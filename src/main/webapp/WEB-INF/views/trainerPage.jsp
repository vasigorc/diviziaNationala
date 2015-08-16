<%-- 
    Document   : trainer
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
    <c:set var="title" value="${trainer.firstName} ${trainer.lastName}"/>
    <c:set var="home" value=""/>
    <c:set var="about" value=""/>
    <c:set var="contact" value=""/>
    <%@include file="../jspfs/head.jspf" %>
</head>
<body>
    <%@include file="../jspfs/navbar.jspf" %>
    <div class="media">       
        <div class="media-body">
            <table class="table table-striped">
                <tr>
                    <th scope="row">First Name*:</th>
                    <td>${trainer.firstName}</td>
                </tr>
                <tr>
                    <th scope="row">Last Name*:</th>
                    <td>${trainer.lastName}</td>
                </tr>
                <tr>
                    <th scope="row">Age*:</th>
                    <td>${trainer.age}</td>
                </tr>
                <tr>
                    <th scope="row">Annual Salary*:</th>
                    <td>${trainer.salary}</td>
                </tr>
            </table>
            <div class="row">
                <div class="col-xs-6 col-md-4">
                    <button onclick="location.href = '<c:url value="/home" />'" type="button" class="btn btn-default">Return</button>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../jspfs/footer.jspf" %>
</body>
</html>
