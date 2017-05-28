
package BusinessLogic.Calculator;

import BusinessLogic.CarportDUR;
import BusinessLogic.CarportHR;
import BusinessLogic.Part;
import BusinessLogic.PartList;
import BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 *Holds the CalculatorFacadeImpl that implements our calculatorFacade interface.
 * 
 * 
 * 
 * @author Kasper and Anton
 */
public class CalculatorFacadeImpl implements CalculatorFacade {
    private CarportCalculator cc;

    public CalculatorFacadeImpl(CarportCalculator cc) {
        this.cc = cc;
    }
    
    public CalculatorFacadeImpl() throws Exception {
        this.cc = new CarportCalculator();
    }
    
    
    @Override
    public PartList calculateHRNoShed(ArrayList<Part> list, CarportHR cp) {
        return cc.calculateHRNoShed(list, cp);
    }

    @Override
    public PartList calculateHRWithShed(ArrayList<Part> list, CarportHR cp) {
       return cc.calculateHRWittShed(list, cp);
    }

    @Override
    public PartList calculateDURNoShed(ArrayList<Part> list, CarportDUR cp) {
        return cc.calculateDURNoShed(list, cp);
    }

    @Override
    public PartList calculateDURWithShed(ArrayList<Part> list, CarportDUR cp) {
        return cc.calculateDURWithShed(list, cp);
    }

    
    
}
