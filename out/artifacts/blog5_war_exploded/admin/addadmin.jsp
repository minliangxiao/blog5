<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/6/15
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%--
    1.这是用做写博客的页面
    未完成：博客类型  博客照片 等功能没有做

--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/pages/css/login.css" />
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/messages_zh.js" type="text/javascript" charset="utf-8"></script>
    <!-- 一堆我也不太清楚的库 -->
    <link rel="stylesheet" type="text/css" href="plugin/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="plugin/Hui-iconfont/1.0.8/iconfont.min.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="plugin/pifu/pifu.css" />
    <title>添加管理员</title>
    <style type="text/css">
        div.error{

            /*padding-left: 30px;*/
            font-family:georgia;
            font-size: 15px;
            font-style: normal;
            color: red;
        }
    </style>

    <script type="text/javascript">
        function changeimg(obj){
            obj.src="<%=basePath%>/ChickImgServlet?=time"+new Date().getTime();

        }

    </script>
    <script>
        //校验表单
        $(function(){
            $("#checkForm").validate({
                rules:{
                    adminname:{
                        required:true,

                    },
                    adminpwd:{
                        required:true,

                    },

                },
                messages:{

                    adminname:{
                        required:"管理员名不能为空!",

                    },
                    adminpwd:{
                        required:"密码不能为空!",

                    }

                },
                errorElement: "div", //用来创建错误提示信息标签,validate插件默认的就是label
                success: function(div) { //验证成功后的执行的回调函数
                    //label指向上面那个错误提示信息标签label
                    div.text(" ") //清空错误提示消息
                        .addClass("success"); //加上自定义的success类
                }
            });
        });

    </script>

</head>
<body>
<div class="container-fluid">
    <%--头部--%>
    <%--<div class="wangEditor-txt" contenteditable="true" style="height: 184px;"> <p><br></p></div>--%>
    <%--<div class="wangEditor-menu-container clearfix" style="position: static; top: auto; width: 100%;"><div class="menu-group clearfix"><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-terminal"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-terminal"></i></a><div class="menu-tip" style="width: 53px; margin-left: -26.5px; display: none;">插入代码</div></div><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-quotes-left"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-quotes-left"></i></a><div class="menu-tip" style="width: 29px; margin-left: -14.5px; display: none;">引用</div></div><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-bold"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-bold"></i></a><div class="menu-tip" style="width: 29px; margin-left: -14.5px;">粗体</div></div></div><div class="menu-group clearfix"><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-picture"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-picture"></i></a><div class="menu-tip" style="width: 29px; margin-left: -14.5px;">图片</div></div><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-happy"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-happy"></i></a><div class="menu-tip" style="width: 29px; margin-left: -14.5px;">表情</div></div></div><div class="menu-group clearfix"><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-ccw"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-ccw"></i></a><div class="menu-tip" style="width: 29px; margin-left: -14.5px; display: none;">撤销</div></div><div class="menu-item clearfix"><a href="#" tabindex="-1"><i class="wangeditor-menu-img-enlarge2"></i></a><a href="#" tabindex="-1" class="selected" style="display: none;"><i class="wangeditor-menu-img-shrink2"></i></a><div class="menu-tip" style="width: 29px; margin-left: -14.5px;">全屏</div></div></div></div>--%>

    <%--左半部分--%>
    <div class="col-sm-9 col-md-9">
        <div class="content" id="content-control"> <!-- class添加table-responsive可左右滑动 -->
            <h3>添加管理员</h3>

            <div class="col-sm-10">
                <form action="${pageContext.request.contextPath }/AddAdminServlet" method="post" id="checkForm" >
                    <div class="input-group">
                        <label for="exampleInputTopic1">管理员名字：</label>
                        <input type="text" class="form-control"     name="adminname" >
                    </div>
                    <br>
                    <div class="input-group">
                        <label for="exampleInputTopic1">管理员密码：</label>
                        <input type="text" class="form-control"  name="adminpwd">
                    </div>
                    <br>
                    <div class="input-group">
                        <label for="exampleInputTopic1">管理员性别：</label>
                        <label>
                            <input type="radio" name="adminsex" value="男" checked="checked"> 男
                            <input type="radio" name="adminsex" value="女"> 女
                        </label>

                    </div>
                    <br>

                    <h3 style="color:#cc0000  ">${mesage}</h3>




                    <button type="submit" class="btn btn-primary btn-lg">提交</button>
                    <button type="reset" class="btn btn-default btn-lg">重写</button>
                </form>
            </div>
        </div>
    </div>

    <%--右半部分--%>


</div>
</body>
</html>
