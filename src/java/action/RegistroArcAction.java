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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.html.HTML;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.interceptor.SessionAware;

import utilidades.Constantes;

public class RegistroArcAction extends ActionSupport implements SessionAware {

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
    ConsultaDatosRenapo service = null;
    ConsultaRenapoPorCurp port;
    PersonasDTO personas;

    //conexiones................................PARA LAS LISTAS
    Statement objConexion;
    PreparedStatement objPreConexion;
    Connection conecta;

    DatosBean datos = new DatosBean();

    private boolean banT;
    private boolean BanListaCarreraError;
    private boolean BanCarreraAgregada;
    private boolean BanCarreraEliminada;
    private boolean BanCarreraExistente;

    private boolean BanDatosCorrectos;
    private boolean BanArchivoProcesado;

    private boolean BanArchivoCarrera = false;
    private boolean BanArchivoResponsables = false;
    private boolean BanArchivoAlumnos = false;

    //************************************ banderas Responsables************************************************
    private boolean banTR;
    private boolean BanListaResponsableError;
    private boolean BanResponsableExistente;
    private boolean BanListaResponsablesErrorRenapo;
    private boolean BanDatosCorrectosR;
    private boolean BanArchivoProcesadoR;

    //************************************ banderas AsesoresI************************************************
    private boolean banTAI;
    private boolean BanListaAsesorIError;
    private boolean BanListaAsesorIErrorRenapo;
    private boolean BanAsesorIExistente;
    private boolean BanDatosCorrectosAI;
    private boolean BanArchivoProcesadoAI;

    //***********************************banderas alumnos******************************************************
    private boolean banTA;
    private boolean BanListaAlumnosError;
    private boolean BanAlumnosExistente;
    private boolean BanDatosCorrectosA;
    private boolean BanArchivoProcesadoA;
    private boolean BanListaErrorRenapo;

    private boolean BanArcchivoFaltante = true;

    private String archiFileName;
    private File archi;

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

                if (ObtenerCarreraCCT.size() > 0) {
                    BanDatosCorrectos = true;
                } else {
                    BanDatosCorrectos = false;
                }

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

