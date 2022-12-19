<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/6
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>

    <script type="text/javascript">
        
          $(function () {
              
              $.post("servlet/LeaveController","method=leaveFindAll",function (result) {

                  for(var   i  in  result){
                      $("#tb").append('<tr>\n' +
                          '        <th>'+result[i].id+'</th>\n' +
                          '        <th>'+result[i].name+'</th>\n' +
                          '        <th>'+result[i].time+'</th>\n' +
                          '        <th>'+result[i].reason+'</th>\n' +
                          '        <th><a href="javascript:del('+result[i].id+')">删除</a></th>\n' +
                          '    </tr>')

                  }




              },"json")
              
          })
        
        
        function del(id) {
            
              var  flag=window.confirm("是否确认删除?");
              
              if(flag){
                  
                  $.post("servlet/LeaveController","method=leaveRemove&id="+id,function (result) {

                       if(result>0){
                           window.location.reload();
                       }else {
                           alert("删除失败");
                       }
                  },"json")
              }
              
        }
        
        
    </script>
    

</head>
<body>

<h3>请假信息查询</h3>
<hr/>
<table border="1px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>请假事件</th>
        <th>原因</th>
        <th>操作</th>
    </tr>

    <tbody id="tb">


    </tbody>
</table>


</body>
</html>
