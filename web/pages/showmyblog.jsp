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
                <c:forEach items="${page.datalist}" var="n">
                    <li class="index_arc_item">
                        <a href="<%=basePath%>showBlogServlet?blog_id=${n.blog_id}" class="pic">
                            <img class="lazyload" src="${pageContext.request.contextPath}/upload/${n.photos.photo_address}" height="90" alt="图片" />
                        </a>
                        <h4 class="title"><a href="<%=basePath%>showBlogServlet?blog_id=${n.blog_id}">${n.blog_titile}</a></h4><%--个人博客应该选择什么样的域名和域名后缀--%>
                        <div class="date_hits">
                            <span>作者id:${n.blog_id}</span>
                            <span>${n.blog_createtime}</span><%----%>
                            <span><a href="<%=basePath%>showBlogServlet?blog_id=${n.blog_id}">${n.blog_name}</a></span>
                            <p class="hits" style="color: #cc0000"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i><a href="<%=basePath%>/UpdataBlogServlet?blog_id=${n.blog_id}"  style="color: #cc0000">编辑</a> </p>
                            <p class="commonts" style="color: #cc0000"><i class="Hui-iconfont" title="点击量">&#xe622;</i>
                                <a href="${pageContext.request.contextPath}/DeleteMyBlogServlet?blog_id=${n.blog_id}  " style="color: #cc0000">删除</a> </p>
                        </div>
                        <div class="desc">${n.blog_context}</div>
                    </li>
                </c:forEach>




            </ul>
            <div class="text-c mb-20" id="moreBlog">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${page.currentPage==1}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/FindMyBlogServlet?currentPage=1&&rows=12&&userid=${user.userid}"  aria-label="Previous">

                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${page.currentPage!=1}">
                            <li >
                                <a href="${pageContext.request.contextPath}/FindMyBlogServlet?currentPage=${page.currentPage-1}&&rows=12&&userid=${user.userid}" aria-label="Previous">

                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${page.totalPage}" var="i">
                            <c:if test="${page.currentPage==i}">
                                <li class="active"><a href="${pageContext.request.contextPath}/FindMyBlogServlet?currentPage=${i}&&rows=12&&userid=${user.userid}">${i}</a></li>
                            </c:if>
                            <c:if test="${page.currentPage!=i}">
                                <li ><a href="${pageContext.request.contextPath}/FindMyBlogServlet?currentPage=${i}&&rows=12&&userid=${user.userid}">${i}</a></li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${page.currentPage==page.totalPage}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/FindMyBlogServlet?currentPage=${page.totalPage}&&rows=12&&userid=${user.userid}"  aria-label="Previous">

                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${page.currentPage!=page.totalPage}">
                            <li >
                                <a href="${pageContext.request.contextPath}/FindMyBlogServlet?currentPage=${page.currentPage+1}&&rows=12&&userid=${user.userid}" aria-label="Previous">

                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <span style="font-size: 25px;margin-left: 5px">共查询到${page.totalCount}条数据 共${page.totalPage}页</span>
                    </ul>
                </nav>
            </div>
        </div>
    </section>

    <jsp:include page="/pages/footer.jsp"></jsp:include><%--页面尾部--%>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>