/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        function selectAngle(){
        var angle = parseInt(document.getElementById("angle").value);
        if(document.getElementById("angle").value === "" ||angle > 45 || angle < 15){
    
            alert("Dit taghældning skal være mindst 15 grader og max 45. Den må ikke være: " + angle + " grader.");
            return "stop";
        }
        return"go";
        }
        
        function selectWidth(){
        var width = parseFloat(document.getElementById("width").value);
        if(document.getElementById("width").value === "" ||width < 240 || width > 780)
        {
    
            alert("Din carport skal være mellem 240 og 780 cm bred. Den må ikke være: " + width  + " cm bred.");
            return "stop";
        }
        return"go";    
        }
        
        function selectLength(){
        var length = parseFloat(document.getElementById("length").value);
        if(document.getElementById("length").value === "" || length < 240 || length > 780){
    
            alert("Din carport skal være mellem 240 og 780 cm lang. Den må ikke være: " + length + " cm lang.");
            return "stop";
        }
        return"go";
        }
        
        function selectShedWidth(){
        var width = parseFloat(document.getElementById("width").value);
        var shedWidth = parseFloat(document.getElementById("shedWidth").value);
            if(document.getElementById("shedWidth").value !== "" && shedWidth > width-30){
    
            alert("Dit skur skal være min 210 cm bredt, og må ikke overskride " + (width-30) + " cm. Det må ikke være: " + shedWidth + " cm bredt.");
            return "stop";
        }
        return"go";
        }
        
        function selectShedLength(){
        var length = parseFloat(document.getElementById("length").value);
        var shedLength = parseFloat(document.getElementById("shedLength").value);
            if(document.getElementById("shedLength").value !== "" && shedLength > length-30){
    
            alert("Dit skur skal være min 210 cm langt, og må ikke overskride " + (length-30) + " cm. Det må ikke være: " + shedLength + " cm langt.");
            return "stop";
        }
        return"go";
        }
        
        function checkCarportMeasurementsRoof(){
        var checkedLength = selectLength();
            if(checkedLength === "go"){
                var checkedWidth = selectWidth();
                if(checkedWidth === "go"){
                    var checkedShedLength = selectShedLength();
                    if(checkedShedLength === "go"){
                        var checkedShedWidth = selectShedWidth();
                        if(checkedShedWidth === "go"){
                            var checkedAngle = selectAngle();
                            if(checkedAngle === "go"){
                                return "go";
                            }
                        }
                    }
                }
            }
            else {
                return confirm("stop");
            }
        }
        function checkCarportMeasurements(){
        var checkedLength = selectLength();
            if(checkedLength === "go"){
                var checkedWidth = selectWidth();
                if(checkedWidth === "go"){
                    var checkedShedLength = selectShedLength();
                    if(checkedShedLength === "go"){
                        var checkedShedWidth = selectShedWidth();
                        if(checkedShedWidth === "go"){
                                return "go";
                        }
                    }
                }
            
            }
                
            else{
                return "stop";
            }
        }
        

        function getLength(){
        var length = parseFloat(document.getElementById("length").value);
        return length;
        }
        function getWidth(){
        var width = parseFloat(document.getElementById("width").value);
        return width;
        }
        function getLength(){
        var height = parseFloat(document.getElementById("height").value);
        return length;
        }
        function getLength(){
        var length = parseFloat(document.getElementById("length").value);
        return length;
        }
        function getLength(){
        var length = parseFloat(document.getElementById("length").value);
        return length;
        }
        

        function drawCarports(){
                var measurements = "go";
                var measurements = checkCarportMeasurements();
                if (measurements === "stop"){
                    return;
                }
                else if(measurements === "go"){
                    drawCarportFromSide();
                    drawCarportFromFront();
                    drawCarportFromTop();
                }
        };
       
       function downloadAll(){
           downloadCarportSideSVG();
           downloadCarportFrontSVG();
           downloadCarportTopSVG();
       };
       
        function drawCarportFromSide(){
            

            var carport = document.getElementById("carport1");
            var carportFromSideRect1 = document.getElementById("carportFromSideRect1");
            var carportFromSideRect2 = document.getElementById("carportFromSideRect2");
            var roofFromSideBottomLine = document.getElementById("roofFromSideBottomLine");
            var roofFromSideTopLine = document.getElementById("roofFromSideTopLine");
            var frontPillarLine = document.getElementById("frontPillarLine");
            var middlePillarLine = document.getElementById("middlePillarLine");
            var backPillarLine = document.getElementById("backPillarLine");

            
            var newWidth = document.getElementById("length");
            var newHeight = document.getElementById("height");
            var newShedWidth = document.getElementById("shedWidth");
            var newShedLength = document.getElementById("shedLength");
            carport.setAttribute("height", newHeight.value*1.05);
            carport.setAttribute("width", newWidth.value*1.05);
            
            carportFromSideRect1.setAttribute("width", newWidth.value);
            carportFromSideRect1.setAttribute("height", newHeight.value);
            carportFromSideRect1.setAttribute("x", newWidth.value*0.03);
            carportFromSideRect1.setAttribute("y", newHeight.value*0.03);
            
            var shedXStartPosition = (parseFloat(newWidth.value)-parseFloat(newShedWidth.value));
            var shedYStartPosition = (newHeight.value*0.2); 
            
            
            carportFromSideRect2.setAttribute("width", newShedWidth.value*1.02);
            carportFromSideRect2.setAttribute("height",newHeight.value*0.83);
            carportFromSideRect2.setAttribute("x", shedXStartPosition);
            carportFromSideRect2.setAttribute("y", shedYStartPosition);
 
            roofFromSideBottomLine.setAttribute("x1", newWidth.value*0.03);
            roofFromSideBottomLine.setAttribute("y1", (newHeight.value*0.2)); 
            roofFromSideBottomLine.setAttribute("x2", newWidth.value*1.03);
            roofFromSideBottomLine.setAttribute("y2", (newHeight.value*0.2));
            
            roofFromSideTopLine.setAttribute("x1", newWidth.value*0.03);
            roofFromSideTopLine.setAttribute("y1", (newHeight.value*0.05)); 
            roofFromSideTopLine.setAttribute("x2", newWidth.value*1.03);
            roofFromSideTopLine.setAttribute("y2", (newHeight.value*0.05));
            
            backPillarLine.setAttribute("x1", (newWidth.value));
            var l2 = parseFloat(newHeight.value);
            var l22 = l2 + 5;
            backPillarLine.setAttribute("y1", (newHeight.value*1.03));
            backPillarLine.setAttribute("x2", (newWidth.value));
            backPillarLine.setAttribute("y2", (newHeight.value*0.2));
            
            middlePillarLine.setAttribute("x1", (newWidth.value*0.5));
            var l2 = parseFloat(newHeight.value);
            var l22 = l2 + 5;
            middlePillarLine.setAttribute("y1", (l22));
            middlePillarLine.setAttribute("x2", (newWidth.value*0.5));
            middlePillarLine.setAttribute("y2", (newHeight.value*0.2));
            
            frontPillarLine.setAttribute("x1", (newWidth.value*0.05));
            var l2 = parseFloat(newHeight.value);
            var l22 = l2 + 5;
            frontPillarLine.setAttribute("y1", (l22));
            frontPillarLine.setAttribute("x2", (newWidth.value*0.05));
            frontPillarLine.setAttribute("y2", (newHeight.value*0.2));
            
            
            
            
        };
        function drawCarportFromFront(){

            var carport = document.getElementById("carport2");
            var carportFromFrontRect1 = document.getElementById("carportFromFrontRect1");
            var roofFromFrontBottomLine = document.getElementById("roofFromFrontBottomLine");
            var roofFromFrontTopLine = document.getElementById("roofFromFrontTopLine");
            var frontPillarLeftLine = document.getElementById("frontPillarLeftLine");
            var frontPillarRightLine = document.getElementById("frontPillarRightLine");


            var newWidth = document.getElementById("width");
            var newHeight = document.getElementById("height");
            var newLength = document.getElementById("length");
            carport.setAttribute("height", newHeight.value);
            carport.setAttribute("width", newLength.value);
            carportFromFrontRect1.setAttribute("width", newWidth.value);
            carportFromFrontRect1.setAttribute("height", newHeight.value);
            carportFromFrontRect1.setAttribute("x", "5.0");
            carportFromFrontRect1.setAttribute("y", "5.0");
            
            roofFromFrontBottomLine.setAttribute("x1", "5.0");
            roofFromFrontBottomLine.setAttribute("y1", (newHeight.value*0.2)); 
            var l1 = parseFloat(newWidth.value);
            var l11 = l1 + 5;
            roofFromFrontBottomLine.setAttribute("x2", l11);
            roofFromFrontBottomLine.setAttribute("y2", (newHeight.value*0.2));
            
            roofFromFrontTopLine.setAttribute("x1", "5.0");
            roofFromFrontTopLine.setAttribute("y1", (newHeight.value*0.05)); 
            var l1 = parseFloat(newWidth.value);
            var l11 = l1 + 5;
            roofFromFrontTopLine.setAttribute("x2", l11);
            roofFromFrontTopLine.setAttribute("y2", (newHeight.value*0.05));
            
            
            frontPillarLeftLine.setAttribute("x1", (newWidth.value*0.05));
            var l2 = parseFloat(newHeight.value);
            var l22 = l2 + 5;
            frontPillarLeftLine.setAttribute("y1", (l22));
            frontPillarLeftLine.setAttribute("x2", (newWidth.value*0.05));
            frontPillarLeftLine.setAttribute("y2", (newHeight.value*0.2));
            
            frontPillarRightLine.setAttribute("x1", (newWidth.value*0.95));
            var l2 = parseFloat(newHeight.value);
            var l22 = l2 + 5;
            frontPillarRightLine.setAttribute("y1", (l22));
            frontPillarRightLine.setAttribute("x2", (newWidth.value*0.95));
            frontPillarRightLine.setAttribute("y2", (newHeight.value*0.2));
            
            
        }; 
        
