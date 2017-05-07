<%-- 
    Document   : carportDesign
    Created on : 05-05-2017, 12:44:22
    Author     : Kornh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carport Design</title>
    </head>
    <body>
            <ul id="fogNavBar">
                <li><a class="active" href="http://localhost:8080/FogExamProjectGroup5A/index.html">Home</a></li>
                <li><a href="http://localhost:8080/FogExamProjectGroup5A/chooseCarportType.jsp">Vælg Carporttype</a></li>
                <li><a href="http://localhost:8080/FogExamProjectGroup5A/customerReview.jsp">Giv anmeldelse</a></li>
                <li><a href="http://207.154.197.214:8080/TheEnd/error.html">Error</a></li>
            </ul>
        
        <h1>Her kan du designe din egen carport med fladt tag</h1>
        <%String r = (String) request.getParameter("carportType");
          double carportDesign = Integer.parseInt(r) * 100;
        %>
        <p><%=carportDesign%></p>
        <svg width="1000" height="1000">
        <rect x="50.0" y="50.0" width="<%=carportDesign%>" height="<%=carportDesign%>" fill="blue" stroke="black" stroke-width="1"/>
        </svg>
        
    </body>
</html>
