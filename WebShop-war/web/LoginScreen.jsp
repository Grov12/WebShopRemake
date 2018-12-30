<%-- 
    Document   : LoginScreen
    Created on : 2018-dec-30, 16:47:04
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
        <form action="ServletLogic" method="GET">
        <br>Login with username and password<br>
            <b> Name: <input type="text" name="name"/></b><br><br>
            <b> Password:  <input type="text" name="pword"/> </b><<br> <br><br>

            <input type="submit" value="Register" />
            
            <br><br>
            
                   
    </body>
    
    <body>
        <form action="ServletCreateAcc" method="GET">
        
            <input type="submit" value="Register account" />
    </body>
    
    
</html>
