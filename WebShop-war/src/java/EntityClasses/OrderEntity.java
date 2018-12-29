
package EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
public class OrderEntity {
    
    @Id
    @Column(name = "orderid")
    private int orderID;
    
    
    @Column(name = "User_userName")
    private String userName;
    
    
    @Column(name = "totalprice")
    private int totalPrice;
    
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "firstname")
    private String firstName;
    
    
    @Column(name = "surname")
    private String surName;

    public OrderEntity(String userName, int totalPrice, String address, String firstName, String surName) {
        orderID = 6;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.firstName = firstName;
        this.surName = surName;
    }
    
    
    
    
}
