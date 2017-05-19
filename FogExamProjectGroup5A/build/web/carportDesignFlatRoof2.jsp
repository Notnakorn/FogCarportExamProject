<%-- 
    Document   : carportDesignFlatRoof2
    Created on : 16-05-2017, 13:10:42
    Author     : Kornh
--%>


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
        
        <h1>Her kan du designe din egen carport med Fladt Tag</h1>
        
        <p>
        

        <input type="hidden" name="cmd" value="carport-design">
        <button>Send Forespørgsel til Fog</button>
        </form>
        
        <form action="FrontController" method="GET">
        <input type="number" placeholder="Carport-Længde" id="length" name="length" value="400">
        <input type="number" placeholder="Carport-Bredde" id="width" name="width" value="400">
        <input type="number" placeholder="Skur-Bredde" id="shedLength" name="shedLength" value="150">
        <input type="number" placeholder="Skur-Længde" id="shedWidth"name="shedWidth" value="350">

        <input type="hidden" id="height" name="height" value="210">
        <input type="hidden" id="angle" name="angle" value="0">
        
        <input type="hidden" name="cmd" value="draw-carport">
        <input type="button" value="Check Measurements" onclick="checkCarportMeasurements();">
        <button onclick="checkCarportMeasurements();"> Lav Carport</button>
        </form>
        
        
        
    </body>
</html>