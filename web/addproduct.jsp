<%-- 
    Document   : addproduct
    Created on : Feb 19, 2024, 3:48:33 PM
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
                        <div class="card-header text-center">Add Product</div>
                        <div class="card-body">
                            <h2 style="color: red">${requestScope.error}</h2>
                            <form action="add-product" method="post">
                                <div class="form-group">
                                    <label>Product ID : </label>
                                    <input type="text" class="form-control" name="productID" required/>
                                </div>
                                <div class="form-group">
                                    <label>Product name: </label>
                                    <input type="text" class="form-control" name="name" placeholder="Enter product name" required/>
                                </div>
                                <div class="form-group">
                                    <label>Description: </label>
                                    <input type="text" class="form-control" name="description" placeholder="Enter description" required/>
                                </div>
                                
                                <div class="form-group">
                                    <label>Price: </label>
                                    <input type="number" class="form-control" name="price" placeholder="Enter price" required/>
                                </div>
                                <div class="form-group">
                                    <label>Stock: </label>
                                    <input type="number" class="form-control" name="stock" value="${c.stock}" required/>
                                </div>
                                <div class="form-group">
                                    <label>Image: </label>
                                    <input type="text" class="form-control" name="image" required/>
                                </div>
                                <div class="form-group">
                                    <label>Category ID: </label>
                                    <input type="text" class="form-control" name="category" placeholder="Enter category" required/>
                                </div>
                                                               
                                <div class="text-center">
                                    <button style="background-color: orange; border: orange" type="submit" class="btn btn-primary">Add</button>
                                    <button style="background-color: orange; border: orange" type="reset" class="btn btn-primary">Reset</button>
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
