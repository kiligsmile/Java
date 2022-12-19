<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/12
  Time: 9:33
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
            
            $.post("EmailController/findMoreEmail",function (result) {

                for(var  i  in  result){
                    $("#tb").append('<tr>\n' +
                        '        <th>'+result[i].etitle+'</th>\n' +
                        '        <th>'+result[i].edate+'</th>\n' +
                        '        <th>'+result[i].econ+'</th>\n' +
                        '        <th>'+result[i].us.uname+'</th>\n' +
                        '    </tr>');

                }




            })
            
            
        })
        
        
        
    </script>
      

</head>
<body>
<h3>收件信息展示</h3>

<table border="1px" bgcolor="#7fffd4">
    <tr bgcolor="green">
        <th bgcolor="#faebd7">标题</th>
        <th bgcolor="#adff2f">时间</th>
        <th bgcolor="red">内容</th>
        <th bgcolor="aqua">发送人</th>
    </tr>
    <tbody id="tb"></tbody>
</table>


<a href="sendEmail">邮件发送</a>
</body>
</html>
