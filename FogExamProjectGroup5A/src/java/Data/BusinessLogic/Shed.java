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
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
    }

    public double getShedLength() {
        return shedLength;
    }

    public double getShedWidth() {
        return shedWidth;
    }
    
    
    
}
