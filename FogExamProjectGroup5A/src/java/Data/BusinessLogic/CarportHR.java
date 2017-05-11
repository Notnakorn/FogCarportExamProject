
package Data.BusinessLogic;

/**
 * This class extends carport, 
 * There seem to be devidede opnions about subclasses, but since its part of our pensum,
 * we choose to include it. 
 * 
 * @author Kasper
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
