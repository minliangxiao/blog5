
<%--<%=basePath%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>

<html>
<%--_war_exploded--%>
<!·
    作者：offline
    时间：2019-05-16
    描述：这个页面是登陆页面
    未完成功能：1.页面样式太过单调
               2.没有写表单校验
-->
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>登陆</title>
    <%--<base href="<%=basePath%>">--%>
  <!--引入必要的库-->
  <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/login.css" />

  <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/messages_zh.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        label.error{

            /*padding-left: 30px;*/
            font-family:georgia;
            font-size: 12px;
            font-style: normal;
            color: red;
        }
    </style>
    <script type="text/javascript">
        function changeimg(obj){
            obj.src="<%=basePath%>/ChickImgServlet?=time"+new Date().getTime();

        }

    </script>
    <script >
        $(function(){
            $("#checkForm").validate({
                rules:{
                    username:{
                        required:true,

                    },
                    userpwd:{
                        required:true,

                    },

                    checkCode:{
                        required:true
                    }
                },
                messages:{
                    username:{
                        required:"用户名不能为空!",

                    },
                    userpwd:{
                        required:"密码不能为空!",

                    },
                    checkCode:{
                        required:"验证码不能为空",
                    }
                },
                errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
                success: function(label) { //验证成功后的执行的回调函数
                    //label指向上面那个错误提示信息标签label
                    label.text(" ") //清空错误提示消息
                        .addClass("success"); //加上自定义的success类
                }
            });
        });

    </script>


</head>
<body>
<div class="container">


  <form class="form-signin" action="LonginServlet" method="post" id="checkForm">
    <h2 class="form-signin-heading" style="color: red;" id="message">${message} </h2>
    <h2 class="form-signin-heading">登陆系统</h2>
    <label for="inputEmail" class="sr-only" >输入账号</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="输入账号" name="username" required autofocus>
    <label for="inputPassword" class="sr-only" >输入密码</label>
    <input type="password" id="inputPassword" class="form-control" name="userpwd" placeholder="密码" required>



      <div class="checkbox">



      <label>
        <input type="radio" name="identity" value="用户登录" checked="checked"> 用户登录
        <input type="radio" name="identity" value="管理员登录"> 管理员登录
      </label>


    </div>

      <div class="col-sm-3">
          <input type="text"   name="checkCode" placeholder="请输入验证码">
          <img onclick="changeimg(this)"  src="<%=basePath%>/ChickImgServlet" />
      </div>
      <%--<div class="checkbox">--%>
          <%--<label>--%>
              <%--输入验证码:<input for="inputPassword" type ="text" >
              <img onclick="changeimg(this)" src="<%=basePath%>/ChickImgServlet"><br>--%>
          <%--</label>--%>
      <%--</div>--%>







    <button class="btn btn-lg btn-primary btn-block" type="submit" >登陆</button>
    <button class="btn btn-lg btn-primary btn-block" type="button"  id="regist" onclick="javascript:window.location.href='pages/register.jsp'">注册</button>
  </form>

</div>
<!-- /container -->
<!-- 这个问题再好好想想 -->



</body>




</html>