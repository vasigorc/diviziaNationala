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
    <c:set var="title" value="All Players"/>
    <c:set var="home" value=""/>
    <c:set var="about" value=""/>
    <c:set var="contact" value=""/>
    <%@include file="../jspfs/head.jspf" %>
</head>
<body>
    <%@include file="../jspfs/navbar.jspf" %>
    <div class="media">
        <h3>There are no players saved yet &#128543;<a href='<c:url value="/createplayer" />'><small> Create one!</small></a></h3>
        <div class="media-body">
            <p class="text-center">&#42;Click on a player to get more details</p>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Position</th>
                    </tr>
                </thead>
                <tbody>
                    
                </tbody>
            </table>
        </div>
    </div>
    <%@include file="../jspfs/footer.jspf" %>
</body>
</html>
