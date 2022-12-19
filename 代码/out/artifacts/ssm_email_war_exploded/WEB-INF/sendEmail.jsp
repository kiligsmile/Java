<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/12
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

 <h3>邮件发送</h3>
 <h3>当前用户是:${sessionScope.user.uname}</h3>

<form action="EmailController/sendEmail" method="post" enctype="multipart/form-data">

    <p>
        收件人:<select name="recid">

              <option>--请选择--</option>
              <option value="1">admin</option>
              <option value="2">bjsxt</option>
              <option value="3">zs</option>
              </select>
    </p>
    <p>
        主题:<input type="text" name="etitle"/>
    </p>
    <p>
        正文:<input type="text" name="econ"/>
    </p>
    <p>
        附件:<input type="file" name="fil"/>
    </p>
    <p>
        <input type="submit" value="发送"/>
    </p>


</form>

</body>
</html>
