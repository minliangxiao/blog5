<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta href="<%=basePath%>">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/login.css"/>
    <!-- 一堆我也不太清楚的库 -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/Hui-iconfont/1.0.8/iconfont.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/pifu/pifu.css"/>

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
    <jsp:include page="/pages/header2.jsp"></jsp:include>

    <nav class="breadcrumb">
        <div class="container">
            <i class="Hui-iconfont">&#xe67f;</i><a href="index.html" class="c-primary">首页</a>
            <span class="c-gray en">&gt;</span> <a href="article.html" class="c-primary">学无止尽</a>
            <span class="c-gray en">&gt;</span> <span class="c-gray"><i class="Hui-iconfont">&#xe64b;</i> nginx</span>
        </div>
    </nav>
    <section class="container">

        <div class="col-sm-9 col-md-9 mt-20">


            <ul class="index_arc">
                <%--后期用c标签查询数据--%>
                <c:forEach items="${page.datalist}" var="n">
                    <li class="index_arc_item">
                        <h4 class="title"><a
                                href="<%=basePath%>UpdataDiscussServlet?user=user&&discussid=${n.discussid}"
                                style="color: #cc0000">公告主题：${n.discuss_title}</a></h4><%--个人博客应该选择什么样的域名和域名后缀--%>
                        <div class="date_hits">
                            <span>发布人:${n.adminname}</span>
                            <span>${n.discuss_time}</span><%----%>
                        </div>
                        <div class="desc"><span style="color: #cc0000">内容：
                        </span><span>${n.discuss_content}</span></div>
                        <div class="desc"></div>
                    </li>
                </c:forEach>


            </ul>
            <div class="text-c mb-20" id="moreBlog">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                        <c:forEach begin="1" end="${page.totalPage}" var="i">
                            <%--<li><a href="${pageContext.request.contextPath}/FindAllDiscussServlet?currentPage=${i}&&rows=12&&user=user">${i}</a></li>--%>
                            <c:if test="${page.currentPage==i}">
                                <li class="active"><a
                                        href="${pageContext.request.contextPath}/FindAllDiscussServlet?currentPage=${i}&&rows=12&&user=user">${i}</a>
                                </li>
                            </c:if>
                            <c:if test="${page.currentPage!=i}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/FindAllDiscussServlet?currentPage=${i}&&rows=12&&user=user">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${page.currentPage==page.totalPage}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/FindAllDiscussServlet?currentPage=${page.totalPage}&&rows=12&&user=user "
                                   aria-label="Previous">

                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${page.currentPage!=page.totalPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/FindAllDiscussServlet?currentPage=${page.currentPage+1}&&rows=12&&user=user"
                                   aria-label="Previous">

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