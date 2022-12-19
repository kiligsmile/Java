<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/11
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

<%--
   JSP页面必须注意的事项：
     A、method="post"  get提交的方式有大小限制  get的传输方式依附于URL地址的

    B、 enctype="multipart/form-data"
         指定文件按照二进制流方式传输

--%>

<h3>用户添加</h3>
<form action="FileController/fileUpLoad" method="post" enctype="multipart/form-data">

    <p>
        用户名: <input type="text" name="uname"/>
    </p>
    <p>
        密码: <input type="text" name="pwd"/>
    </p>
    <p>
        分数: <input type="text" name="score"/>
    </p>
    <p>
        文件: <input type="file" name="fil"/>${msg}
    </p>
    <p>
        <input type="submit" value="提交"/>
    </p>


</form>


</body>
</html>
