<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/5/25
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../css/login.style.css">
</head>
<body>

<div id="content">
    <div class="login-header">
        <img src="../images/File.jpg">
    </div>
    <form method="post" action="register" name="userReg">
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input type="text" placeholder="Please enter your username" required name="username">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" placeholder="Please enter your password" required name="password">
        </div>

        <div class="remember-box">

        </div>
        <div class="login-button-box">
            <input type="submit" value="注册">
        </div>
    </form>
    <div class="logon-box">
    </div>
</div>

</body>
</html>