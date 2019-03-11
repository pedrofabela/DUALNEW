package action;

//BEANS
import beans.AlumnosBean;
import beans.DatosBean;
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
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

import org.apache.struts2.interceptor.SessionAware;

import utilidades.Constantes;

public class RegistraAlumnosAction extends ActionSupport implements SessionAware {

    //Uusario
    private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;
    private String tabSelect;

    //LISTAS PERSISTENTES DEL MENU
    public List<DatosBean> ListaMunicipios = new ArrayList<DatosBean>();

    private List<DatosBean> ListaCarreras = new ArrayList<>();

    private List<DatosBean> ListaTipoAlumno = new ArrayList<>();

    private List<DatosBean> VerificaAlumno = new ArrayList<>();

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

    AlumnosBean al = new AlumnosBean();
    DatosBean obj = new DatosBean();

    private boolean BANCURPENCONTRADA = false;
    private boolean BanExisteAlum = false;
    private boolean BanExisteAlumStatusInhabil = false;
    private boolean BanAlumReg = false;
    private boolean BanAlumHabilitado = false;
    private boolean BanAlumnoEgresado = false;

    public String FormAlumno() {

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

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String consultacurp() {
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
            limpiar();

            Constantes.enviaMensajeConsola("longitud de curp: " + al.getCURPA().length());
            al.getCURPA().toUpperCase();

            if (al.getCURPA().length() == 18) {
                banlong = true;
            } else {
                banlong = false;

                addFieldError("ErrorValCurp", "LA CURP DEBE CONTENER 18 CARACTERES");

            }

            if (banlong) {

                ConsultasBusiness con = new ConsultasBusiness();

                obj.setCURP(al.getCURPA());

                VerificaAlumno = con.ConsultaAlumnos2(obj);

                if (VerificaAlumno.size() > 0) {

                    String VerificaStatus = con.ConsultaStatus(obj);

                    Constantes.enviaMensajeConsola(VerificaStatus);

                    if (VerificaStatus.equals("1")) {

                        BanExisteAlum = true;

                    } else if (VerificaStatus.equals("10")) {
                        BanAlumnoEgresado = true;
                    } else {
                        Constantes.enviaMensajeConsola("entro aqui");
                        BanExisteAlumStatusInhabil = true;
                    }

                    return "input";

                } else {

                    System.out.println ("MICURP ES: " + al.getCURPA());
                    service = new ConsultaDatosRenapo();
                    port = service.getConsultaRenapoPorCurpPort();
                    personas = port.consultaPorCurp(al.getCURPA());
                    //port.consultaPorCurp(micurp)
                    
                    Constantes.enviaMensajeConsola("resultado de renapo"+personas.getResultado());

                    if (personas.getResultado().equals("EXITO")) {

                        BANCURPENCONTRADA = true;

                        al.setNOMBRE(personas.getNombre());
                        al.setAPELLIDOP(personas.getApellidoPaterno());
                        al.setAPELLIDOM(personas.getApellidoMaterno());
                        al.setFECNAC(personas.getFechaNacimientoAxu());
                        al.setCURP(personas.getCurp());

                        if (personas.getSexo().equals("H")) {
                            al.setSEXO("HOMBRE");
                        } else {
                            al.setSEXO("MUJER");
                        }

                        obj.setCCT(usuariocons.getUSUARIO());

                        al.setCCT(usuariocons.getUSUARIO());

                        ListaMunicipios = con.listaMunicipios();
                        ListaCarreras = con.ConsultaCarreraExistente(obj);
                        ListaTipoAlumno = con.ConsultaTipoAlumno();

                        al.setCURPA("");

                    } else {

                        BANCURPENCONTRADA = false;
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

    public String HabilitarAlumno() {
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

            boolean curp = false;
            al.getCURPA();

            if (al.getCURPA().length() > 0) {
                curp = true;
            } else {
                addFieldError("ErrorCurp", "Agregar el domicilio del alumno");
                curp = false;
            }

            if (curp) {

                ConsultasBusiness con = new ConsultasBusiness();

                al.setSTATUS("1");
                al.setAVANCE("50");
                al.setBECA("no");
                al.setTIPO_ALUM("2");
                al.setFECHA_REINGRESO(fecha());

                con.HabilitarAlumno(al);

                BanAlumHabilitado = true;

            } else {

                return "ERROR";

            }

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String GuardaAlum() {
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

            boolean domicilio = false;
            boolean colonia = false;
            boolean cp = false;
            boolean mun = false;
            boolean tel = false;
            boolean email = false;
            boolean matricula = false;
            boolean carrera = false;
            boolean grado = false;
            boolean promedio = false;
            boolean situacionaca = false;
            boolean tipoalu = false;
            boolean fechaingresodual = false;

            if (al.getDOMICILIO().length() > 0) {
                domicilio = true;
            } else {
                addFieldError("ErrorDomicilio", "Agregar el domicilio del alumno");
                domicilio = false;
            }
            if (al.getCOLONIA().length() > 0) {
                colonia = true;
            } else {
                addFieldError("ErrorColonia", "Agregar la colonia del alumno");
                colonia = false;
            }
            if (al.getCP().length() > 0) {
                cp = true;
            } else {
                addFieldError("ErrorCP", "Agregar el codigo postal del alumno");
                cp = false;
            }
            if (al.getCVE_MUN().length() > 0) {
                mun = true;
            } else {
                addFieldError("ErrorMunicipio", "Agregar el municipio del alumno");
                mun = false;
            }
            if (al.getTELEFONO().length() > 0) {
                tel = true;
            } else {
                addFieldError("ErrorTel", "Agregar el Teléfono del alumno");
                tel = false;
            }
            if (al.getCORREO().length() > 0) {
                email = true;
            } else {
                addFieldError("ErrorCorreo", "Agregar el correo del alumno");
                email = false;
            }
            if (al.getMATRICULA().length() > 0) {
                matricula = true;
            } else {
                addFieldError("ErrorMatricula", "Agregar la matricula de alumno");
                matricula = false;
            }
            if (al.getCLAVECARRERA().length() > 0) {
                carrera = true;
            } else {
                addFieldError("ErrorCarrera", "Agregar la carrera del alumno");
                carrera = false;
            }
            if (al.getGRADO_CURSA().length() > 0) {
                grado = true;
            } else {
                addFieldError("ErrorGrado", "Agregar el grado que cursa el alumno");
                grado = false;
            }
            if (al.getPROMEDIOGRAL().length() > 0) {
                promedio = true;
            } else {
                addFieldError("ErrorPromedio", "Agregar el promedio del alumno");
                promedio = false;
            }
            if (al.getSITUACIONACA().length() > 0) {
                situacionaca = true;
            } else {
                addFieldError("ErrorSituacioAca", "Agregar la situacion academica del alumno");
                situacionaca = false;
            }
            if (al.getTIPO_ALUM().length() > 0) {
                tipoalu = true;
            } else {
                addFieldError("ErrorTipoAlu", "Seleccionar el tipo de alumno ");
                tipoalu = false;
            }
            if (al.getFECHA_INGRESO_DUAL().length() > 0) {
                fechaingresodual = true;
            } else {
                addFieldError("ErrorFID", "Debe agregar la fecha de ingreso a dual ");
                fechaingresodual = false;
            }

            if (domicilio && colonia && cp && mun && tel && email && matricula && carrera && grado && promedio && situacionaca && tipoalu && fechaingresodual) {

                ConsultasBusiness con = new ConsultasBusiness();

                al.setSTATUS("1");
                al.setAVANCE("50");
                al.setBECA("no");

                con.GuardaAlumnos(al);

                BanAlumReg = true;

            } else {

                return "ERROR";

            }

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public static boolean checkEmail(String email) {
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
        // Asociar el string al patron
        Matcher m = p.matcher(email);
        // Comprobar si encaja
        return m.matches();
    }

    public void limpiar() {
        al.setCURP("");
        al.setNOMBRE("");
        al.setAPELLIDOP("");
        al.setAPELLIDOM("");
        al.setSEXO("");
        al.setFECNAC("");
        al.setDOMICILIO("");
        al.setCOLONIA("");
        al.setCP("");
        al.setCVE_MUN("");
        al.setTELEFONO("");
        al.setCORREO("");
        al.setMATRICULA("");
        al.setCLAVECARRERA("");
        al.setGRADO_CURSA("");
        al.setPROMEDIOGRAL("");
        al.setSITUACIONACA("");
        al.setTIPO_ALUM("");
    }

    public String fecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
        return formateador.format(ahora);
    }

    public AlumnosBean getAl() {
        return al;
    }

    public void setAl(AlumnosBean al) {
        this.al = al;
    }

    public DatosBean getObj() {
        return obj;
    }

    public void setObj(DatosBean obj) {
        this.obj = obj;
    }

    public boolean isBANCURPENCONTRADA() {
        return BANCURPENCONTRADA;
    }

    public void setBANCURPENCONTRADA(boolean BANCURPENCONTRADA) {
        this.BANCURPENCONTRADA = BANCURPENCONTRADA;
    }

    public boolean isBanExisteAlum() {
        return BanExisteAlum;
    }

    public void setBanExisteAlum(boolean BanExisteAlum) {
        this.BanExisteAlum = BanExisteAlum;
    }

    public boolean isBanExisteAlumStatusInhabil() {
        return BanExisteAlumStatusInhabil;
    }

    public void setBanExisteAlumStatusInhabil(boolean BanExisteAlumStatusInhabil) {
        this.BanExisteAlumStatusInhabil = BanExisteAlumStatusInhabil;
    }

    public boolean isBanAlumReg() {
        return BanAlumReg;
    }

    public void setBanAlumReg(boolean BanAlumReg) {
        this.BanAlumReg = BanAlumReg;
    }

    public boolean isBanAlumHabilitado() {
        return BanAlumHabilitado;
    }

    public void setBanAlumHabilitado(boolean BanAlumHabilitado) {
        this.BanAlumHabilitado = BanAlumHabilitado;
    }

    public boolean isBanAlumnoEgresado() {
        return BanAlumnoEgresado;
    }

    public void setBanAlumnoEgresado(boolean BanAlumnoEgresado) {
        this.BanAlumnoEgresado = BanAlumnoEgresado;
    }

    public List<DatosBean> getListaMunicipios() {
        return ListaMunicipios;
    }

    public void setListaMunicipios(List<DatosBean> ListaMunicipios) {
        this.ListaMunicipios = ListaMunicipios;
    }

    public usuarioBean getUsuariocons() {
        return usuariocons;
    }

    public void setUsuariocons(usuarioBean usuariocons) {
        this.usuariocons = usuariocons;
    }

    public List<DatosBean> getListaCarreras() {
        return ListaCarreras;
    }

    public void setListaCarreras(List<DatosBean> ListaCarreras) {
        this.ListaCarreras = ListaCarreras;
    }

    public List<DatosBean> getListaTipoAlumno() {
        return ListaTipoAlumno;
    }

    public void setListaTipoAlumno(List<DatosBean> ListaTipoAlumno) {
        this.ListaTipoAlumno = ListaTipoAlumno;
    }

    public List<DatosBean> getVerificaAlumno() {
        return VerificaAlumno;
    }

    public void setVerificaAlumno(List<DatosBean> VerificaAlumno) {
        this.VerificaAlumno = VerificaAlumno;
    }

}
