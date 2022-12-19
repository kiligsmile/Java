<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/19
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功主页面</title>

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

                   var flag= $('#tab').tabs('exists',node.text);

                    if(flag){
                        $('#tab').tabs('select',node.text);
                    }else {
                        $('#tab').tabs('add',{
                            title:node.text,
                            // href:node.url,
                            content:'<iframe src="'+node.url+'" width="99%" height="98%" ></iframe>',
                            closable:true
                        });

                    }

                }
            });
        })



    </script>

</head>
<body class="easyui-layout">

    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:200px;">

        <div class="easyui-panel" title="备忘录" style="width: 193px;height: 150px;">

            <h3>[1]上午和张总吃饭</h3>

            <h3>[2]下午会见XXX</h3>

        </div>

        <div class="easyui-calendar" style="height: 300px;width: 193px"></div>

    </div>
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">

        <div class="easyui-accordion" data-options="fit:true">


            <div title="类别一">

                <ul id="tt" class="easyui-tree" url="SysMenusCont/findMoreMenus3">

                </ul>

            </div>
            <div title="类别二"></div>
            <div title="类别三"></div>
            
        </div>
            


    </div>
    <div data-options="region:'center'" style="background:#eee;">


        <div id="tab" class="easyui-tabs" data-options="fit:true">

            <div title="默认打开页">

                <img src="imgs/body.jpg" width="100%" height="100%"/>


            </div>

        </div>


    </div>


</body>
</html>
