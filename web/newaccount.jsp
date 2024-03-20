<%-- 
    Document   : newaccount
    Created on : Mar 7, 2024, 7:41:37 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/newaccount.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="newaccount" method="post">
        <label for="customerID">Customer ID:</label><br>
        <input type="text" id="customerID" name="customerID"><br>
        
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>
        
        <label for="address">Address:</label><br>
        <input type="text" id="address" name="address"><br>
        
        <label for="phoneNumber">Phone Number:</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber"><br>
        
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        
        <input type="submit" value="Submit">
    </form>
    </body>
</html>
