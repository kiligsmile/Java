<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/11
  Time: 14:57
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
              
              $.post("FileController/findAll",function (result) {

                  for(var  i  in  result){
                      $("#tb").append('<tr>\n' +
                          '        <th>'+result[i].uid+'</th>\n' +
                          '        <th>'+result[i].uname+'</th>\n' +
                          '        <th>'+result[i].score+'</th>\n' +
                          '        <th><img width="80px" src="imgs/'+result[i].filename+'"/></th>\n' +
                          '        <th><a href="FileController/fileDownLoad?filename='+result[i].filename+'&filetype='+result[i].fileType+'">下载</a></th>\n' +
                          '    </tr>')

                  }



              })
              
              
          })


     </script>

</head>
<body>
<h3 align="center">信息展示页面</h3>
<hr/>
<table align="center" border="1px">
    <tr>
        <th>用户ID</th>
        <th>用户名称</th>
        <th>用户分数</th>
        <th>图片</th>
        <th>操作</th>
    </tr>
    <tbody id="tb">

    </tbody>
</table>

</body>
</html>
