<%-- 
    Document   : LoginScreen
    Created on : 2018-dec-30, 18:41:37
    Author     : jimmyjonsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to Webshop</title>
    </head>
    <body>
        <form action="LoginServlet" method="GET">
        Enter your Username and password to login<br><br>
            <b> Username: <input type="text" name="name"/></b><br><br>
            <b>Password:  <input type="password" name="pword"/> </b><br> <br><br>

            <input type="submit" value="Login in" />
            
            <br><br>
            
            <a href="RegisterServlet" >Create Account</a><br><br>
            <a href="EmailServlet" >Recover password</a>
            
    </body>
</html>
