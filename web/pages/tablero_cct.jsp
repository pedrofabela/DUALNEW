<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="css/estilo.css"/>



    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    
    
     <script type="text/javascript"  charset="UTF-8">

            //GRAFICA REGION
            // Load the Visualization API and the piechart package.

            google.load('visualization', '1.0', {'packages': ['corechart']});
            // Set a callback to run when the Google Visualization API is loaded.
            google.setOnLoadCallback(drawChart);
            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {
                // Create the data table.
                var data = google.visualization.arrayToDataTable([
                    ['Genre', 'Alumnos Nuevos', 'Alumnos por inscribir', {role: 'annotation'} ],

    <s:iterator value="ListaAvanceMetas" id=" ListaAvanceMetas" status="stat">
                    ['<s:property value="ABRE_INST"/>', <s:property value="ALU_NUEVOS"/>, <s:property value="FALTANTES"/>, <s:property value="META"/> ],

    </s:iterator>

                ]);

                // Set chart options 

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.ColumnChart(document.getElementById('chart_div2'));
                function selectHandler() {
                    var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                        var topping = data.getValue(selectedItem.row, 0);
                        window.location.assign(rutaGraficasOk + 'TipoD?topping=' + topping + '');
                    }
                }

                var options = {

                    legend: {position: 'top', maxLines: 3, legend: 'left'},
                    bar: {groupWidth: '95%'},

                    titleTextStyle: {
                        color: '#A4A4A4',
                        fontSize: 16,
                        fontName: 'Arial',

                    },

                    colors: ['#276c59', '#58bca6'],

                    animation: {
                        duration: 2500,
                        startup: true //This is the new option
                    },
                    bar: {groupWidth: '95%'},
                    isStacked: true,

                    textStyle: {
                        color: '#1b9e77',
                        fontSize: 20,
                        fontName: 'Arial',

                        italic: true
                    },
                    annotations: {
                        textStyle: {

                            fontSize: 13,

                            // The color of the text.
                            color: '#848484'
                                    // The color of the text outline.

                                    // The transparency of the text.

                        }
                    }




                };
                google.visualization.events.addListener(chart, 'select', selectHandler);
                chart.draw(data, options);
            }


