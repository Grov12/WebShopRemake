/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import java.util.List;
import java.util.ArrayList;
import DBHelperClasses.OrderHandler;
import DBHelperClasses.ItemHandler;
import DBHelperClasses.ProductHandler;
import JavaClasses.Product;
import SessionBeanInterface.CartInterface;
import java.util.Random;
import javax.ejb.Remove;



/**
 *
 * @author Daniel
 */
@Stateful
public class CartBean implements CartInterface {

    private String customerName;
    List<Product> products = new ArrayList();
    private double totalCost;
    private OrderHandler oh;
    private ItemHandler ih;
    ProductHandler pro;
    List<Object[]> tempList;

    public CartBean() {
        if(pro == null) {
        pro = new ProductHandler();
        tempList = pro.getListOfProducts();
        }
    }
    
    
    
    

   @Override
    public List getProducts(){
        return products;
    }
    
    @Override
    public List getListOfProductsFromDatabase() {
        return tempList;
    }
    
    
    
    
     @Remove
    @Override
    public void end() {
        System.out.println("Cartbean instance will be removed..");
    }
    


    @Override
    public void addToList(Product product) {
        products.add(product);
    }

    @Override
    public void emtptyList() {
       products.clear();
    }
   

    @Override
    public void removeFromList(Product product) {
         products.remove(product);
    }

   

    @Override
    public double gettotalCost() {
       return totalCost;
    }

    @Override
    public void increaseTotalCost(double c) {
        totalCost = totalCost + c;
    }

    @Override
    public void decreaseTotalCost(double c) {
       totalCost = totalCost - c;
    }

    @Override
    public boolean checkIfPossible(String name) {
        boolean c = pro.checkIfPossible(name);
        return c;
    }
    
         @Override
        public boolean decreaseQuantity(String name) {
            boolean controller = false;
            List<Object[]> k =  getListOfProductsFromDatabase();
            for(Object[] list: k){
                  if(list[1].equals(name)) {
                      if(!list[3].equals(0)) {
                     list[3] = (int) list[3] - 1;
                     tempList = k;
                     controller = true;
                      }
                      else {
                          controller = false;
                      }
                  }
     }
            return controller;
            
            
    }
        
        @Override
        public void increaseQuantity(String name) {
            List<Object[]> k =  getListOfProductsFromDatabase();
            for(Object[] list: k){
                  if(list[1].equals(name)) {
                     list[3] = (int) list[3] + 1;
                  }
     }
            tempList = k;
            
    }

   

 

  

   
}
