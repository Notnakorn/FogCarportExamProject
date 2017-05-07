<%-- 
    Document   : chooseCarportType
    Created on : 04-05-2017, 15:20:54
    Author     : Kornh
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<String> carportTypes = new ArrayList<String>();
    carportTypes.add("Img/carport_Flat_Roof.jpg");
    carportTypes.add("Img/carport_Pointy_Roof.jpg"); 
%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="CSS/FogCarportCSS.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vælg carporttype</title>
        <style>
        ul#menu li 
        {
        display:inline;
        }
        </style>
    </head>
    <body>
        
        <ul id="fogNavBar">
            <li><a class="active" href="http://207.154.197.214:8080/TheEnd/index.html">Home</a></li>
            <li><a href="http://localhost:8080/FogExamProjectGroup5A/chooseCarportType.jsp">Vælg Carporttype</a></li>
            <li><a href="http://207.154.197.214:8080/TheEnd/order.html">Vælg Carportmål</a></li>
            <li><a href="http://localhost:8080/FogExamProjectGroup5A/customerReview.jsp">Giv anmeldelse</a></li>
            <li><a href="http://207.154.197.214:8080/TheEnd/error.html">Error</a></li>
        </ul>
        
        <h1>Vælg din carporttype!</h1>
        <p> Du kan vælge mellem en carport med fladt og spidst tag.

        <ul id="menu">     
        <li>    
        <%
            int count = 0;
            for(String carportType : carportTypes)
                
            {
                count++;
        %>    
                    <form action= "FrontController" method="GET">    
                        <input  name="carportType" 
                                id="carporttypeID<%=count%>" 
                                type="image" 
                                src="<%=carportType%>" 
                                width="300" 
                                height="300" 
                                alt="carport<%=count%>" 
                                value="<%=count%>"
                        >      
                        <input  type="hidden" name="cmd" value="choose-carport-type" />

                    <form/>
                
            
        <%
            }
        %>
        </li>
        </ul>

    </body>
</html>
