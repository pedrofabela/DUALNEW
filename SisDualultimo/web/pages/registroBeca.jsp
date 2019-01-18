<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">

    <head>

        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <meta name="description" content="">
                    <meta name="author" content="">

                        <title>SisDUAL</title>

                        <!-- Bootstrap core CSS -->
                        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

                        <!-- Custom fonts for this template -->
                        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
                        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
                        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"/>

                        <!-- Plugin CSS -->
                        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css"/>

                        <!-- Custom styles for this template -->
                        <link href="css/freelancer.min.css" rel="stylesheet"/>

                        <link href=" <s:url value="css/CssExtras.css"/>" media="all" rel="stylesheet" type="text/css"/> 

                        <!-- Bootstrap core JavaScript -->
                        <script src="vendor/jquery/jquery.min.js"></script>   

                        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
                            <link rel="stylesheet" href="css/estilo.css"/>

                            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                            <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

                            <script>
                                $.datepicker.regional['es'] = {
                                    closeText: 'Cerrar',
                                    prevText: '<Ant',
                                    nextText: 'Sig>',
                                    currentText: 'Hoy',
                                    monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                                    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                                    dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                                    dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie', 'Sáb'],
                                    dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
                                    weekHeader: 'Sm',
                                    dateFormat: 'dd/mm/yy',
                                    changeMonth: true,
                                    changeYear: true,
                                    firstDay: 1,
                                    isRTL: false,
                                    showMonthAfterYear: false,
                                    yearSuffix: ''
                                };
                                $.datepicker.setDefaults($.datepicker.regional['es']);
                                $(function () {

                                    $("#Fecha").datepicker();

                                });

                                $(function () {
                                    $("#Fecha1").datepicker();
                                });
                            </script>



                            <script type="text/javascript">

                                function Accion(accion) {

                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.submit();
                                }

                                function ModificaBeca(accion, valor) {

                                    document.formularioPrincipal.ID_BECA.value = valor;
                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.target = "_self";
                                    document.formularioPrincipal.submit();

                                }

                                function EliminaBeca(accion, valor) {

                                    document.formularioPrincipal.ID_BECA.value = valor;
                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.target = "_self";
                                    document.formularioPrincipal.submit();

                                }





                            </script>


                            </head>

                            <body id="page-top">
                                <s:form name="formularioPrincipal" id="formularioPrincipal" enctype="multipart/form-data">

                                    <!-- Navigation -->
                                    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
                                        <div class="container">
                                            <img class="img-fluid mb-2 d-block mx-auto" src="images/logos-10.png" alt=""/>   
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded " type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                                                Menu
                                                <i class="fas fa-bars"></i>
                                            </button>
                                            <div class="collapse navbar-collapse" id="navbarResponsive">
                                                <ul class="navbar-nav ml-auto">
                                                    <li class="nav-item mx-0 mx-lg-1">
                                                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Javascript:Accion('ReturnStar')">Inicio</a>
                                                    </li>
                                                    <li class="nav-item dropdown no-arrow">
                                                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            <i class="fas fa-user-circle fa-fw" style="font-size: 40px;"></i>
                                                        </a>
                                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">                                           
                                                            <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">Cerrar Sesion</a>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </nav>

                                    <!-- Header -->
                                    <header class="masthead text-white text-center" style="background: #0050A6;" >

                                        <div class="table-responsive col-lg-12">  
                                            <table class="table "  >

                                                <tbody class="col-lg-12">
                                                    <tr>
                                                        <td colspan="6">

                                                            <table class="table table-hover" >
                                                                <tr>
                                                                    <td class="text-center bg-primary" style="border-top-left-radius: 10px; border-top-right-radius: 10px;"colspan="6" ><h5>DATOS DE ALUMNO</h5></td>
                                                                </tr>
                                                                <tr style="color:#000; background: #cccccc;"  >
                                                                    <td >Curp</td>
                                                                    <td >Matricula</td>
                                                                    <td >Nombre del alumno</td>
                                                                    <td >Carrera</td>

                                                                </tr>
                                                                <tr style=" background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">
                                                                    <s:iterator value="ListaAlumnos2" id="ListaAlumnos2" status="stat">
                                                                        <td ><s:property value="CURP"/></td>
                                                                        <td ><s:property value="MATRICULA"/></td>
                                                                        <td ><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td ><s:property value="NOMBRE_CARRERA" /></td>

                                                                        <s:hidden  name = "ListaAlumnos2[%{#stat.index}].CURP" id="CURP"></s:hidden> 
                                                                        <s:hidden  name = "ListaAlumnos2[%{#stat.index}].MATRICULA" id="MATRICULA"></s:hidden> 
                                                                        <s:hidden  name = "ListaAlumnos2[%{#stat.index}].NOMBRE_COMPLETO" id="NOMBRE_COMPLETO"></s:hidden> 
                                                                        <s:hidden  name = "ListaAlumnos2[%{#stat.index}].NOMBRE_CARRERA" id="NOMBRE_CARRERA"></s:hidden> 

                                                                    </s:iterator>   
                                                                </tr>     
                                                            </table>    
                                                        </td>
                                                    </tr>        
                                                    <tr>
                                                        <td class="text-center bg-primary" style="border-top-left-radius: 10px; border-top-right-radius: 10px;" colspan="6" ><h5>REGISTRO DE BECAS</h5></td>
                                                    </tr>
                                                    <tr style=" background: #ffffff;  font-size: 15px;">
                                                        <td colspan="6">



                                                            <div class="container-fluid"  >
                                                                <div class="modal-content" style="border-radius: 10px;"> 
                                                                    <div class="modal-body "  >
                                                                        <div class="row">
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label text-muted" for="RFC">FUENTE:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="be.FUENTE" id="be.FUENTE" maxLength="20" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorFuente" cssClass="alert alert-danger"></s:fielderror>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-4 ">
                                                                                    <label class="col-form-label text-muted" style="text-align : left;" for="RAZON">MONTO:</label>
                                                                                    <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="be.MONTO" id="be.MONTO"  ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorMonto" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label text-muted" for="GIRO">PERIODICIDAD:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="be.PERIODICIDAD" id="be.PERIODICIDAD" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorPeriodo" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label text-muted" for="SECTOR">DURACIÓN:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="be.DURACION" id="be.DURACION" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorDuracion" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>                                                                                                                                                                                                                                                                                                                     
                                                                        </div>
                                                                        <div class="form-group col-lg-12">                                                                                     
                                                                            <a class="btn bg-success text-white" href="Javascript:Accion('AgregarBeca')">AGREGAR BECA</a>
                                                                        </div>        
                                                                    </div>
                                                                </div> 
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr><td>&nbsp;</td></tr>
                                                                           
                                                        <tr>
                                                            <td class="text-center bg-primary" style="border-top-left-radius: 10px; border-top-right-radius: 10px;" colspan="6" ><h5>BECAS REGISTRADAS</h5></td>
                                                        </tr>
                                                        <s:if test="ListaBecas.size()>0"> 
                                                        <tr style="color:#000 ; background: #cccccc" >

                                                            <td >Fuente</td>
                                                            <td >Monto</td>
                                                            <td >Periodicidad</td>
                                                            <td >Duración</td>
                                                            <td >Modificar</td>
                                                            <td >Eliminar</td>

                                                        </tr>
                                                        <s:iterator value="ListaBecas" id="ListaBecas" status="stat">
                                                            <tr style=" background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">


                                                                <td ><s:property value="FUENTE"/></td>
                                                                <td ><s:property value="MONTO"/></td>
                                                                <td ><s:property value="PERIODICIDAD"/></td>
                                                                <td ><s:property value="DURACION" /></td>
                                                                <td >
                                                                    <a href="" data-toggle='modal' data-target='#editBeca' 
                                                                       data-fuente='<s:property value="FUENTE"/>' 
                                                                       data-monto='<s:property value="MONTO"/>' 
                                                                       data-periodo='<s:property value="PERIODICIDAD"/>' 
                                                                       data-duracion='<s:property value="DURACION"/>' 
                                                                       data-id='<s:property value="ID_BECA"/>' 
                                                                       ><i class="fa fa-edit" style="font-size: 25px; color: #004085; "></i> <span class="text-muted">Modificar Beca</span> </a>
                                                                </td>
                                                                <td >
                                                                    <a href="#" data-toggle='modal' data-target='#DeleteBeca' 
                                                                       data-id_eliminar='<s:property value="ID_BECA"/>'>
                                                                        <i class="fa fa-trash" style="font-size: 25px; color: #004085; "></i><span class="text-muted"> Eliminar Beca</span></a>
                                                                </td>

                                                            </tr>   
                                                            <s:hidden  name = "ListaBecas[%{#stat.index}].FUENTE" id="FUENTE"></s:hidden>
                                                            <s:hidden  name = "ListaBecas[%{#stat.index}].MONTO" id="MONTO"></s:hidden>
                                                            <s:hidden  name = "ListaBecas[%{#stat.index}].PERIODICIDAD" id="PERIODICIDAD"></s:hidden>
                                                            <s:hidden  name = "ListaBecas[%{#stat.index}].DURACION" id="DURACION"></s:hidden>
                                                            <s:hidden  name = "ListaBecas[%{#stat.index}].ID_BECA" id="ID_BECA"></s:hidden>
                                                        </s:iterator>   
                                                    </s:if> 
                                                    
                                                    <s:else>
                                                        <tr>
                                                            <td>
                                                                 <div style="color: #e1173e; font-size: 20px; text-align: center;">No hay Becas Registradas </div>
                                                            </td>
                                                        </tr>
                                                       
                                                    </s:else>
                                                </tbody>
                                            </table>

                                        </div> 
                                    </header>

                                    <s:textfield name="datos.CCT" id="datos.CCT" cssStyle="display:none;"></s:textfield>  
                                    <s:textfield name="datos.CURP" id="datos.CURP" cssStyle="display:none;"></s:textfield>     



                                        <footer class="footer text-center bg-primary">



                                            <div class="row" style="width: 100%; ">
                                                <div class="form-group col-lg-4"style="margin: auto; color:white; ; text-align: center; margin-top: 30px; ">

                                                    <div style="width: 100%; height: 25px; display: block; text-decoration: underline; ">Aviso de Privacidad</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Consulta nuestro aviso de privacidad</div>



                                                </div>  

                                                <div class="form-group col-lg-4"style="margin: auto; color:white;  text-align: center; margin-top: 30px;">

                                                    <div style="width: 100%; height: 25px; display: block; text-decoration: underline;">Enlaces de intéres</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Gobierno del Estado de México</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto;">Secretaría de Educación del Estado de México </div>



                                                </div>  

                                                <div class="form-group col-lg-4"style="margin: auto; color:white;  text-align: center; margin-top: 30px;">

                                                    <div style="width: 100%; height: 25px; display: block;  text-decoration: underline;">Acerca del portal</div>
                                                    <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Unidad de Desarrollo Administrativa e Informática</div>


                                                </div>  

                                            </div>

                                        </footer>                     
                                        <div class="copyright bg-secondary py-4 text-center text-white">
                                            <div class="container">
                                                <small>Copyright &copy; Your Website 2018</small>
                                            </div>
                                        </div>





                                        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
                                        <div class="scroll-to-top d-lg-none position-fixed ">
                                            <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>



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

                                        <!-- Actualiza Modal-->
                                        <div class="modal fade" id="editBeca" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-lg " role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header bg-primary">
                                                        <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> ACTUALIZACIÓN DE DATOS DE BECA</h4> 
                                                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true"></span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">

                                                        <div class="row">
                                                            <div class="form-group col-lg-6">
                                                                <label class="col-form-label" for="matricula">FUENTE:</label>
                                                                <div class="col-sm-auto">
                                                                <s:textfield  cssClass="form-control text-uppercase" name="be.FUENTEA" id="fuente" ></s:textfield>
                                                                <s:fielderror fieldName="ErrorFuenteA" cssClass="alert alert-danger"></s:fielderror>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-lg-6 ">
                                                                <label class="col-form-label" style="text-align : left;" for="curp">MONTO:</label>
                                                                <div class="col-sm-auto">
                                                                <s:textfield  cssClass="form-control text-uppercase" name="be.MONTOA" id="monto" ></s:textfield>
                                                                <s:fielderror fieldName="ErrorMontoA" cssClass="alert alert-danger"/>
                                                            </div> 
                                                        </div>
                                                        <div class="form-group col-lg-12">
                                                            <label class="col-form-label" for="nombre">PERIODICIDAD:</label>
                                                            <div class="col-sm-auto">
                                                                <s:textfield  cssClass="form-control text-uppercase" name="be.PERIODICIDADA" id="periodo" ></s:textfield>
                                                                <s:fielderror fieldName="ErrorPeriodoA" cssClass="alert alert-danger"/>
                                                            </div> 
                                                        </div>
                                                        <div class="form-group col-lg-6">
                                                            <label class="col-form-label" for="apellidop">DURACION:</label>
                                                            <div class="col-sm-auto">
                                                                <s:textfield  cssClass="form-control text-uppercase" name="be.DURACIONA" id="duracion" ></s:textfield>
                                                                <s:fielderror fieldName="ErrorDuracionA" cssClass="alert alert-danger"/>
                                                            </div> 
                                                        </div>    

                                                        <s:textfield name="be.ID_BECAA" id="id" cssStyle="display:none;"></s:textfield>        

                                                        </div>        
                                                        <div class="modal-footer">
                                                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                            <a class="btn btn-primary" href="Javascript:Accion('ActualizarBeca')">Actualizar Beca</a>
                                                        </div>                                         
                                                    </div>
                                                </div>
                                            </div>  
                                        </div>            
                                        <!-- Elimiar Modal-->
                                        <div class="modal fade" id="DeleteBeca" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Eliminar Beca</h5>
                                                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true"></span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">Estas seguro que deseas eliminar la beca seleccionada.
                                                    <s:textfield name="be.ID_BECAE" id="id_eliminar" cssStyle="display:none;"></s:textfield> 
                                                    </div>


                                                    <div class="modal-footer">
                                                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                        <a class="btn btn-primary" href="Javascript:Accion('EliminarBeca')">Aceptar</a>
                                                    </div>

                                                </div>
                                            </div>
                                        </div> 



                                    <s:iterator value="ListaMunicipios" id="ListaMunicipios" status="stat">
                                        <s:hidden  name = "ListaMunicipios[%{#stat.index}].ID" id="ID"></s:hidden>
                                        <s:hidden  name = "ListaMunicipios[%{#stat.index}].MUNICIPIO" id="MUNICIPIO"></s:hidden>
                                    </s:iterator>




                                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                    <!-- Plugin JavaScript -->
                                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
                                    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

                                    <!-- Contact Form JavaScript -->
                                    <script src="js/jqBootstrapValidation.js"></script>
                                    <script src="js/contact_me.js"></script>

                                    <!-- Custom scripts for this template -->
                                    <script src="js/freelancer.min.js"></script>


                                    <script>
                                $('#editBeca').on('show.bs.modal', function (event) {
                                    var button = $(event.relatedTarget) // Button that triggered the modal

                                    var recipient0 = button.data('fuente')
                                    var recipient1 = button.data('monto')
                                    var recipient2 = button.data('periodo')
                                    var recipient3 = button.data('duracion')
                                    var recipient4 = button.data('id')

                                    var modal = $(this)
                                    modal.find('.modal-body #fuente').val(recipient0)
                                    modal.find('.modal-body #monto').val(recipient1)
                                    modal.find('.modal-body #periodo').val(recipient2)
                                    modal.find('.modal-body #duracion').val(recipient3)
                                    modal.find('.modal-body #id').val(recipient4)
                                });
                                    </script>

                                    <script>
                                        $('#DeleteBeca').on('show.bs.modal', function (event) {
                                            var button = $(event.relatedTarget) // Button that triggered the modal


                                            var recipient0 = button.data('id_eliminar')
                                            var modal = $(this)
                                            modal.find('.modal-body #id_eliminar').val(recipient0)
                                        });

                                    </script>  

                                </s:form>

                            </body>

                            </html>
