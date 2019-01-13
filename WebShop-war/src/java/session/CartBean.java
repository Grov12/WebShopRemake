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
import JavaClasses.Product;
import java.util.Random;



/**
 *
 * @author Daniel
 */
@Stateful
@LocalBean
public class CartBean {

    private String customerName;
    private List<Product> products;
    private double totalCost;
    private OrderHandler oh;
    private ItemHandler ih;
    
    
    public void initialize(String customer) throws Exception{
        if (customer == null){
            throw new Exception("Null parameter");
        } else {
            customerName = customer;
        }
        products = new ArrayList<>();
        totalCost = 0;
        oh = new OrderHandler();
        ih = new ItemHandler();
    }
    
    /*
    public void addProduct(Product product){
        // To avoid multiple instances of the same product but with different quantities
        String productName = product.getName();
        List<String> productNames = new ArrayList<>();
        for (Product p: products){
             productNames.add(p.getName());
        }
        if (productNames.contains(productName)){
            int index = productNames.indexOf(productName);
            products.get(index).increaseQuantity();
        }
        else {
            products.add(product);
        }
        totalCost += product.getPrice();
    }
    */
    
    public void addProduct(Product product){
        products.add(product);
    }
    
    public void removeProduct(Product product){
        products.remove(product);
    }
    
    /*
    public void decreaseQuantity(Product product){
        String productName = product.getName();
        List<String> productNames = new ArrayList<>();
        for (Product p: products){
             productNames.add(p.getName());
        }
        if (productNames.contains(productName)){
            int index = productNames.indexOf(productName);
            products.get(index).decreaseQuantity();
            
            if (products.get(index).getQuantity() == 0){
                removeProduct(product);
            }
        }
        totalCost -= product.getPrice();
    }
    */
    
    public List getProducts(){
        return products;
    }
    
    public String cartToString(){
        String s = "";
        for (Product p: products){
            s = s + p.toString() + "\n";
        }
        return s;
    }
    
    public double getTotalCost(){
        return totalCost;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    
    public void setCustomerName(String name){
        this.customerName = name;
    }
    
    public void checkOut(String username, String address, String firstName, String surName){
        
        Random rng = new Random();
        int orderID = rng.nextInt(1000000) + 1;
        int totalPrice = (int) Math.round(totalCost);
        oh.createNewOrder(orderID, username, 0, address, firstName, surName);
        
        for (Product p : products){
            int productCost = (int) Math.round(p.getPrice());
            ih.addItemToOrder(orderID, p.getName(), productCost);
        }
    }
}
