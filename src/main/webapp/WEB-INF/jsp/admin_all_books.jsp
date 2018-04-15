<%--
  Created by IntelliJ IDEA.
  User: 杨亚宸
  Date: 18.4.12
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="admin_manage.jsp" %>
<html>
<head>
    <title>全部图书</title>
</head>
<body>
<c:if test="${!empty success}">
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">
            &times;
        </a>
            ${success}
    </div>

</c:if>
<table class="table  table-hover">
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
            <c:if test="${book.state==1}">
                <td>
                    <button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#myModal">借出
                    </button>
                </td>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <form action="lend_book.html">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">借出图书</h4>
                                </div>
                                <div class="modal-body" style="height:130px">

                                    <div class="form-group">
                                        <label for="bookId" class="col-sm-2 control-label">图书号</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="bookId" readonly
                                                   value="${book.book_id}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="readerId" class="col-sm-2 control-label">读者号</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="readerId">
                                        </div>
                                    </div>
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <input type="submit" class="btn btn-primary" value="借出"></input>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </form>
                </div>
            </c:if>
            <c:if test="${book.state==0}">
                <td><a href="return_book.html?bookId=${book.book_id}">
                    <button type="button" class="btn btn-info btn-xs">归还</button>
                </a></td>
            </c:if>
            <td><a href="update_book.html?bookId=${book.book_id}">
                <button type="button" class="btn btn-info btn-xs">编辑</button>
            </a></td>
            <td><a href="delete_book.html?bookId=${book.book_id}">
                <button type="button" class="btn btn-danger btn-xs">删除</button>
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>