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
public interface CalculatorFacade {
    
    public PartList calculateHRNoShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateHRWithShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateDURNoShed(ArrayList<Part> list, CarportHR cp);
    public PartList calculateDURWithShed(ArrayList<Part> list, CarportHR cp);
    
    
}
