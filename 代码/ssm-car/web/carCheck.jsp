<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/24
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汽车入库操作</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body>

<div id="p" class="easyui-panel" title="汽车入库"
     style="width:900px;height:150px;padding:10px;background:#fafafa;">

    <br/>
    出租单编号:  <input id="reid" class="easyui-searchbox" data-options="searcher:doSearch" style="width:35%">

</div>

<div id="p22">
    <div id="p2" class="easyui-panel" title="检查单管理"
         style="width:900px;height:400px;padding-top:50px;background:#fafafa;">

        <form method="post" id="fm">

            <div style="margin-left: 20px" >

                <input name="checkid"  id="checkid" class="easyui-textbox" label="检查单号:" style="width:30%">&nbsp;&nbsp;&nbsp;

                <input name="checkdate"  class="easyui-datebox"   data-options="formatter:myformatter,parser:myparser" label="检查日期:" style="width:30%">&nbsp;&nbsp;&nbsp;

                <input name="problem"  class="easyui-textbox"  label="检查问题:" style="width:30%">&nbsp;&nbsp;&nbsp;
            </div>

            <div style="margin-left: 20px;margin-top: 30px" >

                <input name="paymoney"  class="easyui-textbox"  label="赔付金额:" style="width:30%">&nbsp;&nbsp;&nbsp;

                <input name="opername"  class="easyui-textbox"  label="经办人:" style="width:30%">&nbsp;&nbsp;&nbsp;

                <input name="rentid" id="rentid"  class="easyui-textbox"  label="出租单号:" style="width:30%">&nbsp;&nbsp;&nbsp;
            </div>

            <div style="margin-left: 20px;margin-top: 30px" >

                <input name="checkdesc" class="easyui-textbox" label="问题描述:" labelPosition="left" multiline="true"  style="width:60%;height:120px">

                <input type="hidden" name="carnumber" id="carnum"/>
            </div>

        </form>
        <div style="margin-left: 20px;margin-top: 40px;text-align: center" >

            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveChecks()" style="width:90px">Save</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
        </div>

    </div>

</div>

<div id="p3">


</div>


<script type="text/javascript">


    $(function () {
        $("#p22").hide();
        $("#p3").hide();

    })

    
    
    function   saveChecks() {
        $('#fm').form('submit',{
            url: "BusChecksCont/BusChecksSave",
            success: function(result){
                var result = eval('('+result+')');
                if (result.errorMsg){
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {

                    $.messager.show({
                        title: 'success',
                        msg: "汽车入库成功"
                    });

                }
            }
        });



    }
    
    
    function  doSearch(val) {


        //生成出租单号和检查单号

        var  rid =new Date().getTime();

        $("#checkid").textbox("setValue","JC_"+rid);

        $("#rentid").textbox("setValue",$("#reid").textbox("getValue"));


        if(val==null||val==""){

            $.messager.alert("警告","出租单号不能为空","error");
        }else {
            
            //查询指定的出租单号
            $.post("BusRentsCont/BusRentsFindOne","rentid="+val,function (data1) {

                if(data1){
                    $("#p22").show();
                    $("#p3").show();

                    $("#p3").empty();

                    //给车牌号赋值

                    $("#carnum").val(data1.carnumber);

                   //出租单信息展示
                   var obj= $("#p3").append('<div style="float:left">\n' +
                        '        <div id="t1" class="easyui-panel" title="出租单信息"\n' +
                        '             style="width:300px;height:250px;padding:15px;background:#fafafa;">\n' +
                        '            <p>出租单号:'+data1.rentid+'</p>\n' +
                        '            <p>租金:'+data1.price+'</p>\n' +
                        '            <p>起租日期:'+data1.begindate+'</p>\n' +
                        '            <p>归还日期:'+data1.returndate+'</p>\n' +
                        '            <p>经办人:'+data1.opername+'</p>\n' +
                        '        </div>\n' +
                        '    </div>');

                        $.parser.parse(obj);


                     $.post("BusCustomersCont/customersFindOne","identity="+data1.identity,function (data2) {

                         //展示客户信息
                        var  obj2= $("#p3").append('<div style="float:left">\n' +
                             '        <div id="t2" class="easyui-panel" title="客户信息"\n' +
                             '             style="width:300px;height:250px;padding:15px;background:#fafafa;">\n' +
                             '            <p>客户身份号:'+data2.identity+'</p>\n' +
                             '            <p>客户名称:'+data2.custname+'</p>\n' +
                             '            <p>性别:'+data2.sex+'</p>\n' +
                             '            <p>地址:'+data2.address+'</p>\n' +
                             '            <p>手机号:'+data2.phone+'</p>\n' +
                             '            <p>职位:'+data2.career+'</p>\n' +
                             '        </div>\n' +
                             '    </div>')

                         $.parser.parse(obj2);
                       })


                      //查询车辆的信息
                    $.post("BusCarsCont/findOneBusCars","carnumber="+data1.carnumber,function (data3) {

                      var  obj3=  $("#p3").append(' <div style="float:left">\n' +
                            '        <div id="t3" class="easyui-panel" title="汽车信息"\n' +
                            '             style="width:300px;height:250px;padding:15px;background:#fafafa;">\n' +
                            '            <p>汽车牌号:'+data3.carnumber+'</p>\n' +
                            '            <p>汽车类型:'+data3.cartype+'</p>\n' +
                            '            <p>颜色:'+data3.color+'</p>\n' +
                            '            <p>总价:'+data3.price+'</p>\n' +
                            '            <p>描述:'+data3.description+'</p>\n' +
                            '            <p>图片:<img src="imgs/'+data3.carimg+'" width="80px" /> </p>\n' +
                            '        </div>\n' +
                            '   </div>')


                        $.parser.parse(obj3);
                    })






                }else {
                    $.messager.alert("警告","出租单号不存在","info");
                }
            })
            
            
            
        }






        
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
