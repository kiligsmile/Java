<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/11/7
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>银行转账页面</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>

     <script type="text/javascript">

         var flag1=false;
         var flag2=false;
         var flag3=false;

         $(function () {

             //验证账号和密码
             $("#pwd").blur(function () {

                 var  outcno=$("#outcno").val();

                 var  pwd=$("#pwd").val();


                 if(outcno==""||pwd==""){

                     $("#pwd_span").html("× 用户名或者密码不能为空").css("color","green");

                     return;

                 }


                 $.post("servlet/AccountController?method=checkUser",{cno:outcno,pwd:pwd},function (result) {

                     if(result){

                         $("#pwd_span").html("√用户存在").css("color","green");

                         flag1=true;


                      }else{
                         $("#pwd_span").html("×用户不存在").css("color","red")

                     }

                 },"JSON")
             })


             $("#money").blur(function () {

                 var  outcno=$("#outcno").val();

                 var  pwd=$("#pwd").val();

                 var  money=$("#money").val();

                 $.post("servlet/AccountController?method=checkUser",{cno:outcno,pwd:pwd,money:money},function (result) {

                     if(result){

                         $("#money_span").html("√余额充足").css("color","green")

                         flag2=true;
                     }else{
                         $("#money_span").html("×余额不足").css("color","red")

                     }

                 },"JSON")


             })

             $("#incno").blur(function () {

                 var  incno=$("#incno").val();


                 $.post("servlet/AccountController?method=checkUser",{cno:incno},function (result) {

                     if(result){

                         $("#incno_span").html("√用户存在").css("color","green")

                         flag3=true;
                     }else{
                         $("#incno_span").html("×用户不存在").css("color","red")

                     }

                 },"JSON")

             })


         })


         //总的校验
         function  change() {

             if(flag1&&flag2&&flag3){
                 return true;
             }else {
                 return  false;
             }
             
         }




     </script>
</head>
<body>

<h3>银行转账</h3>

<form action="servlet/AccountController?method=inOutMoney" method="post" onsubmit="return change()">


    <p>
        转账账号:<input type="text" name="outcno" id="outcno"/>

    </p>

    <p>
        转账密码:<input type="text" name="pwd" id="pwd"/><span id="pwd_span"></span>

    </p>
    <p>
        转账金额:<input type="text" name="money" id="money"/><span id="money_span"></span>

    </p>
    <p>
        收款账号:<input type="text" name="incno" id="incno"/><span id="incno_span"></span>

    </p>
    <p>
          <input type="submit" value="确认转账"/>

    </p>
</form>

</body>
</html>
