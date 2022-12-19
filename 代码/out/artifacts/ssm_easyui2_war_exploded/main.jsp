<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/14
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css"/>

    <link type="text/css" rel="stylesheet" href="easyui/themes/icon.css"/>

    <script type="text/javascript" src="easyui/jquery.min.js"></script>

    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

     <script type="text/javascript">

         $(function () {

             $('#tt').tree({
                 onClick: function(node){

                     //alert(node.text);  // 在用户点击的时候提示

                     if(node.url==""||node.url==null){
                         return;
                     }


                     //判断点击的选项卡是否已经打开
                      var flag = $("#tab").tabs("exists",node.text);

                     if(flag){
                         //选中已经打开的选项卡
                         $("#tab").tabs("select",node.text);

                     }else{
                         //新建选项卡
                         $('#tab').tabs('add',{
                             title:node.text,
                             //content:'<iframe src="'+node.url+'" width="100%" height="98%"></iframe>',
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



    <div data-options="region:'north',title:'North Title',split:false,border:false" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">

        <div class="easyui-accordion" data-options="fit:true,border:false,animate:true">
            <div title="类别一">

                <ul id="tt" class="easyui-tree" url="findMoreMenus"></ul>
                
                
            </div>
            <div title="类别二">1234</div>
            <div title="类别三"></div>
        </div>


    </div>
    <div data-options="region:'center'" style="background:#eee;">

        <div id="tab" class="easyui-tabs" data-options="fit:true">

            <div title="默认页" data-options="closable:true">

            </div>
        </div>

    </div>

</body>
</html>
