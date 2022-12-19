<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/7/26
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="js/echarts.min.js"></script>

    <script type="text/javascript" src="easyui/jquery.min.js"></script>


    <script type="text/javascript">


        $(function () {

            $.post("BusCarsCont/eaCount",function (data1) {

                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '车辆统计图'
                    },
                    tooltip: {},
                    legend: {
                        data:['车辆数量']
                    },
                    xAxis: {
                        data: data1[1]
                    },
                    yAxis: {},
                    series: [{
                        name: '车辆数量',
                        type: 'bar',
                        data: data1[0]
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);


            })


        })


    </script>

</head>
<body>

<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">

</script>

</body>
</html>
