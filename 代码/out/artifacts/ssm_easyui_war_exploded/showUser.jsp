<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户展示页面</title>

</head>
<body>

<table id="dg" title="用户展示" class="easyui-datagrid" style="width:700px;height:550px"
       url="UserController/UserfindAll"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="uid" width="50">用户ID</th>
        <th field="uname" width="50">用户姓名</th>
        <th field="pwd" width="50">用户密码</th>
    </tr>
    </thead>

</table>

    <%--工具栏的展示--%>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
    </div>

    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>User Information</h3>
            <div style="margin-bottom:10px">
                <input name="uid" class="easyui-textbox" required="true" label="用户ID:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="uname" class="easyui-textbox" required="true" label="用户名称:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="pwd" class="easyui-textbox" required="true" label="用户密码:" style="width:100%">
            </div>
        </form>
    </div>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>


<script type="text/javascript">

    var   url;
    
    function   newUser() {

        //打开新建用户的窗口
        $('#dlg').dialog('open').dialog('center').dialog('setTitle','新建用户');

        $('#fm').form('clear');

        url="UserController/userSave";

    }

    //提交表单内容数据
    function  saveUser() {

        $('#fm').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.errorMsg){
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg,
                        showType:'show'
                    });
                } else {
                    $('#dlg').dialog('close');        // 关闭添加的窗口
                    $('#dg').datagrid('reload');    // 重新加载数据
                }
            }
        });
        
    }


    //弹出窗口进行数据的回显
    function editUser(){
        // object  {uid:1,uname:'123',pwd:'123'}
        var row = $('#dg').datagrid('getSelected');

        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');

            //把获得数据给表单
            $('#fm').form('load',row);

            url="UserController/userUpdate"

        }else{
            $.messager.alert('警告','请至少选择一行数据！','info');
        }
    }


    //删除的操作
    function destroyUser(){

        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('Confirm','是否删除该用户?',function(r){
                if (r){
                    $.post('UserController/userDelete',{uid:row.uid},function(result){
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
        }else{
            $.messager.alert('警告','请至少选择一行数据！','info');
        }
    }
    
    
</script>




</body>
</html>
