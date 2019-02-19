package action;

//BEANS
import beans.BecaBean;
import beans.DatosBean;
import beans.DatosErroresBean;
import beans.ProyectoBean;
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import business.AccesoBusiness;
import business.ConsultasBusiness;
import mx.gob.edomex.dgsei.ws.ConsultaRenapoPorCurp;
import mx.gob.edomex.dgsei.ws.ConsultaRenapoPorCurp_Service;
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
import static javax.print.attribute.standard.MediaPrintableArea.MM;
import org.apache.commons.io.FileUtils;

import org.apache.struts2.interceptor.SessionAware;

import utilidades.Constantes;

public class PrincipalAction extends ActionSupport implements SessionAware {

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

    private ArrayList<DatosBean> ListaCarrera = new ArrayList<>();
    public ArrayList<DatosBean> ListaAlumnos = new ArrayList<DatosBean>();
    public ArrayList<DatosBean> ListaAlumnosBeca = new ArrayList<DatosBean>();
    public ArrayList<DatosBean> ListaAlumnos2 = new ArrayList<DatosBean>();
    public List<DatosBean> ListaMunicipios = new ArrayList<DatosBean>();
    private List<DatosBean> ListaTipoAlumno = new ArrayList<>();

    public ArrayList<ProyectoBean> BuscaRFC = new ArrayList<>();
    public ArrayList<ProyectoBean> ListaAsesores = new ArrayList<>();
    public ArrayList<ProyectoBean> VerificaAsesores = new ArrayList<>();

    public ArrayList<ProyectoBean> ListaAsesoresE = new ArrayList<>();
    public ArrayList<ProyectoBean> ListaAsesoresI = new ArrayList<>();
    public ArrayList<ProyectoBean> ListaResponsables = new ArrayList<>();
    public ArrayList<ProyectoBean> ListaEstatus = new ArrayList<>();

    public ArrayList<BecaBean> ListaBecas = new ArrayList<>();

    public ArrayList<BecaBean> ListaTipoBeca = new ArrayList<>();

    //*****************************************LISTAS TABLERO*****************************************************
    public List<DatosBean> ListaAlumnosDashboard = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalEstatus = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalEsuela = new ArrayList<DatosBean>();

    public List<DatosBean> ListaAlumnosDashboardU = new ArrayList<DatosBean>();
    public List<DatosBean> ListaAlumnosDashboardUGeneral = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalEstatusU = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalEsuelaU = new ArrayList<DatosBean>();
    
    
    public List<DatosBean> ListaProyectos = new ArrayList<DatosBean>();
    public List<DatosBean> ListaReingresos = new ArrayList<DatosBean>();
    

    private boolean bantablero = false;

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
    ProyectoBean pro = new ProyectoBean();
    BecaBean be = new BecaBean();

    private boolean banT = false;
    private String archiFileName;
    private File archi;

    public boolean BanBuscaRFC = false;
    public boolean BanAsesoresE = false;
    public boolean BanExisteEmpresa = false;
    public boolean BanEmpresaEncontrada = false;
    public boolean BanEmpresaRegistrada = false;
    public boolean BanAsesorRegistrado = false;
    public boolean BanExisteAsesor = false;
    public boolean BanRegistraProyecto = false;
    public boolean BanProyectoRegistrado = false;
    public boolean BanProyectoActualizado = false;
    public boolean BanErrorSubirArchivo = false;
    public boolean BanBecaRegistrada = false;
    public boolean BanBecaActualizada = false;
    public boolean BanBecaEliminada = false;

