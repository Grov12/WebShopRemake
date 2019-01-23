
package DBHelperClasses;

//this class will handle all export to database when comes to users.

import DAOClass.DAOClass;
import EntityClasses.UserEntity;
import java.util.List;


public class UserHandler {
    DAOClass daoMethods;
  
    
    
    public UserHandler() {
        daoMethods = new DAOClass();
     
    }
    
    
    
    public void createNewUser(String username, String password, String email) {
          UserEntity handleUser = new UserEntity(username,password, email);
          daoMethods.openSessionWithTransaction();
          daoMethods.persist(handleUser);
          daoMethods.closeSessionWithTransaction();
    }
    
     public void deleteUser(String username) {
          daoMethods.openSessionWithTransaction();
          daoMethods.deleteUser(username);
          daoMethods.closeSessionWithTransaction();
    }
    
    public boolean authorizeLogin(String username, String password) {
            daoMethods.openSession();
            boolean checker = daoMethods.checkPass(username, password);
            daoMethods.closeCurrentSession();
            
            return checker;
    }
    
     public void addPointsToUser(String username) {
          daoMethods.openSessionWithTransaction();
          daoMethods.giveAPointToUser(username);
          daoMethods.closeSessionWithTransaction();
    }
     
     public int getPointsFromUser(String username){
        
          daoMethods.openSessionWithTransaction();
          int result = daoMethods.getPointsFromUser(username);
          daoMethods.closeSessionWithTransaction();
       
          return result; 
         
     }
       public String getPassword(String email){
        
          daoMethods.openSession();
          String result = daoMethods.getPassword(email);
          daoMethods.closeCurrentSession();
       
          return result; 
         
     }
     
       
    
    
    
}
