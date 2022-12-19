<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/5
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

<h3>登陆页面</h3>

<form  action="servlet/UserController" method="post">

    <p>
       用户名: <input type="text" name="uname"/>${msg}
    </p>
    <p>
        密码: <input type="text" name="pwd"/>
    </p>
    <p>
       <input type="submit" value="登陆"/>
    </p>

</form>

</body>
</html>
