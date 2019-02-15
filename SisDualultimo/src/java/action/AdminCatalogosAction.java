package action;

//BEANS
import beans.DatosBean;
import beans.DatosErroresBean;
import beans.VerificaArchivoBean;
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import business.ConsultasBusiness;
import mx.gob.edomex.dgsei.ws.ConsultaRenapoPorCurp;
import mx.gob.edomex.dgsei.ws.ConsultaRenapoPorCurp_Service;
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

    private ArrayList<DatosBean> VerificaCarreraRegistradas = new ArrayList<>();
    private ArrayList<DatosErroresBean> ListaDatosResponsablesConError = new ArrayList<>();
    private ArrayList<DatosErroresBean> DatosResponsablesValidadosRenapoConError = new ArrayList<>();
    private ArrayList<DatosBean> VerificaResponsables = new ArrayList<>();
    private ArrayList<DatosErroresBean> ResponsableExistente = new ArrayList<>();
    private ArrayList<DatosErroresBean> RegistrosNuevosR = new ArrayList<>();

    private ArrayList<DatosErroresBean> ListaDatosAsesoresIConError = new ArrayList<>();
    private ArrayList<DatosBean> VerificaAsesores = new ArrayList<>();
    private ArrayList<DatosErroresBean> DatosAsesorValidadosRenapoConError = new ArrayList<>();
    private ArrayList<DatosErroresBean> AsesoresIExistente = new ArrayList<>();
    private ArrayList<DatosErroresBean> RegistrosNuevosAI = new ArrayList<>();

    private ArrayList<DatosBean> VerificaAlumnosRegistradas = new ArrayList<>();
    private ArrayList<DatosErroresBean> ListaDatosAlumnosConError = new ArrayList<>();

    private ArrayList<DatosBean> VerificaAlumnos = new ArrayList<>();
    private ArrayList<DatosErroresBean> AlumnosExistente = new ArrayList<>();
    private ArrayList<DatosErroresBean> RegistrosNuevosA = new ArrayList<>();
    private ArrayList<DatosErroresBean> DatosAlumnosValidadosRenapoConError = new ArrayList<>();
    private ArrayList<DatosBean> ListaCarrera = new ArrayList<>();
    private ArrayList<DatosBean> ListaModalidad = new ArrayList<>();
    private List<VerificaArchivoBean> VerificaArchivos = new ArrayList<>();
    public List<DatosBean> ListaCarreras = new ArrayList<DatosBean>();

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
    ConsultaRenapoPorCurp_Service service = null;
    ConsultaRenapoPorCurp port;
    PersonasDTO personas;

    //conexiones................................PARA LAS LISTAS
    Statement objConexion;
    PreparedStatement objPreConexion;
    Connection conecta;

    DatosBean datos = new DatosBean();

    
    private boolean BanCarreraAgregada;
    private boolean BanCarreraEliminada;
    private boolean BanCarreraExistente;

    

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
            
            ConsultasBusiness con= new ConsultasBusiness();
            
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

    public ArrayList<DatosBean> getVerificaCarreraRegistradas() {
        return VerificaCarreraRegistradas;
    }

    public void setVerificaCarreraRegistradas(ArrayList<DatosBean> VerificaCarreraRegistradas) {
        this.VerificaCarreraRegistradas = VerificaCarreraRegistradas;
    }

    public ArrayList<DatosErroresBean> getListaDatosResponsablesConError() {
        return ListaDatosResponsablesConError;
    }

    public void setListaDatosResponsablesConError(ArrayList<DatosErroresBean> ListaDatosResponsablesConError) {
        this.ListaDatosResponsablesConError = ListaDatosResponsablesConError;
    }

    public ArrayList<DatosBean> getVerificaResponsables() {
        return VerificaResponsables;
    }

    public void setVerificaResponsables(ArrayList<DatosBean> VerificaResponsables) {
        this.VerificaResponsables = VerificaResponsables;
    }

    public ArrayList<DatosErroresBean> getResponsableExistente() {
        return ResponsableExistente;
    }

    public void setResponsableExistente(ArrayList<DatosErroresBean> ResponsableExistente) {
        this.ResponsableExistente = ResponsableExistente;
    }

    public ArrayList<DatosErroresBean> getRegistrosNuevosR() {
        return RegistrosNuevosR;
    }

    public void setRegistrosNuevosR(ArrayList<DatosErroresBean> RegistrosNuevosR) {
        this.RegistrosNuevosR = RegistrosNuevosR;
    }

    public ArrayList<DatosBean> getVerificaAlumnosRegistradas() {
        return VerificaAlumnosRegistradas;
    }

    public void setVerificaAlumnosRegistradas(ArrayList<DatosBean> VerificaAlumnosRegistradas) {
        this.VerificaAlumnosRegistradas = VerificaAlumnosRegistradas;
    }

    public ArrayList<DatosErroresBean> getListaDatosAlumnosConError() {
        return ListaDatosAlumnosConError;
    }

    public void setListaDatosAlumnosConError(ArrayList<DatosErroresBean> ListaDatosAlumnosConError) {
        this.ListaDatosAlumnosConError = ListaDatosAlumnosConError;
    }

    public ArrayList<DatosErroresBean> getDatosResponsablesValidadosRenapoConError() {
        return DatosResponsablesValidadosRenapoConError;
    }

    public void setDatosResponsablesValidadosRenapoConError(ArrayList<DatosErroresBean> DatosResponsablesValidadosRenapoConError) {
        this.DatosResponsablesValidadosRenapoConError = DatosResponsablesValidadosRenapoConError;
    }

    public ArrayList<DatosBean> getVerificaAlumnos() {
        return VerificaAlumnos;
    }

    public void setVerificaAlumnos(ArrayList<DatosBean> VerificaAlumnos) {
        this.VerificaAlumnos = VerificaAlumnos;
    }

    public ArrayList<DatosErroresBean> getAlumnosExistente() {
        return AlumnosExistente;
    }

    public void setAlumnosExistente(ArrayList<DatosErroresBean> AlumnosExistente) {
        this.AlumnosExistente = AlumnosExistente;
    }

    public ArrayList<DatosErroresBean> getRegistrosNuevosA() {
        return RegistrosNuevosA;
    }

    public void setRegistrosNuevosA(ArrayList<DatosErroresBean> RegistrosNuevosA) {
        this.RegistrosNuevosA = RegistrosNuevosA;
    }

    public ArrayList<DatosBean> getListaCarrera() {
        return ListaCarrera;
    }

    public void setListaCarrera(ArrayList<DatosBean> ListaCarrera) {
        this.ListaCarrera = ListaCarrera;
    }

    public ArrayList<DatosBean> getListaModalidad() {
        return ListaModalidad;
    }

    public void setListaModalidad(ArrayList<DatosBean> ListaModalidad) {
        this.ListaModalidad = ListaModalidad;
    }

    public List<VerificaArchivoBean> getVerificaArchivos() {
        return VerificaArchivos;
    }

    public void setVerificaArchivos(List<VerificaArchivoBean> VerificaArchivos) {
        this.VerificaArchivos = VerificaArchivos;
    }

    public List<DatosBean> getListaCarreras() {
        return ListaCarreras;
    }

    public void setListaCarreras(List<DatosBean> ListaCarreras) {
        this.ListaCarreras = ListaCarreras;
    }

    

   

   

    public boolean isBanCarreraExistente() {
        return BanCarreraExistente;
    }

    public void setBanCarreraExistente(boolean BanCarreraExistente) {
        this.BanCarreraExistente = BanCarreraExistente;
    }

   
    

   
    

    

    

    public ArrayList<DatosErroresBean> getListaDatosAsesoresIConError() {
        return ListaDatosAsesoresIConError;
    }

    public void setListaDatosAsesoresIConError(ArrayList<DatosErroresBean> ListaDatosAsesoresIConError) {
        this.ListaDatosAsesoresIConError = ListaDatosAsesoresIConError;
    }

    public ArrayList<DatosBean> getVerificaAsesores() {
        return VerificaAsesores;
    }

    public void setVerificaAsesores(ArrayList<DatosBean> VerificaAsesores) {
        this.VerificaAsesores = VerificaAsesores;
    }

    public ArrayList<DatosErroresBean> getAsesoresIExistente() {
        return AsesoresIExistente;
    }

    public void setAsesoresIExistente(ArrayList<DatosErroresBean> AsesoresIExistente) {
        this.AsesoresIExistente = AsesoresIExistente;
    }

    public ArrayList<DatosErroresBean> getRegistrosNuevosAI() {
        return RegistrosNuevosAI;
    }

    public void setRegistrosNuevosAI(ArrayList<DatosErroresBean> RegistrosNuevosAI) {
        this.RegistrosNuevosAI = RegistrosNuevosAI;
    }

    

    public ArrayList<DatosErroresBean> getDatosAsesorValidadosRenapoConError() {
        return DatosAsesorValidadosRenapoConError;
    }

    public void setDatosAsesorValidadosRenapoConError(ArrayList<DatosErroresBean> DatosAsesorValidadosRenapoConError) {
        this.DatosAsesorValidadosRenapoConError = DatosAsesorValidadosRenapoConError;
    }

    public ArrayList<DatosErroresBean> getDatosAlumnosValidadosRenapoConError() {
        return DatosAlumnosValidadosRenapoConError;
    }

    public void setDatosAlumnosValidadosRenapoConError(ArrayList<DatosErroresBean> DatosAlumnosValidadosRenapoConError) {
        this.DatosAlumnosValidadosRenapoConError = DatosAlumnosValidadosRenapoConError;
    }

    
}
