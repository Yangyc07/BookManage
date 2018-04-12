<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.12
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_manage.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑学生信息</title>
</head>
<body>
<div style="padding: 10px 100px 10px;">
    <form action="do_edit_reader.html" method="post">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">编辑学生信息</h3>
            </div>
            <div class="panel-body">
                <div class="input-group">
                    <span class="input-group-addon">读者号</span>
                    <input type="text" class="form-control" name="readerId" value="${readerInfo.readerId}">
                </div>
                <br>

                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" value="${readerInfo.name}">
                </div>
                <br>

                <div class="input-group">
                    <span class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" value="${readerInfo.sex}">
                </div>
                <br>

                <div class="input-group">
                    <span class="input-group-addon">生日</span>
                    <input type="text" class="form-control" name="birth" value="${readerInfo.birth}">
                </div>
                <br>

                <div class="input-group">
                    <span class="input-group-addon">地址</span>
                    <input type="text" class="form-control" name="address" value="${readerInfo.address}">
                </div>
                <br>

                <div class="input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="telCode" value="${readerInfo.telcode}">
                </div>
                <br>
                <input class="btn btn-primary btn-lg" type="submit" value="提交">
            </div>
        </div>
    </form>
</div>
</body>
</html>