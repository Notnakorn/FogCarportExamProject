
package FrontEnd.FrontController;

import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.CarportDUR;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Customer;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import Data.Calculator.CalculatorFacadeImpl;
import Email.SendMail;
import java.util.ArrayList;


/**
 *
 * @author Katja Kaj
 */
public class Controller {
    
    CalculatorFacadeImpl cf;
    DBFacadeImpl dbf;
    SendMail sm;
    
    public void setup() throws Exception{
       
        cf = new CalculatorFacadeImpl();
        dbf = new DBFacadeImpl();
        sm = new SendMail();
        
     
    }
    public void runHR(CarportHR cp, Customer c) throws Exception{
        
        setup();
        
        //Creates a list with parts
        ArrayList<Part> parts = new ArrayList<Part>();
        parts = dbf.getPartListHR();
        
        
        PartList partList = null;
       
        if(cp.getShed() != null){
          partList = cf.calculateHRWithShed(parts, cp);
        } else {
          partList = cf.calculateHRNoShed(parts, cp);
        };
        
        sm.sendEmail(partList, c);
        dbf.createCustomer(c.getCustomerName(), c.getCustomerPhoneNumber(), c.getCustomerEmail(), c.getCustomerAdress());
        dbf.createOrder(c.getCustomerEmail(), partList.toString());
        
        
    }
    
    public void runDUR(CarportDUR cp, Customer c) throws Exception{
        
        setup();
        
        //Creates a list with parts
        ArrayList<Part> parts = new ArrayList<Part>();
        parts = dbf.getPartListDUR();
        
        
        PartList partList = null;
       
//        if(cp.getShed() != null){
          partList = cf.calculateDURWithShed(parts, cp);
//        } else {
//          partList = cf.calculateDURNoShed(parts, cp);
//        };
        
//        sm.sendEmail(partList, c);
//        dbf.createCustomer(c.getCustomerName(), c.getCustomerPhoneNumber(), c.getCustomerEmail(), c.getCustomerAdress());
//        dbf.createOrder(c.getCustomerEmail(), partList.toString());
        
        
    }
    
    public void runReview(int reviewScore)throws Exception{
        setup();
        
        dbf.createReview(reviewScore);
    }
}
