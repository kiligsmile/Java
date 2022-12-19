<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/11
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax的发送</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>

    <script type="text/javascript">

        $(function () {
            $("#but").click(function () {

                //发送ajax请求
                $.post("demo1",{name:'zs',age:18},function (result) {

                    alert(result.name);
                })

            })


        })



    </script>


</head>
<body>


 <button id="but">ajax的请求</button>

</body>
</html>
