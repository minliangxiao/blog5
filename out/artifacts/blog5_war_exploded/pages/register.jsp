<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<!-- 
	未有完成部分：
		1.两次密码的校验
	考虑是否需要注册时填写qq号
 -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="css/nav.css"/>
    <link rel="icon" href="../../favicon.ico">
    <link href="<%=basePath%>/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery.validate.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/messages_zh.js" type="text/javascript" charset="utf-8"></script>
    <title>注册页面</title>
    <style type="text/css">
        label.error {

            /*padding-left: 30px;*/
            font-family: georgia;
            font-size: 15px;
            font-style: normal;
            color: red;
        }
    </style>
    <style type="text/css">
        body {
            background-color: #696969;
        }
    </style>
    <script type="text/javascript">
        function changeimg(obj) {
            obj.src = "<%=basePath%>/ChickImgServlet?=time" + new Date().getTime();

        }

    </script>
    <script>
        //校验表单
        $(function () {
            $("#checkForm").validate({
                rules: {
                    username: {
                        required: true,

                    },
                    userpwd: {
                        required: true,

                    },
                    userpwd2: {
                        required: true,
                        equalTo: "[name='userpwd']"


                    },
                    qq: {
                        required: true,

                    },
                    email: {
                        required: true,
                        email: true

                    },

                    checkCode: {
                        required: true,

                    }

                },
                messages: {

                    username: {
                        required: "用户名不能为空!",

                    },
                    userpwd: {
                        required: "密码不能为空!",

                    },
                    userpwd2: {
                        required: "密码不能为空!",
                        equalTo: "密码不一致"


                    },
                    qq: {
                        required: "qq号不能为空",

                    },
                    email: {
                        required: "邮箱不能为空",
                        email: "邮箱格式不对"

                    },
                    checkCode: {
                        required: "验证码不能为空",
                    }
                },
                errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
                success: function (label) { //验证成功后的执行的回调函数
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
    <div class="col-sm-6">
        <h2 style="color: red;">${message  }</h2>
        <h3>注册用户</h3>
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post" id="checkForm">

            <div class="form-group">
                <label for="inputName">昵称</label>
                <input type="text" class="form-control" id="inputName" placeholder="姓名" required name="username">
            </div>
            <div class="form-group">
                <label for="inputPassword">密码</label>
                <input type="password" class="form-control" id="inputPassword" placeholder="密码" required name="userpwd"><br/>
                <input type="password" class="form-control" id="suerPassword" placeholder="请确认密码" required
                       name="userpwd2">

            </div>
            <div class="form-group">
                <label>qq号</label>
                <input type="text" class="form-control" id="inputPhoneNo" placeholder="qq" required name="qq">
            </div>
            <div class="form-group">
                <label for="inputEmail">邮箱</label>
                <input type="email" class="form-control" id="inputEmail" placeholder="Email" required name="email">
            </div>
            <div class="form-group">
                <label for="inputEmail">验证码</label>

                <input type="text" class="form-control" name="checkCode" placeholder="请输入验证码">
                <img onclick="changeimg(this)" src="<%=basePath%>/ChickImgServlet"/>
            </div>


            <button type="reset" class="btn btn-default">重置</button>
            <button type="submit" class="btn btn-default">注册</button>
        </form>
    </div>
</div>
<!-- /container -->

</body>

</html>