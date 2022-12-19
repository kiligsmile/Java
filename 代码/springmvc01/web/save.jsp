<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/8
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

<h3>用户注册</h3>

<form action="MyCon2/demo4" method="post">

    <p>
        姓名:<input type="text" name="name"/>
    </p>
    <p>
        年龄:<input type="text" name="age"/>
    </p>
    <p>
        分数:<input type="text" name="score"/>
    </p>
    <p>
        出生日期:<input type="text" name="birth"/>
    </p>
    <p>
        爱好:
        抽烟:  <input type="checkbox" name="hobby" value="cy"/>
        喝酒:  <input type="checkbox" name="hobby" value="hj"/>
        烫头:  <input type="checkbox" name="hobby" value="tt"/>

    </p>
    <p>
        <input type="submit" value="注册"/>
    </p>


</form>

<a href="MyCon2/demo5?name=sxt&pid=123">删除</a>

<a href="MyCon2/demo5/sxt/123/eb3f5d9c0040d565/eb3f5d9c0040d5123">删除</a>

</body>
</html>
