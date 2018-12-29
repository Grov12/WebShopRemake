
package DBHelperClasses;

//this class will handle all export to database when comes to users.

import DAOClass.DAOClass;
import EntityClasses.UserEntity;

public class UserHandler {
    DAOClass daoMethods;
  
    
    
    public UserHandler() {
        daoMethods = new DAOClass();
     
    }
    
    
    
    public void createNewUser(String username, String password) {
          UserEntity handleUser = new UserEntity(username,password);
          daoMethods.openSessionWithTransaction();
          daoMethods.persist(handleUser);
          daoMethods.closeSessionWithTransaction();
    }
    
    public boolean authorizeLogin(String username, String password) {
            daoMethods.openSession();
            boolean checker = daoMethods.checkPass(username, password);
            daoMethods.closeCurrentSession();
            
            return checker;
    }
    
    
    
}
