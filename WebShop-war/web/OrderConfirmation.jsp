<%-- 
    Document   : OrderConfirmation
    Created on : 2019-jan-15, 12:58:10
    Author     : robin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your order was successful, you will receive an email.</h1>
        <form action="WebShopServlet" method="POST">
        <button type="submit" name="button" value="continueshopping">Home</button></form> <br>
        
      <form action="WebShopServlet" method="POST">
     <button type="submit" name="button" value="button3">Logout</button></form>
        
      
    </body>
</html>
