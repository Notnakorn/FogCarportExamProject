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
public class CalculatorFacadeImpl implements CalculatorFacade {
    private CarportCalculator cc;

    public CalculatorFacadeImpl(CarportCalculator cc) {
        this.cc = cc;
    }
    
    public CalculatorFacadeImpl() throws Exception {
        this.cc = new CarportCalculator();
    }
    
    
    @Override
    public ArrayList<PartListLine> calculateHRNoShed(ArrayList<Part> list, CarportHR cp) {
        return cc.calculateHRNoShed(list, cp);
    }

    @Override
    public ArrayList<PartListLine> calculateHRWithShed(ArrayList<Part> list, CarportHR cp) {
       return cc.calculatorHRWittShed(list, cp);
    }

    @Override
    public ArrayList<PartListLine> calculateDURNoShed(ArrayList<Part> list, CarportHR cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PartListLine> calculateDURWithShed(ArrayList<Part> list, CarportHR cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
