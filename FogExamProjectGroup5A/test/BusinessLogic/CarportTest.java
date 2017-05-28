/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

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
public class CarportTest {
 
    Shed sh = null;
    
    /**
     * Test of getCarportLength method, of class Carport.
     */
    @Test
    public void testCarportValidSize() {
       boolean succes = true;
       try{
       Carport c = new Carport(600,600,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertTrue("Failed to construct carport", succes);
    }
    
    @Test
    public void testCarportInvalidLengthSize() {
       boolean succes = true;
       try{
       Carport c = new Carport(800,600,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }

    @Test
    public void testCarportInvalidWidthSize() {
       boolean succes = true;
       try{
       Carport c = new Carport(600,800,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }
    
    @Test
    public void testCarportNoSize() {
       boolean succes = true;
       try{
       Carport c = new Carport(0,0,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }
    
    @Test
    public void testCarportNoSizeValidLength() {
       boolean succes = true;
       try{
       Carport c = new Carport(600,0,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }
    
    @Test
    public void testCarportNoSizeValidWidth() {
       boolean succes = true;
       try{
       Carport c = new Carport(0,600,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }
    
    @Test
    public void testCarportNegativeSizeWithinValidSize() {
       boolean succes = true;
       try{
       Carport c = new Carport(-400,-400,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }
    @Test
    public void testCarportNegativeSize() {
       boolean succes = true;
       try{
       Carport c = new Carport(-100,-100,sh);
       } catch (Exception ex){
           succes = false;
       }
        assertFalse("Failed to construct carport", succes);
    }
    
    
}
