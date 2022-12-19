<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/5
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息查询</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
    
    <script type="text/javascript">
        
        function change() {

            /*var  name=$("#name").val();

            var  phone= $("#phone").val();*/

            //name=sxt&phone=123
           var  val= $("form").serialize();

            $.post("servlet/StudentController",val,function (result) {

                 $("#tb").empty();

                 for(var  i  in   result){

                     $("#tb").append('<tr>\n' +
                         '        <th>'+result[i].id+'</th>\n' +
                         '        <th>'+result[i].name+'</th>\n' +
                         '        <th>'+result[i].phone+'</th>\n' +
                         '    </tr>')
                 }
                
            },"JSON")

            
        }
        
    </script>
    
</head>
<body onload="change()">

<form>
    <input type="text" name="name" id="name"/>

    <input type="text" name="phone" id="phone"/>

    <input type="button" value="查询" onclick="change()"/>

</form>

<hr/>
<table border="1px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>手机号</th>
    </tr>

    <tbody id="tb">


    </tbody>
</table>


</body>
</html>
