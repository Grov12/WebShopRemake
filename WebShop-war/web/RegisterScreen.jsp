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
        
        
    <form method="POST" action="${pageContext.request.contextPath}/RegisterServlet">
        <h2>Please specify the following down below to register</h2><br>
            <b> Username: </b>  <input name="username" type="text"> <br><br>
            <b> Password </b>  <input name="password" type="password"> <br><br>
            <b> Email </b>  <input name="email" type="text"> <br><br>
            
            

            <input type="submit" value="Create Account" />
    </form>
    </body>
</html>
