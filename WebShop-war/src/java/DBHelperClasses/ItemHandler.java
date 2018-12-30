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
    
    
    public void addItemToOrder(int orderID, String name, int price) {
        ItemEntity item = new ItemEntity(orderID,name,price);
        daoMethods.openSessionWithTransaction();
        daoMethods.persist(item);
        daoMethods.increaseAmountOrder(price,orderID);
        daoMethods.closeSessionWithTransaction();
    }
    
    
    
    
}
