<%-- 
    Document   : RegisterScreen
    Created on : 2018-dec-30, 17:02:40
    Author     : jimmyjonsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register account</title>
    </head>
    <body>
        <form action="ServletCreateAcc" method="GET">
        <h1></h1>
        
        <h2>Please specify the following down below to become a member</h2><br>
            <b> Username: </b>  <input name="username" type="text"> <br><br>
            <b> Email: </b>  <input name="email" type="text"> <br><br>
            <b> Password: </b> <input name="password" type="text"> <br><br>
            
            <b>Credit Card No:  <input type="text" name="creditcard"/> </b><<br> <br><br>

            <input type="submit" value="Create account" />

    </body>
</html>
