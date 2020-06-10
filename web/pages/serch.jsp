<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta href="<%=basePath%>">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/login.css" />
    <!-- 一堆我也不太清楚的库 -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/Hui-iconfont/1.0.8/iconfont.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/pifu/pifu.css" />

    <title>博客浏览</title>
</head>
<!--
    这是用来浏览博客文章的页面

    未完成：》》这个页面还暂时不能用！！
            因为c标签哪里还没数据可以取后面后端数据写了过后可以尝试下
 -->

<body>
<div class="container-fluid">
    <!-- 引入header -->
    <jsp:include page="/pages/header2.jsp"></jsp:include><!-- 知识点路径开头的/代表了当前目录》》》这个路径可能有问题 -->
    <%--这里用来放主题内容--%>
    <!--导航条这个模块完全没有用！！完全是用来填充内容的-->
    <nav class="breadcrumb">
        <div class="container">
            <i class="Hui-iconfont">&#xe67f;</i><a href="index.html" class="c-primary">首页</a>
            <span class="c-gray en">&gt;</span> <a href="article.html" class="c-primary">学无止尽</a>
            <span class="c-gray en">&gt;</span> <span class="c-gray"><i class="Hui-iconfont">&#xe64b;</i> nginx</span>
        </div>
    </nav>
    <section class="container">
        <!--left-->
        <div class="col-sm-9 col-md-9 mt-20">


            <!--article list-->
            <ul class="index_arc">
                <%--后期用c标签查询数据--%>
                <c:forEach items="${blogList}" var="b">
                    <li class="index_arc_item">
                        <a href="<%=basePath%>showBlogServlet?blog_id=${b.blog_id}&&user=user" class="pic">
                            <img class="lazyload" src="${pageContext.request.contextPath}/upload/${b.photos.photo_address}" height="90" alt="图片" />
                        </a>
                        <h4 class="title"><a href="<%=basePath%>showBlogServlet?blog_id=${b.blog_id}&&user=user">${b.blog_titile}</a></h4><%--个人博客应该选择什么样的域名和域名后缀--%>
                        <div class="date_hits">
                            <span>作者id:${b.blog_id}</span>
                            <span>${b.blog_createtime}</span><%----%>
                            <span><a href="<%=basePath%>showBlogServlet?blog_id=${b.blog_id}&&user=user">${b.blog_name}</a></span>
                            <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> ${b.blog_hot}° </p>
                            <p class="commonts"><i class="Hui-iconfont" title="评论量">&#xe622;</i> <span class="cy_cmt_count">${b.blog_renumber}</span></p>
                        </div>
                        <div class="desc">${b.blog_context}</div>
                    </li>
                </c:forEach>




            </ul>
            <div class="text-c mb-20" id="moreBlog">
                <%--<nav aria-label="Page navigation">--%>
                    <%--<ul class="pagination">--%>
                        <%--<li>--%>
                            <%--<a href="#" aria-label="Previous">--%>
                                <%--<span aria-hidden="true">&laquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>

                        <%--<c:forEach begin="1" end="${page.totalPage}" var="i">--%>
                            <%--<li><a href="${pageContext.request.contextPath}/FindAllNewBlogServlet?currentPage=${i}&&rows=12 ">${i}</a></li>--%>
                        <%--</c:forEach>--%>

                        <%--<li>--%>
                            <%--<a href="#" aria-label="Next">--%>
                                <%--<span aria-hidden="true">&raquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<span style="font-size: 25px;margin-left: 5px">共查询到${page.totalCount}条数据 共${page.totalPage}页</span>--%>
                    <%--</ul>--%>
                <%--</nav>--%>
            </div>
        </div>

        <!--right 考虑要不要到时候把他封装-->
        <div class="col-sm-3 col-md-3 mt-20">

            <!--导航这里也考虑下能不能用c标签写-->
            <%--<div class="panel panel-primary mb-20">--%>
                <%--<div class="panel-body">--%>
                    <%--<input class="btn btn-primary radius nav-btn" type="button" value="杂谈">--%>
                    <%--<input class="btn btn-primary-outline radius nav-btn" type="button" value="java">--%>
                    <%--<input class="btn btn-primary-outline radius nav-btn" type="button" value="框架">--%>
                    <%--<input class="btn btn-primary-outline radius nav-btn" type="button" value="服务域名">--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<!--热门推荐-->--%>
            <%--<div class="bg-fff box-shadow radius mb-20">--%>
                <%--<div class="tab-category">--%>
                    <%--<a href=""><strong>热门推荐</strong></a>--%>
                <%--</div>--%>
                <%--<div class="tab-category-item">--%>
                    <%--<ul class="index_recd">--%>
                        <%--<li>--%>
                            <%--<a href="#">阻止a标签href默认跳转事件</a>--%>
                            <%--<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>--%>
                        <%--</li>--%>
                        <%--<li >--%>
                            <%--<a href="#">PHP面试题汇总</a>--%>
                            <%--<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>--%>
                        <%--</li>--%>
                        <%--<li >--%>
                            <%--<a href="#">阻止a标签href默认跳转事件</a>--%>
                            <%--<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>--%>
                        <%--</li>--%>
                        <%--<li >--%>
                            <%--<a href="#">阻止a标签href默认跳转事件</a>--%>
                            <%--<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>--%>
                        <%--</li>--%>
                        <%--<li >--%>
                            <%--<a href="#">PHP面试题汇总</a>--%>
                            <%--<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<!--标签-->--%>
            <%--<div class="bg-fff box-shadow radius mb-20">--%>
                <%--<div class="tab-category">--%>
                    <%--<a href=""><strong>标签云</strong></a>--%>
                <%--</div>--%>
                <%--<div class="tab-category-item">--%>
                    <%--<div class="tags"> <a href="http://www.h-ui.net/">H-ui前端框架</a> <a href="http://www.h-ui.net/websafecolors.shtml">Web安全色</a> <a href="http://www.h-ui.net/Hui-4.4-Unslider.shtml">jQuery轮播插件</a> <a href="http://idc.likejianzhan.com/vhost/korea_hosting.php">韩国云虚拟主机</a> <a href="http://www.h-ui.net/bug.shtml">IEbug</a> <a href="http://www.h-ui.net/site.shtml">IT网址导航</a> <a href="http://www.h-ui.net/icon/index.shtml">网站常用小图标</a> <a href="http://www.h-ui.net/tools/jsformat.shtml">web工具箱</a> <a href="http://www.h-ui.net/bg/index.shtml">网站常用背景素材</a> <a href="http://www.h-ui.net/yuedu/chm.shtml">H-ui阅读</a> <a href="http://www.h-ui.net/easydialog-v2.0/index.html">弹出层插件</a> <a href="http://www.h-ui.net/SuperSlide2.1/demo.html">SuperSlide插件</a> <a href="http://www.h-ui.net/TouchSlide1.1/demo.html">TouchSlide</a></div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>

    </section>

    <jsp:include page="/pages/footer.jsp"></jsp:include><%--页面尾部--%>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>