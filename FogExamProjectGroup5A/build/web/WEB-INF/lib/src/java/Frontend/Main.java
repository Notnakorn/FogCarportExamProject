package Frontend;

 

import Data.DataAccessObject;
import Data.Login.DummyLoginService;
import Data.Login.LoginService;
import Data.Login.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tobias
 */
@WebServlet(urlPatterns =
{
    "/Main"
})
public class Main extends HttpServlet
{
    
    DataAccessObject dao = null;

    private void DAOInit()
    {
        try
        {
            dao = new DataAccessObject();
        }
        catch (Exception ex)
        {
            System.out.println("cant access database");
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        LoginService loginService = new DummyLoginService();
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("login".equals(action))
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = loginService.login(email, password);
            if(user == null)
            {
                //Login failed
                sendLoginForm(request, response);
                return;
            }
            request.getSession().setAttribute("user", user);
            sendIndex(request, response);
            return;
        }
        
        User user = (User) request.getSession().getAttribute("user");
        if(user == null)
        {
            sendLoginForm(request, response);
            return;
        }
        if(action == null)
        {
            sendIndex(request, response);
        }

        else
        {
            sendNotFound(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    private void sendLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"dererstiloverdet.css\" />");
            out.println("<title>Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<form action=\"Main\" method=\"post\">");
            out.println("Email: <input type=\"text\" name=\"email\" />");
            out.println("Pasword: <input type=\"password\" name=\"password\" />");
            out.println("<input type=\"submit\" value=\"Login\">");
            out.println("<input type=\"hidden\" name=\"action\" value=\"login\">");
            out.println("</form>");    
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"dererstiloverdet.css\" />");
            out.println("<title>Index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cupcake shop</h1>");

            DAOInit();
            
            User user = (User) request.getSession().getAttribute("user");
        if(user == null)
        {
            sendLoginForm(request, response);
            return;
        }
            
            out.println("<a href=\"http://207.154.197.214:8080/CupcakeShop/Main.html\" target=\"_blank\"><img  src=\"Pictures/CupcakeImage.jpg\" align=\"middle\" width=\"500\" height=\"300\"></a>");
            out.println("<p>Here you can design your own perfect cupcake!</p>");
            out.println("<br><h2>Current user: </h2> <h3>" + user.getUsername() + " </h3>");
            out.println("<h2>Current balance: </h2> <h3>" + user.getBalance() + " </h3>");
            
            
            //list of cupcakes // import from database
           out.println("<form action=\"cake\" id=\"cakeform\">");
           
           //Dropdown with bottoms description and prices
           out.println("<h2> Select bottom: </h2>");
           out.println("<select name=\"bno\" id=\"bottom\">");
           
           out.println("<script>var bottom_prices = new Array();</script>");
           for (int i = 1; i <= dao.getBottomsCount(); i++) {
              
             out.println("<option value=\"" + i + "\">" + i +": " + dao.getBottomDescription(i) + 
                    " - price: " + dao.getBottomPrice(i) +  "</option>");
             out.println("<script>bottom_prices["+i+"]="+dao.getBottomPrice(i)+";</script>");
           
            }
            out.println("</select>");

            
            //Dropdwon with toppings desc and prices
            out.println("<h2> Select topping: </h2>");
            out.println("<select name=\"tno\" id=\"topping\">");
           
            out.println("<script>var topping_prices = new Array();</script>");
             for (int i = 1; i <= dao.getToppingsCount(); i++) {
             out.println("<option value=\"" + i + "\">" + i +": " + dao.getToppingDescription(i)+ 
                    " - price: " + dao.getToppingPrice(i) +  "</option>");
             out.println("<script>topping_prices["+i+"]="+dao.getToppingPrice(i)+";</script>");
           
            }
            
            out.println("</select>");
           
            //Field to enter amount
            out.println("<h2> Select amount: </h2>");
            
            out.println("<input type=\"number\" min=\"1\" id=\"number\" name=\"amount\" />");
            out.println("<br>");
            out.println("<br>");
            
           
            out.println("<br><h2>Price: </h2>");
            //Creates field to store price
            out.println("<input type=\"number\" id=\"price\" disabled=\"disabled\"/>");

            
            out.println("<br> <h2>New balance: </h2>");
            //Creates field to store user balance
            out.println("<input type=\"number\" id=\"nBalance\" disabled=\"disabled\"/>");
            
            out.println("<script>var s = 0;</script>");
            
            //Calculates price and new user balance
            out.println("<script>document.getElementById(\"number\").onkeyup  = function test() {"
                    +"var e = document.getElementById(\"topping\");"
                    +"var toppingId = e.options[e.selectedIndex].value;"
                    
                    +"var c = document.getElementById(\"bottom\");"
                    +"var bottomId = c.options[c.selectedIndex].value;"
                    
                    + "document.getElementById(\"price\").value = parseFloat(this.value)"
                    + "* (bottom_prices[bottomId]+topping_prices[toppingId]);"
                    
                    + "document.getElementById(\"nBalance\").value = " + user.getBalance() 
                    +"- parseFloat(document.getElementById(\"price\").value) - s; "
                    + "}</script>");
            
            out.println("<br><br>");   
            
            out.println("<input type=\"button\" id=\"myBtn\" onclick=\"myFunction();\" value=\"add to cart\"/>");
            out.println("<script>var cartList = [];</script>");
            out.println("<p id=\"container\"></p>");
            out.println("<script> "
                   
                    + "function myFunction() {"
                    + "if(parseFloat(document.getElementById(\"nBalance\").value) < 0){"
                    + "alert(\"Insufficient funds!\");"
                    + "} else if(document.getElementById(\"number\").value < 1) {"
                    + "alert(\"Cant add negative amount!\");"
                    + "} else {"
                    +"var e = document.getElementById(\"topping\");"
                    +"var toppingId = e.options[e.selectedIndex].value;"
                    
                    +"var c = document.getElementById(\"bottom\");"
                    +"var bottomId = c.options[c.selectedIndex].value;"
                    
                    +"var n = document.getElementById(\"number\").value;"
                    
                    +"var cupcake = {bottom:bottomId, topping:toppingId, amount:n};"
                    +"cartList.push(cupcake);"
                    +"s = s + parseFloat(document.getElementById(\"price\").value);"
                    +"document.getElementById(\"container\").innerHTML = JSON.stringify(cartList);"
                    
                    + "document.getElementById(\"nBalance\").value = " + user.getBalance() 
                    +"- parseFloat(document.getElementById(\"price\").value) - s; "
                    
                    +"alert(\"Cupcake added to cart\");"
                    +"}}</script>");
            
//            out.println("<script>document.getElementById(\"myBtn\").onkeypress = function() {"
//                    +"aler(\"hello\");};");
////                    + "document.getElementById('container').innerHTML =lineChartData[cartList]};");
            
            out.println("<br><br>");   
            
            out.println("<input type=\"button\" value=\"Order\" onclick=\"myFunction2()\"/>");
            out.println("<script> function myFunction2() {"
                    + ""
                    + ""
                    + ""
                    + "}</script>");
            
            
            
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendNotFound(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>NotFound</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Action not found</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
