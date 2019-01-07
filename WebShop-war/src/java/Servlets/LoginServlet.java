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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    UserHandler handle = new UserHandler();
    ProductHandler m = new ProductHandler();

    private void sendJSP (HttpServletRequest request, HttpServletResponse response, String name, String pword) 
        throws ServletException, IOException{
        
        
        //request.setAttribute("name", name); //not necessary
        //request.setAttribute("pword", pword); //Not necessary
        
        List<Object[]> k =  m.getListOfProducts();
        
         //System.out.println(list[1] + " " + list[2] + " " + list[3]);
         request.setAttribute("data",k);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("WebshopScreen.jsp");
        rd.forward(request, response);
    }
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
        processRequest(request, response);
        
        
        
        String name = request.getParameter("name");
        String pword = request.getParameter("pword");
        
        handle.authorizeLogin(name, pword);
        
        sendJSP(request, response, name, pword);
        
        
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
        processRequest(request, response);
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
