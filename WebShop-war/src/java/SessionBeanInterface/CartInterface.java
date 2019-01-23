/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeanInterface;

import JavaClasses.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author robin
 */
 @Local
public interface CartInterface {
   
    /**
     *
     * @param product
     */
    public void addToList(Product product);
    public void emtptyList();
    public void end();
    public void removeFromList(Product product);
    public double gettotalCost();
    public void increaseTotalCost(double c);
    public void decreaseTotalCost(double c);
    public List getListOfProductsFromDatabase();
    public boolean checkIfPossible(String name);
    public boolean decreaseQuantity(String name);
    public void increaseQuantity(String name);

    public List getProducts();

   
    
}

