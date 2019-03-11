package action;

//BEANS
import beans.AdminCatBean;
import beans.DatosBean;
import beans.DatosErroresBean;
import beans.VerificaArchivoBean;
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import business.ConsultasBusiness;
import mx.gob.edomex.dgsei.ws.ConsultaRenapoPorCurp;
import mx.gob.edomex.dgsei.ws.ConsultaDatosRenapo;
import mx.gob.edomex.dgsei.ws.PersonasDTO;
//BUSINESS

//SESION
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.struts2.interceptor.SessionAware;

import utilidades.Constantes;

public class AdminCatalogosAction extends ActionSupport implements SessionAware {

    //Uusario
    private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;
    private String tabSelect;

    //LISTAS PERSISTENTES DEL MENU
    public List<moduloBean> modulosAUX = new ArrayList<moduloBean>();
    public List<moduloAuxBean> modulosAUXP = new ArrayList<moduloAuxBean>();

    public List<DatosBean> listaCCT = new ArrayList<>();
    private ArrayList<DatosBean> VerificaCarrera = new ArrayList<>();
    private ArrayList<DatosBean> ObtenerCarreraCCT = new ArrayList<>();
    public List<DatosBean> ListaCarreras = new ArrayList<DatosBean>();
    private List<AdminCatBean> ListaResponsables = new ArrayList<>();
    private List<AdminCatBean> ListaAsesores = new ArrayList<>();
    private List<AdminCatBean> VerificaResponsable = new ArrayList<>();
    private List<AdminCatBean> VerificaAsesor = new ArrayList<>();
    private List<AdminCatBean> VerificaAsesorDeshabilitado = new ArrayList<>();

    //SESSIN USUARIO	
    // private Map session  = ActionContext.getContext().getSession();
    private String nivelUsuario;

    //Exception
    private String TipoError;
    private String TipoException;

    //******************** PARA OBJETO DE NAVEGACIoN ***********************************************
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public Map getSession() {
        return session;
    }
    //******************** TERMINA OBJETO DE NAVEGACIoN **********************************************

    //instancias para web service//
    ConsultaDatosRenapo service = null;
    ConsultaRenapoPorCurp port;
    PersonasDTO personas;

    //conexiones................................PARA LAS LISTAS
    Statement objConexion;
    PreparedStatement objPreConexion;
    Connection conecta;

    DatosBean datos = new DatosBean();

    AdminCatBean ad = new AdminCatBean();
    //carreras
    private boolean BanCarreraAgregada;
    private boolean BanCarreraEliminada;
    private boolean BanCarreraExistente;
    //responsables
    private boolean banCurpValida;
    private boolean BanResponsableExiste;
    private boolean BANCURPRENCONTRADA;
    private boolean BanResponsableRegistrado;
    private boolean BanResponsableEliminado;
    private boolean BanResponsableActualizado;
    //asesores
    private boolean banCurpAValida;
    private boolean BanAsesorExiste;
    private boolean BANCURPAENCONTRADA;
    private boolean BanAsesorRegistrado;
    private boolean BanAsesorEliminado;
    private boolean BanExisteAsesorStatusInhabil;
    private boolean BanAsesorHABILITADO;

