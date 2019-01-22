/**
 *
 * @author Esteban
 */
package daos;

import beans.BecaBean;
import beans.DatosBean;
import beans.ProyectoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public interface ConsultaDAO {

    public Connection crearConexion() throws Exception;

    public Statement crearStatement(Connection cone) throws Exception;

    public List ConsultaCCT(String cct) throws Exception;

    public List ConsultaCarreras() throws Exception;

    public List verificaRegistroArchivo(String cct) throws Exception;

    public List ConsultaCarrera(DatosBean obj) throws Exception;

    public List ConsultaCarreraExistente(DatosBean obj) throws Exception;

    public List ConsultaDatos(DatosBean obj) throws Exception;

    public boolean GuardaCarrera(DatosBean dat) throws Exception;

    public boolean EliminarCar(DatosBean dat) throws Exception;

    //******************************************************daos responsables*********************************************
    public List ConsultaResponsable(DatosBean obj) throws Exception;

    public boolean GuardaResponsable(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception;

    //***********************************************business de asesorI**********************************
    public List ConsultaAsesorI(DatosBean obj) throws Exception;

    public boolean GuardaAsesorI(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception;

    //******************************************************daos responsables*********************************************
    public List ConsultaModalidad(DatosBean obj) throws Exception;

    public List ConsultaAlumnos(DatosBean obj) throws Exception;

    public boolean GuardaAlumnos(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception;

    //************************************************** daos actualiza archivos***********************************************
    public boolean ActualizaDocCar(DatosBean objdatos) throws Exception;

    public boolean ActualizaDocRes(DatosBean objdatos) throws Exception;

    public boolean ActualizaDocAI(DatosBean objdatos) throws Exception;

    public boolean ActualizaDocAlu(DatosBean objdatos) throws Exception;

    //**********************************************************PARTE 2*****************************************************
    public List listaMunicipios() throws Exception;

    public List listaAlumnos(DatosBean datos) throws Exception;

    public List listaAlumnosBeca(DatosBean datos) throws Exception;

    public List listaAlumnos2(DatosBean datos) throws Exception;

    public boolean actualizarAlumno(DatosBean datos) throws Exception;

    public List buscaRFC(String RFC) throws Exception;

    public List ConsultaAsesores(String RFC) throws Exception;

    public List ConsultaAsesoresI(String CCT, String CVE_CAR) throws Exception;

    public List ConsultaResponsableI(String CCT) throws Exception;

    public List ConsultaEstatus() throws Exception;

    public List VerificaAsesor(String curp) throws Exception;

    public boolean GuardaEmpresa(ProyectoBean pro) throws Exception;

    public boolean GuardaAsesor(ProyectoBean pro) throws Exception;

    public boolean GuardaProyecto(ProyectoBean pro) throws Exception;

    public boolean ActualizaStatus(ProyectoBean datos) throws Exception;

    public ProyectoBean ConsultaProyecto(String curp) throws Exception;

    public boolean ActualizarAsesor(ProyectoBean pro) throws Exception;

    public boolean ActualizarProyecto(ProyectoBean pro) throws Exception;

    public boolean ActualizarEstatusAlumnos(ProyectoBean pro) throws Exception;

    public boolean GuardaBecas(BecaBean be) throws Exception;

    public boolean ActualizaStatusBeca(BecaBean be) throws Exception;
    
    public List ConsultaBecas(DatosBean obj) throws Exception;
    
    public boolean ActualizarBecas(BecaBean be) throws Exception;
     
    public boolean EliminarBecas(BecaBean be) throws Exception;

    //**********************************************************FIN PARTE 2*****************************************************
    //**********************************************************DAO PETER*****************************************************
    public List listaAlumnosDashboard(DatosBean datos) throws Exception;
    
    public List listaAlumnosDashboardU(DatosBean datos) throws Exception;

    public List listaTotalEstatus(DatosBean datos) throws Exception;
    
    public List listaTotalEstatusU(DatosBean datos) throws Exception;

    public List listaTotalEscuela(DatosBean datos) throws Exception;
    
    public List listaTotalAsesorProyecto(DatosBean datos) throws Exception;
}
