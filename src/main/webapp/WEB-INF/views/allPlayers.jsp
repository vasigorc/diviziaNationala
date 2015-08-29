<%-- 
    Document   : player
    Created on : Aug 11, 2015, 9:10:44 PM
    Author     : vgorcinschi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <div class="media-body">
            <c:choose>
                <c:when test="${fn:length(playerList)==0}">
                    <h3>There are no players saved yet &#128543;<a href='<c:url value="/createplayer" />'><small> Create one!</small></a></h3>
                </c:when>
                <c:otherwise>
                    <p class="text-center">&#42;Click on a player to get more details</p>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Position</th>
                            </tr>
                        </thead>
                        <tbody>                            
                            <c:forEach varStatus="count" var="player" items="${playerList}">
                                <tr>
                                    <th scope="row">${count.count}</th>
                                    <td>${player.firstName}</td>
                                    <td>${player.lastName}</td>
                                    <td>${player.position}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <%@include file="../jspfs/footer.jspf" %>
</body>
</html>
