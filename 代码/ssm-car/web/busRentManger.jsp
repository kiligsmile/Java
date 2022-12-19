<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/23
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汽车出租管理页面</title>
   <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body>

    <div id="p" class="easyui-panel" title="车辆出租"
         style="width:700px;height:150px;padding:10px;background:#fafafa;">

         <br/>
        用户身份证:  <input id="identity" class="easyui-searchbox" data-options="searcher:doSearch" style="width:50%">

    </div>

<div id="tab">

</div>


<div>

            <div id="dlg" class="easyui-dialog" style="width:550px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
                <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
                    <h3>CarsRent Information</h3>
                    <div style="margin-bottom:10px">
                        <input name="rentid" id="rentid" class="easyui-textbox" required="true" label="出租单号:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="price" id="price" class="easyui-textbox" required="true" label="租金:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="begindate" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" required="true" label="起租日期:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="returndate" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" required="true"  label="归还日期:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="identity" id="ide" class="easyui-textbox" required="true"  label="身份证:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="carnumber" id="carnumber" class="easyui-textbox" required="true"  label="车牌号:" style="width:100%">
                    </div>
                    <div style="margin-bottom:10px">
                        <input name="opername" class="easyui-textbox" required="true"  label="操作员:" style="width:100%">
                    </div>
                </form>
            </div>
            <div id="dlg-buttons">
                <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCarsRent()" style="width:90px">Save</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
            </div>


</div>



    <script type="text/javascript">

        //添加出租单的信息
        function  saveCarsRent() {

            $('#fm').form('submit',{
                url: "BusRentsCont/BusRentsSave",
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



        function doSearch(val) {

            if(val==null||val==""){

                $.messager.alert("提示","用户身份证不可为空","error");
            }else {

                $.post("BusCustomersCont/customersFindOne","identity="+val,function (data1) {

                    if(data1){
                      //展示可以出租车辆的信息
                       // $("#tab").show();
                  $("#tab").empty();
                  var  targetObj=   $("#tab").append('<table id="dg" title="show Cars" class="easyui-datagrid" style="width:700px;height:450px"\n' +
                         '           url="BusCarsCont/findMoreBusCars"\n' +
                         '           toolbar="#toolbar" pagination="true"\n' +
                         '           rownumbers="true" fitColumns="true" singleSelect="true">\n' +
                         '        <thead>\n' +
                         '        <tr>\n' +
                         '            <th field="carnumber" width="50">汽车牌号</th>\n' +
                         '            <th field="cartype" width="50">汽车类型</th>\n' +
                         '            <th field="color" width="50">汽车颜色</th>\n' +
                         '            <th field="price" width="50">汽车价格</th>\n' +
                         '            <th field="description" width="50">汽车描述</th>\n' +
                         '            <th  data-options="field:\'carimg\',formatter:showImage"  width="50">汽车图片</th>\n' +
                         '\n' +
                         '        </tr>\n' +
                         '        </thead>\n' +
                         '    </table>'+
                      '<div id="toolbar">\n' +
                      '        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRents()">确认选择</a>\n' +
                      '</div>');


                        //页面重新渲染
                        $.parser.parse(targetObj);

                    }else{

                        $.messager.alert("提示","该用户不存在","error");
                    }

                })



            }


        }


        //新建出租单信息的管理
        function  newRents() {


            var row = $('#dg').datagrid('getSelected');

            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','新建出租单');

                //赋值给出租单号

                var  r=new  Date().getTime();

                //给easyui中的文本框赋值
                $("#rentid").textbox("setValue","CZ_"+r);
                //给租金赋值
                $("#price").textbox("setValue",row.rentprice);
                //给身份证赋值
                $("#ide").textbox("setValue",$("#identity").textbox("getValue"));
                //给车牌赋值
                $("#carnumber").textbox("setValue",row.carnumber);









               // url = 'update_user.php?id='+row.id;
            }else {

                $.messager.alert("提示","请选择一辆汽车进行出租","error");
            }

        }



        //图片展示
        function  showImage(val) {

            if(val){

                return "<img src='imgs/"+val+"' width='80px'>";
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
