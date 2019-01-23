/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DBHelperClasses.UserHandler;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.EmailBean;


@WebServlet(name = "EmailServlet", urlPatterns = {"/EmailServlet"})
public class EmailServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.sendRedirect("EmailScreen.jsp");
  
    }

    @EJB EmailBean sendemail;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UserHandler getEmail = new UserHandler();
        
                 String email = request.getParameter("email");
                 
                 
                 if(email != null) {
                     try {
                     String pass = getEmail.getPassword(email);
                     sendemail.sendFromGMail("grovgrov1","Robinlol12345",email,"Password recovery",pass);
                     response.sendRedirect("LoginScreen.jsp");
                     } catch(Exception e) {
                         response.sendRedirect("EmailScreen.jsp");
                     }
                    
                 }
   
    }
    

}
