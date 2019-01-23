<%-- 
    Document   : WebshopScreen
    Created on : 2018-dec-30, 18:52:20
    Author     : jimmyjonsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webshop</title>
    </head>
    <body>
        <div style="background: #cd3700; height: 55px; padding: 5px;">
  <div style="float: left; padding: 12px; text-align: left">
    Welcome <b>${name}</b>! You have earned <b>${points}</b> points  
  </div>
 
  <div style="float: right; padding: 12px; text-align: right;">
    
   <br/>
  </div>
</div>
  
    <p style="color: red;">${errorString}</p>
  
    <table border="1" cellpadding="5" cellspacing="1" style="background: #D6DBDF;" >
       <tr>
          <th>Article No.</th>
          <th>Product Name</th>
          <th>Price</th>
          <th>Quantity</th>
          
       </tr>
       <c:forEach items="${data}" var="product" >
          <tr>
             <td>${product[0]}</td>
             <td>${product[1]}</td>
             <td>${product[2]}</td>
             <td>${product[3]}</td>
             <td>
                
             </td>
             <td>
                 
            
                  <form action="WebShopServlet" method="POST">
                  <input type="hidden" name="param2"  value="${product[1]}"></input>
                  <input type="hidden" name="param3"  value="${product[2]}"></input>
                  <button type="submit" name="button" value="addCart">Add to cart</button></form>
                 

            
             </td>
          </tr>
       </c:forEach>
    </table>

    
       <form action="WebShopServlet" method="POST">
     <button type="submit" name="button" value="Checkout">Checkout</button></form>
   
    <br>
    <br>
  
    </body> 
    ${msgBack} <br><br>
      <form action="WebShopServlet" method="POST">
     <button type="submit" name="button" value="button3">Logout</button></form>
    
     
    </body>
</html>


