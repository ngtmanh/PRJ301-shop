<%-- 
    Document   : showproducts
    Created on : Feb 19, 2024, 3:48:50 PM
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
        <title>JSP Page</title>
        <%@include file="includes/head.jsp" %>

        <%
            String message = (String) request.getSession().getAttribute("message");
            if (message!=null && message!="") {
        %>

        <script type="text/javascript">
            window.onload = function () {
                var message = '<%=message%>';
                if (message !== null && message !== '') {
                    alert(message, 3000);
                }
            };
        </script>
        <script src="includes/alert.js"></script>

        <%
            }
            request.getSession().removeAttribute("message");
        %>

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
                    <table class="table table-light">
                        <thead>
                            <tr>
                                <th scope="col">Product ID</th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Product Description</th>
                                <th scope="col">Image</th>
                                <th scope="col">Price</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.list}" var="o">
                                <tr>
                                    <td>${o.getProductID()}</td>
                                    <td>${o.getProductName()}</td>
                                    <td>${o.getDescription()}</td>
                                    <td><img src="images/${o.getProductImage()}"  style="height: 100px; width: 150px;"/></td>
                                    <td>${o.getPrice()}</td>
                                    
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>

                    <div style="text-align: center;" class="clearfix">
                        <div class="hint-text">Showing <b>${requestScope.tag}</b> out of <b>${requestScope.endP}</b> entries</div>
                        <ul class="pagination" style="display: flex; align-items: center; justify-content: center;">
                            <c:if test="${requestScope.tag>1}">
                                <li class="page-item">
                                    <a href="show-products?index=${requestScope.tag-1}" class="page-link" aria-label="Go to previous page">Previous</a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${requestScope.endP}" var="i">
                                <li class="page-item ${requestScope.tag == i?"active":""}">
                                    <a href="show-products?index=${i}" class="page-link">${i}</a>
                                </li> 
                            </c:forEach>
                            <c:if test="${requestScope.tag < requestScope.endP}">
                                <li class="page-item">
                                    <a href="show-products?index=${requestScope.tag+1}" class="page-link" aria-label="Go to next page">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </main>

            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
