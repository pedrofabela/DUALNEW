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

                                    window.onunload = function () {
                                        window.name = self.pageYOffset
                                                || (document.documentElement.scrollTop + document.body.scrollTop);


                                    }




                                }
                            </script>


                            </head>

                            <body id="page-top" >
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
                                            <table class="table table-hover" style="background: #0056b3;"  >

                                                <tbody>
                                                    <tr>
                                                        <td class="text-center bg-primary" style="border-top-left-radius: 10px; border-top-right-radius: 10px;" colspan="4"><h5>DATOS DE ALUMNO</h5></td>
                                                    </tr>
                                                    <tr style="color:#000 ; background: #cccccc" >
                                                        <td style="width: 25%;">Curp</td>
                                                        <td style="width: 25%;">Matricula</td>
                                                        <td style="width: 25%;">Nombre del alumno</td>
                                                        <td style="width: 25%;">Carrera</td>

                                                    </tr>
                                                    <tr style="pointer-events: none; background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">
                                                        <s:iterator value="ListaAlumnos2" id="ListaAlumnos2" status="stat">
                                                            <td style="width: 25%;"><s:property value="CURP"/></td>
                                                            <td style="width: 25%;"><s:property value="MATRICULA"/></td>
                                                            <td style="width: 25%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                            <td style="width: 25%;"><s:property value="NOMBRE_CARRERA" /></td>

                                                            <s:hidden  name = "ListaAlumnos2[%{#stat.index}].CURP" id="CURP"></s:hidden> 
                                                            <s:hidden  name = "ListaAlumnos2[%{#stat.index}].MATRICULA" id="MATRICULA"></s:hidden> 
                                                            <s:hidden  name = "ListaAlumnos2[%{#stat.index}].NOMBRE_COMPLETO" id="NOMBRE_COMPLETO"></s:hidden> 
                                                            <s:hidden  name = "ListaAlumnos2[%{#stat.index}].NOMBRE_CARRERA" id="NOMBRE_CARRERA"></s:hidden> 

                                                        </s:iterator>   
                                                    </tr>     
                                                    <s:textfield name="datos.CCT" id="datos.CCT" cssStyle="display:none;"></s:textfield>  
                                                    <s:textfield name="datos.CURP" id="datos.CURP" cssStyle="display:none;"></s:textfield>  
                                                    <s:textfield name="datos.CLAVECARRERA" id="datos.CLAVECARRERA" cssStyle="display:none;"></s:textfield>  

                                                        <tr>
                                                            <td class="text-center bg-primary" style="border-top-left-radius: 10px; border-top-right-radius: 10px;" colspan="4"><h5>DATOS DE LA EMPRESA</h5></td>
                                                        </tr>
                                                        <tr style=" background: #ffffff;  font-size: 15px;">
                                                            <td colspan="4">

                                                                <div class="form-inline col-lg-12 ">
                                                                    <label class="col-form-label text-muted" for="rfc">INGRESE EL RFC DE LA EMPRESA:</label>
                                                                    <div class="col-xs-8">
                                                                    <s:textfield  cssClass="form-control" name="pro.RFCA" id="pro.RFCA" maxLength="18"/>
                                                                    <s:fielderror fieldName="ErrorRFCA" cssClass="alert alert-danger"/>
                                                                </div> 
                                                                <div class="col-sm-auto">
                                                                    <a class="btn bg-primary text-white" href="Javascript:Accion('BuscarRFC')">BUSCAR RFC</a>
                                                                </div>


                                                            </div>
                                                            <s:if test="BanBuscaRFC">
                                                                <s:if test="BuscaRFC.size()>0">
                                                                    <br/>
                                                                    <s:if test="BanEmpresaEncontrada">
                                                                        <div class="alert alert-primary"  style="width:100%; border-radius: 5px; ">
                                                                            <h5 align="center" style="color: #ffffff">Empresa Encontrada</h5>
                                                                        </div>
                                                                    </s:if>
                                                                    <s:if test="BanExisteEmpresa">
                                                                        <div class="alert bg-success"  style="width:100%; border-radius: 5px; ">
                                                                            <h5 align="center" style="color: #ffffff">La empresa con el RFC que intenta registrar ya existe </h5>
                                                                        </div>
                                                                    </s:if>
                                                                    <div class="container-fluid"  >
                                                                        <div class="modal-content" style="border-radius: 10px;"> 
                                                                            <div class="modal-body "  >
                                                                                <div class="row">
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="RFC">RFC:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.RFC" id="pro.RFC" maxLength="20" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorRFC" cssClass="alert alert-danger"></s:fielderror>
                                                                                            </div> 
                                                                                        </div>
                                                                                        <div class="form-group col-lg-12 ">
                                                                                            <label class="col-form-label text-muted" style="text-align : left;" for="RAZON">RAZÓN SOCIAL</label>
                                                                                            <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.RAZON_SOCIAL" id="pro.RAZON_SOCIAL" readonly="true" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorRS" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="GIRO">GIRO:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.GIRO" id="pro.GIRO" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorGiro" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="SECTOR">SECTOR:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.SECTOR" id="pro.SECTOR" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorSector" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>    
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="Domicilio">DOMICILIO:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.DOMICILIOE" id="pro.DOMICILIOE" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorDomicilioE" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>   
                                                                                    <div class="form-group col-lg-5">
                                                                                        <label class="col-form-label text-muted" for="coloniaE">COLONIA:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.COLONIAE" id="pro.COLONIAE" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorColonia" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>      
                                                                                    <div class="form-group col-lg-5">
                                                                                        <label class="col-form-label text-muted" for="localidad">LOCALIDAD:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.LOCALIDADE" id="pro.LOCALIDADE" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorLocalidadE" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>  
                                                                                    <div class="form-group col-lg-2">
                                                                                        <label class="col-form-label text-muted" for="cp">CP:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.CPE" id="pro.CPE" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorCP" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>     
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted " for="Municipio" >MUNICIPIO:</label>
                                                                                        <div class="col-sm-auto ">
                                                                                            <s:select  name="pro.MUNICIPIOE" id="municipio" list="ListaMunicipios"  listKey="ID"  listValue="MUNICIPIO"  headerKey="" headerValue="Municipio" cssClass="form-control " ></s:select>
                                                                                            <s:fielderror fieldName="ErrorMunicipio" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
                                                                                        </div> 
                                                                                    </div>      

                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="cp">TELEFONO:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.TELEFONOE" id="pro.TELEFONOE" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorTel" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>                                                     
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="correo">Email:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control " name="pro.CORREO_ELECTRONICOE" id="correo" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorCorreo" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>  
                                                                                    <div class="form-group col-lg-12">
                                                                                        <label class="col-form-label text-muted" for="REPLEGAL">REP. LEGAL</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.REP_LEGAL" id="pro.REP_LEGAL" readonly="true"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorRep" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>      

                                                                                </div>
                                                                                <s:if test="BanEmpresaRegistrada">
                                                                                    <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                        <h5 align="center" style="color: #ffffff">Empresa Registrada Correctamente</h5>
                                                                                    </div>
                                                                                </s:if>        
                                                                                <div class="form-group col-lg-12">                                                                                     
                                                                                    <a class="btn bg-success text-white" href="Javascript:Accion('AgregarProyecto')">AGREGAR PROYECTO</a>
                                                                                </div>        
                                                                            </div>
                                                                        </div> 
                                                                    </div>


                                                                </s:if>
                                                                <s:else>
                                                                    <br/>
                                                                    <div class="alert bg-danger "  style=" border-radius: 5px; ">
                                                                        <h5 align="center" style="color: #ffffff"> RFC no encontrada, Registrar Datos de Empresa por favor</h5>
                                                                    </div>

                                                                    <div class="container-fluid"  >
                                                                        <div class="modal-content" style="border-radius: 10px;">
                                                                            <div class="modal-header bg-primary">
                                                                                <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> REGISTRO DE EMPRESA</h4> 
                                                                                <br/>
                                                                            </div>  
                                                                            <div class="modal-body "  >
                                                                                <div class="row">
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="RFC">RFC:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.RFC" id="pro.RFC" maxLength="20"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorRFC" cssClass="alert alert-danger"></s:fielderror>
                                                                                            </div> 
                                                                                        </div>
                                                                                        <div class="form-group col-lg-12 ">
                                                                                            <label class="col-form-label text-muted" style="text-align : left;" for="RAZON">RAZÓN SOCIAL</label>
                                                                                            <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.RAZON_SOCIAL" id="pro.RAZON_SOCIAL" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorRS" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="GIRO">GIRO:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.GIRO" id="pro.GIRO" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorGiro" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="SECTOR">SECTOR:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.SECTOR" id="pro.SECTOR" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorSector" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>    
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="Domicilio">DOMICILIO:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.DOMICILIOE" id="pro.DOMICILIOE" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorDomicilioE" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>   
                                                                                    <div class="form-group col-lg-5">
                                                                                        <label class="col-form-label text-muted" for="coloniaE">COLONIA:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.COLONIAE" id="pro.COLONIAE" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorColonia" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>      
                                                                                    <div class="form-group col-lg-5">
                                                                                        <label class="col-form-label text-muted" for="localidad">LOCALIDAD:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.LOCALIDADE" id="pro.LOCALIDADE" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorLocalidadE" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>  
                                                                                    <div class="form-group col-lg-2">
                                                                                        <label class="col-form-label text-muted" for="cp">CP:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.CPE" id="pro.CPE"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorCP" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>     
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted " for="Municipio" >MUNICIPIO:</label>
                                                                                        <div class="col-sm-auto ">
                                                                                            <s:select  name="pro.MUNICIPIOE" id="municipio" list="ListaMunicipios"  listKey="ID"  listValue="MUNICIPIO"  headerKey="" headerValue="Municipio" cssClass="form-control "  ></s:select>
                                                                                            <s:fielderror fieldName="ErrorMunicipio" cssClass="alert alert-danger" />
                                                                                        </div> 
                                                                                    </div>      

                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="cp">TELEFONO:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.TELEFONOE" id="pro.TELEFONOE" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorTel" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>                                                     
                                                                                    <div class="form-group col-lg-4">
                                                                                        <label class="col-form-label text-muted" for="correo">Email:</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control " name="pro.CORREO_ELECTRONICOE" id="correo" ></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorCorreo" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>  
                                                                                    <div class="form-group col-lg-12">
                                                                                        <label class="col-form-label text-muted" for="REPLEGAL">REP. LEGAL</label>
                                                                                        <div class="col-sm-auto">
                                                                                            <s:textfield  cssClass="form-control text-uppercase" name="pro.REP_LEGAL" id="pro.REP_LEGAL"></s:textfield>
                                                                                            <s:fielderror fieldName="ErrorRep" cssClass="alert alert-danger"/>
                                                                                        </div> 
                                                                                    </div>      

                                                                                </div>
                                                                            </div>
                                                                            <div class="modal-footer bg-primary">

                                                                                <a class="btn bg-secondary text-white" href="Javascript:Accion('GuardarEmpresa')">Guardar Empresa</a>

                                                                            </div>            
                                                                        </div> 
                                                                    </div>
                                                                </s:else>

                                                            </s:if>
                                                        </td>
                                                    </tr>


                                                    <!--*************************************************registro de proyecto***************************************************************************************-->
                                                    <s:if test="BanRegistraProyecto">
                                                        <tr>
                                                            <td class="text-center bg-primary" style="border-top-left-radius: 10px; border-top-right-radius: 10px;" colspan="4"><h5>REGISTRO DE PROYECTO</h5></td>
                                                        </tr>
                                                        <tr style=" background: white;  font-size: 15px;">
                                                            <td colspan="4">


                                                                <br/>
                                                                <s:if test="BanProyectoRegistrado">
                                                                    <div class="alert bg-success"  style="width:100%; border-radius: 5px; ">
                                                                        <h5 align="center" style="color: #ffffff">Proyecto Registrado</h5>
                                                                    </div>
                                                                </s:if>

                                                                <div class="container-fluid"  >
                                                                    <div class="modal-content" style="border-radius: 10px;"> 
                                                                        <div class="modal-body "  >
                                                                            <div class="row">
                                                                                <div class="form-group col-lg-12">
                                                                                    <label class="col-form-label text-muted" for="np">NOMBRE DEL PROYECTO:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.NOM_PRO" id="pro.NOM_PRO" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorNOMPRO" cssClass="alert alert-danger"></s:fielderror>
                                                                                        </div> 
                                                                                    </div>
                                                                                    <div class="form-group col-lg-4 ">
                                                                                        <label class="col-form-label text-muted" style="text-align : left;" for="RAZON">ETAPA</label>
                                                                                        <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.ETAPA" id="pro.ETAPA" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorETAPA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="AC">ÁREA DE CONOCIMIENTO:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.AREA_CONOCIMIENTO" id="pro.AREA_CONOCIMIENTO" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorAC" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="HORAS">NÚMERO DE HORAS:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.NUM_HORAS" id="pro.NUM_HORAS" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorNH" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>      
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="FI">FECHA DE INICIO DEL PROYECTO:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield name="pro.FECHA_INICIO" id="Fecha"  placeholder="Fecha de inicio del proyecto" required="true" readonly="true" cssClass="form-control text-uppercase"  />
                                                                                        <s:fielderror fieldName="ErrorFI" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="FF">FECHA DE TERMINO DEL PROYECTO:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield name="pro.FECHA_TERMINO" id="Fecha1"  placeholder="Fecha Final del proyecto" required="true" readonly="true" cssClass="form-control text-uppercase"  />
                                                                                        <s:fielderror fieldName="ErrorFF" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div> 
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="REPLEGAL">CONVENIO</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:file cssClass="text-muted"  name="archi" id="archi" accept=" application/pdf" title="Solo archivos con extension PDF" />

                                                                                        <s:fielderror fieldName="archierror" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label text-muted " for="Municipio" >RESPONSABLE INSTITUCIONAL:</label>
                                                                                    <div class="col-sm-auto ">
                                                                                        <s:select  name="pro.RESP_INS" id="pro.RESP_INS" list="ListaResponsables"  listKey="ID_RESPONSABLE"  listValue="NOMBRE_COMPLETO_RESP"  headerValue="" cssClass="form-control "  ></s:select>
                                                                                        <s:fielderror fieldName="ErrorResp" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
                                                                                    </div> 
                                                                                </div>   
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label text-muted " for="Municipio" >ASESOR INSTITUCIONAL:</label>
                                                                                    <div class="col-sm-auto ">
                                                                                        <s:select  name="pro.ASE_INS" id="pro.ASE_INS" list="ListaAsesoresI"  listKey="ID_ASESOR_I"  listValue="NOMBRE_COMPLETO_AI"  headerValue="" cssClass="form-control "  ></s:select>
                                                                                        <s:fielderror fieldName="ErrorAI" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
                                                                                    </div> 
                                                                                </div>   

                                                                                &nbsp;    
                                                                                <!--REGISTRO DE ASESORES DE EMPRESA-->  
                                                                                <div class="form-group col-lg-12 bg-primary">
                                                                                    <h5 align="center" style="color: #ffffff">DATOS DEL ASESOR DE LA EMPRESA</h5>
                                                                                </div>

                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="nombre">Nombre del asesor:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.NOMBRE_A" id="pro.NOMBRE_A"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorNombreA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="apellidop">Apellido Paterno del asesor:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.APELLIDO_PA" id="pro.APELLIDO_PA" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorApellidoPA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>    
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="apellidom">Apellido Materno del asesor:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.APELLIDO_MA" id="pro.APELLIDO_MA" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorApellidoMA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>   
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="cargo">Cargo:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.CARGO_A" id="pro.CARGO_A" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorCargo" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>      

                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="tel">Teléfono del asesor:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="pro.TELEFONO_A" id="pro.TELEFONO_A"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorTelA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>     

                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label text-muted" for="correo">Email del asesor:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control" name="pro.CORREO_A" id="pro.CORREO_A" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorCorreoA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>    

                                                                                <!--FIN DE REGISTRO DE ASESORES DE EMPRESA-->                                                                                                                                                                                                                                        
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group col-lg-12">
                                                                            <a class="btn bg-secondary text-white" href="Javascript:Accion('GuardarProyecto')" onclick="this.onclick = function () {
                                                                                        return false
                                                                                    }">Guardar Proyecto</a>
                                                                        </div>  
                                                                    </div> 

                                                                </div>

                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="bg-primary" style="border-bottom-right-radius: 10px;border-bottom-left-radius: 10px;" colspan="4">

                                                            </td>
                                                        </tr>  
                                                    </s:if>  
                                                </tbody>
                                            </table>

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

                                </s:form>

                            </body>

                            </html>
