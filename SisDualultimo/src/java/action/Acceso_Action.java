package action;

//BEANS
import beans.DatosBean;
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import beans.VerificaArchivoBean;
import business.AccesoBusiness;
import business.ConsultasBusiness;
//BUSINESS

//SESION
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

import java.text.SimpleDateFormat;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import utilidades.Constantes;

public class Acceso_Action extends ActionSupport implements SessionAware {

    //Uusario
    private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;

    private boolean BanArchivoCarrera = false;
    private boolean BanArchivoResponsables = false;
    private boolean BanArchivoAlumnos = false;
    private boolean BanArcchivoFaltante = false;
    private boolean BanDatosCorrectos = false;

    private DatosBean datos = new DatosBean();

    //LISTAS PERSISTENTES DEL MENU
    public List<moduloBean> modulosAUX = new ArrayList<moduloBean>();
    public List<moduloAuxBean> modulosAUXP = new ArrayList<moduloAuxBean>();

    public List<DatosBean> listaCCT = new ArrayList<>();
    private List<VerificaArchivoBean> VerificaArchivos = new ArrayList<>();
    public List<DatosBean> ListaMunicipios = new ArrayList<DatosBean>();
    private List<DatosBean> ListaTipoAlumno = new ArrayList<>();
    public ArrayList<DatosBean> ListaAlumnos = new ArrayList<DatosBean>();
    public ArrayList<DatosBean> ListaAlumnosBeca = new ArrayList<DatosBean>();
    public List<DatosBean> ListaCarreras = new ArrayList<DatosBean>();
    private ArrayList<DatosBean> ObtenerCarreraCCT = new ArrayList<>();

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
    public String MuestraMenuPrincipalUsuario() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {

            //Se crea un nuevo objeto de acceco a Business
            AccesoBusiness acceso = new AccesoBusiness();
            ConsultasBusiness con = new ConsultasBusiness();
            usuariocons = acceso.consultaUsuario(cveusuario, pasusuario);

            Constantes.enviaMensajeConsola("esto llega de usuario: " + usuariocons);

            if (usuariocons != null) {

                session.put("usuario", usuariocons);

                //obteniendo el nombre del usuario
                nombreUsuario = usuariocons.getNAMEUSUARIO();

                modulosAUX = (ArrayList<moduloBean>) acceso.consultaModulosPerfilMenu(usuariocons.getPERFIL(), modulo);
                modulosAUXP = (ArrayList<moduloAuxBean>) acceso.consultaModulosHijosPerfilMenu(usuariocons.getPERFIL(), modulo);

                if (usuariocons.getPERFIL() == 2) {

                    Constantes.enviaMensajeConsola("entre a perfil admin");

                    String fecha = fecha();
                    System.out.println(fecha);

                    fecha = fecha.substring(3, 8);

                    datos.setFECHA_INICIO("01/" + fecha);
                    datos.setFECHA_TERMINO(fecha());

                    

                    return "SUCCESS3";

                } else {

                    Constantes.enviaMensajeConsola("REGRESE-----------------------");
                    Iterator iterG = modulosAUX.iterator();
                    while (iterG.hasNext()) {
                        moduloBean Concep = (moduloBean) iterG.next();
                        Constantes.enviaMensajeConsola("VALOR -->" + Concep.getCVE_MODPADRE());
                        Constantes.enviaMensajeConsola("VALOR -->" + Concep.getDESC_MOD());
                        Constantes.enviaMensajeConsola("VALOR -->" + Concep.getACTION());
                        Constantes.enviaMensajeConsola("VALOR -->" + Concep.getIMAGEN());

                    }

                    listaCCT = con.ConsultaCCT(usuariocons.getUSUARIO());
                    ListaCarreras = con.ConsultaCarreras();
                    datos.setCCT(usuariocons.getUSUARIO());
                    ObtenerCarreraCCT = (ArrayList<DatosBean>) con.ConsultaCarreraExistente(datos);

                    if (ObtenerCarreraCCT.size() > 0) {
                        BanDatosCorrectos = true;
                    } else {
                        BanDatosCorrectos = false;
                    }

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

                    VerificaArchivos = con.verificaRegistroArchivo(datos.getCCT());
                    Constantes.enviaMensajeConsola("TAM VERIFICA ARCHIVOS: " + VerificaArchivos.size());
                    if (VerificaArchivos.size() > 0) {

                        Iterator VA = VerificaArchivos.iterator();
                        VerificaArchivoBean valor;

                        while (VA.hasNext()) {
                            valor = (VerificaArchivoBean) VA.next();

                            if (valor.getARCHIVO_CAR().equals("si") && valor.getARCHIVO_RES().equals("si") && valor.getARCHIVO_ASE_INT().equals("si") && valor.getARCHIVO_ALU().equals("si")) {

                                ListaMunicipios = con.listaMunicipios();
                                ListaAlumnos = (ArrayList<DatosBean>) con.listaAlumnos(datos);
                                ListaTipoAlumno=con.ConsultaTipoAlumno();
                                ListaAlumnosBeca = (ArrayList<DatosBean>) con.listaAlumnosBeca(datos);
                                
                                Constantes.enviaMensajeConsola("REGRESO DE CONSULTAS");

                                return "SUCCESS2";

                            } else {
                                Constantes.enviaMensajeConsola("entro al else");
                                BanArcchivoFaltante = true;
                                if (valor.getARCHIVO_CAR().equals("no")) {

                                    valor.setERROR_ARCHIVO_CAR("FALTA CARGAR ARCHIVO DE CARRERAS");
                                } else {
                                    valor.setERROR_ARCHIVO_CAR(" ARCHIVO DE CARRERAS CARGADO");
                                }
                                if (valor.getARCHIVO_RES().equals("no")) {
                                    valor.setERROR_ARCHIVO_RES("FALTA CARGAR ARCHIVO DE RESPONSABLES");
                                } else {
                                    valor.setERROR_ARCHIVO_RES(" ARCHIVO DE RESPONSABLES CARGADO");
                                }

                                if (valor.getARCHIVO_ASE_INT().equals("no")) {
                                    valor.setERROR_ARCHIVO_ASE_INT("FALTA CARGAR ARCHIVO DE ASESORES INTERNOS");
                                } else {
                                    valor.setERROR_ARCHIVO_ASE_INT(" ARCHIVO DE ASESORES INTERNOS CARGADO");
                                }

                                if (valor.getARCHIVO_ALU().equals("no")) {
                                    valor.setERROR_ARCHIVO_ALU("FALTA CARGAR ARCHIVO DE ALUMNOS");

                                } else {
                                    valor.setERROR_ARCHIVO_ALU(" ARCHIVO DE ALUMNOS CARGADO");
                                }

                                return "SUCCESS";
                            }
                        }
                    } else {
                        BanArcchivoFaltante = true;

                        addFieldError("FaltaCar", "FALTA CARGAR ARCHIVO DE CARRERAS");
                        addFieldError("FaltaRes", "FALTA CARGAR ARCHIVO DE RESPONSABLES");
                        addFieldError("FaltaAI", "FALTA CARGAR ARCHIVO DE ASESORES INTERNOS");
                        addFieldError("FaltaAlu", "FALTA CARGAR ARCHIVO DE ALUMNOS");

                        return "SUCCESS";
                    }

                    if (modulosAUX == null) {
                        addActionError("***** Ud. no tiene acceso a este modulo, favor de contacar al administrador del sistema ***** ");
                        return "ERROR";
                    }
                    Constantes.enviaMensajeConsola("voy a successs-----------------------");
                    return "SUCCESS";
                }
            } else {
                addActionError("***** Usuario no valido, favor de verificar ***** ");
                return "ERROR";
            }

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String verMevu() {
        try {

            //...retomando
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    @SkipValidation
    public String cerrar() {
        if (session != null) {
            System.out.println("termino la session");
            session.clear();
        }
        return "SUCCESS";
    }

    //VALIDACIONES
    @Override
    public void validate() {

        try {

            if (cveusuario.length() == 0) {
                addFieldError("ERRORUSU", "Debe Capturar el Nombre de Usuario");
            }

            if (pasusuario.length() == 0) {
                addFieldError("ERRORPASS", "Debe Capturar la Contraseña de Usuario");
            }

        } catch (Exception ex) {
            TipoError = "SESSION";
            TipoException = ex.getMessage();
        }
    }

    public String fecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
        return formateador.format(ahora);
    }

    public usuarioBean getUsuariocons() {
        return usuariocons;
    }

    public void setUsuariocons(usuarioBean usuariocons) {
        this.usuariocons = usuariocons;
    }

    public DatosBean getDatos() {
        return datos;
    }

    public void setDatos(DatosBean datos) {
        this.datos = datos;
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

    public List<DatosBean> getListaCCT() {
        return listaCCT;
    }

    public void setListaCCT(List<DatosBean> listaCCT) {
        this.listaCCT = listaCCT;
    }

    public List<VerificaArchivoBean> getVerificaArchivos() {
        return VerificaArchivos;
    }

    public void setVerificaArchivos(List<VerificaArchivoBean> VerificaArchivos) {
        this.VerificaArchivos = VerificaArchivos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isBanArchivoCarrera() {
        return BanArchivoCarrera;
    }

    public void setBanArchivoCarrera(boolean BanArchivoCarrera) {
        this.BanArchivoCarrera = BanArchivoCarrera;
    }

    public boolean isBanArchivoResponsables() {
        return BanArchivoResponsables;
    }

    public void setBanArchivoResponsables(boolean BanArchivoResponsables) {
        this.BanArchivoResponsables = BanArchivoResponsables;
    }

    public boolean isBanArchivoAlumnos() {
        return BanArchivoAlumnos;
    }

    public void setBanArchivoAlumnos(boolean BanArchivoAlumnos) {
        this.BanArchivoAlumnos = BanArchivoAlumnos;
    }

    public boolean isBanArcchivoFaltante() {
        return BanArcchivoFaltante;
    }

    public void setBanArcchivoFaltante(boolean BanArcchivoFaltante) {
        this.BanArcchivoFaltante = BanArcchivoFaltante;
    }

    public boolean isBanDatosCorrectos() {
        return BanDatosCorrectos;
    }

    public void setBanDatosCorrectos(boolean BanDatosCorrectos) {
        this.BanDatosCorrectos = BanDatosCorrectos;
    }

    //PEDRO
    public List<DatosBean> getListaMunicipios() {
        return ListaMunicipios;
    }

    public void setListaMunicipios(List<DatosBean> ListaMunicipios) {
        this.ListaMunicipios = ListaMunicipios;
    }

    public List<DatosBean> getListaTipoAlumno() {
        return ListaTipoAlumno;
    }

    public void setListaTipoAlumno(List<DatosBean> ListaTipoAlumno) {
        this.ListaTipoAlumno = ListaTipoAlumno;
    }
    
    

    public ArrayList<DatosBean> getListaAlumnos() {
        return ListaAlumnos;
    }

    public void setListaAlumnos(ArrayList<DatosBean> ListaAlumnos) {
        this.ListaAlumnos = ListaAlumnos;
    }

    public ArrayList<DatosBean> getListaAlumnosBeca() {
        return ListaAlumnosBeca;
    }

    public void setListaAlumnosBeca(ArrayList<DatosBean> ListaAlumnosBeca) {
        this.ListaAlumnosBeca = ListaAlumnosBeca;
    }

    public List<DatosBean> getListaCarreras() {
        return ListaCarreras;
    }

    public void setListaCarreras(List<DatosBean> ListaCarreras) {
        this.ListaCarreras = ListaCarreras;
    }

    public ArrayList<DatosBean> getObtenerCarreraCCT() {
        return ObtenerCarreraCCT;
    }

    public void setObtenerCarreraCCT(ArrayList<DatosBean> ObtenerCarreraCCT) {
        this.ObtenerCarreraCCT = ObtenerCarreraCCT;
    }

}
