/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        function selectAngle(){
            document.getElementById("selectedAngle").value;
        }
        function selectWidth(){
            document.getElementById("selectedWidth").value;
        }
        function selectHeight(){
            document.getElementById("selectedHeight").value;
        }

        function drawCarports(){
            
                drawCarportFromSide();
    }
       
   
        function drawCarportFromSide(){
            
            var carport = document.getElementById("carport");
            var carportFromSideRect1 = document.getElementById("carportFromSideRect1");
            var roofFromSideBottomLine = document.getElementById("roofFromSideBottomLine");
            var roofFromSideTopLine = document.getElementById("roofFromSideTopLine");
            var frontPillarLine = document.getElementById("frontPillarLine");
            var middlePillarLine = document.getElementById("middlePillarLine");
            var backPillarLine = document.getElementById("backPillarLine");
            
            
            var newWidth = document.getElementById("width");
            var newHeight = document.getElementById("height");
            carportFromSideRect1.setAttribute("width", newWidth.value);
            carportFromSideRect1.setAttribute("height", newHeight.value);
            carportFromSideRect1.setAttribute("x", "5.0");
            carportFromSideRect1.setAttribute("y", "5.0");
            
            roofFromSideBottomLine.setAttribute("x1", "5.0");
            roofFromSideBottomLine.setAttribute("y1", (newHeight.value*0.2)); 
            var l1 = parseFloat(newWidth.value);
            var l11 = l1 + 5;
            roofFromSideBottomLine.setAttribute("x2", l11);
            roofFromSideBottomLine.setAttribute("y2", (newHeight.value*0.2));
            
            roofFromSideTopLine.setAttribute("x1", "5.0");
            roofFromSideTopLine.setAttribute("y1", (newHeight.value*0.05)); 
            var l1 = parseFloat(newWidth.value);
            var l11 = l1 + 5;
            roofFromSideTopLine.setAttribute("x2", l11);
            roofFromSideTopLine.setAttribute("y2", (newHeight.value*0.05));
            
            backPillarLine.setAttribute("x1", (newWidth.value));
            var l2 = parseFloat(newHeight.value);
            var l22 = l2 + 5;
            backPillarLine.setAttribute("y1", (l22));
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
            
            
        } 
        
        function downloadSVG(){
            
            var svgData = document.getElementById("carport").outerHTML;
            var svgBlob = new Blob([svgData], {type:"image/svg+xml;charset=utf-8"});
            var svgUrl = URL.createObjectURL(svgBlob);
            var downloadLink = document.createElement("a");
            downloadLink.href = svgUrl;
            downloadLink.download = "newesttree.svg";
            document.body.appendChild(downloadLink);
            downloadLink.click();
            document.body.removeChild(downloadLink);
        }
        

