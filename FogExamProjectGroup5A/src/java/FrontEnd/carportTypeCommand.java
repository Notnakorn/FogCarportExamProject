/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;


import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kornh
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
          return "carportDesignFlatRoof.jsp";  
        }
        else if (carportType == 2)
        {
          return "carportDesignPointyRoof.jsp";
        }
       return next;
    }
    
}
