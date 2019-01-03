/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelperClasses;

import DAOClass.DAOClass;
import EntityClasses.ItemEntity;

/**
 *
 * @author robin
 */
public class ItemHandler {
    DAOClass daoMethods;

    public ItemHandler() {
        daoMethods = new DAOClass();
    }
    
    //after created random index number for order, add an item to that same index.
    public void addItemToOrder(int orderID, String name, int price) {
        ItemEntity item = new ItemEntity(orderID,name,price);
        daoMethods.openSessionWithTransaction(); 
       boolean check = daoMethods.checkIfPossible(name);
       if(check) {
           daoMethods.persist(item); //saves new value.
           daoMethods.increaseAmountOrder(price,orderID);
           daoMethods.decreaseQuantityFromProducts(name);
           daoMethods.closeSessionWithTransaction();
           System.out.println(name + " was successfully added to order.");
       }
       
       else {
           daoMethods.closeSessionWithTransaction();
           System.out.println(name + " could not be added.");
       }
       
       
     
        
        
    }
    
    
    
    
}
