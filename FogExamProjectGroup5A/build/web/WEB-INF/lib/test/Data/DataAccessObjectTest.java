/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.Login.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Smaug
 */
public class DataAccessObjectTest {
    
    public DataAccessObjectTest() {
    }
    
     private static DataAccessObject dao;
    
      @Before
    public void setUp() {
        try {
            dao = new DataAccessObject();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessObjectTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetGlassPrice() {
        int productPrice;

        productPrice = dao.getBottomsCount();
        assertEquals(5, productPrice, 0);
        System.out.println(productPrice);
        
        String d = dao.getBottomDescription(1);
        System.out.println(d);
        
        
        User user = null;
        
        String email = "k@gmail.com";
        String password = "1234";
        user = dao.getUser(email, password);
        
        assertNotNull(user);
        System.out.println(user.getAdress());
    }
    
   
    
}
