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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    UserHandler handle = new UserHandler();
    ProductHandler m = new ProductHandler();
    

    
    
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
        String name = request.getParameter("name");
         String btn = request.getParameter("button3");
       
        String pword = request.getParameter("pword");
        //String points = request.getParameter("points");
        String errorMsg = "";
        boolean error = false;
        
        
        
      
        
        
        
        
        
        try{
            boolean checker = handle.authorizeLogin(name, pword);
            
            
        if (name == null || pword == null || name.length() == 0 || pword.length() == 0) {
            error = true;
            errorMsg = "Username and password is required";
            System.out.println(errorMsg);
        }
        
        
        
        
        
        
        
        if(error){
        RequestDispatcher rd = request.getRequestDispatcher("LoginScreen.jsp");
        rd.forward(request, response);
        }
        
        if(checker == true && name.equals("Admin")){
             RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
             rd.forward(request, response);
        
        
        } else if(checker == true && !name.equals("Admin")) {
            List<Object[]> k =  m.getListOfProducts();
            int pp = handle.getPointsFromUser(name);
            String point = Integer.toString(pp);
            request.setAttribute("data",k);
            
            Cookie username = new Cookie("name",name);
            Cookie points = new Cookie("points", point);
        
            username.setMaxAge(60*60*2); 
            points.setMaxAge(60*60*2);
            response.addCookie(username);
            response.addCookie(points);
            
            
            
            request.setAttribute("name", name);
            request.setAttribute("points", point);
            HttpSession session = request.getSession();
            session.invalidate();
            
            RequestDispatcher rd = request.getRequestDispatcher("WebshopScreen.jsp");
            rd.forward(request, response);
            
            //sendJSP(request, response, name);
        }
        
        else{
        RequestDispatcher rd = request.getRequestDispatcher("LoginScreen.jsp");
        rd.forward(request, response);
            
        }
        }catch(NullPointerException e){
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("LoginScreen.jsp");
            rd.forward(request, response);
            
        }
        
          
        
            
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
               response.sendRedirect("LoginScreen.jsp");
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
