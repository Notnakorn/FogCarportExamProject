
package Data.Backend;

import Data.BusinessLogic.Order;
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
//    public Part getPartHR (int pno);
//    public Part getPartDUR (int pno);
//    public int getPartCountHR (int l, int h);
//    public int getPartCountDUR (int l, int h);
    public ArrayList<Part> getPartListHR();
    public ArrayList<Part> getPartListDUR();
    public void createCustomer(String cName, String cNumber, String cEmail, String cAdress);
    public void createOrder(String cEmail, String oDetails);
    public void createReview(int reviewScore);
}
