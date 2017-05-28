
package FrontEnd;

import Backend.DBFacadeImpl;
import BusinessLogic.CarportDUR;
import BusinessLogic.CarportHR;
import BusinessLogic.Customer;
import BusinessLogic.Part;
import BusinessLogic.PartList;
import BusinessLogic.PartListLine;
import BusinessLogic.Calculator.CalculatorFacadeImpl;
import BusinessLogic.Email.SendMail;
import java.util.ArrayList;


/**
 *
 * @author Kasper and Anton
 */
public class Controller {
    
    CalculatorFacadeImpl cf;
    DBFacadeImpl dbf;
    ArrayList<Part> parts = new ArrayList<Part>();
//    SendMail sm;
    
    public void setup() throws Exception{
       
         cf = new CalculatorFacadeImpl();
        dbf = new DBFacadeImpl();
//        sm = new SendMail();
        
     
    }
    
    public double getPriceHR(CarportHR cp) throws Exception {
        double price = 0;
        
        setup();
        
        
        parts = dbf.getPartListHR();
        
        
        PartList partList = null;
       
        if(cp.getShed() != null){
          partList = cf.calculateHRWithShed(parts, cp);
        } else {
          partList = cf.calculateHRNoShed(parts, cp);
        };
        
        price = partList.getPrice();
        
        return price;
    }
    
    public double getPriceDUR(CarportDUR cp) throws Exception {
        double price = 0;
        
        setup();
        
        
        parts = dbf.getPartListDUR();
        
        
        PartList partList = null;
       
        if(cp.getShed() != null){
          partList = cf.calculateDURWithShed(parts, cp);
        } else {
          partList = cf.calculateDURNoShed(parts, cp);
        };
        
        price = partList.getPrice();
        
        return price;
    }
    
    public void runHR(CarportHR cp, Customer c) throws Exception{
        
        setup();
        
        //Creates a list with parts       
        parts = dbf.getPartListHR();
        
        
        PartList partList = null;
       
        if(cp.getShed() != null){
          partList = cf.calculateHRWithShed(parts, cp);
        } else {
          partList = cf.calculateHRNoShed(parts, cp);
        };
        
//        sm.sendEmail(partList, c);
        dbf.createCustomer(c.getCustomerName(), c.getCustomerPhoneNumber(), c.getCustomerEmail(), c.getCustomerAdress());
        dbf.createOrder(c.getCustomerEmail(), partList.toString());
        
        
    }
    
    public void runDUR(CarportDUR cp, Customer c) throws Exception{
        
        setup();
        
        //Creates a list with parts
        parts = dbf.getPartListDUR();
        
        
        PartList partList = null;
       
        if(cp.getShed() != null){
          partList = cf.calculateDURWithShed(parts, cp);
        } else {
          partList = cf.calculateDURNoShed(parts, cp);
        };
        
//        sm.sendEmail(partList, c);
        dbf.createCustomer(c.getCustomerName(), c.getCustomerPhoneNumber(), c.getCustomerEmail(), c.getCustomerAdress());
        dbf.createOrder(c.getCustomerEmail(), partList.toString());
        
        
    }
    
    public void runReview(int reviewScore)throws Exception{
        setup();
        
        dbf.createReview(reviewScore);
    }
    
    
}
