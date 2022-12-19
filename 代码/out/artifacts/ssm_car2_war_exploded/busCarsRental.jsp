<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/18
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汽车出租</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>

 <div title="车辆出租" class="easyui-panel"  style="width: 700px;height: 150px;">

     <div style="margin-top: 40px;margin-left: 30px">
         用户身份证: <input id="userid" class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:60%">
     </div>

 </div>

 <div id="div1">


 </div>

 <div id="busCarsRental_dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#busCarsRental_dlg-buttons'">
     <form id="busCarsRental_fm" method="post" novalidate style="margin:0;padding:20px 50px">
         <h3>CarsRental Information</h3>
         <div style="margin-bottom:10px">
             <input name="rentid" id="rentid" class="easyui-textbox" required="true" label="出租单号:" style="width:100%">
         </div>
         <div style="margin-bottom:10px">
             <input name="price" id="price" class="easyui-textbox" required="true" label="租金:" style="width:100%">
         </div>
         <div style="margin-bottom:10px">
             <input name="begindate" class="easyui-datebox"   data-options="formatter:myformatter,parser:myparser" required="true" label="起租日期:" style="width:100%">
         </div>
         <div style="margin-bottom:10px">
             <input name="returndate" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" required="true" label="归还日期:" style="width:100%">
         </div>
         <div style="margin-bottom:10px">
             <input name="identity" id="identity" class="easyui-textbox" required="true" label="身份证号:" style="width:100%">
         </div>
         <div style="margin-bottom:10px">
             <input name="carnumber" id="carnumber" class="easyui-textbox" required="true" label="车牌号:" style="width:100%">
         </div>
         <div style="margin-bottom:10px">
             <input name="opername" id="opername" class="easyui-textbox" required="true" label="操作员:" style="width:100%">
         </div>
     </form>
 </div>
 <div id="busCarsRental_dlg-buttons">
     <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saverentBus()" style="width:90px">Save</a>
     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
 </div>


<script type="text/javascript">
    
    function doSearch(val) {

        if(val==null||val==""){

            $.messager.alert("提示","用户身份证不能为空","error");
        }else {
            $.post("BusCustomersController/findOneBusCustomers",{identity:val},function (result) {

                if(result){
                    //展示可以出租的类表
                    $("#div1").empty();

                  var  targetObj= $("#div1").append('<table id="busCarsRental_dg" title="My Car" class="easyui-datagrid" style="width:700px;height:450px"\n' +
                        '       url="busCarsController/findMoreBusCars"\n' +
                        '       toolbar="#busCarsRental_toolbar" pagination="true"\n' +
                        '       rownumbers="true" fitColumns="true" singleSelect="true">\n' +
                        '    <thead>\n' +
                        '    <tr>\n' +
                        '        <th field="carnumber" width="50">汽车牌号</th>\n' +
                        '        <th field="cartype" width="50">汽车类型</th>\n' +
                        '        <th field="price" width="50">汽车价格</th>\n' +
                        '        <th field="description" width="50">汽车描述</th>\n' +
                        '        <th data-options="field:\'carimg\',formatter:showImage"  width="50">汽车图片</th>\n' +
                        '    </tr>\n' +
                        '    </thead>\n' +
                        '</table>'+
                        '<div id="busCarsRental_toolbar">\n' +
                        '    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="rentCars()">确认选择</a>\n' +
                        '</div>')

                    //页面的渲染
                    $.parser.parse(targetObj);


                }else{

                    $("#div1").empty();

                    $.messager.alert("提示","该用户不存在","error");



                }


            })
        }

    }
    
    
    //添加出租单信息--汽车出租
    function  saverentBus() {

      var   val= $("#busCarsRental_fm").serialize();

      $.post("BusRentsController/saveBusRents",val,function (result) {

          if(result>0){

              //关闭当前的对话框
              $("#busCarsRental_dlg").dialog("close");

              //刷新出租列表的表格
              $("#busCarsRental_dg").datagrid("reload");

          }else {
              $.messager.alert("提示","汽车出租失败","error");

          }

      })


    }
    
    
    //出租单产生
    function rentCars() {

        var row = $('#busCarsRental_dg').datagrid('getSelected');

        if(row){

            console.log(row);
            //[1]打开出租单的对话框
            $("#busCarsRental_dlg").dialog("open").dialog("center").dialog("setTitle","汽车出租");

            //[2]给出租单内容赋值
            var   time =new Date().getTime();

            $("#rentid").textbox('setValue',"CZ_"+time);

            $("#price").textbox('setValue',row.rentprice);

            $("#identity").textbox('setValue',$("#userid").val());

            $("#carnumber").textbox('setValue',row.carnumber);

            $("#opername").textbox('setValue','admin');

        }else{
            $.messager.alert("提示","请至少选择一辆车","info");
        }

        
    }
    

    function  showImage(val) {
        return  "<img src='imgs/"+val+"' width='80px'/>";
    }

    //日期格式的改变
    function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    function myparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    }
    
</script>



</body>
</html>
