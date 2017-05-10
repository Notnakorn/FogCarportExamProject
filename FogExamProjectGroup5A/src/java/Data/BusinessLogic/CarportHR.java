/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.BusinessLogic;

/**
 *
 * @author Kornh
 */
public class CarportHR extends Carport {
    
    private int angle;
    
    public CarportHR(double carportLength, double carportWidth,Shed sh, int angle) {
       
        super(carportLength, carportWidth,sh);
        if(angle < 15 || angle > 45){
            throw new IllegalArgumentException();  
        }
        else{
            this.angle = angle;
        }
    }

    public int getAngle() {
        return angle;
    }
    
}
