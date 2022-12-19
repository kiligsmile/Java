<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/12
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>
<h3>用户的登陆</h3>

<form action="UserController/userLogin" method="post">

    <p>
       用户名: <input type="text" name="uname"/>${msg}
    </p>
    <p>
        密码:<input type="text" name="pwd"/>
    </p>
    <p>
        <input type="submit" value="登陆"/>
    </p>

</form>

</body>
</html>
