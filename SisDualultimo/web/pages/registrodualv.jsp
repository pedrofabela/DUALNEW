<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">

    function buscar(accion) {

        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }

    
    function Accion(accion) {

        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }
    
   function aMayusculas(obj,id){
    obj = obj.toUpperCase();
    document.getElementById(id).value = obj;
}
   
    //PARA REGRESAR EN DONDE SE QUEDO...........
   
   
</script>

<script>

function startTime() {
    var today = new Date();
    var hr = today.getHours();
    var min = today.getMinutes();
    var sec = today.getSeconds();
    ap = (hr < 12) ? "<span>am</span>" : "<span>pm</span>";
    hr = (hr == 0) ? 12 : hr;
    hr = (hr > 12) ? hr - 12 : hr;
    //Add a zero in front of numbers<10
    hr = checkTime(hr);
    min = checkTime(min);
    sec = checkTime(sec);
    document.getElementById("clock").innerHTML = hr + ":" + min + ":" + sec + " " + ap;
    
    var months = ['Enero', 'Febrero', 'Marzo', 'April', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
    var days = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado'];
    var curWeekDay = days[today.getDay()];
    var curDay = today.getDate();
    var curMonth = months[today.getMonth()];
    var curYear = today.getFullYear();
    var date = curDay+" "+'de'+" "+curMonth;
    document.getElementById("date").innerHTML = date;
    
    var time = setTimeout(function(){ startTime() }, 500);
}
function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
</script>









<html lang="en">

    <head>
        
        
        

        <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="">
                        <meta name="author" content="">

                            <title>DUAL</title>

                            <link href=" <s:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" media="all" rel="stylesheet" type="text/css"/>
                            <!-- Custom fonts for this template-->
                            <link href=" <s:url value="/vendor/fontawesome-free/css/all.min.css"/>" media="all" rel="stylesheet" type="text/css"/>        
                            <!-- Page level plugin CSS-->
                            <link href=" <s:url value="/vendor/datatables/dataTables.bootstrap4.css"/>" media="all" rel="stylesheet" type="text/css"/>            
                            <!-- Custom styles for this template-->
                            <link href=" <s:url value="/css/sb-admin.css"/>" media="all" rel="stylesheet" type="text/css"/> 

                           

                            </head>

                            <body id="page-top" onload="startTime()">
                                <s:form name="formularioPrincipal" id="formularioPrincipal">

                                    <nav class="navbar navbar-expand navbar-dark " style="height: 65px; background: #8181a4; box-shadow: 2px 2px 5px #333; border-bottom: 3px solid #cccccc;">


                                        <span class="navbar-brand mr-1" style="font-size: 25px;">DUAL</span>

                                        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                                            <i class="fas fa-bars" style="font-size: 25px;"></i>
                                        </button>

                                        <!-- Navbar Search -->
                                        <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

                                        </div>

                                        <!-- Navbar -->
                                        <ul class="navbar-nav ml-auto ml-md-0">    
                                            <li class="nav-item dropdown no-arrow">
                                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-user-circle fa-fw" style="background: red; width: 40px; height: 40px; font-size: 40px; border-radius: 50%;"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">                                           
                                                    <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">Cerrar Sesion</a>
                                                </div>
                                            </li>
                                        </ul>

                                    </nav>

                                    <div id="wrapper">

                                        <!-- Sidebar -->
                                        <jsp:include page="/pages/menuB.jsp"/>

                                        <div id="content-wrapper">
                                             <div class="container-fluid">
                                                                                           
                                                   
                                                        <div  style="width:99%" >
                                                                     <div class="modal-content">
                                                                
                                                                                        <div class="modal-header" >

                                                                                            <img src="images/edomex2.png" alt="edomex" ></img>

                                                                                            <div style="text-align: center; margin-right: 30px; background:  #8181a4; margin-top: 10px; width: 170px; height: 90px; border-radius: 20px; color: white; font-size: 15px; "> <h7><i class="fas fa-clock" style="font-size: 25px; margin-top: 8px;"></i><div id="date" style="margin-top: 5px;" ></div><div id="clock"></div> </h7>   </div> 


                                                                                        </div>
                                                                
                                                             
                                                                
                                                                
                                                                
                                                               

                                                               
                                                                
                                                                <br></br>
                                                                
                                                                
                                                                
                                                                <!--BUSQUEDA DE AUDIENCIA -->
                                                                
                                                               
                                                                
                                                                  <div style="width:100%; height: 30px; background: #a2a3b8; text-align: center; color:white;   ">
                                                                            <h5 style="margin-top: 2px;">Datos del Alumno</h5> 
                                                                            <br/>
                                                                        </div>
                                                                
                                                            
                                                                
                                                                 <div style="width: 95%; margin: auto; margin-top: 5px;  ">
                                                                <div class="table-responsive">  
                                                                        <table class="table table-hover">
                                                                            
                                                                            <tbody>
                                                                                <tr style=" color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999; ">
                                                                                    <td style="width: 25%;">Nombre</td>
                                                                                    <td style="width: 25%;">Municipio</td>
                                                                                    <td style="width: 25%;">Teléfono</td>
                                                                                    <td style="width: 25%;">Ocupación</td>
                                                                                    
                                                                                </tr>
                                                                                
                                                                                <s:iterator value="ListaConsultaCiudadano" id="ListaConsultaCiudadano" status="stat">
                                                                                    <tr style="pointer-events: none; background: #efeaf0; font-size: 12px;">
                                                                                    <td style="width: 25%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                                    <td style="width: 25%;"><s:property value="MUNICIPIO"/></td>
                                                                                    <td style="width: 25%;"><s:property value="TELEFONO"/></td>
                                                                                    <td style="width: 25%;"><s:property value="OCUPACION" /></td>
                                                                                    
                                                                                </tr>
                                                                                </s:iterator>
                                                                               
                                                                            </tbody>
                                                                        </table>
                                                                
                                                                </div>   
                                                                    
                                                               </div> 
                                                                <div style="width:100%; height: 30px; background: #a2a3b8; text-align: center; color:white;   ">
                                                                            <h5 style="margin-top: 2px;">Responsables del Proyecto</h5> 
                                                                            <br/>
                                                                        </div>
                                                                
                                                                
                                                                 <hr style="width: 99% ; margin: auto; height: 8px; box-shadow: 5px 5pc 15px #333;"/>
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                               
                                                             <!-- ++++++++++++++++++++++++++++++++++++++++++++++     -->
                                                             
                                                             
                                                             
                                                           
                                                                      <div class="row">
                                                                        
                                                                        
                                                                        
                                                                        
                                                                     
                                                                        
                                                                        
                                                                     
                                                                    
                                                                        
                                                                  
                                                                      
                                                                        <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Datos del Proyecto</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  

                                                                            
                                                                             <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Empresa</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                            
                                                                            
                                                                             <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Responsable de la Empresa</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                            
                                                                            



                                                                    </div>
                                                                            
                                                                            
                                                                              <div style="width:100%; height: 30px; background: #a2a3b8; text-align: center; color:white;   ">
                                                                            <h5 style="margin-top: 2px;">Datos del proyecto</h5> 
                                                                            <br/>
                                                                        </div>
                                                                            
                                                                            
                                                                            <div class="row">
                                                                                
                                                                                 <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Apellido Paterno">Nombre del Proyecto</label>
                                                                                <div class="col-sm-auto">

                                                                                      
                                                                                      
                                                                                <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>

                                                                            
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                                
                                                                                
                                                                      <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Apellido Paterno">Fecha de Inicio</label>
                                                                                <div class="col-sm-auto">

                                                                                   
                                                                                      
                                                                                <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>

                                                                            
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                                
                                                                                 <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Apellido Paterno">Fecha de Termino</label>
                                                                                <div class="col-sm-auto">

                                                                                     
                                                                                      
                                                                                <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>

                                                                            
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                                
                                                                                
                                                                                 <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Apellido Paterno">Área de conocimiento</label>
                                                                                <div class="col-sm-auto">

                                                                                    
                                                                                      
                                                                                <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>

                                                                            
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                 <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Apellido Paterno">Número de Horas</label>
                                                                                <div class="col-sm-auto">

                                                                                     
                                                                                      
                                                                                <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>

                                                                            
                                                                        </div> 
                                                                          
                                                                    </div> 
                                                                                 <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Apellido Paterno">Convenio</label>
                                                                                <div class="col-sm-auto">

                                                                                     
                                                                                      
                                                                                <s:textfield list="{'SEDUC'}" cssClass="form-control text-uppercase" name="datos.FOLIO_REFERENCIA" id="datos.FOLIO_REFERENCIA"  maxlength="200" cssStyle=""></s:textfield>

                                                                            
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                                
                                                                                
                                                                            </div>
                                                                            
                                                                            
                                                                            
                                                                
                                                                        <div class="row">
                                                                           
                                                                        <div class="form-group col-lg-4" style="margin-top: 45px;">
                                                                                <label class="col-form-label" for="Apellido Paterno"></label>
                                                                                <div class="col-sm-auto">

                                                                                <div class="col-sm-auto " style="margin: auto;">
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:Accion('guardaAudiencia')" style="background: green;" ><i class="fa fa-user-plus"></i> Guardar datos </a>
                                                                        </div>    
                                                                                
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                           
                                                                       
                                                                        
                                                                    </div>
                                                                         
                                                                   
                                                                
                                                                        
                                                                <br/> 
                                                               
                                                                
                                                
                                                             
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                <s:textfield name="datos.ID" id="ID" cssStyle="display:none;" />  
                                                             
                                                             
                                                                

                                                              
                                            </div>
                                        </div>
                                                                        
                                               </div>
                                        </div>    
                                                                        
                                                                        
                                                                        
                                               

                                                                  <!-- Campos de nombre-->

                                                                        
                                                                        
                                                           
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                        <!-- Sticky Footer -->
                                        <footer class="sticky-footer" style="width: 100%; background-color: #ced4da; ">
                                            <div class="container my-auto">
                                                <div class="copyright text-center my-auto">
                                                    <span>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</span>
                                                </div>
                                            </div>
                                        </footer>


                                        <!-- /.content-wrapper -->

                                    </div>
                                                                        
                            </div>
                            
                            
                           
                                
                                    <!-- /#wrapper -->

                                    <!-- Scroll to Top Button-->
                                    <a class="scroll-to-top rounded" href="#page-top">
                                        <i class="fas fa-angle-up"></i>
                                    </a>

                                    <!-- Logout Modal-->
                                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Cerrar Sesión</h5>
                                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true"></span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">Estas seguro que deseas cerrar sesión.</div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                    <a class="btn btn-primary" href="Javascript:Accion('CerrarSesion')">Aceptar</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Bootstrap core JavaScript-->
                                    <script src="vendor/jquery/jquery.min.js"></script>
                                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                    <!-- Core plugin JavaScript-->
                                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                                    <!-- Page level plugin JavaScript-->
                                    <script src="vendor/chart.js/Chart.min.js"></script>
                                    <script src="vendor/datatables/jquery.dataTables.js"></script>
                                    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

                                    <!-- Custom scripts for all pages-->
                                    <script src="js/sb-admin.min.js"></script>

                                    <!-- Demo scripts for this page-->
                                    <script src="js/demo/datatables-demo.js"></script>
                                    <script src="js/demo/chart-area-demo.js"></script>





                                  
                                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
                                    </s:iterator>

                                    <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">                        
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MODULO" id="MODULO"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MODPADRE" id="MODPADRE"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MOD" id="MOD"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].ACCION" id="ACCION"></s:hidden>
                                    </s:iterator>
                                    
                                    
                                     <s:iterator value="ListaSerPub" id="ListaSerPub" status="stat">                        
                                        <s:hidden  name = "ListaSerPub[%{#stat.index}].ID_SERPUB" id="ID_SERPUB"></s:hidden>
                                        <s:hidden  name = "ListaSerPub[%{#stat.index}].NOMBRE_SERPUB" id="NOMBRE_SERPUB"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                      <s:iterator value="ListaMotivo" id="ListaMotivo" status="stat">                        
                                        <s:hidden  name = "ListaMotivo[%{#stat.index}].ID_MOTIVO" id="ID_MOTIVO"></s:hidden>
                                        <s:hidden  name = "ListaMotivo[%{#stat.index}].MOTIVO" id="MOTIVO"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                      <s:iterator value="ListaVisitas" id="ListaVisitas" status="stat">                        
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].FOLIO" id="FOLIO"></s:hidden>
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].FECHA_AUDI" id="FECHA_AUDI"></s:hidden>
                                        
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].NOMBRE_SERPUB" id="NOMBRE_SERPUB"></s:hidden>
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].ASUNTO" id="ASUNTO"></s:hidden>
                                        
                                         <s:hidden  name = "ListaVisitas[%{#stat.index}].MOTIVO" id="MOTIVO"></s:hidden>
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].ESTATUS" id="ESTATUS"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                    
                                    
                                    
                                    
                                    

                                </s:form>
                            </body>

                            </html>
