
package Data.Calculator;

import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.Carport;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Customer;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import Data.BusinessLogic.Shed;
import Email.SendMail;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katja Kaj
 */
public class CarportCalculatorTest {
    
    private CarportCalculator cc;
    private DBFacadeImpl dbf;
    private ArrayList<Part> list;
    private SendMail sm;
    private Shed sh = new Shed(450,330);
    private CarportHR cp = new CarportHR(480,360,sh,45);
    private PartList pl = null;
    private Customer c = new Customer("test","test","test","test");


    @Before
    public void setUp() throws Exception {
        cc = new CarportCalculator();
        dbf = new DBFacadeImpl();
        sm = new SendMail();
        
        //Creates an ArrayList containing Part's for usage in this test method. 
        list = new ArrayList<Part>();
        list = dbf.getPartListHR();
      
    }

    @After
    public void tearDown() throws Exception {
    }
    
     @Test
    public void calculateRoofHeight() {     
        assertTrue("Calculator failed", cc.calculateRoofSideLength(45, 420) == 296.98);
    }

    
    
    /**
     * Test of calculateHRNoShed method, of class CarportCalculator.
     */
    @Test
    public void testCalculateHRNoShedCount() {
       int count = cc.calculateHRNoShed(list, cp).getPartList().get(0).getCount();
        assertTrue("Calculator failed", count == 4);       
    }
    
    @Test
    public void testCalculateHRNoShedDescription() {
        String d = cc.calculateHRNoShed(list, cp).getPartList().get(0).getPart().getPartDescription(); 
        assertTrue("Calculator failed",d.equalsIgnoreCase("Vindskeder på rejsning"));        
    }
    
    @Test
    public void testCalculateHRNoShedLength() {
        double l = cc.calculateHRNoShed(list, cp).getPartList().get(5).getPart().getPartLength();
        assertTrue("Calculator failed", l == 480);        
    }
    
    @Test
    public void testCalculateHRNoShedPrice() {        
        pl = cc.calculateHRNoShed(list, cp);
        assertTrue("Calculator failed",pl.getPrice() == 16499.0);        
    }
    @Test
    public void testCalculateHRWithShedPrice() {  
        pl = cc.calculateHRWittShed(list, cp);
        assertTrue("Calculator failed",pl.getPrice() == 29010.0);        
    }


   
}
