package business;

import beans.AlumnosBean;
import beans.BecaBean;
import beans.DatosBean;
import beans.GeneraArchivoBean;
import beans.ProyectoBean;
import daos.ConsultaDAO;
import daos.ConsultaDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class ConsultasBusiness {

    private ConsultaDAO con;

    public ConsultasBusiness() throws Exception {
        this.con = new ConsultaDAOImpl();
    }

    public Connection crearConexion() throws Exception {
        return con.crearConexion();
    }
//crear statement2

    public Statement crearStatement(Connection cone) throws Exception {
        return con.crearStatement(cone);

    }

    public List ConsultaCCT(String cct) throws Exception {
        List lista = this.con.ConsultaCCT(cct);
        return lista;
    }

    public List ConsultaCarreras() throws Exception {
        List lista = this.con.ConsultaCarreras();
        return lista;
    }

    public List verificaRegistroArchivo(String cct) throws Exception {
        List lista = this.con.verificaRegistroArchivo(cct);
        return lista;
    }

    public List ConsultaCarrera(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaCarrera(obj);
        return lista;
    }

    public List ConsultaCarreraExistente(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaCarreraExistente(obj);
        return lista;
    }

    public List ConsultaDatos(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaDatos(obj);
        return lista;
    }

    public boolean GuardaCarrera(DatosBean datos) throws Exception {
        return this.con.GuardaCarrera(datos);
    }

    public boolean EliminarCar(DatosBean datos) throws Exception {
        return this.con.EliminarCar(datos);
    }

    //***********************************************business de responsables**********************************
    public List ConsultaResponsable(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaResponsable(obj);
        return lista;
    }

    public boolean GuardaResponsable(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception {
        return this.con.GuardaResponsable(conn, stat, datos);
    }

    //***********************************************business de asesorI**********************************
    public List ConsultaAsesorI(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAsesorI(obj);
        return lista;
    }

    public boolean GuardaAsesorI(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception {
        return this.con.GuardaAsesorI(conn, stat, datos);
    }

    //***********************************************business de ALUMNOS**********************************
    public List ConsultaModalidad(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaModalidad(obj);
        return lista;
    }

    public List ConsultaAlumnos(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAlumnos(obj);
        return lista;
    }

    public boolean GuardaAlumnos(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception {
        return this.con.GuardaAlumnos(conn, stat, datos);
    }

    //************************************** ACTUALIZA ARCHIVOS********************************************************
    public boolean ActualizaDocCar(DatosBean objdatos) throws Exception {
        return con.ActualizaDocCar(objdatos);
    }

    public boolean ActualizaDocRes(DatosBean objdatos) throws Exception {
        return con.ActualizaDocRes(objdatos);
    }

    public boolean ActualizaDocAI(DatosBean objdatos) throws Exception {
        return con.ActualizaDocAI(objdatos);
    }

    public boolean ActualizaDocAlu(DatosBean objdatos) throws Exception {
        return con.ActualizaDocAlu(objdatos);
    }

    //*****************************************************PARTE 2******************************************************
    public List listaMunicipios() throws Exception {
        List lista = this.con.listaMunicipios();
        return lista;
    }

    public List listaAlumnos(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnos(datos);
        return lista;
    }

    public List listaAlumnosBeca(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosBeca(datos);
        return lista;
    }

    public List listaAlumnos2(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnos2(datos);
        return lista;
    }

    public boolean actualizarAlumno(DatosBean datos) throws Exception {
        return con.actualizarAlumno(datos);

    }

    public List buscaRFC(String RFC) throws Exception {
        List lista = this.con.buscaRFC(RFC);
        return lista;
    }

    public List ConsultaAsesores(String RFC) throws Exception {
        List lista = this.con.ConsultaAsesores(RFC);
        return lista;
    }

    public List ConsultaAsesoresI(String CCT, String CVE_CAR) throws Exception {
        List lista = this.con.ConsultaAsesoresI(CCT, CVE_CAR);
        return lista;
    }

    public List ConsultaResponsableI(String CCT) throws Exception {
        List lista = this.con.ConsultaResponsableI(CCT);
        return lista;
    }

    public List ConsultaEstatus() throws Exception {
        List lista = this.con.ConsultaEstatus();
        return lista;
    }

    public List VerificaAsesor(String curp) throws Exception {
        List lista = this.con.VerificaAsesor(curp);
        return lista;
    }

    public boolean GuardaEmpresa(ProyectoBean pro) throws Exception {
        return this.con.GuardaEmpresa(pro);
    }

    public boolean GuardaAsesor(ProyectoBean pro) throws Exception {
        return this.con.GuardaAsesor(pro);
    }

    public boolean GuardaProyecto(ProyectoBean pro) throws Exception {
        return this.con.GuardaProyecto(pro);
    }

    public boolean ActualizaStatus(ProyectoBean objdatos) throws Exception {
        return con.ActualizaStatus(objdatos);
    }

    public ProyectoBean ConsultaProyecto(String curp) throws Exception {
        return con.ConsultaProyecto(curp);
    }

    public boolean ActualizarAsesor(ProyectoBean pro) throws Exception {
        return this.con.ActualizarAsesor(pro);
    }

    public boolean ActualizarProyecto(ProyectoBean pro) throws Exception {
        return this.con.ActualizarProyecto(pro);
    }

    public boolean ActualizarEstatusAlumnos(ProyectoBean pro) throws Exception {
        return this.con.ActualizarEstatusAlumnos(pro);
    }

    public boolean GuardaBecas(BecaBean be) throws Exception {
        return this.con.GuardaBecas(be);
    }

    public boolean ActualizaStatusBeca(BecaBean be) throws Exception {
        return con.ActualizaStatusBeca(be);
    }
    
    public List ConsultaTipoBeca() throws Exception {
        List lista = this.con.ConsultaTipoBeca();
        return lista;
    }

    public List ConsultaBecas(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaBecas(obj);
        return lista;
    }

    public boolean ActualizarBecas(BecaBean be) throws Exception {
        return this.con.ActualizarBecas(be);
    }

    public boolean EliminarBecas(BecaBean be) throws Exception {
        return this.con.EliminarBecas(be);
    }

    //*****************************************************FIN PARTE 2******************************************************
    //*****************************************************BUSSINESS PETER******************************************************
    public List listaAlumnosDashboard(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosDashboard(datos);
        return lista;

    }
    
    public List listaAlumnosDashboardU(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosDashboardU(datos);
        return lista;

    }

    public List listaTotalEstatus(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalEstatus(datos);
        return lista;

    }
    
     public List listaTotalEstatusU(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalEstatusU(datos);
        return lista;

    }

    public List listaTotalEscuela(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalEscuela(datos);
        return lista;

    }
    
     public List listaTotalAsesorProyecto(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalAsesorProyecto(datos);
        return lista;

    }
     
   //******************************************************************REGISTRO DE ALUMNO INDIVIDUAL*************************************************************
     
      public List ConsultaAlumnos2(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAlumnos2(obj);
        return lista;
    }
     
      public boolean GuardaAlumnos(AlumnosBean objdatos) throws Exception  {
        return this.con.GuardaAlumnos(objdatos);
    }

     

}
