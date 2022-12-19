<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/20
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<table id="MenusManager_dg" title="My Menus" class="easyui-datagrid" style="width:700px;height:450px"
       url="SysMenusController/findAllMenus"
       toolbar="#MenusManager_toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">菜单ID</th>
        <th field="name" width="50">菜单名称</th>
        <th field="open" width="50">是否打开</th>
        <th field="pid" width="50">父菜单ID</th>
        <th field="url" width="50">菜单地址</th>
    </tr>
    </thead>
</table>

<div id="MenusManager_toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newMenus()">New Menus</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editMenus()">Edit Menus</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyMenus()">Remove Menus</a>
</div>


<div id="MenusManager_dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#MenusManager_dlg-buttons'">
    <form id="MenusManager_fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>Menus Information</h3>
        <div style="margin-bottom:10px">

            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-save" onclick="selectedMenus()" style="width:140px">父节点选择</a>

            <span id="pid_name"></span>
        </div>
        <div style="margin-bottom:10px">

            <input name="pid" id="pid" class="easyui-textbox" required="true" label="父节点ID:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="name" class="easyui-textbox" required="true" label="菜单名称:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="url" class="easyui-textbox" required="true" label="菜单路径:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="open" class="easyui-textbox" required="true" label="是否打开:" style="width:100%">
        </div>

        <input type="hidden" id="beforPid" name="beforPid"/>
    </form>
</div>
<div id="MenusManager_dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveMenus()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>


<div id="MenusManager_dlg2" class="easyui-dialog" style="width:400px;height: 600px" data-options="closed:true,modal:true,border:'thin'">

    <ul id="MenusManager_tt" class="easyui-tree" url="SysMenusController/findMoreMenus"></ul>


</div>

<script type="text/javascript">

    var  url;
    
    //删除菜单操作
    function  destroyMenus() {

        var row = $('#MenusManager_dg').datagrid('getSelected');

        if(row){

            $.messager.confirm("提示","是否删除指定数据?",function (flag) {

                if(flag){

                    //发送ajax请求执行删除
                    $.post("SysMenusController/removeMenus",{id:row.id},function (result) {

                        if(result>0){
                          //刷新表格数据
                            $("#MenusManager_dg").datagrid("reload");

                        }else if(result==-100){
                            $.messager.alert("提示","当前节点下有子菜单","error");
                        }
                        else{
                            $.messager.alert("提示","删除失败","error");
                        }
                    })
                }


            })

        }else {
            $.messager.alert("提示","请至少选中一行数据","info");
        }
    }
    

    //修改菜单操作
    function  editMenus() {

        var row = $('#MenusManager_dg').datagrid('getSelected');

        if(row){
            //对话框的打开
            $("#MenusManager_dlg").dialog("open").dialog("center").dialog("setTitle","修改菜单");

            //数据的回显
            $("#MenusManager_fm").form("load",row);

            $("#beforPid").val(row.pid);

            url="SysMenusController/changeMenus?id="+row.id;
        }else{
            $.messager.alert("⚠警告","请至少选中一行数据","warning")
        }



    }
    

    //添加菜单
    function saveMenus() {

       var  val= $("form").serialize();

       $.post(url,val,function (result) {

           if(result>0){

               //关闭当前的添加对话框
               $("#MenusManager_dlg").dialog("close")

               //刷新后面的数据表格
               $("#MenusManager_dg").datagrid("reload");


           }

       })

    }
    
    
    
    $(function () {
        $('#MenusManager_tt').tree({
            onDblClick: function(node){
                 console.log(node);
                //[A]关闭当前选择的对话框
                $("#MenusManager_dlg2").dialog("close");

                //[B]把选中的内容赋值给input文本框
                $("#pid").textbox("setValue",node.id);

                $("#pid_name").html(node.text);



            }
        });


    })





    //点击选择菜单
    function selectedMenus() {
        $("#MenusManager_dlg2").dialog("open").dialog("center").dialog("setTitle","选择父节点ID");

    }
    
    
    function newMenus() {

        $("#MenusManager_dlg").dialog("open").dialog("center").dialog("setTitle","新增菜单");

        //清空表单数据
        $("#MenusManager_fm").form("clear");

        url="SysMenusController/saveMenus"

    }
    
    
</script>

</body>
</html>
