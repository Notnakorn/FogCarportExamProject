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
        
        <h1>Her kan du designe din egen carport med fladt tag</h1>
        
        <p>
        
        <form action= "FrontController" method="GET">
        <input type="number" name="length" id="length" value="">
        <input type="number" name="width" id="width" value="">
        <input type="hidden" id="height" value="210" >
        <select id="selectedAngle" type ="number" name="angle" value="">
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="25">25</option>
            <option selected="selected" value="30">30</option>
            <option value="35">35</option>
            <option value="40">40</option>
            <option value="45">45</option>
        </select>
        <input type="button" value="Lav Carport" onclick="drawCarports();">
        
        <input type="hidden" name="cmd" value="carport-design">
        <button>Send Forespørgsel til Fog</button>
        </form>
        
        </p>
        
        
        
        <div id="div1">
        <svg  version="1.1" xmlns="http://www.w3.org/2000/svg" id="carport1" width="800" height="800" style="border-color: brown; border-left-width: 0;">
            
        <rect id="carportFromSideRect1" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" strokewidth="5" borderleftwidth="0"/>
        <line id="roofFromSideBottomLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#9b6c2e" stroke-width="5"/>
        <line id="roofFromSideTopLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#9b6c2e" stroke-width="5"/>
        
        <line id="frontPillarLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>
        <line id="middlePillarLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>
        <line id="backPillarLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>

        </svg>
        
        <input type="button" value="Download" onclick="downloadCarportSideSVG();">
        </div>
        
        <div id="div2">
        <svg  version="1.1" xmlns="http://www.w3.org/2000/svg" id="carport2" width="800" height="800" style="border-color: brown; border-left-width: 0;">
        <rect id="carportFromFrontRect1" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" strokewidth="5" borderleftwidth="0"/>
        <line id="roofFromFrontBottomLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#9b6c2e" stroke-width="5"/>
        <line id="roofFromFrontTopLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#9b6c2e" stroke-width="5"/>
        
        <line id="frontPillarLeftLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>
        <line id="frontPillarRightLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>

        </svg>
        
        <input type="button" value="Download" onclick="downloadCarportFrontSVG();">
        </div>
        
        <div id="div3">
        <svg  version="1.1" xmlns="http://www.w3.org/2000/svg" id="carport3" width="800" height="800" style="border-color: brown; border-left-width: 0;">
        <rect id="carportFromTopRect1" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" strokewidth="5" borderleftwidth="0"/>
        <rect id="carportFromTopRect2" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" strokewidth="5"/>
 

        </svg>
        
        <input type="button" value="Download" onclick="downloadCarportTopSVG();">
        </div>
        
        
    </body>
</html>
