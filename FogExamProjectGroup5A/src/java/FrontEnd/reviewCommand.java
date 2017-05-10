/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;


import javax.servlet.http.HttpServletRequest;


class reviewCommand implements Command{

    private String next;
    
    public reviewCommand(String jsp) {
        next  = jsp;
    }


    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        int review = 0;
        String r = (String) request.getParameter("smiley");
//        review = Integer.parseInt(r);

        
        //boolean status = facade.storeReview(smiley);
        
        
        return next;
    }
    
}