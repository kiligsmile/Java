<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/25
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>

    <table id="dg" title="My Roles" class="easyui-datagrid" style="width:700px;height:450px"
           url="SysRolesCont/sysRolesFindAll"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="roleid" width="50">角色ID</th>
            <th field="rolename" width="50">角色名称</th>
            <th field="roledesc" width="50">角色描述</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRoles()">New Roles</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRoles()">Edit Roles</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRoles()">Remove Roles</a>
    </div>


    <div id="dlg" class="easyui-dialog" style="width:400px;height: 550px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>Role Information</h3>
            <div style="margin-bottom:10px">
                <input name="rolename" class="easyui-textbox"  label="角色名称:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="roledesc" class="easyui-textbox" label="角色描述:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">

                菜单展示:
                <ul id="tt" class="easyui-tree" data-options="url:'SysMenusCont/findMoreMenus1',method:'get',animate:true,checkbox:true,cascadeCheck:false"></ul>

            </div>

            <input type="text" name="roleid" id="rid" value="0"/>

        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRoles()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>


<script type="text/javascript">

    var  url;


    function destroyRoles() {


        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                if (r){
                    $.post('SysRolesCont/sysRolesRemove',{rid:row.roleid},function(result){
                        if (result.success){
                            $('#dg').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        }
                    },'json');
                }
            });
        }


    }


    function  editRoles() {

        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit Roles');
            $('#fm').form('load',row);
            url = 'SysRolesCont/sysRoleschange';

            //把roleid进行赋值
            $("#rid").val(row.roleid)

             $.post("RmCont/rmFindMore","rid="+row.roleid,function (data1) {


                 for(var  i  in   data1){

                     //查找到指定的节点对象
                     var node = $('#tt').tree('find', data1[i]);

                     //选择指定的查询出来的对象
                     $('#tt').tree('check', node.target);

                 }


             })

        }
        
    }
    
    
    function  newRoles() {

        $('#dlg').dialog('open').dialog('center').dialog('setTitle','New Role');

        $('#fm').form('clear');

        $("#rid").val(0);

        url="SysRolesCont/sysRolesSave";
    }
    
    
    function   saveRoles() {


            //获得全部选中的节点对象
            var nodes = $('#tt').tree('getChecked');

            //获取未全部选中子节点的父节点
           var nodes2 = $('#tt').tree('getChecked', ['indeterminate']);

            var s = '';
            for(var i=0; i<nodes.length; i++){
                if (s != '') s += ',';
                s += nodes[i].id;
            }


            if(nodes2!=null&&nodes2!=''){

                var s2 = '';
                for(var i=0; i<nodes2.length; i++){
                    if (s2 != '') s2 += ',';
                    s2 += nodes2[i].id;
                }

                //  1 , 2, 3  ,    7,9
                s+=","+s2;

            }

        $('#fm').form('submit',{
            url: url+"?mmids="+s,
            success: function(result){
                var result = eval('('+result+')');
                if (result.errorMsg){
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {
                    $('#dlg').dialog('close');        // close the dialog
                    $('#dg').datagrid('reload');    // reload the user data
                }
            }
        });
        
    }
    
    
</script>

</body>
</html>
