/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Calculator;

import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 *
 * @author Katja Kaj
 */
public interface CalculatorFacade {
    
    public ArrayList<PartListLine> calculateHRNoShed(ArrayList<Part> list, CarportHR cp);
    public ArrayList<PartListLine> calculateHRWithShed(ArrayList<Part> list, CarportHR cp);
    public ArrayList<PartListLine> calculateDURNoShed(ArrayList<Part> list, CarportHR cp);
    public ArrayList<PartListLine> calculateDURWithShed(ArrayList<Part> list, CarportHR cp);
    
    
}
