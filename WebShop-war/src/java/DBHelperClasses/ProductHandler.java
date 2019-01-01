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
    
    
    
    public List getListOfProducts() {
       daoMethods.openSessionWithTransaction();
       List<Object[]> list = daoMethods.getListOfProducts();
       daoMethods.closeSessionWithTransaction();
    
       return list;
    }
    
    
    
}
