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
        <input type="number" placeholder="Carport-Længde" name="length" id="length" value="">
        <input type="number" placeholder="Carport-Bredde" name="width" id="width" value="">
        <input type="number" placeholder="Skur-Bredde" name="shedLength" id="shedLength" value="">
        <input type="number" placeholder="Skur-Længde" name="shedWidth" id="shedWidth" value="">
        <input type="hidden" id="height" value="210" >
        
        
        <select id="angle" type="number" name="angle" value="">
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
        
        <input type="button" value="Download" onclick="downloadAll();">
        
        
        </p>
        
        
        
        <div id="div1">
        <svg  version="1.1" xmlns="http://www.w3.org/2000/svg" id="carport1" width="800" height="800" style="border-color: brown; border-left-width: 0;">
            
        <rect id="carportFromSideRect1" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="1" />
        <rect id="carportFromSideRect2" x="0.0" y="0.0" width="0.0" height="0.0" fill="#996633"  stroke="black" stroke-width="1"/>
        <line id="roofFromSideBottomLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#9b6c2e" stroke-width="5"/>
        <line id="roofFromSideTopLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#9b6c2e" stroke-width="5"/>
        
        <line id="frontPillarLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>
        <line id="middlePillarLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>
        <line id="backPillarLine" transform="translate(0.0,0.0)" x1="0" y1="0" x2="0" y2="0" stroke="#725a0b" stroke-width="5"/>
        
        <%         //Vertical lines
        /* for(int y = 0; y <= height; y += sizeY)
        {
            //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
            res.append("<line x1=\"0\" y1=\"").append(y).append("\" x2=\"").append(width-1)
                    .append("\" y2=\"").append(y).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");
        } */
        %>
        
        <line id="shedWood" transform=""translate=(0.0,0.0)" x1="0" y1="0" x1="0"
        
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
        <rect id="carportFromTopRect1" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5" borderleftwidth="0"/>
        <rect id="carportFromTopRect2" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX1" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX2" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX3" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX4" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX5" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX6" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX7" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX8" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX9" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareX10" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY11" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY21" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY31" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY41" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY51" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY61" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY71" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY81" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY91" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY101" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY12" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY22" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY32" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY42" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY52" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY62" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY72" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY82" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY92" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY102" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY13" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY23" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY33" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY43" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY53" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY63" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY73" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY83" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY93" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY103" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY14" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY24" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY34" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY44" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY54" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY64" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY74" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY84" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY94" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY104" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY15" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY25" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY35" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY45" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY55" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY65" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY75" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY85" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY95" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY105" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY16" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY26" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY36" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY46" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY56" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY66" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY76" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY86" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY96" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY106" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY17" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY27" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY37" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY47" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY57" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY67" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY77" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY87" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY97" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY107" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY18" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY28" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY38" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY48" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY58" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY68" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY78" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY88" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY98" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY108" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY19" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY29" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY39" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY49" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY59" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY69" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY79" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY89" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY99" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY109" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY110" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY210" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY310" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY410" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY510" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY610" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY710" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY810" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY910" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY1010" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY111" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY211" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY311" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY411" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY511" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY611" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY711" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY811" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY911" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY1011" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY112" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY212" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY312" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY412" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY512" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY612" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY712" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY812" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY912" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>
        <rect id="roofSquareY1012" x="0.0" y="0.0" width="0.0" height="0.0" fill="white"  stroke="black" stroke-width="5"/>

        
</svg>

        </svg>
        
        <input type="button" value="Download" onclick="downloadCarportTopSVG();">
        </div>
        
        
        
        
    </body>
</html>