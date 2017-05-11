
package Data.BusinessLogic;

/**
 * This class extends carport, 
 * There seem to be devidede opnions about subclasses, but since its part of our pensum,
 * we choose to include it. 
 * 
 * @author Kasper
 */
public class CarportDUR extends Carport{
    
    public CarportDUR(double carportLength, double carportWidth, Shed sh) {
        super(carportLength, carportWidth, sh);  
    }
    
}
