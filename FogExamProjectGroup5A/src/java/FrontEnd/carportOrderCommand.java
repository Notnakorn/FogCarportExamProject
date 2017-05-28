package FrontEnd;


import FrontEnd.CommandException;
import Backend.DBFacadeImpl;
import BusinessLogic.Carport;
import BusinessLogic.CarportDUR;
import BusinessLogic.CarportHR;
import BusinessLogic.Customer;
import BusinessLogic.Shed;
import FrontEnd.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author Kasper and Anton
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
            
        setAttribute("width", 800.0, request);
        setAttribute("length", 800.0, request);
        setAttribute("height", 400.0, request);
        setAttribute("shedWidth", 0.0, request);
        setAttribute("shedLength", 0.0, request);
        setIntAttribute("angle", 0.0, request);
            
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
        Shed sh = null;
        try{
            if(shedWidth == 0 || shedLength == 0){
            }
            else{
            sh = new Shed(shedWidth,shedLength);    
            }
        }    
        catch(IllegalArgumentException ex){
            return "error.jsp";
        }    
        try{    
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
        private void setAttribute(String name, Object defaultValue, HttpServletRequest request)
    {
        String strVal = request.getParameter(name);
 
        try
        {
            request.setAttribute(name, Double.parseDouble(strVal));
        }
        catch(NumberFormatException ex)
        {
            request.setAttribute(name, defaultValue);
        }
    }    
    private void setIntAttribute(String name, Object defaultValue, HttpServletRequest request)
    {
        String strVal = request.getParameter(name);
 
        try
        {
            request.setAttribute(name, Integer.parseInt(strVal));
        }
        catch(NumberFormatException ex)
        {
            request.setAttribute(name, defaultValue);
        }
    }   
    
}
