<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

<c:forEach items="${list}" var="menu">

    <h3>${menu.mname}</h3>

    <c:forEach items="${menu.list}" var="m">

        <p>&nbsp;&nbsp;&nbsp;<a href="${m.url}">${m.mname}</a></p>

    </c:forEach>

</c:forEach>

</body>
</html>
