<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
    
    <script>
        var URLactual = window.location;
        if (URLactual == "http://dual.edugem.gob.mx/") {
            location.href = "https://dual.edugem.gob.mx/";
        }

    </script>

    <head>

        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <meta name="description" content="">
                    <meta name="author" content="">

                        <title >SisDual</title>
                        <link rel="shortcut icon" href="images/portalSE.png" />
                        <!-- Bootstrap core CSS -->
                        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

                            <!-- Custom fonts for this template -->
                            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css" />
                            <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
                            <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />

                            <!-- Plugin CSS -->
                            <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css" />

                            <!-- Custom styles for this template -->
                            <link href="css/freelancer.min.css" rel="stylesheet" />

                            <script type="text/javascript">

                                function guarda(accion) {

                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.submit();
                                }
                            </script>

                            </head>

                            <body id="page-top">
                                <s:form name="formularioPrincipal" id="formularioPrincipal">
                                    <!-- Navigation -->
                                    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
                                        <div class="container">
                                            <img class="img-fluid mb-2 d-block mx-auto" src="images/logos-10.png" alt=""/>   
                                        </div>
                                    </nav>

                                    <!-- Header -->
                                    <header class="masthead  text-white text-center" style="background: linear-gradient(to bottom, rgba(38,122,191,1) 0%, rgba(38,122,191,1) 4%, rgba(5,59,117,1) 17%, rgba(11,75,143,1) 84%, rgba(38,120,191,1) 98%, rgba(38,120,191,1) 100%);" >
                                        <div class="container col-lg-4" >
                                            <div class="card card-login  mx-auto mt-4" style="box-shadow: 2px 2px 7px ; background: linear-gradient(to bottom, rgba(242,246,248,1) 0%, rgba(216,225,231,1) 0%, rgba(181,198,208,1) 24%, rgba(224,239,249,1) 100%);">
                                                <div class="card-header " style="color: #fff;"  align="center"><h4>Acceso Sistema DUAL</h4></div>
                                                <div class="card-body" >

                                                    <div class="form-group ">

                                                        <s:textfield  cssClass="form-control" name="cveusuario" id="cveusuario" placeholder="Usuario"  autofocus="autofocus"></s:textfield>
                                                        <s:fielderror fieldName="ERRORUSU" cssClass="alert alert-danger"/>
                                                    </div>
                                                    <div class="form-group ">

                                                        <s:password cssClass="form-control" name="pasusuario" id="pasusuario"  placeholder="Password" />  
                                                        <s:fielderror fieldName="ERRORPASS" cssClass="alert alert-danger"/>
                                                    </div>

                                                </div>
                                                <div class="card-footer" >
                                                    <a class="btn bg-secondary btn-block" style="color: white;" href="Javascript:guarda('verAcceso')">Acceder</a>
                                                </div>    

                                            </div>
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
                                    <div class="copyright bg-secondary py-5 text-center text-white">
                                        <div class="container">
                                            <small>Copyright &copy; Your Website 2018</small>
                                        </div>
                                    </div>


                                    <!-- Bootstrap core JavaScript -->
                                    <script src="vendor/jquery/jquery.min.js"></script>
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
