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
    <c:set var="title" value="Home"/>
    <c:set var="home" value="active"/>
    <c:set var="about" value=""/>
    <c:set var="contact" value=""/>
    <%@include file="../jspfs/head.jspf" %>
    <body>
        <%@include file="../jspfs/navbar.jspf" %>         
        
            <div class="page-header">
                <h1>Choose what you want to do:</h1>
            </div>
            <div style="margin: auto; width: 50%">
                <button onclick="location.href='<c:url value="/createplayer" />'" type="button" class="btn btn-default btn-lg">Create player</button>
                <button onclick="location.href='<c:url value="/createtrainer" />'" type="button" class="btn btn-default btn-lg" style="position: absolute; margin-left: 5em;">Create trainer</button>
            </div>
        <%@include file="../jspfs/footer.jspf" %>
    </body>
</html>
