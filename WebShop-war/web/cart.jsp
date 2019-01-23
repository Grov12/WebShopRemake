<%-- 
    Document   : cart
    Created on : 2019-jan-13, 21:52:01
    Author     : robin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Cart</h3>
          <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
        
          <th>Product Name</th>
          <th>Price</th>
         
          
       </tr>
       <c:forEach items="${data2}" var="product" >
          <tr>
             <td>${product.getName()}</td>
             <td>${product.getPrice()}</td>
             
              
            
             <td>
                
             </td>
             <td>
                 
                  <form action="WebShopServlet" method="POST">
                  <input type="hidden" name="data1"  value="${product.getName()}"></input>
                   <input type="hidden" name="somevalue"  value="${product.getPrice()}"></input>
                   <input type="submit" value="Remove"></input></form>
             </td>
          </tr>
       </c:forEach>
    </table>
        total cost : ${totalcost}<br>
        <form action="WebShopServlet" method="POST">
        <button type="submit" name="button" value="continueshopping">Continue shopping</button></form> <br>
        <br><br>
        <form action="WebShopServlet" method="POST">
        <input type="text"  name="firstname" />Firstname <br><br>
        <input type="text"  name="lastname" />Lastname<br><br>
        <input type="text"  name="address" />address <br><br>
        <input type="text"  name="email" />E-mail <br><br>
        <input type="text"  name="creditcard" />creditcard <br><br>
        <button type="submit" name="button" value="buttonPay">Pay</button></form> <br>
       ${errorMsg}
 
  
    </body>
</html>
