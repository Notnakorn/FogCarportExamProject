package FrontEnd.FrontController;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/** Is this javadoc or what? **/

public interface Command {
    /**Is this inside the method explaining what it does**/
    public String execute(HttpServletRequest req) throws CommandException;

}
