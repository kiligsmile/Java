<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/14
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <base href="<%=request.getContextPath()+"/"%>">

</head>
<body>

<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:450px"
       url="findMoreUser"
       toolbar="#toolbar" pagination="true"
       rownumbers="false" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="uid" width="50">用户ID</th>
        <th field="uname" width="50">用户名</th>
        <th field="pwd" width="50">用户密码</th>

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

      var  url;

      //删除操作
      function destroyUser() {
          var row = $('#dg').datagrid('getSelected');

          if(row){
              $.messager.confirm("提示","是否删除该数据?",function (flag) {

                  if(flag){
                      //进行删除的操作

                      $.post("remomveUser",{uid:row.uid},function (result) {

                          if(result>0){
                              //重新加载数据表格
                              $("#dg").datagrid('reload');
                          }else{
                              $.messager.alert("提示","删除失败","error");
                          }
                      })
                  }
              })

          }else{
              $.messager.alert("提示","请至少选中一行数据","info");
          }

      }



    //修改操作
    function editUser() {
        var row = $('#dg').datagrid('getSelected');

        console.log(row);
        if(row){


            //把对话框打开
            $("#dlg").dialog("open").dialog("center").dialog("setTitle","新建用户");
            ////把数据直接回显到form表单中
            $("#fm").form('load',row);
            url="changeUser";

        }else{
            $.messager.alert("提示","请至少选中一行数据","info")
        }
    }



    //添加操作
    function newUser() {

        $("#dlg").dialog("open").dialog("center").dialog("setTitle","新建用户");

        $('#fm').form('clear');

        url="saveUser";
    }
    
    function  saveUser() {
        //完成添加操作

       var  val= $("form").serialize();
        $.post(url,val,function (result) {

            if(result>0){

                //关闭当前的对话框
                $('#dlg').dialog('close');

                //刷新表格的数据
                $("#dg").datagrid('reload')

            }else {
                $.messager.show({
                    title:'提示',
                    msg:'操作失败',
                    showType:'show'
                });
            }
        })
    }
</script>

</body>
</html>
