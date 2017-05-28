
package Backend;


import Backend.DataAccessObject;
import BusinessLogic.Part;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataAccessObjectTest {
    
    DataAccessObject dao;
    Connection con;
    private static String DBNAME = "fogTestDatabase";
    private static String HOST = "207.154.197.214";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String ID = "kasper";
    private static String PWD = "kasperSQL123";
    private ArrayList<Part> parts = new ArrayList<Part>();

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, ID, PWD);

            try (Statement stmt = con.createStatement()) {             
                stmt.execute("drop table if exists partHR");
                stmt.execute("create table partHR as (select * from partTest)");
            }           
            dao = new DataAccessObject(con);            
            
        } catch (ClassNotFoundException | SQLException ex) {
            con = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());;
        }
    }

    @Test
    public void testSetUpOK() {
        assertNotNull("Setup failed", con);
    }

    //Testing partHR with id 1001.
    @Test
    public void testGetPartID() {
        Part p = dao.getPartHR(1001);
        assertTrue("Get Part failed", p.getPartID()== 1001);
    }
    @Test
    public void testGetPartLength() {
        Part p = dao.getPartHR(1001);
        assertTrue("Get Part failed", p.getPartLength()== 480);
    }
    @Test
    public void testGetPartType() {
        Part p = dao.getPartHR(1001);
        assertTrue("Get Part failed", p.getPartType().equalsIgnoreCase("25x150 mm. trykimp. Bræt"));
    }

    //Testing senario where we dont get a part
    @Test
    public void testGetPartNull() {
        
        boolean catched = false;       
        try{
            Part p = dao.getPartHR(0);
            int id = p.getPartID();
        }catch(NullPointerException ex){
            catched = true;
        }
        assertTrue("Get Part failed", catched);
    }
    
    
    @Test
    public void testGetPartCount() {
        int p = dao.getPartCountHR(1000,1999);
        assertTrue("Get Part failed", p == 16);
    } 
    @Test
    public void testGetPartCountEmptyInterval() {
        int p = dao.getPartCountHR(0,999);
        assertTrue("Get Part failed", p == 0);
    } 
    @Test
    public void testGetPartCountNegativeInterval() {
        int p = dao.getPartCountHR(0,-999);
        assertTrue("Get Part failed", p == 0);
    } 
    
    @Test
    public void testGetPartListHR(){
        parts = dao.getPartListHR();
        Part p = parts.get(0);
        assertTrue("Get Part failed", p.getPartLength()== 480);
    }
    
    @Test
    public void testGetPartListHRSize(){
        parts = dao.getPartListHR();
        assertTrue("Get Part failed", parts.size() == 33);
    }
    
    @Test
    public void testCreateCustomer(){
        boolean succes = true;
        try{
        dao.createCustomer("Mr Test", "0000007", "Test.net", "testvej 2d");
        }catch(Exception e){
            succes = false;
        }
        assertTrue("Creating customer failed", succes);
    }
    
    @Test
    public void testCreateOrder(){
        boolean succes = true;
        try{
        dao.createOrder("Test.net", "Very good ordering");
        }catch(Exception e){
            succes = false;
        }
        assertTrue("Creating order failed", succes);
    }
    
    @Test
    public void testCreateReview(){
        boolean succes = true;
        try{
        dao.createReview(2);
        }catch(Exception e){
            succes = false;
        }
        assertTrue("Creating review failed", succes);
    }
}
