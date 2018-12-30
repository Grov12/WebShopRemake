<%-- 
    Document   : RegisterScreen
    Created on : 2018-dec-30, 19:09:34
    Author     : jimmyjonsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create account</title>
    </head>
    <body>
        <form action="LoginServlet" method="GET">
        
        
        <h2>Please specify the following down below</h2><br>
            <b> Userame: </b>  <input name="username" type="text"> <br><br>
            <b> Password </b>  <input name="password" type="text"> <br><br>
            <b> Email: </b> <input name="size" type="email"> <br><br>
            
            <b>Credit Card No:  <input type="text" name="creditcard"/> </b><<br> <br><br>

            <input type="submit" value="Create Account" />

    </body>
</html>
