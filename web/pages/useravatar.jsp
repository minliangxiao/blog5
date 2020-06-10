
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
    <title>博客编辑</title>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="/pages/header2.jsp"></jsp:include>
    <%--左半部分--%>
    <div class="col-sm-9 col-md-9">
        <div class="content" id="content-control">
            <h3>修改头像</h3>

            <div class="col-sm-10">

                <h3>请选择头像</h3>
                <form action="${pageContext.request.contextPath }/UpAvatarServlet" method="post"  enctype="multipart/form-data">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">选择头像</span>
                        <input type="file" class="form-control"  aria-describedby="basic-addon1"><br>
                        <input type="hidden" value="${user.userid}">
                    </div>




                    <button type="submit" class="btn btn-primary btn-lg">提交</button>

                </form>
            </div>
        </div>
    </div>

    <

    <jsp:include page="/pages/footer.jsp"></jsp:include>
</div>
</body>
</html>
