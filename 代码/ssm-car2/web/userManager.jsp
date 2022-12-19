<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/21
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:450px"
       url="SysUserController/findAllUsers"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="userid" width="50">用户ID</th>
        <th field="loginname" width="50">登陆名称</th>
        <th field="realname" width="50">真实姓名</th>
        <th field="identity" width="50">身份证号</th>
        <th field="position" width="50">职位</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>User Information</h3>
        <div style="margin-bottom:10px">
            <input name="firstname" class="easyui-textbox" required="true" label="First Name:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="lastname" class="easyui-textbox" required="true" label="Last Name:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="phone" class="easyui-textbox" required="true" label="Phone:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="email" class="easyui-textbox" required="true" validType="email" label="Email:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">

            <input class="easyui-combobox" name="language" style="width:100%;" data-options="
                    url:'SysRolesController/findMore2',
                    method:'get',
                    valueField:'roleid',
                    textField:'rolename',
                    panelHeight:'auto',
                    label: '用户角色:',
                    labelPosition: 'left'
                    ">

        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>

<script type="text/javascript">
    
    
    function newUser() {

        $("#dlg").dialog("open").dialog("center").dialog("setTitle","新增用户")
        
    }
    
</script>

</body>
</html>
