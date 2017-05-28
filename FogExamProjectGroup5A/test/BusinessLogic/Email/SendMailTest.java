/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Email;

import BusinessLogic.Email.SendMail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasper and Anton
 */
public class SendMailTest {
    
       
        SendMail sm;
    
    public SendMailTest() {
    }
    

    @Before
    public void setUp() {  
        sm = new SendMail();
    }
 

    /**
     * Test of main method, of class SendMail.
     */
    @Test
    public void testMain() {
        System.out.println("Testing email-system");
    }
    

    
}
