<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/26
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body>


<table id="dg" title="My Log" class="easyui-datagrid" style="width:700px;height:450px"
       url="SysLogLoginCont/LogLoginfindAll"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">日志ID</th>
        <th field="loginip" width="50">登录IP</th>
        <th field="loginname" width="50">登录名称</th>
        <th field="logintime" width="50">登录时间</th>
    </tr>
    </thead>
</table>

</body>
</html>
