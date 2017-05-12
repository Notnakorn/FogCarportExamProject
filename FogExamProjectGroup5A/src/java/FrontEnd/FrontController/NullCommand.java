package FrontEnd.FrontController;

import FrontEnd.FrontController.Command;
import FrontEnd.FrontController.CommandException;
import javax.servlet.http.HttpServletRequest;


class NullCommand implements Command {

   private String next;
    
    public NullCommand(String jsp) {
        next  = jsp;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return next;
    }
    
}
