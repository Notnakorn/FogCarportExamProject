
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
    
    CarportCalculator cc;
    DBFacadeImpl dbf;
    ArrayList<Part> list;
    SendMail sm;
    
    
    public CarportCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    

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
        Shed sh = new Shed(450,330);
        CarportHR cp = new CarportHR(480,360,sh,45);
        assertTrue("Calculator failed",cc.calculateHRNoShed(list, cp).getPartList().get(0).getCount() == 4);       
    }
    
    @Test
    public void testCalculateHRNoShedDescription() {
        Shed sh = null;
        CarportHR cp = new CarportHR(480,360,sh,45);
        assertTrue("Calculator failed",cc.calculateHRNoShed(list, cp).getPartList().get(0).getPart().getPartDescription().equalsIgnoreCase("Vindskeder på rejsning"));        
    }
    
    @Test
    public void testCalculateHRNoShedLength() {
        Shed sh = null;
        CarportHR cp = new CarportHR(480,360,sh,45);
        assertTrue("Calculator failed",cc.calculateHRNoShed(list, cp).getPartList().get(5).getPart().getPartLength() == 480);        
    }
    
    @Test
    public void testCalculateHRNoShedPrice() {
        Shed sh = null;
        CarportHR cp = new CarportHR(480,360,sh,45);
        
        PartList pl = null;
        
        pl = cc.calculateHRNoShed(list, cp);
        System.out.println(pl.toString());
        assertTrue("Calculator failed",pl.getPrice() == 1299);        
    }
    @Test
    public void testCalculateHRWithShedPrice() {
        Shed sh = new Shed(450,330);
        CarportHR cp = new CarportHR(480,360,sh,45);
        
        PartList pl = null;
        
        Customer c = new Customer("test","test","test","test");
        
        pl = cc.calculateHRWittShed(list, cp);
        System.out.println(pl.toString());
        assertTrue("Calculator failed",pl.getPrice() == 48495.0);        
    }
//    
//    /**
//     * Test of calculatorHRWittShed method, of class CarportCalculator.
//     */
//    @Test
//    public void testCalculatorHRWittShedCount() {
//        assertTrue("Calculator failed",cc.calculatorHRWittShed(list, 480, 360, 45,480,200).get(0).getCount() == 2);
//    }
//    @Test
//    public void testCalculatorHRWittShedDescription() {
//        assertTrue("Calculator failed",cc.calculatorHRWittShed(list, 480, 360, 45,480,200).get(0).getPart().getPartDescription().equalsIgnoreCase("Vindskeder på rejsning"));
//    }


   
}
