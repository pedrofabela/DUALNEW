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
                        <link rel="shortcut icon" href="images/portalSE.png" />
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




                                window.onload = function () {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
                                    var pos = window.name || 0;
                                    window.scrollTo(0, pos);

                                    window.location.hash = "no-back-button";
                                    window.location.hash = "Again-No-back-button" //chrome
                                    window.onhashchange = function () {
                                        window.location.hash = "no-back-button";
                                    }

                                }

                                window.onunload = function () {
                                    window.name = self.pageYOffset
                                            || (document.documentElement.scrollTop + document.body.scrollTop);


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
                                        <div class="container"  >
                                            <div class="modal-content" style="border-radius: 10px;">
                                                <div class="modal-header bg-secondary col-lg-12">
                                                    <h5 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> REGISTRO DE ALUMNO AL SISTEMA DUAL</h5> 
                                                    <br/>
                                                </div>  
                                                <div class="modal-body col-lg-12"  >

                                                    <div class="form-group col-lg-auto ">
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <label class="col-form-label text-muted" for="curp">INGRESE EL CURP DEL ALUMNO: </label>
                                                                <s:textfield  cssClass="form-control text-uppercase " name="al.CURPA" id="al.CURPA" maxLength="18"/>
                                                                <s:fielderror fieldName="ErrorValCurp" cssClass="alert alert-danger"/>  
                                                                <br/>
                                                                <a class="btn bg-primary text-white" href="Javascript:Accion('BuscarCurp')">CONSULTAR CURP</a>
                                                            </div> 
                                                            &nbsp;
                                                            <s:if test="BanExisteAlum">
                                                                <div class="alert bg-warning"  style="width:100%; border-radius: 5px; ">
                                                                    <h5 align="center" style="color: #ffffff">EL ALUMNO QUE INTENTA REGISTRAR YA EXISTE EN LA BASE DE DATOS</h5>
                                                                </div>
                                                            </s:if>    
                                                            <s:if test="BanAlumnoEgresado">
                                                                <div class="alert bg-warning"  style="width:100%; border-radius: 5px; ">
                                                                    <h5 align="center" style="color: #ffffff">EL ALUMNO QUE INTENTA REGISTRAR YA SE ENCUENTRA CON ESTATUS DE EGRESADO</h5>
                                                                </div>
                                                            </s:if>    
                                                            <s:if test="BanExisteAlumStatusInhabil">

                                                                <div  class="modal-dialog bg-info" role="document">
                                                                    <div class="modal-content ">
                                                                        <div class="modal-header bg-secondary">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Habilitar Alumno</h5>
                                                                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true"></span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body bg-primary">El Alumno que intenta registrar ya se encuentra en la base de datos con un estatus inhabilitado. Desea Habilitar al Alumno?</div>
                                                                        <div class="modal-footer bg-secondary">

                                                                            <a class="btn btn-primary" href="Javascript:Accion('HabilitarAlumno')">Aceptar</a>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                            </s:if>   

                                                        </div>
                                                    </div>


                                                    <s:if test="BANCURPENCONTRADA">   
                                                        <s:hidden name="BANCURPENCONTRADA"    value="%{BANCURPENCONTRADA}"></s:hidden>      
                                                            <div class="row">
                                                                <div class="alert bg-info"  style="width:100%; border-radius: 5px; ">
                                                                    <h5 align="center" style="color: #ffffff">Cupr verificada con renapo</h5>
                                                                </div>
                                                                <div class="form-group col-lg-12">
                                                                    <div class="col-lg-12 bg-primary">
                                                                        <h5>Datos Personales</h5>
                                                                    </div>
                                                                </div> 
                                                                <div class="form-group col-lg-4">
                                                                    <label class="col-form-label text-muted" for="CURP">CURP:</label>
                                                                    <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.CURP" id="al.CURP" maxLength="20" readonly="true"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorCURP" cssClass="alert alert-danger"></s:fielderror>
                                                                    </div> 
                                                                </div>
                                                                <div class="form-group col-lg-12 ">
                                                                    <label class="col-form-label text-muted" style="text-align : left;" for="NOMBREA">NOMBRE: </label>
                                                                    <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.NOMBRE" id="al.NOMBRE" readonly="true" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorNom" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="APELLIDOP">APELLIDO PATERNO:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.APELLIDOP" id="al.APELLIDOP" readonly="true"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorApeP" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="APELLIDOM">APELLIDO MATERNO:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.APELLIDOM" id="al.APELLIDOM" readonly="true"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorApeM" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>    
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="SEXO">SEXO:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.SEXO" id="al.SEXO" readonly="true"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorSexo" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>   
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="Fecha">FECHA DE NACIMIENTO:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.FECNAC" id="al.FECNAC" readonly="true"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorFecNac" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>      
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="Domicilio">DOMICILIO:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.DOMICILIO" id="al.DOMICILIO" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorDomicilio" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="Colonia">COLONIA:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.COLONIA" id="al.COLONIA" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorColonia" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>     
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="cp">CP:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.CP" id="al.CP" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorCP" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>     
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted " for="Municipio" >MUNICIPIO:</label>
                                                                <div class="col-sm-auto ">
                                                                    <s:select  name="al.CVE_MUN" id="al.CVE_MUN" list="ListaMunicipios"  listKey="ID"  listValue="MUNICIPIO"  headerKey="" headerValue="Municipio" cssClass="form-control " ></s:select>
                                                                    <s:fielderror fieldName="ErrorMunicipio" cssClass="alert alert-danger" />
                                                                </div> 
                                                            </div>      

                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="cp">TELEFONO:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.TELEFONO" id="al.TELEFONO" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorTel" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>                                                     
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="correo">Email:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control " name="al.CORREO" id="al.CORREO" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorCorreo" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div> 
                                                            <div class="form-group col-lg-12">
                                                                <div class="col-lg-12 bg-primary">
                                                                    <h5>Datos Academicos</h5>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="CCT">CCT: </label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.CCT" id="al.CCT" readonly="true"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorCCT" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>    
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="MATRICULA">MATRICULA: </label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.MATRICULA" id="al.MATRICULA" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorMatricula" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted " for="CARRERA" >CARRERA:</label>
                                                                <div class="col-sm-auto ">
                                                                    <s:select  name="al.CLAVECARRERA" id="al.CLAVECARRERA" list="ListaCarreras"  listKey="CLAVECARRERA"  listValue="NOMBRE_CARRERA"  headerKey="" headerValue="--SELECCIONE UNA CARRERA" cssClass="form-control " ></s:select>
                                                                    <s:fielderror fieldName="ErrorCarrera" cssClass="alert alert-danger" />
                                                                </div> 
                                                            </div>  
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="grado">GRADO: </label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.GRADO_CURSA" id="al.GRADO_CURSA" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorGrado" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>    
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="PROMEDIO">PROMEDIO: </label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.PROMEDIOGRAL" id="al.PROMEDIOGRAL" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorPromedio" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div> 
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="SituacionAca">SITUACION ACADEMICA: </label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="al.SITUACIONACA" id="al.SITUACIONACA" ></s:textfield>
                                                                    <s:fielderror fieldName="ErrorSituacioAca" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div> 
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="tipoalu">TIPO DE ALUMNO: </label>
                                                                <div class="col-sm-auto">
                                                                    <s:select  name="al.TIPO_ALUM" id="al.TIPO_ALUM" list="ListaTipoAlumno"  listKey="ID_TIPOALUM"  listValue="NOM_TIPO"  headerKey="" headerValue="--SELECCIONE--" cssClass="form-control " ></s:select>                                                                  
                                                                    <s:fielderror fieldName="ErrorTipoAlu" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group col-lg-4">
                                                                <label class="col-form-label text-muted" for="FI">FECHA DE INGRESO A DUAL:</label>
                                                                <div class="col-sm-auto">
                                                                    <s:textfield name="al.FECHA_INGRESO_DUAL" id="Fecha"  placeholder="Fecha de ingreso a DUAl" required="true" readonly="true" cssClass="form-control text-uppercase"  />
                                                                    <s:fielderror fieldName="ErrorFID" cssClass="alert alert-danger"/>
                                                                </div> 
                                                            </div>     
                                                            <div class="form-group col-lg-12">                                                                                     
                                                                <a class="btn bg-success text-white" href="Javascript:Accion('RegistrarAlum')" onclick="this.onclick = function () {
                                                                            return false
                                                                        }">REGISTRAR ALUMNO</a>
                                                            </div>  



                                                        </div>
                                                    </s:if>     

                                                </div>





                                                </header>




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
                                                            <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">Unidad de Desarrollo Administrativo e Informática</div>
                                                            <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">Para asistencia y soporte técnico sobre este sistema:</div>
                                                            <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">mesadeservicios@edugem.gob.mx</div>
                                                            <div style="width: 80%; height: 10px; display: block; margin: auto; margin-top: 15px;">Llamanos (01 722) 2264304</div>

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


                                                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                                <!-- Plugin JavaScript -->
                                                <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
                                                <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

                                                <!-- Contact Form JavaScript -->
                                                <script src="js/jqBootstrapValidation.js"></script>
                                                <script src="js/contact_me.js"></script>

                                                <!-- Custom scripts for this template -->
                                                <script src="js/freelancer.min.js"></script>

                                                <s:iterator value="ListaMunicipios" id="ListaMunicipios" status="stat">
                                                    <s:hidden  name = "ListaMunicipios[%{#stat.index}].ID" id="ID"></s:hidden>
                                                    <s:hidden  name = "ListaMunicipios[%{#stat.index}].MUNICIPIO" id="MUNICIPIO"></s:hidden>
                                                </s:iterator>

                                                <s:iterator value="ListaCarreras" id="ListaCarreras" status="stat">
                                                    <s:hidden  name = "ListaCarreras[%{#stat.index}].CLAVECARRERA" id="CLAVECARRERA"></s:hidden>
                                                    <s:hidden  name = "ListaCarreras[%{#stat.index}].NOMBRE_CARRERA" id="NOMBRE_CARRERA"></s:hidden>
                                                </s:iterator>

                                                <s:iterator value="ListaTipoAlumno" id="ListaTipoAlumno" status="stat">
                                                    <s:hidden  name = "ListaTipoAlumno[%{#stat.index}].ID_TIPOALUM" id="ID_TIPOALUM"></s:hidden>
                                                    <s:hidden  name = "ListaTipoAlumno[%{#stat.index}].NOM_TIPO" id="NOM_TIPO"></s:hidden>
                                                </s:iterator>


                                            </s:form>

                                            </body>

                                            </html>
