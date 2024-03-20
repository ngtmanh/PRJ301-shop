<%-- 
    Document   : adduser
    Created on : Feb 19, 2024, 3:47:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="dal.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TienManh-Shop</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <div class="container container-fluid">
            <div style="background-color: orangered" class="card-header my-3 d-flex align-items-center justify-content-between">
                <a style="color: white" href="#"><h5>Information Manage</h5></a>
                <a style="color: white" class="nav-link" href="logout">Log out</a>
            </div>
            <div class="row">
                <%@include file="includes/asideadmin.jsp" %>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="card mx-auto">
                        <div class="card-header text-center">Add User</div>
                        <div class="card-body">
                            <h2 style="color: red">${requestScope.error}</h2>
                            <form action="add-user" method="post">
                                <div class="form-group">
                                    <label>Customer ID: </label>
                                    <input type="number" class="form-control" name="customerID" placeholder="Enter CustomerID" required/>
                                </div>
                                <div class="form-group">
                                    <label>Username: </label>
                                    <input type="text" class="form-control" name="name" placeholder="Enter name" required/>
                                </div>
                                <div class="form-group">
                                    <label>Email : </label>
                                    <input type="email" class="form-control" name="email" placeholder="Enter email" required/>
                                </div>
                                <div class="form-group">
                                    <label>Address: </label>
                                    <input type="text" class="form-control" name="address" placeholder="Enter Address" required/>
                                </div>
                                <div class="form-group">
                                    <label>Phone: </label>
                                    <input type="text" class="form-control" name="phone" placeholder="Enter phone" required/>
                                </div>
                                <div class="form-group">
                                    <label>Password: </label>
                                    <input type="password" class="form-control" name="password" placeholder="********" required/>
                                </div>
                                <div class="text-center">
                                    <button style="background-color: orange; border: orangered"type="submit" class="btn btn-primary">Add</button>
                                    <button style="background-color: orange; border: orangered"type="reset" class="btn btn-primary">Reset</button>
                                </div>
                                   
                            </form>
                        </div>
                    </div>
                </main>
            </div>
        </div>

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
