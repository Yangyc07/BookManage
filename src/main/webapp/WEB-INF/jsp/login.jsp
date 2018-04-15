<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.2
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图书管理系统</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
    <link href="Login.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style type="text/css">
        .form-signin{
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
            background: #29d1b0;
        }

    </style>
</head>
<body>
<div class="container">
    <form action="loginCheck.html" class="form-signin" method="post">
        <h2 class="form-signin-heading">登陆</h2>
        <label  for="inputId">账号</label>
        <input type="text" name="id" id="inputId" placeholder="请输入账号" class="form-control">
        <label  for="Password">密码</label>
        <input type="password" name="password" id="Password" placeholder="请输入密码" class="form-control">
        <div class="check-box">
            <input value="remember-me" type="checkbox">
            remember me
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">sign in</button>
    </form>
</div>
</body>
</html>