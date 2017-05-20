package FrontEnd.FrontController;


import FrontEnd.FrontController.CommandException;
import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.Carport;
import Data.BusinessLogic.CarportDUR;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Customer;
import Data.BusinessLogic.Shed;
import FrontEnd.FrontController.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author Kornh
 */
class carportOrderCommand implements Command{

    private String next;
    Controller ctr;
    
    public carportOrderCommand(String jsp) {
        next  = jsp;
    }


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       
        
        try {
            ctr = new Controller();
        } catch (Exception ex) {
            Logger.getLogger(carportOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Customer c = null;
        
        String cName;
        String cNumber;
        String cEmail;
        String cAdress;
        
        double width = 0;
        double length = 0;
        double shedWidth = 0;
        double shedLength = 0;
        int angle = 0;
        
        try{
            
        cName = (String) request.getParameter("cName");
        cNumber = (String) request.getParameter("cNumber");
        cEmail = (String) request.getParameter("cEmail");
        cAdress = (String) request.getParameter("cAdress");
        
        String w = (String) request.getParameter("width");
        String l = (String) request.getParameter("length");
        String sw = (String) request.getParameter("shedWidth");
        String sl = (String) request.getParameter("shedLength");
        String a = (String) request.getParameter("angle");
      
        
        width = Double.parseDouble(w);
        length = Double.parseDouble(l);
        shedWidth = Double.parseDouble(sw);
        shedLength = Double.parseDouble(sl);
        angle = Integer.parseInt(a);
        }
        catch(NumberFormatException Ex){
            return "error.jsp";
        }
         
        try
        {
            c = new Customer(cName, cNumber, cEmail, cAdress);
        }
        catch(IllegalArgumentException Ex){
            return "error.jsp";
        }
        try{
            Shed sh = new Shed(shedWidth,shedLength);
        if(angle > 0){
            CarportHR carportHR = new CarportHR(width,length,sh,angle);
            ctr.runHR(carportHR, c);
        }
        else
        {  
            CarportDUR carportDUR = new CarportDUR(width,length,sh);
            ctr.runDUR(carportDUR, c);
        }
        }
        catch(IllegalArgumentException ex){
            return "error.jsp";
        }
        catch(Exception ex){
            Logger.getLogger(carportOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
            return "error.jsp";
        }
        

        
 
        {
        return next;
        }

    }
    
}
