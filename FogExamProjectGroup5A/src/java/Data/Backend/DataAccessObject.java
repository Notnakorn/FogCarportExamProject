
package Data.Backend;


import Data.BusinessLogic.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Holds communication to the database 
 * We're using MySQL together with java to get informations from our database.
 * Our parts on the database are in 3 categories, with the partID in the intervals;
 * 1000-1999, 2000-2999 and 3000-3999. 
 * 
 * @author Kasper
 * 
 * 
 */

class DataAccessObject
{

    //The DataAccessObject class handles all requests to the server.
     private Connection con = null;
    
    public DataAccessObject(Connection con) {
        this.con = con;
    }

    //NEW due to front controller
    public DataAccessObject() {
        this.con = DBConnector.getConnection();
    }
    

    public int getPartCount(int l, int h)
    {
        int partsCount = 0;
        String SQLString
                = "select COUNT(part_ID) "
                + "from partHR "
                + "where part_ID between ? and ?";
        
        try (PreparedStatement statement = con.prepareStatement(SQLString)) {
            statement.setInt(1, l);
            statement.setInt(2, h);
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                partsCount = rs.getInt(1);
            }
            } catch (SQLException e) {
            System.out.println("Fail in DataAccessObject - getPart " + e.getMessage());
        }

        return partsCount;
    }
        
  
    public Part getPartHR(int partID) {
        Part p = null;
        String SQLString
                = "select * "
                + "from partHR "
                + "where part_ID = ?";

        try (PreparedStatement statement = con.prepareStatement(SQLString)) {
            statement.setInt(1, partID);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                p = new Part(partID,
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("Fail in DataAccessObject - getPart " + e.getMessage());
        }

        return p;
    }
    
    
    public ArrayList<Part> getPartListHR(){
            //Creates an ArrayList with parts
        ArrayList<Part> parts = new ArrayList<Part>();
        
        for (int i = 1; i <= getPartCount(1000,1999); i++){
        Part part = null;  
        part = getPartHR(1000+i);
        parts.add(part);
        }
        
        for (int i = 1; i <= getPartCount(2000,2999); i++){
        Part part = null;  
        part = getPartHR(2000+i);
        parts.add(part);
        }
        
        for (int i = 1; i <= getPartCount(3000,3999); i++){
        Part part = null;  
        part = getPartHR(3000+i);
        parts.add(part);
        }
        return parts;
    }
    
    
	
}
