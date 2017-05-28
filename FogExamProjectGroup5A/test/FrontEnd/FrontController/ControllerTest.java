/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.FrontController;

import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.CarportDUR;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Customer;
import Data.Calculator.CalculatorFacadeImpl;
import Email.SendMail;
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
public class ControllerTest {
    
    private Controller ctrl;
    private CarportHR cpHR = new CarportHR(300,300,null,25);
    private CarportHR cpHR1 = new CarportHR(600,600,null,25);
    private CarportDUR cpDUR = new CarportDUR(300,300,null);
    private Customer c = new Customer("BenteBent","0000000","bent@bent.com","Bentevej 64");

    @Before
    public void setUp() throws Exception {
        
        ctrl = new Controller();
  
    }
    

    /**
     * Test of setup method, of class Controller.
     */
    @Test
    public void testSetup() throws Exception {       
        assertNotNull(ctrl);
    }

    /**
     * Test of getPriceHR method, of class Controller.
     */
    @Test
    public void testGetPriceHR() throws Exception {
        double price = ctrl.getPriceHR(cpHR);       
        assertTrue("Price is not correct", price == 12324.0);
        
    }

    /**
     * Test of getPriceDUR method, of class Controller.
     */
    @Test
    public void testGetPriceDUR() throws Exception {
        double price = ctrl.getPriceDUR(cpDUR);
        assertTrue("will it fizz", price == 7301.0);
    }

    /**
     * Test of runHR method, of class Controller.
     */
    @Test
    public void testRunHR() {        
        boolean succes = true;
        try{               
                ctrl.runHR(cpHR, c);
        } catch(Exception e){
            succes = false;
        }
        assertTrue("Controller run failed",succes);
    }

    /**
     * Test of runDUR method, of class Controller.
     */
    @Test
    public void testRunDUR(){
        boolean succes = true;
        try{               
            ctrl.runDUR(cpDUR, c);
        } catch(Exception e){
            succes = false;
        }
        assertTrue("Controller run failed",succes);
    }

    /**
     * Test of runReview method, of class Controller.
     */
    @Test
    public void testRunReview()  {
            boolean succes = true;
        try{     
            ctrl.runReview(4);
        } catch(Exception e){
            succes = false;
        }
        assertTrue("Controller review failed",succes);
    }
    
}
