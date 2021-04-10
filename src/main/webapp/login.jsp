<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<%@include file="navbar.jsp" %>
<p class="text-center h1 my-5">Log In</p>

<div class="test-div">

    <form action="login" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username"
                   aria-describedby="username" placeholder="Enter username" required="">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password"
                   name="password" placeholder="Password" required="">
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Remember me</label>
        </div>
        <br>
        <button type="submit" class="btn btn-dark">Submit</button>
    </form>

</div>

</body>
</html>
