<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.12
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_manage.jsp"%>
<html>
<head>
    <title>全部图书</title>
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
<table class="table  table-hover" >
    <thead>
    <tr>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>ISBN</th>
        <th>价格</th>
        <th>借还</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.publish}</td>
            <td>${book.isbn}</td>
            <td>${book.price}</td>
            <td>${book.state}</td>
            <td><a href="update_book.html?bookId=${book.book_id}"><button type="button" class="btn btn-info btn-xs">编辑</button></a></td>
            <td><a href="delete_book.html?bookId=${book.book_id}"><button type="button" class="btn btn-danger btn-xs">删除</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>