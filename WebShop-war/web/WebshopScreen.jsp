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
        <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
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
                <a href="buyProduct?code=${product[0]}">BUY</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    </body>
</html>


