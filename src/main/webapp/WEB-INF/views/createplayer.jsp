<%-- 
    Document   : createplayer
    Created on : Aug 9, 2015, 6:13:09 PM
    Author     : vgorcinschi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">
    <c:set var="title" value="Create Player"/>
    <c:set var="home" value=""/>
    <c:set var="about" value=""/>
    <c:set var="contact" value=""/>
    <%@include file="../jspfs/head.jspf" %>
    <body>
        <%@include file="../jspfs/navbar.jspf" %>   
        <h1>Hai și-om fași și noi jucători &#9786;</h1>
        <%@include file="../jspfs/footer.jspf" %>
    </body>
</html>