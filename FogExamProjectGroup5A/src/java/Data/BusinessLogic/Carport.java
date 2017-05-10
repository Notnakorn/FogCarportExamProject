

package Data.BusinessLogic;

/**
 *
 * @author kasper
 */
public class Carport {
    
    
    private double carportLength;
    private double carportWidth;
    private Shed shed;
    
    
    public Carport(double carportLength, double carportWidth, Shed sh) {
        
        if(sh != null){
            if((sh.getShedLength()+30)>carportLength || (sh.getShedWidth()+30)>carportWidth){
                throw new IllegalArgumentException(); 
            }
          this.shed = sh;  
        }
        
        if(carportLength < 240 || carportLength > 780){
            throw new IllegalArgumentException();  
            }
            else
            {
            this.carportLength = carportLength;
        }
        
        if(carportWidth < 240 || carportWidth > 750){
            throw new IllegalArgumentException();  
            }
            else
            {
            this.carportWidth = carportWidth;
        }
    }

    public double getCarportLength() {
        return carportLength;
    }

    public double getCarportWidth() {
        return carportWidth;
    }

    public Shed getShed() {
        return shed;
    }

    
}
