<%-- 
    Document   : carportDesignFlatRoof2
    Created on : 16-05-2017, 13:10:42
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
  <script src="carportDrawing.js"></script>
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
        <li><a href="http://http://207.154.197.214:8080/FogExamProjectGroup5A/index.html">Home</a></li>
        <li><a href="https://www.johannesfog.dk/byggecenter/om-fog/">About</a></li>
        <li><a href="http://http://207.154.197.214:8080/FogExamProjectGroup5A/index.jsp">Carporte</a></li>
        <li><a href="https://johannesfog.dk/byggecenter/find-butik/">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

    <div class="container-fluid text-center">
        <h1>Her kan du designe din egen carport med Fladt Tag</h1>
        
    </div>    
        
        <div class="container-fluid text-center">
        <p>
        <div>
        <form action="FrontController" method="GET">
        <input type="number" placeholder="Carport-Længde" id="length" name="length" value="<%= request.getAttribute("length")%>">
        <input type="number" placeholder="Carport-Bredde" id="width" name="width" value="<%= request.getAttribute("width")%>">
        Med Skur:  <input type="radio" onclick="javascript:showShed();" checked="checked" name="shedChoice" id="withShed"/>
        Uden Skur: <input type="radio" onclick="javascript:showShed();" name="shedChoice" id="withoutShed"/>
        <div id="shed" style="display:block">
        <input type="number" placeholder="Skur-Bredde" id="shedLength" name="shedLength" value="<%= request.getAttribute("shedLength")%>">
        <input type="number" placeholder="Skur-Længde" id="shedWidth" name="shedWidth" value="<%= request.getAttribute("shedWidth")%>">
        </div>
        <input type="hidden" id="angle" name="angle" value="0">
        <input type="hidden" id="height" name="height" value="210">
        
        <input type="hidden" name="cmd" value="draw-carport">  
        <input type="button" value="Check Measurements" onclick="checkCarportMeasurements();">
        <input type="button" value="Download" onclick="downloadAll();"> 
        <button onclick="checkCarportMeasurements();">Tegn Carport</button>
        </form>
        </div>
        <br>
        <div>
        <form>
            <input type="hidden" name ="length" id = "length" value="<%= request.getAttribute("length")%>">
            <input type="hidden" name ="width" id = "width" value="<%= request.getAttribute("width")%>">
            <input type="hidden" name ="height" id = "height" value="<%= request.getAttribute("height")%>">
            <input type="hidden" name ="shedLength" id = "shedLength" value="<%= request.getAttribute("shedLength")%>">
            <input type="hidden" name ="shedWidth" id = "shedWidth" value="<%= request.getAttribute("shedWidth")%>">
            <input type="hidden" name ="angle" id = "angle" value="<%= request.getAttribute("angle")%>">
            <input type="hidden" name ="price" id = "price" value="1000">
            <input type="hidden" name="cmd" value="add-carport">
            <button>Tilføj til kurv</button>
        </form>
</div>
        <br>
        <div id="drawings">
        <p>
        <% SVGDrawCompleteCarport SVGDrawCompleteCarport = new SVGDrawCompleteCarport(); %>
        <%= SVGDrawCompleteCarport.drawCompleteCarport(   
                                
                    
                                (Double) request.getAttribute("length"),
                                (Double) request.getAttribute("width"),
                                (Double) request.getAttribute("height"),
                                (Double) request.getAttribute("shedLength"),
                                (Double) request.getAttribute("shedWidth"),
                                (Integer) request.getAttribute("angle")
                                
                        ) %>
        
               
        </div>                
        </p>
        
        <br>
</div>
        
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