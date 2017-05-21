<%-- 
    Document   : carpportDesignPointyRoof
    Created on : 05-05-2017, 12:45:27
    Author     : Kornh
--%>

<%@page import="BusinessLogic.SVGDrawing.SVGDrawCompleteCarport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Johannes Fog</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link type="text/css" rel="stylesheet" href="CSS/FogCarportCSS.css" />
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-left" href="https://www.johannesfog.dk/"><img src="Img/logo.png"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" >
      <ul class="nav navbar-nav">
        <li><a href="http://localhost:8080/FogExamProjectGroup5A/index.html">Home</a></li>
        <li><a href="https://www.johannesfog.dk/byggecenter/om-fog/">About</a></li>
        <li><a href="http://localhost:8080/FogExamProjectGroup5A/chooseCarportType.jsp">Carporte</a></li>
        <li><a href="https://johannesfog.dk/byggecenter/find-butik/">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
        
    <div class="container-fluid text-center">
    <h1>Her kan du designe din egen carport med rejsning</h1>
        
        <div>
        
        <form action= "FrontController" method="GET">
        <input type="number" placeholder="Carport-Længde" name="length" id="length" value="<%= request.getAttribute("length")%>">
        <input type="number" placeholder="Carport-Bredde" name="width" id="width" value="<%= request.getAttribute("width")%>">
        <input type="number" placeholder="Skur-Bredde" name="shedLength" id="shedLength" value="<%= request.getAttribute("shedLength")%>">
        <input type="number" placeholder="Skur-Længde" name="shedWidth" id="shedWidth" value="<%= request.getAttribute("shedWidth")%>">
        <input type="hidden" name="height" id="height" value="210" >
        
        <select type="number" name="angle" id="angle" value="">
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="25">25</option>
            <option selected="selected" value="30">30</option>
            <option value="35">35</option>
            <option value="40">40</option>
            <option value="45">45</option>
        </select>
        
        <input type="button" value="Check Measurements" onclick="checkCarportMeasurements();">
        <button onclick="checkCarportMeasurements();"> Lav Carport</button>
        <input type="button" value="Download" onclick="downloadAll();">
        <input type="hidden" name="cmd" value="draw-carport">

        </form>
        </div><br><br><br>
        
        <div>
        <form>
            <input type="hidden" name ="length" id = "length" value="<%= request.getAttribute("length")%>">
            <input type="hidden" name ="width" id = "width" value="<%= request.getAttribute("width")%>">
            <input type="hidden" name ="height" id = "height" value="<%= request.getAttribute("height")%>">
            <input type="hidden" name ="shedLength" id = "shedLength" value="<%= request.getAttribute("shedLength")%>">
            <input type="hidden" name ="shedWidth" id = "shedWidth" value="<%= request.getAttribute("shedWidth")%>">
            <input type="hidden" name ="angle" id = "angle" value="<%= request.getAttribute("angle")%>">
            <input type="hidden" name="cmd" value="add-carport">
            <button>Tilføj til kurv</button>
        </form>
        </div><br><br><br>
        
        <% SVGDrawCompleteCarport SVGDrawCompleteCarport = new SVGDrawCompleteCarport(); %>
        <%= SVGDrawCompleteCarport.drawCompleteCarport(   
                                
                    
                                (Double) request.getAttribute("length"),
                                (Double) request.getAttribute("width"),
                                (Double) request.getAttribute("height"),
                                (Double) request.getAttribute("shedLength"),
                                (Double) request.getAttribute("shedWidth"),
                                (Integer) request.getAttribute("angle")
                                
                        ) %>
        
            
</div><br>
        


 
        
        
        
        
        
        <footer class="container-fluid text-center">
    <div class="pull-left">
    Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439
</div>
<div class="pull-right">
    Alle priser er inkl. moms
</div>
</footer>
        
        
    </body>
</html>