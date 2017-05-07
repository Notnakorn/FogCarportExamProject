/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Calculator;

import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 *
 * @author Katja Kaj
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
    
public ArrayList<PartListLine> calculateHRNoShed(ArrayList<Part> list, CarportHR cp){
    
        
    
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
        
        //Creates partListList for line  7
        //Description: "45x195 spærtræ ubh."
        //Length: 480
        //Usage: Remme i sider, sadles ned i stolper Skur del
       
        //Dont add anything
        
        //Creates partListList for line 8
        //Description: "45x95 Reglar ubh."
        //Length: 240
        //Usage: Løsholter i siderne af skur
       
        //Dont add anything
        
        
        //Creates partListList for line  9
        //Description: "45x95 Reglar ubh."
        //Length: 360
        //Usage: Løsholter i gavle af skur
       
        //Dont add anything
        
        
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
       
        //Dont add anything
        
        
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
       
        //Dont add anything
        
        
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
        
        return plll;
}

public ArrayList<PartListLine> calculatorHRWittShed (ArrayList<Part> list, CarportHR cp){
   
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
        
        return plll;
    
}






}

