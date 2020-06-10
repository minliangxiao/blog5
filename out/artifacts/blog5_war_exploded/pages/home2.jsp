<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/login.css"/>
    <!-- 一堆我也不太清楚的库 -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/Hui-iconfont/1.0.8/iconfont.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/pifu/pifu.css"/>

    <title>博客主页</title>
</head>
<!--
	这个用来显示登陆后的显示的主页

 -->

<body>
<div class="container-fluid">
    <!-- 引入header -->
    <jsp:include page="/pages/header2.jsp"></jsp:include><!-- 知识点路径开头的/代表了当前目录》》》这个路径可能有问题 -->

    <!--  开始写正文 -->
    <section class="container pt-20">

        <div class="col-sm-9 col-md-9"><!-- 左半部一部分 -->
            <!-- 轮播图 -->
            <!-- 1.后面考虑轮播图的内容问题
                 2.个轮播图还存在不一样图片变化问题
            -->
            <div class="container-fluid">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- 轮播图的中的小点 -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
                    <!-- 轮播图的轮播图片 -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath }/pages/img/slide2.jpg">
                            <div class="carousel-caption">
                                <!-- 轮播图上的文字 -->
                            </div>
                        </div>
                        <div class="item">
                            <a href="#"><img src="${pageContext.request.contextPath }/pages/img/slide1.jpg"></a>
                            <div class="carousel-caption">
                                热门博客
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath }/pages/img/slide3.jpg">
                            <div class="carousel-caption">
                                <!-- 轮播图上的文字 -->
                            </div>
                        </div>
                    </div>

                    <!-- 上一张 下一张按钮 -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <!-- 轮播图在这里结束 -->

            <!-- 最新文章 -->
            <div class="mt-20 bg-fff box-shadow radius mb-5">
                <div class="tab-category">
                    <a href="${pageContext.request.contextPath}/FindAllNewBlogServlet?rows=12"><strong class="current">最新发布</strong></a>
                </div>
            </div>
            <!-- 这里写最新文章的主要类容 -->
            <div class="art_content">
                <ul class="index_arc">

                    <!-- 后面用for循环实现更多数据的添加 -->
                    <c:forEach items="${newblogs.datalist}" var="blog">

                        <li class="index_arc_item"><%--blog_id--%>
                            <a href="<%=basePath%>showBlogServlet?blog_id=${blog.blog_id}&&user=user" class="pic">
                                <img class="lazyload"
                                     src="${pageContext.request.contextPath}/upload/${blog.photos.photo_address}"
                                     height="90" alt="博客图片"/><!--  data-original="admintemp/art.jpg"不知道是什么意思-->
                            </a><%--这个图片之后在想--%>
                            <h4 class="title"><a
                                    href="<%=basePath%>showBlogServlet?blog_id=${blog.blog_id}&&user=user">${blog.blog_titile} </a>
                            </h4>
                            <div class="date_hits">
                                <span>发布人id：${blog.userid}</span>
                                <span>时间：${blog.blog_createtime}</span>
                                <span>博客名称：<a
                                        href="<%=basePath%>showBlogServlet?blog_id=${blog.blog_id}&&user=user">${blog.blog_name}</a></span>
                                <p class="hits" style="color: #cc0000"><i class="Hui-iconfont"
                                                                          title="点击量">&#xe6c1;</i> ${blog.blog_hot}°
                                </p>
                                <p class="commonts" style="color:#cc0000 "><i class="Hui-iconfont"
                                                                              title="评论量">&#xe622;</i> <span
                                        class="cy_cmt_count">${blog.blog_renumber}</span></p>
                            </div>
                            <div class="desc"><%--这是正文--%>
                                    ${blog.blog_context}

                            </div>
                        </li>
                    </c:forEach>

                </ul>
                <%--分页功能--%>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${newblogs.currentPage==1}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/HomeServlet?currentPage=1"
                                   aria-label="Previous">

                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${newblogs.currentPage!=1}">
                            <li>
                                <a href="${pageContext.request.contextPath}/HomeServlet?currentPage=${newblogs.currentPage-1}"
                                   aria-label="Previous">

                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>


                        <c:forEach begin="1" end="${newblogs.totalPage}" var="i">
                            <%--<li><a href="${pageContext.request.contextPath}/HomeServlet?currentPage=${i}">${i}</a></li>--%>
                            <c:if test="${newblogs.currentPage==i}">
                                <li class="active"><a
                                        href="${pageContext.request.contextPath}/HomeServlet?currentPage=${i}">${i}</a>
                                </li>
                            </c:if>
                            <c:if test="${newblogs.currentPage!=i}">
                                <li><a href="${pageContext.request.contextPath}/HomeServlet?currentPage=${i}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${newblogs.currentPage==newblogs.totalPage}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/HomeServlet?currentPage=${newblogs.totalPage}"
                                   aria-label="Previous">

                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${newblogs.currentPage!=newblogs.totalPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/HomeServlet?currentPage=${newblogs.currentPage+1}"
                                   aria-label="Previous">

                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <span style="font-size: 25px;margin-left: 5px">共查询到${newblogs.totalCount}条数据 共${newblogs.totalPage}页</span>
                    </ul>
                </nav>


            </div>


        </div>
        <div class="col-sm-3 col-md-3"><!-- 右半部 -->
            <!--站点声明-->
            <div class="panel panel-default mb-20">
                <div class="panel-body">
                    <i class="Hui-iconfont" style="float: left;">&#xe62f;&nbsp;</i>
                    <div class="slideTxtBox">
                        <div class="bd">

                            <div class="mt-20 bg-fff box-shadow radius mb-5">
                                <div class="tab-category">
                                    <a href="${pageContext.request.contextPath}/FindAllDiscussServlet?user=user"><strong
                                            class="current">公告</strong></a>
                                </div>
                            </div>
                            <ul><%--这是发公告的--%>


                                <c:forEach items="${newdiscusslist}" var="dis">


                                    <li>
                                        <a href="${pageContext.request.contextPath}/UpdataDiscussServlet?user=user&&discussid=${dis.discussid}"
                                           style="color:#cc0000 ">${dis.discuss_title}</a></li><%--这个后期还需要完善--%>
                                </c:forEach>
                            </ul>


                        </div>
                    </div>
                </div>
            </div>
            <!--博主信息  登陆后显示这个模块-->
            <!-- <div class="bg-fff box-shadow radius mb-20">
                <div class="tab-category">
                    <a href=""><strong>博主信息</strong></a>
                </div>
                <div class="tab-category-item">
                    <ul class="index_recd">
                        <li class="index_recd_item"><i class="Hui-iconfont">&#xe653;</i>姓名：王风宇</li>
                        <li class="index_recd_item"><i class="Hui-iconfont">&#xe70d;</i>职业：JavaWeb开发</li>
                        <li class="index_recd_item"><i class="Hui-iconfont">&#xe63b;</i>邮箱：<a href="mailto:wfyv@qq.com">wfyv@qq.com</a></li>
                        <li class="index_recd_item"><i class="Hui-iconfont">&#xe671;</i>定位：安徽 &middot; 合肥</li>
                    </ul>
                </div>
            </div>
           -->
            <!--热门推荐--><%--勉强完成了--%>
            <div class="bg-fff box-shadow radius mb-20">
                <div class="tab-category">
                    <a href=""><strong>热门推荐</strong></a>
                </div>
                <div class="tab-category-item">
                    <ul class="index_recd">
                        <%--<c:forEach items="${tuijian}" var="tui">--%>
                        <%--<li>--%>
                        <%--<a href="#">${tui.blog_titile}</a>--%>
                        <%--<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>--%>
                        <%--</li>--%>
                        <%--</c:forEach>--%>
                    </ul>
                </div>
            </div>

            <!--点击排行--><%--这个算法还是要改一下!!要不就不要这个功能--%>
            <div class="bg-fff box-shadow radius mb-20">
                <div class="tab-category">
                    <a href="${pageContext.request.contextPath}/FindHotServlet"><strong>点击排行</strong></a>
                </div>
                <div class="tab-category-item">
                    <ul class="index_recd clickTop">
                        <c:forEach items="${dianji}" var="hot">
                            <li>
                                <a href="<%=basePath%>showBlogServlet?blog_id=${hot.blog_id}&&user=user">${hot.blog_titile}</a>

                                <p class="hits" style="color: #cc0000"><i class="Hui-iconfont"
                                                                          title="点击量">&#xe6c1;</i> ${hot.blog_hot}° </p>

                            </li>
                        </c:forEach>


                    </ul>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- 这个底部的标注规则可以在网上搜搜再决定写啥子 -->
<jsp:include page="/pages/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>