<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/22
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查询航班信息</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <script type="text/javascript" src="js/jquery.min.js"></script>
    
    <script type="text/javascript">

        var  i =0;
        function demo1(th) {

            //JS
            var  tr= th.parentNode.parentNode;

            if(i%2==0){
                $(tr).after("<tr><th>亚洲航空官网</th><th>1900</th></tr>");
                i++;
            }else {
               $(tr).next().remove();
               i=0;
            }
        }
        
        
    </script>
</head>
<body>

<table border="1px">
    <tr>
        <th>航空公司/航班</th>
        <th>起降时间</th>
        <th>机场</th>
        <th>飞行时间</th>
        <th>经停</th>
        <th>参考报价</th>
    </tr>

    <c:forEach items="${list}" var="fls">
        <tr>
            <th>${fls.airline}/${fls.flight_code}</th>
            <th><fmt:formatDate value="${fls.take_time}" pattern="yyyy-MM-dd"></fmt:formatDate> /<fmt:formatDate value="${fls.landing_time}" pattern="yyyy-MM-dd"></fmt:formatDate></th>
            <th>${fls.n1}/${fls.n2}</th>
            <th>3</th>
            <th>${fls.stop_airport}</th>
            <th>
                    ${fls.reference_price}
                     <button onclick="demo1(this)">查询机票</button>
            </th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