</script>


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
            var counter = 0;

            var handler = setInterval(function () {
                counter = counter + 0.01
                options = {

                    slices: {
                        3: {offset: counter},
                        4: {offset: counter},
                        5: {offset: counter},

                    },

                    backgroundColor: '#e7e6e6',
                    chartArea: {left: 20, top: 25, width: '85%', height: '80%'},
                    legend: {position: 'left', top: 20, width: '45%', textStyle: {fontSize: 13, color: 'black', fontName: 'Didactic'}},

                    colors: ['green', '#25a1db', '#9dc325', '#fcce00', '#a29f9d', '#e1173e'],

                    textStyle: {

                        fontSize: 16,

                        // The color of the text.
                        color: '#848484'
                                // The color of the text outline.

                                // The transparency of the text.

                    },

                };
                chart.draw(data, options);

                if (counter > 0.20)
                    clearInterval(handler);
            }, 200);
        }
    </script>    

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
        <s:iterator value="ListaTotalEstatusUGeneral" id="ListaTotalEstatusUGeneral" status="stat">

                ['<s:property value="NOM_ESTATUS"/>', <s:property value="TOTAL_ESTATUS"/>],

        </s:iterator>

            ]);

            var options = {

                backgroundColor: '#edecec',

            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart_general'));

            chart.draw(data, options);

            var counter = 0;

            var handler = setInterval(function () {
                counter = counter + 0.01
                options = {

                    slices: {
                        3: {offset: counter},
                        4: {offset: counter},
                        5: {offset: counter},

                    },

                    backgroundColor: '#e7e6e6',
                    chartArea: {left: 20, top: 25, width: '85%', height: '80%'},
                    legend: {position: 'left', top: 20, width: '45%', textStyle: {fontSize: 13, color: 'black', fontName: 'Didactic'}},

                    colors: ['green', '#25a1db', '#9dc325', '#fcce00', '#a29f9d', '#e1173e'],

                    textStyle: {

                        fontSize: 16,

                        // The color of the text.
                        color: '#848484'
                                // The color of the text outline.

                                // The transparency of the text.

                    },

                };
                chart.draw(data, options);

                if (counter > 0.20)
                    clearInterval(handler);
            }, 200);
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
                animation: {
                    duration: 4500,
                    startup: true //This is the new option
                },
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
                ['City', 'DUAL', {role: 'annotation'}, {role: 'style'}],

                ['Hombre', <s:property value="datos.TOTAL_HOMBRE" />, '<s:property value="datos.TOTAL_HOMBRE" />', 'blue'],
                ['Mujer', <s:property value="datos.TOTAL_MUJER" />, '<s:property value="datos.TOTAL_MUJER" />', 'pink'],
            ]);

            var options = {

                chartArea: {width: '50%'},

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
                animation: {
                    duration: 4500,
                    startup: true //This is the new option
                },

            };
            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }



    </script>


    <script type="text/javascript">



        google.charts.load('current', {packages: ['corechart', 'bar']});
        google.charts.setOnLoadCallback(drawBarColors);

        function drawBarColors() {
            var data = google.visualization.arrayToDataTable([
                ['City', 'DUAL', {role: 'annotation'}, {role: 'style'}],

                ['Hombre', <s:property value="datos.TOTAL_HOMBRE_GENERAL" />, '<s:property value="datos.TOTAL_HOMBRE_GENERAL" />', 'blue'],
                ['Mujer', <s:property value="datos.TOTAL_MUJER_GENERAL" />, '<s:property value="datos.TOTAL_MUJER_GENERAL" />', 'pink'],
            ]);

            var options = {

                chartArea: {width: '50%'},
                colors: ['#ffab91', '#ffab91'],
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
                animation: {
                    duration: 4500,
                    startup: true //This is the new option
                },

            };
            var chart = new google.visualization.BarChart(document.getElementById('chart_div_gen'));
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

                            <body id="page-top" >
                                
                                <s:form name="formularioPrincipal" id="formularioPrincipal" enctype="multipart/form-data">

                                    <!-- Navigation -->
                                    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav" style="height: 60px;">
                                        <div class="container">
                                            <img class="img-fluid mb-2 d-block mx-auto" src="images/logos-10.png" alt="" style="width: 25%;"/>   
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
                                    <header class="masthead text-white text-center"   >

                                        <div class="container"  style="margin-top: -100px; box-shadow: 5px 5px 10px #333;" >
                                            <div class="modal-content" style="border-radius: 10px;">
                                                <div class="modal-header bg-secondary col-lg-12">
                                                    <h5 align="center"  style="color: #ffffff"> <s:property value="usuariocons.getNAMEUSUARIO()"/></h5> 
                                                    <br/>
                                                </div>      
                                                <div class="modal-body">                                              






                                                    <div id="wrapper2"> 

                                                        <div style="width: 100%; height: 40px;  background: #343a40; margin-bottom: 15px; padding: 7px; ">Indicadores Generales</div>

                                                        <div class="row" style="margin-bottom: 30px;">


                                                            <div class="form-group col-lg-4" style="padding: none;"  >

                                                                <div style="background: #a2a3b8; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Total de Alumnos 

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.TOTAL_ALUMNOS_DUAL"/> <i class="fas fa-fw fa-wrench" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <a href="#popup5" style="text-decoration: none; color:white;" >    <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            Detalle de Alumnos        ->

                                                                        </div></a>


                                                                </div>


                                                            </div>           



                                                            <div class="form-group col-lg-2" style="padding: none;"  >

                                                                <div style="background: #28a745; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Activos 

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.ALUMNOS_ACTIVOS_GENERAL"/> <i class="fas fa-fw fa-user" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <a href="#popup6" style="text-decoration: none; color:white;" >      <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            Detalle de Alumnos        ->

                                                                        </div></a>


                                                                </div>


                                                            </div>  



                                                            <div class="form-group col-lg-2" style="padding: none;"  >

                                                                <div style="background: #dc3545; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Inactivos 

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.ALUMNOS_INACTIVOS_GENERAL"/> <i class="fas fa-fw fa-thumbs-down" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div> 
                                                                    <a href="#popup2" style="text-decoration: none; color: white;" > <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            Detalle de Alumnos        ->

                                                                        </div>
                                                                    </a>


                                                                </div>


                                                            </div>  






                                                            <div class="form-group col-lg-2" style="padding: none;"  >

                                                                <div style="background: #ffc107; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Egresados

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.ALUMNOS_EGRESADOS_GENERAL"/> <i class="fas fa-fw fa-graduation-cap" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <a href="#popup3" style="text-decoration: none; color: white;" >    <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            Detalle de Alumnos        ->

                                                                        </div>
                                                                    </a>


                                                                </div>


                                                            </div>     

                                                            <div class="form-group col-lg-2" style="padding: none;"  >

                                                                <div style="background: #008080; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Con Beca

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.TOTAL_BECA_GENERAL"/> <i class="fas fa-fw fa-graduation-cap" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <a href="#popup4" style="text-decoration: none; color: white;" >    <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            Detalle de Alumnos        ->

                                                                        </div>
                                                                    </a>


                                                                </div>


                                                            </div>        



                                                            <div class="form-group col-lg-6" >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Alumnos por género</div>

                                                                <div id="chart_div_gen" style="margin-bottom: 10px; height: 240px;"></div>

                                                            </div>    

                                                            <div class="form-group col-lg-6"  >


                                                                <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; "> Por estatus</div>
                                                                <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">


                                                                    <div id="piechart_general" style="width: 100%; height: 240px; margin: auto; margin-top: 0px;"></div>

                                                                </div> 

                                                            </div>  

                                                             <div class="form-group col-lg-6" >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Alumnos por Municipio</div>

                                                                <div style="height: 250px; overflow-y: scroll">
                                                                  
                                                                       <div id="dvData9">    
                                                                    
                                                                    <table class="table table-hover"  style=" font-size: 14px; width: 100%;">



                                                                        <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999; background: purple; color:white;">
                                                                            <td  scope="row" style="width: 40%;">Municipio</td>
                                                                            <td style="width: 20%;">Activos</td>
                                                                            <td style="width: 20%;">Inactivos</td>
                                                                            <td style="width: 20%;">Egresados</td>




                                                                        </tr>

                                                                        <s:iterator value="ListaMunicipioEscuela" id="ListaMunicipioEscuela" status="stat">



                                                                            <tr style=" background: #efeaf0; font-size: 12px; color: #333;">
                                                                                <td style="width: 40%;"><s:property value="NOMESC"/></td>
                                                                                <td style="width: 20%;"><s:property value="MUNICIPIO_ACTIVOS"/></td>
                                                                                <td style="width: 20%;"><s:property value="MUNICIPIO_INACTIVOS"/></td>
                                                                                <td style="width: 20%;"><s:property value="MUNICIPIO_EGRESADOS" /></td>



                                                                            </tr>


                                                                        </s:iterator>


                                                                        <s:if test="ListaMunicipioEscuela.size()<=0">

                                                                            <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                                        </s:if>
                                                                    </table>
                                                                           
                                                                           
                                                                            <center>

                                                            <input  align="top" type="image" id="btnExport8"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport8").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData9').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>
                                                                           
                                                                           
                                                                           
                                                                           
                                                                           
                                                                       </div>

                                                                </div> 



                                                            </div>    
                                                                        
                                                           
                                                                        
                                                                        
                                                            <div class="form-group col-lg-6" >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Alumnos por Carrera</div>

                                                                <div style="height: 250px; overflow-y: scroll">
                                                                  
                                                                       <div id="dvData8">    
                                                                    
                                                                    <table class="table table-hover"  style=" font-size: 14px; width: 100%;">



                                                                        <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999; background: #dc3545; color:white;">
                                                                            <td  scope="row" style="width: 20%;">Clave</td>
                                                                            <td style="width: 40%;">Carrera</td>
                                                                             <td style="width: 20%;">Activos</td>
                                                                            <td style="width: 20%;">Inactivos</td>
                                                                            <td style="width: 20%;">Egresados</td>




                                                                        </tr>

                                                                        <s:iterator value="ListaCarreraAlumnos" id="ListaCarreraAlumnos" status="stat">



                                                                            <tr style=" background: #efeaf0; font-size: 12px; color: #333;">
                                                                                <td style="width: 20%;"><s:property value="CLAVECARRERA"/></td>
                                                                                <td style="width: 40%;"><s:property value="NOMBRE_CARRERA"/></td>
                                                                                 <td style="width: 20%;"><s:property value="ALUMNOS_ACTIVOS_GENERAL"/></td>
                                                                                <td style="width: 20%;"><s:property value="ALUMNOS_INACTIVOS_GENERAL"/></td>
                                                                                <td style="width: 20%;"><s:property value="ALUMNOS_EGRESADOS_GENERAL" /></td>



                                                                            </tr>


                                                                        </s:iterator>


                                                                        <s:if test="ListaMunicipioEscuela.size()<=0">

                                                                            <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                                        </s:if>
                                                                    </table>
                                                                           
                                                                           
                                                                            <center>

                                                            <input  align="top" type="image" id="btnExport9"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport9").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData8').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>
                                                                           
                                                                           
                                                                           
                                                                           
                                                                           
                                                                       </div>

                                                                </div> 



                                                            </div>               
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        

                                                            <div class="form-group col-lg-6" >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Alumnos activos por empresa</div>

                                                                <div style="height: 250px; overflow-y: scroll">
                                                                  
                                                                  <div id="dvData7">    
                                                                    
                                                                    
                                                                    <table class="table table-hover"   style=" font-size: 14px; width: 100%;">



                                                                        <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999; background: #10707f; color:white;">
                                                                            <td  scope="row" style="width: 20%;">RFC</td>
                                                                            <td style="width: 40%;">Empresa</td>
                                                                            <td style="width: 20%;">Municipio</td>
                                                                            <td style="width: 20%;">No.Alumnos</td>
                                                                              <td style="width: 20%;">Giro</td>
                                                                                <td style="width: 20%;">Sector</td>
                                                                                 <td style="width: 20%;">CCT</td>





                                                                        </tr>

                                                                        <s:iterator value="ListaEmpresasAlumnos" id="ListaEmpresasAlumnos" status="stat">



                                                                            <tr style=" background: #efeaf0; font-size: 12px; color: #333;">
                                                                                <td style="width: 20%;"><s:property value="RFC"/></td>
                                                                                <td style="width: 40%;"><s:property value="RAZON_SOCIAL"/></td>
                                                                                <td style="width: 20%;"><s:property value="NOM_MUN"/></td>
                                                                                <td style="width: 20%;"><s:property value="TOTAL_ALUMNOS_EMPRESA" /></td>
                                                                                <td style="width: 20%;"><s:property value="GIRO" /></td>
                                                                                <td style="width: 20%;"><s:property value="SECTOR" /></td>
                                                                                  <td style="width: 20%;"><s:property value="CCT" /></td>


                                                                            </tr>


                                                                        </s:iterator>


                                                                        <s:if test="ListaEmpresasAlumnos.size()<=0">

                                                                            <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                                        </s:if>
                                                                    </table>
                                                                      
                                                                       <center>

                                                            <input  align="top" type="image" id="btnExport2"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport2").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData7').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>
                                                                      
                                                                      
                                                                  </div>

                                                                </div> 




                                                            </div>


                                                                 
                                                                        
                                                                        
                                                                        
                                                                        
                                                            <div class="form-group col-lg-6" >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Avance de Metas Globales ó Individuales </div>

                                                               
                                                                 <div id="chart_div2" style="margin: auto; width: 100%; height: 280px; margin-bottom: 20px;" ></div>



                                                            </div>





                                                        <div style="width: 100%; height: 40px;  background: #4885Ed; margin-bottom: 15px; padding: 7px; ">Indicadores por Periodo</div>


                                                        <div class="row" style="margin-bottom: 30px;">


                                                            <div class="form-group col-lg-4" style="background: #343a40; padding: 10px; height: 60px;"  >

                                                                <s:textfield name="datos.FECHA_INICIO" id="Fecha"  placeholder="Fecha de Inicial"  cssClass="form-control"   />


                                                            </div>


                                                            <div class="form-group col-lg-4"  style="background: #343a40; padding: 10px; height: 60px;" >

                                                                <s:textfield name="datos.FECHA_TERMINO" id="Fecha1"  placeholder="Fecha de Termmino"   cssClass="form-control"   />


                                                            </div>

                                                            <div class="form-group col-lg-4" style="background: #343a40; padding: 10px; height: 60px;" >                                                 
                                                                <a href="Javascript:Accion('consultaDashboardU')" ><div style="width: 80%; max-width: 250px;  height: 35px; background: #0065d2; margin: auto; margin-top: 2px; color: white; border-radius: 10px; text-align: center; padding: 5px; text-decoration: none;">Generar</div></a>

                                                            </div>        









                                                            <!-- indicadores de colores -->   

                                                           <div class="form-group col-lg-3" style="padding: none;"  >

                                                                <div style="background: #007bff; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Nuevos Ingresos

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="ListaAlumnosNuevos.size()"/> <i class="fas fa-fw fa-wrench" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                   <a href="#popup10" style="text-decoration: none; color:white;" >  <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                        Detalle de Alumnos    

                                                                       </div></a>


                                                                </div>


                                                            </div>      


                                                            <div class="form-group col-lg-3" style="padding: none;"  >

                                                                <div style="background: #A5DF00; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Reingresos

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="ListaAlumnosReingresos.size()"/> <i class="fas fa-fw fa-thumbs-down" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div> 
                                                                    <a href="#popup11" style="text-decoration: none; color: white;" > <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                             Detalle de Alumnos       

                                                                        </div>
                                                                    </a>


                                                                </div>


                                                            </div>                



                                                            <div class="form-group col-lg-3" style="padding: none;"  >

                                                                <div style="background: purple; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Proyectos Registrados

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.TOTAL_PROYECTOS"/> <i class="fas fa-fw fa-user" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <a href="#" style="text-decoration: none; color:white;" >      <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            <!-- Detalle de Alumnos        -->

                                                                        </div></a>


                                                                </div>


                                                            </div>  









                                                            <div class="form-group col-lg-3" style="padding: none;"  >

                                                                <div style="background: #008080; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Becas Registradas

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.TOTAL_BECAS"/> <i class="fas fa-fw fa-graduation-cap" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <a href="#" style="text-decoration: none; color: white;" >    <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            <!-- Detalle de Alumnos        -->

                                                                        </div>
                                                                    </a>


                                                                </div>


                                                            </div>          



















                                                            <!--     <div class="form-group col-lg-6" >
 
 
                                                                     <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Alumnos por género del periodo</div>
                                                                    
                                                                    <div id="chart_div" style="margin-bottom: 10px; height: 240px;"></div>
 
                                                                 </div>  
 
                                                                 <div class="form-group col-lg-6"  >
 
 
                                                                     <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Estatus de Alumnos en el periodo</div>
                                                                     <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
 
 
                                                                         <div id="piechart" style="width: 100%; height: 240px; margin: auto; margin-top: 0px;"></div>
 
                                                                     </div> 
 
                                                                 </div>  -->


                                                            <div class="form-group col-lg-12"  >


                                                                <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Total de Proyectos Asignados por Asesor del periodo  </div>
                                                                <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
                                                                    <s:if test="ListaTotalEsuelaU.size()>0">
                                                                        <div id="columnchart_values" style="width: 100%; height: 300px;"></div>
                                                                    </s:if>
                                                                    <s:else>
                                                                        <div  style="width: 100%; height: 300px; color: red; font-size: 22px;">Sin información</div>
                                                                    </s:else>
                                                                </div> 

                                                            </div>  







                                                            <div style="margin: auto; width: 120px; background: green; color: white; text-align: center; margin-bottom: 20px; border-radius: 20px;"><a href="javascript:imprSelec('wrapper2')" style="text-decoration: none; color: white; text-align: center;">Imprimir</a></div>



                                                        </div> 





                                                    </div> 






                                                </div>
                                            </div>                                                                   
                                        </div>            

                                    </header>


                                    <div class="modal-wrapper" id="popup">
                                        <div class="popup-contenedor">
                                            <h2  >Alumnos Activos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >
                                                <div id="dvData21">

                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardU.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="28" align="center" style="background: green; color: white;" >Alumnos Activos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave carrera</td>
                                                                    <td style="width: 10%;">Nombre carrera</td>

                                                                    <td style="width: 10%;">Género</td>
                                                                     <td style="width: 10%;">Fecha nacimineto</td>
                                                                    <td style="width: 10%;">Domicilio</td>
                                                                    
                                                                    <td style="width: 10%;">Colonia</td>
                                                                    <td style="width: 10%;">Teléfono</td>  
                                                                    <td style="width: 10%;">CP</td>
                                                                    <td style="width: 10%;">Correo</td>

                                                                    <td style="width: 10%;">Grado</td>
                                                                     <td style="width: 10%;">Promedio</td>
                                                                    <td style="width: 10%;">Situación académica</td>
                                                                    
                                                                    <td style="width: 10%;">Tipo Alumno</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 10%;">CCT</td>

                                                                    <td style="width: 10%;">Escuela</td>
                                                                     <td style="width: 10%;">Municipio</td>
                                                                     
                                                                 
                                                                    
                                                                    <td style="width: 10%;">Fecha registro</td>
                                                                    
                                                                    <td style="width: 10%;">Beca</td>
                                                                    <td style="width: 10%;">Fecha ingreso DUAL</td>

                                                                    <td style="width: 10%;">Fecha Reingreso</td>
                                                                      <td style="width: 10%;">Fecha Egreso</td>
                                                                      <td style="width: 10%;">Fecha cambio estatus</td>
                                                                      <td style="width: 10%;">Estatus General</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardU" id="ListaAlumnosDashboardU" status="stat">

                                                                    <s:if test="STATUS==1">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                        <td style="width: 50%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CVE_CAARRERA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="NOMBRE_CARRERA" /></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECNAC"/></td>
                                                                        <td style="width: 10%;"><s:property value="DOMICILIOA"/></td>
                                                                        <td style="width: 10%;"><s:property value="COLONIA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="TELEFONO" /></td>
                                                                         <td style="width: 10%;"><s:property value="CP" /></td>
                                                                         <td style="width: 10%;"><s:property value="CORREO" /></td>
                                                                        
                                                                        <td style="width: 10%;"><s:property value="GRADO"/></td>
                                                                        <td style="width: 10%;"><s:property value="PROMEDIOGRAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>
                                                                        <td style="width: 10%;"><s:property value="TIPO_ALUMNO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="STATUS" /></td>
                                                                         <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMESC"/></td>
                                                                        <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                       

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_REG" /></td>
                                                                        <td style="width: 10%;"><s:property value="BECA"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_REINGRESO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_EGRESO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_CAMBIO_ESTATUS" /></td>
                                                                        <td style="width: 10%;"><s:property value="ESTATUS_GENERAL"/></td>

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

                                                            <input  align="top" type="image" id="btnExport21"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport21").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData21').html()));
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


                                                <div id="dvData22">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="28" align="center" style="background: red; color: white;" >Alumnos Inactivos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                     <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave carrera</td>
                                                                    <td style="width: 10%;">Nombre carrera</td>

                                                                    <td style="width: 10%;">Género</td>
                                                                     <td style="width: 10%;">Fecha nacimineto</td>
                                                                    <td style="width: 10%;">Domicilio</td>
                                                                    
                                                                    <td style="width: 10%;">Colonia</td>
                                                                    <td style="width: 10%;">Teléfono</td>  
                                                                    <td style="width: 10%;">CP</td>
                                                                    <td style="width: 10%;">Correo</td>

                                                                    <td style="width: 10%;">Grado</td>
                                                                     <td style="width: 10%;">Promedio</td>
                                                                    <td style="width: 10%;">Situación académica</td>
                                                                    
                                                                    <td style="width: 10%;">Tipo Alumno</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 10%;">CCT</td>

                                                                    <td style="width: 10%;">Escuela</td>
                                                                     <td style="width: 10%;">Municipio</td>
                                                                     
                                                                 
                                                                    
                                                                    <td style="width: 10%;">Fecha registro</td>
                                                                    
                                                                    <td style="width: 10%;">Beca</td>
                                                                    <td style="width: 10%;">Fecha ingreso DUAL</td>

                                                                    <td style="width: 10%;">Fecha Reingreso</td>
                                                                      <td style="width: 10%;">Fecha Egreso</td>
                                                                      <td style="width: 10%;">Fecha cambio estatus</td>
                                                                      <td style="width: 10%;">Estatus General</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="STATUS!=1 && STATUS!=10">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                        <td style="width: 50%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CVE_CAARRERA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="NOMBRE_CARRERA" /></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECNAC"/></td>
                                                                        <td style="width: 10%;"><s:property value="DOMICILIOA"/></td>
                                                                        <td style="width: 10%;"><s:property value="COLONIA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="TELEFONO" /></td>
                                                                         <td style="width: 10%;"><s:property value="CP" /></td>
                                                                         <td style="width: 10%;"><s:property value="CORREO" /></td>
                                                                        
                                                                        <td style="width: 10%;"><s:property value="GRADO"/></td>
                                                                        <td style="width: 10%;"><s:property value="PROMEDIOGRAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>
                                                                        <td style="width: 10%;"><s:property value="TIPO_ALUMNO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="STATUS" /></td>
                                                                         <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMESC"/></td>
                                                                        <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                       

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_REG" /></td>
                                                                        <td style="width: 10%;"><s:property value="BECA"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_REINGRESO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_EGRESO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_CAMBIO_ESTATUS" /></td>
                                                                        <td style="width: 10%;"><s:property value="ESTATUS_GENERAL"/></td>

                                                                        </tr>

                                                                    </s:if>
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport22"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport22").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData22').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup2-cerrar" href="#">X</a>
                                        </div>
                                    </div>                                          




                                    <!-- TOTAL DE ALUMNOS DUAL -->    

                                    <div class="modal-wrapper" id="popup3">
                                        <div class="popup3-contenedor">
                                            <h2 style="color: #ffc107;" >Alumnos Egresados</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData23">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="28" align="center" style="background: #ffc107; color: white;" >Alumnos Egresados</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave carrera</td>
                                                                    <td style="width: 10%;">Nombre carrera</td>

                                                                    <td style="width: 10%;">Género</td>
                                                                     <td style="width: 10%;">Fecha nacimineto</td>
                                                                    <td style="width: 10%;">Domicilio</td>
                                                                    
                                                                    <td style="width: 10%;">Colonia</td>
                                                                    <td style="width: 10%;">Teléfono</td>  
                                                                    <td style="width: 10%;">CP</td>
                                                                    <td style="width: 10%;">Correo</td>

                                                                    <td style="width: 10%;">Grado</td>
                                                                     <td style="width: 10%;">Promedio</td>
                                                                    <td style="width: 10%;">Situación académica</td>
                                                                    
                                                                    <td style="width: 10%;">Tipo Alumno</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 10%;">CCT</td>

                                                                    <td style="width: 10%;">Escuela</td>
                                                                     <td style="width: 10%;">Municipio</td>
                                                                     
                                                                 
                                                                    
                                                                    <td style="width: 10%;">Fecha registro</td>
                                                                    
                                                                    <td style="width: 10%;">Beca</td>
                                                                    <td style="width: 10%;">Fecha ingreso DUAL</td>

                                                                    <td style="width: 10%;">Fecha Reingreso</td>
                                                                      <td style="width: 10%;">Fecha Egreso</td>
                                                                      <td style="width: 10%;">Fecha cambio estatus</td>
                                                                      <td style="width: 10%;">Estatus General</td>

                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="STATUS == 10">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                        <td style="width: 50%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CVE_CAARRERA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="NOMBRE_CARRERA" /></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECNAC"/></td>
                                                                        <td style="width: 10%;"><s:property value="DOMICILIOA"/></td>
                                                                        <td style="width: 10%;"><s:property value="COLONIA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="TELEFONO" /></td>
                                                                         <td style="width: 10%;"><s:property value="CP" /></td>
                                                                         <td style="width: 10%;"><s:property value="CORREO" /></td>
                                                                        
                                                                        <td style="width: 10%;"><s:property value="GRADO"/></td>
                                                                        <td style="width: 10%;"><s:property value="PROMEDIOGRAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>
                                                                        <td style="width: 10%;"><s:property value="TIPO_ALUMNO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="STATUS" /></td>
                                                                         <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMESC"/></td>
                                                                        <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                       

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_REG" /></td>
                                                                        <td style="width: 10%;"><s:property value="BECA"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_REINGRESO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_EGRESO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_CAMBIO_ESTATUS" /></td>
                                                                        <td style="width: 10%;"><s:property value="ESTATUS_GENERAL"/></td>

                                                                        </tr>

                                                                    </s:if>
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport23"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport23").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData23').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup3-cerrar" href="#">X</a>
                                        </div>
                                    </div>     



                                    <div class="modal-wrapper" id="popup4">
                                        <div class="popup4-contenedor">
                                            <h2 style="color: #008080;" >Alumnos con Beca</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData24">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="28" align="center" style="background: #008080; color: white;" >Alumnos con beca</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                   <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave carrera</td>
                                                                    <td style="width: 10%;">Nombre carrera</td>

                                                                    <td style="width: 10%;">Género</td>
                                                                     <td style="width: 10%;">Fecha nacimineto</td>
                                                                    <td style="width: 10%;">Domicilio</td>
                                                                    
                                                                    <td style="width: 10%;">Colonia</td>
                                                                    <td style="width: 10%;">Teléfono</td>  
                                                                    <td style="width: 10%;">CP</td>
                                                                    <td style="width: 10%;">Correo</td>

                                                                    <td style="width: 10%;">Grado</td>
                                                                     <td style="width: 10%;">Promedio</td>
                                                                    <td style="width: 10%;">Situación académica</td>
                                                                    
                                                                    <td style="width: 10%;">Tipo Alumno</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 10%;">CCT</td>

                                                                    <td style="width: 10%;">Escuela</td>
                                                                     <td style="width: 10%;">Municipio</td>
                                                                     
                                                                 
                                                                    
                                                                    <td style="width: 10%;">Fecha registro</td>
                                                                    
                                                                    <td style="width: 10%;">Beca</td>
                                                                    <td style="width: 10%;">Fecha ingreso DUAL</td>

                                                                    <td style="width: 10%;">Fecha Reingreso</td>
                                                                      <td style="width: 10%;">Fecha Egreso</td>
                                                                      <td style="width: 10%;">Fecha cambio estatus</td>
                                                                      <td style="width: 10%;">Estatus General</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="BECA=='si' && STATUS==1 ">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                             <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                        <td style="width: 50%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CVE_CAARRERA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="NOMBRE_CARRERA" /></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECNAC"/></td>
                                                                        <td style="width: 10%;"><s:property value="DOMICILIOA"/></td>
                                                                        <td style="width: 10%;"><s:property value="COLONIA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="TELEFONO" /></td>
                                                                         <td style="width: 10%;"><s:property value="CP" /></td>
                                                                         <td style="width: 10%;"><s:property value="CORREO" /></td>
                                                                        
                                                                        <td style="width: 10%;"><s:property value="GRADO"/></td>
                                                                        <td style="width: 10%;"><s:property value="PROMEDIOGRAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>
                                                                        <td style="width: 10%;"><s:property value="TIPO_ALUMNO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="STATUS" /></td>
                                                                         <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMESC"/></td>
                                                                        <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                       

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_REG" /></td>
                                                                        <td style="width: 10%;"><s:property value="BECA"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_REINGRESO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_EGRESO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_CAMBIO_ESTATUS" /></td>
                                                                        <td style="width: 10%;"><s:property value="ESTATUS_GENERAL"/></td>

                                                                        </tr>

                                                                    </s:if>
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport24"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport24").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData24').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup4-cerrar" href="#">X</a>
                                        </div>
                                    </div>     
















                                    <div class="modal-wrapper" id="popup5">
                                        <div class="popup5-contenedor">
                                            <h2 style="color: gray;" >Total de alumnos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow: scroll;" >


                                                <div id="dvData20">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="28" align="center" style="background: grey; color: white;" >Total de Alumnos DUAL</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    
                                                                     <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave carrera</td>
                                                                    <td style="width: 10%;">Nombre carrera</td>

                                                                    <td style="width: 10%;">Género</td>
                                                                     <td style="width: 10%;">Fecha nacimineto</td>
                                                                    <td style="width: 10%;">Domicilio</td>
                                                                    
                                                                    <td style="width: 10%;">Colonia</td>
                                                                    <td style="width: 10%;">Teléfono</td>  
                                                                    <td style="width: 10%;">CP</td>
                                                                    <td style="width: 10%;">Correo</td>

                                                                    <td style="width: 10%;">Grado</td>
                                                                     <td style="width: 10%;">Promedio</td>
                                                                    <td style="width: 10%;">Situación académica</td>
                                                                    
                                                                    <td style="width: 10%;">Tipo Alumno</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 10%;">CCT</td>

                                                                    <td style="width: 10%;">Escuela</td>
                                                                     <td style="width: 10%;">Municipio</td>
                                                                     
                                                                 
                                                                    
                                                                    <td style="width: 10%;">Fecha registro</td>
                                                                    
                                                                    <td style="width: 10%;">Beca</td>
                                                                    <td style="width: 10%;">Fecha ingreso DUAL</td>

                                                                    <td style="width: 10%;">Fecha Reingreso</td>
                                                                      <td style="width: 10%;">Fecha Egreso</td>
                                                                      <td style="width: 10%;">Fecha cambio estatus</td>
                                                                      <td style="width: 10%;">Estatus General</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">



                                                                    <tr style=" background: #efeaf0; font-size: 8px;">
                                                                       
                                                                        <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                        <td style="width: 50%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CVE_CAARRERA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="NOMBRE_CARRERA" /></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECNAC"/></td>
                                                                        <td style="width: 10%;"><s:property value="DOMICILIOA"/></td>
                                                                        <td style="width: 10%;"><s:property value="COLONIA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="TELEFONO" /></td>
                                                                         <td style="width: 10%;"><s:property value="CP" /></td>
                                                                         <td style="width: 10%;"><s:property value="CORREO" /></td>
                                                                        
                                                                        <td style="width: 10%;"><s:property value="GRADO"/></td>
                                                                        <td style="width: 10%;"><s:property value="PROMEDIOGRAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>
                                                                        <td style="width: 10%;"><s:property value="TIPO_ALUMNO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="STATUS" /></td>
                                                                         <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMESC"/></td>
                                                                        <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                       

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_REG" /></td>
                                                                        <td style="width: 10%;"><s:property value="BECA"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_REINGRESO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_EGRESO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_CAMBIO_ESTATUS" /></td>
                                                                        <td style="width: 10%;"><s:property value="ESTATUS_GENERAL"/></td>
                                                                      

                                                                    </tr>


                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport20"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport20").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData20').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup5-cerrar" href="#">X</a>
                                        </div>
                                    </div>                                          

                                    <div class="modal-wrapper" id="popup6">
                                        <div class="popup6-contenedor">
                                            <h2 style="color: green;" >Total de Alumnos activos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData25">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="28" align="center" style="background: green; color: white;" >Total de Alumnos Activos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave carrera</td>
                                                                    <td style="width: 10%;">Nombre carrera</td>

                                                                    <td style="width: 10%;">Género</td>
                                                                     <td style="width: 10%;">Fecha nacimineto</td>
                                                                    <td style="width: 10%;">Domicilio</td>
                                                                    
                                                                    <td style="width: 10%;">Colonia</td>
                                                                    <td style="width: 10%;">Teléfono</td>  
                                                                    <td style="width: 10%;">CP</td>
                                                                    <td style="width: 10%;">Correo</td>

                                                                    <td style="width: 10%;">Grado</td>
                                                                     <td style="width: 10%;">Promedio</td>
                                                                    <td style="width: 10%;">Situación académica</td>
                                                                    
                                                                    <td style="width: 10%;">Tipo Alumno</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 10%;">CCT</td>

                                                                    <td style="width: 10%;">Escuela</td>
                                                                     <td style="width: 10%;">Municipio</td>
                                                                     
                                                                 
                                                                    
                                                                    <td style="width: 10%;">Fecha registro</td>
                                                                    
                                                                    <td style="width: 10%;">Beca</td>
                                                                    <td style="width: 10%;">Fecha ingreso DUAL</td>

                                                                    <td style="width: 10%;">Fecha Reingreso</td>
                                                                      <td style="width: 10%;">Fecha Egreso</td>
                                                                      <td style="width: 10%;">Fecha cambio estatus</td>
                                                                      <td style="width: 10%;">Estatus General</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="STATUS==1">

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                           <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                        <td style="width: 50%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CVE_CAARRERA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="NOMBRE_CARRERA" /></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECNAC"/></td>
                                                                        <td style="width: 10%;"><s:property value="DOMICILIOA"/></td>
                                                                        <td style="width: 10%;"><s:property value="COLONIA" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="TELEFONO" /></td>
                                                                         <td style="width: 10%;"><s:property value="CP" /></td>
                                                                         <td style="width: 10%;"><s:property value="CORREO" /></td>
                                                                        
                                                                        <td style="width: 10%;"><s:property value="GRADO"/></td>
                                                                        <td style="width: 10%;"><s:property value="PROMEDIOGRAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>
                                                                        <td style="width: 10%;"><s:property value="TIPO_ALUMNO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="STATUS" /></td>
                                                                         <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="NOMESC"/></td>
                                                                        <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                       

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_REG" /></td>
                                                                        <td style="width: 10%;"><s:property value="BECA"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_REINGRESO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_EGRESO" /></td>

                                                                        <td style="width: 10%;" align="center"><s:property value="FECHA_CAMBIO_ESTATUS" /></td>
                                                                        <td style="width: 10%;"><s:property value="ESTATUS_GENERAL"/></td>
                                                                        </tr>

                                                                    </s:if>
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport25"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport25").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData25').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup6-cerrar" href="#">X</a>
                                        </div>
                                    </div>       
                                    
                                      <div class="modal-wrapper" id="popup10">
                                        <div class="popup10-contenedor">
                                            <h2 style="color: #0065d2;" >Nuevos ingresos DUAL</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData12">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosNuevos.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="8" align="center" style="background: #0065d2; color: white;" >Total de Alumnos Nuevos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 30%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave</td>
                                                                    <td style="width: 10%;">Situación</td>

                                                                    <td style="width: 10%;">Municipio</td>
                                                                     <td style="width: 10%;">Fecha Ingreso</td>
                                                                      <td style="width: 10%;">CCT</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosNuevos" id="ListaAlumnosNuevos" status="stat">

                                                                   

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            
                                                                            
                                                                            <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                            <td style="width: 10%;"><s:property value="CURP"/></td>
                                                                            <td style="width: 30%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                            <td style="width: 10%;"><s:property value="CLAVECARRERA"/></td>
                                                                            <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>

                                                                            <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                            <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                            <td style="width: 10%;"><s:property value="CCT"/></td>

                                                                        </tr>

                                                                 
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosNuevos.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport12"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport12").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData12').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup10-cerrar" href="#">X</a>
                                        </div>
                                    </div>                                                                          


                                    
                                    
                                    
                                     <div class="modal-wrapper" id="popup11">
                                        <div class="popup11-contenedor">
                                            <h2 style="color: #A5DF00;" >Reingresos DUAL</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData13">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosReingresos.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="8" align="center" style="background: #A5DF00; color: white;" >Total de Reingresos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">Matricula</td>
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 30%;">Nombre</td>
                                                                    <td style="width: 10%;">Clave</td>
                                                                    <td style="width: 10%;">Situación</td>

                                                                    <td style="width: 10%;">Municipio</td>
                                                                     <td style="width: 10%;">Fecha Ingreso</td>
                                                                      <td style="width: 10%;">CCT</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosReingresos" id="ListaAlumnosReingresos" status="stat">

                                                                   

                                                                        <tr style=" background: #efeaf0; font-size: 8px;">
                                                                            
                                                                            
                                                                            <td style="width: 10%;"><s:property value="MATRICULA"/></td>
                                                                            <td style="width: 10%;"><s:property value="CURP"/></td>
                                                                            <td style="width: 30%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                            <td style="width: 10%;"><s:property value="CLAVECARRERA"/></td>
                                                                            <td style="width: 10%;"><s:property value="SITUACIONACA"/></td>

                                                                            <td style="width: 10%;"><s:property value="MUNICIPIO"/></td>
                                                                            <td style="width: 10%;"><s:property value="FECHA_INGRESO_DUAL"/></td>
                                                                            <td style="width: 10%;"><s:property value="CCT"/></td>

                                                                        </tr>

                                                                 
                                                                </s:iterator>
                                                            </s:if>

                                                            <s:else>

                                                                <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                            </s:else>
                                                        </table>

                                                    </table>

                                                    <s:if test="ListaAlumnosReingresos.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport13"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport13").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData13').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup11-cerrar" href="#">X</a>
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
