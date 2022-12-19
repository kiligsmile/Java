<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/19
  Time: 11:23
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
<table id="dg" title="show Cars" class="easyui-datagrid" style="width:700px;height:450px"
       url="BusCarsCont/findAllBusCars"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="carnumber" width="50">汽车牌号</th>
        <th field="cartype" width="50">汽车类型</th>
        <th field="color" width="50">汽车颜色</th>
        <th field="price" width="50">汽车价格</th>
        <th field="description" width="50">汽车描述</th>
        <th  data-options="field:'carimg',formatter:showImage"  width="50">汽车图片</th>

    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCars()">New Cars</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCars()">Edit Cars</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroCars()">Remove Cars</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:550px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
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
            <input name="rentprice" class="easyui-textbox" required="true" label="汽车租金:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="deposit" class="easyui-textbox" required="true" label="汽车押金:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="description" class="easyui-textbox" required="true"  label="汽车描述:" style="width:100%">
        </div>

        <input name="carimg" type="text" id="ig"/>
    </form>

    <div style="margin-bottom:10px;margin-top: -20px">
        <%--<input name="carimg" class="easyui-textbox" required="true"  label="汽车图片:" style="width:100%">--%>

        <form id="fom"  method="post" enctype="multipart/form-data" style="margin:0;padding:20px 50px">

            <input class="easyui-filebox" name="fil" label="汽车图片:"  style="width:60%">

            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUpLoad()" style="width:90px">上传图片</a>

             <img id="im"  height="80px"/>
        </form>
    </div>

</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCar()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>



<script type="text/javascript">

    var  url;
    //修改车辆的信息
    function  editCars() {

        var row = $('#dg').datagrid('getSelected');

        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit Cars');
            $('#fm').form('load',row);

            $("#im").attr("src","imgs/"+row.carimg);

            url = "BusCarsCont/changeBusCars"
        }else {

            $.messager.alert("提示","请至少选择一行","error");
        }

    }
    
    



       //删除的操作
     function  destroCars() {

         var row = $('#dg').datagrid('getSelected');
         if (row){
             $.messager.confirm('确认框','是否删除指定车辆信息?',function(r){
                 if (r){
                     $.post('BusCarsCont/removeBusCars',{carnumber:row.carnumber},function(result){
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
         }else {

             $.messager.alert("提示","请至少选择一行","error");

         }
         
     }
     
     

       //文件的上传
       function saveUpLoad() {
           $('#fom').form('submit',{
               url: "BusCarsCont/fileUpload",
               success: function(result){
                   var result = eval('('+result+')');
                   if (result.errorMsg){
                       $.messager.show({
                           title: 'Error',
                           msg: result.errorMsg
                       });
                   } else {

                       //把路径赋值给指定的图片
                       $("#im").attr("src","imgs/"+result.success);

                       //给表单中的属性赋值
                       $("#ig").val(result.success);



                   }
               }
           });
       }
     
     
       //提交表单
      function saveCar() {

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
    


    //点击新建车辆操作
    function   newCars() {

        $('#dlg').dialog('open').dialog('center').dialog('setTitle','New Cars');
        $('#fm').form('clear');
        url = 'BusCarsCont/saveBusCars';
        
    }
    
    
    //图片展示
    function  showImage(val) {

       if(val){

           return "<img src='imgs/"+val+"' width='80px'>";
       }
    }
    
    
    
    
</script>

</body>
</html>
