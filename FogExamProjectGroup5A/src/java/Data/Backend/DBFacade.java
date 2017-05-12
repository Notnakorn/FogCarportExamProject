
package Data.Backend;

import Data.BusinessLogic.Part;
import java.util.ArrayList;

/**
 * Our interface for the DBFade
 * It holds methods that help us communicate with the server. 
 * 
 * @author Kasper
 * 
 * - add place order.
 * - add place review.
 * - add store customer data. 
 */


public interface DBFacade {
    public Part getPart (int pno);
    public int getPartCount (int l, int h);
    public ArrayList<Part> getPartListHR();
}
