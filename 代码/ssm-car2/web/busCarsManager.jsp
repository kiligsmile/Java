<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/18
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汽车管理</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<table id="busCarsManager_dg" title="My Car" class="easyui-datagrid" style="width:700px;height:450px"
       url="busCarsController/findAllBusCars"
       toolbar="#busCarsManager_toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="carnumber" width="50">汽车牌号</th>
        <th field="cartype" width="50">汽车类型</th>
        <th field="price" width="50">汽车价格</th>
        <th field="description" width="50">汽车描述</th>
        <th data-options="field:'carimg',formatter:showImage"  width="50">汽车图片</th>
    </tr>
    </thead>
</table>

<div id="busCarsManager_toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCars()">New Cars</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCars()">Edit Cars</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyCars()">Remove Cars</a>
</div>

<div id="busCarsManager_dlg" class="easyui-dialog" style="width:550px" data-options="closed:true,modal:true,border:'thin',buttons:'#busCarsManager_dlg-buttons'">
    <form id="busCarsManager_fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>Cars Information</h3>
        <div style="margin-bottom:10px">
            <input name="carnumber" class="easyui-textbox" required="true" label="汽车牌号:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="cartype" class="easyui-textbox" required="true" label="汽车类型:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="color" class="easyui-textbox" required="true" label="汽车颜色:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="price" class="easyui-textbox" required="true"  label="汽车价格:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="rentprice" class="easyui-textbox" required="true"  label="汽车租金:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="deposit" class="easyui-textbox" required="true"  label="汽车押金:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="description" class="easyui-textbox" required="true"  label="汽车描述:" style="width:100%">
        </div>

        <input type="text" name="carimg" id="carimg"/>

    </form>

    <form  method="post" enctype="multipart/form-data"  id="fm2" style="margin:0;padding:0px 50px">
        <div >
            <input name="fil"  class="easyui-filebox"  label="汽车图片:" style="width:60%">

            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="fileUpload()" style="width:90px">上传文件</a>

            <span id="sp1"></span>
        </div>
    </form>
</div>
<div id="busCarsManager_dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCars()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>

</div>

<script type="text/javascript">

    var  url;

     //删除车辆信息
    function destroyCars() {

        var  row= $('#busCarsManager_dg').datagrid('getSelected');

        if(row){
            //提示 是否删除
            $.messager.confirm("提示","是否删除选中数据",function (flag) {

                if(flag){
                    //发送ajax请求 进行数据的删除
                    $.post("busCarsController/removeBusCars",{'carnumber':row.carnumber},function (result) {

                        if(result>0){
                            //重新加载表格数据
                            $("#busCarsManager_dg").datagrid("reload");

                        }else{
                            $.messager.alert("警告","删除失败","error");
                        }


                    })


                }
                
            })


        }else{

            $.messager.alert("提示","请至少选中一行数据","info");
        }

    }
    

    //修改车辆信息
    function editCars() {
        var  row= $('#busCarsManager_dg').datagrid('getSelected');

        if(row){

            //执行修改的操作
            $("#busCarsManager_dlg").dialog("open").dialog("center").dialog("setTitle","Update Cars");

            //表单一中数据的回显
            $("#busCarsManager_fm").form("load",row);

            //表单二中图片的回显
            $("#sp1").html("<img src='imgs/"+row.carimg+"' width='80px'>");

            url="busCarsController/changeBusCars";
        }else{
            $.messager.alert("提示","请至少选中一行数据","info");
        }
    }

    
    //文件上传的操作
    function fileUpload() {

        //提交form表单
        $('#fm2').form('submit',{
            url: "busCarsController/fileUpload",
            success: function(result){
                var result = eval('('+result+')');
                if(result.url){

                    $("#sp1").empty();

                    //显示图片
                    $("#sp1").append("<img src='imgs/"+result.url+"' width='80px' />")

                    //把图片的url地址赋值给隐藏域
                    $("#carimg").val(result.url);

                }else{
                    $.messager.alert("提示","文件上传失败","error");
                }
            }
        });

    }
    
    //提交车辆的信息
    function saveCars() {

        //获得所有表单的内容
       var  val= $("#busCarsManager_fm").serialize();

       $.post(url,val,function (result) {

           if(result>0){

               //关闭当前对话框
               $("#busCarsManager_dlg").dialog("close")

               //刷新后面的表格
               $("#busCarsManager_dg").datagrid("reload");
           }
       })

        
    }
    
    //添加汽车信息
    function newCars() {
      //打开添加的对话框
        $("#busCarsManager_dlg").dialog("open").dialog("center").dialog("setTitle","New Cars");
      //清除表单之前的内容
        $("#busCarsManager_fm").form("clear");

        $("#fm2").form("clear");

        $("#sp1").empty();

        url="busCarsController/saveBusCars";


    }
    
    
    
    function  showImage(val) {

         return  "<img src='imgs/"+val+"' width='80px'/>";
        
    }
    
</script>

</body>
</html>
