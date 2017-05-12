package FrontEnd;


import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.Carport;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Shed;
import FrontEnd.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kornh
 */
class carportDesignCommand implements Command{

    private String next;
    
    public carportDesignCommand(String jsp) {
        next  = jsp;
    }


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       
        DBFacadeImpl facade;
        try {
            facade = new DBFacadeImpl();
        } catch (Exception ex) {
            Logger.getLogger(carportDesignCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        double width = 0;
        double length = 0;
        int angle = 0;
        
        try{
        String w = (String) request.getParameter("width");
        String l = (String) request.getParameter("length");
        String a = (String) request.getParameter("angle");
        
        width = Double.parseDouble(w);
        length = Double.parseDouble(l);
        angle = Integer.parseInt(a);
        }
        catch(NumberFormatException Ex){
            return "error.jsp";
        }
         
        

        try{
            //Give shed parameters!
            Shed sh = null;
            Carport carportHR = new CarportHR(width,length,sh,angle);
            
        }
        catch(IllegalArgumentException Ex){
            return "error.jsp";
        }
      
        
 
        {
        return next;
        }

    }
    
}
