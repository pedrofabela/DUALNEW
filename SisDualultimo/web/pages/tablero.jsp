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
                                    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav" style="height: 60px;" >
                                        <div class="container">
                                            <img class="img-fluid mb-2 d-block mx-auto" src="images/logos-10.png" alt="" style="width: 25%;"/>   
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded " type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                                                Menu
                                                <i class="fas fa-bars"></i>
                                            </button>
                                            <jsp:include page="/pages/menuB2.jsp"/>
                                        </div>
                                    </nav>


                                    <!-- Header -->
                                    <header class="masthead text-white text-center" >

                                        <div class="container"  style="margin-top: -120px; " >
                                            <div class="modal-content" style="border-radius: 10px; box-shadow: 5px 5px 10px #333;">
                                                <div   style="background: #072146; text-align: center; width: 100%; margin: auto; height: 60px; padding: 20px; ">
                                                    <h4 align="center"  style="color: #ffffff; font-size: 15px;"> TABLERO DE CONTROL DE LA <s:property value="usuariocons.getNAMEUSUARIO()"/></h4> 
                                                    
                                                </div>  
                                                <div class="modal-body">                                              
                                                    
                                                            
                                                           
                                                    <div class="mr-5">hola</div>

                                                    
                                                   
                                                        
                                                   <!--     <div style="position: absolute; color: white; float: left; width: 150px; height: 40px; background: #633974; margin-top: -15px; border-radius: 20px 20px 0px 0px; padding: 8px; box-shadow: 3px 3px 10px #666; z-index: 1; font-size: 12px;">
                                                            Alumnos DUAL: <s:property value="datos.ALUMNOS_NUEVO_INGRESO"/>                                                          
                                                        </div> -->
                                                        
                                                        <div id="wrapper2" style="position: relative;" >    
                                                            
                                                          
                                                                    
                                                                    
                                                                    
                                                                    

                                                                    <div class="row"  >
                                                                        
                                                                        
                                                                     
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                              <div class="form-group col-lg-4" style="background: #343a40; padding: 10px; height: 60px;"  >

                                                                    <s:textfield name="datos.FECHA_INICIO" id="Fecha"  placeholder="Fecha de Inicial"  cssClass="form-control"   />


                                                                </div>


                                                                <div class="form-group col-lg-4"  style="background: #343a40; padding: 10px; height: 60px;" >

                                                                    <s:textfield name="datos.FECHA_TERMINO" id="Fecha1"  placeholder="Fecha de Termmino"   cssClass="form-control"   />


                                                                </div>

                                                                <div class="form-group col-lg-4" style="background: #343a40; padding: 10px; height: 60px;" >                                                 
                                                                    <a href="Javascript:Accion('consultaDashboard')" ><div style="width: 80%; max-width: 250px;  height: 35px; background: #0065d2; margin: auto; margin-top: 2px; color: white; border-radius: 10px; text-align: center; padding: 5px; text-decoration: none;">Generar</div></a>

                                                                </div>         
                                                                        
                                                                    
                                                               <!-- indicadores de colores -->     
                                                               <div class="form-group col-lg-3" style="padding: none;"  >

                                                                   <div style="background: #28a745; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                       <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                           Alumnos activos 

                                                                       </div>
                                                                           <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                               <s:property value="datos.TOTAL_ALU_ACTIVO"/> <i class="fas fa-fw fa-user" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                       </div>
                                                                     <a href="#popup" style="text-decoration: none; color:white;" >      <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                          Detalle de Alumnos        ->

                                                                         </div></a>


                                                                   </div>


                                                               </div>  
                                                                               
                                                                               
                                                                               
                                                                     <div class="form-group col-lg-3" style="padding: none;"  >

                                                                   <div style="background: #dc3545; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                       <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                           Alumnos inactivos 

                                                                       </div>
                                                                            <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                               <s:property value="datos.TOTAL_ALU_INACTIVO"/> <i class="fas fa-fw fa-thumbs-down" style="position: absolute; z-index: 0; top : -2 rem; right: 0.5rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                           </div> 
                                                                               <a href="#popup2" style="text-decoration: none; color: white;" > <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                          Detalle de Alumnos        ->

                                                                                   </div>
                                                                               </a>


                                                                   </div>


                                                               </div>  
                                                                                          
                                                                               
                                                                     
                                                                               
                                                                               
                                                                               
                                                                 <div class="form-group col-lg-3" style="padding: none;"  >

                                                                   <div style="background: #ffc107; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                       <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                           Alumnos egresados

                                                                       </div>
                                                                           <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                               <s:property value="datos.EGRESADOS"/> <i class="fas fa-fw fa-graduation-cap" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                       </div>
                                                                               <a href="#popup3" style="text-decoration: none; color: white;" >    <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                          Detalle de Alumnos        ->

                                                                       </div>
                                                                                   </a>


                                                                   </div>


                                                               </div>                 
                                                                               
                                                                               
                                                                    
                                                                               
                                                                               
                                                                               
                                                                               
                                                                             
                                                                 <div class="form-group col-lg-3" style="padding: none;"  >

                                                                   <div style="background: #007bff; width: 100%; height: 100px; padding: 5px; border-radius: 3px; box-shadow: 2px 2px 5px #333; font-size: 14px;">

                                                                       <div style="width: 100%; height: 20px; color: white; text-align:center; ">    

                                                                           Alumnos nuevos

                                                                       </div>
                                                                           <div style="width: 100%; height: 35px; color: white;   font-size: 30px; text-align: center; ">    

                                                                               <s:property value="datos.ALUMNOS_NUEVOS"/> <i class="fas fa-fw fa-wrench" style="position: absolute; z-index: 0; top : -2.5 rem; right: 0.9rem; opacity: 0.4; font-size: 4rem; transform: rotate(15deg)"></i>

                                                                       </div>
                                                                          <div style="width: 100%; height: 30px;  background: rgba(0, 0, 0, 0.05); padding: 3px; margin-top: 10px; border-top: 0.5px solid #666; font-size: 12px; text-align: left;">    

                                                                          Detalle de Alumnos        ->

                                                                       </div>


                                                                   </div>


                                                               </div>                               
                                                                               
                                                                               
                                                               


                                                             

                                                              
                                                                        
                                                                 <!--  contenedores principlaes-->       


                                                                <div class="form-group col-lg-6" >


                                                                    <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Total de Alumnos en DUAL</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
                                                                        <table style="width: 98%; text-align: center;  ">
                                                                            <tr style="background: #edecec;">
                                                                                <td style="width: 40%;" ><div style="width: 90%; height: 140px; background: #a2a3b8; color: white; margin: auto; border-radius: 10px; margin-top: 35px; margin-bottom: 25px; box-shadow: 5px 5px 10px #666; "><h1 style="padding: 40px; font-size: 50px;"><s:property value="datos.TOTAL_ALU_DUAL"/></h1></div></td>
                                                                                <td style="width: 60%;">
                                                                                    <a href="#popup" style="text-decoration: none;" > 
                                                                                        <div style="width: 43%; height: 65px; background: #145a32 ; display: inline-block; margin: auto;  margin-top: 5px; border-radius: 10px; box-shadow: 5px 5px 10px #666;">
                                                                                            <div style="width: 100%; color: white ; margin-top: 5px; display: block;">Activos</div> 
                                                                                            <div style="width: 100%; color: white ; margin-top: 0px; display: block;">
                                                                                                <h3><s:property value="datos.TOTAL_ALU_ACTIVO"/></h3>
                                                                                                <i class="material-icons" style="float: right; margin-top: -45px; margin-right: 15px; font-size: 25px; color: white;"></i> 
                                                                                            </div>
                                                                                        </div> 
                                                                                    </a>

                                                                                    <a href="#popup2" style="text-decoration: none;" >  
                                                                                        <div style="width: 43%; height: 65px; background: #ce0039; display: inline-block;  margin: auto; margin-top: 10px; border-radius: 10px; box-shadow: 5px 5px 10px #666;">
                                                                                            <div style="width: 100%; color: white ; margin-top: 5px; display: block;">Inactivos</div> 
                                                                                            <div style="width: 100%; color: white ; margin-top: 0px; display: block;">
                                                                                                <h3><s:property value="datos.TOTAL_ALU_INACTIVO"/></h3>
                                                                                            </div>
                                                                                        </div>
                                                                                    </a>

                                                                                    <div style="width: 90%; height: 65px; background: purple; display: inline-block; margin: auto;  margin-top: 3px; border-radius: 10px; box-shadow: 5px 5px 10px #666;">
                                                                                        <div style="width: 100%; color: white ; margin-top: 5px; display: block; ">Proyectos Registrados</div> 
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


                                                                    <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Estatus de Alumnos en el periodo</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">


                                                                        <div id="piechart" style="width: 100%; height: 240px; margin: auto; margin-top: 0px;"></div>

                                                                    </div> 

                                                                </div>  


                                                                <div class="form-group col-lg-12"  >


                                                                    <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Número de Alumnos por CCT   </div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">

                                                                        <div id="columnchart_values" style="width: 100%; height: 300px;"></div>

                                                                    </div> 

                                                                </div>  



                                                                <div class="form-group col-lg-12"  >


                                                                    <div style="width:100%; text-align: center; background: #343a40; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Número de Alumnos por Género</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">

                                                                        <div id="chart_div" style="margin-bottom: 50px; height: 250px;"></div>





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
                                            <h2  >Alumos Activos</h2>

                                            <div style="min-height:350px; max-height: 300px; overflow-y: scroll;" >
                                                <div id="dvData">

                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboard.size()>0">


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

                                                                <s:iterator value="ListaAlumnosDashboard" id="ListaAlumnosDashboard" status="stat">

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


                                                    <s:if test="ListaAlumnosDashboard.size()>0">

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


                                                        <s:if test="ListaAlumnosDashboard.size()>0">


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

                                                                <s:iterator value="ListaAlumnosDashboard" id="ListaAlumnosDashboard" status="stat">

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

                                                    <s:if test="ListaAlumnosDashboard.size()>0">

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

                                                                                            
                                                                                            
                                                                                            
                                      <!-- Alumnos Egresados -->      
                                      
                                      
                                      
                                       <div class="modal-wrapper" id="popup3">
                                        <div class="popup3-contenedor">
                                            <h2 style="color: #ffc107;" >Alumnos egresados</h2>

                                            <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >


                                                <div id="dvData3">  


                                                    <table id="customers" style="text-align: justify;">


                                                        <s:if test="ListaAlumnosDashboard.size()>0">


                                                            <table id="customers" style=" font-size: 12px;">

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: #ffc107; color: white;" >Alumnos Inactivos</td>
                                                                </tr>

                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">CURP</td>
                                                                    <td style="width: 50%;">Nombre</td>
                                                                    <td style="width: 10%;">CCT</td>
                                                                    <td style="width: 10%;">Sexo</td>

                                                                    <td style="width: 20%;">Clave Carrera</td>


                                                                </tr>

                                                                <s:iterator value="ListaAlumnosDashboard" id="ListaAlumnosDashboard" status="stat">

                                                                    <s:if test="STATUS==10">

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

                                                    <s:if test="ListaAlumnosDashboard.size()>0">

                                                        <center>

                                                            <input  align="top" type="image" id="btnExport3"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                        </center>

                                                        <script>
                                                            $("#btnExport3").click(function (e) {
                                                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData3').html()));
                                                                e.preventDefault();
                                                            });
                                                        </script>

                                                    </s:if>




                                                </div>
                                            </div>

                                            <a class="popup3-cerrar" href="#">X</a>
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







                                </s:form>

                            </body>

                            </html>
