<%-- 
    Document   : carpportDesignPointyRoof
    Created on : 05-05-2017, 12:45:27
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
        
        <h1>Her kan du designe din egen carport med rejsning</h1>
        
        <p>  
        
        <form action= "FrontController" method="GET">
        <input type="number" placeholder="Carport-Længde" name="length" id="length" value="500">
        <input type="number" placeholder="Carport-Bredde" name="width" id="width" value="400">
        <input type="number" placeholder="Skur-Bredde" name="shedLength" id="shedLength" value="200">
        <input type="number" placeholder="Skur-Længde" name="shedWidth" id="shedWidth" value="350">
        <input type="hidden" id="height" name="height" value="210" >
        
        
        <select type="number" id="angle" name="angle" value="">
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="25">25</option>
            <option selected="selected" value="30">30</option>
            <option value="35">35</option>
            <option value="40">40</option>
            <option value="45">45</option>
        </select>
        
        <input type="button" value="Check Measurements" onclick="checkCarportMeasurements();">
        <button onclick="checkCarportMeasurements();"> Tegn Carport</button>
        
        <input type="hidden" name="cmd" value="draw-carport">

        </form>
        

        

        
        
        </p>

    </body>
</html>