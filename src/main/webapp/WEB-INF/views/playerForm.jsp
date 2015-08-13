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
        <h1>Hai și-om fași și noi niște jucători &#9786;</h1>
        <sf:form method="POST" cssClass="form-horizontal" commandName="playerForm">
            <sf:errors path="*" element="div" cssClass="alert alert-warning"></sf:errors>
            
            <div class="form-group">
                <sf:label cssErrorClass="errors col-sm-2 control-label" path="firstName" cssClass="col-sm-2 control-label">First name*</sf:label>
                    <div class="col-sm-10">
                    <sf:input path="firstName" type="text" class="form-control" placeholder="Player's first name"/>
                </div>

                <sf:label cssErrorClass="errors col-sm-2 control-label" path="lastName" cssClass="col-sm-2 control-label">Last name*</sf:label>
                    <div class="col-sm-10">
                    <sf:input path="lastName" type="text" class="form-control" placeholder="Player's last name"/>
                </div>
                
                <sf:label cssErrorClass="errors col-sm-2 control-label" path="age" cssClass="col-sm-2 control-label">Age*</sf:label>
                    <div class="col-sm-10">
                    <sf:input min="0" path="age" type="number" class="form-control"/>
                </div>

                <sf:label cssErrorClass="errors col-sm-2 control-label" path="birthCountry" cssClass="col-sm-2 control-label">Country*</sf:label>
                    <div class="col-sm-10">
                    <sf:select cssClass="btn btn-default dropdown-toggle" path="birthCountry" class="form-control">
                        <sf:option value="Moldova" label="Moldova"/>
                        <sf:option value="Ukraine" label="Ukraine"/>
                        <sf:option value="Romania" label="Romania"/>
                        <sf:option value="Russia" label="Russia"/>
                        <sf:option value="Canada" label="Canada"/>
                        <sf:option value="Serbia" label="Serbia"/>
                        <sf:option value="Belarus" label="Belarus"/>
                        <sf:option value="Croatia" label="Croatia"/>
                        <sf:option value="Capo Verde" label="Capo Verde"/>
                        <sf:option value="Brazil" label="Brazil"/>
                    </sf:select>
                </div>

                <sf:label cssErrorClass="errors col-sm-2 control-label" path="position" cssClass="col-sm-2 control-label">Position*</sf:label>
                    <div class="col-sm-10">
                    <sf:select cssClass="btn btn-default dropdown-toggle" path="position" class="form-control">
                        <sf:option value="Goalkeeper" label="Goalkeeper"/>
                        <sf:option value="Defender" label="Defender"/>
                        <sf:option value="Midfielder" label="Midfielder"/>
                        <sf:option value="Forward" label="Forward"/>
                    </sf:select>
                </div> 

                <sf:label cssErrorClass="errors col-sm-2 control-label" path="salary" cssClass="col-sm-2 control-label">Annual salary*</sf:label>
                    <div class="col-sm-10">
                    <sf:input min="0" path="salary" type="number" step="any" class="form-control"/>
                </div>

                <sf:label cssErrorClass="errors col-sm-2 control-label" path="stats.games" cssClass="col-sm-2 control-label">Games*</sf:label>
                    <div class="col-sm-10">
                    <sf:input min="0" path="stats.games" type="number" class="form-control"/>
                </div>

                <sf:label cssErrorClass="errors col-sm-2 control-label" path="stats.goals" cssClass="col-sm-2 control-label">Goals*</sf:label>
                    <div class="col-sm-10">
                    <sf:input min="0" path="stats.goals" type="number" class="form-control"/>
                </div>

                <div class="col-sm-10" style="margin-left: 15em">
                    <button class="btn btn-default" type="submit">Create</button>
                    <a class="btn btn-default" href="<c:url value="/createplayer" />" style="position: absolute; margin-left: 5em;" role="button">Cancel</a>
                </div>

            </div>
        </sf:form>
        <%@include file="../jspfs/footer.jspf" %>
    </body>
</html>