    public String AbreAdminCat() {

        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            ConsultasBusiness con = new ConsultasBusiness();

            listaCCT = con.ConsultaCCT(usuariocons.getUSUARIO());
            ListaCarreras = con.ConsultaCarreras();
            datos.setCCT(usuariocons.getUSUARIO());
            ObtenerCarreraCCT = (ArrayList<DatosBean>) con.ConsultaCarreraExistente(datos);

            Iterator LCCT = listaCCT.iterator();
            DatosBean obj;

            while (LCCT.hasNext()) {
                obj = (DatosBean) LCCT.next();

                datos.setCCT(obj.getCCT());
                datos.setNOMESC(obj.getNOMESC());
                datos.setCALLE(obj.getCALLE() + " " + obj.getNUM_ESC());
                datos.setCOLONIA(obj.getCOLONIA());
                datos.setLOCALIDAD(obj.getLOCALIDAD());
                datos.setCP(obj.getCP());
                datos.setMUNICIPIOCCT(obj.getMUNICIPIOCCT());
            }

            ad.setCCT(usuariocons.getUSUARIO());

            ListaResponsables = con.ConsultaResponsableAdmin(ad);

            ListaAsesores = con.ConsultaAsesorAdmin(ad);

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String GuardaCarrera() {

        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            ConsultasBusiness con = new ConsultasBusiness();

            Constantes.enviaMensajeConsola("clave carrera: " + datos.getCLAVECARRERA());
            Constantes.enviaMensajeConsola("nom carrera: " + datos.getNOMBRE_CARRERA());

            VerificaCarrera = (ArrayList<DatosBean>) con.ConsultaCarrera(datos);
            Constantes.enviaMensajeConsola("tamano de verifica Carrera: " + VerificaCarrera.size());

            if (VerificaCarrera.size() > 0) {

                BanCarreraExistente = true;
                addFieldError("CarreraExiste", "La carrera que intenta Registrar ya existe");

            } else {

                datos.setSTATUS("ACTIVO");

                con.GuardaCarrera(datos);
                datos.setDESERROR("CARRERA REGISTRADA CORRECTAMENTE");

                BanCarreraAgregada = true;
                addFieldError("CarreraAgregada", "La carrera se registro correctamente");

                datos.setSTATUS("si");
                con.ActualizaDocCar(datos);

                //aqui va metodo guardar datos.
                ObtenerCarreraCCT = (ArrayList<DatosBean>) con.ConsultaCarreraExistente(datos);

            }

            return "SUCCESS";
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String EliminarCarrera() {

        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            ConsultasBusiness con = new ConsultasBusiness();
            Constantes.enviaMensajeConsola("clave carrera: " + datos.getCLAVECARRERA());
            Constantes.enviaMensajeConsola("nom carrera: " + datos.getNOMBRE_CARRERA());

            datos.setSTATUS("ACTIVO");
            con.EliminarCar(datos);
            BanCarreraEliminada = true;
            addFieldError("CarreraEliminada", "La carrera se eliminó correctamente");

            ObtenerCarreraCCT = (ArrayList<DatosBean>) con.ConsultaCarreraExistente(datos);

            if (ObtenerCarreraCCT.size() == 0) {

                datos.setSTATUS("no");
                con.ActualizaDocCar(datos);
            }

            return "SUCCESS";
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    //*************************************************responsables*********************************************************
    public String ConsultaCurpR() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            boolean banlong = false;
            //limpiar();

            Constantes.enviaMensajeConsola("longitud de curp: " + ad.getCURP_RESPONSABLEAUX().length());
            ad.getCURP_RESPONSABLEAUX().toUpperCase();

            if (ad.getCURP_RESPONSABLEAUX().length() == 18) {
                banlong = true;
            } else {
                banlong = false;

                addFieldError("ErrorValCurp", "LA CURP DEBE CONTENER 18 CARACTERES");

            }

            if (banlong) {

                ConsultasBusiness con = new ConsultasBusiness();

                datos.setCCT(usuariocons.getUSUARIO());
                datos.setCURP_RESPONSABLE(ad.getCURP_RESPONSABLEAUX().toUpperCase());

                VerificaResponsable = con.ConsultaResponsable(datos);

                Constantes.enviaMensajeConsola("verifica responsable: " + VerificaResponsable.size());

                if (VerificaResponsable.size() > 0) {
                    BanResponsableExiste = true;
                    return "input";

                } else {

                    Constantes.enviaMensajeConsola("MICURP ES: " + ad.getCURP_RESPONSABLEAUX().toUpperCase());
                    service = new ConsultaDatosRenapo();
                    port = service.getConsultaRenapoPorCurpPort();
                    personas = port.consultaPorCurp(ad.getCURP_RESPONSABLEAUX().toUpperCase());
                    //port.consultaPorCurp(micurp)

                    if (personas.getResultado().equals("EXITO")) {

                        BANCURPRENCONTRADA = true;
                        banCurpValida = true;
                        ad.setCURP_RESPONSABLE(personas.getCurp());
                        ad.setNOMBRER(personas.getNombre());
                        ad.setAPELLIDOPR(personas.getApellidoPaterno());
                        ad.setAPELLIDOMR(personas.getApellidoMaterno());
                        ad.setCURP_RESPONSABLEAUX("");

                    } else {

                        BANCURPRENCONTRADA = false;
                        System.out.println("Resultado            : " + personas.getResultado());
                        System.out.println("Codigo de error      : " + personas.getCodigoError());
                        System.out.println("Descripcion Error    : " + personas.getDescripcionError());

                        addFieldError("ErrorValCurp", personas.getDescripcionError());
                    }
                }
            }
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String GuardarResponsableN() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            boolean cargo = false;
            boolean tel = false;
            boolean email = false;

            ConsultasBusiness con = new ConsultasBusiness();

            if (ad.getCARGO_RESPONSABLE().length() > 0) {
                cargo = true;
            } else {
                cargo = false;
                addFieldError("ErrorCargoR", "Debe Agregar el cargo del responsable");

            }
            if (ad.getTELEFONO_RESPONSABLE().length() > 0) {
                tel = true;
            } else {
                tel = false;
                addFieldError("ErrorTelR", "Debe Agregar el Telefono del responsable");
            }
            if (ad.getEMAIL_RESPONSABLE().length() > 0) {
                email = true;
            } else {
                email = false;
                addFieldError("ErrorCorreoR", "Debe Agregar el correo del responsable");
            }

            if (cargo && tel && email) {

                ad.setCCT(usuariocons.getUSUARIO());

                con.GuardaResponsableN(ad);
                BanResponsableRegistrado = true;
                banCurpValida = false;

                ListaResponsables = con.ConsultaResponsableAdmin(ad);

            }

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String ActualizaResp() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            ConsultasBusiness con = new ConsultasBusiness();

            ad.setCCT(usuariocons.getUSUARIO());

            con.ActualizaResponsable(ad);
            BanResponsableActualizado = true;
            banCurpValida = false;

            ListaResponsables = con.ConsultaResponsableAdmin(ad);

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String EliminarResp() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            ConsultasBusiness con = new ConsultasBusiness();

            ad.setCCT(usuariocons.getUSUARIO());

            con.EliminarResponsable(ad);
            BanResponsableEliminado = true;

            ListaResponsables = con.ConsultaResponsableAdmin(ad);

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    //*************************************************responsables*********************************************************
    public String ConsultaCurpA() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            boolean banlong = false;
            //limpiar();

            Constantes.enviaMensajeConsola("longitud de curp: " + ad.getCURP_ASESORIAUX().length());
            ad.getCURP_ASESORIAUX().toUpperCase();

            if (ad.getCURP_ASESORIAUX().length() == 18) {
                banlong = true;
            } else {
                banlong = false;

                addFieldError("ErrorValCurpA", "LA CURP DEBE CONTENER 18 CARACTERES");

            }

            if (banlong) {

                Constantes.enviaMensajeConsola("MICURP ES: " + ad.getCURP_ASESORIAUX().toUpperCase());
                service = new ConsultaDatosRenapo();
                port = service.getConsultaRenapoPorCurpPort();
                personas = port.consultaPorCurp(ad.getCURP_ASESORIAUX().toUpperCase());
                //port.consultaPorCurp(micurp)

                if (personas.getResultado().equals("EXITO")) {

                    BANCURPAENCONTRADA = true;
                    banCurpAValida = true;
                    ad.setCURP_ASESORI(personas.getCurp());
                    ad.setNOMBREAI(personas.getNombre());
                    ad.setAPELLIDOPAI(personas.getApellidoPaterno());
                    ad.setAPELLIDOMAI(personas.getApellidoMaterno());
                    ad.setCURP_ASESORIAUX("");

                } else {

                    BANCURPAENCONTRADA = false;
                    System.out.println("Resultado            : " + personas.getResultado());
                    System.out.println("Codigo de error      : " + personas.getCodigoError());
                    System.out.println("Descripcion Error    : " + personas.getDescripcionError());

                    addFieldError("ErrorValCurpA", personas.getDescripcionError());
                }

            }
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String GuardarAsesorN() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            boolean carrera = false;

            ConsultasBusiness con = new ConsultasBusiness();

            if (ad.getCVE_CAR_ASE().length() > 0) {
                carrera = true;
            } else {
                carrera = false;
                addFieldError("ErrorCarrera", "Debe selecciona una carrera para el asesor");

            }
            if (carrera) {

                datos.setCCT(usuariocons.getUSUARIO());
                datos.setCURP_ASESORI(ad.getCURP_ASESORI().toUpperCase());
                datos.setCVE_CAR_RES(ad.getCVE_CAR_ASE());

                VerificaAsesor = con.ConsultaAsesorIAd(datos);

                Constantes.enviaMensajeConsola("verifica asesor: " + VerificaAsesor.size());

                if (VerificaAsesor.size() > 0) {
                    BanAsesorExiste = true;
                    banCurpAValida = false;
                    return "input";

                } else {

                    VerificaAsesorDeshabilitado = con.ConsultaAsesorDes(datos);

                    if (VerificaAsesorDeshabilitado.size() > 0) {
                        
                       
                        
                        Iterator VAD=VerificaAsesorDeshabilitado.iterator();
                        DatosBean objg;
                        
                        while (VAD.hasNext()) {
                            objg = (DatosBean) VAD.next();                          
                            ad.setID_CAT_ASEA(objg.getID_CAT_ASE());                           
                        }
                        
                         Constantes.enviaMensajeConsola("entro a id asesor"+ ad.getID_CAT_ASEA());

                        BanExisteAsesorStatusInhabil = true;
                        banCurpAValida = false;

                    } else {

                        ad.setCCT_ASE(usuariocons.getUSUARIO());

                        con.GuardaAsesorN(ad);
                        BanAsesorRegistrado = true;
                        banCurpAValida = false;

                        ad.setCCT(usuariocons.getUSUARIO());
                        ListaAsesores = con.ConsultaAsesorAdmin(ad);
                    }

                }

            }
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String ActualizaAse() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            ConsultasBusiness con = new ConsultasBusiness();

           

            con.habilitarAsesor(ad);
            BanAsesorHABILITADO = true;
            banCurpAValida = false;

            ad.setCCT(usuariocons.getUSUARIO());
            ListaAsesores = con.ConsultaAsesorAdmin(ad);

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String EliminarAse() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {
            ConsultasBusiness con = new ConsultasBusiness();

            ad.setCCT_ASEA(usuariocons.getUSUARIO());

            Constantes.enviaMensajeConsola("id ase: " + ad.getID_CAT_ASE());

            con.EliminarAsesor(ad);
            BanAsesorEliminado = true;

            ad.setCCT(usuariocons.getUSUARIO());
            ListaAsesores = con.ConsultaAsesorAdmin(ad);

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

//Cierra método validarFOLIO
    private void cierraConexiones() {
        try {
            objConexion.close();
            //objPreConexion.close();
            conecta.close();
            System.out.println("******************************Conexion cerrada************************************ ");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error al cerrar conexiones: " + e);

        }
    }

    public usuarioBean getUsuariocons() {
        return usuariocons;
    }

    public void setUsuariocons(usuarioBean usuariocons) {
        this.usuariocons = usuariocons;
    }

    public String getCveusuario() {
        return cveusuario;
    }

    public void setCveusuario(String cveusuario) {
        this.cveusuario = cveusuario;
    }

    public String getPasusuario() {
        return pasusuario;
    }

    public void setPasusuario(String pasusuario) {
        this.pasusuario = pasusuario;
    }

    public String getNomModulo() {
        return nomModulo;
    }

    public void setNomModulo(String nomModulo) {
        this.nomModulo = nomModulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getTipoError() {
        return TipoError;
    }

    public void setTipoError(String tipoError) {
        TipoError = tipoError;
    }

    public String getTipoException() {
        return TipoException;
    }

    public void setTipoException(String tipoException) {
        TipoException = tipoException;
    }

    public List<moduloBean> getModulosAUX() {
        return modulosAUX;
    }

    public void setModulosAUX(List<moduloBean> modulosAUX) {
        this.modulosAUX = modulosAUX;
    }

    public List<moduloAuxBean> getModulosAUXP() {
        return modulosAUXP;
    }

    public void setModulosAUXP(List<moduloAuxBean> modulosAUXP) {
        this.modulosAUXP = modulosAUXP;
    }

    public String getTabSelect() {
        return tabSelect;
    }

    public void setTabSelect(String tabSelect) {
        this.tabSelect = tabSelect;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public DatosBean getDatos() {
        return datos;
    }

    public void setDatos(DatosBean datos) {
        this.datos = datos;
    }

    public AdminCatBean getAd() {
        return ad;
    }

    public void setAd(AdminCatBean ad) {
        this.ad = ad;
    }

    public boolean isBanCarreraAgregada() {
        return BanCarreraAgregada;
    }

    public void setBanCarreraAgregada(boolean BanCarreraAgregada) {
        this.BanCarreraAgregada = BanCarreraAgregada;
    }

    public boolean isBanCarreraEliminada() {
        return BanCarreraEliminada;
    }

    public void setBanCarreraEliminada(boolean BanCarreraEliminada) {
        this.BanCarreraEliminada = BanCarreraEliminada;
    }

    public List<DatosBean> getListaCCT() {
        return listaCCT;
    }

    public void setListaCCT(List<DatosBean> listaCCT) {
        this.listaCCT = listaCCT;
    }

    public ArrayList<DatosBean> getVerificaCarrera() {
        return VerificaCarrera;
    }

    public void setVerificaCarrera(ArrayList<DatosBean> VerificaCarrera) {
        this.VerificaCarrera = VerificaCarrera;
    }

    public ArrayList<DatosBean> getObtenerCarreraCCT() {
        return ObtenerCarreraCCT;
    }

    public void setObtenerCarreraCCT(ArrayList<DatosBean> ObtenerCarreraCCT) {
        this.ObtenerCarreraCCT = ObtenerCarreraCCT;
    }

    public List<DatosBean> getListaCarreras() {
        return ListaCarreras;
    }

    public void setListaCarreras(List<DatosBean> ListaCarreras) {
        this.ListaCarreras = ListaCarreras;
    }

    public List<AdminCatBean> getListaResponsables() {
        return ListaResponsables;
    }

    public void setListaResponsables(List<AdminCatBean> ListaResponsables) {
        this.ListaResponsables = ListaResponsables;
    }

    public List<AdminCatBean> getListaAsesores() {
        return ListaAsesores;
    }

    public void setListaAsesores(List<AdminCatBean> ListaAsesores) {
        this.ListaAsesores = ListaAsesores;
    }

    public List<AdminCatBean> getVerificaResponsable() {
        return VerificaResponsable;
    }

    public void setVerificaResponsable(List<AdminCatBean> VerificaResponsable) {
        this.VerificaResponsable = VerificaResponsable;
    }

    public List<AdminCatBean> getVerificaAsesor() {
        return VerificaAsesor;
    }

    public void setVerificaAsesor(List<AdminCatBean> VerificaAsesor) {
        this.VerificaAsesor = VerificaAsesor;
    }

    public List<AdminCatBean> getVerificaAsesorDeshabilitado() {
        return VerificaAsesorDeshabilitado;
    }

    public void setVerificaAsesorDeshabilitado(List<AdminCatBean> VerificaAsesorDeshabilitado) {
        this.VerificaAsesorDeshabilitado = VerificaAsesorDeshabilitado;
    }

    public boolean isBanCarreraExistente() {
        return BanCarreraExistente;
    }

    public void setBanCarreraExistente(boolean BanCarreraExistente) {
        this.BanCarreraExistente = BanCarreraExistente;
    }

    public boolean isBanCurpValida() {
        return banCurpValida;
    }

    public void setBanCurpValida(boolean banCurpValida) {
        this.banCurpValida = banCurpValida;
    }

    public boolean isBanResponsableExiste() {
        return BanResponsableExiste;
    }

    public void setBanResponsableExiste(boolean BanResponsableExiste) {
        this.BanResponsableExiste = BanResponsableExiste;
    }

    public boolean isBANCURPRENCONTRADA() {
        return BANCURPRENCONTRADA;
    }

    public void setBANCURPRENCONTRADA(boolean BANCURPRENCONTRADA) {
        this.BANCURPRENCONTRADA = BANCURPRENCONTRADA;
    }

    public boolean isBanResponsableRegistrado() {
        return BanResponsableRegistrado;
    }

    public void setBanResponsableRegistrado(boolean BanResponsableRegistrado) {
        this.BanResponsableRegistrado = BanResponsableRegistrado;
    }

    public boolean isBanResponsableEliminado() {
        return BanResponsableEliminado;
    }

    public void setBanResponsableEliminado(boolean BanResponsableEliminado) {
        this.BanResponsableEliminado = BanResponsableEliminado;
    }

    public boolean isBanResponsableActualizado() {
        return BanResponsableActualizado;
    }

    public void setBanResponsableActualizado(boolean BanResponsableActualizado) {
        this.BanResponsableActualizado = BanResponsableActualizado;
    }
    
    

    public boolean isBanCurpAValida() {
        return banCurpAValida;
    }

    public void setBanCurpAValida(boolean banCurpAValida) {
        this.banCurpAValida = banCurpAValida;
    }

    public boolean isBanAsesorExiste() {
        return BanAsesorExiste;
    }

    public void setBanAsesorExiste(boolean BanAsesorExiste) {
        this.BanAsesorExiste = BanAsesorExiste;
    }

    public boolean isBANCURPAENCONTRADA() {
        return BANCURPAENCONTRADA;
    }

    public void setBANCURPAENCONTRADA(boolean BANCURPAENCONTRADA) {
        this.BANCURPAENCONTRADA = BANCURPAENCONTRADA;
    }

    public boolean isBanAsesorRegistrado() {
        return BanAsesorRegistrado;
    }

    public void setBanAsesorRegistrado(boolean BanAsesorRegistrado) {
        this.BanAsesorRegistrado = BanAsesorRegistrado;
    }

    public boolean isBanAsesorEliminado() {
        return BanAsesorEliminado;
    }

    public void setBanAsesorEliminado(boolean BanAsesorEliminado) {
        this.BanAsesorEliminado = BanAsesorEliminado;
    }

    public boolean isBanExisteAsesorStatusInhabil() {
        return BanExisteAsesorStatusInhabil;
    }

    public void setBanExisteAsesorStatusInhabil(boolean BanExisteAsesorStatusInhabil) {
        this.BanExisteAsesorStatusInhabil = BanExisteAsesorStatusInhabil;
    }

    public boolean isBanAsesorHABILITADO() {
        return BanAsesorHABILITADO;
    }

    public void setBanAsesorHABILITADO(boolean BanAsesorHABILITADO) {
        this.BanAsesorHABILITADO = BanAsesorHABILITADO;
    }
    
    
    
    

}
