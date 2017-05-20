/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.SVGDrawing;
import  BusinessLogic.SVGDrawing.SVGDrawShed;
/**
 *
 * @author Kornh
 */
public class SVGDrawCompleteCarport {
    
SVGDrawShed ds = new SVGDrawShed();
SVGDrawCarport dc = new SVGDrawCarport();    

    
    
    
    public String drawCompleteCarport(double length, double width, double height, double shedLength, double shedWidth, int angle){
        
       
        StringBuilder res = new StringBuilder();
        

//        
        res.append(drawCarportFromSide(length, width, height, shedLength, angle));

        res.append(drawCarportFromFront(width, height, shedWidth, angle));
        
        res.append(drawCarportFromTop(length, width, height, shedLength, shedWidth, angle));
        
        
        
        return res.toString();
    }
    
        public String drawCarportFromSide(double length, double width, double height, double shedLength, int angle){

            StringBuilder res = new StringBuilder();
            
            double roofHeight = dc.calculateRoofHeight(width, angle);
            
            height = height + roofHeight;
            
            res.append("<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" "
                    + "id=\"carport1\" width=\"").append(length)
                    .append("\" height=\"").append(height)
                    .append("\">\n");

           
            
            res.append(ds.drawShedFromSide(length, shedLength, height, roofHeight));
            
            res.append(dc.drawCarportFromSide(length, width, height, roofHeight));

            res.append("</svg> <br>");

            return res.toString();
        }   

        public String drawCarportFromFront(double width, double height, double shedWidth, int angle){

            StringBuilder res = new StringBuilder();
            
            double roofHeight = dc.calculateRoofHeight(width, angle);
            
            height = height + roofHeight;
            
            res.append("<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" "
                    + "id=\"carport2\" width=\"").append(width)
                    .append("\" height=\"").append(height)
                    .append("\">\n");
            
            res.append(dc.drawCarportFromFront(width, height, roofHeight));

            res.append(ds.drawShedFromFront(width, shedWidth, height, roofHeight));

            res.append("</svg> <br>");

            return res.toString();
        }   

        public String drawCarportFromTop(double length, double width, double height, double shedLength, double shedWidth, int angle){

            StringBuilder res = new StringBuilder();
            
            double roofHeight = dc.calculateRoofHeight(width, angle);
            
            height = height + roofHeight;
            
            res.append("<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" id=\"carport3\" width=\"").append(width).append("\" height=\"").append(length).append("\">\n");

            res.append(dc.drawCarportFromTop(length, width, roofHeight));

            res.append(ds.drawShedFromTop(width, shedLength, shedWidth));

            res.append("</svg> <br>");

            return res.toString();
        }   
    
    
}
    
 


