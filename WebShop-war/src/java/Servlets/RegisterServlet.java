/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DBHelperClasses.UserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    
    
    UserHandler handle = new UserHandler();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
        
        
        
        }
        
        
        
       
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("RegisterScreen.jsp");
        rd.forward(request, response);
        
        
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String errorMsg = "";
        boolean error = false;
        try{
        if (userName == null || password == null || email.length()<1 || userName.length() == 0 || password.length() == 0) {
            error = true;
            errorMsg = "All fields needs to be filled in.";
            System.out.println(errorMsg);
            
        }
        
        
        if(error){
        throw new NullPointerException();
        }else{
            
            handle.createNewUser(userName, password, email);
            RequestDispatcher rd = request.getRequestDispatcher("LoginScreen.jsp");
        rd.forward(request, response);
        }
        }
        catch(NullPointerException e){
         e.printStackTrace();
         RequestDispatcher rd = request.getRequestDispatcher("RegisterScreen.jsp");
         rd.forward(request, response);
         
        }
        
    
    }
        
        
        
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