    public String RegresarIncio() {

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

    public String actualizarAlumno() {
        //validando session***********************************************************************
        if (session.get("cveUsuario") != null) {
            String sUsu = (String) session.get("cveUsuario");
        } else {
            addActionError("**** La sesi髇 ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }
        if (session.containsKey("usuario")) {
            usuariocons = (usuarioBean) session.get("usuario");
        } else {
            addActionError("**** La sesi髇 ha expirado *** favor de iniciar una nueva sesion *** ");
            return "SESSION";
        }

        try {

            ConsultasBusiness con = new ConsultasBusiness();

            Constantes.enviaMensajeConsola("fecha recibe: " + datos.getFECHA_INGRESO_DUAL());

            con.actualizarAlumno(datos);

            ListaMunicipios = con.listaMunicipios();
            ListaTipoAlumno = con.ConsultaTipoAlumno();
            ListaAlumnos = (ArrayList<DatosBean>) con.listaAlumnos(datos);

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String registroDual() {
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

            ListaMunicipios = con.listaMunicipios();

            ListaAlumnos2 = (ArrayList<DatosBean>) con.listaAlumnos2(datos);

            Iterator LA2 = ListaAlumnos2.iterator();
            DatosBean obj;

            while (LA2.hasNext()) {
                obj = (DatosBean) LA2.next();

                datos.setCCT(obj.getCCT());
                datos.setCURP(obj.getCURP());
                datos.setCLAVECARRERA(obj.getCVE_CAR_RES());
            }

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String BuscarRFC() {
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

            boolean rfca = false;

            Constantes.enviaMensajeConsola("rfc: " + pro.getRFCA());

            if (pro.getRFCA().length() > 0) {
                rfca = true;
            } else {
                addFieldError("ErrorRFCA", "debe ingresar la RFC a buscar");
                rfca = false;
            }

            if (rfca) {

                BuscaRFC = (ArrayList<ProyectoBean>) con.buscaRFC(pro.getRFCA());
                BanBuscaRFC = true;
                ListaMunicipios = con.listaMunicipios();
                if (BuscaRFC.size() > 0) {
                    Iterator BR = BuscaRFC.iterator();

                    ProyectoBean obj;

                    while (BR.hasNext()) {
                        obj = (ProyectoBean) BR.next();

                        pro.setRFC(obj.getRFC());
                        pro.setRAZON_SOCIAL(obj.getRAZON_SOCIAL());
                        pro.setGIRO(obj.getGIRO());
                        pro.setSECTOR(obj.getSECTOR());
                        pro.setDOMICILIOE(obj.getDOMICILIOE());
                        pro.setCOLONIAE(obj.getCOLONIAE());
                        pro.setLOCALIDADE(obj.getLOCALIDADE());
                        pro.setCPE(obj.getCPE());
                        pro.setMUNICIPIOE(obj.getMUNICIPIOE());
                        pro.setTELEFONOE(obj.getTELEFONOE());
                        pro.setCORREO_ELECTRONICOE(obj.getCORREO_ELECTRONICOE());
                        pro.setREP_LEGAL(obj.getREP_LEGAL());

                    }
                    BanEmpresaEncontrada = true;
                    BanExisteEmpresa = false;
                } else {
                    limpiar();
                }

            }

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String GuardarEmpresa() {
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
            BanBuscaRFC = true;
            ConsultasBusiness con = new ConsultasBusiness();
            ListaMunicipios = con.listaMunicipios();
            pro.setRFCA("");

            boolean rfc = false;
            boolean razon_social = false;
            boolean giro = false;
            boolean sector = false;
            boolean domicilio = false;
            boolean colonia = false;
            boolean localidad = false;
            boolean cp;
            boolean municipio = false;
            boolean rep_legal = false;
            boolean telefono = false;
            boolean correo = false;

            if (pro.getRFC().length() > 0) {
                rfc = true;
            } else {
                addFieldError("ErrorRFC", "se requiere el RFC de la empresa");
                rfc = false;
            }
            if (pro.getRAZON_SOCIAL().length() > 0) {
                razon_social = true;
            } else {
                addFieldError("ErrorRS", "se requiere el nombre de la empresa");
                razon_social = false;
            }
            if (pro.getGIRO().length() > 0) {
                giro = true;
            } else {
                addFieldError("ErrorGiro", "se requiere el giro de la empresa");
                giro = false;
            }
            if (pro.getSECTOR().length() > 0) {
                sector = true;
            } else {
                addFieldError("ErrorSector", "se requiere el sector de la empresa");
                sector = false;
            }
            if (pro.getDOMICILIOE().length() > 0) {
                domicilio = true;
            } else {
                addFieldError("ErrorDomicilioE", "se requiere el domicilio de la empresa");
                sector = false;
            }
            if (pro.getCOLONIAE().length() > 0) {
                colonia = true;
            } else {
                addFieldError("ErrorColonia", "se requiere la colonia");
                colonia = false;
            }

            if (pro.getLOCALIDADE().length() > 0) {
                localidad = true;
            } else {
                addFieldError("ErrorLocalidadE", "se requiere la localidad");
                localidad = false;
            }
            if (pro.getCPE().length() > 0) {
                cp = true;
            } else {
                addFieldError("ErrorCP", "se requiere el Código Postal");
                cp = false;
            }
            if (pro.getMUNICIPIOE().length() > 0) {
                municipio = true;
            } else {
                addFieldError("ErrorMunicipio", "se requiere el municipio");
                municipio = false;
            }
            if (pro.getTELEFONOE().length() > 0) {
                telefono = true;
            } else {
                addFieldError("ErrorTel", "se requiere el teléfono de la empresa");
                telefono = false;
            }
            if (pro.getCORREO_ELECTRONICOE().length() > 0) {
                correo = true;
            } else {
                addFieldError("ErrorCorreo", "se requiere el teléfono de la empresa");
                correo = false;
            }
            if (pro.getREP_LEGAL().length() > 0) {
                rep_legal = true;
            } else {
                addFieldError("ErrorRep", "se requiere Rep. Legal de la empresa");
                rep_legal = false;
            }

            if (rfc && razon_social && giro && sector && domicilio && colonia && localidad && cp && municipio && telefono && correo && rep_legal) {

                BuscaRFC = (ArrayList<ProyectoBean>) con.buscaRFC(pro.getRFC());

                if (BuscaRFC.size() > 0) {
                    Iterator BR = BuscaRFC.iterator();

                    ProyectoBean obj;

                    while (BR.hasNext()) {
                        obj = (ProyectoBean) BR.next();

                        pro.setRFC(obj.getRFC());
                        pro.setRAZON_SOCIAL(obj.getRAZON_SOCIAL());
                        pro.setGIRO(obj.getGIRO());
                        pro.setSECTOR(obj.getSECTOR());
                        pro.setDOMICILIOE(obj.getDOMICILIOE());
                        pro.setCOLONIAE(obj.getCOLONIAE());
                        pro.setLOCALIDADE(obj.getLOCALIDADE());
                        pro.setCPE(obj.getCPE());
                        pro.setMUNICIPIOE(obj.getMUNICIPIOE());
                        pro.setTELEFONOE(obj.getTELEFONOE());
                        pro.setCORREO_ELECTRONICOE(obj.getCORREO_ELECTRONICOE());
                        pro.setREP_LEGAL(obj.getREP_LEGAL());

                    }
                    BanExisteEmpresa = true;

                } else {

                    con.GuardaEmpresa(pro);

                    BanEmpresaRegistrada = true;

                    BuscaRFC = (ArrayList<ProyectoBean>) con.buscaRFC(pro.getRFC());

                }

                BanBuscaRFC = true;

            }

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String GuardarAsesor() {
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
            BanBuscaRFC = true;
            ConsultasBusiness con = new ConsultasBusiness();

            boolean rfc = false;
            boolean curp = false;
            boolean nomA = false;
            boolean apepA = false;
            boolean apemA = false;
            boolean cargo = false;
            boolean telefono = false;
            boolean correo = false;

            Constantes.enviaMensajeConsola("llego aqui" + pro.getCURP_A());
            if (pro.getCURP_A().length() > 0) {
                curp = true;
            } else {
                addFieldError("ErrorCurpA", "se requiere el CURP del asesor");
                curp = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getNOMBRE_A());
            if (pro.getNOMBRE_A().length() > 0) {
                nomA = true;
            } else {
                addFieldError("ErrorNombreA", "se requiere el nombre del asesor");
                nomA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getAPELLIDO_PA());
            if (pro.getAPELLIDO_PA().length() > 0) {
                apepA = true;
            } else {
                addFieldError("ErrorApellidoPA", "se requiere el apellido paterno del asesor");
                apepA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getAPELLIDO_MA());
            if (pro.getAPELLIDO_MA().length() > 0) {
                apemA = true;
            } else {
                addFieldError("ErrorApellidoMA", "se requiere el apellido materno del asesor");
                apemA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getCARGO_A());
            if (pro.getCARGO_A().length() > 0) {
                cargo = true;
            } else {
                addFieldError("ErrorCargo", "se requiere el cargo del asesor");
                cargo = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getTELEFONO_A());
            if (pro.getTELEFONO_A().length() > 0) {
                telefono = true;
            } else {
                addFieldError("ErrorTelA", "se requiere el teléfono del asesor");
                telefono = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getCORREO_A());
            if (pro.getCORREO_A().length() > 0) {
                correo = true;
            } else {
                addFieldError("ErrorCorreoA", "se requiere el Correo electronico del asesor");
                correo = false;
            }

            if (curp && nomA && apepA && apemA && cargo && telefono && correo) {

                VerificaAsesores = (ArrayList<ProyectoBean>) con.VerificaAsesor(pro.getCURP_A());

                if (VerificaAsesores.size() > 0) {

                    BanExisteAsesor = true;
                } else {

                    con.GuardaAsesor(pro);

                    BuscaRFC = (ArrayList<ProyectoBean>) con.buscaRFC(pro.getRFC());

                    Iterator BR = BuscaRFC.iterator();

                    ProyectoBean obj;

                    while (BR.hasNext()) {
                        obj = (ProyectoBean) BR.next();

                        pro.setRFC(obj.getRFC());
                        pro.setRAZON_SOCIAL(obj.getRAZON_SOCIAL());
                        pro.setGIRO(obj.getGIRO());
                        pro.setSECTOR(obj.getSECTOR());
                        pro.setDOMICILIOE(obj.getDOMICILIOE());
                        pro.setCOLONIAE(obj.getCOLONIAE());
                        pro.setLOCALIDADE(obj.getLOCALIDADE());
                        pro.setCPE(obj.getCPE());
                        pro.setMUNICIPIOE(obj.getMUNICIPIOE());
                        pro.setTELEFONOE(obj.getTELEFONOE());
                        pro.setCORREO_ELECTRONICOE(obj.getCORREO_ELECTRONICOE());
                        pro.setREP_LEGAL(obj.getREP_LEGAL());
                    }
                    ListaAsesores = (ArrayList<ProyectoBean>) con.ConsultaAsesores(pro.getRFC());
                    ListaMunicipios = con.listaMunicipios();

                    BanAsesorRegistrado = true;

                }
            }

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String AgregarProyecto() {

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
            BanBuscaRFC = true;
            BuscaRFC = (ArrayList<ProyectoBean>) con.buscaRFC(pro.getRFC());
            BanBuscaRFC = true;
            if (BuscaRFC.size() > 0) {
                Iterator BR = BuscaRFC.iterator();

                ProyectoBean obj;

                while (BR.hasNext()) {
                    obj = (ProyectoBean) BR.next();

                    pro.setRFC(obj.getRFC());
                    pro.setRAZON_SOCIAL(obj.getRAZON_SOCIAL());
                    pro.setGIRO(obj.getGIRO());
                    pro.setSECTOR(obj.getSECTOR());
                    pro.setDOMICILIOE(obj.getDOMICILIOE());
                    pro.setCOLONIAE(obj.getCOLONIAE());
                    pro.setLOCALIDADE(obj.getLOCALIDADE());
                    pro.setCPE(obj.getCPE());
                    pro.setMUNICIPIOE(obj.getMUNICIPIOE());
                    pro.setTELEFONOE(obj.getTELEFONOE());
                    pro.setCORREO_ELECTRONICOE(obj.getCORREO_ELECTRONICOE());
                    pro.setREP_LEGAL(obj.getREP_LEGAL());

                }
                BanEmpresaEncontrada = true;
                BanExisteEmpresa = false;
            }

            ListaResponsables = (ArrayList<ProyectoBean>) con.ConsultaResponsableI(datos.getCCT());
            ListaAsesoresI = (ArrayList<ProyectoBean>) con.ConsultaAsesoresI(datos.getCCT(), datos.getCLAVECARRERA());
            ListaEstatus = (ArrayList<ProyectoBean>) con.ConsultaEstatus();

            BanRegistraProyecto = true;

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String GuardarProyecto() {
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
            BanBuscaRFC = true;
            ConsultasBusiness con = new ConsultasBusiness();

            boolean nom_p = false;
            boolean etapa = false;
            boolean fec_ini = false;
            boolean fec_ter = false;
            boolean area_con = false;
            boolean num_horas = false;
            boolean ase_ins = false;
            boolean res_ins = false;
            boolean nomA = false;
            boolean apepA = false;
            boolean apemA = false;
            boolean cargo = false;
            boolean telefono = false;
            boolean correo = false;

            String ruta = null;

            Constantes.enviaMensajeConsola("nom pro: " + pro.getNOM_PRO());
            if (pro.getNOM_PRO().length() > 0) {
                nom_p = true;
            } else {
                addFieldError("ErrorNOMPRO", "se requiere el nombre del proyecto");
                nom_p = false;
            }
            Constantes.enviaMensajeConsola("etapa: " + pro.getETAPA());
            if (pro.getETAPA().length() > 0) {
                etapa = true;
            } else {
                addFieldError("ErrorETAPA", "se requiere una etapa");
                etapa = false;
            }
            Constantes.enviaMensajeConsola("area: " + pro.getAREA_CONOCIMIENTO());
            if (pro.getAREA_CONOCIMIENTO().length() > 0) {
                area_con = true;
            } else {
                addFieldError("ErrorAC", "se requiere un área de conocimiento");
                area_con = false;
            }
            Constantes.enviaMensajeConsola("horas: " + pro.getNUM_HORAS());
            if (pro.getNUM_HORAS().length() > 0) {
                num_horas = true;
            } else {
                addFieldError("ErrorNH", "se requiere el número de horas");
                num_horas = false;
            }
            Constantes.enviaMensajeConsola("fecha i: " + pro.getFECHA_INICIO());
            if (pro.getFECHA_INICIO().length() > 0) {
                fec_ini = true;
            } else {
                addFieldError("ErrorFI", "se requiere una fecha de inicio");
                fec_ini = false;
            }
            Constantes.enviaMensajeConsola("fecha t: " + pro.getFECHA_TERMINO());
            if (pro.getFECHA_TERMINO().length() > 0) {
                fec_ter = true;
            } else {
                addFieldError("ErrorFF", "se requiere una fecha de termino");
                fec_ter = false;
            }
            Constantes.enviaMensajeConsola("res e: " + pro.getRESP_INS());
            if (pro.getRESP_INS().length() > 0) {
                res_ins = true;
            } else {
                addFieldError("ErrorResp", "se requiere un responsable institucional");
                res_ins = false;
            }
            Constantes.enviaMensajeConsola("ase i: " + pro.getASE_INS());
            if (pro.getASE_INS().length() > 0) {
                ase_ins = true;
            } else {
                addFieldError("ErrorAI", "se requiere un asesor institucional");
                ase_ins = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getNOMBRE_A());
            if (pro.getNOMBRE_A().length() > 0) {
                nomA = true;
            } else {
                addFieldError("ErrorNombreA", "se requiere el nombre del asesor");
                nomA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getAPELLIDO_PA());
            if (pro.getAPELLIDO_PA().length() > 0) {
                apepA = true;
            } else {
                addFieldError("ErrorApellidoPA", "se requiere el apellido paterno del asesor");
                apepA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getAPELLIDO_MA());
            if (pro.getAPELLIDO_MA().length() > 0) {
                apemA = true;
            } else {
                addFieldError("ErrorApellidoMA", "se requiere el apellido materno del asesor");
                apemA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getCARGO_A());
            if (pro.getCARGO_A().length() > 0) {
                cargo = true;
            } else {
                addFieldError("ErrorCargo", "se requiere el cargo del asesor");
                cargo = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getTELEFONO_A());
            if (pro.getTELEFONO_A().length() > 0) {
                telefono = true;
            } else {
                addFieldError("ErrorTelA", "se requiere el teléfono del asesor");
                telefono = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getCORREO_A());
            if (pro.getCORREO_A().length() > 0) {
                correo = true;
            } else {
                addFieldError("ErrorCorreoA", "se requiere el Correo electronico del asesor");
                correo = false;
            }

            if (nom_p && etapa && area_con && num_horas && fec_ini && fec_ter && res_ins && ase_ins && nomA && apepA && apemA && cargo && telefono && correo) {

                Constantes.enviaMensajeConsola("paso validacion");

                pro.setCCT(datos.getCCT());
                pro.setCURP_AL(datos.getCURP());

                if (archiFileName != null) {
                    validate2();

                    if (banT == false) {

                        String Extension = "";

                        Extension = getExtension(archiFileName);

                        //System.out.println("esta es la extension del archivo: "+Extension);
                        archiFileName = pro.getCCT() + "CONVENIO" + pro.getCURP_AL() + "." + Extension;

                        pro.setCONVENIO(archiFileName);
                        ruta = Constantes.rutaArch + archiFileName;

                        Constantes.enviaMensajeConsola(ruta);
                        File newarch = new File(ruta);

                        FileUtils.copyFile(archi, newarch);
                    } else {
                        AgregarProyecto();
                        BanRegistraProyecto = true;
                        BanBuscaRFC = true;
                        return "ERROR";
                    }
                } else {
                    pro.setCONVENIO("");
                }
                pro.setSTATUS_P("1");

                con.GuardaProyecto(pro);
                con.GuardaAsesor(pro);

                pro.setAVANCE("100");
                con.ActualizaStatus(pro);

                BanProyectoRegistrado = true;

                return "SUCCESS";

            } else {
                AgregarProyecto();
                BanRegistraProyecto = true;
                BanBuscaRFC = true;
                return "ERROR";
            }

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    //*****************************************************metodos de actualizacion****************************************************************
    public String ModificarProyecto() {

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

            ListaMunicipios = con.listaMunicipios();

            ListaAlumnos2 = (ArrayList<DatosBean>) con.listaAlumnos2(datos);

            Iterator LA2 = ListaAlumnos2.iterator();
            DatosBean obj;

            while (LA2.hasNext()) {
                obj = (DatosBean) LA2.next();

                datos.setCCT(obj.getCCT());
                datos.setCURP(obj.getCURP());
                datos.setCLAVECARRERA(obj.getCVE_CAR_RES());
            }

            ListaResponsables = (ArrayList<ProyectoBean>) con.ConsultaResponsableI(datos.getCCT());
            ListaAsesoresI = (ArrayList<ProyectoBean>) con.ConsultaAsesoresI(datos.getCCT(), datos.getCLAVECARRERA());
            ListaEstatus = (ArrayList<ProyectoBean>) con.ConsultaEstatus();
            pro = con.ConsultaProyecto(datos.getCURP());

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String ActualizarProyecto() {
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
            BanBuscaRFC = true;
            ConsultasBusiness con = new ConsultasBusiness();

            boolean nom_p = false;
            boolean etapa = false;
            boolean fec_ini = false;
            boolean fec_ter = false;
            boolean area_con = false;
            boolean num_horas = false;
            boolean ase_ins = false;
            boolean res_ins = false;
            boolean nomA = false;
            boolean apepA = false;
            boolean apemA = false;
            boolean cargo = false;
            boolean telefono = false;
            boolean correo = false;

            String ruta = null;

            Constantes.enviaMensajeConsola("nom pro: " + pro.getNOM_PRO());
            if (pro.getNOM_PRO().length() > 0) {
                nom_p = true;
            } else {
                addFieldError("ErrorNOMPRO", "se requiere el nombre del proyecto");
                nom_p = false;
            }
            Constantes.enviaMensajeConsola("etapa: " + pro.getETAPA());
            if (pro.getETAPA().length() > 0) {
                etapa = true;
            } else {
                addFieldError("ErrorETAPA", "se requiere el nombre del asesor");
                etapa = false;
            }
            Constantes.enviaMensajeConsola("area: " + pro.getAREA_CONOCIMIENTO());
            if (pro.getAREA_CONOCIMIENTO().length() > 0) {
                area_con = true;
            } else {
                addFieldError("ErrorAC", "se requiere un área de conocimiento");
                area_con = false;
            }
            Constantes.enviaMensajeConsola("horas: " + pro.getNUM_HORAS());
            if (pro.getNUM_HORAS().length() > 0) {
                num_horas = true;
            } else {
                addFieldError("ErrorNH", "se requiere el número de horas");
                num_horas = false;
            }
            Constantes.enviaMensajeConsola("fecha i: " + pro.getFECHA_INICIO());
            if (pro.getFECHA_INICIO().length() > 0) {
                fec_ini = true;
            } else {
                addFieldError("ErrorFI", "se requiere una fecha de inicio");
                fec_ini = false;
            }
            Constantes.enviaMensajeConsola("fecha t: " + pro.getFECHA_TERMINO());
            if (pro.getFECHA_TERMINO().length() > 0) {
                fec_ter = true;
            } else {
                addFieldError("ErrorFF", "se requiere una fecha de termino");
                fec_ter = false;
            }
            Constantes.enviaMensajeConsola("res e: " + pro.getRESP_INS());
            if (pro.getRESP_INS().length() > 0) {
                res_ins = true;
            } else {
                addFieldError("ErrorResp", "se requiere un responsable institucional");
                res_ins = false;
            }
            Constantes.enviaMensajeConsola("ase i: " + pro.getASE_INS());
            if (pro.getASE_INS().length() > 0) {
                ase_ins = true;
            } else {
                addFieldError("ErrorAI", "se requiere un asesor institucional");
                ase_ins = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getNOMBRE_A());
            if (pro.getNOMBRE_A().length() > 0) {
                nomA = true;
            } else {
                addFieldError("ErrorNombreA", "se requiere el nombre del asesor");
                nomA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getAPELLIDO_PA());
            if (pro.getAPELLIDO_PA().length() > 0) {
                apepA = true;
            } else {
                addFieldError("ErrorApellidoPA", "se requiere el apellido paterno del asesor");
                apepA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getAPELLIDO_MA());
            if (pro.getAPELLIDO_MA().length() > 0) {
                apemA = true;
            } else {
                addFieldError("ErrorApellidoMA", "se requiere el apellido materno del asesor");
                apemA = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getCARGO_A());
            if (pro.getCARGO_A().length() > 0) {
                cargo = true;
            } else {
                addFieldError("ErrorCargo", "se requiere el cargo del asesor");
                cargo = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getTELEFONO_A());
            if (pro.getTELEFONO_A().length() > 0) {
                telefono = true;
            } else {
                addFieldError("ErrorTelA", "se requiere el teléfono del asesor");
                telefono = false;
            }
            Constantes.enviaMensajeConsola("llego aqui" + pro.getCORREO_A());
            if (pro.getCORREO_A().length() > 0) {
                correo = true;
            } else {
                addFieldError("ErrorCorreoA", "se requiere el Correo electronico del asesor");
                correo = false;
            }

            if (nom_p && etapa && area_con && num_horas && fec_ini && fec_ter && res_ins && ase_ins && nomA && apepA && apemA && cargo && telefono && correo) {

                Constantes.enviaMensajeConsola("paso validacion");

                pro.setCCT(datos.getCCT());
                pro.setCURP_AL(datos.getCURP());

                Constantes.enviaMensajeConsola("cct" + pro.getCCT());

                Constantes.enviaMensajeConsola("curp" + pro.getCURP_AL());

                if (archiFileName != null) {
                    Constantes.enviaMensajeConsola("entro a validar");

                    validate2();
                    Constantes.enviaMensajeConsola("Valor de la bandera: " + banT);
                    if (banT == false) {

                        String Extension = "";

                        Extension = getExtension(archiFileName);

                        //System.out.println("esta es la extension del archivo: "+Extension);
                        archiFileName = pro.getCCT() + "CONVENIO" + pro.getCURP_AL() + "." + Extension;

                        pro.setCONVENIO(archiFileName);

                        Constantes.enviaMensajeConsola("archivo: " + pro.getCONVENIO());
                        ruta = Constantes.rutaArch + archiFileName;

                        Constantes.enviaMensajeConsola(ruta);
                        File newarch = new File(ruta);

                        FileUtils.copyFile(archi, newarch);
                    } else {
                        return "ERROR";
                    }
                } else {
                    pro.setCONVENIO("");
                }

                //Constantes.enviaMensajeConsola("paos lo de archivos");
                if (pro.getSTATUS_P().equals("10")) {
                    pro.setFECHA_CAMBIO_STATUS(fecha());
                    pro.setFECHA_EGRESO(fecha());
                    pro.setFECHA_CIERRE(fecha());
                    con.ActualizarProyecto(pro);
                    con.ActualizarEstatusAlumnoEgresado(pro);
                } else if (pro.getSTATUS_P().equals("11") || pro.getSTATUS_P().equals("12") || pro.getSTATUS_P().equals("13") || pro.getSTATUS_P().equals("14")) {

                    pro.setFECHA_CIERRE(fecha());
                    pro.setFECHA_CAMBIO_STATUS(fecha());

                    con.ActualizarProyecto(pro);

                    con.ActualizarAsesor(pro);

                    con.ActualizarEstatusAlumnos(pro);

                } else {
                    
                    pro.setFECHA_CIERRE("");
                    
                    con.ActualizarProyecto(pro);

                    con.ActualizarAsesor(pro);

                }

                BanProyectoActualizado = true;

                return "SUCCESS";

            } else {

                return "ERROR";
            }

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    //*****************************************************metodos de BECAS****************************************************************
    public String registroBeca() {
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

            ListaMunicipios = con.listaMunicipios();

            datos.setCURPA(datos.getCURPAB());

            ListaAlumnos2 = (ArrayList<DatosBean>) con.listaAlumnos2(datos);

            ListaTipoBeca = (ArrayList<BecaBean>) con.ConsultaTipoBeca();

            Iterator LA2 = ListaAlumnos2.iterator();
            DatosBean obj;

            while (LA2.hasNext()) {
                obj = (DatosBean) LA2.next();

                datos.setCCT(obj.getCCT());
                datos.setCURP(obj.getCURP());
            }

            ListaBecas = (ArrayList<BecaBean>) con.ConsultaBecas(datos);

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String GuardarBeca() {
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

            boolean fuente = false;
            boolean tipo_beca = false;
            boolean monto = false;
            boolean des_beca = false;
            boolean periodo = false;
            boolean duracion = false;

            String ruta = null;

            Constantes.enviaMensajeConsola("fuente: " + be.getFUENTE());
            if (be.getFUENTE().length() > 0) {
                fuente = true;
            } else {
                addFieldError("ErrorFuente", "se requiere la fuente ");
                fuente = false;
            }
            Constantes.enviaMensajeConsola("tipobeca: " + be.getTIPO_BECA());
            if (be.getTIPO_BECA().length() > 0) {
                tipo_beca = true;
            } else {
                addFieldError("ErrorTipoBeca", "seleccione el tipo de beca");
                tipo_beca = false;
            }

            if (Integer.valueOf(be.getTIPO_BECA()) == 1) {
                Constantes.enviaMensajeConsola("monto: " + be.getMONTO());
                if (be.getMONTO().length() > 0) {
                    monto = true;
                } else {
                    addFieldError("ErrorMonto", "se requiere el monto de la beca");
                    monto = false;
                }

            }

            if (Integer.valueOf(be.getTIPO_BECA()) > 1) {
                Constantes.enviaMensajeConsola("monto: " + be.getMONTO());
                if (be.getDES_BECA().length() > 0) {
                    des_beca = true;
                } else {
                    addFieldError("ErrorDes_Beca", "se requiere una descripción de la beca");
                    des_beca = false;
                }

            }

            Constantes.enviaMensajeConsola("periodo: " + be.getPERIODICIDAD());
            if (be.getPERIODICIDAD().length() > 0) {
                periodo = true;
            } else {
                addFieldError("ErrorPeriodo", "se requiere una periodicidad");
                periodo = false;
            }
            Constantes.enviaMensajeConsola("duracion: " + be.getDURACION());
            if (be.getDURACION().length() > 0) {
                duracion = true;
            } else {
                addFieldError("ErrorDuracion", "se requiere la duracion de la beca");
                duracion = false;
            }

            if (fuente && tipo_beca && monto || des_beca && periodo && duracion) {

                Constantes.enviaMensajeConsola("paso validacion");

                be.setCCT_B(datos.getCCT());
                be.setCURP_AB(datos.getCURP());

                be.setSTATUS_B("1");

                con.GuardaBecas(be);

                be.setBECA("si");
                con.ActualizaStatusBeca(be);

                ListaBecas = (ArrayList<BecaBean>) con.ConsultaBecas(datos);

                limpiarBeca();

                BanBecaRegistrada = true;

                return "SUCCESS";

            } else {
                return "ERROR";
            }

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String ActualizaBeca() {
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

            Constantes.enviaMensajeConsola("paso validacion");

            if (be.getTIPO_BECAA().equals("1")) {

                be.setDES_BECAA("");
            } else if (!be.getTIPO_BECAA().equals("1")) {
                be.setMONTOA("");
            }

            con.ActualizarBecas(be);

            ListaBecas = (ArrayList<BecaBean>) con.ConsultaBecas(datos);

            limpiarBeca();

            BanBecaActualizada = true;

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String EliminarBeca() {
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

            con.EliminarBecas(be);

            be.setCCT_B(datos.getCCT());
            be.setCURP_AB(datos.getCURP());

            ListaBecas = (ArrayList<BecaBean>) con.ConsultaBecas(datos);

            if (ListaBecas.size() == 0) {
                be.setBECA("no");
                con.ActualizaStatusBeca(be);
            }

            limpiarBeca();

            BanBecaEliminada = true;

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public void limpiarBeca() {
        be.setTIPO_BECA("");
        be.setFUENTE("");
        be.setMONTO("");
        be.setDES_BECA("");
        be.setPERIODICIDAD("");
        be.setDURACION("");
        be.setID_BECA("");
    }

    //****************************************METODOS TABLERO********************************************************
    public String consultaDashboard() {
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

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

            bantablero = true;

            Constantes.enviaMensajeConsola("FECHA INICIO" + datos.getFECHA_INICIO());
            Constantes.enviaMensajeConsola("FECHA termino" + datos.getFECHA_TERMINO());

            ListaAlumnosDashboard = con.listaAlumnosDashboard(datos);

            Constantes.enviaMensajeConsola("lista Alumnos : " + ListaAlumnosDashboard.size());

            Iterator LAD = ListaAlumnosDashboard.iterator();

            DatosBean obj;
            int total = 0;
            int activo = 0;
            int inactivo = 0;
            int hombre = 0;
            int mujer = 0;
            int egresados = 0;
            int nuevos = 0;
            int tipo_alu = 0;
            Date fechaReg = null;
            Date fechainicio = null;
            Date fechatermino = null;
            System.out.println("fecha reg" + fechaReg);

            fechainicio = format.parse(datos.getFECHA_INICIO());
            fechatermino = format.parse(datos.getFECHA_TERMINO());

            while (LAD.hasNext()) {
                obj = (DatosBean) LAD.next();
                total = total + 1;

                Constantes.enviaMensajeConsola("SEXO: " + obj.getSEXO());

                if (obj.getESTATUS_GENERAL().equals("ACTIVO")) {

                    activo = activo + 1;
                }
                if (obj.getESTATUS_GENERAL().equals("INACTIVO") && !obj.getSTATUS().equals("10")) {

                    inactivo = inactivo + 1;
                }

                if (obj.getSEXO().equals("HOMBRE")) {

                    hombre = hombre + 1;
                }
                if (obj.getSEXO().equals("MUJER")) {

                    mujer = mujer + 1;
                }

                if (obj.getSTATUS().equals("10")) {

                    egresados = egresados + 1;
                }

                if (obj.getFECHA_REG() != null) {
                    fechaReg = format.parse(obj.getFECHA_REG());
                    if (fechaReg.after(fechainicio) && fechaReg.before(fechatermino) || fechaReg.equals(fechainicio) || fechaReg.equals(fechatermino)) {

                        nuevos = nuevos + 1;
                    }
                }

                if (obj.getTIPO_ALUMNO().equals("2")) {

                    tipo_alu = tipo_alu + 1;
                }

            }

            datos.setTOTAL_ALU_DUAL(String.valueOf(total));
            datos.setTOTAL_ALU_ACTIVO(String.valueOf(activo));
            datos.setTOTAL_ALU_INACTIVO(String.valueOf(inactivo));
            datos.setALUMNOS_NUEVO_INGRESO(con.AlumnosNuevoIngresoA(datos));
            datos.setALUMNOS_ACTIVOS_PERIODO(con.AlumnosActivosPeriodoA(datos));
            datos.setTOTAL_HOMBRE(String.valueOf(hombre));
            datos.setTOTAL_MUJER(String.valueOf(mujer));
            datos.setEGRESADOS(String.valueOf(egresados));
            datos.setALUMNOS_NUEVOS(String.valueOf(nuevos));
            datos.setTOTAL_TIPO_ALUMNO(String.valueOf(tipo_alu));

            Constantes.enviaMensajeConsola("hombre&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + hombre + " asignado" + datos.getTOTAL_HOMBRE());

            ListaTotalEstatus = con.listaTotalEstatus(datos);
            ListaTotalEsuela = con.listaTotalEscuela(datos);
           
            
            
            
            
            

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String AbreTablero() {

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

            Constantes.enviaMensajeConsola("usuario: " + usuariocons.getNAMEUSUARIO());
            String fecha = fecha();
            fecha = fecha.substring(3, 8);
            datos.setFECHA_INICIO("01/" + fecha);
            datos.setFECHA_TERMINO(fecha());
            consultaDashboardU();

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String consultaDashboardU() {
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
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

            bantablero = true;

            datos.setCCT(usuariocons.getUSUARIO());

            ListaAlumnosDashboardU = con.listaAlumnosDashboardU(datos);
            
            

            Iterator LAD = ListaAlumnosDashboardU.iterator();

            DatosBean obj;
            int total = 0;
            int activo = 0;
            int inactivo = 0;
            int hombre = 0;
            int mujer = 0;
            int egresados = 0;
            int nuevos = 0;
            int tipo_alu = 0;
            Date fechaReg = null;
            Date fechainicio = null;
            Date fechatermino = null;

            fechainicio = format.parse(datos.getFECHA_INICIO());
            fechatermino = format.parse(datos.getFECHA_TERMINO());

            while (LAD.hasNext()) {
                obj = (DatosBean) LAD.next();
                total = total + 1;

                if (obj.getESTATUS_GENERAL().equals("ACTIVO")) {

                    activo = activo + 1;
                }
                if (obj.getESTATUS_GENERAL().equals("INACTIVO") && !obj.getSTATUS().equals("10")) {

                    inactivo = inactivo + 1;
                }

                if (obj.getSEXO().equals("HOMBRE")) {

                    hombre = hombre + 1;
                }
                if (obj.getSEXO().equals("MUJER")) {

                    mujer = mujer + 1;
                }

                if (obj.getSTATUS().equals("10")) {

                    egresados = egresados + 1;
                }

                if (obj.getFECHA_REG() != null) {
                    fechaReg = format.parse(obj.getFECHA_REG());
                    if (fechaReg.after(fechainicio) && fechaReg.before(fechatermino) || fechaReg.equals(fechainicio) || fechaReg.equals(fechatermino)) {

                        nuevos = nuevos + 1;
                    }
                }

                if (obj.getTIPO_ALUMNO().equals("2")) {

                    tipo_alu = tipo_alu + 1;
                }

            }
            
            
           
            datos.setTOTAL_ALU_DUAL(String.valueOf(total));
            datos.setTOTAL_ALU_ACTIVO(String.valueOf(activo));
            datos.setTOTAL_ALU_INACTIVO(String.valueOf(inactivo));
            datos.setALUMNOS_NUEVO_INGRESO(con.AlumnosNuevoIngreso(datos));
            datos.setALUMNOS_ACTIVOS_PERIODO(con.AlumnosActivosPeriodo(datos));
            datos.setTOTAL_HOMBRE(String.valueOf(hombre));
            datos.setTOTAL_MUJER(String.valueOf(mujer));
            datos.setEGRESADOS(String.valueOf(egresados));
            datos.setALUMNOS_NUEVOS(String.valueOf(nuevos));
            datos.setTOTAL_TIPO_ALUMNO(String.valueOf(tipo_alu));
            
            
            
            
            activo=0;
            inactivo=0;
            egresados=0;
            
            
            ListaAlumnosDashboardUGeneral = con.listaAlumnosDashboardUGeneral(datos);
             
             Iterator LADUG=ListaAlumnosDashboardUGeneral.iterator();
              DatosBean obj2;
             
            while (LADUG.hasNext()) {
          obj2 = (DatosBean) LADUG.next();
          
          
          
          if (obj2.getESTATUS_GENERAL().equals("ACTIVO")) {

                    activo = activo + 1;
                }
                if (obj2.getESTATUS_GENERAL().equals("INACTIVO") && !obj2.getSTATUS().equals("10")) {

                    inactivo = inactivo + 1;
                }
                
                 if (obj2.getSTATUS().equals("10")) {

                    egresados = egresados + 1;
                }
          
          
          
                
            }
            
            datos.setALUMNOS_ACTIVOS_GENERAL(String.valueOf(activo));
            datos.setALUMNOS_INACTIVOS_GENERAL(String.valueOf(inactivo));
              datos.setALUMNOS_EGRESADOS_GENERAL(String.valueOf(egresados));
              datos.setTOTAL_ALUMNOS_DUAL(String.valueOf(activo+inactivo+egresados));
            
            


           

            ListaTotalEstatusU = con.listaTotalEstatusU(datos);
            ListaTotalEsuelaU = con.listaTotalAsesorProyecto(datos);
            
            
             System.out.println("voy a calcular proyectos");
            ListaProyectos=con.proyectos(datos);
            
            
            Iterator LP =ListaProyectos.iterator();
            
             DatosBean obj3;
             
             while (LP.hasNext()) {
               obj3= (DatosBean) LP.next();
               
               datos.setTOTAL_PROYECTOS(obj3.getTOTAL_PROYECTOS());
                
            }
             System.out.println("EL TOTAL DE LOS PROYECTOS ES DE "+datos.getTOTAL_PROYECTOS());
            
            
            
            
            
            

            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String fecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
        return formateador.format(ahora);
    }

    public static boolean checkEmail(String email) {
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
        // Asociar el string al patron
        Matcher m = p.matcher(email);
        // Comprobar si encaja
        return m.matches();
    }

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

    public void validate2() {

        try {
//agregando la validacion de tipo de archivo...
            if (archiFileName.toLowerCase() != null) {
                Constantes.enviaMensajeConsola("--EL ARCHIVO ES .... " + archiFileName.toLowerCase());

                if (!archiFileName.toLowerCase().contains(".pdf")) {

                    addFieldError("archierror", "*** La extensión del archivo no es aceptada debe ser (pdf)***");
                    Constantes.enviaMensajeConsola("--EL ARCHIVO ES DIFERENTE DE PDF .... " + archiFileName.toLowerCase());
                    banT = true;

                }

                //if (archiFileName.length() > 2097152 ) 
                if (16777126 <= FileUtils.sizeOf(archi)) {

                    Constantes.enviaMensajeConsola("--EL ARCHIVO ES MAYOR .... " + archiFileName.toLowerCase());
                    addFieldError("archierror", "*** No se permiten archivos mayores a 15MB ***");

                    banT = true;

                }

            }
        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();

        }

    }

    public static String getExtension(String Archivo) {
        int index = Archivo.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else {
            return Archivo.substring(index + 1);
        }
    }

    public void limpiar() {

        pro.setRFC("");
        pro.setRAZON_SOCIAL("");
        pro.setGIRO("");
        pro.setSECTOR("");
        pro.setDOMICILIOE("");
        pro.setLOCALIDADE("");
        pro.setCOLONIAE("");
        pro.setCPE("");
        pro.setMUNICIPIOE("");
        pro.setTELEFONOE("");
        pro.setCORREO_ELECTRONICOE("");
        pro.setREP_LEGAL("");

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

    public boolean isBanT() {
        return banT;
    }

    public void setBanT(boolean banT) {
        this.banT = banT;
    }

    public String getArchiFileName() {
        return archiFileName;
    }

    public void setArchiFileName(String archiFileName) {
        this.archiFileName = archiFileName;
    }

    public File getArchi() {
        return archi;
    }

    public void setArchi(File archi) {
        this.archi = archi;
    }

    public boolean isBanBuscaRFC() {
        return BanBuscaRFC;
    }

    public void setBanBuscaRFC(boolean BanBuscaRFC) {
        this.BanBuscaRFC = BanBuscaRFC;
    }

    public boolean isBanAsesoresE() {
        return BanAsesoresE;
    }

    public void setBanAsesoresE(boolean BanAsesoresE) {
        this.BanAsesoresE = BanAsesoresE;
    }

    public boolean isBanExisteEmpresa() {
        return BanExisteEmpresa;
    }

    public void setBanExisteEmpresa(boolean BanExisteEmpresa) {
        this.BanExisteEmpresa = BanExisteEmpresa;
    }

    public boolean isBanEmpresaEncontrada() {
        return BanEmpresaEncontrada;
    }

    public void setBanEmpresaEncontrada(boolean BanEmpresaEncontrada) {
        this.BanEmpresaEncontrada = BanEmpresaEncontrada;
    }

    public boolean isBanEmpresaRegistrada() {
        return BanEmpresaRegistrada;
    }

    public void setBanEmpresaRegistrada(boolean BanEmpresaRegistrada) {
        this.BanEmpresaRegistrada = BanEmpresaRegistrada;
    }

    public boolean isBanAsesorRegistrado() {
        return BanAsesorRegistrado;
    }

    public void setBanAsesorRegistrado(boolean BanAsesorRegistrado) {
        this.BanAsesorRegistrado = BanAsesorRegistrado;
    }

    public boolean isBanExisteAsesor() {
        return BanExisteAsesor;
    }

    public void setBanExisteAsesor(boolean BanExisteAsesor) {
        this.BanExisteAsesor = BanExisteAsesor;
    }

    public boolean isBanRegistraProyecto() {
        return BanRegistraProyecto;
    }

    public void setBanRegistraProyecto(boolean BanRegistraProyecto) {
        this.BanRegistraProyecto = BanRegistraProyecto;
    }

    public boolean isBanProyectoRegistrado() {
        return BanProyectoRegistrado;
    }

    public void setBanProyectoRegistrado(boolean BanProyectoRegistrado) {
        this.BanProyectoRegistrado = BanProyectoRegistrado;
    }

    public boolean isBanProyectoActualizado() {
        return BanProyectoActualizado;
    }

    public void setBanProyectoActualizado(boolean BanProyectoActualizado) {
        this.BanProyectoActualizado = BanProyectoActualizado;
    }

    public boolean isBanErrorSubirArchivo() {
        return BanErrorSubirArchivo;
    }

    public void setBanErrorSubirArchivo(boolean BanErrorSubirArchivo) {
        this.BanErrorSubirArchivo = BanErrorSubirArchivo;
    }

    public boolean isBanBecaRegistrada() {
        return BanBecaRegistrada;
    }

    public void setBanBecaRegistrada(boolean BanBecaRegistrada) {
        this.BanBecaRegistrada = BanBecaRegistrada;
    }

    public boolean isBanBecaActualizada() {
        return BanBecaActualizada;
    }

    public void setBanBecaActualizada(boolean BanBecaActualizada) {
        this.BanBecaActualizada = BanBecaActualizada;
    }

    public boolean isBanBecaEliminada() {
        return BanBecaEliminada;
    }

    public void setBanBecaEliminada(boolean BanBecaEliminada) {
        this.BanBecaEliminada = BanBecaEliminada;
    }

    public DatosBean getDatos() {
        return datos;
    }

    public void setDatos(DatosBean datos) {
        this.datos = datos;
    }

    public ProyectoBean getPro() {
        return pro;
    }

    public void setPro(ProyectoBean pro) {
        this.pro = pro;
    }

    public BecaBean getBe() {
        return be;
    }

    public void setBe(BecaBean be) {
        this.be = be;
    }

    public ArrayList<DatosBean> getListaCarrera() {
        return ListaCarrera;
    }

    public void setListaCarrera(ArrayList<DatosBean> ListaCarrera) {
        this.ListaCarrera = ListaCarrera;
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

    public ArrayList<DatosBean> getListaAlumnos2() {
        return ListaAlumnos2;
    }

    public void setListaAlumnos2(ArrayList<DatosBean> ListaAlumnos2) {
        this.ListaAlumnos2 = ListaAlumnos2;
    }

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

    public ArrayList<ProyectoBean> getBuscaRFC() {
        return BuscaRFC;
    }

    public void setBuscaRFC(ArrayList<ProyectoBean> BuscaRFC) {
        this.BuscaRFC = BuscaRFC;
    }

    public ArrayList<ProyectoBean> getListaAsesores() {
        return ListaAsesores;
    }

    public void setListaAsesores(ArrayList<ProyectoBean> ListaAsesores) {
        this.ListaAsesores = ListaAsesores;
    }

    public ArrayList<ProyectoBean> getVerificaAsesores() {
        return VerificaAsesores;
    }

    public void setVerificaAsesores(ArrayList<ProyectoBean> VerificaAsesores) {
        this.VerificaAsesores = VerificaAsesores;
    }

    public ArrayList<ProyectoBean> getListaAsesoresE() {
        return ListaAsesoresE;
    }

    public void setListaAsesoresE(ArrayList<ProyectoBean> ListaAsesoresE) {
        this.ListaAsesoresE = ListaAsesoresE;
    }

    public ArrayList<ProyectoBean> getListaAsesoresI() {
        return ListaAsesoresI;
    }

    public void setListaAsesoresI(ArrayList<ProyectoBean> ListaAsesoresI) {
        this.ListaAsesoresI = ListaAsesoresI;
    }

    public ArrayList<ProyectoBean> getListaResponsables() {
        return ListaResponsables;
    }

    public void setListaResponsables(ArrayList<ProyectoBean> ListaResponsables) {
        this.ListaResponsables = ListaResponsables;
    }

    public ArrayList<ProyectoBean> getListaEstatus() {
        return ListaEstatus;
    }

    public void setListaEstatus(ArrayList<ProyectoBean> ListaEstatus) {
        this.ListaEstatus = ListaEstatus;
    }

    public ArrayList<BecaBean> getListaBecas() {
        return ListaBecas;
    }

    public void setListaBecas(ArrayList<BecaBean> ListaBecas) {
        this.ListaBecas = ListaBecas;
    }

    public ArrayList<BecaBean> getListaTipoBeca() {
        return ListaTipoBeca;
    }

    public void setListaTipoBeca(ArrayList<BecaBean> ListaTipoBeca) {
        this.ListaTipoBeca = ListaTipoBeca;
    }

    public List<DatosBean> getListaAlumnosDashboard() {
        return ListaAlumnosDashboard;
    }

    public void setListaAlumnosDashboard(List<DatosBean> ListaAlumnosDashboard) {
        this.ListaAlumnosDashboard = ListaAlumnosDashboard;
    }

    public List<DatosBean> getListaTotalEstatus() {
        return ListaTotalEstatus;
    }

    public void setListaTotalEstatus(List<DatosBean> ListaTotalEstatus) {
        this.ListaTotalEstatus = ListaTotalEstatus;
    }

    public List<DatosBean> getListaTotalEsuela() {
        return ListaTotalEsuela;
    }

    public void setListaTotalEsuela(List<DatosBean> ListaTotalEsuela) {
        this.ListaTotalEsuela = ListaTotalEsuela;
    }

    public List<DatosBean> getListaAlumnosDashboardU() {
        return ListaAlumnosDashboardU;
    }

    public void setListaAlumnosDashboardU(List<DatosBean> ListaAlumnosDashboardU) {
        this.ListaAlumnosDashboardU = ListaAlumnosDashboardU;
    }

    public List<DatosBean> getListaTotalEstatusU() {
        return ListaTotalEstatusU;
    }

    public void setListaTotalEstatusU(List<DatosBean> ListaTotalEstatusU) {
        this.ListaTotalEstatusU = ListaTotalEstatusU;
    }

    public List<DatosBean> getListaTotalEsuelaU() {
        return ListaTotalEsuelaU;
    }

    public void setListaTotalEsuelaU(List<DatosBean> ListaTotalEsuelaU) {
        this.ListaTotalEsuelaU = ListaTotalEsuelaU;
    }

    public boolean isBantablero() {
        return bantablero;
    }

    public void setBantablero(boolean bantablero) {
        this.bantablero = bantablero;
    }

    public List<DatosBean> getListaAlumnosDashboardUGeneral() {
        return ListaAlumnosDashboardUGeneral;
    }

    public void setListaAlumnosDashboardUGeneral(List<DatosBean> ListaAlumnosDashboardUGeneral) {
        this.ListaAlumnosDashboardUGeneral = ListaAlumnosDashboardUGeneral;
    }

    public List<DatosBean> getListaProyectos() {
        return ListaProyectos;
    }

    public void setListaProyectos(List<DatosBean> ListaProyectos) {
        this.ListaProyectos = ListaProyectos;
    }

    public List<DatosBean> getListaReingresos() {
        return ListaReingresos;
    }

    public void setListaReingresos(List<DatosBean> ListaReingresos) {
        this.ListaReingresos = ListaReingresos;
    }
    
    
    
    

}
