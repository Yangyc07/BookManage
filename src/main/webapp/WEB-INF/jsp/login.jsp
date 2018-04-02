<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.2
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <style>
        body{
            background-color: #4dff78;
            text-align: center;
        }

        .form-inline{
            padding-right: 15px;
            padding-left: 15px;
            margin-left: auto;
            margin-right: auto;
            height: 720px;
            max-width: 330px;
            padding-top: 50px;
        }
        .form-inline input{
            margin-bottom: 8px;
            outline: none;
            padding: 10px;
            font-size: 10px;
            color: #fff;
            border-radius: 4px;
            background-color: #2D2D3F;
        }
        .form-inline .form-control{
            position: relative;
            height: auto;
            padding: 10px;
            font-size: 16px;
            width: 300px;
        }
        .btn{
            width: 300px;
            min-height: 40px;
            display: block;
            background-color: #4a77d4;
            border: 1px solid #3762bc;
            color: #fff;
            padding: 10px 16px;
            font-size: 18px;
            line-height: normal;
            border-radius: 6px;
            margin: 0;
            text-decoration: none;
            text-align: center;
        }

        .checkbox{
            margin-left: -160px;
            font-size: 18px;
            color: #FFE4E1;
        }
    </style>
</head>
<body>
<form action="<c:url value="loginCheck.html"/>" method="post">
    用户名：
    <input type="text" name="userName">
    <br>
    密 码：
    <input type="password" name="password">
    <br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
</form>
</body>
</html>