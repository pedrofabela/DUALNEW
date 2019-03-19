package business;

import beans.AdminCatBean;
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
    
    public List ConsultaTipoAlumno() throws Exception {
        List lista = this.con.ConsultaTipoAlumno();
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
    
    public List ConsultaResponsableAdmin(AdminCatBean obj) throws Exception {
        List lista = this.con.ConsultaResponsableAdmin(obj);
        return lista;
    }
    
    public boolean GuardaResponsableN(AdminCatBean ad) throws Exception {
        return this.con.GuardaResponsableN(ad);
    }
    
     public boolean ActualizaResponsable(AdminCatBean ad) throws Exception {
        return this.con.ActualizaResponsable(ad);
    }
     
     public boolean EliminarResponsable(AdminCatBean ad) throws Exception {
        return this.con.EliminarResponsable(ad);
    }

    //***********************************************business de asesorI**********************************
    public List ConsultaAsesorI(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAsesorI(obj);
        return lista;
    }
    
    public List ConsultaAsesorIAd(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAsesorIAd(obj);
        return lista;
    }
    
     public List ConsultaAsesorDes(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAsesorDes(obj);
        return lista;
    }

    public boolean GuardaAsesorI(Connection conn, PreparedStatement stat, DatosBean datos) throws Exception {
        return this.con.GuardaAsesorI(conn, stat, datos);
    }
    
    public List ConsultaAsesorAdmin(AdminCatBean obj) throws Exception {
        List lista = this.con.ConsultaAsesorAdmin(obj);
        return lista;
    }
    
    public boolean GuardaAsesorN(AdminCatBean ad) throws Exception {
        return this.con.GuardaAsesorN(ad);
    }
    
     public boolean habilitarAsesor(AdminCatBean ad) throws Exception {
        return this.con.habilitarAsesor(ad);
    }
     
     public boolean EliminarAsesor(AdminCatBean ad) throws Exception {
        return this.con.EliminarAsesor(ad);
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
    
    public boolean ActualizarEstatusAlumnoEgresado(ProyectoBean pro) throws Exception {
        return this.con.ActualizarEstatusAlumnoEgresado(pro);
    }
    
    public boolean ActualizarEstatusBeca(ProyectoBean pro) throws Exception {
        return this.con.ActualizarEstatusBeca(pro);
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
     public List listaAlumnosDashboardUGeneral(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosDashboardUGeneral(datos);
        return lista;

    }
     
      public List listaAlumnosDashboardGeneral(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosDashboardGeneral(datos);
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
      public List listaTotalEstatusUGeneral(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalEstatusUGeneral(datos);
        return lista;

    }
       public List listaTotalEstatusGeneral(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalEstatusGeneral(datos);
        return lista;

    }

    public List listaTotalEscuela(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalEscuela(datos);
        return lista;

    }
     public List listaCarreraAlu(DatosBean datos) throws Exception {
        List lista = this.con.listaCarreraAlu(datos);
        return lista;

    }
     public List listaCarreraAluEsc(DatosBean datos) throws Exception {
        List lista = this.con.listaCarreraAluEsc(datos);
        return lista;

    }
      public List listaAvanceMetas(DatosBean datos) throws Exception {
        List lista = this.con.listaAvanceMetas(datos);
        return lista;

    }
       public List listaAvanceMetasEsc(DatosBean datos) throws Exception {
        List lista = this.con.listaAvanceMetasEsc(datos);
        return lista;

    }
       public List listaAlumnosNuevos(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosNuevos(datos);
        return lista;

    }
        public List listaAlumnosNuevosEsc(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosNuevosEsc(datos);
        return lista;

    }
        public List listaAlumnosReingreso(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosReingreso(datos);
        return lista;

    }
         public List listaAlumnosReingresoEsc(DatosBean datos) throws Exception {
        List lista = this.con.listaAlumnosReingresoEsc(datos);
        return lista;

    }
       
      public List proyectos(DatosBean datos) throws Exception {
        List lista = this.con.proyectos(datos);
        return lista;

    }
      public List proyectosGeneral(DatosBean datos) throws Exception {
        List lista = this.con.proyectosGeneral(datos);
        return lista;

    }
    
     public List listaTotalAsesorProyecto(DatosBean datos) throws Exception {
        List lista = this.con.listaTotalAsesorProyecto(datos);
        return lista;

    }
       public List listaMunEsc(DatosBean datos) throws Exception {
        List lista = this.con.listaMunEsc(datos);
        return lista;

    }
        public List listaMunEscGeneral(DatosBean datos) throws Exception {
        List lista = this.con.listaMunEscGeneral(datos);
        return lista;

    }
       public List listaEmpAlu(DatosBean datos) throws Exception {
        List lista = this.con.listaEmpAlu(datos);
        return lista;

    }
        public List listaEmpAluGeneral(DatosBean datos) throws Exception {
        List lista = this.con.listaEmpAluGeneral(datos);
        return lista;

    }
     
    public String AlumnosNuevoIngresoA(DatosBean datos) throws Exception {
        String nuevos = this.con.AlumnosNuevoIngresoA(datos);
        return nuevos;

    } 
    
     public String AlumnosActivosPeriodoA(DatosBean datos) throws Exception {
        String periodo = this.con.AlumnosActivosPeriodoA(datos);
        return periodo;

    }  
     
    public String AlumnosNuevoIngreso(DatosBean datos) throws Exception {
        String nuevos = this.con.AlumnosNuevoIngreso(datos);
        return nuevos;

    } 
    
     public String AlumnosActivosPeriodo(DatosBean datos) throws Exception {
        String periodo = this.con.AlumnosActivosPeriodo(datos);
        return periodo;

    } 
     
   //******************************************************************REGISTRO DE ALUMNO INDIVIDUAL*************************************************************
     
      public List ConsultaAlumnos2(DatosBean obj) throws Exception {
        List lista = this.con.ConsultaAlumnos2(obj);
        return lista;
    }
      
      public String ConsultaStatus(DatosBean obj) throws Exception {
        String status = this.con.ConsultaStatus(obj);
        return status;
    }
     
      public boolean GuardaAlumnos(AlumnosBean objdatos) throws Exception  {
        return this.con.GuardaAlumnos(objdatos);
    }
      
       public boolean HabilitarAlumno(AlumnosBean objdatos) throws Exception  {
        return this.con.HabilitarAlumno(objdatos);
    }

     

}
