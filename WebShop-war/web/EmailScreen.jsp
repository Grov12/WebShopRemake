<%-- 
    Document   : EmailScreen
    Created on : 2019-jan-23, 09:30:32
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
    <form method="POST" action="${pageContext.request.contextPath}/EmailServlet">
        <h2>Enter e-mail you registered with</h2><br>
            <b> Email </b>  <input name="email" type="text"> <br><br>
         
            
            

            <input type="submit" value="Send" />
    </form>
    </body>
</html>
