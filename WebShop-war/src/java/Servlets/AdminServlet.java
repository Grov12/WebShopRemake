/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DBHelperClasses.ProductHandler;
import DBHelperClasses.UserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author robin
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String button = request.getParameter("button");
        
        
    
             if(button.equals("button1")) {               
                 UserHandler user = new UserHandler();
                 String name = request.getParameter("nameOfUser");
                 user.deleteUser(name);
                 request.setAttribute("Yo", "hi");
                 response.sendRedirect("AdminPage.jsp");
                
                 
                 
                 
                 
         
              
             }
             
             else if(button.equals("button2")) {
              String name = request.getParameter("nameOfProduct");
              int priceOfProduct = Integer.parseInt(request.getParameter("priceOfProduct"));
              int quantityOfProduct = Integer.parseInt(request.getParameter("quantityOfProduct"));
              ProductHandler product = new ProductHandler();
              product.createNewProduct(name, priceOfProduct, quantityOfProduct);
              response.sendRedirect("AdminPage.jsp");
                 
            
             } 
             
               else if(button.equals("button3")) {
                   HttpSession session = request.getSession();
                   session.invalidate();
                   response.sendRedirect("LoginScreen.jsp");
               
                 
            
             }
             
             
         } 
        
       
            
    }

 

