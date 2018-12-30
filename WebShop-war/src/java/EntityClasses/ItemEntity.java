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


@Entity
@Table(name = "`items`")
public class ItemEntity {
    
    @Id
    @Column(name = "Order_orderid")
    private int orderID;
    
    
    
    @Column(name = "name")
    private String name;
    
    
    @Column(name = "price")
    private int price;

    public ItemEntity(int orderID, String name, int price) {
        this.orderID = orderID;
        this.name = name;
        this.price = price;
    }
    
    
    
}
