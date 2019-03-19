package daos;

import beans.AdminCatBean;
import beans.AlumnosBean;
import beans.BecaBean;
import beans.DatosBean;
import beans.ProyectoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mappers.AsesoresIMapper;
import mappers.AsesoresMapper;
import mappers.BuscaRFCMapper;
import mappers.CCTMapper;
import mappers.CarrerasMapper;
import mappers.ConsultaTipoAlumnoMapper;
import mappers.EstatusMapper;
import mappers.Mapper;
import mappers.ProyectoMapper;
import mappers.ResponsableIMapper;
import mappers.TipoBecasMapper;
import mappers.VerificaAlumnosMapper;
import mappers.VerificaArcRegMapper;
import mappers.VerificaAsesorAdminMapper;
import mappers.VerificaAsesorIAdMapper;
import mappers.VerificaAsesorIMapper;
import mappers.VerificaAsesorMapper;
import mappers.VerificaCuentaxCurpDCMapper;
import mappers.VerificaCarrerasMapper;
import mappers.VerificaModalidadMapper;
import mappers.VerificaResponsableAdminMapper;
import mappers.VerificaResponsableMapper;
import mappers.aluNuevosMapper;
import mappers.alumnosDashboardMapper;
import mappers.avanceMetasMapper;
import mappers.carreraAluMapper;
import mappers.empAluMapper;
import mappers.listaAlumnos2Mapper;
import mappers.listaAlumnosBecaMapper;
import mappers.listaAlumnosMapper;
import mappers.listaBecasMapper;
import mappers.listaMunicipiosMapper;
import mappers.munEscMapper;
import mappers.proyectoTotalMapper;
import mappers.totalAluEscuela;
import mappers.totalEstatusColorMapper;
import mappers.totalEstatusMapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;

public class ConsultaDAOImpl extends OracleDAOFactory implements ConsultaDAO {

    OracleDAOFactory oraDaoFac = new OracleDAOFactory();

    public Connection crearConexion() throws Exception {

        Connection conne;
        conne = createConnection();
        Constantes.enviaMensajeConsola("conexion abierta.........");
        return conne;

    }

    //creando statement
    public Statement crearStatement(Connection cone) throws Exception {
        Statement stei;
        stei = createStatement2(cone);
        return stei;
    }

