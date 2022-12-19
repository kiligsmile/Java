<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/24
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单展示页面</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body>

    <table id="dg" title="My Menus" class="easyui-datagrid" style="width:700px;height:500px"
           url="SysMenusCont/findAllMenus"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="id" width="50">菜单ID</th>
            <th field="pid" width="50">父节点ID</th>
            <th field="name" width="50">菜单名称</th>
            <th field="url" width="50">菜单路径</th>
            <th field="open" width="50">是否打开</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newMenus()">New Menus</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editMenus()">Edit Menus</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyMenus()">Remove Menus</a>
    </div>


    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>Menus Information</h3>

            <div style="margin-bottom:10px">

                <a href="javascript:void(0)" onclick="myMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="width: 130px">请选择父节点</a>

                <span id="n"></span>
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
                <input name="open" class="easyui-textbox" required="true"  label="是否打开:" style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveMenu2()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>


    <div id="dlg2" class="easyui-dialog" style="width:400px;height: 500px" data-options="closed:true,modal:true,border:'thin'">

        <ul id="tt" class="easyui-tree" url="SysMenusCont/findMoreMenus">
        </ul>

    </div>


    <script type="text/javascript">

        var   url;
        
        
        function  destroyMenus() {

            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','是否确认删除?',function(r){
                    if (r){
                        $.post('SysMenusCont/removeMenus',{id:row.id},function(result){
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
        
        
        function  editMenus() {

            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit Menus');
                $('#fm').form('load',row);
                url = 'SysMenusCont/changeMenus?id='+row.id;
            }
            
        }
        
        function  saveMenu2() {

            $('#fm').form('submit',{
                url: url,
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
        

        $(function () {

            $('#tt').tree({
                onDblClick: function(node){

                    //[1]把当前的选择的窗口关闭
                    $("#dlg2").dialog('close');

                    $("#n").html(node.text);

                    $("#pid").textbox("setValue",node.id);



                }
            });




        })
    
    
    
    function myMenu() {

        $('#dlg2').dialog('open').dialog('center').dialog('setTitle','节点展示');

    }
    
    
    function  newMenus() {

        $('#dlg').dialog('open').dialog('center').dialog('setTitle','New Menus');

        $('#fm').form('clear');

        url="SysMenusCont/saveMenus";
    }
    
    
</script>

</body>
</html>
