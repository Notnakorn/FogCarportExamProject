
package FrontEnd;

import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import Data.Calculator.CalculatorFacadeImpl;
import java.util.ArrayList;


/**
 *
 * @author Katja Kaj
 */
public class Controller {
    
    CalculatorFacadeImpl cf;
    DBFacadeImpl dbf;
    
    public void setup() throws Exception{
       
         cf = new CalculatorFacadeImpl();
        dbf = new DBFacadeImpl();
        
     
    }
    public void runHR(CarportHR cp) throws Exception{
        
        setup();
        
        ArrayList<Part> parts = new ArrayList<Part>();
        
        PartList partList = null;
        
        
        parts = dbf.getPartListHR();
        
        if(cp.getShed() != null){
          partList = cf.calculateHRWithShed(parts, cp);
        } else {
//          partList = cf.calculateHRNoShed(lp, cp);
        };
        
        
      
        
        
    }
    
}
