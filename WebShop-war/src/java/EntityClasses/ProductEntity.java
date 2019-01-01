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
@Table(name = "products")
public class ProductEntity {
    
    @Id
    @Column(name = "articleID")
    private int articleID;
    
    
    @Column(name = "name")
    private String name;
    
    
    @Column(name = "price")
    private int price;
    
    
    @Column(name = "quantity")
    private int quantity;

    public ProductEntity(int articleID,String name, int price, int quantity) {
        this.articleID = articleID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


  
    
  
    
}
