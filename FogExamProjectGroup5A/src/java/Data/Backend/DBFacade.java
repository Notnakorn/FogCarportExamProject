
package Data.Backend;

import Data.BusinessLogic.Part;
import java.util.ArrayList;

public interface DBFacade {
    public Part getPart (int pno);
    public int getPartCount (int l, int h);
    public ArrayList<Part> getPartListHR();
}
