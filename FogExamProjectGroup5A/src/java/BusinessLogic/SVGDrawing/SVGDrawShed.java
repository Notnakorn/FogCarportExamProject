
package BusinessLogic.SVGDrawing;


class SVGDrawShed
{

public String drawShedFromSide(double length, double shedLength, double height, double roofHeight)
        {   
        double strokeWidth = 3;    
        double sizeX = 10;
        double columns = (shedLength-1)/sizeX;
        height = (height-1);
        StringBuilder res = new StringBuilder();
        double shedStartPositionX = length-shedLength;
        double shedStartPositionY = roofHeight+30;

        
        //surrounding square
        res.append("<rect  x=\"").append(shedStartPositionX).append("\" y=\"").append(shedStartPositionY)
                .append("\" width=\"").append(shedLength).append("\" height=\"").append(height-(roofHeight+30))
                .append("\" fill=\"white\" stroke=\"black\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");
        
        //pillar at back and front of shed
        res.append("<line x1=\"").append(shedStartPositionX).append("\" y1=\"").append(31+roofHeight).append("\" x2=\"").append(shedStartPositionX)
                    .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />\n");
        
        //Horizontal lines
        double y = 0;
        for(double x = 0+shedStartPositionX; x <= shedLength+shedStartPositionX; x += sizeX)
        {
            
            res.append("<line x1=\"").append(x).append("\" y1=\"").append(31+roofHeight).append("\" x2=\"").append(x)
                    .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");
        y = x;
        }
        res.append("<line x1=\"").append(y).append("\" y1=\"").append(31+roofHeight).append("\" x2=\"").append(y)
                    .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />");
        
        
        return res.toString();
    }

    public String drawShedFromFront(double width, double shedWidth, double height, double roofHeight)
        {   
          
        double strokeWidth = 3;    
        double sizeX = 10;
        double columns = (shedWidth-1)/sizeX;
        height = (height-1);
        StringBuilder res = new StringBuilder();
        double shedStartPositionX = (width-shedWidth)/2;
        double shedStartPositionY = roofHeight;
        //Begin svg tag
//        res.append("<svg width=\"").append(shedLength).append("\" height=\"").append(height).append("\">\n");
        
        //surrounding square
        res.append("<rect  x=\"").append(shedStartPositionX).append("\" y=\"").append(shedStartPositionY+30)
                .append("\" width=\"").append(shedWidth).append("\" height=\"").append(height-30)
                .append("\" fill=\"white\" stroke=\"black\" stroke-width=\"4\" borderleftwidth=\"0\"/>)");
        
        //pillar at back and front of shed
        res.append("<line x1=\"").append(shedStartPositionX).append("\" y1=\"").append(shedStartPositionY+31).append("\" x2=\"").append(shedStartPositionX)
                    .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />\n");
        
        //Horizontal lines
        double y = 0;
        for(double x = 0+shedStartPositionX; x <= shedWidth+shedStartPositionX; x += sizeX)
        {
            
            //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
            res.append("<line x1=\"").append(x).append("\" y1=\"").append(shedStartPositionY+31).append("\" x2=\"").append(x)
                    .append("\" y2=\"").append(height).append("\" stroke=\"brown\" stroke-width:").append(strokeWidth).append("\" />\n");
        y = x;
        }
        res.append("<line x1=\"").append(y).append("\" y1=\"").append(shedStartPositionY+31).append("\" x2=\"").append(y)
                    .append("\" y2=\"").append(height).append("\" stroke=\"brown\" stroke-width:").append(5).append("\" />");
        
        //End svg tag
//        res.append("</svg>");
        
        return res.toString();
    }

    public String drawShedFromTop(double width, double shedLength, double shedWidth)
        {   
        double strokeWidth = 3;    
        double shedStartPositionX = (width-shedWidth)/2;
        
        StringBuilder res = new StringBuilder();
        
        //surrounding square
        res.append("<rect  x=\"").append(shedStartPositionX).append("\" y=\"").append(0.0)
                .append("\" width=\"").append(shedWidth).append("\" height=\"").append(shedLength)
                .append("\" fill=\"white\" fill-opacity=\"0.4\" stroke=\"gray\" stroke-width=\"4\" borderleftwidth=\"0\"/>)");
        

        return res.toString();
    }
}