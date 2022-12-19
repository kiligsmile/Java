<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/11
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <base href="<%=request.getContextPath()+"/"%>">
  </head>
  <body>

  <h3>index.jsp</h3>

  <%--转发到指定的页面中--%>
  <%--<jsp:forward page="WEB-INF/update.jsp"></jsp:forward>--%>

  <a href="WEB-INF/update.jsp">update.jsp</a>


  </body>
</html>
