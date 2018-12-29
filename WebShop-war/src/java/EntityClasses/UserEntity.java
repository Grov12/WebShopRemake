/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//Entity class that is mapped to the database.

@Entity
@Table(name = "user")
public class UserEntity {

    
    


    @Id
    @Column(name = "userName")
    private String username;
    
    
     @Column(name = "password")
     private String password;
     
      @Column(name = "points")
     private int points;
     
     

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
        points = 0;
      
        
    }
}
    
    
    
    
     
     