    @Override
    public List ConsultaCCT(String cct) throws Exception {
        String query = "SELECT CCT,NOM_ESC,CALLE,NUMERO,COLONIA,LOCALIDAD,CP,MUNICIPIO FROM " + Constantes.TablaCct + " WHERE CCT='" + cct + "'";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, new CCTMapper());
        return list;
    }

    public List ConsultaCarreras() throws Exception {
        String query = "SELECT CVE_CAR,NOM_CAR FROM " + Constantes.TablaCarrera + "";
        Constantes.enviaMensajeConsola("verifica si existen CARRERAS PARA CCT----->" + query);
        List list = null;
        list = queryForList(query, new CarrerasMapper());
        return list;
    }

    @Override
    public List verificaRegistroArchivo(String cct) throws Exception {
        String query = "SELECT CCT,ARCHIVO_CAR,ARCHIVO_RES,ARCHIVO_AI,ARCHIVO_ALU FROM " + Constantes.TablaVerificaArchivos + " WHERE CCT='" + cct + "'";
        Constantes.enviaMensajeConsola("Consulta ARCHIVOS YA REGISTRADOS----->" + query);
        List list = null;
        list = queryForList(query, new VerificaArcRegMapper());
        return list;
    }

    @Override
    public List ConsultaCarrera(DatosBean obj) throws Exception {
        String query = "SELECT ID_CAR_CCT,CVE_CAR,NOM_CAR FROM " + Constantes.TablaCar_CCT + " WHERE CCT='" + obj.getCCT() + "' AND CVE_CAR='" + obj.getCLAVECARRERA() + "'";
        Constantes.enviaMensajeConsola("BUSCA CARRERAS PARA CCT ----->" + query);
        List list = null;
        list = queryForList(query, new VerificaCarrerasMapper());
        return list;
    }

    public List ConsultaCarreraExistente(DatosBean obj) throws Exception {
        String query = "SELECT ID_CAR_CCT, CVE_CAR,NOM_CAR FROM " + Constantes.TablaCar_CCT + " WHERE CCT='" + obj.getCCT() + "'";
        Constantes.enviaMensajeConsola("verifica si existen CARRERAS PARA CCT----->" + query);
        List list = null;
        list = queryForList(query, new VerificaCarrerasMapper());
        return list;
    }

    @Override
    public List ConsultaDatos(DatosBean obj) throws Exception {
        String query = "SELECT NOMBRE,APELLIDOP,APELLIDOM,CURP FROM " + Constantes.TablaDatos + " WHERE CURP='" + obj.getCURPA() + "' ";
        Constantes.enviaMensajeConsola("verifica si existe cuenta con esta curp EN DATOS CUENTA----->" + query);
        List list = null;
        list = queryForList(query, new VerificaCuentaxCurpDCMapper());
        return list;
    }

    public List ConsultaTipoAlumno() throws Exception {
        String query = "select id_tipoalumno,nom_tipo from cat_tipoalumno";
        Constantes.enviaMensajeConsola("verifica si existe cuenta con esta curp EN DATOS CUENTA----->" + query);
        List list = null;
        list = queryForList(query, new ConsultaTipoAlumnoMapper());
        return list;
    }

    public boolean GuardaCarrera(DatosBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_CAR", "STRING", objdatos.getCLAVECARRERA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOM_CAR", "STRING", objdatos.getNOMBRE_CARRERA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaCar_CCT, arregloCampos);
    }

    public boolean EliminarCar(DatosBean objdatos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar     
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        temporal = new ObjPrepareStatement("ID_CAR_CCT", "STRING", objdatos.getID_CVE_CAR());
        arregloCampos.add(temporal);

        return queryDelete(Constantes.TablaCar_CCT, arregloCampos);
    }

    //*************************************************DAO IMPL Responsables*******************************************************************************
    @Override
    public List ConsultaResponsable(DatosBean obj) throws Exception {
        String query = "SELECT CVE_SER_PUB ,NOMBRE,APELLIDOP,APELLIDOM,CARGO, TELEFONO, EMAIL FROM " + Constantes.TablaResponsables + " WHERE CVE_SER_PUB='" + obj.getCURP_RESPONSABLE() + "' AND CCT='" + obj.getCCT() + "'";
        Constantes.enviaMensajeConsola("verifica si existen responsable PARA cvecarrera----->" + query);
        List list = null;
        list = queryForList(query, new VerificaResponsableMapper());
        return list;
    }

    @Override
    public boolean GuardaResponsable(Connection conn, PreparedStatement stat, DatosBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBRER().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDOPR().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDOMR().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_SER_PUB", "STRING", objdatos.getCURP_RESPONSABLE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CARGO", "STRING", objdatos.getCARGO_RESPONSABLE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO_RESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMAIL", "STRING", objdatos.getEMAIL_RESPONSABLE().toLowerCase());
        arregloCampos.add(temporal);

        System.out.println("conn: " + conn);
        System.out.println("stat: " + stat);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsertTransaccion(conn, stat, Constantes.TablaResponsables, arregloCampos);
    }

    public List ConsultaResponsableAdmin(AdminCatBean obj) throws Exception {
        String query = "SELECT ID_CAT_RES,NOMBRE,APELLIDOP,APELLIDOM,CVE_SER_PUB,CCT,CARGO, TELEFONO, EMAIL FROM " + Constantes.TablaResponsables + " WHERE  CCT='" + obj.getCCT() + "'";
        Constantes.enviaMensajeConsola("verifica si existen responsable PARA cvecarrera----->" + query);
        List list = null;
        list = queryForList(query, new VerificaResponsableAdminMapper());
        return list;
    }

    public boolean GuardaResponsableN(AdminCatBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBRER().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDOPR().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDOMR().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_SER_PUB", "STRING", objdatos.getCURP_RESPONSABLE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CARGO", "STRING", objdatos.getCARGO_RESPONSABLE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO_RESPONSABLE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMAIL", "STRING", objdatos.getEMAIL_RESPONSABLE().toLowerCase());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaResponsables, arregloCampos);
    }

    public boolean ActualizaResponsable(AdminCatBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CARGO", "STRING", objdatos.getCARGO_RESPONSABLEA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO_RESPONSABLEA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("EMAIL", "STRING", objdatos.getEMAIL_RESPONSABLEA().toLowerCase());
        arregloCampos.add(temporal);

        String condicion = "WHERE ID_CAT_RES='" + objdatos.getID_CAT_RESPA() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaResponsables, arregloCampos, condicion);
    }

    public boolean EliminarResponsable(AdminCatBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("ID_CAT_RES", "STRING", objdatos.getID_CAT_RESPA());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryDelete(Constantes.TablaResponsables, arregloCampos);
    }

    //*************************************************DAO IMPL ASESORES I*******************************************************************************
    @Override
    public List ConsultaAsesorI(DatosBean obj) throws Exception {
        String query = "SELECT NOMBRE,APELLIDOP,APELLIDOM,CVE_CAR_RES, CURP, CCT FROM " + Constantes.TablaAsesoresI + " WHERE CURP='" + obj.getCURP_ASESORI() + "' AND CCT='" + obj.getCCT() + "' AND CVE_CAR_RES='" + obj.getCVE_CAR_RES() + "'";
        Constantes.enviaMensajeConsola("verifica si existen responsable PARA cvecarrera----->" + query);
        List list = null;
        list = queryForList(query, new VerificaAsesorIMapper());
        return list;
    }

    public List ConsultaAsesorIAd(DatosBean obj) throws Exception {
        String query = "SELECT ID_CAT_ASE, NOMBRE,APELLIDOP,APELLIDOM,CVE_CAR_RES, CURP, CCT FROM " + Constantes.TablaAsesoresI + " WHERE CURP='" + obj.getCURP_ASESORI() + "' AND CCT='" + obj.getCCT() + "' AND CVE_CAR_RES='" + obj.getCVE_CAR_RES() + "' AND STATUS='1'";
        Constantes.enviaMensajeConsola("verifica si existen Asesor PARA cvecarrera----->" + query);
        List list = null;
        list = queryForList(query, new VerificaAsesorIAdMapper());
        return list;
    }
    
     public List ConsultaAsesorDes(DatosBean obj) throws Exception {
        String query = "SELECT ID_CAT_ASE, NOMBRE,APELLIDOP,APELLIDOM,CVE_CAR_RES, CURP, CCT FROM " + Constantes.TablaAsesoresI + " WHERE CURP='" + obj.getCURP_ASESORI() + "' AND CCT='" + obj.getCCT() + "' AND CVE_CAR_RES='" + obj.getCVE_CAR_RES() + "' AND STATUS='2'";
        Constantes.enviaMensajeConsola("verifica si existen ASESOR PARA cvecarrera DESHABILITADO----->" + query);
        List list = null;
        list = queryForList(query, new VerificaAsesorIAdMapper());
        return list;
    }

    @Override
    public boolean GuardaAsesorI(Connection conn, PreparedStatement stat, DatosBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBREAI());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDOPAI());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDOMAI());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_CAR_RES", "STRING", objdatos.getCVE_CAR_RES());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP", "STRING", objdatos.getCURP_ASESORI());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", "1");
        arregloCampos.add(temporal);

        System.out.println("conn: " + conn);
        System.out.println("stat: " + stat);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsertTransaccion(conn, stat, Constantes.TablaAsesoresI, arregloCampos);
    }

    public List ConsultaAsesorAdmin(AdminCatBean obj) throws Exception {
        String query = "SELECT ID_CAT_ASE,NOMBRE,APELLIDOP,APELLIDOM,CVE_CAR_RES,CURP,CCT FROM " + Constantes.TablaAsesoresI + " WHERE  CCT='" + obj.getCCT() + "' AND STATUS='1'";
        Constantes.enviaMensajeConsola("verifica si existen responsable PARA cvecarrera----->" + query);
        List list = null;
        list = queryForList(query, new VerificaAsesorAdminMapper());
        return list;
    }

    public boolean GuardaAsesorN(AdminCatBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBREAI().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDOPAI().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDOMAI().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_CAR_RES", "STRING", objdatos.getCVE_CAR_ASE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP", "STRING", objdatos.getCURP_ASESORI().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT_ASE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", "1");
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaAsesoresI, arregloCampos);
    }

    public boolean habilitarAsesor(AdminCatBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("STATUS", "STRING", "1");
        arregloCampos.add(temporal);

        String condicion = "WHERE ID_CAT_ASE='" + objdatos.getID_CAT_ASEA() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaAsesoresI, arregloCampos, condicion);
    }

    public boolean EliminarAsesor(AdminCatBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("STATUS", "STRING", "2");
        arregloCampos.add(temporal);
       
        
        String condicion="where ID_CAT_ASE='"+objdatos.getID_CAT_ASE()+"'";
//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaAsesoresI, arregloCampos,condicion);
    }

    //*************************************************DAO IMPL ALumnos*******************************************************************************
    public List ConsultaModalidad(DatosBean obj) throws Exception {
        String query = "SELECT MODALIDAD FROM " + Constantes.TablaCarrera + " WHERE CVE_CAR='" + obj.getCVE_CAR_RES() + "'";
        Constantes.enviaMensajeConsola("CONSULTA MODALIDAD----->" + query);
        List list = null;
        list = queryForList(query, new VerificaModalidadMapper());
        return list;
    }

    @Override
    public List ConsultaAlumnos(DatosBean obj) throws Exception {
        String query = "SELECT MATRICULA,CURP FROM " + Constantes.TablaAlumnos + " WHERE CURP='" + obj.getCURP() + "' AND MATRICULA='" + obj.getMATRICULA() + "'";
        Constantes.enviaMensajeConsola("verifica si existen responsable PARA cvecarrera----->" + query);
        List list = null;
        list = queryForList(query, new VerificaAlumnosMapper());
        return list;
    }

    @Override
    public boolean GuardaAlumnos(Connection conn, PreparedStatement stat, DatosBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar.
        temporal = new ObjPrepareStatement("MATRICULA", "STRING", objdatos.getMATRICULA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP", "STRING", objdatos.getCURP());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBRE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDOP());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDOM());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_CARRERA", "STRING", objdatos.getCVE_CAR_RES());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GENERO", "STRING", objdatos.getSEXO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_NAC", "STRING", objdatos.getFECNAC());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DOMICILIO", "STRING", objdatos.getDOMICILIOA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("COLONIA", "STRING", objdatos.getCOLONIAA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO", "STRING", objdatos.getCORREO().toLowerCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GRADO", "STRING", objdatos.getGRADO_CURSA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROMEDIO", "STRING", objdatos.getPROMEDIOGRAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SITUACION_ACA", "STRING", objdatos.getSITUACIONACA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TIPO_ALUMNO", "STRING", objdatos.getTIPO_ALUM());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AVANCE", "STRING", "50");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MUNICIPIO", "STRING", objdatos.getCVE_MUNA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CP", "STRING", objdatos.getCPA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("BECA", "STRING", objdatos.getBECA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INGRESO_DUAL", "STRING", objdatos.getFECHA_INGRESO_DUAL());
        arregloCampos.add(temporal);

        System.out.println("conn: " + conn);
        System.out.println("stat: " + stat);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsertTransaccion(conn, stat, Constantes.TablaAlumnos, arregloCampos);
    }

    public boolean ActualizaDocCar(DatosBean objdatos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;

        String condicion;

        //System.out.println("Entre al DAO ACTUALIZA DATOS...................................");
        temporal = new ObjPrepareStatement("ARCHIVO_CAR", "STRING", objdatos.getSTATUS());
        arregloCampos.add(temporal);

        condicion = "WHERE CCT='" + objdatos.getCCT() + "'";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate(Constantes.TablaVerificaArchivos, arregloCampos, condicion);
    }

    public boolean ActualizaDocRes(DatosBean objdatos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;

        String condicion;

        //System.out.println("Entre al DAO ACTUALIZA DATOS...................................");
        temporal = new ObjPrepareStatement("ARCHIVO_RES", "STRING", "si");
        arregloCampos.add(temporal);

        condicion = "WHERE CCT='" + objdatos.getCCT() + "'";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate(Constantes.TablaVerificaArchivos, arregloCampos, condicion);
    }

    public boolean ActualizaDocAI(DatosBean objdatos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;

        String condicion;

        //System.out.println("Entre al DAO ACTUALIZA DATOS...................................");
        temporal = new ObjPrepareStatement("ARCHIVO_AI", "STRING", "si");
        arregloCampos.add(temporal);

        condicion = "WHERE CCT='" + objdatos.getCCT() + "'";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate(Constantes.TablaVerificaArchivos, arregloCampos, condicion);
    }

    public boolean ActualizaDocAlu(DatosBean objdatos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;

        String condicion;

        //System.out.println("Entre al DAO ACTUALIZA DATOS...................................");
        temporal = new ObjPrepareStatement("ARCHIVO_ALU", "STRING", "si");
        arregloCampos.add(temporal);

        condicion = "WHERE CCT='" + objdatos.getCCT() + "'";

        //Se terminan de adicionar a nuesto ArrayLis los objetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate(Constantes.TablaVerificaArchivos, arregloCampos, condicion);
    }

    //************************************************************PARTE 2**********************************************************************
    public List listaMunicipios() throws Exception {
        String query = "SELECT ID, NOM_MUN AS MUNICIPIO FROM CAT_MUNICIPIOS";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new listaMunicipiosMapper());
        return list;
    }

    public List listaAlumnos(DatosBean datos) throws Exception {
        String query = "SELECT CA.ID_ALUMNO, CA.MATRICULA,CA.CURP,CA.NOMBRE,CA.APELLIDOP,CA.APELLIDOM,CA.NOMBRE ||' ' ||CA.APELLIDOP ||' ' ||CA.APELLIDOM AS NOMBRE_COMPLETO,CA.GENERO,CA.FECHA_NAC,CA.DOMICILIO,CA.COLONIA,CA.CP,CA.TELEFONO,CA.CORREO,(SELECT C.NOM_CAR  FROM CAT_CARRERA_CCT C WHERE c.cve_car=ca.CVE_CARRERA AND C.CCT=CA.CCT  ) AS CARRERA, "
                + "CA.GRADO, CA.PROMEDIO, CA.SITUACION_ACA, CA.TIPO_ALUMNO,CA.MUNICIPIO,(SELECT M.NOM_MUN FROM CAT_MUNICIPIOS M WHERE M.ID=CA.MUNICIPIO) AS NOMMUNICIPIO,CA.CCT ,CA.AVANCE,CA.FECHA_INGRESO_DUAL "
                + "FROM CAT_ALUMNOS CA  WHERE CA.CCT='" + datos.getCCT() + "' AND CA.STATUS='1' ORDER BY ca.cve_carrera ASC";
        Constantes.enviaMensajeConsola("Consulta ALUMNOS----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new listaAlumnosMapper());
        return list;
    }

    public List listaAlumnosBeca(DatosBean datos) throws Exception {
        String query = "SELECT CA.ID_ALUMNO, CA.MATRICULA,CA.CURP,CA.NOMBRE,CA.APELLIDOP,CA.APELLIDOM,CA.NOMBRE ||' ' ||CA.APELLIDOP ||' ' ||CA.APELLIDOM AS NOMBRE_COMPLETO, "
                + "(SELECT C.NOM_CAR  FROM CAT_CARRERA_CCT C WHERE c.cve_car=ca.CVE_CARRERA AND C.CCT=CA.CCT  ) AS CARRERA, CA.CCT ,CA.BECA "
                + "FROM CAT_ALUMNOS CA  WHERE CA.CCT='" + datos.getCCT() + "' AND CA.STATUS='1'";
        Constantes.enviaMensajeConsola("Consulta ALUMNOS BECA----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new listaAlumnosBecaMapper());
        return list;
    }

    public List listaAlumnos2(DatosBean datos) throws Exception {
        String query = "SELECT CURP,MATRICULA,NOMBRE ||' ' ||APELLIDOP ||' ' ||APELLIDOM AS NOMBRE_COMPLETO,(SELECT NOM_CAR FROM cat_carreras WHERE CVE_CAR=CVE_CARRERA) AS NOM_CAR,CVE_CARRERA,CCT FROM CAT_ALUMNOS WHERE CURP='" + datos.getCURPA() + "'";
        Constantes.enviaMensajeConsola("Consulta ALUMNOS 2----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new listaAlumnos2Mapper());
        return list;
    }

    public boolean actualizarAlumno(DatosBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("DOMICILIO", "STRING", datos.getDOMICILIOA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("COLONIA", "STRING", datos.getCOLONIAA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CP", "STRING", datos.getCP());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", datos.getTELEFONO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO", "STRING", datos.getCORREO().toLowerCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GRADO", "STRING", datos.getGRADO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROMEDIO", "STRING", datos.getPROMEDIOGRAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SITUACION_ACA", "STRING", datos.getSITUACIONACA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TIPO_ALUMNO", "STRING", datos.getTIPO_ALUM().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MUNICIPIO", "STRING", datos.getMUNICIPIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INGRESO_DUAL", "STRING", datos.getFECHA_INGRESO_DUAL());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + datos.getCURP() + "'";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("CAT_ALUMNOS", arregloCampos, Condicion);
    }

    public List buscaRFC(String RFC) throws Exception {
        String query = "SELECT RFC,RAZON_SOCIAL,GIRO,SECTOR,DOMICILIO,COLONIA,LOCALIDAD,CP,MUNICIPIO,REP_LEGAL,TELEFONO,CORREO_ELECTRONICO FROM CAT_EMPRESAS WHERE RFC='" + RFC + "'";
        Constantes.enviaMensajeConsola("Consulta RFC----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new BuscaRFCMapper());
        return list;
    }

    public List ConsultaAsesores(String RFC) throws Exception {
        String query = "SELECT ID_CAT_RES_EMP,RFC,CURP,NOMBRE ||' ' ||APELLIDOP ||' ' ||APELLIDOM AS NOMBRE_COMPLETO,CARGO,TELEFONO,CORREO FROM CAT_RESPONSABLES_EMPRESA WHERE RFC='" + RFC + "'";
        Constantes.enviaMensajeConsola("Consulta RFC----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new AsesoresMapper());
        return list;
    }

    public List ConsultaAsesoresI(String cct, String CVE_CAR) throws Exception {
        String query = "SELECT ID_CAT_ASE,NOMBRE ||' ' ||APELLIDOP ||' ' ||APELLIDOM AS NOMBRE_COMPLETO FROM CAT_ASESOR_INSTITUCIONAL WHERE CCT='" + cct + "' AND CVE_CAR_RES='" + CVE_CAR + "'";
        Constantes.enviaMensajeConsola("Consulta ASESORES ESCOLARES----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new AsesoresIMapper());
        return list;
    }

    public List ConsultaResponsableI(String cct) throws Exception {
        String query = "SELECT ID_CAT_RES,NOMBRE ||' ' ||APELLIDOP ||' ' ||APELLIDOM AS NOMBRE_COMPLETO FROM CAT_RESPONSABLES WHERE CCT='" + cct + "'";
        Constantes.enviaMensajeConsola("Consulta ASESORES ESCOLARES----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new ResponsableIMapper());
        return list;
    }

    public List ConsultaEstatus() throws Exception {
        String query = "SELECT ID_ESTATUS,NOM_ESTATUS FROM CAT_ESTATUS";
        Constantes.enviaMensajeConsola("Consulta ESTATUS----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new EstatusMapper());
        return list;
    }

    public List VerificaAsesor(String CURP) throws Exception {
        String query = "SELECT CURP FROM CAT_RESPONSABLES_EMPRESA WHERE CURP='" + CURP + "'";
        Constantes.enviaMensajeConsola("Consulta RFC----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new VerificaAsesorMapper());
        return list;
    }

    public boolean GuardaEmpresa(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("RFC", "STRING", objdatos.getRFC());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RAZON_SOCIAL", "STRING", objdatos.getRAZON_SOCIAL().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GIRO", "STRING", objdatos.getGIRO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SECTOR", "STRING", objdatos.getSECTOR().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DOMICILIO", "STRING", objdatos.getDOMICILIOE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("COLONIA", "STRING", objdatos.getCOLONIAE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("LOCALIDAD", "STRING", objdatos.getLOCALIDADE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CP", "STRING", objdatos.getCPE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MUNICIPIO", "STRING", objdatos.getMUNICIPIOE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("REP_LEGAL", "STRING", objdatos.getREP_LEGAL().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONOE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO_ELECTRONICO", "STRING", objdatos.getCORREO_ELECTRONICOE().toLowerCase());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaEmpresa, arregloCampos);
    }

    public boolean GuardaAsesor(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("RFC", "STRING", objdatos.getRFC());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBRE_A().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDO_PA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDO_MA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CARGO", "STRING", objdatos.getCARGO_A().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO_A());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO", "STRING", objdatos.getCORREO_A().toLowerCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP", "STRING", objdatos.getCURP_AL().toUpperCase());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaResponsableEmpresa, arregloCampos);
    }

    public boolean GuardaProyecto(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP_A", "STRING", objdatos.getCURP_AL().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RFC", "STRING", objdatos.getRFC().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_P", "STRING", objdatos.getNOM_PRO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ETAPA", "STRING", objdatos.getETAPA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INICIO", "STRING", objdatos.getFECHA_INICIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_TERMINO", "STRING", objdatos.getFECHA_TERMINO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AREA_CONOCIMIENTO", "STRING", objdatos.getAREA_CONOCIMIENTO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NUM_HORA", "STRING", objdatos.getNUM_HORAS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ASESOR_INT", "STRING", objdatos.getASE_INS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESPONSABLE_INS", "STRING", objdatos.getRESP_INS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS_P());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CONVENIO", "STRING", objdatos.getCONVENIO());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaProyecto, arregloCampos);
    }

    //***********************************************************FIN PARTE 2**********************************************************
    //***********************************************************IMPL PETER********************************************************** 
    public List listaAlumnosDashboard(DatosBean datos) throws Exception {
        String query = "SELECT  MATRICULA,  CURP, NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA, CAR.NOM_CAR AS NOMBRE_CARRERA,  GENERO AS SEXO,  FECHA_NAC AS FECNAC,  DOMICILIO AS DOMICILIOA,  COLONIA,  TELEFONO,  CORREO,  GRADO,  PROMEDIO AS PROMEDIOGRAL,  SITUACION_ACA AS SITUACIONACA,   TIPO_ALUMNO,  STATUS,  CCT, ES.NOM_ESC AS NOMESC,  MUN.NOM_MUN AS MUNICIPIO,    CP,  FECHA_REG,  BECA,  FECHA_INGRESO_DUAL,  FECHA_REINGRESO,  FECHA_EGRESO,  FECHA_CAMBIO_ESTATUS, STAT.ESTATUS_GENERAL FROM CAT_ALUMNOS  JOIN (SELECT * FROM CAT_MUNICIPIOS)MUN ON CAT_ALUMNOS.MUNICIPIO=MUN.ID  JOIN (SELECT CVE_CAR, NOM_CAR FROM CAT_CARRERAS)CAR ON CAT_ALUMNOS.CVE_CARRERA=CAR.CVE_CAR JOIN (SELECT CCT AS CCT2, NOM_ESC  FROM CAT_ESCUELAS) ES ON CAT_ALUMNOS.CCT=ES.CCT2  JOIN (SELECT * FROM CAT_ESTATUS) STAT  ON CAT_ALUMNOS.STATUS=STAT.ID_ESTATUS  WHERE TO_DATE(CAT_ALUMNOS.FECHA_INGRESO_DUAL)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(CAT_ALUMNOS.FECHA_INGRESO_DUAL)<='" + datos.getFECHA_TERMINO() + "'";       
        Constantes.enviaMensajeConsola("Consulta Alumnos Dashboard----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new alumnosDashboardMapper());
        return list;
    }

    public List listaAlumnosDashboardU(DatosBean datos) throws Exception {
        String query = "SELECT  MATRICULA,  CURP, NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA, CAR.NOM_CAR AS NOMBRE_CARRERA,  GENERO AS SEXO,  FECHA_NAC AS FECNAC,  DOMICILIO AS DOMICILIOA,  COLONIA,  TELEFONO,  CORREO,  GRADO,  PROMEDIO AS PROMEDIOGRAL,  SITUACION_ACA AS SITUACIONACA,   TIPO_ALUMNO,  STATUS,  CCT, ES.NOM_ESC AS NOMESC,  MUN.NOM_MUN AS MUNICIPIO,    CP,  FECHA_REG,  BECA,  FECHA_INGRESO_DUAL,  FECHA_REINGRESO,  FECHA_EGRESO,  FECHA_CAMBIO_ESTATUS, STAT.ESTATUS_GENERAL FROM CAT_ALUMNOS  JOIN (SELECT * FROM CAT_MUNICIPIOS)MUN ON CAT_ALUMNOS.MUNICIPIO=MUN.ID  JOIN (SELECT CVE_CAR, NOM_CAR FROM CAT_CARRERAS)CAR ON CAT_ALUMNOS.CVE_CARRERA=CAR.CVE_CAR JOIN (SELECT CCT AS CCT2, NOM_ESC  FROM CAT_ESCUELAS) ES ON CAT_ALUMNOS.CCT=ES.CCT2  JOIN (SELECT * FROM CAT_ESTATUS) STAT  ON CAT_ALUMNOS.STATUS=STAT.ID_ESTATUS  WHERE TO_DATE(CAT_ALUMNOS.FECHA_INGRESO_DUAL)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(CAT_ALUMNOS.FECHA_INGRESO_DUAL)<='" + datos.getFECHA_TERMINO() + "' AND CCT='"+datos.getCCT()+"'";       
        Constantes.enviaMensajeConsola("Consulta Alumnos Dashboard----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new alumnosDashboardMapper());
        return list;
    }

    public List listaAlumnosDashboardUGeneral(DatosBean datos) throws Exception {
        String query = "SELECT  MATRICULA,  CURP, NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA, CAR.NOM_CAR AS NOMBRE_CARRERA,  GENERO AS SEXO,  FECHA_NAC AS FECNAC,  DOMICILIO AS DOMICILIOA,  COLONIA,  TELEFONO,  CORREO,  GRADO,  PROMEDIO AS PROMEDIOGRAL,  SITUACION_ACA AS SITUACIONACA,   TIPO_ALUMNO,  STATUS,  CCT, ES.NOM_ESC AS NOMESC,  MUN.NOM_MUN AS MUNICIPIO,    CP,  FECHA_REG,  BECA,  FECHA_INGRESO_DUAL,  FECHA_REINGRESO,  FECHA_EGRESO,  FECHA_CAMBIO_ESTATUS, STAT.ESTATUS_GENERAL FROM CAT_ALUMNOS  JOIN (SELECT * FROM CAT_MUNICIPIOS)MUN ON CAT_ALUMNOS.MUNICIPIO=MUN.ID  JOIN (SELECT CVE_CAR, NOM_CAR FROM CAT_CARRERAS)CAR ON CAT_ALUMNOS.CVE_CARRERA=CAR.CVE_CAR JOIN (SELECT CCT AS CCT2, NOM_ESC  FROM CAT_ESCUELAS) ES ON CAT_ALUMNOS.CCT=ES.CCT2  JOIN (SELECT * FROM CAT_ESTATUS) STAT  ON CAT_ALUMNOS.STATUS=STAT.ID_ESTATUS WHERE CCT='"+datos.getCCT()+"'";
        Constantes.enviaMensajeConsola("Consulta Alumnos Dashboard----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new alumnosDashboardMapper());
        return list;
    }

    public List listaAlumnosDashboardGeneral(DatosBean datos) throws Exception {
        String query = "SELECT  MATRICULA,  CURP, NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA, CAR.NOM_CAR AS NOMBRE_CARRERA,  GENERO AS SEXO,  FECHA_NAC AS FECNAC,  DOMICILIO AS DOMICILIOA,  COLONIA,  TELEFONO,  CORREO,  GRADO,  PROMEDIO AS PROMEDIOGRAL,  SITUACION_ACA AS SITUACIONACA,   TIPO_ALUMNO,  STATUS,  CCT, ES.NOM_ESC AS NOMESC,  MUN.NOM_MUN AS MUNICIPIO,    CP,  FECHA_REG,  BECA,  FECHA_INGRESO_DUAL,  FECHA_REINGRESO,  FECHA_EGRESO,  FECHA_CAMBIO_ESTATUS, STAT.ESTATUS_GENERAL FROM CAT_ALUMNOS  JOIN (SELECT * FROM CAT_MUNICIPIOS)MUN ON CAT_ALUMNOS.MUNICIPIO=MUN.ID  JOIN (SELECT CVE_CAR, NOM_CAR FROM CAT_CARRERAS)CAR ON CAT_ALUMNOS.CVE_CARRERA=CAR.CVE_CAR JOIN (SELECT CCT AS CCT2, NOM_ESC  FROM CAT_ESCUELAS) ES ON CAT_ALUMNOS.CCT=ES.CCT2  JOIN (SELECT * FROM CAT_ESTATUS) STAT  ON CAT_ALUMNOS.STATUS=STAT.ID_ESTATUS ";
        Constantes.enviaMensajeConsola("Consulta Alumnos Dashboard----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new alumnosDashboardMapper());
        return list;
    }

    public List listaTotalEstatus(DatosBean datos) throws Exception {
        String query = "SELECT DISTINCT(NOM_ESTATUS), COUNT(NOM_ESTATUS) AS TOTAL_ESTATUS FROM (SELECT * FROM(SELECT   MATRICULA,  CURP,  NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA,  GENERO AS SEXO,  STATUS,  CCT,  MUNICIPIO,  FECHA_REG FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "')ALU JOIN (SELECT ID_ESTATUS, NOM_ESTATUS, ESTATUS_GENERAL FROM CAT_ESTATUS  )CAT_ES ON  ALU.STATUS=CAT_ES.ID_ESTATUS) GROUP BY NOM_ESTATUS";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new totalEstatusMapper());
        return list;
    }

    public List listaTotalEstatusU(DatosBean datos) throws Exception {
        String query = "SELECT DISTINCT(NOM_ESTATUS), COUNT(NOM_ESTATUS) AS TOTAL_ESTATUS FROM (SELECT * FROM(SELECT   MATRICULA,  CURP,  NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA,  GENERO AS SEXO,  STATUS,  CCT,  MUNICIPIO,  FECHA_REG FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "' AND CCT='" + datos.getCCT() + "')ALU JOIN (SELECT ID_ESTATUS, NOM_ESTATUS, ESTATUS_GENERAL FROM CAT_ESTATUS  )CAT_ES ON  ALU.STATUS=CAT_ES.ID_ESTATUS) GROUP BY NOM_ESTATUS";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new totalEstatusMapper());
        return list;
    }

    public List listaTotalEstatusUGeneral(DatosBean datos) throws Exception {
        String query = "SELECT DISTINCT(NOM_ESTATUS), COUNT(NOM_ESTATUS) AS TOTAL_ESTATUS FROM (SELECT * FROM(SELECT   MATRICULA,  CURP,  NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA,  GENERO AS SEXO,  STATUS,  CCT,  MUNICIPIO,  FECHA_REG FROM CAT_ALUMNOS WHERE  CCT='" + datos.getCCT() + "')ALU JOIN (SELECT ID_ESTATUS, NOM_ESTATUS, ESTATUS_GENERAL FROM CAT_ESTATUS  )CAT_ES ON  ALU.STATUS=CAT_ES.ID_ESTATUS) GROUP BY NOM_ESTATUS";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new totalEstatusMapper());
        return list;
    }

    public List listaTotalEstatusGeneral(DatosBean datos) throws Exception {
        String query = "SELECT CATALOGO.NOM_ESTATUS, NVL(VAL.TOTAL_ESTATUS,'0') AS TOTAL_ESTATUS, CATALOGO.COLOR FROM (SELECT NOM_ESTATUS, COLOR FROM CAT_ESTATUS)CATALOGO LEFT OUTER JOIN (SELECT DISTINCT(NOM_ESTATUS), COUNT(NOM_ESTATUS) AS TOTAL_ESTATUS, COLOR FROM  (SELECT ID_ESTATUS, NOM_ESTATUS, ESTATUS_GENERAL, COLOR FROM CAT_ESTATUS  )CAT_ES JOIN  (SELECT * FROM CAT_ALUMNOS)ALU ON  ALU.STATUS=CAT_ES.ID_ESTATUS GROUP BY NOM_ESTATUS, COLOR)VAL ON VAL.NOM_ESTATUS=CATALOGO.NOM_ESTATUS ORDER BY TO_NUMBER(COLOR) ASC ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new totalEstatusColorMapper());
        return list;
    }

    public List proyectos(DatosBean datos) throws Exception {
        String query = "SELECT * FROM (SELECT COUNT(ID_PROYECTO) AS TOTAL_PROYECTOS  FROM TBL_PROYECTOS WHERE CCT='" + datos.getCCT() + "' AND TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "'), (SELECT COUNT(ID_ALUMNO) AS TOTAL_REINGRESOS FROM CAT_ALUMNOS WHERE TIPO_ALUMNO='2' AND TO_DATE(FECHA_REINGRESO)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REINGRESO)<='" + datos.getFECHA_TERMINO() + "' AND CCT='" + datos.getCCT() + "') , (SELECT COUNT(DISTINCT(CURP)) TOTAL_BECAS FROM TBL_BECAS WHERE CCT='" + datos.getCCT() + "' AND TO_DATE(FECHA_REG_BECA)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG_BECA)<='" + datos.getFECHA_TERMINO() + "')";
        Constantes.enviaMensajeConsola("cCANTIDAD DE PROYECTOS REGISTRADOS----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new proyectoTotalMapper());
        return list;
    }

    public List proyectosGeneral(DatosBean datos) throws Exception {
        String query = "SELECT * FROM (SELECT COUNT(ID_PROYECTO) AS TOTAL_PROYECTOS  FROM TBL_PROYECTOS WHERE  TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "'), (SELECT COUNT(ID_ALUMNO) AS TOTAL_REINGRESOS FROM CAT_ALUMNOS WHERE TIPO_ALUMNO='2' AND TO_DATE(FECHA_REINGRESO)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REINGRESO)<='" + datos.getFECHA_TERMINO() + "' ) , (SELECT COUNT(DISTINCT(CURP)) TOTAL_BECAS FROM TBL_BECAS WHERE  TO_DATE(FECHA_REG_BECA)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG_BECA)<='" + datos.getFECHA_TERMINO() + "')";
        Constantes.enviaMensajeConsola("cCANTIDAD DE PROYECTOS REGISTRADOS----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new proyectoTotalMapper());
        return list;
    }

    public List listaTotalEscuela(DatosBean datos) throws Exception {
        String query = "SELECT TRANSLATE(CAT.ABRE_INST,   'áéíóúàèìòùãõâêîôôäëïöüçÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ',   'aeiouaeiouaoaeiooaeioucAEIOUAEIOUAOAEIOOAEIOUC') AS CCT,  ESC.TOTAL_CCT FROM (SELECT DISTINCT(CCT), COUNT(CCT) AS TOTAL_CCT FROM (SELECT * FROM(SELECT   MATRICULA,  CURP,  NOMBRE ||' '||  APELLIDOP || ' ' ||  APELLIDOM  AS NOMBRE_COMPLETO,  CVE_CARRERA,  GENERO AS SEXO,  STATUS,  CCT,  MUNICIPIO,  FECHA_REG FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_REG)>='"+datos.getFECHA_INICIO()+"' AND TO_DATE(FECHA_REG)<='"+datos.getFECHA_TERMINO()+"')ALU JOIN (SELECT ID_ESTATUS, NOM_ESTATUS, ESTATUS_GENERAL FROM CAT_ESTATUS  )CAT_ES ON  ALU.STATUS=CAT_ES.ID_ESTATUS) GROUP BY CCT)ESC JOIN (SELECT CCT, ABRE_INST FROM CAT_ESCUELAS)CAT ON ESC.CCT=CAT.CCT";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new totalAluEscuela());
        return list;
    }
    public List listaCarreraAlu(DatosBean datos) throws Exception {
        String query = "SELECT CAT.CVE_CAR AS CLAVECARRERA, CAT.NOM_CAR AS NOMBRE_CARRERA, NVL(ACT.ALUMNOS_ACTIVOS,'0') AS ALUMNOS_ACTIVOS_GENERAL, NVL(INA.ALUMNOS_INACTIVOS,'0') AS ALUMNOS_INACTIVOS_GENERAL, NVL(EGR.ALUMNOS_EGRESADOS, '0' ) AS ALUMNOS_EGRESADOS_GENERAL FROM (SELECT * FROM CAT_CARRERAS)CAT LEFT OUTER JOIN (SELECT DISTINCT(CVE_CARRERA), COUNT(CVE_CARRERA) AS ALUMNOS_ACTIVOS FROM CAT_ALUMNOS WHERE STATUS=1 GROUP BY CVE_CARRERA)ACT ON CAT.CVE_CAR=ACT.CVE_CARRERA LEFT OUTER JOIN (SELECT DISTINCT(CVE_CARRERA), COUNT(CVE_CARRERA) AS ALUMNOS_INACTIVOS FROM CAT_ALUMNOS WHERE STATUS=10 GROUP BY CVE_CARRERA)INA ON CAT.CVE_CAR=INA.CVE_CARRERA LEFT OUTER JOIN (SELECT DISTINCT(CVE_CARRERA), COUNT(CVE_CARRERA) AS ALUMNOS_EGRESADOS FROM CAT_ALUMNOS WHERE STATUS>10 GROUP BY CVE_CARRERA)EGR ON CAT.CVE_CAR=EGR.CVE_CARRERA ORDER BY TO_NUMBER(NVL(ACT.ALUMNOS_ACTIVOS,'0') )DESC";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new carreraAluMapper());
        return list;
    }
    public List listaCarreraAluEsc(DatosBean datos) throws Exception {
        String query = "SELECT CAT.CVE_CAR AS CLAVECARRERA, CAT.NOM_CAR AS NOMBRE_CARRERA, NVL(ACT.ALUMNOS_ACTIVOS,'0') AS ALUMNOS_ACTIVOS_GENERAL, NVL(INA.ALUMNOS_INACTIVOS,'0') AS ALUMNOS_INACTIVOS_GENERAL, NVL(EGR.ALUMNOS_EGRESADOS, '0' ) AS ALUMNOS_EGRESADOS_GENERAL FROM (SELECT * FROM CAT_CARRERAS)CAT LEFT OUTER JOIN (SELECT DISTINCT(CVE_CARRERA), COUNT(CVE_CARRERA) AS ALUMNOS_ACTIVOS FROM CAT_ALUMNOS WHERE STATUS=1 AND CCT='"+datos.getCCT()+"' GROUP BY CVE_CARRERA)ACT ON CAT.CVE_CAR=ACT.CVE_CARRERA LEFT OUTER JOIN (SELECT DISTINCT(CVE_CARRERA), COUNT(CVE_CARRERA) AS ALUMNOS_INACTIVOS FROM CAT_ALUMNOS WHERE STATUS=10 AND CCT='"+datos.getCCT()+"' GROUP BY CVE_CARRERA)INA ON CAT.CVE_CAR=INA.CVE_CARRERA LEFT OUTER JOIN (SELECT DISTINCT(CVE_CARRERA), COUNT(CVE_CARRERA) AS ALUMNOS_EGRESADOS FROM CAT_ALUMNOS WHERE STATUS>10 AND CCT='"+datos.getCCT()+"' GROUP BY CVE_CARRERA)EGR ON CAT.CVE_CAR=EGR.CVE_CARRERA ORDER BY TO_NUMBER(NVL(ACT.ALUMNOS_ACTIVOS,'0') )DESC";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new carreraAluMapper());
        return list;
    }
    public List listaAvanceMetas(DatosBean datos) throws Exception {
        String query = " SELECT MAT.*,  MET.META, ROUND(TO_NUMBER(MET.META)*100/TO_NUMBER(MAT.MATRICULA),2) AS PORCENTAJE_META, MET.ABRE_INST, TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0') )AS ALU_NUEVOS, CASE WHEN TO_NUMBER(MET.META)>0 THEN  ROUND(((TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0') ) * 100)/TO_NUMBER(MET.META) ) , 2) ELSE TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0'))  END AS AVANCE_META, TO_NUMBER(MET.META)-TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0') ) AS FALTANTES FROM (SELECT DISTINCT(CVE_INSTITUCIONAL), SUM (MATRICULA) AS MATRICULA FROM TBL_MATRICULA WHERE ANIO=( SELECT ID_ANIO FROM CAT_CICLOS WHERE ESTATUS=1)  GROUP BY CVE_INSTITUCIONAL)MAT JOIN (SELECT * FROM TBL_METAS_SIPREP WHERE ANIO=( SELECT ID_ANIO FROM CAT_CICLOS WHERE ESTATUS=1)) MET ON MAT.CVE_INSTITUCIONAL=MET.CVE_INSTITUCIONAL LEFT OUTER JOIN (       SELECT DISTINCT(CAT.CVE_INSTITUCIONAL), SUM(ESC.NUEVOS_ESCUELA) AS TOTAL_ALU_INST FROM (SELECT DISTINCT(CCT), COUNT(CCT) AS NUEVOS_ESCUELA FROM ( SELECT * FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_INGRESO_DUAL)>= (SELECT FECHA_INICIO FROM CAT_CICLOS WHERE ESTATUS=1) AND TO_DATE(FECHA_INGRESO_DUAL)<= (SELECT FECHA_TERMINO FROM CAT_CICLOS WHERE ESTATUS=1)) GROUP BY CCT)ESC JOIN (SELECT CCT, CVE_INSTITUCIONAL FROM  CAT_ESCUELAS)CAT ON ESC.CCT=CAT.CCT GROUP BY CAT.CVE_INSTITUCIONAL) NUEVO ON MAT.CVE_INSTITUCIONAL=NUEVO.CVE_INSTITUCIONAL  ORDER BY (ROUND(TO_NUMBER(MET.META)*100/TO_NUMBER(MAT.MATRICULA),2)) DESC ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new avanceMetasMapper());
        return list;
    }
     public List listaAvanceMetasEsc(DatosBean datos) throws Exception {
        String query = "SELECT DAT.* FROM (SELECT MAT.*,  MET.META, ROUND(TO_NUMBER(MET.META)*100/TO_NUMBER(MAT.MATRICULA),2) AS PORCENTAJE_META, MET.ABRE_INST, TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0') )AS ALU_NUEVOS, CASE WHEN TO_NUMBER(MET.META)>0 THEN  ROUND(((TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0') ) * 100)/TO_NUMBER(MET.META) ) , 2) ELSE TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0'))  END AS AVANCE_META, TO_NUMBER(MET.META)-TO_NUMBER(NVL(NUEVO.TOTAL_ALU_INST,'0') ) AS FALTANTES FROM (SELECT DISTINCT(CVE_INSTITUCIONAL), SUM (MATRICULA) AS MATRICULA FROM TBL_MATRICULA WHERE ANIO=( SELECT ID_ANIO FROM CAT_CICLOS WHERE ESTATUS=1)  GROUP BY CVE_INSTITUCIONAL)MAT JOIN (SELECT * FROM TBL_METAS_SIPREP WHERE ANIO=( SELECT ID_ANIO FROM CAT_CICLOS WHERE ESTATUS=1)) MET ON MAT.CVE_INSTITUCIONAL=MET.CVE_INSTITUCIONAL LEFT OUTER JOIN (       SELECT DISTINCT(CAT.CVE_INSTITUCIONAL), SUM(ESC.NUEVOS_ESCUELA) AS TOTAL_ALU_INST FROM (SELECT DISTINCT(CCT), COUNT(CCT) AS NUEVOS_ESCUELA FROM ( SELECT * FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_INGRESO_DUAL)>= (SELECT FECHA_INICIO FROM CAT_CICLOS WHERE ESTATUS=1) AND TO_DATE(FECHA_INGRESO_DUAL)<= (SELECT FECHA_TERMINO FROM CAT_CICLOS WHERE ESTATUS=1))  GROUP BY CCT)ESC JOIN (SELECT CCT, CVE_INSTITUCIONAL FROM  CAT_ESCUELAS)CAT ON ESC.CCT=CAT.CCT GROUP BY CAT.CVE_INSTITUCIONAL) NUEVO ON MAT.CVE_INSTITUCIONAL=NUEVO.CVE_INSTITUCIONAL  ORDER BY (ROUND(TO_NUMBER(MET.META)*100/TO_NUMBER(MAT.MATRICULA),2)) DESC ) DAT JOIN (SELECT * FROM CAT_ESCUELAS WHERE CCT='"+datos.getCCT()+"')CAT ON  DAT.CVE_INSTITUCIONAL=CAT.CVE_INSTITUCIONAL  ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new avanceMetasMapper());
        return list;
    }
    public List listaAlumnosNuevos(DatosBean datos) throws Exception {
        String query = "SELECT MATRICULA, CURP, NOMBRE||' '||APELLIDOP||' '||APELLIDOM AS NOMBRE_COMPLETO, CVE_CARRERA AS CLAVECARRERA, SITUACION_ACA AS SITUACIONACA, MUNICIPIO, FECHA_INGRESO_DUAL,CCT  FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_INGRESO_DUAL)>='"+datos.getFECHA_INICIO()+"' AND TO_DATE(FECHA_INGRESO_DUAL)<='"+datos.getFECHA_TERMINO()+"'";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new aluNuevosMapper());
       return list;
    }
    public List listaAlumnosNuevosEsc(DatosBean datos) throws Exception {
        String query = "SELECT MATRICULA, CURP, NOMBRE||' '||APELLIDOP||' '||APELLIDOM AS NOMBRE_COMPLETO, CVE_CARRERA AS CLAVECARRERA, SITUACION_ACA AS SITUACIONACA, MUNICIPIO, FECHA_INGRESO_DUAL,CCT  FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_INGRESO_DUAL)>='"+datos.getFECHA_INICIO()+"' AND TO_DATE(FECHA_INGRESO_DUAL)<='"+datos.getFECHA_TERMINO()+"' AND CCT='"+datos.getCCT()+"'";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new aluNuevosMapper());
       return list;
    }
    
     public List listaAlumnosReingreso(DatosBean datos) throws Exception {
        String query = "SELECT MATRICULA, CURP, NOMBRE||' '||APELLIDOP||' '||APELLIDOM AS NOMBRE_COMPLETO, CVE_CARRERA AS CLAVECARRERA, SITUACION_ACA AS SITUACIONACA, MUNICIPIO, FECHA_INGRESO_DUAL,CCT  FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_REINGRESO)>='"+datos.getFECHA_INICIO()+"' AND TO_DATE(FECHA_REINGRESO)<='"+datos.getFECHA_TERMINO()+"' AND TIPO_ALUMNO=2";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new aluNuevosMapper());
       return list;
    }
      public List listaAlumnosReingresoEsc(DatosBean datos) throws Exception {
        String query = "SELECT MATRICULA, CURP, NOMBRE||' '||APELLIDOP||' '||APELLIDOM AS NOMBRE_COMPLETO, CVE_CARRERA AS CLAVECARRERA, SITUACION_ACA AS SITUACIONACA, MUNICIPIO, FECHA_INGRESO_DUAL,CCT  FROM CAT_ALUMNOS WHERE TO_DATE(FECHA_REINGRESO)>='"+datos.getFECHA_INICIO()+"' AND TO_DATE(FECHA_REINGRESO)<='"+datos.getFECHA_TERMINO()+"' AND TIPO_ALUMNO=2 AND CCT='"+datos.getCCT()+"'";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new aluNuevosMapper());
       return list;
    }

    public List listaTotalAsesorProyecto(DatosBean datos) throws Exception {
        String query = "SELECT NOMBRE_COMPLETO AS CCT, TOTAL_PROYECTOS AS TOTAL_CCT FROM (SELECT DISTINCT(ASE.CURP) AS CURP_ASESOR,  SUM(ALU.TOTAL_ASESOR) AS TOTAL_PROYECTOS , ASE.NOMBRE||' '||ASE.APELLIDOP||' '||ASE.APELLIDOM AS NOMBRE_COMPLETO FROM (SELECT ASESOR_INT, COUNT(ASESOR_INT) AS TOTAL_ASESOR FROM TBL_PROYECTOS WHERE CCT='" + datos.getCCT() + "' AND TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' AND TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "' GROUP BY ASESOR_INT) ALU LEFT OUTER JOIN (SELECT ID_CAT_ASE,  NOMBRE,  APELLIDOP,  APELLIDOM,  CVE_CAR_RES,  CURP,  CCT FROM CAT_ASESOR_INSTITUCIONAL) ASE ON ALU.ASESOR_INT=ASE.ID_CAT_ASE GROUP BY ASE.CURP, ASE.NOMBRE, ASE.APELLIDOP, ASE.APELLIDOM) ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new totalAluEscuela());
        return list;
    }

    public List listaMunEsc(DatosBean datos) throws Exception {
        String query = "SELECT  CAT_MUNICIPIOS.NOM_MUN AS NOMESC, NVL(ACTIVO.TOTAL_MUNICIPIOACTIVO,'0') AS MUNICIPIO_ACTIVOS, NVL(INACTIVO.TOTAL_MUNICIPIOINACTIVO,'0') AS MUNICIPIO_INACTIVOS, NVL(EGRESADOS.TOTAL_MUNICIPIOEGRESADO,'0' ) AS MUNICIPIO_EGRESADOS FROM CAT_MUNICIPIOS LEFT OUTER JOIN (SELECT DISTINCT(MUNICIPIO) AS MUNICIPIOACTIVO, COUNT(MUNICIPIO) AS TOTAL_MUNICIPIOACTIVO FROM  CAT_ALUMNOS WHERE STATUS=1 AND CCT='" + datos.getCCT() + "' GROUP BY MUNICIPIO )ACTIVO ON CAT_MUNICIPIOS.ID=ACTIVO.MUNICIPIOACTIVO LEFT OUTER JOIN (SELECT DISTINCT(MUNICIPIO) AS MUNICIPIOINACTIVO, COUNT(MUNICIPIO) AS TOTAL_MUNICIPIOINACTIVO FROM  CAT_ALUMNOS WHERE STATUS<>10 AND STATUS>10  AND CCT='" + datos.getCCT() + "' GROUP BY MUNICIPIO) INACTIVO ON CAT_MUNICIPIOS.ID=INACTIVO.MUNICIPIOINACTIVO LEFT OUTER JOIN (SELECT DISTINCT(MUNICIPIO) AS MINICIPIOEGRESADO, COUNT(MUNICIPIO) AS TOTAL_MUNICIPIOEGRESADO FROM  CAT_ALUMNOS WHERE STATUS=10  AND CCT='" + datos.getCCT() + "' GROUP BY MUNICIPIO )EGRESADOS ON CAT_MUNICIPIOS.ID=EGRESADOS.MINICIPIOEGRESADO WHERE ACTIVO.TOTAL_MUNICIPIOACTIVO IS NOT NULL OR INACTIVO.TOTAL_MUNICIPIOINACTIVO IS NOT NULL OR EGRESADOS.TOTAL_MUNICIPIOEGRESADO IS NOT NULL ORDER BY CAT_MUNICIPIOS.NOM_MUN ASC ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new munEscMapper());
        return list;
    }

    public List listaMunEscGeneral(DatosBean datos) throws Exception {
        String query = "SELECT  CAT_MUNICIPIOS.NOM_MUN AS NOMESC, NVL(ACTIVO.TOTAL_MUNICIPIOACTIVO,'0') AS MUNICIPIO_ACTIVOS, NVL(INACTIVO.TOTAL_MUNICIPIOINACTIVO,'0') AS MUNICIPIO_INACTIVOS, NVL(EGRESADOS.TOTAL_MUNICIPIOEGRESADO,'0' ) AS MUNICIPIO_EGRESADOS FROM CAT_MUNICIPIOS LEFT OUTER JOIN (SELECT DISTINCT(MUNICIPIO) AS MUNICIPIOACTIVO, COUNT(MUNICIPIO) AS TOTAL_MUNICIPIOACTIVO FROM  CAT_ALUMNOS WHERE STATUS=1  GROUP BY MUNICIPIO )ACTIVO ON CAT_MUNICIPIOS.ID=ACTIVO.MUNICIPIOACTIVO LEFT OUTER JOIN (SELECT DISTINCT(MUNICIPIO) AS MUNICIPIOINACTIVO, COUNT(MUNICIPIO) AS TOTAL_MUNICIPIOINACTIVO FROM  CAT_ALUMNOS WHERE STATUS<>10 AND STATUS>10   GROUP BY MUNICIPIO) INACTIVO ON CAT_MUNICIPIOS.ID=INACTIVO.MUNICIPIOINACTIVO LEFT OUTER JOIN (SELECT DISTINCT(MUNICIPIO) AS MINICIPIOEGRESADO, COUNT(MUNICIPIO) AS TOTAL_MUNICIPIOEGRESADO FROM  CAT_ALUMNOS WHERE STATUS=10   GROUP BY MUNICIPIO )EGRESADOS ON CAT_MUNICIPIOS.ID=EGRESADOS.MINICIPIOEGRESADO WHERE ACTIVO.TOTAL_MUNICIPIOACTIVO IS NOT NULL OR INACTIVO.TOTAL_MUNICIPIOINACTIVO IS NOT NULL OR EGRESADOS.TOTAL_MUNICIPIOEGRESADO IS NOT NULL ORDER BY CAT_MUNICIPIOS.NOM_MUN ASC ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new munEscMapper());
        return list;
    }

    public List listaEmpAlu(DatosBean datos) throws Exception {
        String query = "SELECT TOTAL.RFC, EMP.RAZON_SOCIAL, MUN.NOM_MUN, TOTAL.TOTAL_ALUMNOS_EMPRESA, EMP.GIRO, EMP.SECTOR, TOTAL.CCT FROM (SELECT DISTINCT(RFC), COUNT(RFC) AS TOTAL_ALUMNOS_EMPRESA, CCT FROM TBL_PROYECTOS WHERE  CCT='" + datos.getCCT() + "' GROUP BY RFC, CCT)TOTAL LEFT OUTER JOIN (SELECT RFC AS RFC_EMPRESA, RAZON_SOCIAL, MUNICIPIO, GIRO, SECTOR FROM CAT_EMPRESAS)EMP ON TOTAL.RFC=EMP.RFC_EMPRESA JOIN (SELECT * FROM CAT_MUNICIPIOS)MUN ON EMP.MUNICIPIO=MUN.ID ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new empAluMapper());
        return list;
    }

    public List listaEmpAluGeneral(DatosBean datos) throws Exception {
        String query = "SELECT TOTAL.RFC, EMP.RAZON_SOCIAL, MUN.NOM_MUN, TOTAL.TOTAL_ALUMNOS_EMPRESA, EMP.GIRO, EMP.SECTOR, TOTAL.CCT FROM (SELECT DISTINCT(RFC), COUNT(RFC) AS TOTAL_ALUMNOS_EMPRESA, CCT FROM TBL_PROYECTOS    GROUP BY RFC, CCT)TOTAL LEFT OUTER JOIN (SELECT RFC AS RFC_EMPRESA, RAZON_SOCIAL, MUNICIPIO, GIRO, SECTOR FROM CAT_EMPRESAS)EMP ON TOTAL.RFC=EMP.RFC_EMPRESA JOIN (SELECT * FROM CAT_MUNICIPIOS)MUN ON EMP.MUNICIPIO=MUN.ID ";
        Constantes.enviaMensajeConsola("Consulta cct----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new empAluMapper());
        return list;
    }

    public String AlumnosNuevoIngresoA(DatosBean datos) throws Exception {
        String query = "SELECT COUNT(ID_ALUMNO) AS ALUMNOS_NUEVOS FROM CAT_ALUMNOS  ";
        Constantes.enviaMensajeConsola("Consulta nuevo ingreso----->" + query);
        String nuevos = null;

        nuevos = queryStringUnCampo(query);

        return nuevos;
    }

    public String AlumnosActivosPeriodoA(DatosBean datos) throws Exception {
        String query = "SELECT COUNT(ALUMNOS_ACTIVOS) ALUMNOS_ACTIVOS_PERIODO FROM  (SELECT  DISTINCT(CURP_A) AS ALUMNOS_ACTIVOS  FROM TBL_PROYECTOS WHERE TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "' AND TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' GROUP BY CURP_A )";
        Constantes.enviaMensajeConsola("Consulta nuevo ActivosPeriodo----->" + query);
        String periodo = null;

        periodo = queryStringUnCampo(query);

        return periodo;
    }

    public String AlumnosNuevoIngreso(DatosBean datos) throws Exception {
        String query = "SELECT COUNT(ID_ALUMNO) AS ALUMNOS_NUEVOS FROM CAT_ALUMNOS WHERE  CCT='" + datos.getCCT() + "'";
        Constantes.enviaMensajeConsola("Consulta nuevo ingreso----->" + query);
        String nuevos = null;

        nuevos = queryStringUnCampo(query);

        return nuevos;
    }

    public String AlumnosActivosPeriodo(DatosBean datos) throws Exception {
        String query = "SELECT COUNT(ALUMNOS_ACTIVOS) ALUMNOS_ACTIVOS_PERIODO FROM  (SELECT  DISTINCT(CURP_A) AS ALUMNOS_ACTIVOS  FROM TBL_PROYECTOS WHERE TO_DATE(FECHA_REG)<='" + datos.getFECHA_TERMINO() + "' AND TO_DATE(FECHA_REG)>='" + datos.getFECHA_INICIO() + "' AND CCT='" + datos.getCCT() + "' GROUP BY CURP_A )";
        Constantes.enviaMensajeConsola("Consulta nuevo ActivosPeriodo----->" + query);
        String periodo = null;

        periodo = queryStringUnCampo(query);

        return periodo;
    }

    public boolean ActualizaStatus(ProyectoBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("AVANCE", "STRING", datos.getAVANCE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + datos.getCURP_AL() + "'";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("CAT_ALUMNOS", arregloCampos, Condicion);
    }

    public ProyectoBean ConsultaProyecto(String curp) throws Exception {
        String query = "";
        query = "SELECT tp.id_proyecto,tp.cct,tp.curp_a,tp.nombre_p,tp.etapa,tp.fecha_inicio,tp.fecha_termino,tp.area_conocimiento,tp.num_hora,tp.asesor_int,tp.responsable_ins,tp.status,tp.convenio,"
                + "ce.rfc,ce.razon_social,ce.giro,ce.sector,ce.domicilio,ce.colonia,ce.localidad,ce.cp,ce.municipio,ce.rep_legal,ce.telefono,ce.correo_electronico,"
                + "cre.nombre,cre.apellidop,cre.apellidom,cre.cargo,cre.telefono as tel_resp,cre.correo "
                + "FROM tbl_proyectos tp INNER JOIN cat_empresas ce on tp.rfc = ce.rfc INNER JOIN cat_responsables_empresa cre on tp.curp_a=cre.curp where curp_a='" + curp + "' AND STATUS='1'";
        Constantes.enviaMensajeConsola(" query consulta CCTS --> " + query);
        ProyectoBean resu = (ProyectoBean) oraDaoFac.queryForObject(query, new ProyectoMapper());
        return resu;
    }

    public boolean ActualizarAsesor(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBRE_A().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDO_PA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDO_MA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CARGO", "STRING", objdatos.getCARGO_A().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO_A());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO", "STRING", objdatos.getCORREO_A().toLowerCase());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + objdatos.getCURP_AL() + "' AND RFC='" + objdatos.getRFC() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaResponsableEmpresa, arregloCampos, Condicion);
    }

    public boolean ActualizarProyecto(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("RFC", "STRING", objdatos.getRFC().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_P", "STRING", objdatos.getNOM_PRO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ETAPA", "STRING", objdatos.getETAPA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INICIO", "STRING", objdatos.getFECHA_INICIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_TERMINO", "STRING", objdatos.getFECHA_TERMINO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AREA_CONOCIMIENTO", "STRING", objdatos.getAREA_CONOCIMIENTO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NUM_HORA", "STRING", objdatos.getNUM_HORAS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ASESOR_INT", "STRING", objdatos.getASE_INS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RESPONSABLE_INS", "STRING", objdatos.getRESP_INS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS_P());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CONVENIO", "STRING", objdatos.getCONVENIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_CIERRE", "STRING", objdatos.getFECHA_CIERRE());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP_A='" + objdatos.getCURP_AL() + "' AND CCT='" + objdatos.getCCT() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaProyecto, arregloCampos, Condicion);
    }

    public boolean ActualizarEstatusAlumnos(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS_P());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("BECA", "STRING", objdatos.getBECA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_CAMBIO_ESTATUS", "STRING", objdatos.getFECHA_CAMBIO_STATUS());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + objdatos.getCURP_AL() + "' AND CCT='" + objdatos.getCCT() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaAlumnos, arregloCampos, Condicion);
    }

    public boolean ActualizarEstatusAlumnoEgresado(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS_P());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("BECA", "STRING", objdatos.getBECA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_EGRESO", "STRING", objdatos.getFECHA_EGRESO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_CAMBIO_ESTATUS", "STRING", objdatos.getFECHA_CAMBIO_STATUS());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + objdatos.getCURP_AL() + "' AND CCT='" + objdatos.getCCT() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaAlumnos, arregloCampos, Condicion);
    }

    public boolean ActualizarEstatusBeca(ProyectoBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("STATUS", "STRING", "2");
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + objdatos.getCURP_AL() + "' AND CCT='" + objdatos.getCCT() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaBecas, arregloCampos, Condicion);
    }

    public List ConsultaTipoBeca() throws Exception {
        String query = "SELECT id_beca,nom_beca FROM cat_becas ";
        Constantes.enviaMensajeConsola("Consulta cat becas----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new TipoBecasMapper());
        return list;
    }

    public boolean GuardaBecas(BecaBean be) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("CCT", "STRING", be.getCCT_B());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP", "STRING", be.getCURP_AB().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FUENTE", "STRING", be.getFUENTE().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MONTO", "STRING", be.getMONTO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PERIODICIDAD", "STRING", be.getPERIODICIDAD());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DURACION", "STRING", be.getDURACION());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", be.getSTATUS_B());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TIPO_BECA", "STRING", be.getTIPO_BECA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DES_BECA", "STRING", be.getDES_BECA());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaBecas, arregloCampos);
    }

    public boolean ActualizaStatusBeca(BecaBean be) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("BECA", "STRING", be.getBECA());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + be.getCURP_AB() + "'";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("CAT_ALUMNOS", arregloCampos, Condicion);
    }

    public List ConsultaBecas(DatosBean datos) throws Exception {
        String query = "SELECT id_beca,cct,curp,fuente,monto,periodicidad,duracion,(SELECT cat_becas.nom_beca FROM cat_becas where tbl_becas.tipo_beca = cat_becas.id_beca)  nom_beca , tipo_beca, des_beca,status FROM tbl_becas where cct='" + datos.getCCT() + "' and curp='" + datos.getCURP() + "' AND STATUS='1'";
        Constantes.enviaMensajeConsola("Consulta ALUMNOS----->" + query);
        List list = null;
        list = queryForList(query, (Mapper) new listaBecasMapper());
        return list;
    }

    public boolean ActualizarBecas(BecaBean be) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("FUENTE", "STRING", be.getFUENTEA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MONTO", "STRING", be.getMONTOA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PERIODICIDAD", "STRING", be.getPERIODICIDADA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DURACION", "STRING", be.getDURACIONA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TIPO_BECA", "STRING", be.getTIPO_BECAA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DES_BECA", "STRING", be.getDES_BECAA());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE ID_BECA='" + be.getID_BECAA() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaBecas, arregloCampos, Condicion);
    }

    public boolean EliminarBecas(BecaBean be) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar     
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        temporal = new ObjPrepareStatement("ID_BECA", "STRING", be.getID_BECAE());
        arregloCampos.add(temporal);

        return queryDelete(Constantes.TablaBecas, arregloCampos);
    }

    //*********************************************************************************REGISTRO DE ALUMNO INDIVIDUAL***********************************************************************************
    @Override
    public List ConsultaAlumnos2(DatosBean obj) throws Exception {
        String query = "SELECT MATRICULA,CURP FROM " + Constantes.TablaAlumnos + " WHERE CURP='" + obj.getCURP().toUpperCase() + "'";
        Constantes.enviaMensajeConsola("verifica si existen alumno registrado----->" + query);
        List list = null;
        list = queryForList(query, new VerificaAlumnosMapper());
        return list;
    }

    public String ConsultaStatus(DatosBean obj) throws Exception {
        String query = "SELECT STATUS FROM " + Constantes.TablaAlumnos + " WHERE CURP='" + obj.getCURP().toUpperCase() + "'";
        Constantes.enviaMensajeConsola("verifica estatus del alumno----->" + query);
        String status = null;
        status = queryStringUnCampo(query);
        return status;
    }

    public boolean GuardaAlumnos(AlumnosBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar.
        temporal = new ObjPrepareStatement("MATRICULA", "STRING", objdatos.getMATRICULA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CURP", "STRING", objdatos.getCURP());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE", "STRING", objdatos.getNOMBRE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOP", "STRING", objdatos.getAPELLIDOP());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDOM", "STRING", objdatos.getAPELLIDOM());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CVE_CARRERA", "STRING", objdatos.getCLAVECARRERA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GENERO", "STRING", objdatos.getSEXO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_NAC", "STRING", objdatos.getFECNAC());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("DOMICILIO", "STRING", objdatos.getDOMICILIO().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("COLONIA", "STRING", objdatos.getCOLONIA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TELEFONO", "STRING", objdatos.getTELEFONO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CORREO", "STRING", objdatos.getCORREO().toLowerCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("GRADO", "STRING", objdatos.getGRADO_CURSA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PROMEDIO", "STRING", objdatos.getPROMEDIOGRAL());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SITUACION_ACA", "STRING", objdatos.getSITUACIONACA().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TIPO_ALUMNO", "STRING", objdatos.getTIPO_ALUM().toUpperCase());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CCT", "STRING", objdatos.getCCT());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AVANCE", "STRING", "50");
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MUNICIPIO", "STRING", objdatos.getCVE_MUN());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CP", "STRING", objdatos.getCP());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("BECA", "STRING", objdatos.getBECA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INGRESO_DUAL", "STRING", objdatos.getFECHA_INGRESO_DUAL());
        arregloCampos.add(temporal);

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryInsert(Constantes.TablaAlumnos, arregloCampos);
    }

    public boolean HabilitarAlumno(AlumnosBean objdatos) throws Exception {

//Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
//Crear un objeto de tipo ObjPrepareStatement
        ObjPrepareStatement temporal;
//imprimiendo los valores del objeto tipo CCT...........
        Constantes.enviaMensajeConsola("Entre al DAO del INSERT...................................");

//En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        temporal = new ObjPrepareStatement("TIPO_ALUMNO", "STRING", objdatos.getTIPO_ALUM());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("STATUS", "STRING", objdatos.getSTATUS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AVANCE", "STRING", objdatos.getAVANCE());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("BECA", "STRING", objdatos.getBECA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_REINGRESO", "STRING", objdatos.getFECHA_REINGRESO());
        arregloCampos.add(temporal);

        String Condicion;
        Condicion = " WHERE CURP='" + objdatos.getCURPA().toUpperCase() + "'";

//Se terminan de adicionar a nuesto ArrayLis los objetos
//Ejecutar la funcion del OracleDAOFactory queryInsert, se deber pasar como parmetros la tabla en donde se insertara
        return oraDaoFac.queryUpdate(Constantes.TablaAlumnos, arregloCampos, Condicion);

    }

}
