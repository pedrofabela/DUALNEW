<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">

    <head>

        <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="">
                        <meta name="author" content="">

                            <title>Cuentas de Correo</title>

                            <link href=" <s:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" media="all" rel="stylesheet" type="text/css"/>
                            <!-- Custom fonts for this template-->
                            <link href=" <s:url value="/vendor/fontawesome-free/css/all.min.css"/>" media="all" rel="stylesheet" type="text/css"/>        
                            <!-- Page level plugin CSS-->
                            <link href=" <s:url value="/vendor/datatables/dataTables.bootstrap4.css"/>" media="all" rel="stylesheet" type="text/css"/>            
                            <!-- Custom styles for this template-->
                            <link href=" <s:url value="/css/sb-admin.css"/>" media="all" rel="stylesheet" type="text/css"/> 
                            <!-- css extras-->
                            <link href=" <s:url value="/css/CssExtras.css"/>" media="all" rel="stylesheet" type="text/css"/> 

                            <!-- para la barra de progreso  -->
                            <link type="text/css" href="<s:url value="/css/style_E.css"/>" rel="stylesheet" />
                            <script type="text/javascript" src="<s:url value="/js/jquery-loader_E.js"/>"></script>

                            <!-- fin barra progreso -->


                            <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
                            <script type="text/javascript" src="js/jquery.ui.core.js"></script>
                            <script type="text/javascript" src="js/jquery.ui.widget.js"></script>



                            <script type="text/javascript">

                                function Accion(accion) {

                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.submit();
                                }

                                function seleccionguardarAlerta(accion) {
                                    //llamar al loader  ………

                                    $data = {
                                        size: $('32'),
                                        bgColor: $('#FFF'),
                                        bgOpacity: $('1.5'),
                                        fontColor: $('#000'),
                                        title: ' Notificando ... ',
                                        isOnly: !$('true')

                                    };
                                    $.loader.open($data);
                                    //fin del loader

                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.target = "_self";
                                    document.formularioPrincipal.submit();

                                }

                                //PARA REGRESAR EN DONDE SE QUEDO...........
                                window.onload = function () {
                                    var pos = window.name || 0;
                                    window.scrollTo(0, pos);
                                }

                                window.onunload = function () {
                                    window.name = self.pageYOffset
                                            || (document.documentElement.scrollTop + document.body.scrollTop);
                                    //terminar proceso de carga de procesando...
                                    $.loader.close(true);
                                }


                            </script>

                            <script type="text/javascript">
                                function validarInput(input) {
                                    var curp = input.value.toUpperCase(),
                                            resultado = document.getElementById("resultado"),
                                            valido = "No válido";


                                    if (curpValida(curp)) {
                                        valido = "Válido";
                                        resultado.classList.add("ok");
                                    } else {
                                        resultado.classList.remove("ok");

                                    }

                                    resultado.innerText = "Formato de CURP: " + valido;

                                    if (valido == "Válido") {

                                        document.getElementById('boton').style.visibility = 'visible';
                                    } else {

                                        document.getElementById('boton').style.visibility = 'hidden';

                                    }



                                }

                                function curpValida(curp) {
                                    var re = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0\d|1[0-2])(?:[0-2]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/,
                                            validado = curp.match(re);

                                    if (!validado)  //Coincide con el formato general?
                                        return false;

                                    //Validar que coincida el dígito verificador
                                    function digitoVerificador(curp17) {
                                        //Fuente https://consultas.curp.gob.mx/CurpSP/
                                        var diccionario = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZ",
                                                lngSuma = 0.0,
                                                lngDigito = 0.0;
                                        for (var i = 0; i < 17; i++)
                                            lngSuma = lngSuma + diccionario.indexOf(curp17.charAt(i)) * (18 - i);
                                        lngDigito = 10 - lngSuma % 10;
                                        if (lngDigito == 10)
                                            return 0;
                                        return lngDigito;
                                    }
                                    if (validado[2] != digitoVerificador(validado[1]))
                                        return false;

                                    return true; //Validado
                                }
                            </script>

                            <script>

                                function startTime() {
                                    var today = new Date();
                                    var hr = today.getHours();
                                    var min = today.getMinutes();
                                    var sec = today.getSeconds();
                                    ap = (hr < 12) ? "<span>am</span>" : "<span>pm</span>";
                                    hr = (hr == 0) ? 12 : hr;
                                    hr = (hr > 12) ? hr - 12 : hr;
                                    //Add a zero in front of numbers<10
                                    hr = checkTime(hr);
                                    min = checkTime(min);
                                    sec = checkTime(sec);
                                    document.getElementById("clock").innerHTML = hr + ":" + min + ":" + sec + " " + ap;

                                    var months = ['Enero', 'Febrero', 'Marzo', 'April', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
                                    var days = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado'];
                                    var curWeekDay = days[today.getDay()];
                                    var curDay = today.getDate();
                                    var curMonth = months[today.getMonth()];
                                    var curYear = today.getFullYear();
                                    var date = curDay + " " + 'de' + " " + curMonth;
                                    document.getElementById("date").innerHTML = date;

                                    var time = setTimeout(function () {
                                        startTime()
                                    }, 500);
                                }
                                function checkTime(i) {
                                    if (i < 10) {
                                        i = "0" + i;
                                    }
                                    return i;
                                }
                            </script>

                            </head>

                            <body id="page-top" onload="startTime()">
                                <s:form name="formularioPrincipal" id="formularioPrincipal" enctype="multipart/form-data">

                                    <nav class="navbar navbar-expand navbar-dark " style="height: 75px; background: #4885Ed; box-shadow: 2px 2px 5px #333; border-bottom: 2px solid #f4c20d;">


                                        <span class="navbar-brand mr-1">Cuentas de Correo</span>

                                        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                                            <i class="fas fa-bars"></i>
                                        </button>

                                        <!-- Navbar Search -->
                                        <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

                                        </div>

                                        <!-- Navbar -->
                                        <ul class="navbar-nav ml-auto ml-md-0">    
                                            <li class="nav-item dropdown no-arrow">
                                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-user-circle fa-fw" style="font-size: 40px;"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">                                           
                                                    <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">Cerrar Sesion</a>
                                                </div>
                                            </li>
                                        </ul>

                                    </nav>

                                    <div id="wrapper">

                                        <!-- Sidebar -->
                                        <jsp:include page="/pages/menuB.jsp"/>


                                        <div id="content-wrapper">
                                            <div  class="modal-header">
                                                <img src="images/edomex.png" alt="edomex" ></img>
                                                <div style="text-align: center; margin-right: 30px; background:  #4885Ed; margin-top: 10px; width: 170px; height: 90px; border-radius: 20px; color: white; font-size: 15px;"> <h7><i class="fas fa-clock" style="font-size: 25px; margin-top: 8px;"></i><div id="date" style="margin-top: 5px;" ></div><div id="clock"></div></h7></div>                
                                            </div>
                                            <br/>
                                            <div class="container-fluid">
                                                <s:if test="banGenCuentaA">
                                                    <s:hidden name="banGenCuentaA" value="%{banGenCuentaA}"></s:hidden> 
                                                        <div class="modal-content">
                                                            <div class="modal-header" style="background-color: #1c2a48;">
                                                                <h4 align="center" style="color: #ffffff"> <i class="fas fa-book"></i>Crear Cuentas de Alumnos</h4> 
                                                                <br/>
                                                            </div>  
                                                            <div class="modal-body">
                                                                <div class="dropdown-divider"></div>                                                                                                                                                                                     
                                                            <s:if test="banTablaDatosAlumGen">
                                                                <div class="table-wrapper-scroll-y">
                                                                    <div style=" background-color: #2e3951 ; border-radius: 5px">
                                                                        <h5 class="text-white" align="center">DATOS PENDIENTES PARA CREAR CUENTAS</h5>                                                                    
                                                                    </div>
                                                                    <table class="table table-hover pag">                                                                   
                                                                        <thead >                                                                      
                                                                            <tr style="background-color: #929fba;">              
                                                                                <th class="text-white" scope="col">CURP</th>
                                                                                <th class="text-white" scope="col">NOMBRE(S)</th>
                                                                                <th class="text-white" scope="col">APELLIDO PATERNO</th>
                                                                                <th class="text-white" scope="col">APELLIDO MATERNO</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <s:iterator value="ListaCuentasGenerarA" id="ListaCuentasGenerarA" status="stat">
                                                                                <tr style="background-color: #d0d6e2;">
                                                                                    <td class="text-muted" ><s:property value="CURPA"/></td>
                                                                                    <td class="text-muted" ><s:property value="NOMBRE"/></td>
                                                                                    <td class="text-muted" ><s:property value="APELLIDOP"/></td>
                                                                                    <td class="text-muted" ><s:property value="APELLIDOM"/></td>
                                                                                </tr>
                                                                                <s:hidden  name = "ListaCuentasGenerarA[%{#stat.index}].CURPA" id="CURPA"></s:hidden>
                                                                                <s:hidden  name = "ListaCuentasGenerarA[%{#stat.index}].NOMBRE" id="NOMBRE"></s:hidden>
                                                                                <s:hidden  name = "ListaCuentasGenerarA[%{#stat.index}].APELLIDOP" id="APELLIDOP"></s:hidden>
                                                                                <s:hidden  name = "ListaCuentasGenerarA[%{#stat.index}].APELLIDOM" id="APELLIDOM"></s:hidden>

                                                                            </s:iterator>
                                                                        </tbody>
                                                                    </table>                                                               
                                                                </div>
                                                                <script type="text/javascript">



                                                                    $('table.paginated').each(function () {
                                                                        var currentPage = 0;
                                                                        var numPerPage = 100;
                                                                        var $table = $(this);
                                                                        $table.bind('repaginate', function () {
                                                                            $table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
                                                                            //document.getElementById("indice").value = currentPage + 1;
                                                                        });



                                                                        $table.trigger('repaginate');
                                                                        var numRows = $table.find('tbody tr').length;
                                                                        var numPages = Math.ceil(numRows / numPerPage);
                                                                        var $pager = $('<div class="pager"></div>');
                                                                        for (var page = 0; page < numPages; page++) {
                                                                            $('<span class="page-number"></span>').text(page + 1).bind('click', {
                                                                                newPage: page
                                                                            }, function (event) {
                                                                                currentPage = event.data['newPage'];
                                                                                $table.trigger('repaginate');
                                                                                $(this).addClass('active').siblings().removeClass('active');
                                                                                document.getElementById("indice").value = currentPage + 1;
                                                                            }).appendTo($pager).addClass('clickable');

                                                                        }
                                                                        $pager.insertAfter($table).find('span.page-number:first').addClass('active');
                                                                    });


                                                                </script>
                                                                <s:textfield name="datos.INDICE" id="indice" style="visibility:hidden" />
                                                            </s:if>                                                        
                                                        </div>
                                                        <div class="modal-footer">
                                                            <div class="form-inline">

                                                            </div>
                                                            <div class="form-inline"> 
                                                                <s:if test="MuestraMsj"> 
                                                                    <div class="col-sm-auto" >
                                                                        <s:fielderror  fieldName="MessageOk" cssClass="alert alert-success"/>
                                                                        <s:fielderror  fieldName="SinDatos" cssClass="alert alert-danger"/>
                                                                    </div>
                                                                </s:if>  
                                                                <s:if test="BanBtnCC">
                                                                    <div class="col-sm-auto">
                                                                        <a class="btn" style="background-color: #2e3951; color: white;" href="Javascript:Accion('CrearCuentasA')">Crear Cuentas</a>
                                                                    </div>
                                                                </s:if>                                                                   
                                                            </div>
                                                        </div>    
                                                    </div>   
                                                </s:if>
                                            </div>                                           
                                        </div>
                                    </div>
                                    <br></br>
                                    <!-- Sticky Footer -->
                                    <footer class="sticky-footer" style="width: 100%; background-color: #ced4da; ">
                                        <div class="container my-auto">
                                            <div class="copyright text-center my-auto">
                                                <span>Copyright Â© Your Website 2018</span>
                                            </div>
                                        </div>
                                    </footer>


                                    <!-- /.content-wrapper -->

                                    </div>
                                    <!-- /#wrapper -->

                                    <!-- Scroll to Top Button-->
                                    <a class="scroll-to-top rounded" href="#page-top">
                                        <i class="fas fa-angle-up"></i>
                                    </a>

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

                                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                                        <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                                        <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                                        <s:hidden name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                                        <s:hidden name = "modulosAUX[%{#stat.index}].ACTION" id="ACTION"></s:hidden> 
                                        <s:hidden name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
                                        <s:hidden name = "modulosAUX[%{#stat.index}].NAMEUNIDAD" id="NAMEUNIDAD"></s:hidden>
                                        <s:hidden name = "modulosAUX[%{#stat.index}].VALORU" id="VALORU"></s:hidden>
                                    </s:iterator>
                                    <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">                        
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MODULO" id="MODULO"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MODPADRE" id="MODPADRE"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MOD" id="MOD"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].ACCION" id="ACCION"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].CVE_ACCESO_AUX" id="CVE_ACCESO_AUX"></s:hidden>
                                    </s:iterator>

                                    <!-- Bootstrap core JavaScript-->
                                    <script src="vendor/jquery/jquery.min.js"></script>
                                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                    <!-- Core plugin JavaScript-->
                                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                                    <!-- Page level plugin JavaScript-->
                                    <script src="vendor/chart.js/Chart.min.js"></script>
                                    <script src="vendor/datatables/jquery.dataTables.js"></script>
                                    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

                                    <!-- Custom scripts for all pages-->
                                    <script src="js/sb-admin.min.js"></script>

                                    <!-- Demo scripts for this page-->
                                    <script src="js/demo/datatables-demo.js"></script>
                                    <script src="js/demo/chart-area-demo.js"></script>
                                </s:form>
                            </body>

                            </html>
