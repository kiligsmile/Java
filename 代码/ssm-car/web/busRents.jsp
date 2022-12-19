<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/23
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出租单管理页面</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body onload="findMoreCars()">

<div id="p" class="easyui-panel" title="出租单管理"
     style="width:900px;height:300px;padding-top:50px;background:#fafafa;">

    <form method="post">

     <div style="margin-left: 20px" >

          <input name="rentid"  class="easyui-textbox" label="出租单号:" style="width:30%">&nbsp;&nbsp;&nbsp;

          <input name="carnumber"  class="easyui-textbox" label="汽车牌号:" style="width:30%">&nbsp;&nbsp;&nbsp;

          <input name="identity"  class="easyui-textbox"  label="客户账号:" style="width:30%">&nbsp;&nbsp;&nbsp;
      </div>

    <div style="margin-left: 20px;margin-top: 30px" >

        <input name="begindate"  class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" label="起租日期:" style="width:30%">&nbsp;&nbsp;&nbsp;

        <input name="returndate"  class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" label="归还日期:" style="width:30%">&nbsp;&nbsp;&nbsp;

    </div>

    </form>
    <div style="margin-left: 20px;margin-top: 40px;text-align: center" >

        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="findMoreCars()" style="width:90px">Save</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>

</div>

<div id="tab">


</div>




<script type="text/javascript">


      function  findMoreCars() {


          //[1]获得输入的所有的表单的值

          var  val=$("form").serialize();


          $("#tab").empty();
          //[2]在给div进行赋值
         var  obj= $("#tab").append('<table id="dg" title="show Cars" class="easyui-datagrid" style="width:900px;height:450px"\n' +
              '       url="BusRentsCont/BusRentsFindMore?'+val+'"' +
              '       toolbar="#toolbar" pagination="true"\n' +
              '       rownumbers="true" fitColumns="true" singleSelect="true">\n' +
              '    <thead>\n' +
              '    <tr>\n' +
              '        <th field="rentid" width="50">出租单号</th>\n' +
              '        <th field="price" width="50">租金</th>\n' +
              '        <th field="begindate" width="50">起租日期</th>\n' +
              '        <th field="returndate" width="50">归还日期</th>\n' +
              '        <th field="identity" width="50">用户ID</th>\n'+
              '        <th field="carnumber" width="50">汽车牌号</th>\n'+
              '        <th field="opername" width="50">经办人</th>\n'+
              '\n' +
              '    </tr>\n' +
              '    </thead>\n' +
              '</table>');

          $.parser.parse(obj);


          
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