                if (ObtenerCarreraCCT.size() > 0) {
                    BanDatosCorrectos = true;
                } else {
                    BanDatosCorrectos = false;
                }

            }

            VerificaArchivos = con.verificaRegistroArchivo(datos.getCCT());

            if (VerificaArchivos.size() > 0) {

                Iterator VA = VerificaArchivos.iterator();
                VerificaArchivoBean valor;

                while (VA.hasNext()) {
                    valor = (VerificaArchivoBean) VA.next();

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
                }
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

            if (ObtenerCarreraCCT.size() > 0) {
                BanDatosCorrectos = true;
            } else {
                BanDatosCorrectos = false;
                datos.setSTATUS("no");
                con.ActualizaDocCar(datos);
            }

            VerificaArchivos = con.verificaRegistroArchivo(datos.getCCT());

            if (VerificaArchivos.size() > 0) {

                Iterator VA = VerificaArchivos.iterator();
                VerificaArchivoBean valor;

                while (VA.hasNext()) {
                    valor = (VerificaArchivoBean) VA.next();

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

                }
            }

            return "SUCCESS";
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    //************************************************************archivo de responsables*****************************************************************
    public String validaArchivoResponsable() {

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
            String ruta = null;

            ConsultasBusiness con = new ConsultasBusiness();

            //agregando la validacion de tipo de archivo..
            Constantes.enviaMensajeConsola("--EL ARCHIVO DE RESPONSABLES ES .... " + archiFileName);

            if (archiFileName != null) {

                //Constantes.enviaMensajeConsola("--entre a validar el tipo de arcivo.... " + sitio.getTIP_MSJ());
                if ((!archiFileName.contains(".xlsx"))) {
                    archiFileName = "";
                    addFieldError("archiR", "*** La extensión del archivo no es aceptada debe ser (xlsx)***");
                    banTR = true;
                }

                //if (archiFileName.length() > 2097152 ) 
                if (16777126 <= FileUtils.sizeOf(archi)) {
                    addFieldError("archiR", "*** No se permiten archivos mayores a 15MB ***");
                    banT = true;
                }

                if (!banTR) {

                    Constantes.enviaMensajeConsola("paso el banTR");
                    ruta = Constantes.rutaArch + archiFileName;
                    File newarch = new File(ruta);
                    FileUtils.copyFile(archi, newarch);

                    String rutaArchivoExcel = ruta;
                    String Resultado1 = null;
                    String Resultado2 = null;
                    String Resultado3 = null;

                    Constantes.enviaMensajeConsola("ruta: " + rutaArchivoExcel);
                    // valida cabecera
                    Resultado1 = ValidaCabeceraR(rutaArchivoExcel);

                    Constantes.enviaMensajeConsola("regreso de valida: " + Resultado1);
                    if (Resultado1.equals("Correcto")) {
                        limpiar();
                        Resultado2 = VerificaContenidoR(rutaArchivoExcel);

                        if (Resultado2.equals("Valido")) {
                            limpiar();
                            Resultado3 = ValidaRenapoR(rutaArchivoExcel);
                            if (Resultado3.equals("ValidoRenapo")) {
                                limpiar();

                                GuardaDatosResponsable(rutaArchivoExcel);

                                VerificaArchivos = con.verificaRegistroArchivo(datos.getCCT());

                                if (VerificaArchivos.size() > 0) {

                                    Iterator VA = VerificaArchivos.iterator();
                                    VerificaArchivoBean valor;

                                    while (VA.hasNext()) {
                                        valor = (VerificaArchivoBean) VA.next();

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

                                    }
                                }
                            }

                        }
                    }

                }

            } else {

                addFieldError("archiR", getText("DEBÉ SELECCIONAR UN ARCHIVO"));
                return "ERROR";

            }

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String ValidaCabeceraR(String rutaArchivoExcel) {

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

            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator excel = firstSheet.iterator();

            DataFormatter formatter = new DataFormatter();
            boolean CURP = false;
            boolean NOMBRER = false;
            boolean APELLIDOPR = false;
            boolean APELLIDOMR = false;
            boolean CARGO = false;
            boolean TELEFONO = false;
            boolean EMAIL = false;
            boolean VALIDO = false;
            boolean LLENO = false;
            String Resultado = "";
            /**
             * ***************************VALIDANDO NOMBRE DE CAMPOS DE
             * CABECERA ****************
             */
            int fila = 0;

            while (excel.hasNext()) {
                Row nextRow = (Row) excel.next();
                Iterator CeldaCabecera = nextRow.cellIterator();
                System.out.println("");
                fila++;
                int i = 0;

                while (CeldaCabecera.hasNext()) {

                    Cell cell = (Cell) CeldaCabecera.next();
                    String ContenidoCabecera = formatter.formatCellValue(cell);
                    ContenidoCabecera = limpiarCadenas(ContenidoCabecera);// limpia las cadenas **********

                    i++;
                    Constantes.enviaMensajeConsola("i**:" + i);

                    if (ContenidoCabecera.equals("CURP")) {
                        Constantes.enviaMensajeConsola("CURP");
                        CURP = true;
                    }

                    if (ContenidoCabecera.equals("NOMBRE")) {
                        Constantes.enviaMensajeConsola("NOMBRE");
                        NOMBRER = true;
                    }

                    if (ContenidoCabecera.equals("APELLIDO_PATERNO")) {
                        Constantes.enviaMensajeConsola("APELLIDO_PATERNO");
                        APELLIDOPR = true;
                    }
                    if (ContenidoCabecera.equals("APELLIDO_MATERNO")) {
                        Constantes.enviaMensajeConsola("APELLIDO_MATERNO");
                        APELLIDOMR = true;
                    }
                    if (ContenidoCabecera.equals("CARGO")) {
                        Constantes.enviaMensajeConsola("CARGO");
                        CARGO = true;
                    }
                    if (ContenidoCabecera.equals("TELEFONO")) {
                        Constantes.enviaMensajeConsola("TELEFONO");
                        TELEFONO = true;
                    }
                    if (ContenidoCabecera.equals("EMAIL")) {
                        Constantes.enviaMensajeConsola("EMAIL");
                        EMAIL = true;
                    }

                    if (fila != 1) {
                        if (ContenidoCabecera.length() > 0) {
                            Constantes.enviaMensajeConsola("entro a lleno");
                            LLENO = true;
                        } else {
                            LLENO = false;
                        }

                    }

                }
                /*VALIDANDO NUMERO CAMPOS */
                if (LLENO) {
                    if (i > 7 || i < 7) {

                        Constantes.enviaMensajeConsola("entro a las i" + i);

                        Constantes.enviaMensajeConsola("Número de campos no valido");
                        addFieldError("archiR", "*** FALTAN DATOS EN LA FILA NUMERO : " + fila + " FAVOR DE VERIFICAR ***");
                        VALIDO = false;
                        break;

                    } else {
                        VALIDO = true;
                        Constantes.enviaMensajeConsola("VALIDO");
                    }
                }

            }

            if (!CURP || !NOMBRER || !APELLIDOPR || !APELLIDOMR || !CARGO || !TELEFONO || !EMAIL) {
                Constantes.enviaMensajeConsola("FALTA UN CAMPO REQUERIDO");
                addFieldError("archiR", "*** FALTA UN CAMPO REQUERIDO Ó ESTA MAL ESCRITO ALGUN ENCABEZADO FAVOR DE VERIFICAR EL ARCHIVO***");
            }

            if (CURP && NOMBRER && APELLIDOPR && APELLIDOMR && CARGO && TELEFONO && EMAIL && VALIDO) {

                Resultado = "Correcto";

            }
            return Resultado;

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String VerificaContenidoR(String rutaArchivoExcel) {

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
            boolean validaCurp = false;
            boolean validaNomR = false;
            boolean validaApePR = false;
            boolean validaApeMR = false;
            boolean validaCargo = false;
            boolean validaTelefono = false;
            boolean validaEmail = false;
            boolean lleno = false;

            String Respuesta = null;
            int fila = 0;
            int contador = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {
                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                while (contenido.hasNext()) {

                    //Constantes.enviaMensajeConsola("PASO EL WHILE");
                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;
                    Constantes.enviaMensajeConsola("fila de contenido: " + fila);

                    if (contenidoCelda.length() > 0) {

                        lleno = true;

                        if (fila >= 2 && columna == 1) {

                            boolean estatus = false;

                            datos.setCURP_RESPONSABLE(contenidoCelda);

                            Constantes.enviaMensajeConsola("CURP*******: " + datos.getCURP_RESPONSABLE());

                            estatus = validarCurp(datos.getCURP_RESPONSABLE());

                            Constantes.enviaMensajeConsola("VALOR DE ESTATUS: " + estatus);

                            if (!estatus) {
                                //Constantes.enviaMensajeConsola("curp*****************" + datos.getCURPA());
                                //Constantes.enviaMensajeConsola("LA CURP DE LA FILA " + (fila) + " NO ES VALIDA, FAVOR DE VERIFICAR LOS DATOS--------------------");
                                datos.setDESERROR("LA CURP DE LA FILA " + (fila) + " NO ES VALIDA, FAVOR DE VERIFICAR LOS DATOS");
                                validaCurp = false;
                            } else {
                                validaCurp = true;
                            }

                        }

                        if (fila >= 2 && columna == 2) {

                            datos.setNOMBRER(contenidoCelda);
                            if (ValidaCadenasN(datos.getNOMBRER())) {
                                //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DEL RESPONSABLE EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                validaNomR = false;
                            } else {
                                validaNomR = true;
                            }

                        }

                        if (fila >= 2 && columna == 3) {

                            datos.setAPELLIDOPR(contenidoCelda);

                            if (ValidaCadenasN(datos.getAPELLIDOPR())) {
                                //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DEL RESPONSABLE EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                validaApePR = false;
                            } else {
                                validaApePR = true;
                            }

                        }
                        if (fila >= 2 && columna == 4) {

                            datos.setAPELLIDOMR(contenidoCelda);

                            if (ValidaCadenasN(datos.getAPELLIDOMR())) {
                                //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO MATERNO DEL RESPONSABLE EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                validaApeMR = false;
                            } else {
                                validaApeMR = true;
                            }

                        }
                        if (fila >= 2 && columna == 5) {

                            datos.setCARGO_RESPONSABLE(contenidoCelda);

                            if (ValidaCadenas(datos.getCARGO_RESPONSABLE())) {
                                //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN CARGO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                validaCargo = false;
                            } else {
                                validaCargo = true;
                            }

                        }

                        if (fila >= 2 && columna == 6) {

                            datos.setTELEFONO_RESPONSABLE(contenidoCelda);

                            if (ValidaCadenas(datos.getTELEFONO_RESPONSABLE())) {
                                //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL TELÉFONO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                validaTelefono = false;
                            } else {
                                validaTelefono = true;
                            }

                        }
                        if (fila >= 2 && columna == 7) {

                            datos.setEMAIL_RESPONSABLE(contenidoCelda);

                            boolean valEmail = checkEmail(datos.getEMAIL_RESPONSABLE());

                            if (valEmail) {
                                validaEmail = true;
                            } else {
                                datos.setDESERROR("DEBE INGRESAR UN EMAIL VÁLIDO EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                                validaEmail = false;

                            }

                        }
                    } else {
                        lleno = false;
                        break;
                    }

                }

                Constantes.enviaMensajeConsola("fila**: " + fila);

                if (validaCurp && validaNomR && validaApePR && validaApeMR && validaCargo && validaTelefono && validaEmail) {
                    contador = contador + 1;
                } else {
                    Constantes.enviaMensajeConsola("esto recibe de lleno: " + lleno);

                    if (fila != 1 && lleno) {
                        Constantes.enviaMensajeConsola("******************DATOS CON ERRORES************");
                        Constantes.enviaMensajeConsola("Curp de responsable: " + datos.getCURP_RESPONSABLE());
                        Constantes.enviaMensajeConsola("NOMR: " + datos.getNOMBRER());
                        Constantes.enviaMensajeConsola("APEP: **************" + datos.getAPELLIDOPR());
                        Constantes.enviaMensajeConsola("APEM: **************" + datos.getAPELLIDOMR());
                        Constantes.enviaMensajeConsola("Cargo: **************" + datos.getCARGO_RESPONSABLE());
                        Constantes.enviaMensajeConsola("des error: **************" + datos.getDESERROR());

                        datos.setSTATUS("CON ERRORES");
                        //datos.setDESERROR("Datos con caracteres no permitidos en la fila " + fila + "");

                        DatosErroresBean dat = new DatosErroresBean(datos.getCURP_RESPONSABLE(), datos.getNOMBRER(), datos.getAPELLIDOPR(), datos.getAPELLIDOMR(), datos.getCARGO_RESPONSABLE(), datos.getSTATUS(), datos.getDESERROR());

                        ListaDatosResponsablesConError.add(dat);
                        Constantes.enviaMensajeConsola("LISTA DE DATOS CON ERRORES: " + ListaDatosResponsablesConError.size());

                    }

                }

            }
            Constantes.enviaMensajeConsola("salio: " + ListaDatosResponsablesConError.size());

            if (ListaDatosResponsablesConError.size() > 0) {
                Constantes.enviaMensajeConsola("no valido");
                BanListaResponsableError = true;

            } else {
                Constantes.enviaMensajeConsola("valido");
                Respuesta = "Valido";
                BanListaResponsableError = false;
            }

            return Respuesta;
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String ValidaRenapoR(String rutaArchivoExcel) {

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
            limpiar();
            String nom = null;
            String apellidop = null;
            String apellidom = null;
            String Genero = null;
            String FecNac = null;

            boolean validanomrenapo = false;
            boolean validaapeprenapo = false;
            boolean validaapemrenapo = false;
            boolean lleno = false;

            String Respuesta = null;

            int fila = 0;
            int contador = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {
                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    if (contenidoCelda.length() > 0) {

                        lleno = true;

                        //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                        if (fila >= 2 && columna == 1) {
                            datos.setCURP_RESPONSABLE(contenidoCelda);
                            Constantes.enviaMensajeConsola("curp DE RENAPO: " + datos.getCURP_RESPONSABLE());
                        }
                        if (fila >= 2 && columna == 2) {
                            datos.setNOMBRER(contenidoCelda);
                        }
                        if (fila >= 2 && columna == 3) {
                            datos.setAPELLIDOPR(contenidoCelda);
                        }

                        if (fila >= 2 && columna == 4) {
                            datos.setAPELLIDOMR(contenidoCelda);

                        }

                    } else {
                        lleno = false;
                        break;

                    }

                }
                Constantes.enviaMensajeConsola("fila en RENAPO: " + fila);
                if (fila != 1 && lleno) {

                    Constantes.enviaMensajeConsola("entro al if" + datos.getCURP_RESPONSABLE());

                    service = new ConsultaDatosRenapo();
                    port = service.getConsultaRenapoPorCurpPort();
                    personas = port.consultaPorCurp(datos.getCURP_RESPONSABLE());

                    //System.out.println("Resultado            : " + personas.getResultado());
                    //System.out.println("Codigo de error      : " + personas.getCodigoError());
                    //System.out.println("Descripcion Error    : " + personas.getDescripcionError());
                    Constantes.enviaMensajeConsola("resultado curp: " + personas.getResultado());

                    if (personas.getResultado().equals("EXITO")) {

                        nom = personas.getNombre();
                        apellidop = personas.getApellidoPaterno();
                        apellidom = personas.getApellidoMaterno();

                        nom = limpiarCadenas(nom);
                        apellidop = limpiarCadenas(apellidop);
                        apellidom = limpiarCadenas(apellidom);

                        Constantes.enviaMensajeConsola("nombre renapo: " + nom + "--------- nombre Archivo: " + datos.getNOMBRER());
                        Constantes.enviaMensajeConsola("ape p renapo: " + apellidop + "--------- a paterno Archivo: " + datos.getAPELLIDOPR());
                        Constantes.enviaMensajeConsola("ape m renapo: " + apellidom + "--------- a materno Archivo: " + datos.getAPELLIDOMR());

                        if (nom.equals(datos.getNOMBRER())) {
                            validanomrenapo = true;
                        } else {
                            validanomrenapo = false;
                        }
                        if (apellidop.equals(datos.getAPELLIDOPR())) {
                            validaapeprenapo = true;
                        } else {
                            validaapeprenapo = false;
                        }
//                      if (apellidom.equals(datos.getAPELLIDOM())) {
//                         validaapemrenapo = true;
//                      } else {
//                         validaapeprenapo = false;
//                      }

                    } else {
                        //regresa valor si la curp no existe                                                                
                        //System.out.println("Resultado            : " + personas.getResultado());
                        //System.out.println("Codigo de error      : " + personas.getCodigoError());
                        //System.out.println("Descripcion Error    : " + personas.getDescripcionError());

                        addFieldError("ErrorValCurp", personas.getDescripcionError());
                    }//

                    //Constantes.enviaMensajeConsola("fila: " + fila);
                    if (validanomrenapo && validaapeprenapo) {
                        contador = contador + 1;
                    } else {
                        if (fila != 1) {
                            datos.setSTATUS("ERROR EN DATOS");
                            if (personas.getResultado().equals("ERROR")) {
                                datos.setDESERROR("ERROR EN LA CURP DE LA FILA " + fila + " , FAVOR DE VERIFICAR");
                            } else {
                                datos.setDESERROR("EL NOMBRE DE LA CURP PROPORCIONADA EN LA FILA " + fila + " ,NO COINCIDE CON LOS DATOS DE RENAPO, RESULTADO DE RENAPO(" + nom + " " + apellidop + " " + apellidom + ")  FAVOR DE VERIFICAR");
                            }

                            DatosErroresBean ValidaError = new DatosErroresBean(datos.getCURP_RESPONSABLE(), datos.getNOMBRER(), datos.getAPELLIDOPR(), datos.getAPELLIDOMR(), datos.getSTATUS(), datos.getDESERROR());

                            DatosResponsablesValidadosRenapoConError.add(ValidaError);
                        }
                    }

                }

            }

            Constantes.enviaMensajeConsola("salio: " + DatosResponsablesValidadosRenapoConError.size());

            if (DatosResponsablesValidadosRenapoConError.size() > 0) {
                BanListaResponsablesErrorRenapo = true;

            } else {
                Respuesta = "ValidoRenapo";
                BanListaResponsablesErrorRenapo = false;
            }

            return Respuesta;

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String GuardaDatosResponsable(String rutaArchivoExcel) {

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
            conecta = con.crearConexion();
            //statement
            objConexion = con.crearStatement(conecta);
            String mensajeOK = "";

            String Respuesta = null;
            int fila = 0;

            boolean lleno = false;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {

                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    //Constantes.enviaMensajeConsola("PASO EL WHILE");
                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                    if (contenidoCelda.length() > 0) {
                        lleno = true;

                        if (fila >= 2 && columna == 1) {
                            datos.setCURP_RESPONSABLE(contenidoCelda);
                        }
                        if (fila >= 2 && columna == 2) {
                            datos.setNOMBRER(contenidoCelda);
                        }

                        if (fila >= 2 && columna == 3) {
                            datos.setAPELLIDOPR(contenidoCelda);
                        }

                        if (fila >= 2 && columna == 4) {
                            datos.setAPELLIDOMR(contenidoCelda);
                        }

                        if (fila >= 2 && columna == 5) {
                            datos.setCARGO_RESPONSABLE(contenidoCelda);
                        }
                        if (fila >= 2 && columna == 6) {
                            datos.setTELEFONO_RESPONSABLE(contenidoCelda);
                        }
                        if (fila >= 2 && columna == 7) {
                            datos.setEMAIL_RESPONSABLE(contenidoCelda);
                            datos.getEMAIL_RESPONSABLE().toLowerCase();
                        }

                    } else {
                        lleno = false;
                        break;
                    }

                }

                if (fila != 1 && lleno) {
                    Constantes.enviaMensajeConsola("curp responsable: " + datos.getCURP_RESPONSABLE());

                    VerificaResponsables.clear();

                    VerificaResponsables = (ArrayList<DatosBean>) con.ConsultaResponsable(datos);
                    Constantes.enviaMensajeConsola("tamano de verifica Responsable: " + VerificaResponsables.size());

                    if (VerificaResponsables.size() > 0) {
                        Iterator VC = VerificaResponsables.iterator();
                        DatosBean obj;

                        while (VC.hasNext()) {
                            obj = (DatosBean) VC.next();
                            datos.setCURP_RESPONSABLE(obj.getCURP_RESPONSABLE());
                            datos.setNOMBRER(obj.getNOMBRER());
                            datos.setAPELLIDOPR(obj.getAPELLIDOPR());
                            datos.setAPELLIDOMR(obj.getAPELLIDOMR());
                            datos.setCARGO_RESPONSABLE(obj.getCARGO_RESPONSABLE());
                            datos.setTELEFONO_RESPONSABLE(obj.getTELEFONO_RESPONSABLE());
                            datos.setEMAIL_RESPONSABLE(obj.getEMAIL_RESPONSABLE());
                        }

                        datos.setSTATUS("RESPONSABLE YA REGISTRADO");
                        datos.setDESERROR("YA SE ENCUENTRA REGISTRADO EL RESPONSABLE PARA ESTA INSTITUCIÓN");
                        DatosErroresBean dat = new DatosErroresBean(datos.getCURP_RESPONSABLE(), datos.getNOMBRER(), datos.getAPELLIDOPR(), datos.getAPELLIDOMR(), datos.getCARGO_RESPONSABLE(), datos.getSTATUS(), datos.getDESERROR());

                        ResponsableExistente.add(dat);
                        Constantes.enviaMensajeConsola("RESPONSABLE Existentes: " + ResponsableExistente);

                    } else {

                        datos.setSTATUS("ACTIVO");

                        con.GuardaResponsable(conecta, objPreConexion, datos);

                        datos.setDESERROR("RESPONSABLE REGISTRADO CORRECTAMENTE");

                        //aqui va metodo guardar datos.
                        DatosErroresBean Correctos = new DatosErroresBean(datos.getCURP_RESPONSABLE(), datos.getNOMBRER(), datos.getAPELLIDOPR(), datos.getAPELLIDOMR(), datos.getCARGO_RESPONSABLE(), datos.getSTATUS(), datos.getDESERROR());

                        RegistrosNuevosR.add(Correctos);

                    }
                }

            }
            if (ResponsableExistente.size() > 0) {

                BanResponsableExistente = true;
            } else {
                BanResponsableExistente = false;
            }
            if (RegistrosNuevosR.size() > 0) {
                con.ActualizaDocRes(datos);

                BanDatosCorrectosR = true;

            } else {
                BanDatosCorrectosR = false;
            }

            BanArchivoProcesadoR = true;
            addFieldError("DatosProcesadosR", "ARCHIVO PROCESADO VERIFICA DETALLES ABAJO");

            cierraConexiones();

            return Respuesta;
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    //************************************************************archivo de Asesores I*****************************************************************
    public String validaArchivoAsesorInterno() {

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
            String ruta = null;

            ConsultasBusiness con = new ConsultasBusiness();

            //agregando la validacion de tipo de archivo..
            Constantes.enviaMensajeConsola("--EL ARCHIVO DE Asesor Interno ES .... " + archiFileName);
            VerificaCarreraRegistradas = (ArrayList<DatosBean>) con.ConsultaCarreraExistente(datos);

            if (VerificaCarreraRegistradas.size() > 0) {

                if (archiFileName != null) {

                    //Constantes.enviaMensajeConsola("--entre a validar el tipo de arcivo.... " + sitio.getTIP_MSJ());
                    if ((!archiFileName.contains(".xlsx"))) {
                        archiFileName = "";
                        addFieldError("archiAI", "*** La extensión del archivo no es aceptada debe ser (xlsx)***");
                        banTR = true;
                    }

                    //if (archiFileName.length() > 2097152 ) 
                    if (16777126 <= FileUtils.sizeOf(archi)) {
                        addFieldError("archiAI", "*** No se permiten archivos mayores a 15MB ***");
                        banT = true;
                    }

                    if (!banTR) {

                        Constantes.enviaMensajeConsola("paso el banTR");
                        ruta = Constantes.rutaArch + archiFileName;
                        File newarch = new File(ruta);
                        FileUtils.copyFile(archi, newarch);

                        String rutaArchivoExcel = ruta;
                        String Resultado1 = null;
                        String Resultado2 = null;
                        String Resultado3 = null;

                        Constantes.enviaMensajeConsola("ruta: " + rutaArchivoExcel);
                        // valida cabecera
                        Resultado1 = ValidaCabeceraAI(rutaArchivoExcel);

                        Constantes.enviaMensajeConsola("regreso de valida: " + Resultado1);
                        if (Resultado1.equals("Correcto")) {
                            limpiar();
                            Resultado2 = VerificaContenidoAI(rutaArchivoExcel);

                            if (Resultado2.equals("Valido")) {
                                limpiar();
                                Resultado3 = ValidaRenapoAI(rutaArchivoExcel);
                                if (Resultado3.equals("ValidoRenapo")) {
                                    limpiar();

                                    GuardaDatosAsesorI(rutaArchivoExcel);

                                    VerificaArchivos = con.verificaRegistroArchivo(datos.getCCT());

                                    if (VerificaArchivos.size() > 0) {

                                        Iterator VA = VerificaArchivos.iterator();
                                        VerificaArchivoBean valor;

                                        while (VA.hasNext()) {
                                            valor = (VerificaArchivoBean) VA.next();

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

                                        }
                                    }

                                }

                            }
                        }

                    }

                } else {

                    addFieldError("archiAI", getText("DEBÉ SELECCIONAR UN ARCHIVO"));
                    return "ERROR";

                }
            } else {
                addFieldError("NOCARRERAS", getText("DEBÉ AGREGAR PRIMERO EL CATALOGO DE CARRERAS, PARA PODER REGISTRAR ASESORES INSTITUCIONALES."));
                return "ERROR";

            }

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String ValidaCabeceraAI(String rutaArchivoExcel) {

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

            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator excel = firstSheet.iterator();

            DataFormatter formatter = new DataFormatter();
            boolean CURP = false;
            boolean NOMBREAI = false;
            boolean APELLIDOPAI = false;
            boolean APELLIDOMAI = false;
            boolean CVE_CAR = false;
            boolean VALIDO = false;
            String Resultado = "";
            /**
             * ***************************VALIDANDO NOMBRE DE CAMPOS DE
             * CABECERA ****************
             */
            int fila = 0;
            while (excel.hasNext()) {
                Row nextRow = (Row) excel.next();
                Iterator CeldaCabecera = nextRow.cellIterator();
                System.out.println("");
                int i = 0;
                int columna = 0;
                fila++;
                while (CeldaCabecera.hasNext()) {

                    Cell cell = (Cell) CeldaCabecera.next();
                    String ContenidoCabecera = formatter.formatCellValue(cell);

                    ContenidoCabecera = limpiarCadenas(ContenidoCabecera);// limpia las cadenas **********
                    //Constantes.enviaMensajeConsola("celda:" + contenidoCelda);
                    i++;
                    columna++;
                    if (ContenidoCabecera.equals("CURP")) {
                        Constantes.enviaMensajeConsola("CURP");
                        CURP = true;
                    }

                    if (ContenidoCabecera.equals("NOMBRE")) {
                        Constantes.enviaMensajeConsola("NOMBRE");
                        NOMBREAI = true;
                    }

                    if (ContenidoCabecera.equals("APELLIDO_PATERNO")) {
                        Constantes.enviaMensajeConsola("APELLIDO_PATERNO");
                        APELLIDOPAI = true;
                    }
                    if (ContenidoCabecera.equals("APELLIDO_MATERNO")) {
                        Constantes.enviaMensajeConsola("APELLIDO_MATERNO");
                        APELLIDOMAI = true;
                    }
                    if (ContenidoCabecera.equals("CVE_CARRERA")) {
                        Constantes.enviaMensajeConsola("CVE_CARRERA");
                        CVE_CAR = true;
                    }

                }
                /*VALIDANDO NUMERO CAMPOS */

                if (i > 5 || i < 5) {

                    Constantes.enviaMensajeConsola("Número de campos no valido");
                    addFieldError("archiAI", "*** FALTAN DATOS EN LA FILA NUMERO : " + fila + " FAVOR DE VERIFICAR ***");
                    VALIDO = false;
                    break;

                } else {
                    VALIDO = true;
                    //Constantes.enviaMensajeConsola("VALIDO");
                }

            }
            if (!CURP || !NOMBREAI || !APELLIDOPAI || !APELLIDOMAI || !CVE_CAR) {
                Constantes.enviaMensajeConsola("FALTA UN CAMPO REQUERIDO");
                addFieldError("archiAI", "*** FALTA UN CAMPO REQUERIDO Ó ESTA MAL ESCRITO ALGUN ENCABEZADO FAVOR DE VERIFICAR EL ARCHIVO***");
            }

            if (CURP && NOMBREAI && APELLIDOPAI && APELLIDOMAI && CVE_CAR && VALIDO) {

                Resultado = "Correcto";

            }
            return Resultado;

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String VerificaContenidoAI(String rutaArchivoExcel) {

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

            boolean validaCurp = false;
            boolean validaNomAI = false;
            boolean validaApePAI = false;
            boolean validaApeMAI = false;
            boolean validaCve_Car = false;

            String Respuesta = null;
            int fila = 0;
            int contador = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {
                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();

                fila++;
                int columna = 0;

                while (contenido.hasNext()) {

                    //Constantes.enviaMensajeConsola("PASO EL WHILE lor de fila: "+fila);
                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //.enviaMensajeConsola("fila: "+fila);
                    //Constantes.enviaMensajeConsola("columna: "+columna);
                    if (fila >= 2 && columna == 1) {

                        boolean estatus = false;

                        datos.setCURP_ASESORI(contenidoCelda);
                        estatus = validarCurp(datos.getCURP_ASESORI());

                        if (!estatus) {
                            //Constantes.enviaMensajeConsola("curp*****************" + datos.getCURPA());
                            //Constantes.enviaMensajeConsola("LA CURP DE LA FILA " + (fila) + " NO ES VALIDA, FAVOR DE VERIFICAR LOS DATOS--------------------");
                            datos.setDESERROR("LA CURP DE LA FILA " + (fila) + " NO ES VALIDA, FAVOR DE VERIFICAR LOS DATOS");
                            validaCurp = false;
                        } else {
                            validaCurp = true;
                        }

                    }

                    if (fila >= 2 && columna == 2) {

                        datos.setNOMBREAI(contenidoCelda);
                        if (ValidaCadenasN(datos.getNOMBREAI())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DEL ASESOR EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaNomAI = false;
                        } else {
                            validaNomAI = true;
                        }

                    }

                    if (fila >= 2 && columna == 3) {

                        datos.setAPELLIDOPAI(contenidoCelda);

                        if (ValidaCadenasN(datos.getAPELLIDOPAI())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DEL ASESOR EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaApePAI = false;
                        } else {
                            validaApePAI = true;
                        }

                    }
                    if (fila >= 2 && columna == 4) {

                        Constantes.enviaMensajeConsola("entro a columna 4");
                        datos.setAPELLIDOMAI(contenidoCelda);

                        if (ValidaCadenasN(datos.getAPELLIDOMAI())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO MATERNO DEL ASESOR EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaApeMAI = false;
                        } else {
                            validaApeMAI = true;
                        }

                    }
                    if (fila >= 2 && columna == 5) {
                        Constantes.enviaMensajeConsola("entro a columna 5");
                        datos.setCVE_CAR_RES(contenidoCelda);

                        if (ValidaCadenas(datos.getCVE_CAR_RES())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN LA CLAVE DE LA CARRERA  EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaCve_Car = false;
                        } else {
                            String checkCar = null;

                            checkCar = ValidaCarrera(datos);

                            if (checkCar.equals("ok")) {
                                validaCve_Car = true;
                            } else {
                                datos.setDESERROR("LA CLAVE DE LA CARRERA EN LA FILA  " + (fila) + " NO COINCIDE CON NINGUNA DE LAS CARRERAS REGISTRADAS, FAVOR DE VERIFICAR LOS DATOS");
                                validaCve_Car = false;
                            }

                        }

                    }

                }

                Constantes.enviaMensajeConsola("fila**: " + fila);
                if (validaCurp && validaNomAI && validaApePAI && validaApeMAI && validaCve_Car) {
                    contador = contador + 1;
                } else {

                    Constantes.enviaMensajeConsola("entro a else");
                    if (fila != 1) {
                        Constantes.enviaMensajeConsola("******************DATOS CON ERRORES************");
                        Constantes.enviaMensajeConsola("CSP: " + datos.getCURP_ASESORI());
                        Constantes.enviaMensajeConsola("NOMR: " + datos.getNOMBREAI());
                        Constantes.enviaMensajeConsola("APEP: **************" + datos.getAPELLIDOPAI());
                        Constantes.enviaMensajeConsola("APEM: **************" + datos.getAPELLIDOMAI());
                        Constantes.enviaMensajeConsola("CVE_CAR: **************" + datos.getCVE_CAR_RES());

                        datos.setSTATUS("CON ERRORES");
                        //datos.setDESERROR("Datos con caracteres no permitidos en la fila " + fila + "");

                        DatosErroresBean dat = new DatosErroresBean(datos.getCURP_ASESORI(), datos.getNOMBREAI(), datos.getAPELLIDOPAI(), datos.getAPELLIDOMAI(), datos.getCVE_CAR_RES(), datos.getSTATUS(), datos.getDESERROR());

                        ListaDatosAsesoresIConError.add(dat);
                        Constantes.enviaMensajeConsola("LISTA DE DATOS CON ERRORES: " + ListaDatosAsesoresIConError.size());

                    }

                }

                Constantes.enviaMensajeConsola("salio del else");

            }
            Constantes.enviaMensajeConsola("salio: " + ListaDatosAsesoresIConError.size());

            if (ListaDatosAsesoresIConError.size() > 0) {
                Constantes.enviaMensajeConsola("no valido");
                BanListaAsesorIError = true;

            } else {
                Constantes.enviaMensajeConsola("valido");
                Respuesta = "Valido";
                BanListaAsesorIError = false;
            }

            return Respuesta;
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String ValidaRenapoAI(String rutaArchivoExcel) {

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
            Constantes.enviaMensajeConsola("PASO EL WHILE");
            limpiar();
            String nom = null;
            String apellidop = null;
            String apellidom = null;

            boolean validanomrenapo = false;
            boolean validaapeprenapo = false;

            String Respuesta = null;

            int fila = 0;
            int contador = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {
                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                    if (fila >= 2 && columna == 1) {
                        datos.setCURP_ASESORI(contenidoCelda);
                        Constantes.enviaMensajeConsola("curp: " + datos.getCURP_ASESORI());
                    }
                    if (fila >= 2 && columna == 2) {
                        datos.setNOMBREAI(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 3) {
                        datos.setAPELLIDOPAI(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 4) {
                        datos.setAPELLIDOMAI(contenidoCelda);

                    }

                }

                service = new ConsultaDatosRenapo();
                port = service.getConsultaRenapoPorCurpPort();
                personas = port.consultaPorCurp(datos.getCURP_ASESORI());

                //System.out.println("Resultado            : " + personas.getResultado());
                //System.out.println("Codigo de error      : " + personas.getCodigoError());
                //System.out.println("Descripcion Error    : " + personas.getDescripcionError());
                Constantes.enviaMensajeConsola("resultado curp: " + personas.getResultado());

                if (personas.getResultado().equals("EXITO")) {

                    nom = personas.getNombre();
                    apellidop = personas.getApellidoPaterno();
                    apellidom = personas.getApellidoMaterno();

                    nom = limpiarCadenas(nom);
                    apellidop = limpiarCadenas(apellidop);
                    apellidom = limpiarCadenas(apellidom);

                    Constantes.enviaMensajeConsola("nombre renapo: " + nom + "--------- nombre Archivo: " + datos.getNOMBREAI());
                    Constantes.enviaMensajeConsola("ape p renapo: " + apellidop + "--------- a paterno Archivo: " + datos.getAPELLIDOPAI());
                    Constantes.enviaMensajeConsola("ape m renapo: " + apellidom + "--------- a materno Archivo: " + datos.getAPELLIDOMAI());

                    if (nom.equals(datos.getNOMBREAI())) {
                        validanomrenapo = true;
                    } else {
                        validanomrenapo = false;
                    }
                    if (apellidop.equals(datos.getAPELLIDOPAI())) {
                        validaapeprenapo = true;
                    } else {
                        validaapeprenapo = false;
                    }
//                      if (apellidom.equals(datos.getAPELLIDOM())) {
//                         validaapemrenapo = true;
//                      } else {
//                         validaapeprenapo = false;
//                      }

                } else {
                    //regresa valor si la curp no existe                                                                
                    //System.out.println("Resultado            : " + personas.getResultado());
                    //System.out.println("Codigo de error      : " + personas.getCodigoError());
                    //System.out.println("Descripcion Error    : " + personas.getDescripcionError());

                    addFieldError("ErrorValCurp", personas.getDescripcionError());
                }//

                //Constantes.enviaMensajeConsola("fila: " + fila);
                if (validanomrenapo && validaapeprenapo) {
                    contador = contador + 1;
                } else {
                    if (fila != 1) {
                        datos.setSTATUS("ERROR EN DATOS");
                        if (personas.getResultado().equals("ERROR")) {
                            datos.setDESERROR("ERROR EN LA CURP DE LA FILA " + fila + " , FAVOR DE VERIFICAR");
                        } else {
                            datos.setDESERROR("EL NOMBRE DE LA CURP PROPORCIONADA EN LA FILA " + fila + " ,NO COINCIDE CON LOS DATOS DE RENAPO, RESULTADO DE RENAPO(" + nom + " " + apellidop + " " + apellidom + ")  FAVOR DE VERIFICAR");
                        }

                        DatosErroresBean ValidaError = new DatosErroresBean(datos.getCURP_ASESORI(), datos.getNOMBREAI(), datos.getAPELLIDOPAI(), datos.getAPELLIDOMAI(), datos.getSTATUS(), datos.getDESERROR());

                        DatosAsesorValidadosRenapoConError.add(ValidaError);
                    }
                }

            }

            Constantes.enviaMensajeConsola("salio: " + DatosAsesorValidadosRenapoConError.size());

            if (DatosAsesorValidadosRenapoConError.size() > 0) {
                BanListaAsesorIErrorRenapo = true;

            } else {
                Respuesta = "ValidoRenapo";
                BanListaAsesorIErrorRenapo = false;
            }

            return Respuesta;

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String GuardaDatosAsesorI(String rutaArchivoExcel) {

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
            conecta = con.crearConexion();
            //statement
            objConexion = con.crearStatement(conecta);
            String mensajeOK = "";

            String Respuesta = null;
            int fila = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {

                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    //Constantes.enviaMensajeConsola("PASO EL WHILE");
                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                    if (fila >= 2 && columna == 1) {
                        datos.setCURP_ASESORI(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 2) {
                        datos.setNOMBREAI(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 3) {
                        datos.setAPELLIDOPAI(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 4) {
                        datos.setAPELLIDOMAI(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 5) {
                        datos.setCVE_CAR_RES(contenidoCelda);
                    }

                }

                if (fila != 1) {
                    Constantes.enviaMensajeConsola("curp sp: " + datos.getCURP_ASESORI());

                    VerificaAsesores.clear();

                    VerificaAsesores = (ArrayList<DatosBean>) con.ConsultaAsesorI(datos);
                    Constantes.enviaMensajeConsola("tamano de verifica Responsable: " + VerificaAsesores.size());

                    if (VerificaAsesores.size() > 0) {
                        Iterator VC = VerificaAsesores.iterator();
                        DatosBean obj;

                        while (VC.hasNext()) {
                            obj = (DatosBean) VC.next();
                            datos.setCURP_ASESORI(obj.getCURP_ASESORI());
                            datos.setNOMBREAI(obj.getNOMBREAI());
                            datos.setAPELLIDOPAI(obj.getAPELLIDOPAI());
                            datos.setAPELLIDOMAI(obj.getAPELLIDOMAI());
                            datos.setCVE_CAR_RES(obj.getCVE_CAR_RES());

                        }

                        datos.setSTATUS("ASESOR INSTITUCIONAL YA REGISTRADO");
                        datos.setDESERROR("YA SE ENCUENTRA REGISTRADO EL ASESOR INSTITUCIONAL PARA ESTA CARRERA");
                        DatosErroresBean dat = new DatosErroresBean(datos.getCURP_ASESORI(), datos.getNOMBREAI(), datos.getAPELLIDOPAI(), datos.getAPELLIDOMAI(), datos.getCVE_CAR_RES(), datos.getSTATUS(), datos.getDESERROR());

                        AsesoresIExistente.add(dat);
                        Constantes.enviaMensajeConsola("ASESOR Existentes: " + AsesoresIExistente);

                    } else {

                        datos.setSTATUS("ACTIVO");

                        con.GuardaAsesorI(conecta, objPreConexion, datos);

                        datos.setDESERROR("ASESOR INTERNO REGISTRADO CORRECTAMENTE");

                        //aqui va metodo guardar datos.
                        DatosErroresBean Correctos = new DatosErroresBean(datos.getCURP_ASESORI(), datos.getNOMBREAI(), datos.getAPELLIDOPAI(), datos.getAPELLIDOMAI(), datos.getCVE_CAR_RES(), datos.getSTATUS(), datos.getDESERROR());

                        RegistrosNuevosAI.add(Correctos);

                    }
                }

            }
            if (AsesoresIExistente.size() > 0) {

                BanAsesorIExistente = true;
            } else {
                BanAsesorIExistente = false;
            }
            if (RegistrosNuevosAI.size() > 0) {
                con.ActualizaDocAI(datos);

                BanDatosCorrectosAI = true;

            } else {
                BanDatosCorrectosAI = false;
            }

            BanArchivoProcesadoAI = true;
            addFieldError("DatosProcesadosAI", "ARCHIVO PROCESADO VERIFICA DETALLES ABAJO");

            cierraConexiones();

            return Respuesta;
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    //**********************************************************archivo alumnos***************************************************************************
    public String validaArchivoAlumnos() {

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
            String ruta = null;

            ConsultasBusiness con = new ConsultasBusiness();

            //agregando la validacion de tipo de archivo..
            Constantes.enviaMensajeConsola("--EL ARCHIVO DE ALUMNSO ES .... " + archiFileName);
            VerificaCarreraRegistradas = (ArrayList<DatosBean>) con.ConsultaCarreraExistente(datos);

            if (VerificaCarreraRegistradas.size() > 0) {
                if (archiFileName != null) {

                    //Constantes.enviaMensajeConsola("--entre a validar el tipo de arcivo.... " + sitio.getTIP_MSJ());
                    if ((!archiFileName.contains(".xlsx"))) {
                        archiFileName = "";
                        addFieldError("archiA", "*** La extensión del archivo no es aceptada debe ser (xlsx)***");
                        banT = true;
                    }

                    //if (archiFileName.length() > 2097152 ) 
                    if (16777126 <= FileUtils.sizeOf(archi)) {
                        addFieldError("archiA", "*** No se permiten archivos mayores a 15MB ***");
                        banT = true;
                    }

                    if (!banT) {

                        Constantes.enviaMensajeConsola("paso el banT");
                        ruta = Constantes.rutaArch + archiFileName;
                        File newarch = new File(ruta);
                        FileUtils.copyFile(archi, newarch);

                        String rutaArchivoExcel = ruta;
                        String Resultado1 = null;
                        String Resultado2 = null;
                        String Resultado3 = null;

                        Constantes.enviaMensajeConsola("ruta: " + rutaArchivoExcel);

                        // valida cabecera
                        Resultado1 = ValidaCabeceraA(rutaArchivoExcel);

                        Constantes.enviaMensajeConsola("regreso de valida: " + Resultado1);
                        if (Resultado1.equals("Correcto")) {
                            limpiar();
                            Resultado2 = VerificaContenidoA(rutaArchivoExcel);

                            if (Resultado2.equals("Valido")) {
                                limpiar();
                                Resultado3 = ValidaRenapo(rutaArchivoExcel);

                                if (Resultado3.equals("ValidoRenapo")) {
                                    limpiar();
                                    GuardaDatosA(rutaArchivoExcel);

                                    VerificaArchivos = con.verificaRegistroArchivo(datos.getCCT());

                                    if (VerificaArchivos.size() > 0) {

                                        Iterator VA = VerificaArchivos.iterator();
                                        VerificaArchivoBean valor;

                                        while (VA.hasNext()) {
                                            valor = (VerificaArchivoBean) VA.next();

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

                                        }
                                    }

                                }

                            }
                        }

                    }

                } else {

                    addFieldError("archiA", getText("DEBÉ SELECCIONAR UN ARCHIVO"));
                    return "ERROR";

                }
            } else {
                addFieldError("NOCARRERASA", getText("DEBÉ AGREGAR PRIMERO EL CATALOGO DE CARRERAS, PARA PODER REGISTRAR ALUMNOS."));
                return "ERROR";

            }

            return "SUCCESS";

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }
    }

    public String ValidaCabeceraA(String rutaArchivoExcel) {

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

            FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator excel = firstSheet.iterator();

            DataFormatter formatter = new DataFormatter();
            boolean MATRICULA = false;
            boolean CURP = false;
            boolean APATERNO = false;
            boolean AMATERNO = false;
            boolean NOMBRE = false;
            boolean DOMICILIO = false;
            boolean COLONIA = false;
            boolean CP = false;
            boolean CVE_MUNICIPIO = false;
            boolean TELEFONO = false;
            boolean EMAIL = false;
            boolean CVE_CAR = false;
            boolean CUATRI_CURSA = false;
            boolean PROMEDIOGRAL = false;
            boolean SITUACIONACA = false;
            boolean TIPO_ALUMNO = false;
            boolean FECHA_INGRESO = false;
            boolean VALIDO = false;
            String Resultado = "";
            /**
             * ***************************VALIDANDO NOMBRE DE CAMPOS DE
             * CABECERA ****************
             */
            int fila = 0;
            while (excel.hasNext()) {
                Row nextRow = (Row) excel.next();
                Iterator CeldaCabecera = nextRow.cellIterator();
                System.out.println("");
                int i = 0;
                int columna = 0;
                fila++;
                while (CeldaCabecera.hasNext()) {
                    Cell cell = (Cell) CeldaCabecera.next();
                    String ContenidoCabecera = formatter.formatCellValue(cell);
                    ContenidoCabecera = limpiarCadenas(ContenidoCabecera);// limpia las cadenas **********
                    //Constantes.enviaMensajeConsola("celda:" + contenidoCelda);
                    i++;
                    columna++;
                    if (ContenidoCabecera.equals("MATRICULA")) {
                        Constantes.enviaMensajeConsola("MATRICULA ");
                        MATRICULA = true;
                    }

                    if (ContenidoCabecera.equals("CURP")) {
                        Constantes.enviaMensajeConsola("CURP ");
                        CURP = true;
                    }

                    if (ContenidoCabecera.equals("APATERNO")) {
                        Constantes.enviaMensajeConsola("APATERNO ");
                        APATERNO = true;
                    }

                    if (ContenidoCabecera.equals("AMATERNO")) {
                        Constantes.enviaMensajeConsola("AMATERNO ");
                        AMATERNO = true;
                    }

                    if (ContenidoCabecera.equals("NOMBRE")) {
                        Constantes.enviaMensajeConsola("NOMBRE ");
                        NOMBRE = true;
                    }
                    if (ContenidoCabecera.equals("DOMICILIO")) {
                        Constantes.enviaMensajeConsola("DOMICILIO ");
                        DOMICILIO = true;
                    }
                    if (ContenidoCabecera.equals("COLONIA")) {
                        Constantes.enviaMensajeConsola("COLONIA ");
                        COLONIA = true;
                    }
                    if (ContenidoCabecera.equals("CP")) {
                        Constantes.enviaMensajeConsola("CP ");
                        CP = true;
                    }
                    if (ContenidoCabecera.equals("CVE_MUNICIPIO")) {
                        Constantes.enviaMensajeConsola("CVE_MUNICIPIO ");
                        CVE_MUNICIPIO = true;
                    }
                    if (ContenidoCabecera.equals("TELEFONO")) {
                        Constantes.enviaMensajeConsola("TELEFONO ");
                        TELEFONO = true;
                    }
                    if (ContenidoCabecera.equals("EMAIL")) {
                        Constantes.enviaMensajeConsola("EMAIL ");
                        EMAIL = true;
                    }
                    if (ContenidoCabecera.equals("CLAVE_CARRERA")) {
                        Constantes.enviaMensajeConsola("CLAVE_CARRERA ");
                        CVE_CAR = true;
                    }
                    if (ContenidoCabecera.equals("GRADO_QUE_CURSA")) {
                        Constantes.enviaMensajeConsola("GRADO_QUE_CURSA ");
                        CUATRI_CURSA = true;
                    }
                    if (ContenidoCabecera.equals("PROMEDIO_GENERAL")) {
                        Constantes.enviaMensajeConsola("PROMEDIO_GENERAL ");
                        PROMEDIOGRAL = true;
                    }
                    if (ContenidoCabecera.equals("SITUACION_ACADEMICA")) {
                        Constantes.enviaMensajeConsola("SITUACION_ACADEMICA ");
                        SITUACIONACA = true;
                    }
                    if (ContenidoCabecera.equals("TIPO_ALUMNO")) {
                        Constantes.enviaMensajeConsola("TIPO_ALUMNO ");
                        TIPO_ALUMNO = true;
                    }
                    if (ContenidoCabecera.equals("FECHA_INGRESO_DUAL")) {
                        Constantes.enviaMensajeConsola("FECHA_INGRESO_DUAL ");
                        FECHA_INGRESO = true;
                    }

                }
                /*VALIDANDO NUMERO CAMPOS */

                if (i > 17 || i < 17) {

                    Constantes.enviaMensajeConsola("Número de campos no valido");
                    addFieldError("archiA", "*** FALTAN DATOS EN LA FILA NUMERO : " + fila + " FAVOR DE VERIFICAR ***");
                    VALIDO = false;
                    break;

                } else {
                    VALIDO = true;
                    //Constantes.enviaMensajeConsola("VALIDO");
                }

            }
            if (!MATRICULA || !CURP || !APATERNO || !AMATERNO || !NOMBRE || !DOMICILIO || !COLONIA || !CP || !CVE_MUNICIPIO || !TELEFONO || !EMAIL || !CVE_CAR || !CUATRI_CURSA || !PROMEDIOGRAL || !SITUACIONACA || !TIPO_ALUMNO || !FECHA_INGRESO) {
                Constantes.enviaMensajeConsola("FALTA UN CAMPO REQUERIDO");
                addFieldError("archiA", "*** FALTA UN CAMPO REQUERIDO Ó ESTA MAL ESCRITO ALGUN ENCABEZADO FAVOR DE VERIFICAR EL ARCHIVO***");
            }

            if (MATRICULA && CURP && APATERNO && AMATERNO && NOMBRE && DOMICILIO && COLONIA && CP && CVE_MUNICIPIO && TELEFONO && EMAIL && CVE_CAR && CUATRI_CURSA && PROMEDIOGRAL && SITUACIONACA && TIPO_ALUMNO && FECHA_INGRESO && VALIDO) {

                Resultado = "Correcto";

            }
            return Resultado;

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String VerificaContenidoA(String rutaArchivoExcel) {

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
            boolean validaMat = false;
            boolean validacurp = false;
            boolean validanom = false;
            boolean validaapellidop = false;
            boolean validaapellidom = false;
            boolean validacvemun = false;
            boolean validaTel = false;
            boolean validaemail = false;
            boolean validacvecar = false;
            boolean validatipo_alumno = false;
            boolean validafecha_ingreso = false;

            String Respuesta = null;
            int fila = 0;
            int contador = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {
                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    //Constantes.enviaMensajeConsola("PASO EL WHILE");
                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                    if (fila >= 2 && columna == 1) {

                        datos.setMATRICULA(contenidoCelda);
                        if (ValidaMatriculas(datos.getMATRICULA())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN LA MATRICULA DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaMat = false;
                        } else {
                            validaMat = true;
                        }

                    }

                    if (fila >= 2 && columna == 2) {

                        boolean estatus = false;

                        datos.setCURP(contenidoCelda);
                        estatus = validarCurp(datos.getCURP());

                        if (!estatus) {
                            //Constantes.enviaMensajeConsola("curp*****************" + datos.getCURPA());
                            //Constantes.enviaMensajeConsola("LA CURP DE LA FILA " + (fila) + " NO ES VALIDA, FAVOR DE VERIFICAR LOS DATOS--------------------");
                            datos.setDESERROR("LA CURP DE LA FILA " + (fila) + " NO ES VALIDA, FAVOR DE VERIFICAR LOS DATOS");
                            validacurp = false;
                        } else {
                            validacurp = true;
                        }

                    }

                    if (fila >= 2 && columna == 3) {

                        datos.setAPELLIDOP(contenidoCelda);

                        if (ValidaCadenasN(datos.getAPELLIDOP())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaapellidop = false;
                        } else {
                            validaapellidop = true;
                        }

                    }

                    if (fila >= 2 && columna == 4) {
                        datos.setAPELLIDOM(contenidoCelda);

                        if (ValidaCadenasN(datos.getAPELLIDOM())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO MATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO MATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaapellidom = false;
                        } else {
                            validaapellidom = true;
                        }

                    }
                    if (fila >= 2 && columna == 5) {

                        datos.setNOMBRE(contenidoCelda);
                        if (ValidaCadenasN(datos.getNOMBRE())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL NOMBRE DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validanom = false;
                        } else {
                            validanom = true;
                        }

                    }
                    if (fila >= 2 && columna == 9) {

                        datos.setCVE_MUNA(contenidoCelda);

                        if (!esEntero(datos.getCVE_MUNA())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN LA CLAVE DE MUNICIPIO  EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS SOLO SE PERMITEN NÚMEROS");
                            validacvemun = false;
                        } else {
                            validacvemun = true;

                        }

                    }
                    if (fila >= 2 && columna == 10) {

                        datos.setTELEFONO(contenidoCelda);

                        if (ValidaCadenas(datos.getTELEFONO())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO MATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN EL TELEFONO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaTel = false;
                        } else {
                            validaTel = true;
                        }

                    }
                    if (fila >= 2 && columna == 11) {

                        datos.setCORREO(contenidoCelda);

                        boolean valEmail = checkEmail(datos.getCORREO());

                        if (valEmail) {
                            validaemail = true;
                        } else {
                            datos.setDESERROR("DEBE INGRESAR UN EMAIL VÁLIDO EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validaemail = false;

                        }
                    }
                    if (fila >= 2 && columna == 12) {

                        datos.setCVE_CAR_RES(contenidoCelda);

                        if (ValidaCadenas(datos.getCVE_CAR_RES())) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN LA CLAVE DE LA CARRERA  EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validacvecar = false;
                        } else {
                            String checkCar = null;

                            checkCar = ValidaCarrera(datos);

                            if (checkCar.equals("ok")) {
                                validacvecar = true;
                            } else {
                                datos.setDESERROR("LA CLAVE DE LA CARRERA EN LA FILA  " + (fila) + " NO COINCIDE CON NINGUNA DE LAS CARRERAS REGISTRADAS, FAVOR DE VERIFICAR LOS DATOS");
                                validacvecar = false;
                            }

                        }

                    }

                    if (fila >= 2 && columna == 16) {

                        String TipoAlumno = null;

                        TipoAlumno = contenidoCelda;

                        if (ValidaCadenas(TipoAlumno)) {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("TIENE CARACTERES NO PERMITIDOS EN TIPO DE ALUMNO EN LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            validatipo_alumno = false;
                        } else {

                            if (TipoAlumno.equals("NUEVO INGRESO")) {
                                datos.setTIPO_ALUM("1");
                                validatipo_alumno = true;
                            } else if (TipoAlumno.equals("REINGRESO")) {
                                datos.setTIPO_ALUM("2");
                                validatipo_alumno = true;
                            } else {
                                datos.setDESERROR("EL TIPO DE ALUMNO  EN LA FILA  " + (fila) + " NO COINCIDE CON NINGUNA DE LAS OPCIONES DEBE SER (NUEVO INGRESO O REINGRESO), FAVOR DE VERIFICAR LOS DATOS");
                                validatipo_alumno = false;
                            }

                        }

                    }

                    if (fila >= 2 && columna == 17) {

                        datos.setFECHA_INGRESO_DUAL(contenidoCelda);

                        if (validarFecha(datos.getFECHA_INGRESO_DUAL())) {
                            validafecha_ingreso = true;
                        } else {
                            //Constantes.enviaMensajeConsola("TIENE CARACTERES NO PERMITIDOS EN EL APELLIDO PATERNO DE LA FILA  " + (fila) + " FAVOR DE VERIFICAR LOS DATOS");
                            datos.setDESERROR("LA FECHA QUE INGRESO EN LA FILA: " + fila + " NO TIENE EL FORMATO CORRECTO dd/mm/yyyy ej..(01/01/1900) FAVOR DE VERIFICAR ");
                            validafecha_ingreso = false;

                        }

                    }

                }

                Constantes.enviaMensajeConsola("fila: " + fila);

                if (validaMat && validacurp && validanom && validaapellidop && validaapellidom && validacvemun && validaTel && validaemail && validacvecar && validatipo_alumno && validafecha_ingreso) {
                    contador = contador + 1;
                } else {
                    if (fila != 1) {
                        Constantes.enviaMensajeConsola("******************DATOS CON ERRORES************");
                        Constantes.enviaMensajeConsola("MATRICULA: " + datos.getMATRICULA());
                        Constantes.enviaMensajeConsola("la curp es: " + datos.getCURP());
                        Constantes.enviaMensajeConsola("nombre: **************" + datos.getNOMBRE());
                        Constantes.enviaMensajeConsola("apaterno: **************" + datos.getAPELLIDOP());
                        Constantes.enviaMensajeConsola("amaterno: **************" + datos.getAPELLIDOM());
                        Constantes.enviaMensajeConsola("CVE CAR: **************" + datos.getCVE_CAR_RES());
                        Constantes.enviaMensajeConsola("TELEFONO: **************" + datos.getTELEFONO());
                        Constantes.enviaMensajeConsola("EMAIL: **************" + datos.getCORREO());
                        Constantes.enviaMensajeConsola("TIPO DE ALUMNO: **************" + datos.getTIPO_ALUM());
                        Constantes.enviaMensajeConsola("FECHA DE INGRESO: **************" + datos.getFECHA_INGRESO_DUAL());

                        datos.setSTATUS("CON ERRORES");
                        //datos.setDESERROR("Datos con caracteres no permitidos en la fila " + fila + "");

                        DatosErroresBean dat = new DatosErroresBean(datos.getMATRICULA(), datos.getCURP(), datos.getNOMBRE(), datos.getAPELLIDOP(), datos.getAPELLIDOM(), datos.getCVE_CAR_RES(), datos.getTELEFONO(), datos.getCORREO(), datos.getSTATUS(), datos.getDESERROR());

                        ListaDatosAlumnosConError.add(dat);
                        Constantes.enviaMensajeConsola("LISTA DE DATOS CON ERRORES: " + ListaDatosAlumnosConError.size());

                    }

                }

            }
            Constantes.enviaMensajeConsola("salio: " + ListaDatosAlumnosConError.size());

            if (ListaDatosAlumnosConError.size() > 0) {
                Constantes.enviaMensajeConsola("no valido");
                BanListaAlumnosError = true;

            } else {
                Constantes.enviaMensajeConsola("valido");
                Respuesta = "Valido";
                BanListaAlumnosError = false;
            }

            return Respuesta;
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String ValidaRenapo(String rutaArchivoExcel) {

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
            Constantes.enviaMensajeConsola("PASO EL WHILE");

            String nom = null;
            String apellidop = null;
            String apellidom = null;
            String Genero = null;
            String FecNac = null;

            boolean validanomrenapo = false;
            boolean validaapeprenapo = false;
            boolean validaapemrenapo = false;

            String Respuesta = null;

            int fila = 0;
            int contador = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();
            limpiar();
            while (lectura.hasNext()) {
                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                    if (fila >= 2 && columna == 2) {
                        datos.setCURP(contenidoCelda);
                        Constantes.enviaMensajeConsola("curp: " + datos.getCURP());
                    }

                    if (fila >= 2 && columna == 3) {
                        datos.setAPELLIDOP(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 4) {
                        datos.setAPELLIDOM(contenidoCelda);

                    }
                    if (fila >= 2 && columna == 5) {
                        datos.setNOMBRE(contenidoCelda);
                    }

                }

                if (fila != 1) {

                    service = new ConsultaDatosRenapo();
                    port = service.getConsultaRenapoPorCurpPort();
                    personas = port.consultaPorCurp(datos.getCURP());

                    //System.out.println("Resultado            : " + personas.getResultado());
                    //System.out.println("Codigo de error      : " + personas.getCodigoError());
                    //System.out.println("Descripcion Error    : " + personas.getDescripcionError());
                    Constantes.enviaMensajeConsola("resultado curp: " + personas.getResultado());

                    if (personas.getResultado().equals("EXITO")) {

                        nom = personas.getNombre();
                        apellidop = personas.getApellidoPaterno();
                        apellidom = personas.getApellidoMaterno();

                        nom = limpiarCadenas(nom);
                        apellidop = limpiarCadenas(apellidop);
                        apellidom = limpiarCadenas(apellidom);

                        Constantes.enviaMensajeConsola("nombre renapo: " + nom + "--------- nombre Archivo: " + datos.getNOMBRE());
                        Constantes.enviaMensajeConsola("ape p renapo: " + apellidop + "--------- a paterno Archivo: " + datos.getAPELLIDOP());
                        Constantes.enviaMensajeConsola("ape m renapo: " + apellidom + "--------- a materno Archivo: " + datos.getAPELLIDOM());

                        if (nom.equals(datos.getNOMBRE())) {
                            validanomrenapo = true;
                        } else {
                            validanomrenapo = false;
                        }
                        if (apellidop.equals(datos.getAPELLIDOP())) {
                            validaapeprenapo = true;
                        } else {
                            validaapeprenapo = false;
                        }
//                      if (apellidom.equals(datos.getAPELLIDOM())) {
//                         validaapemrenapo = true;
//                      } else {
//                         validaapeprenapo = false;
//                      }

                    } else {
                        //regresa valor si la curp no existe                                                                
                        //System.out.println("Resultado            : " + personas.getResultado());
                        //System.out.println("Codigo de error      : " + personas.getCodigoError());
                        //System.out.println("Descripcion Error    : " + personas.getDescripcionError());

                        addFieldError("ErrorValCurp", personas.getDescripcionError());
                    }//
                }
                //Constantes.enviaMensajeConsola("fila: " + fila);
                if (validanomrenapo && validaapeprenapo) {
                    contador = contador + 1;
                } else {
                    if (fila != 1) {
                        datos.setSTATUS("ERROR EN DATOS");
                        if (personas.getResultado().equals("ERROR")) {
                            datos.setDESERROR("ERROR EN LA CURP DE LA FILA " + fila + " , FAVOR DE VERIFICAR");
                        } else {
                            datos.setDESERROR("EL NOMBRE EN LA CURP PROPORCIONADA DE LA FILA " + fila + " ,NO COINCIDE CON LOS DATOS DE RENAPO, RESULTADO DE RENAPO(" + nom + " " + apellidop + " " + apellidom + ")  FAVOR DE VERIFICAR");
                        }

                        DatosErroresBean ValidaError = new DatosErroresBean(datos.getCURP(), datos.getNOMBRE(), datos.getAPELLIDOP(), datos.getAPELLIDOM(), datos.getSTATUS(), datos.getDESERROR());

                        DatosAlumnosValidadosRenapoConError.add(ValidaError);
                    }
                }

            }

            Constantes.enviaMensajeConsola("salio: " + DatosAlumnosValidadosRenapoConError.size());

            if (DatosAlumnosValidadosRenapoConError.size() > 0) {
                BanListaErrorRenapo = true;

            } else {
                Respuesta = "ValidoRenapo";
                BanListaErrorRenapo = false;
            }

            return Respuesta;

        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    }

    public String GuardaDatosA(String rutaArchivoExcel) {

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
            conecta = con.crearConexion();
            //statement
            objConexion = con.crearStatement(conecta);
            String mensajeOK = "";

            String Respuesta = null;
            int fila = 0;

            FileInputStream Libro = new FileInputStream(new File(rutaArchivoExcel));
            Workbook Cont = new XSSFWorkbook(Libro);
            Sheet celdas = Cont.getSheetAt(0);
            Iterator lectura = celdas.iterator();
            DataFormatter formatter = new DataFormatter();

            while (lectura.hasNext()) {

                Row nextRow = (Row) lectura.next();
                Iterator contenido = nextRow.cellIterator();
                fila++;

                int columna = 0;
                System.out.println("");
                while (contenido.hasNext()) {

                    //Constantes.enviaMensajeConsola("PASO EL WHILE");
                    Cell cell = (Cell) contenido.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    contenidoCelda = limpiarCadenas(contenidoCelda);// limpia las cadenas **********

                    columna++;

                    //Constantes.enviaMensajeConsola("columna: " + columna + " fila: " + fila);
                    if (fila >= 2 && columna == 1) {
                        datos.setMATRICULA(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 2) {
                        datos.setCURP(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 3) {
                        datos.setAPELLIDOP(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 4) {
                        datos.setAPELLIDOM(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 5) {
                        datos.setNOMBRE(contenidoCelda);
                    }

                    if (fila >= 2 && columna == 6) {
                        datos.setDOMICILIOA(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 7) {
                        datos.setCOLONIAA(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 8) {
                        datos.setCPA(contenidoCelda);

                    }
                    if (fila >= 2 && columna == 9) {
                        datos.setCVE_MUNA(contenidoCelda);

                    }
                    if (fila >= 2 && columna == 10) {
                        datos.setTELEFONO(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 11) {
                        datos.setCORREO(contenidoCelda.toLowerCase());
                    }
                    if (fila >= 2 && columna == 12) {
                        datos.setCVE_CAR_RES(contenidoCelda);

                    }
                    if (fila >= 2 && columna == 13) {
                        datos.setGRADO_CURSA(contenidoCelda);

                    }
                    if (fila >= 2 && columna == 14) {
                        datos.setPROMEDIOGRAL(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 15) {
                        datos.setSITUACIONACA(contenidoCelda);
                    }
                    if (fila >= 2 && columna == 16) {

                        String TipoAlumno = null;

                        TipoAlumno = contenidoCelda;

                        if (TipoAlumno.equals("NUEVO INGRESO")) {
                            datos.setTIPO_ALUM("1");

                        } else if (TipoAlumno.equals("REINGRESO")) {
                            datos.setTIPO_ALUM("2");

                        }

                    }
                    if (fila >= 2 && columna == 17) {

                        datos.setFECHA_INGRESO_DUAL(contenidoCelda);

                    }

                }
                if (fila != 1) {

                    VerificaAlumnos.clear();
                    VerificaAlumnos = (ArrayList<DatosBean>) con.ConsultaAlumnos(datos);
                    Constantes.enviaMensajeConsola("tamano de verifica Responsable: " + VerificaAlumnos.size());

                    if (VerificaAlumnos.size() > 0) {
//                        Iterator VC = VerificaResponsables.iterator();
//                        DatosBean obj;
//
//                        while (VC.hasNext()) {
//                            obj = (DatosBean) VC.next();
//                            datos.setCVE_SER_PUB(obj.getCVE_SER_PUB());
//                            datos.setNOMBRER(obj.getNOMBRER());
//                            datos.setAPELLIDOPR(obj.getAPELLIDOPR());
//                            datos.setAPELLIDOMR(obj.getAPELLIDOMR());
//                            datos.setCVE_CAR_RES(obj.getCVE_CAR_RES());
//                        }

                        datos.setSTATUS("ALUMNOS YA REGISTRADO");
                        datos.setDESERROR("YA SE ENCUENTRA REGISTRADO EL ALUMNO PARA ESTA CARRERA");
                        DatosErroresBean dat = new DatosErroresBean(datos.getCURP(), datos.getNOMBRE(), datos.getAPELLIDOP(), datos.getAPELLIDOM(), datos.getSTATUS(), datos.getDESERROR());

                        AlumnosExistente.add(dat);
                        Constantes.enviaMensajeConsola("AlumnosExistente : " + AlumnosExistente);

                    } else {

                        service = new ConsultaDatosRenapo();
                        port = service.getConsultaRenapoPorCurpPort();
                        personas = port.consultaPorCurp(datos.getCURP());

                        String FecNac = null;
                        String Genero = null;

                        Constantes.enviaMensajeConsola("resultado curp: " + personas.getResultado());

                        if (personas.getResultado().equals("EXITO")) {

                            FecNac = personas.getFechaNacimientoAxu();
                            Genero = personas.getSexo();

                            if (Genero.equals("H")) {
                                datos.setSEXO("HOMBRE");

                            } else {
                                datos.setSEXO("MUJER");
                            }
                        }

                        datos.setFECNAC(FecNac);
                        datos.setSTATUS("1");
                        datos.setBECA("no");

                        con.GuardaAlumnos(conecta, objPreConexion, datos);

                        datos.setDESERROR("ALUMNO REGISTRADO CORRECTAMENTE");

                        //aqui va metodo guardar datos.
                        DatosErroresBean Correctos = new DatosErroresBean(datos.getCURP(), datos.getNOMBRE(), datos.getAPELLIDOP(), datos.getAPELLIDOM(), datos.getSTATUS(), datos.getDESERROR());
                        RegistrosNuevosA.add(Correctos);

                    }
                }

            }
            if (AlumnosExistente.size() > 0) {

                BanAlumnosExistente = true;
            } else {
                BanAlumnosExistente = false;
            }
            if (RegistrosNuevosA.size() > 0) {

                BanDatosCorrectosA = true;
                con.ActualizaDocAlu(datos);

            } else {
                BanDatosCorrectosA = false;
            }

            BanArchivoProcesadoA = true;
            addFieldError("DatosProcesadosA", "ARCHIVO PROCESADO VERIFICA DETALLES ABAJO");

            cierraConexiones();

            return Respuesta;
        } catch (Exception e) {

            TipoException = e.getMessage();
            return "ERROR";
        }

    } // FALTA AGREGAR TIPO ALU Y FECHA 

    public String ValidaCarrera(DatosBean datos) throws Exception {

        ConsultasBusiness con = new ConsultasBusiness();

        datos.setCLAVECARRERA(datos.getCVE_CAR_RES());

        ListaCarrera = (ArrayList<DatosBean>) con.ConsultaCarrera(datos);

        if (ListaCarrera.size() > 0) {
            return "ok";
        } else {
            return "error";
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
        datos.setCURPA("");
        datos.setNOMBRE("");
        datos.setAPELLIDOP("");
        datos.setAPELLIDOM("");
        datos.setSTATUS("");
        datos.setDESERROR("");

    }

    public final static String REGEX_CURP = "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]";

    public static boolean validarCurp(String textoCurp) {
        boolean curpValido = false;

        Pattern pattern = Pattern.compile(REGEX_CURP);
        Matcher matcher = pattern.matcher(textoCurp);
        curpValido = matcher.find();

        matcher = null;
        pattern = null;

        return curpValido;
    }

    public String limpiarCadenas(String cadena) {

        cadena = cadena.trim();
        cadena = cadena.toUpperCase();

        //System.out.println("cadena a mayu: "+cadena);
        if (cadena != null) {

            String original = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
            // Cadena de caracteres ASCII que reemplazarán los originales.

            String valor1 = "";
            String valor2 = "";

            for (int o = 0; o < original.length(); o++) {

                valor1 = original.substring(o, o + 1);
                //System.out.println("////////////////////valor1 "+o+" "+valor1);

                for (int i = 0; i < cadena.length(); i++) {

                    valor2 = cadena.substring(i, i + 1);
                    //System.out.println("valor2 "+i+" "+valor2);

                    if (valor1.equals(valor2)) {

                        if (valor2.equals("á")) {
                            cadena = cadena.replace(valor2, "a");

                        } else if (valor2.equals("é")) {
                            cadena = cadena.replace(valor2, "e");

                        } else if (valor2.equals("í")) {
                            cadena = cadena.replace(valor2, "i");

                        } else if (valor2.equals("ó")) {
                            cadena = cadena.replace(valor2, "o");

                        } else if (valor2.equals("ú")) {
                            cadena = cadena.replace(valor2, "u");

                        } else if (valor2.equals("ñ")) {
                            cadena = cadena.replace(valor2, "n");

                        } else if (valor2.equals("Á")) {
                            cadena = cadena.replace(valor2, "A");

                        } else if (valor2.equals("É")) {
                            cadena = cadena.replace(valor2, "E");

                        } else if (valor2.equals("Í")) {
                            cadena = cadena.replace(valor2, "I");

                        } else if (valor2.equals("Ó")) {
                            cadena = cadena.replace(valor2, "O");

                        } else if (valor2.equals("Ú")) {
                            cadena = cadena.replace(valor2, "U");

                        } else if (valor2.equals("Ñ")) {
                            cadena = cadena.replace(valor2, "N");

                        }

                    }

                }
            }
        }
        return cadena;

    }

    public boolean ValidaCadenas(String cadena) {

        cadena = cadena.trim();
        cadena = cadena.toUpperCase();

        //System.out.println("cadena a mayu: "+cadena);
        if (cadena != null) {

            String original = ",?!@#$%^&*()+<>;:{}[]'/=|";

            String valor1 = "";
            String valor2 = "";
            int contador = 0;

            for (int o = 0; o < original.length(); o++) {

                valor1 = original.substring(o, o + 1);
                //System.out.println("////////////////////valor1 "+o+" "+valor1);

                for (int i = 0; i < cadena.length(); i++) {

                    valor2 = cadena.substring(i, i + 1);
                    //System.out.println("valor2 "+i+" "+valor2);

                    if (valor1.equals(valor2)) {
                        //Constantes.enviaMensajeConsola("si paso el equal de valida cadenas");
                        contador = contador + 1;
                    }

                }
            }

            //Constantes.enviaMensajeConsola("numero del contador: "+contador);
            if (contador > 0) {
                return true;

            } else {
                return false;
            }

        }

        return true;

    }

    public boolean ValidaCadenasN(String cadena) {

        cadena = cadena.trim();
        cadena = cadena.toUpperCase();

        //System.out.println("cadena a mayu: "+cadena);
        if (cadena != null) {

            String original = "0123456789.-_,?!@#$%^&*()+<>;:{}[]'/=|";

            String valor1 = "";
            String valor2 = "";
            int contador = 0;

            for (int o = 0; o < original.length(); o++) {

                valor1 = original.substring(o, o + 1);
                //System.out.println("////////////////////valor1 "+o+" "+valor1);

                for (int i = 0; i < cadena.length(); i++) {

                    valor2 = cadena.substring(i, i + 1);
                    //System.out.println("valor2 "+i+" "+valor2);

                    if (valor1.equals(valor2)) {
                        //Constantes.enviaMensajeConsola("si paso el equal de valida cadenas");
                        contador = contador + 1;
                    }

                }
            }

            //Constantes.enviaMensajeConsola("numero del contador: "+contador);
            if (contador > 0) {
                return true;

            } else {
                return false;
            }

        }

        return true;

    }

    public boolean ValidaMatriculas(String cadena) {

        cadena = cadena.trim();
        cadena = cadena.toUpperCase();

        //System.out.println("cadena a mayu: "+cadena);
        if (cadena != null) {

            String original = "._,?!@#$%^&*()+<>;:{}[]'/=|";

            String valor1 = "";
            String valor2 = "";
            int contador = 0;

            for (int o = 0; o < original.length(); o++) {

                valor1 = original.substring(o, o + 1);
                //System.out.println("////////////////////valor1 "+o+" "+valor1);

                for (int i = 0; i < cadena.length(); i++) {

                    valor2 = cadena.substring(i, i + 1);
                    //System.out.println("valor2 "+i+" "+valor2);

                    if (valor1.equals(valor2)) {
                        //Constantes.enviaMensajeConsola("si paso el equal de valida cadenas");
                        contador = contador + 1;
                    }

                }
            }

            //Constantes.enviaMensajeConsola("numero del contador: "+contador);
            if (contador > 0) {
                return true;

            } else {
                return false;
            }

        }

        return true;

    }

    public static boolean checkEmail(String email) {
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
        // Asociar el string al patron
        Matcher m = p.matcher(email);
        // Comprobar si encaja
        return m.matches();
    }

    public boolean validarFecha(String valFecha) throws ParseException {

        Constantes.enviaMensajeConsola("entro a validar fecha " + valFecha);
        boolean Fecha = false;

        Fecha = valFecha.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");
        
        Constantes.enviaMensajeConsola("fecha: "+Fecha);
        
        if (Fecha) {
            
            Constantes.enviaMensajeConsola("entro al if");
            // el que parsea
            SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
            // el que formatea
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

            Date date = parseador.parse(valFecha);

            //System.out.println("date"+date);
            String ff = formateador.format(date);

            System.out.println(formateador.format(date));

            Fecha = ff.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");

            Constantes.enviaMensajeConsola("fecha validada es:  " + Fecha);

            return Fecha;
            
        } else {
            Fecha = false;

            return Fecha;
        }
        

        

        

    }

    public boolean esEntero(String cad) {

        for (int i = 0; i < cad.length(); i++) {
            if (!Character.isDigit(cad.charAt(i))) {
                return false;
            }
        }

        return true;
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

    public boolean isBanTR() {
        return banTR;
    }

    public void setBanTR(boolean banTR) {
        this.banTR = banTR;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public DatosBean getDatos() {
        return datos;
    }

    public void setDatos(DatosBean datos) {
        this.datos = datos;
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

    public boolean isBanT() {
        return banT;
    }

    public void setBanT(boolean banT) {
        this.banT = banT;
    }

    public boolean isBanListaCarreraError() {
        return BanListaCarreraError;
    }

    public void setBanListaCarreraError(boolean BanListaCarreraError) {
        this.BanListaCarreraError = BanListaCarreraError;
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

    public boolean isBanListaResponsableError() {
        return BanListaResponsableError;
    }

    public void setBanListaResponsableError(boolean BanListaResponsableError) {
        this.BanListaResponsableError = BanListaResponsableError;
    }

    public boolean isBanResponsableExistente() {
        return BanResponsableExistente;
    }

    public void setBanResponsableExistente(boolean BanResponsableExistente) {
        this.BanResponsableExistente = BanResponsableExistente;
    }

    public boolean isBanListaResponsablesErrorRenapo() {
        return BanListaResponsablesErrorRenapo;
    }

    public void setBanListaResponsablesErrorRenapo(boolean BanListaResponsablesErrorRenapo) {
        this.BanListaResponsablesErrorRenapo = BanListaResponsablesErrorRenapo;
    }

    public boolean isBanDatosCorrectosR() {
        return BanDatosCorrectosR;
    }

    public void setBanDatosCorrectosR(boolean BanDatosCorrectosR) {
        this.BanDatosCorrectosR = BanDatosCorrectosR;
    }

    public boolean isBanArchivoProcesadoR() {
        return BanArchivoProcesadoR;
    }

    public void setBanArchivoProcesadoR(boolean BanArchivoProcesadoR) {
        this.BanArchivoProcesadoR = BanArchivoProcesadoR;
    }

    public boolean isBanListaErrorRenapo() {
        return BanListaErrorRenapo;
    }

    public void setBanListaErrorRenapo(boolean BanListaErrorRenapo) {
        this.BanListaErrorRenapo = BanListaErrorRenapo;
    }

    public boolean isBanArcchivoFaltante() {
        return BanArcchivoFaltante;
    }

    public void setBanArcchivoFaltante(boolean BanArcchivoFaltante) {
        this.BanArcchivoFaltante = BanArcchivoFaltante;
    }

    public boolean isBanCarreraExistente() {
        return BanCarreraExistente;
    }

    public void setBanCarreraExistente(boolean BanCarreraExistente) {
        this.BanCarreraExistente = BanCarreraExistente;
    }

    public boolean isBanDatosCorrectos() {
        return BanDatosCorrectos;
    }

    public void setBanDatosCorrectos(boolean BanDatosCorrectos) {
        this.BanDatosCorrectos = BanDatosCorrectos;
    }

    public boolean isBanArchivoProcesado() {
        return BanArchivoProcesado;
    }

    public void setBanArchivoProcesado(boolean BanArchivoProcesado) {
        this.BanArchivoProcesado = BanArchivoProcesado;
    }

    public boolean isBanTA() {
        return banTA;
    }

    public void setBanTA(boolean banTA) {
        this.banTA = banTA;
    }

    public boolean isBanListaAlumnosError() {
        return BanListaAlumnosError;
    }

    public void setBanListaAlumnosError(boolean BanListaAlumnosError) {
        this.BanListaAlumnosError = BanListaAlumnosError;
    }

    public boolean isBanAlumnosExistente() {
        return BanAlumnosExistente;
    }

    public void setBanAlumnosExistente(boolean BanAlumnosExistente) {
        this.BanAlumnosExistente = BanAlumnosExistente;
    }

    public boolean isBanDatosCorrectosA() {
        return BanDatosCorrectosA;
    }

    public void setBanDatosCorrectosA(boolean BanDatosCorrectosA) {
        this.BanDatosCorrectosA = BanDatosCorrectosA;
    }

    public boolean isBanArchivoProcesadoA() {
        return BanArchivoProcesadoA;
    }

    public void setBanArchivoProcesadoA(boolean BanArchivoProcesadoA) {
        this.BanArchivoProcesadoA = BanArchivoProcesadoA;
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

    public boolean isBanTAI() {
        return banTAI;
    }

    public void setBanTAI(boolean banTAI) {
        this.banTAI = banTAI;
    }

    public boolean isBanListaAsesorIError() {
        return BanListaAsesorIError;
    }

    public void setBanListaAsesorIError(boolean BanListaAsesorIError) {
        this.BanListaAsesorIError = BanListaAsesorIError;
    }

    public boolean isBanAsesorIExistente() {
        return BanAsesorIExistente;
    }

    public void setBanAsesorIExistente(boolean BanAsesorIExistente) {
        this.BanAsesorIExistente = BanAsesorIExistente;
    }

    public boolean isBanDatosCorrectosAI() {
        return BanDatosCorrectosAI;
    }

    public void setBanDatosCorrectosAI(boolean BanDatosCorrectosAI) {
        this.BanDatosCorrectosAI = BanDatosCorrectosAI;
    }

    public boolean isBanArchivoProcesadoAI() {
        return BanArchivoProcesadoAI;
    }

    public void setBanArchivoProcesadoAI(boolean BanArchivoProcesadoAI) {
        this.BanArchivoProcesadoAI = BanArchivoProcesadoAI;
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

    public boolean isBanListaAsesorIErrorRenapo() {
        return BanListaAsesorIErrorRenapo;
    }

    public void setBanListaAsesorIErrorRenapo(boolean BanListaAsesorIErrorRenapo) {
        this.BanListaAsesorIErrorRenapo = BanListaAsesorIErrorRenapo;
    }

}
