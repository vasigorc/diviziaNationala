<%-- 
    Document   : player
    Created on : Aug 11, 2015, 9:10:44 PM
    Author     : vgorcinschi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                <tr data-bind="click: function(data){selectPlayer('${player.lastName}', data)}">
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
        <!-- ko if:hasSelectedPlayer -->
        <ul class="list-group" style="width: 40%;">
            <a id="playerLink" href=""><li id="fullname" class="list-group-item list-group-item-info"></li></a>
            <li id="position" class="list-group-item"></li>
            <li id="nationality" class="list-group-item"></li>
            <li id="age" class="list-group-item"></li>
            <li class="list-group-item"><span id="games" class="badge"></span>Games:</li>
            <li class="list-group-item"><span id="goals" class="badge"></span>Goals:</li>
            <li class="list-group-item">Yearly wage: <span id="salary"></span> &#8364;</li>
        </ul>
        <!-- /ko -->
    </div>
    <%@include file="../jspfs/footer.jspf" %>
    <script src="<c:url value="/resources/js/knockout-3.3.0.js"/>"></script>
    <script src="<c:url value="/resources/js/knockout.mapping-latest.js"/>"></script>
    <script>
        function ViewModel() {
            var self = this;

//            var playerOne = {
//                "age": ko.observable(22),
//                "birthCountry": ko.observable("Moldova"),
//                "firstName": ko.observable("Dan"),
//                "id": ko.observable(3),
//                "lastName": ko.observable("Spataru"),
//                "position": ko.observable("Midfielder"),
//                "pureSalary": ko.observable(400000),
//                stats:{ 
//                "games": ko.observable(10),
//                "goals": ko.observable(1)}
//            };

            //self.player;
            self.hasSelectedPlayer = ko.observable(false);

            self.selectPlayer = function (obs) {
                //alert("You picked " + obs);
                $.ajax({
                    url: '<c:url value="/resources/player/" />' + obs,
                    type: 'GET',
                    contentType: 'application/json'
                }).success(function (data) {
                    //self.player = ko.mapping.fromJS(data, self);
                    self.hasSelectedPlayer(true);
                    $("#playerLink").attr("href", "<c:url value="/player/"/>"+data.id);
                    $("#fullname").text(data.firstName+" "+data.lastName);
                    $("#position").text(data.position);
                    $("#nationality").text("Nationality: "+data.birthCountry);
                    $("#age").text(data.age);
                    $("#games").text(data.stats.games);
                    $("#goals").text(data.stats.goals);
                    $("#salary").text(data.pureSalary);                    
                });
            };
        }
        ;
        var viewModel = new ViewModel();
        ko.applyBindings(viewModel);
    </script>
</body>
</html>
