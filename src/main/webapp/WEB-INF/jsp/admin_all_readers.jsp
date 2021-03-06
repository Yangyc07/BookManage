<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.9
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_manage.jsp" %>
<html>
<head>
    <title>全部读者</title>
</head>
<body>
<c:if test="${!empty error}">
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${b2}
    </div>
</c:if>
<table class="table  table-hover">
    <thead>
    <tr>
        <th>读者号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
        <th>地址</th>
        <th>电话</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reader" items="${readers}">
        <tr>
            <td>${reader.readerId}</td>
            <td>${reader.name}</td>
            <td>${reader.sex}</td>
            <td>${reader.birth}</td>
            <td>${reader.address}</td>
            <td>${reader.telcode}</td>
            <td><a href="admin_edit_reader.html?readerId=${reader.readerId}">
                <button type="button" class="btn btn-info btn-xs">编辑</button>
            </a></td>
            <td><a href="reader_delete.html?readerId=${reader.readerId}">
                <button type="button" class="btn btn-info btn-xs">删除</button>
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>