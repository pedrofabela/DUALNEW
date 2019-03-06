<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
    var URLactual = window.location;
    if (URLactual == "http://dual.edugem.gob.mx/tablero") {
        location.href = "https://dual.edugem.gob.mx/tablero";
    }

</script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="css/estilo.css"/>



    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


    <script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
        <s:iterator value="ListaTotalEstatus" id="ListaTotalEstatus" status="stat">

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
        <s:iterator value="ListaTotalEsuela" id="ListaTotalEsuela" status="stat">
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



                            <!-- Custom fonts for this template -->
                            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
                            <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
                            <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"/>

                            <!-- Plugin CSS -->
                            <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css"/>

                            <!-- Custom styles for this template -->
                            <link href="css/freelancer.min.css" rel="stylesheet"/>



                            <!-- Bootstrap core JavaScript -->

                            <!-- Bootstrap core CSS -->
                            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>


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

                                    <!-- Header -->
                                    <header class="masthead text-white text-center"  >

                                        <div class="container" style="margin-top: -200px;" >
                                            <div class="modal-content" style="border-radius: 10px;">

                                                <div class="modal-body">                                              


                                                    <!--     <div style="position: absolute; color: white; float: left; width: 150px; height: 40px; background: #633974; margin-top: -15px; border-radius: 20px 20px 0px 0px; padding: 8px; box-shadow: 3px 3px 10px #666; z-index: 1; font-size: 12px;">
                                                             Alumnos DUAL: <s:property value="datos.ALUMNOS_NUEVO_INGRESO"/>                                                          
                                                         </div> -->

                                                    <div id="wrapper2" style="position: relative;" >    

                                                        <div style="width: 100%; height: 40px;  background: #343a40; margin-bottom: 15px; padding: 7px; ">Indicadores Generales</div>


                                                        <div class="row"  >


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


                                                                        <s:else>

                                                                            <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                                        </s:else>
                                                                    </table>

                                                                </div> 



                                                            </div>    

                                                            <div class="form-group col-lg-6" >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Alumnos activos por empresa</div>

                                                                <div style="height: 250px; overflow-y: scroll">
                                                                    <table class="table table-hover"  style=" font-size: 14px; width: 100%;">



                                                                        <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999; background: #10707f; color:white;">
                                                                            <td  scope="row" style="width: 20%;">RFC</td>
                                                                            <td style="width: 40%;">Empresa</td>
                                                                            <td style="width: 20%;">Municipio</td>
                                                                            <td style="width: 20%;">No.Alumnos</td>




                                                                        </tr>

                                                                        <s:iterator value="ListaEmpresasAlumnos" id="ListaEmpresasAlumnos" status="stat">



                                                                            <tr style=" background: #efeaf0; font-size: 12px; color: #333;">
                                                                                <td style="width: 20%;"><s:property value="RFC"/></td>
                                                                                <td style="width: 40%;"><s:property value="RAZON_SOCIAL"/></td>
                                                                                <td style="width: 20%;"><s:property value="NOM_MUN"/></td>
                                                                                <td style="width: 20%;"><s:property value="TOTAL_ALUMNOS_EMPRESA" /></td>



                                                                            </tr>


                                                                        </s:iterator>


                                                                        <s:else>

                                                                            <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>


                                                                        </s:else>
                                                                    </table>

                                                                </div> 


















                                                            </div>











                                                            <div style="width: 100%; height: 40px;  background: #4885Ed; margin-bottom: 15px; padding: 7px; margin-top: 30px;">Indicadores por Periodo</div>         








                                                            <div class="form-group col-lg-4" style="background: #343a40; padding: 10px; height: 60px;"  >

                                                                <s:textfield name="datos.FECHA_INICIO" id="Fecha"  placeholder="Fecha de Inicial"  cssClass="form-control"   />


                                                            </div>


                                                            <div class="form-group col-lg-4"  style="background: #343a40; padding: 10px; height: 60px;" >

                                                                <s:textfield name="datos.FECHA_TERMINO" id="Fecha1"  placeholder="Fecha de Termmino"   cssClass="form-control"   />


                                                            </div>

                                                            <div class="form-group col-lg-4" style="background: #343a40; padding: 10px; height: 60px;" >                                                 
                                                                <a href="Javascript:Accion('consultaDashboardt')" ><div style="width: 80%; max-width: 250px;  height: 35px; background: #0065d2; margin: auto; margin-top: 2px; color: white; border-radius: 10px; text-align: center; padding: 5px; text-decoration: none;">Generar</div></a>

                                                            </div>         


                                                            <!-- indicadores de colores -->    


                                                            <div class="form-group col-lg-3" style="padding: none;"  >

                                                                <div style="background: #007bff; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Nuevos Ingresos

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.ALUMNOS_NUEVOS"/> <i class="fas fa-fw fa-wrench" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div>
                                                                    <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                        <!-- Detalle de Alumnos        -->

                                                                    </div>


                                                                </div>


                                                            </div>      


                                                            <div class="form-group col-lg-3" style="padding: none;"  >

                                                                <div style="background: #A5DF00; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                    <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                        Reingresos

                                                                    </div>
                                                                    <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                        <s:property value="datos.TOTAL_REINGRESOS"/> <i class="fas fa-fw fa-thumbs-down" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                    </div> 
                                                                    <a href="#" style="text-decoration: none; color: white;" > <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                            <!-- Detalle de Alumnos        -->

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










                                                            <!--  contenedores principlaes-->       


                                                            <!--     <div class="form-group col-lg-6" >
 
 
                                                                     <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Total de Alumnos en DUAL</div>
                                                                      <div id="chart_div" style="margin-bottom: 50px; height: 240px;"></div>
 
                                                                 </div>  
 
                                                                 <div class="form-group col-lg-6"  >
 
 
                                                                     <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Estatus de Alumnos en el periodo</div>
                                                                     <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
 
 
                                                                         <div id="piechart" style="width: 100%; height: 240px; margin: auto; margin-top: 0px;"></div>
 
                                                                     </div> 
 
                                                                 </div>  -->


                                                            <div class="form-group col-lg-12"  >


                                                                <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Número de Alumnos por CCT   </div>
                                                                <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">

                                                                    <div id="columnchart_values" style="width: 100%; height: 300px;"></div>

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


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


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

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="STATUS!=1 && STATUS!=10">

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

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

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




                                    <!-- TOTAL DE ALUMNOS DUAL -->    

                                    <div class="modal-wrapper" id="popup3">
                                        <div class="popup3-contenedor">
                                            <h2 style="color: #ffc107;" >Alumnos Egresados</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData2">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: #ffc107; color: white;" >Alumnos Egresados</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="STATUS == 10">

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

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

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

                                            <a class="popup3-cerrar" href="#">X</a>
                                        </div>
                                    </div>     



                                    <div class="modal-wrapper" id="popup4">
                                        <div class="popup4-contenedor">
                                            <h2 style="color: #008080;" >Alumnos con Beca</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData2">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: #008080; color: white;" >Alumnos con beca</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

                                                                    <s:if test="BECA=='si' && STATUS==1 ">

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

                                                    <s:if test="ListaAlumnosDashboardUGeneral.size()>0">

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

                                            <a class="popup4-cerrar" href="#">X</a>
                                        </div>
                                    </div>     
















                                    <div class="modal-wrapper" id="popup5">
                                        <div class="popup5-contenedor">
                                            <h2 style="color: gray;" >Total de alumnos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData2">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: grey; color: white;" >Total de Alumnos DUAL</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">



                                                                    <tr style=" background: #efeaf0; font-size: 8px;">
                                                                        <td style="width: 10%;"><s:property value="CURP"/></td>
                                                                        <td style="width: 50%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                        <td style="width: 10%;"><s:property value="CCT"/></td>
                                                                        <td style="width: 10%;"><s:property value="SEXO" /></td>

                                                                        <td style="width: 20%;" align="center"><s:property value="CLAVECARRERA" /></td>

                                                                    </tr>


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

                                            <a class="popup5-cerrar" href="#">X</a>
                                        </div>
                                    </div>                                          

                                    <div class="modal-wrapper" id="popup6">
                                        <div class="popup6-contenedor">
                                            <h2 style="color: green;" >Total de Alumnos activos</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData2">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboardUGeneral.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: green; color: white;" >Total de Alumnos Activos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboardUGeneral" id="ListaAlumnosDashboardUGeneral" status="stat">

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

                                            <a class="popup6-cerrar" href="#">X</a>
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







                                </s:form>

                            </body>

                            </html>
