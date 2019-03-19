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
    public List<DatosBean> ListaTotalEstatus = new ArrayList<DatosBean>();
    public List<DatosBean> ListaAlumnosDashboard = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalEsuela = new ArrayList<DatosBean>();

    public List<DatosBean> ListaAlumnosDashboardUGeneral = new ArrayList<DatosBean>();
    public List<DatosBean> ListaProyectos = new ArrayList<DatosBean>();
    public List<DatosBean> ListaReingresos = new ArrayList<DatosBean>();
    public List<DatosBean> ListaMunicipioEscuela = new ArrayList<DatosBean>();
    public List<DatosBean> ListaEmpresasAlumnos = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalEstatusUGeneral = new ArrayList<DatosBean>();
     public List<DatosBean> ListaCarreraAlumnos = new ArrayList<DatosBean>();
       public List<DatosBean> ListaAvanceMetas = new ArrayList<DatosBean>();
         public List<DatosBean> ListaAlumnosNuevos = new ArrayList<DatosBean>();
           public List<DatosBean> ListaAlumnosReingresos = new ArrayList<DatosBean>();

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
                    int beca = 0;

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

                   /*     if (obj.getFECHA_REG() != null) {
                            fechaReg = format.parse(obj.getFECHA_REG());
                            if (fechaReg.after(fechainicio) && fechaReg.before(fechatermino) || fechaReg.equals(fechainicio) || fechaReg.equals(fechatermino)) {

                                nuevos = nuevos + 1;
                            }
                        }*/

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

                    activo = 0;
                    inactivo = 0;
                    egresados = 0;
                    hombre = 0;
                    mujer = 0;
                    beca = 0;

                    ListaAlumnosDashboardUGeneral = con.listaAlumnosDashboardGeneral(datos);

                    Iterator LADUG = ListaAlumnosDashboardUGeneral.iterator();
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
                        if (obj2.getSEXO().equals("HOMBRE")) {

                            hombre = hombre + 1;
                        }
                        if (obj2.getSEXO().equals("MUJER")) {

                            mujer = mujer + 1;
                        }

                        if (obj2.getBECA().equals("si") && obj2.getESTATUS_GENERAL().equals("ACTIVO")) {

                            beca = beca + 1;
                        }

                    }

                    datos.setALUMNOS_ACTIVOS_GENERAL(String.valueOf(activo));
                    datos.setALUMNOS_INACTIVOS_GENERAL(String.valueOf(inactivo));
                    datos.setALUMNOS_EGRESADOS_GENERAL(String.valueOf(egresados));
                    datos.setTOTAL_ALUMNOS_DUAL(String.valueOf(activo + inactivo + egresados));
                    datos.setTOTAL_HOMBRE_GENERAL(String.valueOf(hombre));
                    datos.setTOTAL_MUJER_GENERAL(String.valueOf(mujer));
                    datos.setTOTAL_BECA_GENERAL(String.valueOf(beca));

                    ListaTotalEstatusUGeneral = con.listaTotalEstatusGeneral(datos);

                    ListaMunicipioEscuela = con.listaMunEscGeneral(datos);
                    ListaEmpresasAlumnos = con.listaEmpAluGeneral(datos);

                    System.out.println("voy a calcular proyectos");
                    ListaProyectos = con.proyectosGeneral(datos);

                    Iterator LP = ListaProyectos.iterator();

                    DatosBean obj3;

                    while (LP.hasNext()) {
                        obj3 = (DatosBean) LP.next();

                        datos.setTOTAL_PROYECTOS(obj3.getTOTAL_PROYECTOS());
                        datos.setTOTAL_REINGRESOS(obj3.getTOTAL_REINGRESOS());
                        datos.setTOTAL_BECAS(obj3.getTOTAL_BECAS());

                    }

                    ListaTotalEstatus = con.listaTotalEstatus(datos);
                    ListaTotalEsuela = con.listaTotalEscuela(datos);
                    
                    
                    ListaCarreraAlumnos = con.listaCarreraAlu(datos);
                    
                    ListaAvanceMetas= con.listaAvanceMetas(datos);
                    
                    ListaAlumnosNuevos= con.listaAlumnosNuevos(datos);
                       
                    ListaAlumnosReingresos= con.listaAlumnosReingreso(datos);
                    
                    
                  
                    
                    

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
                                ListaTipoAlumno = con.ConsultaTipoAlumno();
                                ListaAlumnosBeca = (ArrayList<DatosBean>) con.listaAlumnosBeca(datos);

                               
                    

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

    public String MuestraMenuPrincipalUsuario2() {

        cveusuario = "DGES";
        pasusuario = "YCFJUKFQ";

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
                    int beca = 0;

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

                      /*  if (obj.getFECHA_REG() != null) {
                            fechaReg = format.parse(obj.getFECHA_REG());
                            if (fechaReg.after(fechainicio) && fechaReg.before(fechatermino) || fechaReg.equals(fechainicio) || fechaReg.equals(fechatermino)) {

                                nuevos = nuevos + 1;
                            }
                        }*/

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

                    activo = 0;
                    inactivo = 0;
                    egresados = 0;
                    hombre = 0;
                    mujer = 0;
                    beca = 0;

                    ListaAlumnosDashboardUGeneral = con.listaAlumnosDashboardGeneral(datos);

                    Iterator LADUG = ListaAlumnosDashboardUGeneral.iterator();
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
                        if (obj2.getSEXO().equals("HOMBRE")) {

                            hombre = hombre + 1;
                        }
                        if (obj2.getSEXO().equals("MUJER")) {

                            mujer = mujer + 1;
                        }

                        if (obj2.getBECA().equals("si") && obj2.getESTATUS_GENERAL().equals("ACTIVO")) {

                            beca = beca + 1;
                        }

                    }

                    datos.setALUMNOS_ACTIVOS_GENERAL(String.valueOf(activo));
                    datos.setALUMNOS_INACTIVOS_GENERAL(String.valueOf(inactivo));
                    datos.setALUMNOS_EGRESADOS_GENERAL(String.valueOf(egresados));
                    datos.setTOTAL_ALUMNOS_DUAL(String.valueOf(activo + inactivo + egresados));
                    datos.setTOTAL_HOMBRE_GENERAL(String.valueOf(hombre));
                    datos.setTOTAL_MUJER_GENERAL(String.valueOf(mujer));
                    datos.setTOTAL_BECA_GENERAL(String.valueOf(beca));

                    ListaTotalEstatusUGeneral = con.listaTotalEstatusGeneral(datos);

                    ListaMunicipioEscuela = con.listaMunEscGeneral(datos);
                    ListaEmpresasAlumnos = con.listaEmpAluGeneral(datos);

                    System.out.println("voy a calcular proyectos");
                    ListaProyectos = con.proyectosGeneral(datos);

                    Iterator LP = ListaProyectos.iterator();

                    DatosBean obj3;

                    while (LP.hasNext()) {
                        obj3 = (DatosBean) LP.next();

                        datos.setTOTAL_PROYECTOS(obj3.getTOTAL_PROYECTOS());
                        datos.setTOTAL_REINGRESOS(obj3.getTOTAL_REINGRESOS());
                        datos.setTOTAL_BECAS(obj3.getTOTAL_BECAS());

                    }

                    ListaTotalEstatus = con.listaTotalEstatus(datos);
                    ListaTotalEsuela = con.listaTotalEscuela(datos);

                    return "SUCCESS3";

                } else {
                    addActionError("***** Usuario con perfil no valido, favor de verificar ***** ");
                    return "ERROR";
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

    public String MuestraMenuPrincipalUsuarioT() {

        cveusuario = "DGES";
        pasusuario = "YCFJUKFQ";

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
                    int beca = 0;

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

                      /*  if (obj.getFECHA_REG() != null) {
                            fechaReg = format.parse(obj.getFECHA_REG());
                            if (fechaReg.after(fechainicio) && fechaReg.before(fechatermino) || fechaReg.equals(fechainicio) || fechaReg.equals(fechatermino)) {

                                nuevos = nuevos + 1;
                            }
                        }*/

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

                    activo = 0;
                    inactivo = 0;
                    egresados = 0;
                    hombre = 0;
                    mujer = 0;
                    beca = 0;

                    ListaAlumnosDashboardUGeneral = con.listaAlumnosDashboardGeneral(datos);

                    Iterator LADUG = ListaAlumnosDashboardUGeneral.iterator();
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
                        if (obj2.getSEXO().equals("HOMBRE")) {

                            hombre = hombre + 1;
                        }
                        if (obj2.getSEXO().equals("MUJER")) {

                            mujer = mujer + 1;
                        }

                        if (obj2.getBECA().equals("si") && obj2.getESTATUS_GENERAL().equals("ACTIVO")) {

                            beca = beca + 1;
                        }

                    }

                    datos.setALUMNOS_ACTIVOS_GENERAL(String.valueOf(activo));
                    datos.setALUMNOS_INACTIVOS_GENERAL(String.valueOf(inactivo));
                    datos.setALUMNOS_EGRESADOS_GENERAL(String.valueOf(egresados));
                    datos.setTOTAL_ALUMNOS_DUAL(String.valueOf(activo + inactivo + egresados));
                    datos.setTOTAL_HOMBRE_GENERAL(String.valueOf(hombre));
                    datos.setTOTAL_MUJER_GENERAL(String.valueOf(mujer));
                    datos.setTOTAL_BECA_GENERAL(String.valueOf(beca));

                    ListaTotalEstatusUGeneral = con.listaTotalEstatusGeneral(datos);

                    ListaMunicipioEscuela = con.listaMunEscGeneral(datos);
                    ListaEmpresasAlumnos = con.listaEmpAluGeneral(datos);

                    System.out.println("voy a calcular proyectos");
                    ListaProyectos = con.proyectosGeneral(datos);

                    Iterator LP = ListaProyectos.iterator();

                    DatosBean obj3;

                    while (LP.hasNext()) {
                        obj3 = (DatosBean) LP.next();

                        datos.setTOTAL_PROYECTOS(obj3.getTOTAL_PROYECTOS());
                        datos.setTOTAL_REINGRESOS(obj3.getTOTAL_REINGRESOS());
                        datos.setTOTAL_BECAS(obj3.getTOTAL_BECAS());

                    }

                    ListaTotalEstatus = con.listaTotalEstatus(datos);
                    ListaTotalEsuela = con.listaTotalEscuela(datos);

                    return "SUCCESS3";

                } else {
                    addActionError("***** Usuario con perfil no valido, favor de verificar ***** ");
                    return "ERROR";

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

    public List<DatosBean> getListaCarreraAlumnos() {
        return ListaCarreraAlumnos;
    }

    public void setListaCarreraAlumnos(List<DatosBean> ListaCarreraAlumnos) {
        this.ListaCarreraAlumnos = ListaCarreraAlumnos;
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

    public List<DatosBean> getListaTotalEstatus() {
        return ListaTotalEstatus;
    }

    public void setListaTotalEstatus(List<DatosBean> ListaTotalEstatus) {
        this.ListaTotalEstatus = ListaTotalEstatus;
    }

    public List<DatosBean> getListaAlumnosDashboard() {
        return ListaAlumnosDashboard;
    }

    public void setListaAlumnosDashboard(List<DatosBean> ListaAlumnosDashboard) {
        this.ListaAlumnosDashboard = ListaAlumnosDashboard;
    }

    public boolean isBantablero() {
        return bantablero;
    }

    public void setBantablero(boolean bantablero) {
        this.bantablero = bantablero;
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public List<DatosBean> getListaTotalEsuela() {
        return ListaTotalEsuela;
    }

    public void setListaTotalEsuela(List<DatosBean> ListaTotalEsuela) {
        this.ListaTotalEsuela = ListaTotalEsuela;
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

    public List<DatosBean> getListaMunicipioEscuela() {
        return ListaMunicipioEscuela;
    }

    public void setListaMunicipioEscuela(List<DatosBean> ListaMunicipioEscuela) {
        this.ListaMunicipioEscuela = ListaMunicipioEscuela;
    }

    public List<DatosBean> getListaEmpresasAlumnos() {
        return ListaEmpresasAlumnos;
    }

    public void setListaEmpresasAlumnos(List<DatosBean> ListaEmpresasAlumnos) {
        this.ListaEmpresasAlumnos = ListaEmpresasAlumnos;
    }

    public List<DatosBean> getListaTotalEstatusUGeneral() {
        return ListaTotalEstatusUGeneral;
    }

    public void setListaTotalEstatusUGeneral(List<DatosBean> ListaTotalEstatusUGeneral) {
        this.ListaTotalEstatusUGeneral = ListaTotalEstatusUGeneral;
    }

    public List<DatosBean> getListaAvanceMetas() {
        return ListaAvanceMetas;
    }

    public void setListaAvanceMetas(List<DatosBean> ListaAvanceMetas) {
        this.ListaAvanceMetas = ListaAvanceMetas;
    }

    public List<DatosBean> getListaAlumnosNuevos() {
        return ListaAlumnosNuevos;
    }

    public void setListaAlumnosNuevos(List<DatosBean> ListaAlumnosNuevos) {
        this.ListaAlumnosNuevos = ListaAlumnosNuevos;
    }

    public List<DatosBean> getListaAlumnosReingresos() {
        return ListaAlumnosReingresos;
    }

    public void setListaAlumnosReingresos(List<DatosBean> ListaAlumnosReingresos) {
        this.ListaAlumnosReingresos = ListaAlumnosReingresos;
    }
    
    
    

}
