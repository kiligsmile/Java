<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/15
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">

        $(function () {

            $('#tt').tree({
                onClick: function(node){

                    if(node.url==null||node.url==""){
                        return;
                    }

                   var  flag= $('#tab').tabs('exists',node.text);

                    if(flag){
                        $('#tab').tabs('select',node.text);
                    }else {
                        $('#tab').tabs('add',{
                            title:node.text,
                            //content:Tab Body',
                            href:node.url,
                            closable:true
                        });

                    }


                }
            });




        })

    </script>

</head>
<body class="easyui-layout">

    <div data-options="region:'north',split:true" style="height:100px; background-image: url('easyui/imgs/layout-browser-hd-bg.gif')">

        <div style="margin-left: 100px;margin-top: 30px;float: left" >
            <img src="easyui/imgs/blocks.gif">

            <span style="font-size: 32px;font-family: 仿宋;color: #ffffff;font-weight: bold"><i>Car Rental System</i></span>

        </div>

        <div style="float: right;margin-top: 60px;margin-right: 30px">

            <span style="font-size: 17px;color: #ffffff;font-family: 仿宋" >欢迎admin登陆</span>|
            <a style="font-size: 17px;color: #ffffff;font-family: 仿宋;text-decoration: none" href="" >注销</a>

        </div>

    </div>
    <div data-options="region:'south',split:true" style="height:120px;
                       background-image: url('easyui/imgs/bottom.png');background-repeat: no-repeat;background-position: center;background-color: #eaeaea"></div>
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:180px;">

        <div class="easyui-panel" style="width:173px;height:174px;" title="备忘录">

            <h4>A、明天上午张老板谈拆迁</h4>
            <h4>B、明天上午张老板谈拆迁</h4>
            <h4>C、明天上午张老板谈拆迁</h4>

        </div>

        <div class="easyui-calendar" style="width:173px;height:230px;"></div>

    </div>
    <div data-options="region:'west',title:'Menu',split:true" style="width:200px;">

        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="类别一">

                <ul id="tt" class="easyui-tree" url="SysMenusController/findMoreMenus3"></ul>

            </div>
            <div title="类别二"></div>
            <div title="类别三"></div>
        </div>

    </div>
    <div data-options="region:'center'" style="background:#eee;">

        <div id="tab" class="easyui-tabs" data-options="fit:true">
            <div title="默认页">
                <img src="easyui/imgs/timg.jpg" width="100%" height="100%">
            </div>

        </div>

    </div>

</body>
</html>
