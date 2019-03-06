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
                        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

                            <!-- Custom fonts for this template -->
                            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
                                <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
                                    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

                                        <!-- Plugin CSS -->
                                        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

                                            <!-- Custom styles for this template -->
                                            <link href="css/freelancer.min.css" rel="stylesheet">

                                                <link href=" <s:url value="css/CssExtras.css"/>" media="all" rel="stylesheet" type="text/css"/> 



                                                <script type="text/javascript">

                                                    function Accion(accion) {

                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.submit();
                                                    }

                                                    function Agregar(accion, valor, valor2, id) {

                                                        if (document.getElementById) { //se obtiene el id
                                                            var GrdCar = document.getElementById(id); //se define la variable "el" igual a nuestro div
                                                            GrdCar.style.display = (GrdCar.style.display == 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
                                                        }

                                                        document.formularioPrincipal.Cve_Car.value = valor;
                                                        document.formularioPrincipal.Nom_Car.value = valor2;
                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.target = "_self";
                                                        document.formularioPrincipal.submit();
                                                    }

                                                    function Eliminar(accion, valor, id) {
                                                        if (document.getElementById) { //se obtiene el id
                                                            var EliCar = document.getElementById(id); //se define la variable "el" igual a nuestro div
                                                            EliCar.style.display = (EliCar.style.display == 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
                                                        }
                                                        document.formularioPrincipal.Id_Cve_Car.value = valor;
                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.target = "_self";
                                                        document.formularioPrincipal.submit();
                                                    }


                                                    function muestra_oculta(accion, id) {// ejecuta el loader
                                                        if (document.getElementById) { //se obtiene el id
                                                            var GM = document.getElementById(id); //se define la variable "el" igual a nuestro div
                                                            GM.style.display = (GM.style.display == 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
                                                        }
                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.submit();
                                                    }


                                                    window.onload = function () {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
                                                        var pos = window.name || 0;
                                                        window.scrollTo(0, pos);

                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var GrdCar = document.getElementById('loadGrdCar'); //se define la variable "el" igual a nuestro div
                                                            GrdCar.style.display = (GrdCar.style.display == 'none') ? 'block' : 'none';/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var EliCar = document.getElementById('loadEliCar'); //se define la variable "el" igual a nuestro div
                                                            EliCar.style.display = (EliCar.style.display == 'none') ? 'block' : 'none';/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var GM = document.getElementById('loadGM'); //se define la variable "el" igual a nuestro div
                                                            GM.style.display = (GM.style.display == 'none') ? 'block' : 'none';/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var CD = document.getElementById('loadCarDatos'); //se define la variable "el" igual a nuestro div
                                                            CD.style.display = (CD.style.display == 'none') ? 'block' : 'none';/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }





                                                    }

                                                    window.onunload = function () {
                                                        window.name = self.pageYOffset
                                                                || (document.documentElement.scrollTop + document.body.scrollTop);


                                                    }

                                                   

                                                </script>
                                                <!-- Bootstrap core JavaScript -->
                                                <script src="vendor/jquery/jquery.min.js"></script>   
                                                <script type="text/javascript">
                                                    $(document).ready(function () {

                                                        (function ($) {

                                                            $('#filtrar').keyup(function () {

                                                                var rex = new RegExp($(this).val(), 'i');
                                                                $('.buscar tr').hide();
                                                                $('.buscar tr').filter(function () {
                                                                    return rex.test($(this).text());
                                                                }).show();

                                                            })

                                                        }(jQuery));

                                                    });
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
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#cc">Agregar Carreras</a>
                                                                        </li>
                                                                        <li class="nav-item mx-0 mx-lg-1">
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#cr">Cargar Responsables DUAL</a>
                                                                        </li>
                                                                        <li class="nav-item mx-0 mx-lg-1">
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#cri">Cargar Asesores Institucionales DUAL</a>
                                                                        </li>
                                                                        <li class="nav-item mx-0 mx-lg-1">
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#ca">Cargar Alumnos</a>
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



                                                        <div id="loadCarDatos">
                                                            <div class="loader1">
                                                                <div id="circle">

                                                                    <div class="loader">
                                                                        <div class="loader">
                                                                            <div class="loader">
                                                                                <div class="loader">

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <h5 >Cargando Datos..</h5>
                                                                </div> 
                                                            </div>    
                                                        </div>   

                                                        <!-- Header -->
                                                        <header class="masthead text-white text-center" style="background:  linear-gradient(to bottom, rgba(73,155,234,1) 0%, rgba(11,82,158,1) 83%, rgba(11,82,158,1) 100%);" >

                                                            <div class="container"  >
                                                                <div class="modal-content" style="border-radius: 10px;">
                                                                    <div class="modal-header bg-secondary col-lg-12">
                                                                        <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> REGISTRO DE CATÁLOGOS (SISTEMA DUAL)</h4> 
                                                                        <br/>
                                                                    </div>  
                                                                    <div class="modal-body "  >
                                                                        <div class="bg-secondary"  style="width:100%; border-radius: 5px; ">
                                                                            <h5 align="center" style="color: #ffffff"><i class="fas fa-graduation-cap"></i>Datos de la escuela</h5>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="form-group col-lg-4 ">
                                                                                <label class="col-form-label" for="cct">Cct:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.CCT" id="datos.CCT" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCCTA" cssClass="alert alert-danger"></s:fielderror>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-4 ">
                                                                                    <label class="col-form-label" style="text-align : left;" for="nombre">Nombre:</label>
                                                                                    <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.NOMESC" id="datos.NOMESC" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorNOMESC" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="domicilio">Calle:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.CALLE" id="datos.CALLE" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorDIR" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Colonia">Colonia:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.COLONIA" id="datos.COLONIA" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCol" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>    
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Localidad">Localidad:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.LOCALIDAD" id="datos.LOCALIDAD" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorLOCALIDAD" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>   
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="CP">CP:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.CP" id="datos.CP" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCP" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>      
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="municipio">Municipio:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.MUNICIPIOCCT" id="datos.MUNICIPIOCCT" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorMUNESC" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>                                                                                                                          
                                                                        </div>



                                                                        <s:if test="BanArcchivoFaltante">


                                                                            <div class="bg-secondary" style="width:100%; border-radius: 5px; ">
                                                                                <h5 align="center" style="color: #ffffff"><i class="fas fa-archive "></i>Archivos Faltantes</h5>

                                                                            </div>
                                                                            <div class="col-sm-auto" >

                                                                                <table class="table table-hover" style="background: #0056b3;"  >

                                                                                    <tbody>

                                                                                        <tr style="pointer-events: none; background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">
                                                                                            <s:iterator value="VerificaArchivos" id="VerificaArchivos" status="stat">
                                                                                                <s:if test="ARCHIVO_CAR=='si'">
                                                                                                    <td class="alert-success" style="width: 25%;"><s:property value="ERROR_ARCHIVO_CAR"/></td>
                                                                                                </s:if>
                                                                                                <s:else>
                                                                                                    <td class="alert-danger" style="width: 25%;"><s:property value="ERROR_ARCHIVO_CAR"/></td>
                                                                                                </s:else>
                                                                                            </tr> 
                                                                                            <tr style="pointer-events: none; background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">       
                                                                                                <s:if test="ARCHIVO_RES=='si'">
                                                                                                    <td class="alert-success" style="width: 25%;"><s:property value="ERROR_ARCHIVO_RES"/></td>
                                                                                                </s:if>
                                                                                                <s:else>
                                                                                                    <td class="alert-danger" style="width: 25%;"><s:property value="ERROR_ARCHIVO_RES"/></td>
                                                                                                </s:else>    
                                                                                            </tr>  
                                                                                            <tr style="pointer-events: none; background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">       
                                                                                                <s:if test="ARCHIVO_ASE_INT=='si'">
                                                                                                    <td class="alert-success" style="width: 25%;"><s:property value="ERROR_ARCHIVO_ASE_INT"/></td>
                                                                                                </s:if>
                                                                                                <s:else>
                                                                                                    <td class="alert-danger" style="width: 25%;"><s:property value="ERROR_ARCHIVO_ASE_INT"/></td>
                                                                                                </s:else>    
                                                                                            </tr> 
                                                                                            <tr style="pointer-events: none; background: #ffffff;  color: #000; font-size: 15px; border-radius:10px;">       
                                                                                                <s:if test="ARCHIVO_ALU=='si'">
                                                                                                    <td class="alert-success" style="width: 25%;"><s:property value="ERROR_ARCHIVO_ALU"/></td>
                                                                                                </s:if>
                                                                                                <s:else>
                                                                                                    <td class="alert-danger" style="width: 25%;"><s:property value="ERROR_ARCHIVO_ALU"/></td>
                                                                                                </s:else>    
                                                                                            </tr>         

                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ARCHIVO_CAR" id="ARCHIVO_CAR"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ERROR_ARCHIVO_CAR" id="ERROR_ARCHIVO_CAR"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ARCHIVO_RES" id="ARCHIVO_RES"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ERROR_ARCHIVO_RES" id="ERROR_ARCHIVO_RES"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ARCHIVO_ASE_INT" id="ARCHIVO_ASE_INT"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ERROR_ARCHIVO_ASE_INT" id="ERROR_ARCHIVO_ASE_INT"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ARCHIVO_ALU" id="ARCHIVO_ALU"></s:hidden> 
                                                                                            <s:hidden  name = "VerificaArchivos[%{#stat.index}].ERROR_ARCHIVO_ALU" id="ERROR_ARCHIVO_ALU"></s:hidden> 

                                                                                        </s:iterator>   


                                                                                    </tbody>

                                                                                </table>                                                                             
                                                                            </div>

                                                                        </s:if> 

                                                                    </div>                                                                   
                                                                </div>  
                                                            </div> 
                                                            <br></br>   
                                                            <br></br>                                                                                                                 
                                                        </header>

                                                        <!-- REGISTRA CARRERAS -->
                                                        <section   id="cc">
                                                            <div class="container"  >
                                                                <div class="modal-content">
                                                                    <div class="modal-header bg-secondary " >
                                                                        <h4  style="color: #ffffff"> <i class="fas fa-book"></i> Registro de Catálogo de Carreras</h4> 
                                                                        <br/>
                                                                    </div>  

                                                                    <div class="form-inline">

                                                                        <div class="modal-body col-lg-6"  > 
                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table  table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr ><th colspan="6" > <h6 class="text-muted" align="center">CATÁLOGO DE CARRERAS</h6></th> </tr>
                                                                                        <tr>              
                                                                                            <th  scope="col">CLAVE DE LA  CARRERA</th>
                                                                                            <th  scope="col">NOMBRE DE LA CARRERA</th>
                                                                                            <th  scope="col">AGREGAR CARRERA</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody class='buscar'>
                                                                                        <s:iterator value="ListaCarreras" id="ListaCarreras" status="stat">
                                                                                            <tr >
                                                                                                <td class="text-muted"><s:property value="CLAVECARRERA"/></td>
                                                                                                <td class="text-muted"><s:property value="NOMBRE_CARRERA"/></td>
                                                                                                <td align="center">
                                                                                                    <a href="Javascript:Agregar('AgregarCarrera','<s:property value="CLAVECARRERA"/>','<s:property value="NOMBRE_CARRERA"/>','loadGrdCar')">
                                                                                                        <i class="fa fa-plus-circle fa-2x" style="color: green;"></i>
                                                                                                    </a>
                                                                                                </td>    
                                                                                            </tr>
                                                                                            <s:hidden  name = "ListaCarreras[%{#stat.index}].CLAVECARRERA" id="CLAVECARRERA"></s:hidden> 
                                                                                            <s:hidden  name = "ListaCarreras[%{#stat.index}].NOMBRE_CARRERA" id="NOMBRE_CARRERA"></s:hidden>            
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div> 
                                                                            <br></br>
                                                                            <div class="form-inline col-lg-12">                                                                               
                                                                                <div class="input-group col-lg-12">                        
                                                                                    <i class="fa fa-search fa-2x"></i>                                                                                                                  
                                                                                    <input id="filtrar" type="text" class="form-control" placeholder="INGRESA EL NOMBRE DE LA CARRERA QUE BUSCA...."/>
                                                                                </div>                                                                                                                                                     
                                                                            </div>    
                                                                        </div>

                                                                        <div class="modal-body col-lg-6" >  
                                                                            <s:if test="ObtenerCarreraCCT.size()>0">
                                                                                <div class="table-wrapper-scroll-y">                                 
                                                                                    <table class="table  table-hover">                                                                   
                                                                                        <thead>
                                                                                            <tr ><th colspan="6" > <h6 class="text-muted" align="center">CARRERAS AGREGADAS</h6></th> </tr>
                                                                                            <tr> 
                                                                                                <th  scope="col" style='visibility:hidden'>>ID</th>
                                                                                                <th  scope="col">CLAVE DE LA  CARRERA</th>
                                                                                                <th  scope="col">NOMBRE DE LA CARRERA</th>
                                                                                                <th  scope="col">ELIMINAR CARRERA</th>
                                                                                            </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                            <s:iterator value="ObtenerCarreraCCT" id="ObtenerCarreraCCT" status="stat">
                                                                                                <tr >
                                                                                                    <td class="text-muted" style='visibility:hidden'>><s:property value="ID_CVE_CAR"/></td>
                                                                                                    <td class="text-muted"><s:property value="CLAVECARRERA"/></td>
                                                                                                    <td class="text-muted"><s:property value="NOMBRE_CARRERA"/></td>
                                                                                                    <td align="center">
                                                                                                        <a href="Javascript:Eliminar('EliminarCarrera','<s:property value="ID_CVE_CAR"/>','loadEliCar')">
                                                                                                            <i class="fa fa-times fa-2x" style="color: red;"></i>
                                                                                                        </a>
                                                                                                    </td> 

                                                                                                </tr>
                                                                                                <s:hidden  name = "ObtenerCarreraCCT[%{#stat.index}].ID_CVE_CAR" id="ID_CVE_CAR"></s:hidden>            
                                                                                                <s:hidden  name = "ObtenerCarreraCCT[%{#stat.index}].CLAVECARRERA" id="CLAVECARRERA"></s:hidden> 
                                                                                                <s:hidden  name = "ObtenerCarreraCCT[%{#stat.index}].NOMBRE_CARRERA" id="NOMBRE_CARRERA"></s:hidden>
                                                                                            </s:iterator>
                                                                                        </tbody>
                                                                                    </table>                                                               
                                                                                </div>
                                                                            </s:if>
                                                                            <s:else>
                                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>
                                                                            </s:else>

                                                                            <s:if test="BanCarreraAgregada">
                                                                                <s:fielderror  fieldName="CarreraAgregada" cssClass="alert alert-success"/>
                                                                            </s:if>    
                                                                            <s:if test="BanCarreraEliminada">
                                                                                <s:fielderror  fieldName="CarreraEliminada" cssClass="alert alert-danger"/>
                                                                            </s:if>    
                                                                            <s:if test="BanCarreraExistente">
                                                                                <s:fielderror  fieldName="CarreraExiste" cssClass="alert alert-warning"/>
                                                                            </s:if>

                                                                        </div>
                                                                    </div>    
                                                                    <div class="modal-footer bg-secondary"  >

                                                                    </div>


                                                                </div>
                                                                <br></br>   
                                                                <br></br>   


                                                            </div>
                                                            <s:textfield name="datos.ID_CVE_CAR" id="Id_Cve_Car" style='visibility:hidden' />
                                                            <s:textfield name="datos.CLAVECARRERA" id="Cve_Car" style='visibility:hidden' />
                                                            <s:textfield name="datos.NOMBRE_CARRERA" id="Nom_Car" style='visibility:hidden'/>
                                                        </section>

                                                        <!-- REGISTRA RESPONSABLES -->
                                                        <section style="background:  linear-gradient(to bottom, rgba(73,155,234,1) 0%, rgba(11,82,158,1) 83%, rgba(11,82,158,1) 100%);" id="cr">
                                                            <div class="container"  >
                                                                <div class="modal-content">
                                                                    <div class="modal-header bg-secondary">
                                                                        <h4 align="center" style="color: #ffffff"> <i class="fas fa-book"></i> Registro de Catálogo de Responsables &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a  href= "doc/cat_responsables.xlsx" target="_blank"> <img width="8%"  src="images/excel.png" alt="home" > </img> </a></h4> 
                                                                        <br/>
                                                                    </div>  
                                                                    <div class="modal-body"  >
                                                                        <br></br>
                                                                        <div class="form-group">
                                                                            <label for="exampleFormControlFile1">Cargar Archivo:</label>
                                                                            <s:file   name="archi" id="archi" accept="application/vnd.ms-excel,application/vnd.ms-powerpoint, application/zip, application/x-rar-compressed" title="Solo archivos con extension xlsx"></s:file>
                                                                            <s:fielderror fieldName="archiR" cssClass="alert alert-danger"/>  
                                                                            <s:fielderror fieldName="NOCARRERAS" cssClass="alert alert-danger"/> 
                                                                            <s:if test="BanArcchivoProcesadoR"> 
                                                                                <div class="col-sm-auto" >
                                                                                    <s:fielderror  fieldName="DatosProcesadosR" cssClass="alert alert-success"/>
                                                                                </div>
                                                                            </s:if>  
                                                                        </div>
                                                                        <br></br>
                                                                        <s:if test="BanListaResponsableError">
                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #CC0000;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS CON ERRORES</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP DEL RESPONSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>
                                                                                            <th style="font-size: 10px;" scope="col">CARGO</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="ListaDatosResponsablesConError" id="ListaDatosResponsablesConError" status="stat">
                                                                                            <tr >

                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRER"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOPR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOMR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>
                                                                        <s:if test="BanResponsableExistente">


                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #0d47a1;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>RESPONSABLES YA REGISTRADOS</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP DE RESPOSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>
                                                                                            <th style="font-size: 10px;" scope="col">CARGO</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="ResponsableExistente" id="ResponsableExistente" status="stat">
                                                                                            <tr >
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="NOMBRER"/></td>
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="APELLIDOPR"/></td>
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="APELLIDOMR"/></td>
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted"style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>
                                                                        <s:if test="BanDatosCorrectosR">


                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #00C851;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS REGISTRADOS</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP DE RESPONSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>
                                                                                            <th style="font-size: 10px;" scope="col">CARGO</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="RegistrosNuevosR" id="RegistrosNuevosR" status="stat">
                                                                                            <tr >

                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRER"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOPR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOMR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>  
                                                                        <s:if test="BanListaResponsablesErrorRenapo">

                                                                            <div class="table-wrapper-scroll-y">                                                              

                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead> 
                                                                                        <tr style="background-color: #CC0000;"><th colspan="6" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS CON ERRORES AL VALIDAR CON RENAPO</h6></th> </tr>
                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP DE RESPONSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE(S)</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO PATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO MATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="DatosResponsablesValidadosRenapoConError" id="DatosResponsablesValidadosRenapoConError" status="stat">
                                                                                            <tr>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOM"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>       

                                                                    </div>
                                                                    <div class="modal-footer bg-secondary" >
                                                                        <div class="form-inline">                                                             
                                                                            <div class="col-sm-auto">
                                                                                <a class="btn bg-primary " style="color: white;"  href="Javascript:muestra_oculta('GuardarResponsable','loadGM')">Guardar Archivo de Responsables</a>
                                                                            </div>  
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <br></br>   
                                                                <br></br>   
                                                                <br></br>   
                                                                <br></br>  
                                                                <br></br>   
                                                                <br></br>             
                                                            </div>
                                                        </section>

                                                        <!-- REGISTRA RESPONSABLES INSTITUCIONALES -->
                                                        <section style="background:  linear-gradient(to bottom, rgba(73,155,234,1) 0%, rgba(11,82,158,1) 83%, rgba(11,82,158,1) 100%);" id="cri">
                                                            <div class="container"  >
                                                                <div class="modal-content">
                                                                    <div class="modal-header bg-secondary">
                                                                        <h4 align="center" style="color: #ffffff"> <i class="fas fa-book"></i> Registro de Asesores Institucionales &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a  href= "doc/cat_asesores.xlsx" target="_blank"> <img width="8%"  src="images/excel.png" alt="home" > </img> </a></h4> 
                                                                        <br/>
                                                                    </div>  
                                                                    <div class="modal-body"  >
                                                                        <br></br>
                                                                        <div class="form-group">
                                                                            <label for="exampleFormControlFile1">Cargar Archivo:</label>
                                                                            <s:file   name="archi" id="archi" accept="application/vnd.ms-excel,application/vnd.ms-powerpoint, application/zip, application/x-rar-compressed" title="Solo archivos con extension xlsx"></s:file>
                                                                            <s:fielderror fieldName="archiAI" cssClass="alert alert-danger"/>  
                                                                            <s:fielderror fieldName="NOCARRERAS" cssClass="alert alert-danger"/> 
                                                                            <s:if test="BanArcchivoProcesadoAI"> 
                                                                                <div class="col-sm-auto" >
                                                                                    <s:fielderror  fieldName="DatosProcesadosAI" cssClass="alert alert-success"/>
                                                                                </div>
                                                                            </s:if>  
                                                                        </div>
                                                                        <br></br>
                                                                        <s:if test="BanListaAsesorIError">
                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #CC0000;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS CON ERRORES</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>
                                                                                            <th style="font-size: 10px;" scope="col">CLAVE DE LA CARRERA RESPONSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="ListaDatosAsesoresIConError" id="ListaDatosAsesoresIConError" status="stat">
                                                                                            <tr >

                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRER"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOPR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOMR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>
                                                                        <s:if test="BanListaAsesorIErrorRenapo">

                                                                            <div class="table-wrapper-scroll-y">                                                              

                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead> 
                                                                                        <tr style="background-color: #CC0000;"><th colspan="6" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS CON ERRORES AL VALIDAR CON RENAPO</h6></th> </tr>
                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE(S)</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO PATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO MATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="DatosAsesorValidadosRenapoConError" id="DatosAsesorValidadosRenapoConError" status="stat">
                                                                                            <tr>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOM"/></td>                                                                                             
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;" ><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>    
                                                                        <s:if test="BanAsesorIExistente">


                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #0d47a1;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>ASESORES  YA REGISTRADOS</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>
                                                                                            <th style="font-size: 10px;" scope="col">CLAVE DE LA CARRERA RESPONSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="AsesoresIExistente" id="AsesoresIExistente" status="stat">
                                                                                            <tr >
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRER"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOPR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOMR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>

                                                                        <s:if test="BanDatosCorrectosAI">


                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #00C851;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS REGISTRADOS</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>
                                                                                            <th style="font-size: 10px;" scope="col">CLAVE DE LA CARRERA RESPONSABLE</th>
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="RegistrosNuevosAI" id="RegistrosNuevosAI" status="stat">
                                                                                            <tr >

                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRER"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOPR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOMR"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>  

                                                                    </div>
                                                                    <div class="modal-footer bg-secondary" >
                                                                        <div class="form-inline">                                                             
                                                                            <div class="col-sm-auto">
                                                                                <a class="btn bg-primary " style="color: white;"  href="Javascript:muestra_oculta('GuardarAsesoresI','loadGM')">Guardar Archivo de Asesores Institucionales</a>
                                                                            </div>  
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <br></br>   
                                                                <br></br>   
                                                                <br></br>   
                                                                <br></br>  
                                                                <br></br>   
                                                                <br></br>             
                                                            </div>
                                                        </section>


                                                        <!-- REGISTRA ALUMNOS -->
                                                        <section  id="ca">
                                                            <div class="container"  >
                                                                <div class="modal-content">
                                                                    <div class="modal-header bg-secondary">
                                                                        <h4 align="center" style="color: #ffffff"> <i class="fas fa-book"></i> Registro de Listado de Alumnos DUAL &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a  href= "doc/cat_alumnos.xlsx" target="_blank"> <img width="8%"  src="images/excel.png" alt="home" > </img> </a></h4> 
                                                                        <br/>
                                                                    </div>  
                                                                    <div class="modal-body" >





                                                                        <div class="form-group">
                                                                            <label for="exampleFormControlFile1">Cargar Archivo:</label>
                                                                            <s:file   name="archi" id="archi" accept="application/vnd.ms-excel,application/vnd.ms-powerpoint, application/zip, application/x-rar-compressed" title="Solo archivos con extension xlsx"></s:file>
                                                                            <s:fielderror fieldName="archiA" cssClass="alert alert-danger"/>  
                                                                            <s:fielderror fieldName="NOCARRERASA" cssClass="alert alert-danger"/> 
                                                                            <s:if test="BanArcchivoProcesadoA"> 
                                                                                <div class="col-sm-auto" >
                                                                                    <s:fielderror  fieldName="DatosProcesadosA" cssClass="alert alert-success"/>
                                                                                </div>
                                                                            </s:if>  
                                                                        </div>
                                                                        <br></br>
                                                                        <br></br>
                                                                        <s:if test="BanListaAlumnosError">
                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #CC0000;"><th colspan="10" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS CON ERRORES</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">MATRICULA</th>
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO PATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO MATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">CLAVE DE LA CARRERA </th>
                                                                                            <th style="font-size: 10px;" scope="col">TELEFONO </th>
                                                                                            <th style="font-size: 10px;" scope="col">CORREO </th>    
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="ListaDatosAlumnosConError" id="ListaDatosAlumnosConError" status="stat">
                                                                                            <tr >

                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="MATRICULA"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOM"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CVE_CAR_RES"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="TELEFONO"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CORREO"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>
                                                                        <s:if test="BanListaErrorRenapo">

                                                                            <div class="table-wrapper-scroll-y">                                                              

                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead> 
                                                                                        <tr style="background-color: #CC0000;"><th colspan="6" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS CON ERRORES AL VALIDAR CON RENAPO</h6></th> </tr>
                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;"  scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE(S)</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO PATERNO</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO MATERNO</th>                                                                                           
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="DatosAlumnosValidadosRenapoConError" id="DatosAlumnosValidadosRenapoConError" status="stat">
                                                                                            <tr>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOM"/></td>                            
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;" ><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>   

                                                                        <s:if test="BanAlumnosExistente">
                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #0d47a1;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>ALUMNOS YA REGISTRADOS</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>                                                                            
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="AlumnosExistente" id="AlumnosExistente" status="stat">
                                                                                            <tr >
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOM"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if>

                                                                        <s:if test="BanDatosCorrectosA">


                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr style="background-color: #00C851;"><th colspan="7" > <h6 class="text-white" align="center"><i class="fas fa-info-circle"></i>DATOS REGISTRADOS</h6></th> </tr>

                                                                                        <tr>              
                                                                                            <th style="font-size: 10px;" scope="col">CURP</th>
                                                                                            <th style="font-size: 10px;" scope="col">NOMBRE</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO P</th>
                                                                                            <th style="font-size: 10px;" scope="col">APELLIDO M</th>      
                                                                                            <th style="font-size: 10px;" scope="col">STATUS</th>
                                                                                            <th style="font-size: 10px;" scope="col">INFORMACIÓN</th>

                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <s:iterator value="RegistrosNuevosA" id="RegistrosNuevosA" status="stat">
                                                                                            <tr >

                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="CURP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="NOMBRE"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOP"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="APELLIDOM"/></td>                                                                                  
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="STATUS"/></td>
                                                                                                <td class="text-muted" style="font-size: 10px;"><s:property value="DESERROR"/></td> 
                                                                                            </tr>
                                                                                        </s:iterator>
                                                                                    </tbody>
                                                                                </table>                                                               
                                                                            </div>
                                                                            <br></br>
                                                                        </s:if> 
                                                                    </div>
                                                                    <div class="modal-footer bg-secondary" >
                                                                        <div class="form-inline">                                                             
                                                                            <div class="col-sm-auto">
                                                                                <a class="btn  bg-primary" style="color: white;" href="Javascript:muestra_oculta('GuardarAlumnos','loadGM')">Guardar Archivo de Alumnos</a>
                                                                            </div>  
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <br></br>   
                                                                <br></br>   
                                                                <br></br>   
                                                                <br></br>  
                                                                <br></br>   
                                                                <br></br>             
                                                            </div>
                                                        </section>


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


                                                        <div id="loadGrdCar">
                                                            <div class="loader1">
                                                                <div id="circle">

                                                                    <div class="loader">
                                                                        <div class="loader">
                                                                            <div class="loader">
                                                                                <div class="loader">

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <h5 >Guardando Carrera..</h5>
                                                                </div> 
                                                            </div>    
                                                        </div>

                                                        <div id="loadEliCar">
                                                            <div class="loader1">
                                                                <div id="circle">

                                                                    <div class="loader">
                                                                        <div class="loader">
                                                                            <div class="loader">
                                                                                <div class="loader">

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <h5 >Eliminando Carrera..</h5>
                                                                </div> 
                                                            </div>    
                                                        </div>

                                                        <div id="loadGM">
                                                            <div class="loader1">
                                                                <div id="circle">

                                                                    <div class="loader">
                                                                        <div class="loader">
                                                                            <div class="loader">
                                                                                <div class="loader">

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <h5 >Procesando Archivo..</h5>
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

                                                    </s:form>

                                                </body>

                                                </html>
