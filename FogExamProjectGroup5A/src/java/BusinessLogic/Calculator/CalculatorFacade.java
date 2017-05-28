
package BusinessLogic.Calculator;

import BusinessLogic.CarportDUR;
import BusinessLogic.CarportHR;
import BusinessLogic.Part;
import BusinessLogic.PartList;
import BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 * Holds the Calculator interface. 
 * 
 * @author Kasper and Anton
 */
public interface CalculatorFacade {
    
    public PartList calculateHRNoShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateHRWithShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateDURNoShed(ArrayList<Part> list, CarportDUR cp);
    public PartList calculateDURWithShed(ArrayList<Part> list, CarportDUR cp);
    
    
}
