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

                                                    function registroDual(accion, valor) {

                                                        document.formularioPrincipal.CURPA.value = valor;
                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.target = "_self";
                                                        document.formularioPrincipal.submit();

                                                    }
                                                    function registroBeca(accion, valor) {

                                                        document.formularioPrincipal.CURPAB.value = valor;
                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.target = "_self";
                                                        document.formularioPrincipal.submit();

                                                    }

                                                    function ModificarDual(accion, valor) {

                                                        document.formularioPrincipal.CURPA.value = valor;
                                                        document.formularioPrincipal.action = accion;
                                                        document.formularioPrincipal.target = "_self";
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

                                                        window.location.hash = "no-back-button";
                                                        window.location.hash = "Again-No-back-button" //chrome
                                                        window.onhashchange = function () {
                                                            window.location.hash = "no-back-button";
                                                        }




                                                    }


                                                </script>
                                                <!-- Bootstrap core JavaScript -->
                                                <script src="vendor/jquery/jquery.min.js"></script>  

                                                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css"/>
                                                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                                                <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>


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

                                                            $('#filtrarB').keyup(function () {

                                                                var rex = new RegExp($(this).val(), 'i');
                                                                $('.buscarB tr').hide();
                                                                $('.buscarB tr').filter(function () {
                                                                    return rex.test($(this).text());
                                                                }).show();

                                                            })

                                                        }(jQuery));

                                                    });
                                                </script>



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

                                                        $("#fechaingresodual").datepicker();

                                                    });

                                                </script>


                                                </head>

                                                <body id="page-top" >
                                                      <s:form name="formularioPrincipal" id="formularioPrincipal" enctype="multipart/form-data">

                                                            < !-- Navigation -- >
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
                                                                          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Javascript:Accion('FormAlumn')">Registrar Alumno</a>
                                                                      </li>

                                                                      <li class="nav-item mx-0 mx-lg-1">
                                                                          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#ab">Agregar Becas</a>
                                                                      </li>
                                                                      <li class="nav-item mx-0 mx-lg-1">
                                                                          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Javascript:Accion('AbreTablero')">Tablero de Control</a>
                                                                      </li>

                                                                      <li class="nav-item mx-0 mx-lg-1">
                                                                          <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Javascript:Accion('AdminCat')">Administrar Catalogos</a>
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


                                                              <s:if test="BanAlumReg">
                                                                  <div class="alert bg-success"  style="width:100%; border-radius: 5px; ">
                                                                      <h5 align="center" style="color: #ffffff">Alumno Registrado Correctamente</h5>
                                                                  </div>
                                                              </s:if> 
                                                              <s:if test="BanAlumHabilitado">
                                                                  <div class="alert bg-success"  style="width:100%; border-radius: 5px; ">
                                                                      <h5 align="center" style="color: #ffffff">Alumno Habilitado Correctamnte</h5>
                                                                  </div>
                                                              </s:if> 
                                                              <div class="container-fluid"  >
                                                                  <div class="modal-content" style="border-radius: 10px;">
                                                                      <div class="modal-header bg-secondary col-lg-12">
                                                                          <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> REGISTRO DE PROYECTOS (SISTEMA DUAL)</h4> 
                                                                          <br/>
                                                                      </div>  
                                                                      <div class="modal-body">                                              
                                                                          <div class="row">

                                                                              <s:if test="BanProyectoRegistrado">
                                                                                  <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                      <h5 align="center" style="color: #ffffff">Proyecto Registrado Correctamente</h5>
                                                                                  </div>
                                                                              </s:if> 
                                                                              <s:if test="BanProyectoActualizado">
                                                                                  <div class="alert alert-success"  style="width:100%; border-radius: 5px; ">
                                                                                      <h5 align="center" style="color: #ffffff">Proyecto Actualizado Correctamente</h5>
                                                                                  </div>
                                                                              </s:if> 





                                                                              <div class="input-group ">                        
                                                                                  <i class="fa fa-search fa-2x " style="color: #0056b3"></i>                                                                                                                  
                                                                                  <input id="filtrar" type="text" class="form-control" placeholder="INGRESA EL NOMBRE DEL ALUMNO QUE BUSCA...."/>
                                                                              </div>                                                                                                                                                     

                                                                              <br/>
                                                                              <br/>
                                                                              <br/>
                                                                              <br/>
                                                                              <div class="table-wrapper-scroll-y col-lg-12">  
                                                                                  <table class="table table-hover">
                                                                                      <thead>
                                                                                          <tr class="bg-secondary" style="font-size: 75%;">
                                                                                              <th scope="col" >CURP</th>
                                                                                              <th scope="col" >Matrícula</th>
                                                                                              <th scope="col" >Nombre</th>                                                                                         
                                                                                              <th scope="col" >Nombre Carrera</th>
                                                                                              <th scope="col" >Avance</th>
                                                                                              <th scope="col" >Acciones</th>
                                                                                              <th scope="col" >Modificar</th>
                                                                                          </tr>
                                                                                      </thead>
                                                                                      <tbody class='buscar'>

                                                                                          <s:iterator value="ListaAlumnos" id="ListaAlumnos" status="stat">
                                                                                              <tr style="color: #666; font-size: 70%;">
                                                                                                  <td  ><s:property value="CURP"/></td>
                                                                                                  <td  ><s:property value="MATRICULA"/></td>
                                                                                                  <td  ><s:property value="NOMBRE_COMPLETO"/></td>                                                                                             
                                                                                                  <td  ><s:property value="NOMBRE_CARRERA"/></td>
                                                                                                  <td   style="width: 15%;"><s:if test="AVANCE=='100'">
                                                                                                          <div style="width: 80%"> 
                                                                                                              <div style="width: 50%; height: 25px; background: green; color: #ffffff; border-radius: 0px 5px 5px 0px; box-shadow: 2px 2px 2px #666;">100% </div>                                                                             
                                                                                                          </div>   
                                                                                                      </s:if>
                                                                                                      <s:if test="AVANCE=='50'">
                                                                                                          <div style="width: 80%"> 
                                                                                                              <div style="width: 50%; height: 25px; background: yellow; border-radius: 0px 5px 5px 0px; box-shadow: 2px 2px 2px #666;">50% </div>                                                                                
                                                                                                          </div>    
                                                                                                      </s:if>                                                              
                                                                                                  </td>
                                                                                                  <s:if test="AVANCE=='50'">
                                                                                                      <td ><a href="Javascript:registroDual('registroDual','<s:property value="CURP"/>')"><i class="fa fa-book" style="font-size: 25px; color: #ffff00;"></i><span class="text-muted"> Agregar Proyecto</span></a></td>
                                                                                                              </s:if>  
                                                                                                              <s:if test="AVANCE=='100'">
                                                                                                      <td ><a href="Javascript:ModificarDual('ModificarProyecto','<s:property value="CURP"/>')"><i class="fa fa-book" style="font-size: 25px; color: #339900"></i><span class="text-muted"> Modificar o Concluir Proyecto</span></a></td>
                                                                                                              </s:if>  
                                                                                                  <td ><a   data-toggle='modal' data-target='#editUsu' 
                                                                                                            data-matricula='<s:property value="MATRICULA"/>' 
                                                                                                            data-curp='<s:property value="CURP"/>' 
                                                                                                            data-nombre='<s:property value="NOMBRE"/>' 
                                                                                                            data-apellidop='<s:property value="APELLIDOP"/>' 
                                                                                                            data-apellidom='<s:property value="APELLIDOM"/>' 
                                                                                                            data-genero='<s:property value="SEXO"/>' 
                                                                                                            data-fechanac='<s:property value="FECNAC"/>' 
                                                                                                            data-domicilio='<s:property value="DOMICILIOA"/>' 
                                                                                                            data-colonia='<s:property value="COLONIAA"/>'
                                                                                                            data-cp='<s:property value="CP"/>' 
                                                                                                            data-telefono='<s:property value="TELEFONO"/>' 
                                                                                                            data-correo='<s:property value="CORREO"/>'  
                                                                                                            data-carrera='<s:property value="NOMBRE_CARRERA"/>'
                                                                                                            data-grado='<s:property value="GRADO"/>' 
                                                                                                            data-promedio='<s:property value="PROMEDIOGRAL"/>'  
                                                                                                            data-situacion='<s:property value="SITUACIONACA"/>'  
                                                                                                            data-tipo_alu='<s:property value="TIPO_ALUM"/>'
                                                                                                            data-municipio='<s:property value="CVE_MUNA"/>' 
                                                                                                            data-fechaingresodual='<s:property value="FECHA_INGRESO_DUAL"/>'
                                                                                                            data-cct='<s:property value="CCT"/>' 
                                                                                                            ><i class="fa fa-pen" style="font-size: 25px;  color: #004085; "></i>
                                                                                                      </a>
                                                                                                  </td>
                                                                                              </tr>  

                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].MATRICULA" id="MATRICULA"></s:hidden>     
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].CURP" id="CURP"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].NOMBRE" id="NOMBRE"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].APELLIDOP" id="APELLIDOP"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].APELLIDOM" id="APELLIDOM"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].SEXO" id="SEXO"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].FECNAC" id="FECNAC"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].DOMICILIOA" id="DOMICILIOA"></s:hidden>
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].COLONIAA" id="COLONIAA"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].CP" id="CP"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].TELEFONO" id="TELEFONO"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].CORREO" id="CORREO"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].NOMBRE_CARRERA" id="NOMBRE_CARRERA"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].GRADO" id="GRADO"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].PROMEDIOGRAL" id="PROMEDIOGRAL"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].SITUACIONACA" id="SITUACIONACA"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].TIPO_ALUM" id="TIPO_ALUM"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].CVE_MUNA" id="CVE_MUNA"></s:hidden>
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].FECHA_INGRESO_DUAL" id="FECHA_INGRESO_DUAL"></s:hidden>
                                                                                              <s:hidden  name = "ListaAlumnos[%{#stat.index}].CCT" id="CCT"></s:hidden> 
                                                                                          </s:iterator>


                                                                                      </tbody>
                                                                                  </table>
                                                                              </div>   
                                                                          </div>
                                                                      </div>                                                                   
                                                                  </div>  
                                                              </div>
                                                              <s:textfield  cssClass="form-control" name="datos.CURPA" id="CURPA"  maxlength="200" cssStyle="display:none;"></s:textfield>
                                                                  <br></br>   
                                                                  <br></br>  
                                                                  <br></br>   
                                                                  <br></br>  
                                                                  <br></br>   
                                                                  <br></br>   
                                                              </header>

                                                              <!-- REGISTRA becas -->
                                                              <section   id="ab">
                                                                  <div class="container-fluid"  >
                                                                      <div class="modal-content" style="border-radius: 10px;">
                                                                          <div class="modal-header bg-secondary col-lg-12">
                                                                              <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> REGISTRO DE BECAS </h4> 
                                                                              <br/>
                                                                          </div>  
                                                                          <div class="modal-body">                                              
                                                                              <div class="row">


                                                                                  <div class="input-group ">                        
                                                                                      <i class="fa fa-search fa-2x " style="color: #0056b3"></i>                                                                                                                  
                                                                                      <input id="filtrarB" type="text" class="form-control" placeholder="INGRESA EL NOMBRE DEL ALUMNO QUE BUSCA...."/>
                                                                                  </div>                                                                                                                                                     

                                                                                  <br/>
                                                                                  <br/>
                                                                                  <br/>
                                                                                  <br/>
                                                                                  <div class="table-wrapper-scroll-y col-lg-12">  
                                                                                      <table class="table table-hover">
                                                                                          <thead>
                                                                                              <tr class="bg-secondary" style="font-size: 75%; color: #ffffff;">
                                                                                                  <th scope="col" >CURP</th>
                                                                                                  <th scope="col" >Matrícula</th>
                                                                                                  <th scope="col" >Nombre</th>                                                                                         
                                                                                                  <th scope="col" >Nombre Carrera</th>
                                                                                                  <th scope="col" >BECA</th>
                                                                                                  <th scope="col" >Acciones</th>

                                                                                              </tr>
                                                                                          </thead>
                                                                                          <tbody class='buscarB'>

                                                                                          <s:iterator value="ListaAlumnosBeca" id="ListaAlumnosBeca" status="stat">
                                                                                              <tr style="color: #666; font-size: 70%;">
                                                                                                  <td  ><s:property value="CURP"/></td>
                                                                                                  <td  ><s:property value="MATRICULA"/></td>
                                                                                                  <td  ><s:property value="NOMBRE_COMPLETO"/></td>                                                                                             
                                                                                                  <td  ><s:property value="NOMBRE_CARRERA"/></td>
                                                                                                  <td   style="width: 15%;">
                                                                                                      <s:if test="BECA=='si'">
                                                                                                          <div style="width: 80%"> 
                                                                                                              <div style="width: 70%; height: 30px; background: green; color: #ffffff; border-radius: 0px 5px 5px 0px; box-shadow: 2px 2px 2px #666;"> Con Beca Registrada </div>                                                                             
                                                                                                          </div>   
                                                                                                      </s:if>
                                                                                                      <s:if test="BECA=='no'">
                                                                                                          <div style="width: 80%"> 
                                                                                                              <div style="width: 70%; height: 30px; background: yellow; border-radius: 0px 5px 5px 0px; box-shadow: 2px 2px 2px #666;"> Sin Beca Registrada </div>                                                                                
                                                                                                          </div>    
                                                                                                      </s:if>                                                              
                                                                                                  </td>

                                                                                                  <td ><a href="Javascript:registroBeca('registroBeca','<s:property value="CURP"/>')"><i class="fa fa-book" style="font-size: 25px; color: #004085; "></i><span class="text-muted"> Agregar Beca</span></a></td>



                                                                                              </tr>  

                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].MATRICULA" id="MATRICULA"></s:hidden>     
                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].CURP" id="CURP"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].NOMBRE" id="NOMBRE"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].APELLIDOP" id="APELLIDOP"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].APELLIDOM" id="APELLIDOM"></s:hidden> 
                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].BECA" id="BECA"></s:hidden>  
                                                                                              <s:hidden  name = "ListaAlumnosBeca[%{#stat.index}].CCT" id="CCT"></s:hidden> 
                                                                                          </s:iterator>


                                                                                      </tbody>
                                                                                  </table>
                                                                              </div>   
                                                                          </div>
                                                                      </div>                                                                   
                                                                  </div>  
                                                              </div>
                                                              <s:textfield  cssClass="form-control" name="datos.CURPAB" id="CURPAB"  maxlength="200" cssStyle="display:none;"></s:textfield>
                                                                  <br></br>   
                                                                  <br></br>  
                                                                  <br></br>  
                                                                  <br></br>  
                                                                  <br></br>   
                                                                  <br></br>   
                                                              </section>

                                                              <!-- Actualiza Modal-->
                                                              <div class="modal fade" id="editUsu" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                  <div class="modal-dialog modal-lg " role="document">
                                                                      <div class="modal-content">
                                                                          <div class="modal-header bg-primary">
                                                                              <h4 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> ACTUALIZACIÓN DE DATOS PERSONALES DEL ALUMNO</h4> 
                                                                              <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                                  <span aria-hidden="true"></span>
                                                                              </button>
                                                                          </div>
                                                                          <div class="modal-body">

                                                                              <div class="row">
                                                                                  <div class="form-group col-lg-6">
                                                                                      <label class="col-form-label" for="matricula">Matricula:</label>
                                                                                      <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.MATRICULA" id="matricula" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorMatricula" cssClass="alert alert-danger"></s:fielderror>
                                                                                      </div> 
                                                                                  </div>
                                                                                  <div class="form-group col-lg-6 ">
                                                                                      <label class="col-form-label" style="text-align : left;" for="curp">CURP:</label>
                                                                                      <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.CURP" id="curp" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorCurp" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>
                                                                              <div class="form-group col-lg-12">
                                                                                  <label class="col-form-label" for="nombre">Nombre:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.NOMBRE" id="nombre" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorNombre" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>
                                                                              <div class="form-group col-lg-6">
                                                                                  <label class="col-form-label" for="apellidop">Apellido Paterno:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.APELLIDOP" id="apellidop" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorApellidoP" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>    
                                                                              <div class="form-group col-lg-6">
                                                                                  <label class="col-form-label" for="apellidom">Apellido Materno:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.APELLIDOM" id="apellidom" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorApellidoM" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>   
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="Genero">Genero:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.SEXO" id="genero" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorGenero" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>      
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="fechaNac">Fecha de Nacimiento:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.FECHANAC" id="fechanac" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorFechaNac" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>  
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="tel">Teléfono:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.TELEFONO" id="telefono"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorTel" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>     
                                                                              <div class="form-group col-lg-12">
                                                                                  <label class="col-form-label" for="domicilio">Domicilio:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.DOMICILIOA" id="domicilio"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorDomicilio" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>    
                                                                              <div class="form-group col-lg-9">
                                                                                  <label class="col-form-label" for="Colonia">Colonia:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.COLONIAA" id="colonia" ></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorColonia" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>     
                                                                              <div class="form-group col-lg-3">
                                                                                  <label class="col-form-label" for="cp">Codigo Postal:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.CP" id="cp" ></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorCp" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>                                                     
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="correo">Email:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control " name="datos.CORREO" id="correo" ></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorCorreo" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>  
                                                                              <div class="form-group col-lg-8">
                                                                                  <label class="col-form-label" for="carrera">Carrera:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.NOMBRE_CARRERA" id="carrera" readonly="true"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorCorreo" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>   
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="grado">Cuatrimestre/Semestre:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.GRADO" id="grado"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorGrado" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div> 
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="promedio">Promedio:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.PROMEDIOGRAL" id="promedio"></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorPromedio" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="SituacionAca">Situación Academica:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield  cssClass="form-control text-uppercase" name="datos.SITUACIONACA" id="situacion" ></s:textfield>
                                                                                      <s:fielderror fieldName="ErrorSituacion" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label" for="tipo_Alumno">Tipo de Alumno:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:select  name="datos.TIPO_ALUM" id="tipo_alu" list="ListaTipoAlumno"  listKey="ID_TIPOALUM"  listValue="NOM_TIPO"  headerKey="" headerValue="--SELECCIONE--" cssClass="form-control " ></s:select>                                                                                                                 
                                                                                      <s:fielderror fieldName="ErrorTipoAlum" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>      
                                                                              <div class="form-group col-lg-8">
                                                                                  <label class="col-form-label " for="Municipio" >Municipio</label>
                                                                                  <div class="col-sm-auto ">
                                                                                      <s:select  name="datos.MUNICIPIO" id="municipio" list="ListaMunicipios"  listKey="ID"  listValue="MUNICIPIO"  headerKey="" headerValue="Municipio" cssClass="form-control "  ></s:select>
                                                                                      <s:fielderror fieldName="ErrorMunicipio" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
                                                                                  </div> 
                                                                              </div>  
                                                                              <div class="form-group col-lg-4">
                                                                                  <label class="col-form-label text-muted" for="FI">Fecha de ingreso a DUAL:</label>
                                                                                  <div class="col-sm-auto">
                                                                                      <s:textfield name="datos.FECHA_INGRESO_DUAL" id="fechaingresodual"  placeholder="Fecha de ingreso a DUAl" required="true" readonly="true" cssClass="form-control text-uppercase"  />
                                                                                      <s:fielderror fieldName="ErrorFID" cssClass="alert alert-danger"/>
                                                                                  </div> 
                                                                              </div>    
                                                                          </div>
                                                                          <s:textfield name="datos.CCT" id="cct" cssStyle="display:none;"></s:textfield>        

                                                                          </div>        
                                                                          <div class="modal-footer">
                                                                              <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                                              <a class="btn btn-primary" href="Javascript:Accion('actualizarAlumno')">Actualizar</a>
                                                                          </div>                                         
                                                                      </div>
                                                                  </div>
                                                              </div>                  

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

                                                      <script>
                                                        $('#editUsu').on('show.bs.modal', function(event) {
                                                            var button = $(event.relatedTarget) // Button that triggered t                                                                                                                                    he modal

                                                            var recipient0 = button.data('matricula')
                                                            var recipient1 = button.data('curp')
                                                            var recipient2 = button.data('nombre')
                                                            var recipient3 = button.data('apellidop')
                                                            var recipient4 = button.data('apellidom')
                                                            var recipient5 = button.data('genero')
                                                            var recipient6 = button.data('fechanac')
                                                            var recipient7 = button.data('domicilio')
                                                            var recipient8 = button.data('colonia')
                                                            var recipient9 = button.data('cp')
                                                            var recipient10 = button.data('telefono')
                                                            var recipient11 = button.data('correo')
                                                            var recipient12 = button.data('carrera')
                                                            var recipient13 = button.data ('grado')
                                                            var recipient14 = button.data('promedio')
                                                            var recipient15 = button.data('situacion')
                                                            var recipient16 = button.data('tipo_alu')
                                                            var recipient17 = button.data('municipio')
                                                            var recipient18 = button.data('cct')
                                                            var recipient19 = button.data('fechaingresodual')


                                                            // Extract info from data-* a                                                                                                                                    ttributes
                                                            // If necessary, you could initiate an AJAX request here (and then do the updating in a c                                                                                                                                    allback).
                                                            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods                                                                                                                                     instead.

                                                            var modal = $(this)
                                                                    modal.find('.modal-body #matricula').val(recipient0)
                                                                    modal.find('.modal-body #curp').val(recipient1)
                                                                    modal.find('.modal-body #nombre').val(recipient2)
                                                                    modal.find('.modal-body #apellidop').val(recipient3)
                                                                    modal.find('.modal-body #apellidom').val(recipient4)
                                                                    modal.find('.modal-body #genero').val(recipient5)
                                                                    modal.find('.modal-body #fechanac').val(recipient6)
                                                                    modal.find('.modal-body #domicilio').val(recipient7)
                                                                    modal.find('.modal-body #colonia').val(recipient8)
                                                                    modal.find('.modal-body #cp').val(recipient9)
                                                                    modal.find('.modal-body #telefono').val(recipient10)
                                                                    modal.find('.modal-body #correo').val(recipient11)
                                                                    modal.find('.modal-body #carrera').val(recipient12)
                                                                    modal.find('.modal-body #grado').val(recipient13)
                                                                    modal.find('.modal-body #promedio').val(recipient14)
                                                                    modal.find('.modal-body #situacion').val(recipient15)
                                                                    modal.find('.modal-body #tipo_alu').val(recipient16)
                                                                    modal.find('.modal-body #municipio').val(recipient17)
                                                                    modal.find('.modal-body #cct').val(recipient18)
                                                                    modal.find('.modal-body #fechaingresodual').val(recipient19)





                                                                  });
                                                                                                                           
                                                                  </script>

                                                              <s:iterator value="ListaTipoAlumno" id="ListaTipoAlumno" status="stat">
                                                                  <s:hidden  name = "ListaTipoAlumno[%{#stat.index}].ID_TIPOALUM" id="ID_TIPOALUM"></s:hidden>
                                                                  <s:hidden  name = "ListaTipoAlumno[%{#stat.index}].NOM_TIPO" id="NOM_TIPO"></s:hidden>
                                                              </s:iterator>       

                                                          </s:form>

                                                </body>

                                                </html>
