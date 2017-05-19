
package Data.Calculator;

import Data.BusinessLogic.CarportDUR;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 * Holds our CarportCalculator
 * Its a messy class, but it works. 
 * We might spends more time later adding more business logic to this class. 
 * 
 * @author Kasper
 */


class CarportCalculator {

    public CarportCalculator() {
    }
  

public double calculateRoofHeight(int carportRoofAngel, double carportWidth){
    int roofTopAngel = 180 - (2*carportRoofAngel);
    
    double a = (Math.cos(Math.toRadians(carportRoofAngel))*carportWidth)/Math.sin(Math.toRadians(roofTopAngel));
    double finalValue = Math.round( a * 100.0 ) / 100.0;
    
    return finalValue;
}    

public double calculatePrice(ArrayList<PartListLine> pll){
    
    double price = 0;
    
    for (int i = 0; i < pll.size(); i++) {
        price  = price + pll.get(i).getPart().getPartPrice();
    }
    
    return price;
}
public PartList calculateDURNoShed(ArrayList<Part> list, CarportDUR cp){
    //Creates an ArrayList with parts
        ArrayList<Part> parts = list;
        

        ArrayList<PartListLine> plll = new ArrayList<PartListLine>();
        
        PartListLine pll = null;
        
        //Calculates the count of parts in our PartList
        //Creates partListList for line 1 
        //Description: "25x150 mm. trykimp"
        //Length: 360
        //Usage: Vindskeder på rejsning
        
            pll = new PartListLine(parts.get(0),4);
        
        
        //Creates partListList for line 2
        //Description: 25x200 mm. trykimp. Brædt 
        //Length: 540
        //Usage: understernbrædder til siderne
            
            pll = new PartListLine(parts.get(1),4);
        
            
        //Creates partListList for line 3
        //Description: 25x125mm. trykimp. Brædt
        //Length: 360
        //Usage:  oversternbrædder til forenden
   
            pll = new PartListLine(parts.get(2),2);
        
            
        //Creates partListList for line 4
        //Description: 25x125mm. trykimp. Brædt
        //Length: 540
        //Usage:  oversternbrædder til siderne

             pll = new PartListLine(parts.get(3),4);
        
             
             
        //Creates partListList for line 8
        //Description: 45x195 mm. spærtræ ubh.
        //Length: 600
        //Usage:     Remme i sider, sadles ned i stolper
             
              pll = new PartListLine(parts.get(7),2);
             
        //Creates partListList for line 10
        //Description: 45x195 mm. spærtræ ubh. 
        //Length: 600
        //Usage:      Spær, monteres på rem 
        
              pll = new PartListLine(parts.get(9),15);
              
        //Creates partListList for line 11
        //Description: 97x97 mm. trykimp. Stolpe
        //Length: 300
        //Usage: Stolper nedgraves 90 cm. i jord

              pll = new PartListLine(parts.get(10),11);
        
        //Creates partListList for line 13
        //Description: 19x100 mm. trykimp. Brædt  
        //Length: 540   
        //Usage:      vandbrædt på stern i sider

            pll = new PartListLine(parts.get(12),4);
        
        //Creates partListList for line 14
        //Description: 19x100 mm. trykimp. Brædt  
        //Length: 360
        //Usage: vandbrædt på stern i forende

            pll = new PartListLine(parts.get(13),2);
        
        //Creates partListList for line 15
        //Description: Plastmo Ecolite blåtonet
        //Length: 600
        //Usage:     tagplader monteres på spær 

            pll = new PartListLine(parts.get(14),6);
        
        //Creates partListList for line 16
        //Description: Plastmo Ecolite blåtonet
        //Length: 360
        //Usage:     tagplader monteres på spær     
            
            pll = new PartListLine(parts.get(15),6);
        
        //Creates partListList for line 17
        //Description: plastmo bundskruer 200 stk.
        //Usage: Skruer til tagplader

            pll = new PartListLine(parts.get(16),3);
            
        //Creates partListList for line 18
        //Description: hulbånd 1x20 mm. 10 mtr.
        //Usage:    Til vindkryds på spær
 
            pll = new PartListLine(parts.get(17),2);
        
        //Creates partListList for line 19
        //Description: universal 190 mm højre
        //Usage:     Til montering af spær på rem

            pll = new PartListLine(parts.get(18),15);
        
        //Creates partListList for line 20
        //Description: universal 190 mm vesntre
        //Usage:     Til montering af spær på rem

            pll = new PartListLine(parts.get(19),15);    
         
        //Creates partListList for line 21
        //Description: 4,5 x 60 mm. skruer 200 stk.
        //Usage:     Til montering af stern&vandbrædt
        
            pll = new PartListLine(parts.get(20),1);  
        
        //Creates partListList for line 22
        //Description: 4,0 x 50 mm. beslagskruer 250 stk.
        //Usage: Til montering af universalbeslag + hulbånd
 
            pll = new PartListLine(parts.get(21),3);
            
        //Creates partListList for line 23
        //Description:  bræddebolt 10 x 120 mm. 
        //Usage: Til montering af rem på stolper

            pll = new PartListLine(parts.get(22),18);
            
        //Creates partListList for line 24
        //Description: firkantskiver 40x40x11mm
        //Usage: Til montering af rem på stolper

            pll = new PartListLine(parts.get(23),12);
            
        //Creates partListList for line 25
        //Description: 4,5 x 70 mm. Skruer 400 stk.
        //Usage: til montering af yderste beklædning

            pll = new PartListLine(parts.get(24),2);
        
        //Creates partListList for line 26
        //Description: 4,5 x 50 mm. Skruer 300 stk.
        //Usage: til montering af yderste beklædning

            pll = new PartListLine(parts.get(25),2);    
            
        double price = calculatePrice(plll);
        PartList partList = new PartList(plll,price);
        return partList;
        
    
}
public PartList calculateDURWithShed(ArrayList<Part> list, CarportDUR cp){
    //Creates an ArrayList with parts
        ArrayList<Part> parts = list;
        

        ArrayList<PartListLine> plll = new ArrayList<PartListLine>();
        
        PartListLine pll = null;
        
        //Calculates the count of parts in our PartList
        //Creates partListList for line 1 
        //Description: "25x150 mm. trykimp"
        //Length: 360
        //Usage: Vindskeder på rejsning
        
            pll = new PartListLine(parts.get(0),4);
        
        
        //Creates partListList for line 2
        //Description: 25x200 mm. trykimp. Brædt 
        //Length: 540
        //Usage: understernbrædder til siderne
            
            pll = new PartListLine(parts.get(1),4);
        
            
        //Creates partListList for line 3
        //Description: 25x125mm. trykimp. Brædt
        //Length: 360
        //Usage:  oversternbrædder til forenden
   
            pll = new PartListLine(parts.get(2),2);
        
            
        //Creates partListList for line 4
        //Description: 25x125mm. trykimp. Brædt
        //Length: 540
        //Usage:  oversternbrædder til siderne

             pll = new PartListLine(parts.get(3),4);
        
        //Creates partListList for line 5
        //Description: 38x73 mm. Lægte ubh.
        //Length: 420
        //Usage:    til z på bagside af dør 

            pll = new PartListLine(parts.get(4),1);
           
        
        //Creates partListList for line 6
        //Description: 45x95 mm. Reglar ub.
        //Length: 270
        //Usage:    løsholter til skur gavle 

            pll = new PartListLine(parts.get(5),12);
             
        //Creates partListList for line 7
        //Description: 45x95 mm. Reglar ub.
        //Length: 240
        //Usage:    løsholter til skur sider

             pll = new PartListLine(parts.get(6),4);
             
             
        //Creates partListList for line 8
        //Description: 45x195 mm. spærtræ ubh.
        //Length: 600
        //Usage:     Remme i sider, sadles ned i stolper
             
              pll = new PartListLine(parts.get(7),2);
              
        //Creates partListList for line 9
        //Description: 45x195 mm. spærtræ ubh.
        //Length: 480
        //Usage:    Remme i sider, sadles ned i stolper ( skur del, deles)

              pll = new PartListLine(parts.get(8),1);
             
        //Creates partListList for line 10
        //Description: 45x195 mm. spærtræ ubh. 
        //Length: 600
        //Usage:      Spær, monteres på rem 
        
              pll = new PartListLine(parts.get(9),15);
              
        //Creates partListList for line 11
        //Description: 97x97 mm. trykimp. Stolpe
        //Length: 300
        //Usage: Stolper nedgraves 90 cm. i jord

              pll = new PartListLine(parts.get(10),11);
              
        //Creates partListList for line 12
        //Description: 19x100 mm. trykimp. Brædt  
        //Length: 210
        //Usage:        til beklædning af skur 1 på 2 
  
              pll = new PartListLine(parts.get(11),200);
        
        //Creates partListList for line 13
        //Description: 19x100 mm. trykimp. Brædt  
        //Length: 540   
        //Usage:      vandbrædt på stern i sider

            pll = new PartListLine(parts.get(12),4);
        
        //Creates partListList for line 14
        //Description: 19x100 mm. trykimp. Brædt  
        //Length: 360
        //Usage: vandbrædt på stern i forende

            pll = new PartListLine(parts.get(13),2);
        
        //Creates partListList for line 15
        //Description: Plastmo Ecolite blåtonet
        //Length: 600
        //Usage:     tagplader monteres på spær 

            pll = new PartListLine(parts.get(14),6);
        
        //Creates partListList for line 16
        //Description: Plastmo Ecolite blåtonet
        //Length: 360
        //Usage:     tagplader monteres på spær     
            
            pll = new PartListLine(parts.get(15),6);
        
        //Creates partListList for line 17
        //Description: plastmo bundskruer 200 stk.
        //Usage: Skruer til tagplader

            pll = new PartListLine(parts.get(16),3);
            
        //Creates partListList for line 18
        //Description: hulbånd 1x20 mm. 10 mtr.
        //Usage:    Til vindkryds på spær
 
            pll = new PartListLine(parts.get(17),2);
        
        //Creates partListList for line 19
        //Description: universal 190 mm højre
        //Usage:     Til montering af spær på rem

            pll = new PartListLine(parts.get(18),15);
        
        //Creates partListList for line 20
        //Description: universal 190 mm vesntre
        //Usage:     Til montering af spær på rem

            pll = new PartListLine(parts.get(19),15);    
         
        //Creates partListList for line 21
        //Description: 4,5 x 60 mm. skruer 200 stk.
        //Usage:     Til montering af stern&vandbrædt
        
            pll = new PartListLine(parts.get(20),1);  
        
        //Creates partListList for line 22
        //Description: 4,0 x 50 mm. beslagskruer 250 stk.
        //Usage: Til montering af universalbeslag + hulbånd
 
            pll = new PartListLine(parts.get(21),3);
            
        //Creates partListList for line 23
        //Description:  bræddebolt 10 x 120 mm. 
        //Usage: Til montering af rem på stolper

            pll = new PartListLine(parts.get(22),18);
            
        //Creates partListList for line 24
        //Description: firkantskiver 40x40x11mm
        //Usage: Til montering af rem på stolper

            pll = new PartListLine(parts.get(23),12);
            
        //Creates partListList for line 25
        //Description: 4,5 x 70 mm. Skruer 400 stk.
        //Usage: til montering af yderste beklædning

            pll = new PartListLine(parts.get(24),2);
        
        //Creates partListList for line 26
        //Description: 4,5 x 50 mm. Skruer 300 stk.
        //Usage: til montering af yderste beklædning

            pll = new PartListLine(parts.get(25),2);    
            
        //Creates partListList for line 27
        //Description: stalddørsgreb 50x75
        //Usage:   Til lås på dør i skur

            pll = new PartListLine(parts.get(26),1);  
        
        //Creates partListList for line 28
        //Description: t hængsel 390 mm
        //Usage:    Til skurdør
        
            pll = new PartListLine(parts.get(27),2);  
        
        //Creates partListList for line 29
        //Description: vinkelbeslag 35
        //Usage:    Til montering af løsholter i skur
        
            pll = new PartListLine(parts.get(28),32);  
        
        double price = calculatePrice(plll);
        PartList partList = new PartList(plll,price);
        return partList;
        
    
}
public PartList calculateHRNoShed(ArrayList<Part> list, CarportHR cp){
    
        
    
        //Creates an ArrayList with parts
        ArrayList<Part> parts = list;
        
        //Calculates the size of the roof
        double carportRoofHeight = calculateRoofHeight(cp.getAngle(), cp.getCarportWidth());

        ArrayList<PartListLine> plll = new ArrayList<PartListLine>();
        
        PartListLine pll = null;
        
        //Calculates the count of parts in our PartList
        //Creates partListList for line 1 
        //Description: "25x150 mm. trykimp"
        //Length: 480
        //Usage: Vindskeder på rejsning
        if (cp.getCarportWidth() > 460){
            pll = new PartListLine(parts.get(0),2);
        } else {
            pll = new PartListLine(parts.get(0),4);
        }
        plll.add(pll);
        
       
        
        //Creates partListList for line 2
        //Description: "25x150 mm. trykimp. Bræt"
        //Length: 600
        //Usage: Sternbrædder til siderne Carport del
        pll = new PartListLine(parts.get(1),2);
        plll.add(pll);
        
        //Creates partListList for line 3
        //Description: "25x150 mm. trykimp. Bræt"
        //Length: 540
        //Usage: Sternbrædder til siderne Skur del ( deles )
        if (cp.getCarportLength() < 580.0){
            //Dont add anything
        } else {
            pll = new PartListLine(parts.get(2),1);
            plll.add(pll);
        }
        
        
        //Creates partListList for line  4
        //Description: "fædigskåret (byg-selv spær)"
        //Length: Undefined
        //Usage: byg-selv spær (skal samles) 8 stk.
        pll = new PartListLine(parts.get(3),2);
        plll.add(pll);
        
        //Creates partListList for line  5
        //Description: "97x97 mm. trykimp. Stolpe"
        //Length: 300
        //Usage: Stolper nedgraves 90 cm. i jord + skråstiver
            pll = new PartListLine(parts.get(4),7);
       
        plll.add(pll);
        
        //Creates partListList for line  6
        //Description: "45x195 spærtræ ubh."
        //Length: 480
        //Usage: Remme i sider, sadles ned i stolper Carport del 
        pll = new PartListLine(parts.get(5),2);
        plll.add(pll);
           
        
        //Creates partListList for line 10
        //Description: "19x100 mm. trykimp. Bræt "
        //Length: 480
        //Usage: Vand bræt på vindskeder
        if (cp.getCarportWidth() < 480.0){
            pll = new PartListLine(parts.get(9),2);
        } else {
            pll = new PartListLine(parts.get(9),4);
        }
        plll.add(pll);
        
        //Creates partListList for line  11
        //Description: "19x100 mm. trykimp. Bræt  "
        //Length: 240
        //Usage: beklædning af gavle 1 på 2 
       
            double a = (Math.ceil((0.5*carportRoofHeight*cp.getCarportWidth())/355));
            int b = (int) Math.round(a);
            pll = new PartListLine(parts.get(10), b);   
            
        plll.add(pll);

  
        //Creates partListList for line 13 
        //Description: "25x50 mm. trykimp. Bræt"
        //Length: 540
        //Usage: til montering oven på tagfodslægte
        pll = new PartListLine(parts.get(12), 3);
        plll.add(pll);
        

        //Creates partListList for line  15
        //Description: "38x73 mm. taglægte T1"
        //Length: 540
        //Usage: til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte
        pll = new PartListLine(parts.get(14), 21);
        plll.add(pll);
        
        //Creates partListList for line  16
        //Description: "38x73 mm. taglægte T1"
        //Length: 420
        //Usage: toplægte til montering af rygsten lægges i toplægte holder
        pll = new PartListLine(parts.get(15), 2);
        plll.add(pll);
        
        //Creates partListList for line  17
        //Description: "B & C Dobbelt -s sort "
        //Usage: monteres på taglægter 6 rækker af 24 sten på hver side af taget
            a = Math.ceil(((Math.sqrt(((carportRoofHeight*carportRoofHeight)+((0.5*cp.getCarportWidth())*(0.5*cp.getCarportWidth())))-3)*cp.getCarportLength())*2)/936);
            b = (int) Math.round(a);
        pll = new PartListLine(parts.get(16), b); 
        plll.add(pll);
        
        //Creates partListList for line  18
        //Description: "B & C Rygsten sort "
        //Usage: monteres på toplægte med medfølgende beslag se tagstens vejledning
            a = Math.ceil((cp.getCarportWidth()*cp.getCarportLength())/864);
            b = (int) Math.round(a);
        pll = new PartListLine(parts.get(17), b); 
        plll.add(pll);
        
        //Creates partListList for line  19
        //Description: "B & C Toplægte holder"
        //Usage: monteres på toppen af spæret (til toplægte)
        pll = new PartListLine(parts.get(18), 8); 
        plll.add(pll);
        
        //Creates partListList for line  20
        //Description: "B & C rygstensbeslag"
        //Usage: Til montering af rygsten
            a = Math.ceil((cp.getCarportWidth()*cp.getCarportLength())/864);
            b = (int) Math.round(a);
        pll = new PartListLine(parts.get(19), b); 
        plll.add(pll);
        
        //Creates partListList for line  21
        //Description: "B & C tagstens bindere & nakkekroge"
        //Usage: til montering af tagsten, alle ydersten + hver anden fastgøres
        pll = new PartListLine(parts.get(20), 2); 
        plll.add(pll);
        
        //Creates partListList for line  22
        //Description: "universal 190 mm højre"
        //Usage: Til montering af spær på rem
        pll = new PartListLine(parts.get(21), 8); 
        plll.add(pll);
        
        //Creates partListList for line  23
        //Description: "universal 190 mm venstre"
        //Usage: Til montering af spær på rem
        pll = new PartListLine(parts.get(22), 8); 
        plll.add(pll);
        
        //Creates partListList for line  24
        //Description: "Stalddørsgreb 50x75"
        //Usage:til dør i skur
       
        //Dont add anything
        
        
        //Creates partListList for line  25
        //Description: "T-hængsel 390 mm."
        //Usage: til dør i skur
       
        //Dont add anything
        
        
        //Creates partListList for line  26
        //Description: "vinkelbeslag"
        //Usage: til montering af løsholter
        pll = new PartListLine(parts.get(25), 20); 
        plll.add(pll);
        
        //Creates partListList for line  27
        //Description: "4,5 x 60 mm. Skruer 200 stk."
        //Usage: Til montering af Stern, vindskeder, vindkryds & vand bræt
        pll = new PartListLine(parts.get(26), 1); 
        plll.add(pll);
        
        //Creates partListList for line  28
        //Description: "5,0 x 40 mm. beslagskruer 250 stk."
        //Usage: Til montering af universalbeslag + toplægte
        pll = new PartListLine(parts.get(27), 1); 
        plll.add(pll);
                
        //Creates partListList for line 29
        //Description: "5,0 x 100 mm. skruer 100 stk. "
        //Usage: til taglægter
        pll = new PartListLine(parts.get(28), 2); 
        plll.add(pll);
        
        //Creates partListList for line 30
        //Description: " bræddebolt 10 x 120 mm."
        //Usage: Til montering af rem på stolper
        pll = new PartListLine(parts.get(29), 20); 
        plll.add(pll);
        
        //Creates partListList for line 31
        //Description: "firkantskiver 40x40x11mm"
        //Usage: Til montering af rem på stolper
        pll = new PartListLine(parts.get(30), 20); 
        plll.add(pll);
        
        //Creates partListList for line 32
        //Description: "4,5 x 70 mm. Skruer 200 stk."
        //Usage: til montering af yderste bræt ved beklædning
        pll = new PartListLine(parts.get(31), 3); 
        plll.add(pll);
        
        //Creates partListList for line 33
        //Description: "4,5 x 50 mm. Skruer 350 stk."
        //Usage: til montering af inderste bræt ved beklædning 
        pll = new PartListLine(parts.get(32), 2); 
        plll.add(pll);
        
        double price = calculatePrice(plll);
        PartList partList = new PartList(plll,price);
        return partList;
}

public PartList calculateHRWittShed (ArrayList<Part> list, CarportHR cp){
   
       //Creates an ArrayList with parts
        ArrayList<Part> parts = list;
        
        //Calculates the size of the roof
        double carportRoofHeight = calculateRoofHeight(cp.getAngle(), cp.getCarportWidth());

        ArrayList<PartListLine> plll = new ArrayList<PartListLine>();
        
        PartListLine pll = null;
   
        //Calculates the count of parts in our PartList
        //Creates partListList for line 1 
        //Description: "25x150 mm. trykimp"
        //Length: 480
        //Usage: Vindskeder på rejsning
        if (cp.getCarportWidth() > 460){
            pll = new PartListLine(parts.get(0),2);
        } else {
            pll = new PartListLine(parts.get(0),4);
        }
        plll.add(pll);
        
       
        
        //Creates partListList for line 2
        //Description: "25x150 mm. trykimp. Bræt"
        //Length: 600
        //Usage: Sternbrædder til siderne Carport del
        pll = new PartListLine(parts.get(1),2);
        plll.add(pll);
        
        //Creates partListList for line 3
        //Description: "25x150 mm. trykimp. Bræt"
        //Length: 540
        //Usage: Sternbrædder til siderne Skur del ( deles )
        if (cp.getCarportLength() < 580.0){
            pll = new PartListLine(parts.get(2),0);
        } else {
            pll = new PartListLine(parts.get(2),1);
        }
        plll.add(pll);
        
        //Creates partListList for line  4
        //Description: "fædigskåret (byg-selv spær)"
        //Length: Undefined
        //Usage: byg-selv spær (skal samles) 8 stk.
        pll = new PartListLine(parts.get(3),2);
        plll.add(pll);
        
        //Creates partListList for line  5
        //Description: "97x97 mm. trykimp. Stolpe"
        //Length: 300
        //Usage: Stolper nedgraves 90 cm. i jord + skråstiver
       
            pll = new PartListLine(parts.get(4),9);

        plll.add(pll);
        
        //Creates partListList for line  6
        //Description: "45x195 spærtræ ubh."
        //Length: 480
        //Usage: Remme i sider, sadles ned i stolper Carport del 
        pll = new PartListLine(parts.get(5),2);
        plll.add(pll);
        
        //Creates partListList for line  7
        //Description: "45x195 spærtræ ubh."
        //Length: 480
        //Usage: Remme i sider, sadles ned i stolper Skur del
        
            pll = new PartListLine(parts.get(6),1);
       
        plll.add(pll);
        
        //Creates partListList for line 8
        //Description: "45x95 Reglar ubh."
        //Length: 240
        //Usage: Løsholter i siderne af skur
        if (cp.getShed().getShedLength() > 220){
            pll = new PartListLine(parts.get(7),8);
        }else {
            pll = new PartListLine(parts.get(7),4);      
        } 
        plll.add(pll);
        
        //Creates partListList for line  9
        //Description: "45x95 Reglar ubh."
        //Length: 360
        //Usage: Løsholter i gavle af skur
        if (cp.getShed().getShedWidth() > 360){
            pll = new PartListLine(parts.get(8),12);
        }else {
            pll = new PartListLine(parts.get(8),6);      
        } 
        plll.add(pll);
        
        //Creates partListList for line 10
        //Description: "19x100 mm. trykimp. Bræt "
        //Length: 480
        //Usage: Vand bræt på vindskeder
        if (cp.getCarportWidth() < 480.0){
            pll = new PartListLine(parts.get(9),2);
        } else {
            pll = new PartListLine(parts.get(9),4);
        }
        plll.add(pll);
        
        //Creates partListList for line  11
        //Description: "19x100 mm. trykimp. Bræt  "
        //Length: 240
        //Usage: beklædning af gavle 1 på 2 
       
            double a = (Math.ceil((0.5*carportRoofHeight*cp.getCarportWidth())/355));
            int b = (int) Math.round(a);
            pll = new PartListLine(parts.get(10), b);   
            
        plll.add(pll);

        //Creates partListList for line  12
        //Description: "19x100 mm. trykimp. Bræt  "
        //Length: 210
        //Usage: Beklædning af skur 1 på 2 
       
            a = Math.ceil((cp.getShed().getShedLength()*2+cp.getShed().getShedWidth()*2)/7.3);
            b = (int) Math.round(a);
            pll = new PartListLine(parts.get(11), b); 
        
        plll.add(pll);
         
        //Creates partListList for line 13 
        //Description: "25x50 mm. trykimp. Bræt"
        //Length: 540
        //Usage: til montering oven på tagfodslægte
        pll = new PartListLine(parts.get(12), 3);
        plll.add(pll);
        
        //Creates partListList for line 14
        //Description: "38x73 mm. taglægte T1"
        //Length: 540   
        //Usage: til z på bagside af dør
        
            pll = new PartListLine(parts.get(13), 1);
        
        plll.add(pll);
       
        //Creates partListList for line  15
        //Description: "38x73 mm. taglægte T1"
        //Length: 540
        //Usage: til montering på spær, 7 rækker lægter på hver skiftevis 1 hel & 1 halv lægte
        pll = new PartListLine(parts.get(14), 21);
        plll.add(pll);
        
        //Creates partListList for line  16
        //Description: "38x73 mm. taglægte T1"
        //Length: 420
        //Usage: toplægte til montering af rygsten lægges i toplægte holder
        pll = new PartListLine(parts.get(15), 2);
        plll.add(pll);
        
        //Creates partListList for line  17
        //Description: "B & C Dobbelt -s sort "
        //Usage: monteres på taglægter 6 rækker af 24 sten på hver side af taget
            a = Math.ceil(((Math.sqrt(((carportRoofHeight*carportRoofHeight)+((0.5*cp.getCarportWidth())*(0.5*cp.getCarportWidth())))-3)*cp.getCarportLength())*2)/936);
            b = (int) Math.round(a);
        pll = new PartListLine(parts.get(16), b); 
        plll.add(pll);
        
        //Creates partListList for line  18
        //Description: "B & C Rygsten sort "
        //Usage: monteres på toplægte med medfølgende beslag se tagstens vejledning
            a = Math.ceil((cp.getCarportWidth()*cp.getCarportLength())/864);
            b = (int) Math.round(a);
        pll = new PartListLine(parts.get(17), b); 
        plll.add(pll);
        
        //Creates partListList for line  19
        //Description: "B & C Toplægte holder"
        //Usage: monteres på toppen af spæret (til toplægte)
        pll = new PartListLine(parts.get(18), 8); 
        plll.add(pll);
        
        //Creates partListList for line  20
        //Description: "B & C rygstensbeslag"
        //Usage: Til montering af rygsten
            a = Math.ceil((cp.getCarportWidth()*cp.getCarportLength())/864);
            b = (int) Math.round(a);
        pll = new PartListLine(parts.get(19), b); 
        plll.add(pll);
        
        //Creates partListList for line  21
        //Description: "B & C tagstens bindere & nakkekroge"
        //Usage: til montering af tagsten, alle ydersten + hver anden fastgøres
        pll = new PartListLine(parts.get(20), 2); 
        plll.add(pll);
        
        //Creates partListList for line  22
        //Description: "universal 190 mm højre"
        //Usage: Til montering af spær på rem
        pll = new PartListLine(parts.get(21), 8); 
        plll.add(pll);
        
        //Creates partListList for line  23
        //Description: "universal 190 mm venstre"
        //Usage: Til montering af spær på rem
        pll = new PartListLine(parts.get(22), 8); 
        plll.add(pll);
        
        //Creates partListList for line  24
        //Description: "Stalddørsgreb 50x75"
        //Usage:til dør i skur
       
            pll = new PartListLine(parts.get(23), 1);
        
        plll.add(pll);
        
        //Creates partListList for line  25
        //Description: "T-hængsel 390 mm."
        //Usage: til dør i skur
        
            pll = new PartListLine(parts.get(24), 1);
       
        plll.add(pll);
        
        //Creates partListList for line  26
        //Description: "vinkelbeslag"
        //Usage: til montering af løsholter
        pll = new PartListLine(parts.get(25), 20); 
        plll.add(pll);
        
        //Creates partListList for line  27
        //Description: "4,5 x 60 mm. Skruer 200 stk."
        //Usage: Til montering af Stern, vindskeder, vindkryds & vand bræt
        pll = new PartListLine(parts.get(26), 1); 
        plll.add(pll);
        
        //Creates partListList for line  28
        //Description: "5,0 x 40 mm. beslagskruer 250 stk."
        //Usage: Til montering af universalbeslag + toplægte
        pll = new PartListLine(parts.get(27), 1); 
        plll.add(pll);
                
        //Creates partListList for line 29
        //Description: "5,0 x 100 mm. skruer 100 stk. "
        //Usage: til taglægter
        pll = new PartListLine(parts.get(28), 2); 
        plll.add(pll);
        
        //Creates partListList for line 30
        //Description: " bræddebolt 10 x 120 mm."
        //Usage: Til montering af rem på stolper
        pll = new PartListLine(parts.get(29), 20); 
        plll.add(pll);
        
        //Creates partListList for line 31
        //Description: "firkantskiver 40x40x11mm"
        //Usage: Til montering af rem på stolper
        pll = new PartListLine(parts.get(30), 20); 
        plll.add(pll);
        
        //Creates partListList for line 32
        //Description: "4,5 x 70 mm. Skruer 200 stk."
        //Usage: til montering af yderste bræt ved beklædning
        pll = new PartListLine(parts.get(31), 3); 
        plll.add(pll);
        
        //Creates partListList for line 33
        //Description: "4,5 x 50 mm. Skruer 350 stk."
        //Usage: til montering af inderste bræt ved beklædning 
        pll = new PartListLine(parts.get(32), 2); 
        plll.add(pll);
        
        
        double price = calculatePrice(plll);
        PartList partList = new PartList(plll,price);
        return partList;
}






}

