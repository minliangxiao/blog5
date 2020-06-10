
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

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
            <h3>修改公告</h3>

            <div class="col-sm-10">
                <form action="${pageContext.request.contextPath }/IsertUpDiscussServlet" method="post" >
                    <div class="input-group">
                        <label for="exampleInputTopic1">公告主题：</label>
                        <input type="text" class="form-control" placeholder="${discuss.discuss_title}"    name="discuss_title" value="${discuss.discuss_title}">
                    </div>
                    <br>
                    <div class="input-group">
                        <label for="exampleInputTopic1">公告正文：</label>
                        <input type="text" class="form-control"  placeholder="${discuss.discuss_content}" value="${discuss.discuss_content}" name="discuss_content">
                    </div>
                    <br>


                    <h3 style="color:#cc0000  ">${mesage}</h3>

                    <input type="hidden" name="discussid" value="${discuss.discussid}">


                    <button type="submit" class="btn btn-primary btn-lg">修改信息</button>
                    <button type="reset" class="btn btn-default btn-lg">重写</button>
                </form>
            </div>
        </div>
    </div>




</div>
</body>
</html>
