
package Data.Calculator;

import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartListLine;
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
        
        //Creates an ArrayList containing Part's for usage in this test method. 
        list = new ArrayList<Part>();
        list = dbf.getPartListHR();  
    }

    @After
    public void tearDown() throws Exception {
    }
    
     @Test
    public void calculateRoofHeight() {     
        assertTrue("Calculator failed", cc.calculateRoofHeight(45, 420) == 296.98);
    }

    
    
    /**
     * Test of calculateHRNoShed method, of class CarportCalculator.
     */
//    @Test
//    public void testCalculateHRNoShedCount() {
//        assertTrue("Calculator failed",cc.calculateHRNoShed(list, 480, 360, 45).get(0).getCount() == 2);       
//    }
//    
//    @Test
//    public void testCalculateHRNoShedDescription() {
//        assertTrue("Calculator failed",cc.calculateHRNoShed(list, 480, 360, 45).get(0).getPart().getPartDescription().equalsIgnoreCase("Vindskeder på rejsning"));        
//    }
//    
//    @Test
//    public void testCalculateHRNoShedLength() {
//        assertTrue("Calculator failed",cc.calculateHRNoShed(list, 480, 360, 45).get(5).getPart().getPartLength() == 480);        
//    }
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
