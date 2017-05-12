
package Data.Calculator;

import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 * Holds the Calculator interface. 
 * 
 * @author Kasper
 */
public interface CalculatorFacade {
    
    public PartList calculateHRNoShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateHRWithShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateDURNoShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateDURWithShed(ArrayList<Part> list, CarportHR cp);
    
    
}
