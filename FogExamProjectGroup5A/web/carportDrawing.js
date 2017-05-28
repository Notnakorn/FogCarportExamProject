/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        function showShed(){
        
        
        if (document.getElementById('withShed').checked) {
        document.getElementById('shed').style.display = 'block';
        } else {
            document.getElementById('shed').style.display = 'none';
        var shedLength = document.getElementById("shedLength");
        shedLength.setAttribute("value", "0");
        var shedWidth = document.getElementById("shedWidth");
        shedWidth.setAttribute("value", "0");
        }    
        }

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
     
       
       function downloadAll(){
           downloadCarportSideSVG();
           downloadCarportFrontSVG();
           downloadCarportTopSVG();
       };
       
      
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
        