//      To be done Carport from top drawing:
        
        function drawCarportFromTop(){
            
            var carport = document.getElementById("carport3");
            var carportFromTopRect1 = document.getElementById("carportFromTopRect1");
            var carportFromTopRect2 = document.getElementById("carportFromTopRect2");
            var newWidth = document.getElementById("width");
            var newHeight = document.getElementById("height");
            var newLength = document.getElementById("length");

             
             
             
            carport.setAttribute("height", newWidth.value*1.05);
            carport.setAttribute("width", newLength.value*1.05);
            
            var roofWidth = 30;
            var roofHeight = 30;
            
            carportFromTopRect1.setAttribute("width", newLength.value);
            carportFromTopRect1.setAttribute("height", newWidth.value);
            carportFromTopRect1.setAttribute("x", (newLength.value*0.03));
            carportFromTopRect1.setAttribute("y", (newWidth.value*0.03));
            
            carportFromTopRect2.setAttribute("width", (newLength.value*0.80));
            carportFromTopRect2.setAttribute("height", (newWidth.value*0.80));
            carportFromTopRect2.setAttribute("x", (newLength.value*0.13));
            carportFromTopRect2.setAttribute("y", (newWidth.value*0.13));
            
            var numberOfTilesX = (newWidth.value*0.80)/30;
            var numberOfTilesY = (newLength.value*0.80)/30;
            
            for(var x = 1; x < numberOfTilesX; x++){
               
                document.getElementById("roofSquareX" + x+"").setAttribute("x", ((newWidth.value*0.13)+(x*30-31)));
                document.getElementById("roofSquareX" + x+"").setAttribute("y", (newLength.value*0.13));
                document.getElementById("roofSquareX" + x+"").setAttribute("width", roofWidth);
                document.getElementById("roofSquareX" + x+"").setAttribute("height", roofHeight);
                document.getElementById("roofSquareX" + x+"").setAttribute("fill", "white");
                document.getElementById("roofSquareX" + x+"").setAttribute("stroke", "black");
                document.getElementById("roofSquareX" + x+"").setAttribute("stroke-width", "5");
                
                var tempX = document.getElementById("roofSquareX" + x + "").getAttribute("x");
                    
                    for(var y = 1; y < numberOfTilesY; y++){
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("x", (newWidth.value*0.13+(x*30-31)));
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("y", ((newLength.value*0.13)+(y*30-31)));
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("width", roofWidth);
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("height", roofHeight);
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("fill", "white");
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("stroke", "black");
                    document.getElementById("roofSquareY" + y+x+"").setAttribute("stroke-width", "5");
                    };
            };
           
        
    }
        
         
        
        function downloadCarportSideSVG(){
            
            var svgData = document.getElementById("carport1").outerHTML;
            var svgBlob = new Blob([svgData], {type:"image/svg+xml;charset=utf-8"});
            var svgUrl = URL.createObjectURL(svgBlob);
            var downloadLink = document.createElement("a");
            downloadLink.href = svgUrl;
            downloadLink.download = "carportSide.svg";
            document.body.appendChild(downloadLink);
            downloadLink.click();
            document.body.removeChild(downloadLink);
        };
        function downloadCarportFrontSVG(){
            
            var svgData = document.getElementById("carport2").outerHTML;
            var svgBlob = new Blob([svgData], {type:"image/svg+xml;charset=utf-8"});
            var svgUrl = URL.createObjectURL(svgBlob);
            var downloadLink = document.createElement("a");
            downloadLink.href = svgUrl;
            downloadLink.download = "carportFront.svg";
            document.body.appendChild(downloadLink);
            downloadLink.click();
            document.body.removeChild(downloadLink);
        };
        function downloadCarportTopSVG(){
            
            var svgData = document.getElementById("carport3").outerHTML;
            var svgBlob = new Blob([svgData], {type:"image/svg+xml;charset=utf-8"});
            var svgUrl = URL.createObjectURL(svgBlob);
            var downloadLink = document.createElement("a");
            downloadLink.href = svgUrl;
            downloadLink.download = "carportTop.svg";
            document.body.appendChild(downloadLink);
            downloadLink.click();
            document.body.removeChild(downloadLink);
        };
        