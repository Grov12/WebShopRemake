/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelperClasses;

import DAOClass.DAOClass;
import EntityClasses.ProductEntity;
import java.util.List;

/**
 *
 * @author robin
 */
public class ProductHandler {
    DAOClass daoMethods;

    public ProductHandler() {
        daoMethods = new DAOClass();
    }
    
       public void createNewProduct(String name, int price, int quantity){
        ProductEntity product = new ProductEntity(name,price,quantity);
        daoMethods.openSessionWithTransaction();
        daoMethods.persist(product);
        daoMethods.closeSessionWithTransaction();
    }
    
    
    
    public List getListOfProducts() {
       daoMethods.openSessionWithTransaction();
       List<Object[]> list = daoMethods.getListOfProducts();
       daoMethods.closeSessionWithTransaction();
    
       return list;
    }
    
    public void decreaseProductQuantity(String name){
        daoMethods.openSessionWithTransaction();
        daoMethods.decreaseQuantityFromProducts(name);
        daoMethods.closeSessionWithTransaction();
    }
    
     public void increaseQuantityToProducts(String name){
        daoMethods.openSessionWithTransaction();
        daoMethods.increaseQuantityToProducts(name);
        daoMethods.closeSessionWithTransaction();
    }
    
    public boolean checkIfPossible(String name) {
        daoMethods.openSession();
       boolean check = daoMethods.checkIfPossible(name);
       daoMethods.closeCurrentSession();
        return check;
    }
    
    
}
