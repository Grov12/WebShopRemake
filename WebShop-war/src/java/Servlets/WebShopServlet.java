
package Servlets;

import DBHelperClasses.ItemHandler;
import DBHelperClasses.OrderHandler;
import DBHelperClasses.ProductHandler;
import DBHelperClasses.UserHandler;
import JavaClasses.Product;
import SessionBeanInterface.CartInterface;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import session.EmailBean;
import webservices.BalanceWebservice_Service;


@WebServlet(name = "WebShopServlet", urlPatterns = {"/WebShopServlet"})
public class WebShopServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/BalanceWebservice/BalanceWebservice.wsdl")
    private BalanceWebservice_Service service;


     private static final String CART_SESSION_KEY = "shoppingCart";
     UserHandler handle = new UserHandler();
  
  
  

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           
            throws ServletException, IOException {
        
        
           
               
               
    }
    @EJB EmailBean sendMail;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String but = request.getParameter("button");
            
            
            CartInterface m = (CartInterface) request.getSession().getAttribute(CART_SESSION_KEY);
         
                
           if(m == null){

             try {
                 InitialContext ic = new InitialContext();
                 m = (CartInterface) ic.lookup("java:global/WebShop-war/CartBean");
                 request.getSession().setAttribute(CART_SESSION_KEY, m);
                

                 
             
             } catch (NamingException ex) {
                    Logger.getLogger(WebShopServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           
           
              List<Product> listOfAddedItems =  m.getProducts();
             if(request.getParameter("data1") !=null) {
                 ProductHandler pro = new ProductHandler();
                 String name = request.getParameter("data1");
                 double price = Double.parseDouble(request.getParameter("somevalue"));
                 m.decreaseTotalCost(price);
                 m.increaseQuantity(name);
                 removeFromList(name,listOfAddedItems);
                 request.setAttribute("totalcost", m.gettotalCost());
                 request.setAttribute("data2",listOfAddedItems);
                 request.getRequestDispatcher("cart.jsp").forward(request, response);

           
            }
             
             
             
           if(but.equals("addCart")) {
               System.out.println("Addcart.");
          
                
            
               
               try {
                
               String but3 = request.getParameter("param2");
               
               int price = Integer.parseInt(request.getParameter("param3"));
               boolean c = m.decreaseQuantity(but3);
                
                if(!c) {
                    throw new Exception();
                }
                
               
              
               Product s = new Product(but3,price);
               m.addToList(s);  
              
               m.increaseTotalCost(s.getPrice());
             
               
               
               request.setAttribute("name", getCookie("name",request));
               request.setAttribute("points", getCookie("points",request));
               request.setAttribute("data",m.getListOfProductsFromDatabase());
               request.setAttribute("msgBack","Item successfully added to your cart.");
               
               request.getRequestDispatcher("WebshopScreen.jsp").forward(request, response);
               

           
            } catch(Exception e) {
                
               
               
           
               request.setAttribute("data",m.getListOfProductsFromDatabase());
               
               
               
               request.setAttribute("name", getCookie("name",request));
               request.setAttribute("points",  getCookie("points",request));
               
               request.setAttribute("msgBack","This item can not be added to your cart.");
               request.getRequestDispatcher("WebshopScreen.jsp").forward(request, response);
            }
           
           }
           
           
           
               if(but.equals("Checkout")) {
               request.setAttribute("totalcost", m.gettotalCost());
               request.setAttribute("data2",listOfAddedItems);
               request.getRequestDispatcher("cart.jsp").forward(request, response);
               
               }
    
               
                if(but.equals("continueshopping")) {
               request.setAttribute("data",m.getListOfProductsFromDatabase());
               Cookie gg[]= request.getCookies();
               
               
               request.setAttribute("name", getCookie("name",request));
               request.setAttribute("points", getCookie("points",request));
               request.getRequestDispatcher("WebshopScreen.jsp").forward(request, response);
               
               }
               
               //Logic for Cart operations down below
               
                if(but.equals("buttonPay")) {
                 
                    String username =getCookie("name",request);
                    String firstname = null;
                    String lastname = null;
                    String address = null;
                    String email = null;
                    int creditCard = 0;
                  try {
                  
                    firstname = request.getParameter("firstname");
                    lastname = request.getParameter("lastname");
                    address = request.getParameter("address");
                    email = request.getParameter("email");
                    creditCard = Integer.parseInt(request.getParameter("creditcard"));
                    
                  if(m.getProducts().isEmpty()) {
                      throw new NumberFormatException();
                  }
                   
                  } catch(NumberFormatException e) {
                      e.printStackTrace();
                      request.setAttribute("data2",listOfAddedItems);
                      request.setAttribute("errorMsg","Either you didn't fill in all fields or your list is currently empty.");
                      request.setAttribute("totalcost", m.gettotalCost());
                      request.getRequestDispatcher("cart.jsp").forward(request, response);
                      return;
                  }
                  catch(NullPointerException e) {
                      e.printStackTrace();
                      request.setAttribute("data2",listOfAddedItems);
                      request.setAttribute("errorMsg","All fields needs to be filled.");
                      request.setAttribute("totalcost", m.gettotalCost());
                      request.getRequestDispatcher("cart.jsp").forward(request, response);
                      return;
                  }
                  
                  
                       
                  
                  
                  try {
                      
                      boolean moneyInBank = balance(firstname,lastname,creditCard, (int) m.gettotalCost());
                      
                    if(!moneyInBank) {
                         throw new Exception();
                      }
                    String order = "Dear " + firstname + " your order has been placed. Totalcost: "+ m.gettotalCost();
                    sendMail.sendFromGMail("grovgrov1", "Robinlol12345", email, "Order confirmation", order);
                    List<Product> k2 =  m.getProducts();
                    OrderHandler s = new OrderHandler();
                    ItemHandler s1 = new ItemHandler();
                    UserHandler s2 = new UserHandler();
                     Random rng = new Random();
                     int orderID = rng.nextInt(1000000) + 1;
                    s.createNewOrder(orderID, username, 0, address, firstname, lastname);
                    for(Product product : k2) {
                        s1.addItemToOrder(orderID, product.getName(), (int) product.getPrice());
                    }
                    s2.addPointsToUser(username);
                    m.emtptyList();
                    m.decreaseTotalCost(m.gettotalCost());
                    request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
                  } catch(Exception e) {
                      request.setAttribute("data2",listOfAddedItems);
                      request.setAttribute("totalcost", m.gettotalCost());
                      request.setAttribute("errorMsg","Could not process order.");
                      request.getRequestDispatcher("cart.jsp").forward(request, response);
                  }
               }
                 else if(but.equals("button3")) {
                   HttpSession session = request.getSession();
                   session.invalidate();

                   response.sendRedirect("LoginScreen.jsp");
               
                 
            
             }
              
         
     
    }
    
    
     public void removeFromList(String name,List<Product> listl) {
        for(int i = 0; i < listl.size(); i++) {
            if(listl.get(i).getName().equals(name)) {
                
                listl.remove(listl.get(i));
                return;
            }
        }
    }
     
     
     public String getCookie(String name,HttpServletRequest request) {
          Cookie gg[]= request.getCookies();
         String cookieName = null;
        for(int i = 0; i < gg.length; i++) {
            if(gg[i].getName().equals(name)) {
               cookieName = gg[i].getValue();
               System.out.println(cookieName);
            }
        }
        return cookieName;
    }

    private boolean balance(java.lang.String firstnamame, java.lang.String arg1, int arg2, int arg3) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservices.BalanceWebservice port = service.getBalanceWebservicePort();
        return port.balance(firstnamame, arg1, arg2, arg3);
    }

     
     
     



}
