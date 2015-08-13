<%-- 
    Document   : player
    Created on : Aug 11, 2015, 9:10:44 PM
    Author     : vgorcinschi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">
    <c:set var="title" value="${player.firstName} ${player.lastName}"/>
    <c:set var="home" value=""/>
    <c:set var="about" value=""/>
    <c:set var="contact" value=""/>
    <%@include file="../jspfs/head.jspf" %>
</head>
<body>
    <%@include file="../jspfs/navbar.jspf" %>
    <div class="media">
        <div class="media-body">
            First Name*: ${player.firstName}<br/>
            Last Name*: ${player.lastName}<br/>
            Age*: ${player.age}<br/>
            Country*: ${player.birthCountry}<br/>
            Position*: ${player.position}<br/>
            Annual Salary*: ${player.salary}<br/>
            Stats*: ${player.stats.games} games and ${player.stats.goals} goals<br/>
            <div style="margin: auto; width: 50%">
                <button onclick="location.href='<c:url value="/home" />'" type="button" class="btn btn-default">Return</button>
            </div>
        </div>
    </div>
    <%@include file="../jspfs/footer.jspf" %>
</body>
</html>
