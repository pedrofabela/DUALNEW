/**
 *
 * @author Esteban
 */
package daos;

import beans.AdminCatBean;
import beans.AlumnosBean;
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

    public List ConsultaTipoAlumno() throws Exception;

    //******************************************************daos responsables*********************************************
    public List ConsultaResponsable(DatosBean obj) throws Exception;

    public boolean GuardaResponsable(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception;

    public List ConsultaResponsableAdmin(AdminCatBean obj) throws Exception;
    
    public boolean GuardaResponsableN(AdminCatBean ad) throws Exception;
    
    public boolean ActualizaResponsable(AdminCatBean ad) throws Exception;
    
    public boolean EliminarResponsable(AdminCatBean ad) throws Exception;

    //***********************************************business de asesorI**********************************
    public List ConsultaAsesorI(DatosBean obj) throws Exception;
    
    public List ConsultaAsesorIAd(DatosBean obj) throws Exception;
    
     public List ConsultaAsesorDes(DatosBean obj) throws Exception;

    public boolean GuardaAsesorI(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception;
    
    public List ConsultaAsesorAdmin(AdminCatBean obj) throws Exception;
    
    public boolean GuardaAsesorN(AdminCatBean ad) throws Exception; 
    
     public boolean habilitarAsesor(AdminCatBean ad) throws Exception ;
     
     public boolean EliminarAsesor(AdminCatBean ad) throws Exception ;


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
    
    public boolean ActualizarEstatusAlumnoEgresado(ProyectoBean pro) throws Exception;
    
    public boolean ActualizarEstatusBeca(ProyectoBean pro) throws Exception;

    public boolean GuardaBecas(BecaBean be) throws Exception;

    public boolean ActualizaStatusBeca(BecaBean be) throws Exception;

    public List ConsultaTipoBeca() throws Exception;

    public List ConsultaBecas(DatosBean obj) throws Exception;

    public boolean ActualizarBecas(BecaBean be) throws Exception;

    public boolean EliminarBecas(BecaBean be) throws Exception;

    //**********************************************************FIN PARTE 2*****************************************************
    //**********************************************************DAO PETER*****************************************************
    public List listaAlumnosDashboard(DatosBean datos) throws Exception;

    public List listaAlumnosDashboardU(DatosBean datos) throws Exception;
     public List listaAlumnosDashboardUGeneral(DatosBean datos) throws Exception;
      public List listaAlumnosDashboardGeneral(DatosBean datos) throws Exception;

    public List listaTotalEstatus(DatosBean datos) throws Exception;

    public List listaTotalEstatusU(DatosBean datos) throws Exception;
      public List listaTotalEstatusUGeneral(DatosBean datos) throws Exception;
       public List listaTotalEstatusGeneral(DatosBean datos) throws Exception;
    
    public List proyectos(DatosBean datos) throws Exception;
    public List proyectosGeneral(DatosBean datos) throws Exception;

    public List listaTotalEscuela(DatosBean datos) throws Exception;
     public List listaCarreraAlu(DatosBean datos) throws Exception;
     public List listaCarreraAluEsc(DatosBean datos) throws Exception;
      public List listaAvanceMetas(DatosBean datos) throws Exception;
       public List listaAvanceMetasEsc(DatosBean datos) throws Exception;
      public List listaAlumnosNuevos(DatosBean datos) throws Exception;
      public List listaAlumnosNuevosEsc(DatosBean datos) throws Exception;
       public List listaAlumnosReingreso(DatosBean datos) throws Exception;
        public List listaAlumnosReingresoEsc(DatosBean datos) throws Exception;

    public List listaTotalAsesorProyecto(DatosBean datos) throws Exception;
    public List listaMunEsc(DatosBean datos) throws Exception;
     public List listaMunEscGeneral(DatosBean datos) throws Exception;
    public List listaEmpAlu(DatosBean datos) throws Exception;
    public List listaEmpAluGeneral(DatosBean datos) throws Exception;

    public String AlumnosNuevoIngresoA(DatosBean datos) throws Exception;

    public String AlumnosActivosPeriodoA(DatosBean datos) throws Exception;

    public String AlumnosNuevoIngreso(DatosBean datos) throws Exception;

    public String AlumnosActivosPeriodo(DatosBean datos) throws Exception;

    //******************************************************REGISTRO ALUMNOS INDIVIDUAL************************************************
    public List ConsultaAlumnos2(DatosBean obj) throws Exception;

    public String ConsultaStatus(DatosBean obj) throws Exception;

    public boolean GuardaAlumnos(AlumnosBean objdatos) throws Exception;

    public boolean HabilitarAlumno(AlumnosBean objdatos) throws Exception;
}
