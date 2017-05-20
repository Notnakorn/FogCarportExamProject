/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Login;

import Data.DataAccessObject;
import Data.Login.LoginService;

/**
 *
 * @author Katja Kaj
 */
public class DummyLoginService implements LoginService
{
    
    DataAccessObject dao = null;

    private void DAOInit()
    {
        try
        {
            dao = new DataAccessObject();
        }
        catch (Exception ex)
        {
            System.out.println("cant access database");
        }
    }

    @Override
    public User login(String email, String password)
    {
        DAOInit();
        
        User user = null;
        
        try{
            user = dao.getUser(email, password);
            
        } catch(Exception ex) {
            System.out.println("User not found");
        }
        
        if(user != null){
            return user;
        }
        
//        if("123".equals(email) && "123".equals(password))
//        {
//            return new User("Tobias", email);
//        }
//        return null;
    return null;
    }
    
}