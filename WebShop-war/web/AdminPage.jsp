<%-- 
    Document   : AdminPage
    Created on : 2019-jan-17, 13:48:09
    Author     : robin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    </head>
    <body>
            <form action="AdminServlet" method="POST">
             Delete user<br><br>
            <b> Username: <input type="text" name="nameOfUser"/></b><br><br>
            <button type="submit" name="button" value="button1">Delete user</button><br><br>
             ${Yo}
            
              Add new products<br><br>
            <b> Product name: <input type="text" name="nameOfProduct"/></b><br><br>
            <b> Product price: <input type="text" name="priceOfProduct"/></b><br><br>
            <b> Product quantity: <input type="text" name="quantityOfProduct"/></b><br><br>
            <button type="submit" name="button" value="button2">Add product </button></b><br><br>
            
             <button type="submit" name="button" value="button3">Logout</button>
            
    </body>
</html>
