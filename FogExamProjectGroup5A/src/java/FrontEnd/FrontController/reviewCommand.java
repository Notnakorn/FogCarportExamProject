/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.FrontController;


import FrontEnd.FrontController.Command;
import FrontEnd.FrontController.CommandException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


class reviewCommand implements Command{

    private String next;
    Controller ctrl;
    
    public reviewCommand(String jsp) {
        next  = jsp;
    }

        

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        
        
        try {
            ctrl = new Controller();
        } catch (Exception ex) {
            Logger.getLogger(carportOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        int review = 0;
        String r = (String) request.getParameter("smiley");
        review = Integer.parseInt(r);
        
        try {
            ctrl.runReview(review);
        } catch (Exception ex) {
            Logger.getLogger(reviewCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return next;
    }
    
}