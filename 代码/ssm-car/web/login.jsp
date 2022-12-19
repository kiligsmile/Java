<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>

     <%--引入easyUI使用的CSS文件--%>
    <link rel="stylesheet" type="text/css"  href="easyui/themes/default/easyui.css">

     <%--引入css中的图标集--%>
    <link rel="stylesheet" type="text/css"  href="easyui/themes/icon.css">

    <%--引入Jq中的js文件 先引入这个JS文件--%>
   <script type="text/javascript" src="easyui/jquery.min.js"></script>

    <%--引入easyui中使用js文件--%>
   <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

    <%--引入js的汉化语言--%>

    <script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>

    <style type="text/css">

        table{
            margin-top: 85px;
            margin-left: 85px;
        }
        th{
            width: 60px;
        }

        tr{
            height: 40px;
        }

    </style>


    <script type="text/javascript">

        $(function () {

            $("#sub").click(function () {

                if($("#name").val()==""){

                    $.messager.alert('警告','用户名不能为空','warning');

                }else if($("#pwd").val()==""){
                    $.messager.alert('警告','密码不能为空','warning');

                }else{
                    //发送ajax请求提交表单数据

                     var  uname =$("#name").val();

                     var  pwd =$("#pwd").val();

                     $.post("SysUserCont/userLogin","uname="+uname+"&pwd="+pwd,function (data1) {

                         if(data1){

                             window.location.href="main.jsp"


                         }else {

                             $.messager.alert('提示','登录失败','error');
                         }


                     })

                }



            })


        })




    </script>

</head>
<body>
<%--
  class：增加easyui的样式的

  data-options：增加easyui的组建

  如果这个标签上使用了easyui的样式这个时候我们自己书写的样式最好是行内式
--%>
<div style="margin-top: 240px;margin-left: 430px">
    <div id="p" class="easyui-panel" title="登录"
         style="width:400px;height:300px"
         data-options="iconCls:'icon-liu',closable:false,
                    collapsible:false,minimizable:true,maximizable:true">


        <table border="0px">
            <tr>
                <th>姓名:</th>
                <th><input type="text"class="easyui-validatebox" data-options="required:true" name="name" id="name"/> </th>
            </tr>
            <tr>
                <th>密码:</th>
                <th><input type="text" name="pwd" id="pwd"/></th>
            </tr>
            <tr>
                <th colspan="2">

                    <a id="sub" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>

                    <a id="res" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">清空</a>

                </th>
            </tr>
        </table>



    </div>

</div>


</body>
</html>
