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
    
    Controller ctrl;
    CarportHR cpHR = new CarportHR(300,300,null,25);
    CarportDUR cpDUR = new CarportDUR(300,300,null);
    Customer c = new Customer("BenteBent","0000000","bent@bent.com","Bentevej 64");

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
        
        assertTrue("will it fizz", ctrl.getPriceHR(cpHR) == 1299.0);
        
    }

    /**
     * Test of getPriceDUR method, of class Controller.
     */
    @Test
    public void testGetPriceDUR() throws Exception {
       
         assertTrue("will it fizz", ctrl.getPriceDUR(cpDUR) == 1198.0);
    }

    /**
     * Test of runHR method, of class Controller.
     */
    @Test
    public void testRunHR() throws Exception {
        ctrl.runHR(cpHR, c);
    }

    /**
     * Test of runDUR method, of class Controller.
     */
    @Test
    public void testRunDUR() throws Exception {
        ctrl.runDUR(cpDUR, c);
    }

    /**
     * Test of runReview method, of class Controller.
     */
    @Test
    public void testRunReview() throws Exception {
        ctrl.runReview(4);
    }
    
}
