
package Data.Backend;


import Data.BusinessLogic.Part;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Before
    public void setUp() {
        try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, ID, PWD);

            try (Statement stmt = con.createStatement()) {             
                stmt.execute("drop table if exists partTest");
                stmt.execute("create table partTest as (select * from partHR)");
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

    @Test
    public void testGetPart() {
        Part p = dao.getPartHR(1001);
        assertTrue("Get Part failed", p.getPartID()== 1001);
    }
    
    @Test
    public void testGetPartCount() {
        int p = dao.getPartCount(1000,1999);
        assertTrue("Get Part failed", p == 16);
    }    
}
