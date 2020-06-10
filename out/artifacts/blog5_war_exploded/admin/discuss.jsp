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

    <div class="col-sm-9 col-md-9">
        <div class="content" id="content-control">
            <h3>公告编写</h3>

            <div class="col-sm-10">
                <form action="${pageContext.request.contextPath }/DiscussWriteServlet" method="post" >

                    <div class="form-group">
                        <label >输入公告主题：</label>
                        <input type="text" class="form-control" placeholder="输入公告主题" name="discuss_tile">
                    </div>
                    <br>



                    <div class="wangEditor-txt"  contenteditable="true">
                        <label >输入公告内容：</label>
                        <textarea class="form-control" rows="8" placeholder="输入公告内容" name="discuss_content"></textarea>
                    </div>
                    <br>
                    <input type="hidden" name="userid" value="${admin.adminid}">
                    <input type="hidden" name="Adminname" value="${admin.adminname}">

                    <button type="submit" class="btn btn-primary btn-lg">提交</button>
                    <button type="reset" class="btn btn-default btn-lg">重写</button>
                </form>
            </div>
        </div>
    </div>



</div>
</body>
</html>
