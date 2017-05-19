package Data.Backend;

import Data.BusinessLogic.Order;
import Data.BusinessLogic.Part;
import java.util.ArrayList;



/**
 *  Encapsulates the data access layer
 * @author Kasper
 */
public class DBFacadeImpl implements DBFacade {
    private DataAccessObject dao;
    
    public DBFacadeImpl(DataAccessObject dao) {
        this.dao = dao;
    }
    
    public DBFacadeImpl() throws Exception {
        this.dao = new DataAccessObject();
    }
    
//    public Part getPartHR(int pno) {
//        return dao.getPartHR(pno);
//     }
//    
//    public Part getPartDUR(int pno) {
//        return dao.getPartHR(pno);
//     }
//    
//    public int getPartCountHR(int l, int h){
//        return dao.getPartCountHR(l, h);
//    }
//    
//    public int getPartCountDUR(int l, int h){
//        return dao.getPartCountHR(l, h);
//    }
    
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
