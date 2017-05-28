package Backend;

import BusinessLogic.Order;
import BusinessLogic.Part;
import java.util.ArrayList;



/**
 *  Encapsulates the data access layer
 * @author Kasper and Anton
 */
public class DBFacadeImpl implements DBFacade {
    private DataAccessObject dao;
    
    public DBFacadeImpl(DataAccessObject dao) {
        this.dao = dao;
    }
    
    public DBFacadeImpl() throws Exception {
        this.dao = new DataAccessObject();
    }
    

    public ArrayList<Part> getPartListHR(){
        return dao.getPartListHR();
    }
    
    public ArrayList<Part> getPartListDUR(){
        return dao.getPartListHR();
    }
    
    public void createCustomer(String cName, String cNumber, String cEmail, String cAdress){
        dao.createCustomer(cName, cNumber, cEmail, cAdress);
    }
    
    public void createOrder(String cEmail, String oDetails){
        dao.createOrder(cEmail, oDetails);
    }
    
    public void createReview(int reviewScore){
        dao.createReview(reviewScore);
    }
            
}
