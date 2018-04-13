<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.13
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_manage.jsp"%>
<html>
<head>
    <title>全部借阅</title>
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
        <th>流水号</th>
        <th>图书号</th>
        <th>读者账号</th>
        <th>借出时间</th>
        <th>归还时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="lend" items="${lends}">
        <tr>
            <td>${lend.sernum}</td>
            <td>${lend.book_id}</td>
            <td>${lend.reader_id}</td>
            <td>${lend.lend_date}</td>
            <td>${lend.back_date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>