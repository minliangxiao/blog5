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
    <!-- 一堆我也不太清楚的库 -->
    <link rel="stylesheet" type="text/css" href="plugin/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="plugin/Hui-iconfont/1.0.8/iconfont.min.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="plugin/pifu/pifu.css" />
    <title>公告编辑</title>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="/pages/header2.jsp"></jsp:include>
    <div class="col-sm-9 col-md-9">
        <div class="content" id="content-control">
            <h3 style="color: #cc0000">公告</h3>

            <div class="col-sm-10">


                    <div class="form-group">
                        <label >输入公告主题：</label>
                        <input type="text" class="form-control" disabled="disabled" value="${discuss.discuss_title}" >
                    </div>
                    <br>



                    <div class="wangEditor-txt"  >
                        <label >公告内容如下：</label>
                        <br>
                        <label><p style="color: #cc0000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            ${discuss.discuss_content}</p></label>

                    </div>
                    <br>


            </div>
        </div>
    </div>



</div>
</body>
</html>
