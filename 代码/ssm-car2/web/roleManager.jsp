<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/20
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<table id="roleManager_dg" title="My Roles" class="easyui-datagrid" style="width:700px;height:450px"
       url="SysRolesController/findAllRoles"
       toolbar="#roleManager_toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="roleid" width="50">角色ID</th>
        <th field="rolename" width="50">角色名称</th>
        <th field="roledesc" width="50">角色描述</th>
    </tr>
    </thead>
</table>

<div id="roleManager_toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRoles()">New Roles</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRoles()">Edit Roles</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRoles()">Remove Roles</a>
</div>

<div id="roleManager_dlg" class="easyui-dialog" style="width:400px;height: 600px" data-options="closed:true,modal:true,border:'thin',buttons:'#roleManager_dlg-buttons'">
    <form id="roleManager_fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>Role Information</h3>
        <div style="margin-bottom:10px">
            <input name="rolename" class="easyui-textbox" required="true" label="角色名称:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="roledesc" class="easyui-textbox" required="true" label="角色描述:" style="width:100%">
        </div>

        <div style="margin-bottom:10px">
           用户菜单: <ul id="roleManager_tt" class="easyui-tree" data-options="url:'SysMenusController/findMoreMenus2',method:'get',animate:true,checkbox:true"></ul>

        </div>

         <input type="text" name="roleid" id="roleid"/>
    </form>
</div>
<div id="roleManager_dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRoles()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>

<script type="text/javascript">

    var  url;
    
    function destroyRoles() {
        var row = $('#roleManager_dg').datagrid('getSelected');

        if(row){
            $.messager.confirm("提示","是否删除指定数据?",function (flag) {
                if(flag){

                    $.post("SysRolesController/removeRoles",{rid:row.roleid},function (result) {

                        if(result>0){
                            $("#roleManager_dg").datagrid("reload");
                        }else {
                             $.messager.alert("提示","删除失败","error");
                        }

                    })

                }
            })
        }
    }

    function editRoles() {

        var row = $('#roleManager_dg').datagrid('getSelected');

        if(row){

            $("#roleManager_dlg").dialog("open").dialog("center").dialog("setTitle","修改角色");

            $("#roleManager_fm").form("load",row);

            //发送ajax请求查询指定的菜单ID 
            
            $.post("RmController/findMid",{rid:row.roleid},function (result) {

                    for(var  i in result){

                        //找到指定的节点对象
                       var node= $("#roleManager_tt").tree('find',result[i]);
                       //选中指定的节点对象
                       $("#roleManager_tt").tree('check',node.target);
                }
            })

             //给roleid赋值
            $("#roleid").val(row.roleid);

           url="SysRolesController/changeRoles";

        }


    }

    function saveRoles() {


        //获得选中的菜单
        var nodes = $('#roleManager_tt').tree('getChecked');
        var s = '';
        for(var i=0; i<nodes.length; i++){
            if (s != '') s += ',';
            s += nodes[i].id;
        }


        //获得没有全部选中子节点的父节点
        var nodes2 = $('#roleManager_tt').tree('getChecked', ['indeterminate']);

        if(nodes2.length!=0){
            var s2 = '';
            for(var i=0; i<nodes2.length; i++){
                if (s2 != '') s2 += ',';
                s2 += nodes2[i].id;
            }
           s+=","+s2;
        }
        //  2,4,6,7,8,9,28
        alert(s);



        var  val =$("#roleManager_fm").serialize();
        //  SysRolesController/saveRoles?mids=
        $.post(url+"?mids="+s,val,function (result) {

            if(result>0){

                $("#roleManager_dlg").dialog("close");

                $("#roleManager_dg").datagrid("reload");
            }else {
                $.messager.alert("警告","添加失败","error");
            }

        })

    }


    function newRoles() {

        $("#roleManager_dlg").dialog("open").dialog("center").dialog("setTitle","新建角色");

        $("#roleManager_fm").form("clear");

        $("#roleid").val(0);

        url="SysRolesController/saveRoles";

    }
    
</script>



</body>
</html>
