<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="css/estilo.css"/>



    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
        <s:iterator value="ListaTotalEstatusU" id="ListaTotalEstatusU" status="stat">

                ['<s:property value="NOM_ESTATUS"/>', <s:property value="TOTAL_ESTATUS"/>],

        </s:iterator>

            ]);

            var options = {

                backgroundColor: '#edecec',

            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart'));

            chart.draw(data, options);
        }
    </script>    



    <script type="text/javascript">
        google.charts.load("current", {packages: ['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ["Element", "Density", {role: "style"}],
        <s:iterator value="ListaTotalEsuelaU" id="ListaTotalEsuelaU" status="stat">
                ["<s:property value="CCT"/>", <s:property value="TOTAL_CCT"/>, "purple"],
        </s:iterator>



            ]);

            var view = new google.visualization.DataView(data);
            view.setColumns([0, 1,
                {calc: "stringify",
                    sourceColumn: 1,
                    type: "string",
                    role: "annotation"},
                2]);
            var view = new google.visualization.DataView(data);
            view.setColumns([0, 1,
                {calc: "stringify",
                    sourceColumn: 1,
                    type: "string",
                    role: "annotation"},
                2]);

            var options = {

                backgroundColor: '#edecec',
                chartArea: {width: '90%'},

                bar: {groupWidth: "85%"},
                legend: {position: "none"},
            };
            var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
            chart.draw(view, options);
        }
    </script>

    <script type="text/javascript">



        google.charts.load('current', {packages: ['corechart', 'bar']});
        google.charts.setOnLoadCallback(drawBarColors);

        function drawBarColors() {
            var data = google.visualization.arrayToDataTable([
                ['City', 'DUAL', {role: 'annotation'}],

                ['Hombre', <s:property value="datos.TOTAL_HOMBRE" />, '<s:property value="datos.TOTAL_HOMBRE" />'],
                ['Mujer', <s:property value="datos.TOTAL_MUJER" />, '<s:property value="datos.TOTAL_MUJER" />'],
            ]);

            var options = {

                chartArea: {width: '50%'},
                colors: ['#b0120a', '#ffab91'],
                hAxis: {
                    title: 'Total de Alumnos',
                    minValue: 0,
                    textStyle: {
                        fontSize: 10,
                    }

                },
                backgroundColor: '#edecec',
                bar: {groupWidth: "85%"},
                vAxis: {
                    title: 'Alumnos DUAL'
                },

            };
            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }



    </script>



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



    <html lang="en">

        <head>

            <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="">
                        <meta name="author" content="">
                            <link rel="shortcut icon" href="images/portalSE.png" />
                            <title>SisDUAL</title>



                            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

                            <!-- Custom fonts for this template -->
                            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
                            <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
                            <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"/>

                            <!-- Plugin CSS -->
                            <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css"/>

                            <!-- Custom styles for this template -->
                            <link href="css/freelancer.min.css" rel="stylesheet"/>


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

                                function imprSelec(wrapper2) {
                                    var ficha = document.getElementById(wrapper2);
                                    var ventimp = window.open('printableArea');
                                    ventimp.document.write(ficha.innerHTML);
                                    ventimp.document.close();
                                    ventimp.print();
                                    ventimp.close();



                                }




                            </script>


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
                                    <header class="masthead text-white text-center" style="background:  linear-gradient(to bottom, rgba(73,155,234,1) 0%, rgba(11,82,158,1) 83%, rgba(11,82,158,1) 100%); " >

                                        <div class="container"  style="margin-top: -50px;" >
                                            <div class="modal-content" style="border-radius: 10px;">
                                                <div class="modal-header bg-secondary col-lg-12">
                                                    <h5 align="center"  style="color: #ffffff"> <i class="fas fa-book"></i> TABLERO DE CONTROL DE LA <s:property value="usuariocons.getNAMEUSUARIO()"/></h5> 
                                                    <br/>
                                                </div>  
                                                <div class="modal-body">                                              
                                                    <div class="row">


                                                        <div class="form-group col-lg-6"  >

                                                            <s:textfield name="datos.FECHA_INICIO" id="Fecha"  placeholder="Fecha de Inicial" required="true" readonly="true" cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();" cssStyle="margin-left:5px;  width:95%; text-align:center;" />


                                                        </div>


                                                        <div class="form-group col-lg-6"  >

                                                            <s:textfield name="datos.FECHA_TERMINO" id="Fecha1"  placeholder="Fecha de Inicial" required="true" readonly="true" cssClass="campoFormBusqueda" onKeyUp="this.value=this.value.toUpperCase();" cssStyle="margin-left:5px;  width:95%;  text-align:center;" />


                                                        </div>




                                                    </div>   


                                                    <a href="Javascript:Accion('consultaDashboardU')" ><div style="width: 80%; max-width: 250px;  height: 35px; background: #072146; margin: auto; margin-top: 20px; color: white; border-radius: 10px; text-align: center; padding: 5px;">Generar</div></a>
                                                    <s:if test="bantablero">

                                                        <div style="position: absolute; color: white; float: left; width: 150px; height: 40px; background: #633974; margin-top: -15px; border-radius: 20px 20px 0px 0px; padding: 8px; box-shadow: 3px 3px 10px #666; z-index: 1; font-size: 12px;">
                                                            Alumnos DUAL: <s:property value="datos.ALUMNOS_NUEVO_INGRESO"/>                                                          
                                                        </div>
                                                        <div id="wrapper2">         

                                                            <div class="row">


                                                                <div class="form-group col-lg-6"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Total de Alumnos en DUAL</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
                                                                        <table style="width: 98%; text-align: center;  ">
                                                                            <tr style="background: #edecec;">

                                                                                <td style="width: 40%;" ><div style="width: 90%; height: 140px; background: #a2a3b8; color: white; margin: auto; border-radius: 10px; margin-top: 35px; margin-bottom: 25px; box-shadow: 5px 5px 10px #666; "><h1 style="padding: 40px; font-size: 50px;"><s:property value="datos.TOTAL_ALU_DUAL"/></h1></div></td>
                                                                                <td style="width: 60%;">
                                                                                    <a href="#popup" style="text-decoration: none;" > 
                                                                                        <div style="width: 43%; height: 65px; background: #145a32 ; display: inline-block; margin: auto;  margin-top: 5px; border-radius: 10px; box-shadow: 5px 5px 10px #666;">
                                                                                            <div style="width: 100%; color: white ; margin-top: 10px; display: block;">Activos</div> 
                                                                                            <div style="width: 100%; color: white ; margin-top: 0px; display: block;">
                                                                                                <h3><s:property value="datos.TOTAL_ALU_ACTIVO"/></h3>
                                                                                                <i class="material-icons" style="float: right; margin-top: -45px; margin-right: 15px; font-size: 25px; color: white;"></i> 
                                                                                            </div>
                                                                                        </div> 
                                                                                    </a>

                                                                                    <a href="#popup2" style="text-decoration: none;" >  
                                                                                        <div style="width: 43%; height: 65px; background: #ce0039; display: inline-block;  margin: auto; margin-top: 10px; border-radius: 10px; box-shadow: 5px 5px 10px #666;">
                                                                                            <div style="width: 100%; color: white ; margin-top: 10px; display: block;">Inactivos</div> 
                                                                                            <div style="width: 100%; color: white ; margin-top: 0px; display: block;">
                                                                                                <h3><s:property value="datos.TOTAL_ALU_INACTIVO"/></h3>
                                                                                            </div>
                                                                                        </div>
                                                                                    </a>

                                                                                    


                                                                                    <div style="width: 90%; height: 65px; background: #3366CC; display: inline-block; margin: auto;  margin-top: 5px; border-radius: 10px; box-shadow: 5px 5px 10px #666;">
                                                                                        <div style="width: 100%; color: white ; margin-top: 10px; display: block; ">Activos por proyecto</div> 
                                                                                        <div style="width: 100%; color: white ; margin-top: 0px; display: block;">
                                                                                            <h3><s:property value="datos.ALUMNOS_ACTIVOS_PERIODO"/></h3>
                                                                                            <i class="material-icons" style="float: right; margin-top: -45px; margin-right: 15px; font-size: 25px; color: white;"></i> 
                                                                                        </div>
                                                                                    </div> 

                                                                                </td>
                                                                            </tr>
                                                                            <tr style="">

                                                                                <td style="width: 50%;" colspan="2" ><h4 style="color:#666;">Alumnos DUAL</h4></td>

                                                                            </tr>

                                                                        </table>
                                                                    </div> 

                                                                </div>  

                                                                <div class="form-group col-lg-6"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Estatus de Alumnos en el periodo</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">


                                                                        <div id="piechart" style="width: 100%; height: 240px; margin: auto; margin-top: 0px;"></div>

                                                                    </div> 

                                                                </div>  


                                                                <div class="form-group col-lg-12"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Total de Proyectos Asignados por Asesor   </div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
                                                                        <s:if test="ListaTotalEsuelaU.size()>0">
                                                                            <div id="columnchart_values" style="width: 100%; height: 300px;"></div>
                                                                        </s:if>
                                                                        <s:else>
                                                                            <div  style="width: 100%; height: 300px; color: red; font-size: 22px;">Sin información</div>
                                                                        </s:else>
                                                                    </div> 

                                                                </div>  



                                                                <div class="form-group col-lg-12"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Número de Alumnos por Género</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">

                                                                        <div id="chart_div" style="margin-bottom: 50px; height: 250px;"></div>





                                                                    </div> 

                                                                </div>  




                                                                <div style="margin: auto; width: 120px; background: green; color: white; text-align: center; margin-bottom: 20px; border-radius: 20px;"><a href="javascript:imprSelec('wrapper2')" style="text-decoration: none; color: white; text-align: center;">Imprimir</a></div>



                                                            </div> 





                                                        </div> 



                                                    </s:if>


                                                </div>
                                            </div>                                                                   
                                        </div>            

                                    </header>


                                    <div class="modal-wrapper" id="popup">
                                        <div class="popup-contenedor">
                                            <h2  >Alumos Activos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >
                                                <div id="dvData">

                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardU.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: green; color: white;" >Alumnos Activos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardU" id="ListaAlumnosDashboardU" status="stat">

                                                                    <s:if test="STATUS==1">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            <td style="width: 10%;"><s:property value="CURP"/></td>
                                                                            <td style="width: 50%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                            <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                            <td style="width: 10%;"><s:property value="SEXO" /></td>

                                                                            <td style="width: 20%;" align="center"><s:property value="CLAVECARRERA" /></td>

                                                                        </tr>

                                                                    </s:if>
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>


                                                    <s:if test="ListaAlumnosDashboardU.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup-cerrar" href="#">X</a>
                                        </div>
                                    </div>





                                    <div class="modal-wrapper" id="popup2">
                                        <div class="popup2-contenedor">
                                            <h2 style="color: red;" >Alumnos inactivos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData2">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardU.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: red; color: white;" >Alumnos Inactivos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardU" id="ListaAlumnosDashboardU" status="stat">

                                                                    <s:if test="STATUS!=1">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            <td style="width: 10%;"><s:property value="CURP"/></td>
                                                                            <td style="width: 50%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                            <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                            <td style="width: 10%;"><s:property value="SEXO" /></td>

                                                                            <td style="width: 20%;" align="center"><s:property value="CLAVECARRERA" /></td>

                                                                        </tr>

                                                                    </s:if>
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosDashboardU.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport2"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport2").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData2').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup2-cerrar" href="#">X</a>
                                        </div>
                                    </div>                                          




                                    <!-- Actualiza Modal-->


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






                                    <link href=" <s:url value="/css/CssExtras.css"/>" media="all" rel="stylesheet" type="text/css"/>                         

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
                                                            $('#editUsu').on('show.bs.modal', function (event) {
                                                                var button = $(event.relatedTarget) // Button that triggered the modal






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
                                                                var recipient13 = button.data('grado')
                                                                var recipient14 = button.data('promedio')
                                                                var recipient15 = button.data('situacion')
                                                                var recipient16 = button.data('tipo_alu')
                                                                var recipient17 = button.data('municipio')


                                                                // Extract info from data-* attributes
                                                                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                                                                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.

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





                                                            });

                                    </script>

                                </s:form>

                            </body>

                            </html>
