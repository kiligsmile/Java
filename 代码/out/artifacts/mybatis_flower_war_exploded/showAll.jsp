<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/4
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>花卉信息展示</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

<table border="1px">
    <tr>
        <th>花卉ID</th>
        <th>花卉名称</th>
        <th>花卉价格</th>
        <th>花卉产地</th>
    </tr>

    <c:forEach items="${list}" var="flower">
        <tr>
            <th>${flower.id}</th>
            <th>${flower.name}</th>
            <th>${flower.price}</th>
            <th>${flower.production}</th>
        </tr>

    </c:forEach>
</table>







</body>
</html>
