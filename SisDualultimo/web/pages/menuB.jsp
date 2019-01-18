<%--
    Author     : Esteban y yo
--%>
<%@page import="beans.moduloBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>

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

        <script type="text/javascript">

            function SeleccionMenu(accion) {

                document.formularioPrincipal.target = "_self";
                document.formularioPrincipal.action = accion;
                document.formularioPrincipal.submit();

            }

        </script>
    </head>
    <body>
        <s:form name="formularioPrincipal"  id="formularioPrincipal">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">

                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                        <s:if test='CVE_MODPADRE=="S"'>
                            <li class="nav-item mx-0 mx-lg-1">
                                <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<s:property value="ACTION"/>">
                                    <i class="fas fa-fw fa-plus-circle" style="color: #004085"></i>
                                    <span><s:property value="DESC_MOD"/></span>
                                </a>                          
                            </li> 
                        </s:if>
                    </s:iterator>

                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user-circle fa-fw" style="font-size: 40px;"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">                                           
                            <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">Cerrar Sesion</a>
                        </div>
                    </li>

                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                        <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].ACTION" id="ACTION"></s:hidden> 
                        <s:hidden name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].NAMEUNIDAD" id="NAMEUNIDAD"></s:hidden>
                        <s:hidden name = "modulosAUX[%{#stat.index}].VALORU" id="VALORU"></s:hidden>
                    </s:iterator>
                    
                </ul>
            </div>
        </s:form>  
    </body>
</html>