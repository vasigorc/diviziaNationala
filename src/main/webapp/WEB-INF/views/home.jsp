<%-- 
    Document   : home
    Created on : Aug 8, 2015, 10:38:33 AM
    Author     : vgorcinschi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="false" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="<c:url value="/resources/imgs/soccer_3.ico" />">

        <title>Concordia Football Manager</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/sticky-footer-navbar.css"/>" rel="stylesheet">


        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    </head>

    <body>

        <!-- Fixed navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Football Manager</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">List... <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Players</a></li>
                                <li><a href="#">Coaches</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Teams</li>
                                <li><a href="#">Team A</a></li>
                                <li><a href="#">Team B</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <!-- Begin page content -->
        <div class="container">
            <div class="page-header">
                <h1>Sticky footer with fixed navbar</h1>
            </div>
            <button type="button" class="btn btn-primary btn-lg active">Create player</button>
            <button type="button" class="btn btn-primary btn-lg active">Create trainer</button>
        </div>

        <footer class="footer">
            <div class="container">
                <p class="text-muted">Place sticky footer content here.</p>
            </div>
        </footer>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"</script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="<c:url value="/resources/js/ie10-viewport-bug-workaround.js"/>"></script>
    </body>
</html>
