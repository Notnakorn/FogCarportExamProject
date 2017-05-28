package FrontEnd;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface Command {
    
    public String execute(HttpServletRequest req) throws CommandException;

}
