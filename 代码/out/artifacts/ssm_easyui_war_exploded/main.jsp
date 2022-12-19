<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/17
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
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
                    //node :就是当前点击的节点的对象

                    //alert(node.text);  // 在用户点击的时候提示

                    //我们需要使用JS的方式创建选项卡

                    if(node.url==""||node.url==null){
                        return;
                    }


                    //我们需要判断当前点击的选项卡是否存在

                    var  flag=$('#tab').tabs('exists',node.text);

                    if(flag){
                        //证明选项卡存在

                        $('#tab').tabs('select',node.text);
                    }else{

                        //不存在新建选项卡
                        $('#tab').tabs('add',{
                            title:node.text,
                            //content:"<iframe src='"+node.url+"' width='99%' height='98%'></iframe>",
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




    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:200px;">

    </div>
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">

        <div class="easyui-accordion" data-options="fit:true,border:false,animate:true">

            <div title="类别一" >


                <ul id="tt" class="easyui-tree"
                    url="UserController/findMoreMenu">
                </ul>
                
            </div>
            <div title="类别二"></div>
            <div title="类别三"></div>


        </div>




    </div>
    <div data-options="region:'center'" style="background:#eee;">


        <div  id="tab" class="easyui-tabs" data-options="fit:true,border:false">

            <div title="Tab1" data-options="closable:true,iconCls:'icon-reload'">
                tab1

            </div>
        </div>


    </div>


</body>
</html>

<%--
   使用easyUI分析页面的数据

    [1]讲究就是前后分离思想

    [2]一定学会使用F12观察数据的传递过程


--%>
