<%-- 
    Document   : carpportDesignPointyRoof
    Created on : 05-05-2017, 12:45:27
    Author     : Kornh
--%>

<%@page import="BusinessLogic.SVGDrawing.SVGDrawCompleteCarport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="carportDrawing.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Carport Design</title>
    </head>
         <body>
        
         
        
            <ul id="fogNavBar">
                <li><a class="active" href="http://localhost:8080/FogExamProjectGroup5A/index.html">Home</a></li>
                <li><a href="http://localhost:8080/FogExamProjectGroup5A/chooseCarportType.jsp">Vælg Carporttype</a></li>
                <li><a href="http://207.154.197.214:8080/TheEnd/order.html">Design Carport</a></li>
                <li><a href="http://localhost:8080/FogExamProjectGroup5A/customerReview.jsp">Giv anmeldelse</a></li>
                <li><a href="http://207.154.197.214:8080/TheEnd/error.html">Error</a></li>
            </ul>
        
        <h1>Bekræft order!</h1>
        
        <p>
        
        

        <form action= "FrontController" method="GET">
        <button> Køb Carport </button>
        
        <input type="hidden" name="cmd" value="order-carport">    
            
        <input type="text" placeholder="Navn" name="cName" id="cName" value="Anton">
        <input type="text" placeholder="Tlf.nr." name="cNumber" id="cNumber" value="1234">
        <input type="text" placeholder="Email" name="cEmail" id="cEmail" value="Hejsa">
        <input type="text" placeholder="Adresse" name="cAdress" id="cAdress" value="MedDigsa">
        
        <input type="hidden" name ="length" id = "length" value="<%= request.getAttribute("length")%>">
        <input type="hidden" name ="width" id = "width" value="<%= request.getAttribute("width")%>">
        <input type="hidden" name ="height" id = "height" value="<%= request.getAttribute("height")%>">
        <input type="hidden" name ="shedLength" id = "shedLength" value="<%= request.getAttribute("shedLength")%>">
        <input type="hidden" name ="shedWidth" id = "shedWidth" value="<%= request.getAttribute("shedWidth")%>">
        <input type="hidden" name ="angle" id = "angle" value="<%= request.getAttribute("angle")%>">
        
        <h3> Du har valgt en Carport med følgende mål: </h3>
        
        <h4> Længde:     <%= request.getAttribute("length")%> </h4>
        <h4> Bredde:     <%= request.getAttribute("width")%> </h4>
        <h4> Højde:      <%= request.getAttribute("height")%> </h4>
        <h4> Skurlængde: <%= request.getAttribute("shedLength")%> </h4>
        <h4> Skurbredde: <%= request.getAttribute("shedWidth")%> </h4>
        <h4> Tagvinkel:  <%= request.getAttribute("angle")%> </h4>
        <h4> Pris:  <%= request.getAttribute("price")%> </h4>
        
        <div3>
        
        <% SVGDrawCompleteCarport SVGDrawCompleteCarport = new SVGDrawCompleteCarport(); %>
        <%= SVGDrawCompleteCarport.drawCompleteCarport(   
                                
                    
                                (Double) request.getAttribute("length"),
                                (Double) request.getAttribute("width"),
                                (Double) request.getAttribute("height"),
                                (Double) request.getAttribute("shedLength"),
                                (Double) request.getAttribute("shedWidth"),
                                (Integer) request.getAttribute("angle")
                                
                        ) %>
            
        </div3>    
        
        

        

        </form>
        

        

        
        
        </p>

    </body>
</html>
