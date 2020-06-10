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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<meta href="<%=basePath%>">--%>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/login.css"/>
    <!-- 一堆我也不太清楚的库 -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/Hui-iconfont/1.0.8/iconfont.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/pifu/pifu.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>pages/plugin/wangEditor/css/wangEditor.min.css">
    <%--用于显示评论框--%>

    <title>博客浏览</title>
</head>
<!--
    这是用来文章的页面

    未完成：》》这个页面还暂时不能用！！
            因为c标签哪里还没数据可以取后面后端数据写了过后可以尝试下
 -->

<body>
<div class="container-fluid">
    <!-- 引入header -->
    <jsp:include page="/pages/header2.jsp"></jsp:include><!-- 知识点路径开头的/代表了当前目录》》》这个路径可能有问题 -->
    <%--这里用来放主题内容--%>
    <!--导航条-->
    <nav class="breadcrumb">
        <div class="container"><i class="Hui-iconfont">&#xe67f;</i> <a href="index.html" class="c-primary">首页</a> <span
                class="c-gray en">&gt;</span> <span class="c-gray">文章</span> <span class="c-gray en">&gt;</span> <span
                class="c-gray">个人博客应该选择什么样的域名和域名后缀</span></div>
    </nav>

    <section class="container pt-20">

        <div class="row w_main_row">


            <div class="col-lg-9 col-md-9 w_main_left">
                <div class="panel panel-default  mb-20">
                    <%--着部分先这样！！后期考虑用后台写--%>
                    <div class="panel-body pt-10 pb-10">
                        <h2 class="c_titile">${aBlog.blog_titile}</h2>
                        <p class="box_c"><span class="d_time">发布时间：${aBlog.blog_createtime}</span><span>编辑：<a
                                href="mailto:wfyv@qq.com">wilco</a></span><span>阅读（88646）</span></p>
                        <ul class="infos">

                            <p><strong>${aBlog.blog_context}</strong></p>
                            <c:forEach items="${photos}" var="p">

                                <p>&nbsp;<img src="upload/${p.photo_address}" alt="${p.photo_desc}" width="700"
                                              height="886"></p>

                            </c:forEach>
                            <%-- <p><a href="http://www.aliyun.com/product/ecs" target="_blank"><strong><span style="color: rgb(0, 0, 255);">前往阿里云官网购买&gt;&gt;</span></strong></a></p>--%>
                            <p>&nbsp;</p>
                            <p align="center" class="pageLink"></p>

                        </ul>

                        <div class="keybq">
                            <p><span>关键字</span>：<a class="label label-default">${aBlog.blog_keyword}</a><%--<a class="label label-default">阿里云</a><a class="label label-default">空间</a></p>--%>
                        </div>


                        <div class="nextinfo">
                            <%--<p class="last">上一篇：<a href="#">免费收录网站搜索引擎登录口大全</a></p>--%>
                            <%--<p class="next">下一篇：<a href="#">javascript显示年月日时间代码</a></p>--%>
                        </div>

                    </div>
                </div>
                <%--评论区！！这里的功能还是考虑改下
                        未完成：不知道哪里有问题样式没有想象的那么好！！！后面再看看
                --%>
                <div class="panel panel-default  mb-20">
                    <div class="tab-category">
                        <a href=""><strong>评论区</strong></a>
                    </div>
                    <div class="panel-body">
                        <div class="panel-body" style="margin: 0 3%;">
                            <div class="mb-20">
                                <ul class="commentList">
                                    <c:forEach items="${commList}" var="comm">
                                        <li class="item cl"><a href="#"><i class="avatar size-L radius"><img alt=""
                                                                                                             src="http://qzapp.qlogo.cn/qzapp/101388738/1CF8425D24660DB8C3EBB76C03D95F35/100"></i></a>
                                            <div class="comment-main">
                                                <header class="comment-header">
                                                    <div class="comment-meta"><a class="comment-author"
                                                                                 href="#">${comm.username}</a>
                                                        <time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20"
                                                              class="f-r">${comm.commtime}</time>
                                                    </div>
                                                </header>
                                                <div class="comment-body">
                                                    <p> ${comm.re_content}</p>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                    <%--<li class="item cl"> <a href="#"><i class="avatar size-L radius"><img alt="" src="http://qzapp.qlogo.cn/qzapp/101388738/696C8A17B3383B88804BA92ECBAA5D81/100"></i></a>--%>
                                    <%--<div class="comment-main">--%>
                                    <%--<header class="comment-header">--%>
                                    <%--<div class="comment-meta"><a class="comment-author" href="#">老王</a>--%>
                                    <%--<time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20" class="f-r">2014-8-31 15:20</time>--%>
                                    <%--</div>--%>
                                    <%--</header>--%>
                                    <%--<div class="comment-body">--%>
                                    <%--<p> +1</p>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--</li>--%>

                                </ul>

                            </div>
                            <div class="line"></div>
                            <!--用于评论-->
                            <div class="mt-20" id="ct">
                                <form action="InsertCommServlet" method="post">
                                    <div id="err" class="Huialert Huialert-danger hidden radius">成功状态提示</div>
                                    <textarea class="form-control" rows="8" placeholder="看完留一发吧"
                                              name="re_content"></textarea>
                                    <div class="text-r mt-10">
                                    </div>
                                    <input type="hidden" name="username" value="${user.username}">
                                    <input type="hidden" name="userid" value="${user.userid}">
                                    <input type="hidden" name="blogid" value="${blog_id}">
                                    <input type="submit" class="btn btn-primary radius" value="发表评论">
                                </form>
                            </div>

                            <!--用于回复-->
                            <%--<div class="comment hidden mt-20">--%>
                            <%--<div id="err2" class="Huialert Huialert-danger hidden radius">成功状态提示</div>--%>
                            <%--<textarea class="textarea" style="height:100px;" > </textarea>--%>
                            <%--<button onclick="hf(this);" type="button" class="btn btn-primary radius mt-10">回复</button>--%>
                            <%--<a class="cancelReply f-r mt-10">取消回复</a>--%>
                            <%--</div>--%>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3">
                <!--热门推荐》》》这里考虑要不要单独写一个jsp页面单独引入显示-->
                <div class="bg-fff box-shadow radius mb-20">
                    <div class="tab-category">
                        <a href=""><strong>热门推荐</strong></a>
                    </div>
                    <div class="tab-category-item">
                        <ul class="index_recd">
                            <li>
                                <a href="#">阻止a标签href默认跳转事件</a>
                                <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
                            </li>
                            <li>
                                <a href="#">PHP面试题汇总</a>
                                <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
                            </li>
                            <li>
                                <a href="#">阻止a标签href默认跳转事件</a>
                                <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
                            </li>
                            <li>
                                <a href="#">阻止a标签href默认跳转事件</a>
                                <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
                            </li>
                            <li>
                                <a href="#">PHP面试题汇总</a>
                                <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
                            </li>
                        </ul>
                    </div>
                </div>


            </div>
        </div>

    </section>

    <jsp:include page="/pages/footer.jsp"></jsp:include><%--页面尾部--%>
    <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</body>
</html>