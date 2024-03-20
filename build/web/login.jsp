
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/login.css">
<!-- Form -->


<div class="form-container">
    <form action="login" method="post">
        <a class="logo"><img src="images/logo.png"></a>
        <c:if test="${not empty note}">
        <p style="background: #dc3545; text-align: center">${requestScope.note}</p>
        </c:if>
        <!-- Email input -->
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1" >Email address</label>
            <input type="email" id="form2Example1" class="form-control" name="email" />        
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example2" >Password</label>
            <input type="password" id="form2Example2" class="form-control" name="pass"/>       
        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <div class="col d-flex justify-content-center">
                <!-- Checkbox -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                    <label class="form-check-label" for="form2Example31"> Remember me </label>
                </div>
            </div>

            
        </div>

        <!-- Submit button -->
        <input type="submit" class="btn btn-primary btn-block mb-4" value="Sign In">

        <!-- Register buttons -->
        <div class="text-center">
            <p>Not a member? <a href="newaccount.jsp">Register</a></p>            
        </div>
    </form>
</div>