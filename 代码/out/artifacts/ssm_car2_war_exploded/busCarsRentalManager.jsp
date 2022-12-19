<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/19
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出租单管理</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body onload="rentBusManager()">

  <div class="easyui-panel" style="width: 900px;height: 300px" title="出租单管理">


      <form>
           <div style="margin-top: 50px;margin-left: 20px">

               <input name="rentid"  class="easyui-textbox"  label="出租单号:" style="width:30%"> &nbsp;&nbsp;&nbsp;&nbsp;

               <input name="carnumber"   class="easyui-textbox"  label="汽车牌号:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;

               <input name="identity"  class="easyui-textbox"  label="身份证号:" style="width:30%">

           </div>


          <div style="margin-top: 50px;margin-left: 20px">

              <input name="begindate" class="easyui-textbox"  label="起租日期:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;

              <input name="returndate" class="easyui-textbox"  label="归还日期:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;

          </div>


          <div style="margin-top: 50px;margin-left: 20px;text-align: center">

              <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="rentBusManager()" style="width:90px">Save</a>&nbsp;&nbsp;&nbsp;&nbsp;
              <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>

          </div>

      </form>

  </div>

  <div id="div1">

  </div>

    <script type="text/javascript">

        function  rentBusManager() {

            var  val=$("form").serialize();

            //alert(val);
            //  carnumber=123&id=123

            //发送ajax进行数据的查询

            $("#div1").empty();

            $("#div1").append('<table id="busCarsRentalManager_dg" title="汽车出租单管理" class="easyui-datagrid" style="width:900px;height:450px"\n' +
                '       url="BusRentsController/findMoreBusRents?'+val+'" ' +
                '       toolbar="#busCarsManager_toolbar" pagination="true"\n' +
                '       rownumbers="true" fitColumns="true" singleSelect="true">\n' +
                '    <thead>\n' +
                '    <tr>\n' +
                '        <th field="rentid" width="50">出租单号</th>\n' +
                '        <th field="price" width="50">汽车租金</th>\n' +
                '        <th field="begindate" width="50">起租日期</th>\n' +
                '        <th field="returndate" width="50">归还日期</th>\n' +
                '        <th field="identity" width="50">用户ID</th>\n' +
                '        <th field="carnumber" width="50">汽车牌号</th>\n' +
                '        <th field="rentflag" width="50">是否归还</th>\n' +
                '        <th field="opername" width="50">经办人</th>\n' +
                '    </tr>\n' +
                '    </thead>\n' +
                '</table>')

            $.parser.parse();
        }


    </script>



</body>
</html>
