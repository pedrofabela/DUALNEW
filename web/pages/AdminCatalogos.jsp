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

                                                    function ValidaResponsableM(accion) {

                                                        var cargo = document.getElementById('cargo').value;
                                                        var telefono = document.getElementById('telefonor').value;
                                                        var email = document.getElementById('emailr').value;


                                                        var bancargo = false;
                                                        var bantelefono = false;
                                                        var banemail = false;




                                                        if (cargo == null || cargo.length == 0 || /^\s+$/.test(cargo)) {
                                                            alert('ERROR: Debe agregar el cargo del responsable');
                                                            bancargo = false;
                                                        } else {
                                                            bancargo = true;
                                                        }


                                                        if (telefono == null || telefono.length == 0 || /^\s+$/.test(telefono)) {
                                                            alert('ERROR: Debe agregar el teléfono del responsable');
                                                            bantelefono = false;
                                                        } else {
                                                            bantelefono = true;
                                                        }

                                                        if (email == null || email.length == 0 || /^\s+$/.test(email)) {
                                                            alert('ERROR: Debe agregar el email del responsable');
                                                            banemail = false;
                                                        } else {
                                                            banemail = true;
                                                        }

                                                        if (bancargo && bantelefono && banemail) {

                                                            document.formularioPrincipal.action = accion;
                                                            document.formularioPrincipal.submit();

                                                        }




                                                    }


                                                    window.onload = function () {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
                                                        var pos = window.name || 0;
                                                        window.scrollTo(0, pos);
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var GrdCar = document.getElementById('loadGrdCar'); //se define la variable "el" igual a nuestro div
                                                            GrdCar.style.display = (GrdCar.style.display == 'none') ? 'block' : 'none'; /* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var EliCar = document.getElementById('loadEliCar'); //se define la variable "el" igual a nuestro div
                                                            EliCar.style.display = (EliCar.style.display == 'none') ? 'block' : 'none'; /* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var GM = document.getElementById('loadGM'); //se define la variable "el" igual a nuestro div
                                                            GM.style.display = (GM.style.display == 'none') ? 'block' : 'none'; /* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }
                                                        if (document.getElementById) {
                                                            /* variables para ocultar load de ARCHIVO*/
                                                            var CD = document.getElementById('loadCarDatos'); //se define la variable "el" igual a nuestro div
                                                            CD.style.display = (CD.style.display == 'none') ? 'block' : 'none'; /* "contenido_a_mostrar" es el nombre que le dimos al DIV */
                                                        }

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

                                                <script type="text/javascript">
                                                    $(document).ready(function () {

                                                        (function ($) {

                                                            $('#filtrarR').keyup(function () {

                                                                var rex = new RegExp($(this).val(), 'i');
                                                                $('.buscarR tr').hide();
                                                                $('.buscarR tr').filter(function () {
                                                                    return rex.test($(this).text());
                                                                }).show();
                                                            })

                                                        }(jQuery));
                                                    });
                                                </script>
                                                <script type="text/javascript">
                                                    $(document).ready(function () {

                                                        (function ($) {

                                                            $('#filtrarA').keyup(function () {

                                                                var rex = new RegExp($(this).val(), 'i');
                                                                $('.buscarA tr').hide();
                                                                $('.buscarA tr').filter(function () {
                                                                    return rex.test($(this).text());
                                                                }).show();
                                                            })

                                                        }(jQuery));
                                                    });



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
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#cc">Administrar Carreras</a>
                                                                        </li>
                                                                        <li class="nav-item mx-0 mx-lg-1">
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#cr">Administrar Responsables DUAL</a>
                                                                        </li>
                                                                        <li class="nav-item mx-0 mx-lg-1">
                                                                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#cri">Administrar Asesores Institucionales DUAL</a>
                                                                        </li>
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
                                                                        <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> ADMINISTRACION DE CATÁLOGOS (SISTEMA DUAL)</h4> 
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
                                                                        <h5  style="color: #ffffff"> <i class="fas fa-book"></i>Administrar Catálogo de Carreras</h5> 
                                                                        <br/>
                                                                    </div>  

                                                                    <div class="form-inline">

                                                                        <div class="modal-body col-lg-6"  >                        
                                                                            <div class="table-wrapper-scroll-y">                                 
                                                                                <table class="table  table-hover">                                                                   
                                                                                    <thead>
                                                                                        <tr ><th colspan="6" > <h6 class="text-muted" align="center">CATÁLOGO DE CARRERAS</h6></th> </tr>
                                                                                        <tr>              
                                                                                            <th  scope="col">CLAVE DE CARRERA</th>
                                                                                            <th  scope="col">NOMBRE DE CARRERA</th>
                                                                                            <th  scope="col">AGREGAR CARRERA</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody class='buscar'>
                                                                                        <s:iterator value="ListaCarreras" id="ListaCarreras" status="stat">
                                                                                            <tr >
                                                                                                <td class="text-muted"><s:property value="CLAVECARRERA"/></td>
                                                                                                <td class="text-muted"><s:property value="NOMBRE_CARRERA"/></td>
                                                                                                <td align="center">
                                                                                                    <a href="Javascript:Agregar('AgregarCarreraA','<s:property value="CLAVECARRERA"/>','<s:property value="NOMBRE_CARRERA"/>','loadGrdCar')">
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
                                                                                                        <a href="Javascript:Eliminar('EliminarCarreraA','<s:property value="ID_CVE_CAR"/>','loadEliCar')">
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
                                                                        <h5 align="center" style="color: #ffffff"> <i class="fas fa-book"></i> Administrar Catálogo de Responsables </h5> 
                                                                        <br/>
                                                                    </div>  
                                                                    <div class="modal-body"  >
                                                                        <div class="row">

                                                                            <s:if test="BanResponsableRegistrado">
                                                                                <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">Responsable Registrado Correctamente</h5>
                                                                                </div>
                                                                            </s:if> 
                                                                            <s:if test="BanResponsableActualizado">
                                                                                <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">Responsable Actualizado Correctamente</h5>
                                                                                </div>
                                                                            </s:if> 
                                                                            <s:if test="BanResponsableExiste">
                                                                                <div class="alert alert-danger"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">El Responsable que intenta registrar ya existe</h5>
                                                                                </div>
                                                                            </s:if> 
                                                                            <s:if test="BanResponsableEliminado">
                                                                                <div class="alert alert-danger"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">Responsable Eliminado</h5>
                                                                                </div>
                                                                            </s:if> 

                                                                            <h5 align="center" class="bg-secondary col-lg-12 text-white"  > <i class="fas fa-address-card"></i> Registro de Nuevos Responsables </h5> 
                                                                            <div class="form-inline col-lg-12">

                                                                                <div class=" form-group col-lg-9">
                                                                                    <s:textfield  cssClass="form-control col-lg-8 text-uppercase" name="ad.CURP_RESPONSABLEAUX" id="ad.CURP_RESPONSABLEAUX"  placeholder="INGRESE LA CURP DEL RESPONSABLE QUE DESEA REGISTRAR" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorValCurp" cssClass="alert alert-danger"></s:fielderror>
                                                                                    </div> 
                                                                                    <div class="form-group col-lg-2">                                                             

                                                                                        <a class="btn bg-success " style="color: white;"  href="Javascript:Accion('ConsultaCurpR')">Buscar CURP</a>

                                                                                    </div>    
                                                                                </div>
                                                                                <br></br>        
                                                                            <s:if test="BANCURPRENCONTRADA">
                                                                                <div class="alert alert-primary"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">CURP VALIDADA</h5>
                                                                                </div>
                                                                            </s:if>    
                                                                        </div>

                                                                        <div class="row">
                                                                            <s:if test="banCurpValida">  
                                                                                <s:hidden name="banCurpValida" value="%{banCurpValida}"></s:hidden>
                                                                                    <div class="form-group col-lg-6 ">
                                                                                        <label class="col-form-label"  for="nombre">CURP:</label>
                                                                                        <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.CURP_RESPONSABLE" id="nombrer" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorCURPR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-6 ">
                                                                                    <label class="col-form-label"  for="nombre">Nombre:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.NOMBRER" id="nombrer" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorNombreR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>              
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label" for="apellidop">Apellido Paterno:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOPR" id="apellidopr" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorApellidoPR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>    
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label" for="apellidomr">Apellido Materno:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOMR" id="apellidomr" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorApellidoMR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>   
                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label" for="Genero">Cargo:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.CARGO_RESPONSABLE" id="cargo" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorCargoR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>      

                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label" for="tel">Teléfono:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.TELEFONO_RESPONSABLE" id="telefonor"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorTelR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>     

                                                                                <div class="form-group col-lg-4">
                                                                                    <label class="col-form-label" for="correo">Email:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control " name="ad.EMAIL_RESPONSABLE" id="emailr" ></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorCorreoR" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div> 

                                                                                <div class="form-group col-lg-12">                                                             
                                                                                    <div align="center">
                                                                                        <a class="btn bg-success " style="color: white;"  href="Javascript:Accion('GuardarResponsableN')">Guardar  Responsables</a>
                                                                                    </div>  
                                                                                </div>
                                                                            </s:if> 
                                                                            &nbsp;
                                                                            &nbsp;
                                                                            &nbsp;
                                                                            <h5 align="center" class="bg-secondary col-lg-12 text-white"  > <i class="fas fa-user"></i>Responsables Registrados  </h5>     

                                                                            <div class="form-inline col-lg-12">
                                                                                <i class="fa fa-search fa-2x " style="color: #0056b3"></i>
                                                                                <input id="filtrarR" type="text" class="form-control col-lg-11" placeholder="INGRESA EL NOMBRE DEL RESPONSABLE QUE BUSCA...."/>
                                                                            </div>                                                                                                                                                     

                                                                            <div class="table-wrapper-scroll-y col-lg-12">  
                                                                                <table class="table table-hover">
                                                                                    <thead>
                                                                                        <tr class="bg-secondary" style="font-size: 75%; color: #fff;">
                                                                                            <th scope="col" >CURP</th>
                                                                                            <th scope="col" >Nombre</th>                                                                                         
                                                                                            <th scope="col" >Apellido Paterno</th>
                                                                                            <th scope="col" >Apellido Materno</th>
                                                                                            <th scope="col" >Cargo</th>
                                                                                            <th scope="col" >Teléfono</th>
                                                                                            <th scope="col" >Email</th>                                                    
                                                                                            <th scope="col" >Modificar</th>
                                                                                            <!--<th scope="col" >Eliminar</th> -->
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody class='buscarR'>

                                                                                        <s:iterator value="ListaResponsables" id="ListaResponsables" status="stat">
                                                                                            <tr style="color: #666; font-size: 70%;">
                                                                                                <td  ><s:property value="CURP_RESPONSABLE"/></td>
                                                                                                <td  ><s:property value="NOMBRER"/></td>
                                                                                                <td  ><s:property value="APELLIDOPR"/></td>                                                                                             
                                                                                                <td  ><s:property value="APELLIDOMR"/></td>
                                                                                                <td  ><s:property value="CARGO_RESPONSABLE"/></td>
                                                                                                <td  ><s:property value="TELEFONO_RESPONSABLE"/></td>
                                                                                                <td  ><s:property value="EMAIL_RESPONSABLE"/></td>

                                                                                                <td ><a   data-toggle='modal' data-target='#EditResponsables' 

                                                                                                          data-curpr='<s:property value="CURP_RESPONSABLE"/>' 
                                                                                                          data-nombrer='<s:property value="NOMBRER"/>' 
                                                                                                          data-apellidopr='<s:property value="APELLIDOPR"/>' 
                                                                                                          data-apellidomr='<s:property value="APELLIDOMR"/>' 
                                                                                                          data-cargo='<s:property value="CARGO_RESPONSABLE"/>' 
                                                                                                          data-telefonor='<s:property value="TELEFONO_RESPONSABLE"/>' 
                                                                                                          data-emailr='<s:property value="EMAIL_RESPONSABLE"/>' 
                                                                                                          data-idresp='<s:property value="ID_CAT_RESP"/>' 
                                                                                                          ><i class="fa fa-pen" style="font-size: 25px;  color: #004085; "></i>
                                                                                                    </a>
                                                                                                </td>
                                                                                             <%--   <td >
                                                                                                    <a href="#" data-toggle='modal' data-target='#DeleteResp' 
                                                                                                       data-id_eliminar_resp='<s:property value="ID_CAT_RESP"/>'>
                                                                                                        <i class="fa fa-trash" style="font-size: 25px; color: #004085; "></i></a>
                                                                                                </td>   
                                                                                                   --%>     
                                                                                            </tr>  

                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].CURP_RESPONSABLE" id="CURP_RESPONSABLE"></s:hidden>     
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].NOMBRER" id="NOMBRER"></s:hidden>  
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].APELLIDOPR" id="APELLIDOPR"></s:hidden> 
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].APELLIDOMR" id="APELLIDOMR"></s:hidden>  
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].CARGO_RESPONSABLE" id="CARGO_RESPONSABLE"></s:hidden>  
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].TELEFONO_RESPONSABLE" id="TELEFONO_RESPONSABLE"></s:hidden>  
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].EMAIL_RESPONSABLE" id="EMAIL_RESPONSABLE"></s:hidden>  
                                                                                            <s:hidden  name = "ListaResponsables[%{#stat.index}].ID_CAT_RESP" id="ID_CAT_RESP"></s:hidden>

                                                                                        </s:iterator>


                                                                                    </tbody>
                                                                                </table>
                                                                            </div>   
                                                                        </div>


                                                                    </div>
                                                                    <div class="modal-footer bg-secondary" >

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

                                                        <!-- REGISTRA ASESORES INSTITUCIONALES -->
                                                        <section style="background:  linear-gradient(to bottom, rgba(73,155,234,1) 0%, rgba(11,82,158,1) 83%, rgba(11,82,158,1) 100%);" id="cri">
                                                            <div class="container"  >
                                                                <div class="modal-content">
                                                                    <div class="modal-header bg-secondary">
                                                                        <h5 align="center" style="color: #ffffff"> <i class="fas fa-book"></i> Administrar Catalogo de Asesores Institucionales</h5> 
                                                                        <br/>
                                                                    </div>  
                                                                    <div class="modal-body"  >
                                                                        <div class="row">

                                                                            <s:if test="BanAsesorRegistrado">
                                                                                <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">Asesor Registrado Correctamente</h5>
                                                                                </div>
                                                                            </s:if> 
                                                                            <s:if test="BanAsesorActualizado">
                                                                                <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">Asesor Actualizado Correctamente</h5>
                                                                                </div>
                                                                            </s:if> 

                                                                            <s:if test="BanAsesorExiste">
                                                                                <div class="alert alert-danger"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">El Asesor que intenta registrar ya existe para la carrera seleccionada</h5>
                                                                                </div>
                                                                            </s:if> 
                                                                            <s:if test="BanAsesorEliminado">
                                                                                <div class="alert alert-danger"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">Asesor Eliminado</h5>
                                                                                </div>
                                                                            </s:if> 
                                                                             <s:if test="BanAsesorHABILITADO">
                                                                                <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">El Asesor se habilito correctamente</h5>
                                                                                </div>
                                                                            </s:if> 

                                                                            <h5 align="center" class="bg-secondary col-lg-12 text-white"  > <i class="fas fa-address-card"></i> Registro de Nuevos Asesores Institucionales </h5> 
                                                                            <div class="form-inline col-lg-12">

                                                                                <div class=" form-group col-lg-9">
                                                                                    <s:textfield  cssClass="form-control col-lg-8 text-uppercase" name="ad.CURP_ASESORIAUX" id="ad.CURP_ASESORIAUX"  placeholder="INGRESE LA CURP DEL ASESOR QUE DESEA REGISTRAR" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorValCurpA" cssClass="alert alert-danger"></s:fielderror>
                                                                                    </div> 
                                                                                    <div class="form-group col-lg-2">                                                             

                                                                                        <a class="btn bg-success " style="color: white;"  href="Javascript:Accion('ConsultaCurpA')">Buscar CURP</a>

                                                                                    </div>    
                                                                                </div>
                                                                                <br></br>        
                                                                            <s:if test="BANCURPAENCONTRADA">
                                                                                <div class="alert alert-primary"  style="width:100%; border-radius: 5px; ">
                                                                                    <h5 align="center" style="color: #ffffff">CURP VALIDADA</h5>
                                                                                </div>
                                                                            </s:if>    
                                                                        </div>

                                                                        <div class="row">
                                                                            <s:if test="banCurpAValida">  
                                                                                <s:hidden name="banCurpAValida" value="%{banCurpAValida}"></s:hidden>
                                                                                    <div class="form-group col-lg-6 ">
                                                                                        <label class="col-form-label"  for="nombre">CURP:</label>
                                                                                        <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.CURP_ASESORI" id="nombrea" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorCURPA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-6 ">
                                                                                    <label class="col-form-label"  for="nombre">Nombre:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.NOMBREAI" id="nombrea" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorNombreA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>              
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label" for="apellidop">Apellido Paterno:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOPAI" id="apellidopa" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorApellidoPA" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>    
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label" for="apellidomr">Apellido Materno:</label>
                                                                                    <div class="col-sm-auto">
                                                                                        <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOMAI" id="apellidoma" readonly="true"></s:textfield>
                                                                                        <s:fielderror fieldName="ErrorApellidoMAI" cssClass="alert alert-danger"/>
                                                                                    </div> 
                                                                                </div>   
                                                                                <div class="form-group col-lg-12">
                                                                                    <label class="col-form-label text-muted " for="CARRERA" >Carrera:</label>
                                                                                    <div class="col-sm-auto ">
                                                                                        <s:select  name="ad.CVE_CAR_ASE" id="carrera" list="ObtenerCarreraCCT"  listKey="CLAVECARRERA"  listValue="NOMBRE_CARRERA"  headerKey="" headerValue="--SELECCIONE UNA CARRERA" cssClass="form-control " ></s:select>
                                                                                        <s:fielderror fieldName="ErrorCarrera" cssClass="alert alert-danger" />
                                                                                    </div> 
                                                                                </div>       
                                                                                <div class="form-group col-lg-12">                                                             
                                                                                    <div align="center">
                                                                                        <a class="btn bg-success " style="color: white;"  href="Javascript:Accion('GuardarAsesorN')">Guardar  Asesor</a>
                                                                                    </div>  
                                                                                </div>
                                                                            </s:if> 
                                                                            <s:if test="BanExisteAsesorStatusInhabil">

                                                                                <div  class="modal-dialog bg-info" role="document">
                                                                                    <div class="modal-content ">
                                                                                        <div class="modal-header bg-secondary">
                                                                                            <h5 class="modal-title text-white" id="exampleModalLabel">Habilitar Asesor</h5>
                                                                                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                                                <span aria-hidden="true"></span>
                                                                                            </button>
                                                                                        </div>
                                                                                        <div class="modal-body bg-primary text-white">El Asesor que intenta registrar ya se encuentra en la base de datos con un estatus inhabilitado. Desea Habilitar al Asesor?</div>
                                                                                        <div class="modal-footer bg-secondary">
                                                                                             <s:textfield name="ad.ID_CAT_ASEA" id="ad.ID_CAT_ASEA"  style='visibility:hidden' ></s:textfield> 
                                                                                            <a class="btn btn-primary" href="Javascript:Accion('ActualizaAse')">Habilitar</a>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>

                                                                            </s:if>   
                                                                            &nbsp;
                                                                            &nbsp;
                                                                            &nbsp;
                                                                            <h5 align="center" class="bg-secondary col-lg-12 text-white"  > <i class="fas fa-user"></i>Asesores Registrados  </h5>   
                                                                            <div class="input-group ">                        
                                                                                <i class="fa fa-search fa-2x " style="color: #0056b3"></i>                                                                                                                  
                                                                                <input id="filtrarA" type="text" class="form-control" placeholder="INGRESA EL NOMBRE DEL ASESOR QUE BUSCA...."/>
                                                                            </div>                                                                                                                                                     

                                                                            <br/>
                                                                            <br/>
                                                                            <br/>
                                                                            <br/>
                                                                            <div class="table-wrapper-scroll-y col-lg-12">  
                                                                                <table class="table table-hover">
                                                                                    <thead>
                                                                                        <tr class="bg-secondary" style="font-size: 75%; color: #fff;">
                                                                                            <th scope="col" >CURP</th>
                                                                                            <th scope="col" >Nombre</th>                                                                                         
                                                                                            <th scope="col" >Apellido Paterno</th>
                                                                                            <th scope="col" >Apellido Materno</th>
                                                                                            <th scope="col" >Clave Carrera</th>
                                                                                            <th scope="col" >Eliminar</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody class='buscarA'>

                                                                                        <s:iterator value="ListaAsesores" id="ListaAsesores" status="stat">
                                                                                            <tr style="color: #666; font-size: 70%;">
                                                                                                <td  ><s:property value="CURP_ASESORI"/></td>
                                                                                                <td  ><s:property value="NOMBREAI"/></td>
                                                                                                <td  ><s:property value="APELLIDOPAI"/></td>                                                                                             
                                                                                                <td  ><s:property value="APELLIDOMAI"/></td>
                                                                                                <td  ><s:property value="CVE_CAR_ASE"/></td>
                                                                                                <td >
                                                                                                    <a href="#" data-toggle='modal' data-target='#DeleteAsesor' 
                                                                                                       data-id_eliminar_ase='<s:property value="ID_CAT_ASE"/>'>
                                                                                                        <i class="fa fa-trash" style="font-size: 25px; color: #004085; "></i></a>
                                                                                                </td>          
                                                                                            </tr>  

                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].CURP_ASESORI" id="CURP_ASESORI"></s:hidden>     
                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].NOMBREAI" id="NOMBREAI"></s:hidden>  
                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].APELLIDOPAI" id="APELLIDOPAI"></s:hidden> 
                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].APELLIDOMAI" id="APELLIDOMAI"></s:hidden>  
                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].CVE_CAR_ASE" id="CVE_CAR_ASE"></s:hidden>  
                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].CCT_ASE" id="CCT_ASE"></s:hidden>  
                                                                                            <s:hidden  name = "ListaAsesores[%{#stat.index}].ID_CAT_ASE" id="ID_CAT_ASE"></s:hidden>  


                                                                                        </s:iterator>


                                                                                    </tbody>
                                                                                </table>
                                                                            </div>   
                                                                        </div>  


                                                                    </div>
                                                                    <div class="modal-footer bg-secondary" >

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
                                                        <!-- Actualiza Responsable Modal-->
                                                        <div class="modal fade" id="EditResponsables" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog modal-lg " role="document">
                                                                <div class="modal-content">
                                                                    <div class="modal-header bg-primary">
                                                                        <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> ACTUALIZACIÓN DE RESPONSABLE INSTITUCIONAL</h4> 
                                                                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true"></span>
                                                                        </button>
                                                                    </div>
                                                                    <div class="modal-body">

                                                                        <div class="row">
                                                                            <div class="form-group col-lg-6">
                                                                                <label class="col-form-label" for="curp">CURP:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.CURP_RESPONSABLEA" id="curpr" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCurpRA" cssClass="alert alert-danger"></s:fielderror>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-6 ">
                                                                                    <label class="col-form-label"  for="nombre">Nombre:</label>
                                                                                    <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.NOMBRERA" id="nombrer" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorNombreRA" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>              
                                                                            <div class="form-group col-lg-6">
                                                                                <label class="col-form-label" for="apellidop">Apellido Paterno:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOPRA" id="apellidopr" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorApellidoPRA" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>    
                                                                            <div class="form-group col-lg-6">
                                                                                <label class="col-form-label" for="apellidomr">Apellido Materno:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOMRA" id="apellidomr" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorApellidoMRA" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>   
                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="Genero">Cargo:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.CARGO_RESPONSABLEA" id="cargo" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCargoRA" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>      

                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="tel">Teléfono:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.TELEFONO_RESPONSABLEA" id="telefonor"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorTelRA" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>     

                                                                            <div class="form-group col-lg-4">
                                                                                <label class="col-form-label" for="correo">Email:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control " name="ad.EMAIL_RESPONSABLEA" id="emailr" ></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCorreoRA" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>  

                                                                        </div>
                                                                        <s:textfield name="ad.ID_CAT_RESPA" id="idresp" cssStyle="display:none;"></s:textfield>        

                                                                        </div>        
                                                                        <div class="modal-footer">
                                                                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                                            <a class="btn btn-primary" href="Javascript:ValidaResponsableM('ActualizaResp')">Actualizar</a>
                                                                        </div>                                         
                                                                    </div>
                                                                </div>
                                                            </div>    
                                                            <!-- Elimiar Responsable Modal-->
                                                            <div class="modal fade" id="DeleteResp" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog" role="document">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Eliminar Responsable</h5>
                                                                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true"></span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body">Estas seguro que deseas eliminar el responsable Institucional?
                                                                        <s:textfield name="ad.ID_CAT_RESP" id="id_eliminar_resp" cssStyle="display:none;"></s:textfield> 
                                                                        </div>


                                                                        <div class="modal-footer">
                                                                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                                            <a class="btn btn-primary" href="Javascript:Accion('EliminarResp')">Aceptar</a>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div> 
                                                            <%--            
                                                            <!-- Actualiza Asesores Modal-->
                                                            <div class="modal fade" id="EditAsesores" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-lg " role="document">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header bg-primary">
                                                                            <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> ACTUALIZACIÓN DE ASESOR INSTITUCIONAL</h4> 
                                                                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true"></span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body">

                                                                            <div class="row">
                                                                                <div class="form-group col-lg-6">
                                                                                    <label class="col-form-label" for="curp">CURP:</label>
                                                                                    <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.CURP_ASESORIA" id="curpa" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorCurp" cssClass="alert alert-danger"></s:fielderror>
                                                                                    </div> 
                                                                                </div>
                                                                                <div class="form-group col-lg-6 ">
                                                                                    <label class="col-form-label" style="text-align : left;" for="nombre">Nombre:</label>
                                                                                    <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.NOMBREAIA" id="nombrea" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorNombre" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>              
                                                                            <div class="form-group col-lg-6">
                                                                                <label class="col-form-label" for="apellidop">Apellido Paterno:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOPAIA" id="apellidopa" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorApellidoP" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>    
                                                                            <div class="form-group col-lg-6">
                                                                                <label class="col-form-label" for="apellidomr">Apellido Materno:</label>
                                                                                <div class="col-sm-auto">
                                                                                    <s:textfield  cssClass="form-control text-uppercase" name="ad.APELLIDOMAIA" id="apellidoma" readonly="true"></s:textfield>
                                                                                    <s:fielderror fieldName="ErrorApellidoM" cssClass="alert alert-danger"/>
                                                                                </div> 
                                                                            </div>   
                                                                            <div class="form-group col-lg-12">
                                                                                <label class="col-form-label text-muted " for="CARRERA" >Carrera:</label>
                                                                                <div class="col-sm-auto ">
                                                                                    <s:select  name="ad.CVE_CAR_ASEA" id="carrera" list="ObtenerCarreraCCT"  listKey="CLAVECARRERA"  listValue="NOMBRE_CARRERA"  headerKey="" headerValue="--SELECCIONE UNA CARRERA" cssClass="form-control " ></s:select>
                                                                                    <s:fielderror fieldName="ErrorCarrera" cssClass="alert alert-danger" />
                                                                                </div> 
                                                                            </div>      



                                                                        </div>
                                                                        <s:textfield name="ad.ID_CAT_ASEA" id="idase" cssStyle="display:none;"></s:textfield>        

                                                                        </div>        
                                                                        <div class="modal-footer">
                                                                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                                            <a class="btn btn-primary" href="Javascript:Accion('ActualizaAse')">Actualizar</a>
                                                                        </div>                                         
                                                                    </div>
                                                                </div>
                                                            </div>  
                                                            --%>
                                                            <!-- Elimiar Ase Modal-->
                                                            <div class="modal fade" id="DeleteAsesor" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog" role="document">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Eliminar Asesor Institucional</h5>
                                                                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true"></span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body">Estas seguro que deseas eliminar el Asesor Institucional?
                                                                        <s:textfield name="ad.ID_CAT_ASE" id="id_eliminar_ase"  style='visibility:hidden'></s:textfield> 
                                                                        </div>


                                                                        <div class="modal-footer">
                                                                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                                            <a class="btn btn-primary" href="Javascript:Accion('EliminarAse')">Aceptar</a>
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


                                                            <script>
                                                    $('#EditResponsables').on('show.bs.modal', function (event) {
                                                        var button = $(event.relatedTarget) // Button that triggered the modal


                                                        var recipient0 = button.data('curpr')
                                                        var recipient1 = button.data('nombrer')
                                                        var recipient2 = button.data('apellidopr')
                                                        var recipient3 = button.data('apellidomr')
                                                        var recipient4 = button.data('cargo')
                                                        var recipient5 = button.data('telefonor')
                                                        var recipient6 = button.data('emailr')
                                                        var recipient7 = button.data('idresp')



                                                        // Extract info from data-* attributes
                                                        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                                                        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.

                                                        var modal = $(this)
                                                        modal.find('.modal-body #curpr').val(recipient0)
                                                        modal.find('.modal-body #nombrer').val(recipient1)
                                                        modal.find('.modal-body #apellidopr').val(recipient2)
                                                        modal.find('.modal-body #apellidomr').val(recipient3)
                                                        modal.find('.modal-body #cargo').val(recipient4)
                                                        modal.find('.modal-body #telefonor').val(recipient5)
                                                        modal.find('.modal-body #emailr').val(recipient6)
                                                        modal.find('.modal-body #idresp').val(recipient7)





                                                    });

                                                            </script>

                                                            <script>
                                                                $('#EditAsesores').on('show.bs.modal', function (event) {
                                                                    var button = $(event.relatedTarget) // Button that triggered the modal




                                                                    var recipient0 = button.data('curpa')
                                                                    var recipient1 = button.data('nombrea')
                                                                    var recipient2 = button.data('apellidopa')
                                                                    var recipient3 = button.data('apellidoma')
                                                                    var recipient4 = button.data('carrera')
                                                                    var recipient5 = button.data('idase')




                                                                    // Extract info from data-* attributes
                                                                    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                                                                    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.

                                                                    var modal = $(this)
                                                                    modal.find('.modal-body #curpa').val(recipient0)
                                                                    modal.find('.modal-body #nombrea').val(recipient1)
                                                                    modal.find('.modal-body #apellidopa').val(recipient2)
                                                                    modal.find('.modal-body #apellidoma').val(recipient3)
                                                                    modal.find('.modal-body #carrera').val(recipient4)
                                                                    modal.find('.modal-body #idase').val(recipient5)

                                                                });

                                                            </script>

                                                            <script>
                                                                $('#DeleteResp').on('show.bs.modal', function (event) {
                                                                    var button = $(event.relatedTarget) // Button that triggered the modal


                                                                    var recipient0 = button.data('id_eliminar_resp')
                                                                    var modal = $(this)
                                                                    modal.find('.modal-body #id_eliminar_resp').val(recipient0)
                                                                });

                                                            </script>  

                                                            <script>
                                                                $('#DeleteAsesor').on('show.bs.modal', function (event) {
                                                                    var button = $(event.relatedTarget) // Button that triggered the modal


                                                                    var recipient0 = button.data('id_eliminar_ase')
                                                                    var modal = $(this)
                                                                    modal.find('.modal-body #id_eliminar_ase').val(recipient0)
                                                                });

                                                            </script>  

                                                    </s:form>

                                                </body>

                                                </html>
