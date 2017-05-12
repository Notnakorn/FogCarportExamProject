package Data.Backend;

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
    
    public Part getPart(int pno) {
        return dao.getPartHR(pno);
     }
    
    public int getPartCount(int l, int h){
        return dao.getPartCount(l, h);
    }
    
    public ArrayList<Part> getPartListHR(){
        return dao.getPartListHR();
    }
    
    
}
