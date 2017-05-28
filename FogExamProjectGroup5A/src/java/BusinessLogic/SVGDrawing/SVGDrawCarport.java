/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.SVGDrawing;

/**
 *
 * @author Kasper and Anton
 */
public class SVGDrawCarport {
    
  
    
    
    public String drawCarportFromSide(double length, double width, double height, double roofHeight){   

            double FrontPillarX = length*0.05;
            double middlePillarX = length*0.50;
            double backPillarX = length-3;
            StringBuilder res = new StringBuilder();
            
            
            //roof
            if(roofHeight > 0)
            {   
            res.append("<rect  x=\"0.0\" y=\"0.0\" width=\"").append(length).append("\" height=\"").append(roofHeight).append("\" fill=\"white\" fill-opacity=\"1.0\" stroke=\"red\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");
            }

            //surrounding square
            res.append("<rect  x=\"0.0\" y=\"").append(roofHeight).append("\" width=\"").append(length).append("\" height=\"").append(height-roofHeight).append("\" fill=\"white\" fill-opacity=\"0.0\" stroke=\"grey\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");

            //woodbeam as roof
            res.append("<rect  x=\"0.0\" y=\"").append(roofHeight).append("\" width=\"").append(length).append("\" height=\"").append(30).append("\" fill=\"white\" stroke=\"black\" stroke-width=\"5\" borderleftwidth=\"0\"/>)");


            //FrontPillar
            res.append("<line x1=\"").append(FrontPillarX).append("\" y1=\"").append(roofHeight+31).append("\" x2=\"").append(FrontPillarX)
                        .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />\n");
            //MiddlePillar
            res.append("<line x1=\"").append(middlePillarX).append("\" y1=\"").append(roofHeight+31).append("\" x2=\"").append(middlePillarX)
                        .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />\n");
            //BackPillar
            res.append("<line x1=\"").append(backPillarX).append("\" y1=\"").append(roofHeight+31).append("\" x2=\"").append(backPillarX)
                        .append("\" y2=\"").append(height).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />\n");


            return res.toString();
    }

    public String drawCarportFromFront(double width, double height, double roofHeight){   


            StringBuilder res = new StringBuilder();
            
           
            if(roofHeight > 0)
            {   
            double widthMiddle = width/2;
            
            res.append("<line x1=\"").append(widthMiddle).append("\" y1=\"").append(0.5).append("\" x2=\"").append(0.0)
                        .append("\" y2=\"").append(roofHeight).append("\" stroke=\"red\" stroke-width:").append(1).append("\" />\n");
            res.append("<line x1=\"").append(widthMiddle).append("\" y1=\"").append(0.5).append("\" x2=\"").append(width)
                        .append("\" y2=\"").append(roofHeight).append("\" stroke=\"red\" stroke-width:").append(1).append("\" />\n");
            }
    //        //surrounding square
            res.append("<rect  x=\"").append(0.0).append("\" y=\"").append(roofHeight).append("\" width=\"").append(width).append("\" height=\"").append(height).append("\" fill=\"white\" stroke=\"black\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");
    //        
            //woodbeam as roof
            res.append("<line x1=\"").append(0.0).append("\" y1=\"").append(roofHeight + 30).append("\" x2=\"").append(width)
                        .append("\" y2=\"").append(roofHeight + 30).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(5).append("\" />\n");


            return res.toString();
    }

    public String drawCarportFromTop(double length, double width, double roofHeight)
            {   
            double strokeWidth = 3;    
            double sizeX = 10;
            double columns = (width-1)/sizeX;
            StringBuilder res = new StringBuilder();

    //        //surrounding square
            
            res.append("<rect  x=\"0.0\" y=\"0.0\" width=\"").append(width).append("\" height=\"").append(length).append("\" fill=\"white\" stroke=\"black\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");

            if(roofHeight > 0){
                double widthMiddle = width/2;
                sizeX = 12;
                res.append("<rect  x=\"").append(widthMiddle-10).append("\" y=\"0.0\" width=\"").append(20).append("\" height=\"").append(length).append("\" fill=\"white\" stroke=\"black\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");

                for(double x = 0; x <= length; x += sizeX)
                    {

                        //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
                        res.append("<line x1=\"").append(widthMiddle+10).append("\" y1=\"").append(x).append("\" x2=\"").append(width)
                                .append("\" y2=\"").append(x).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");

                    }
                

                for(double x = 0; x <= length; x += sizeX)
                    {

                        //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
                        res.append("<line x1=\"").append(0.0).append("\" y1=\"").append(x).append("\" x2=\"").append(widthMiddle-10)
                                .append("\" y2=\"").append(x).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");

                    }
                
                sizeX = 20;
                for(double x = 0; x <= widthMiddle-10; x += sizeX)
                    
                {

                        //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
                        res.append("<line x1=\"").append(x).append("\" y1=\"0\" x2=\"").append(x)
                                .append("\" y2=\"").append(length-1).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");

                }
                
                
                
                
                
                for(double x = width; x >= widthMiddle+10; x -= sizeX)
                    {

                        //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
                        res.append("<line x1=\"").append(x).append("\" y1=\"0\" x2=\"").append(x)
                                .append("\" y2=\"").append(length-1).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");

                    }
                
            
            }
            else{
                for(double x = 0; x <= width; x += sizeX)
                {

                    //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(0,0,0);stroke-width:1" />
                    res.append("<line x1=\"").append(x).append("\" y1=\"0\" x2=\"").append(x)
                            .append("\" y2=\"").append(length-1).append("\" style=\"stroke:rgb(0,0,0);stroke-width:").append(strokeWidth).append("\" />\n");

                }
            }

            return res.toString();
    }

    public double calculateRoofHeight(double width, int angle){

        double roofHeight = 0;

            if(angle > 0)
            {   
                int topAngle = 90-angle;
                double topRadians = (double) Math.toRadians(topAngle);
                double widthMiddle = width/2;
                roofHeight = widthMiddle/(Math.tan(topRadians));

    //          res.append("<rect  x=\"0.0\" y=\"0.0\" width=\"").append(length).append("\" height=\"").append(roofHeight).append("\" fill=\"white\" fill-opacity=\"0.0\" stroke=\"grey\" stroke-width=\"3\" borderleftwidth=\"0\"/>)");
            }
            return roofHeight;


    }

}