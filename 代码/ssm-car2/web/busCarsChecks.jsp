<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/19
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汽车检查单</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

    <style type="text/css">


    </style>
</head>
<body>

<%--汽车入库的搜索框--%>
<div title="汽车入库" class="easyui-panel"  style="width: 900px;height: 150px;">

    <div style="margin-top: 40px;margin-left: 30px">
        出租单号: <input id="" class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:60%">
    </div>

</div>

<%--检查单内容--%>
<div id="busCarsChecks_div2">
    <div class="easyui-panel" style="width: 900px;height: 470px" title="检查单管理">

        <form>
            <div style="margin-top: 50px;margin-left: 20px">

                <input name="checkid" id="checkid"  class="easyui-textbox"  label="检查单号:" style="width:300px"> &nbsp;&nbsp;&nbsp;&nbsp;

                <input name="checkdate"   class="easyui-textbox"  label="检查日期:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;

                <input name="problem"  class="easyui-textbox"  label="检查问题:" style="width:30%">

            </div>


            <div style="margin-top: 50px;margin-left: 20px">

                <input name="paymoney" class="easyui-textbox"  label="赔付金额:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;

                <input name="opername" class="easyui-textbox"  label="经办人:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;

                <input name="rentid" id="rentid" class="easyui-textbox"  label="出租单号:" style="width:30%">&nbsp;&nbsp;&nbsp;&nbsp;
            </div>

            <div style="margin-top: 50px;margin-left: 20px">


                <input  name="checkdesc" class="easyui-textbox" label="问题描述:"  multiline="true" style="width:70%;height:120px">

                <input name="carnumber" type="text" id="carnumber"/>
            </div>

            <div style="margin-top: 50px;margin-left: 20px;text-align: center">

                <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="busCarsChecks()" style="width:90px">Save</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>

            </div>
        </form>
    </div>

</div>


<%--出租单、汽车、客户信息展示--%>

<div id="busCarsChecks_div3">

</div>





<script type="text/javascript">
    
    function busCarsChecks() {

      var  val=  $("form").serialize();

      $.post("busChecksController/saveBusChecks",val,function (result) {

          if(result>0){
              $.messager.alert("提示","汽车入库成功","info");
          }else {
              $.messager.alert("提示","汽车入库失败","error");
          }


      })


    }
    

     //查询出租单信息
    function doSearch(val) {

        if(val==null||val==""){

            $.messager.alert("提示","出租单号不能为空","error");
            return;
        }

        //发送ajax进行数据的查询
        $.post("BusRentsController/findOneBusRents",{rentid:val},function (result) {

            if(result){

                //展示汽车检查单列表
                $("#busCarsChecks_div2").show();

                //给汽车检查单列表内容赋值

                 var  time =new Date().getTime();
                $("#checkid").textbox("setValue","JC_"+time);

                $("#rentid").textbox("setValue",result.rentid);


                //给车牌号赋值
                $("#carnumber").val(result.carnumber);




                console.log(result);
                //出租单信息展示
               var  obj1= $("#busCarsChecks_div3").append('<div style="float: left">\n' +
                    '        <div class="easyui-panel" title="出租单信息" style="width: 300px;height: 300px">\n' +
                    '            <p>出租单号:'+result.rentid+'</p>\n' +
                    '            <p>租金:'+result.price+'</p>\n' +
                    '            <p>起租日期:'+result.begindate+'</p>\n' +
                    '            <p>归还日期:'+result.returndate+'</p>\n' +
                    '            <p>操作员:'+result.opername+'</p>\n' +
                    '        </div>\n' +
                    '    </div>');

                $.parser.parse(obj1);

                //查询车辆的信息
                $.post("busCarsController/findOneBusCars",{carnumber:result.carnumber},function (result2) {

                   var obj2= $("#busCarsChecks_div3").append('<div style="float: left">\n' +
                        '     <div class="easyui-panel" title="汽车信息" style="width: 300px;height: 300px">\n' +
                        '             <p>汽车牌号:'+result2.carnumber+'</p>\n' +
                        '             <p>汽车类型:'+result2.cartype+'</p>\n' +
                        '             <p>汽车颜色:'+result2.color+'</p>\n' +
                        '             <p>汽车价格:'+result2.price+'</p>\n' +
                        '             <p>汽车图片:<img src="imgs/'+result2.carimg+'" width="60px"/></p>\n' +
                        '     </div>\n' +
                        '    </div>');

                    $.parser.parse(obj2);

                })

                //客户信息展示
                $.post("BusCustomersController/findOneBusCustomers",{identity:result.identity},function (result3) {

                    var  obj3=$("#busCarsChecks_div3").append(' <div style="float: left">\n' +
                        '       <div class="easyui-panel" title="客户信息" style="width: 300px;height: 300px">\n' +
                        '           <p>客户身份证:'+result3.identity+'</p>\n' +
                        '           <p>客户名称:'+result3.custname+'</p>\n' +
                        '           <p>职位:'+result3.career+'</p>\n' +
                        '           <p>住址:'+result3.address+'</p>\n' +
                        '       </div>\n' +
                        '    </div>');

                    $.parser.parse(obj3);

                })

            }else {

                $("#busCarsChecks_div3").empty();

                $("#busCarsChecks_div2").empty();

                $.messager.alert("提示","该单号不存在或该订单已经入库","error");
            }

        })




    }



    $(function () {

        $("#busCarsChecks_div2").hide();

    })
    

    
</script>

</body>
</html>
