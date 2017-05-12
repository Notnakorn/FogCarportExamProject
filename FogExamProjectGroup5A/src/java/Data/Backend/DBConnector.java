

package Data.Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Holds connection to database 
 * You can see that we connect to our fogDatabase.
 * 
 * @author tm / recieved on gitHub
 * 
 * 
 */
public final class DBConnector {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://207.154.197.214:3306/fogDatabase";
    private static String id = "kasper";
    private static String pw = "kasperSQL123";

    /**
     *
     * @return a connection or null
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(URL, id, pw);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error in opening database constructor " + e.getMessage());
        }

        return null;
    }

}
