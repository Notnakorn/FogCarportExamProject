/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;


import FrontEnd.Command;
import FrontEnd.CommandException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kasper and Anton
 */
class carportTypeCommand implements Command{

    private String next;
    
    public carportTypeCommand(String jsp) {
        next  = jsp;
    }


    @Override
    public String execute(HttpServletRequest request) throws CommandException {


        
        int carportType = 0;
        String c = (String) request.getParameter("carportType");
        carportType = Integer.parseInt(c);

        
        //boolean status = facade.storeReview(smiley);
        if(carportType == 1)
        {
          return "carportDesignFlatRoof2.jsp";  
        }
        else if (carportType == 2)
        {
          return "carportDesignPointyRoof2.jsp";
        }
       return next;
    }

    
}
