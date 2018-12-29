/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelperClasses;

import DAOClass.DAOClass;
import EntityClasses.OrderEntity;


public class OrderHandler {
    DAOClass daoMethods;

    public OrderHandler() {
       daoMethods = new DAOClass();
    }
    
    
    
    public void createNewOrder(String userName, int totalPrice, String address, String firstName, String surName) {
        OrderEntity order = new OrderEntity(userName,totalPrice,address,firstName,surName);
        daoMethods.openSessionWithTransaction();
        daoMethods.persist(order);
        daoMethods.closeSessionWithTransaction();
    }
    
    
}
