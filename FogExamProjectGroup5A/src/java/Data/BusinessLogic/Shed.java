/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.BusinessLogic;

public class Shed {
    
    private double shedLength;
    private double shedWidth;

    public Shed(double shedLength, double shedWidth) {
        if(shedLength < 150 || shedLength > 750){
            throw new IllegalArgumentException(); 
        } else {
            this.shedLength = shedLength;
        }
        if(shedLength < 150 || shedLength > 720){
            throw new IllegalArgumentException(); 
        } else {
        this.shedWidth = shedWidth;
        }
    }

    public double getShedLength() {
        return shedLength;
    }

    public double getShedWidth() {
        return shedWidth;
    }
    
    
    
}
