<nav style="background-color: orangered" class="navbar navbar-expand-lg navbar-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <img src="images/logo.jpg" alt="logo" style="height: 150px"/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a style="color: white" class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item active">
                    <a style="color: white" class="nav-link" href="pagination">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">
                        <img src="images/cart.jpg" alt="cart" style="height: 30px" />
                        <span class="badge badge-danger">${(cart_list.size()>0)?cart_list.size():0}</span></a>
                </li>
                <%
                    if (auth!=null) {
                %>
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="orders.jsp">Orders</a>
                </li>
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="myaccount.jsp">My Account</a>
                </li>                 
                <li class="nav-item">
                    <a style="color: white; text-decoration: underline" class="nav-link" href="logout">Log out</a>
                </li>              
                <%
                    } else {
                %>
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="signup.jsp">Sign up</a>
                </li>                
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>