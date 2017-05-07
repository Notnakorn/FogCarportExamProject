<%-- 
    Document   : customerReviewJSP
    Created on : Apr 25, 2017, 2:14:30 PM
    Author     : Anton
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String veryHappy = new String("Img/Very_Happy_Smiley.png");
    String Happy = new String("Img/Happy_Smiley.png");
    String Sad = new String("Img/Sad_Smiley.png");
    String verySad = new String("Img/Very_Sad_Smiley.png");    
            
    List<String> smileys = new ArrayList<String>();
    smileys.add(veryHappy);
    smileys.add(Happy);
    smileys.add(Sad);
    smileys.add(verySad);
%>

<!DOCTYPE html>
<html>
    <head>
        <style>
            ul#menu li {
            display:inline;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html/; charset=UTF-8">
        <title>Customer Review Page</title>
    </head>
    <body>
        
            <ul id="fogNavBar">
                <li><a class="active" href="http://localhost:8080/FogExamProjectGroup5A/index.html">Home</a></li>
                <li><a href="http://localhost:8080/FogExamProjectGroup5A/chooseCarportType.jsp">Vælg Carporttype</a></li>
                <li><a href="http://207.154.197.214:8080/TheEnd/order.html">Vælg Carportmål</a></li>
                <li><a href="http://localhost:8080/FogExamProjectGroup5A/customerReview.jsp">Giv anmeldelse</a></li>
                <li><a href="http://207.154.197.214:8080/TheEnd/error.html">Error</a></li>
            </ul>
        
        <h1>Tak fordi du bestilte hos Johannes Fog - hvor tilfreds var du med dit besøg på vores side?</h1>
 
        <ul id="menu">   
            
            <li>

            <%
            int count = 0;
            for(String smiley : smileys)
                
            {
                count++;
            %>
                    <form action= "FrontController" method="GET">    
                        <input  name="smiley" id="smileyID<%=count%>" type="image" 
                                src="<%=smiley%>" 
                                width="77" 
                                height="76" 
                                alt="Smiley<%=count%>" 
                                value="<%=count%>"
                        >      
                        <input  type="hidden" name="cmd" value="customer-review" />

                    <form/>
                
            
            <%
                }
            %>
        </li>
        </ul>
        

    </body>
</html>
