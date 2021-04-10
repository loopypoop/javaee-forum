<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user" class="uni.iitu.beans.UserBean" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<header>
    <div class="container">
        <nav class="navbar navbar-expand">
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AllPostsServlet">Posts</a>
                    </li>

                    <li class="nav-item"><a class="nav-link">
                        About</a>
                    </li>
                </ul>
            </div>

            <div class="authorize">

                <% if (user.getUsername() != null) { %>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link">
                        <jsp:getProperty name="user" property="username"/>
                    </a></li>
                    <li class="nav-item"><a href="LogoutServlet" class="nav-link">Log out</a></li>
                </ul>
                <% }
                if (user.getUsername() == null) { %>
                <a class="nav-link" href="login.jsp">Log in</a>
                <% } %>
            </div>
        </nav>
    </div>
</header>
