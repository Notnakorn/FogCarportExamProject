package Data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector
{

    private Connection connection = null;
    //The DBConnector class is used solely to initiate connection to the database.

    //Constants
    private static final String IP = "207.154.197.214";
    private static final String PORT = "3306";
    public static final String DATABASE = "cupcake";
    private static final String USERNAME = "kasper";
    private static final String PASSWORD = "kasperSQL123";

    public DBConnector() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection()
    {
        return this.connection;
    }

}
