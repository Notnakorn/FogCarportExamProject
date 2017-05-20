package Data;


import Data.Login.User;
import Data.Product.Cupcake;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObject
{

    //The DataAccessObject class handles all requests to the server.
    private final DBConnector conn;

    public DataAccessObject() throws Exception
    {
        this.conn = new DBConnector();
    }

    // Get price of a bottom
    public double getBottomPrice(int bno)
    {
        Statement stmt;
        double bottomPrice = 0;
        try
        {
            stmt = conn.getConnection().createStatement();
            String sql = "select PRICE from bottoms where bno = " + bno;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                bottomPrice = rs.getDouble("PRICE");

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bottomPrice;
    }
        // Get price of a topping
    public double getToppingPrice(int tno)
    {
        Statement stmt;
        double toppingPrice = 0;
        try
        {
            stmt = conn.getConnection().createStatement();
            String sql = "select PRICE from toppings where tno = " + tno;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                toppingPrice = rs.getDouble("PRICE");

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toppingPrice;
    }
    
    
    //Get bottom description
    public String getBottomDescription(int bno)
    {
        Statement stmt;
        String bottomDescription = "";
        try
        {
            stmt = conn.getConnection().createStatement();
            String sql = "select description from bottoms where bno = " + bno;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                bottomDescription = rs.getString("DESCRIPTION");

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bottomDescription;
    }
    
        //Get bottom description
    public String getToppingDescription(int tno)
    {
        Statement stmt;
        String toppingsDescription = "";
        try
        {
            stmt = conn.getConnection().createStatement();
            String sql = "select description from toppings where tno = " + tno;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                toppingsDescription = rs.getString("DESCRIPTION");

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toppingsDescription;
    }
    
    public int getBottomsCount()
    {
        Statement stmt = null;
        int bottomsCount = 0;
        try
        {

            stmt = conn.getConnection().createStatement();
            String sql = "select COUNT(bno) from bottoms";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                bottomsCount = rs.getInt("COUNT(bno)");

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bottomsCount;
    }
    
    public int getToppingsCount()
    {
        Statement stmt = null;
        int toppingsCount = 0;
        try
        {

            stmt = conn.getConnection().createStatement();
            String sql = "select COUNT(tno) from toppings";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                toppingsCount = rs.getInt("COUNT(tno)");

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toppingsCount;
    }
    
    public User getUser(String email, String password)
    {
        Statement stmt = null;
        User user = null;
        try
        {

            stmt = conn.getConnection().createStatement();
            String sql = "select * from users where email = '" + email +"' and password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                user = new User(
                        rs.getString("username"),
                        rs.getString("adress"),
                        rs.getString("phone"),
                        email,
                        password,
                        rs.getDouble("balance"));
                
                

            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
    public void createOrder(Orders order,String username)
    {
        Statement stmt;
        
        int bottom = order.getCupcakeBottom();
        int topping = order.getCupcakeTopping();
        int amount = order.getAmount();
        
        try
        {
            stmt = conn.getConnection().createStatement();
            String sql = "insert into orders values (" + bottom + "," + topping + "," 
                    + amount + "," + username + ")";

            stmt.execute(sql);
        }
        catch (Exception ex)
        {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//
//    // Flower access
//    public double getFlowerPrice(int flowerId)
//    {
//        Statement stmt;
//        double flowerPrice = 0;
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "select PRICE from FLOWER where FLOWER_ID = " + flowerId;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next())
//            {
//                flowerPrice = rs.getDouble("PRICE");
//
//            }
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return flowerPrice;
//    }
//
//    public String getFlowerDescription(int flowerId)
//    {
//        Statement stmt;
//        String flowerDescription = "";
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "select DESCRIPTION from FLOWER where FLOWER_ID = " + flowerId;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next())
//            {
//                flowerDescription = rs.getString("DESCRIPTION");
//
//            }
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return flowerDescription;
//    }
//
//    // Entertainment access
//    // Flower access
//    public double getEntertainmentPrice(int entertainmentId)
//    {
//        Statement stmt;
//        double entertainmentPrice = 0;
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "select PRICE from ENTERTAINMENT where ENTERTAINMENT_ID = " + entertainmentId;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next())
//            {
//                entertainmentPrice = rs.getDouble("PRICE");
//
//            }
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return entertainmentPrice;
//    }
//
//    public String getEntertainmentDescription(int entertainmentId)
//    {
//        Statement stmt;
//        String entertainmentDescription = "";
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "select DESCRIPTION from ENTERTAINMENT where ENTERTAINMENT_ID = " + entertainmentId;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next())
//            {
//                entertainmentDescription = rs.getString("DESCRIPTION");
//
//            }
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return entertainmentDescription;
//    }
//
//    // Fee access
//    public double getFeePrice(int feeId)
//    {
//        Statement stmt;
//        double feePrice = 0;
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "select PRICE from FEE where FEE_ID = " + feeId;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next())
//            {
//                feePrice = rs.getDouble("PRICE");
//
//            }
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return feePrice;
//    }
//
//    // Order access
//    public void createOrder(Order order)
//    {
//        Statement stmt;
//        int orderId = order.getOrderId();
//        int casketId = order.getCasketId();
//        int flowerId = order.getFlowerId();
//        int entertainmentId = order.getEntertainmentId();
//        double height = order.getHeight();
//        double width = order.getWidth();
//        double productPrice = order.getProductPrice();
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "INSERT INTO ´ORDER´ (ORDER_ID, CASKET_ID, FLOWER_ID, ENTERTAINMENT_ID, "
//                    + "CASKET_HEIGHT, CASKET_WIDTH, PRODUCTPRICE) "
//                    + "VALUES (" + orderId + "," + casketId + "," + flowerId + "," + entertainmentId + ","
//                    + height + "," + width + "," + productPrice + ")";
//
//            stmt.execute(sql);
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public int orderCount()
//    {
//        Statement stmt = null;
//        int orderCount = 0;
//        try
//        {
//            stmt = conn.getConnection().createStatement();
//            String sql = "select count(ORDER_ID) from ´ORDER´";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next())
//            {
//                orderCount = rs.getInt("count(ORDER_ID)");
//
//            }
//        }
//        catch (Exception ex)
//        {
//            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return orderCount;
//    }

}
