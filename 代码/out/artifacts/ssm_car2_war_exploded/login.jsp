<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/13
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <%--引入easyUI中的css文件--%>
    <link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
    <%--引入easyUI中图标集的css--%>
    <link type="text/css" rel="stylesheet" href="easyui/themes/icon.css"/>

     <%--引入js文件  引入文件的时候需要注意 先引入jq中的js 在引入easyui中的js--%>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <%--引入easyUI中的js文件--%>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>

    <style type="text/css">

        tr{
            height: 40px;
        }

        th{width: 70px}

        body{

            background-color: #F4F4F4;
        }

    </style>

    <script type="text/javascript">

        $(function () {

            $("#btn1").click(function () {

                  var  uname=$("#uname").val();

                  var  pwd =$("#pwd").val();

                if(uname==""||uname==null){

                    $.messager.alert("警告","用户名不能为空","warning");
                }else if(pwd==""||pwd==null){
                    $.messager.alert("警告","密码不能为空","warning");
                }else{
                    //发送ajax请求进行登陆

                    $.post("SysUserController/userLogin",{loginname:uname,pwd:pwd},function (result) {

                        if(result){

                            window.location.href="main.jsp";
                        }else {
                            $.messager.alert("提示","账号密码不正确","error");
                        }

                    })

                }


            })


        })


    </script>


</head>
<body>

<%--
class：给指定的元素增加css样式

data-options：给指定的元素增加组件

  如果标签上含有easyUI的class属性，在增加样式的时候一定书写成行内式

  如果标签上没有easyui的classs属性在增加样式的时候可以随意定义

--%>

<div style="margin-top: 200px;margin-left: 420px">
    <div id="p" class="easyui-panel" title="登陆"
         style="width:400px;height:300px"
         data-options="iconCls:'icon-liu',closable:false,
                collapsible:false,minimizable:false,maximizable:false">

        <table border="0px" style="margin-top: 63px;margin-left: 77px">
            <tr>
                <th>用户名:</th>
                <th>
                    <input type="text" data-options="required:true" class="easyui-validatebox" id="uname"/>
                </th>
            </tr>
            <tr>
                <th>密码:</th>
                <th>
                    <input type="text" id="pwd" data-options="required:true" class="easyui-validatebox"/>
                </th>
            </tr>
            <tr>

                <th colspan="2">
                    <a id="btn1" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登陆</a>

                    <a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">清空</a>
                </th>
            </tr>
        </table>

    </div>
</div>


</body>
</html>
