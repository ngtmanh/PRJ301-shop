<%-- 
    Document   : admin
    Created on : Feb 18, 2024, 10:34:39 PM
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
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    Number of products: ${sessionScope.totalProducts}
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    Number of users: ${sessionScope.totalUsers}
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>

        <%@include file="includes/footer.jsp" %>
    </body>
</body>
</html>
