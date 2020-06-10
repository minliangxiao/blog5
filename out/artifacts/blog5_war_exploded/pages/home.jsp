<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
<title>博客主页</title>
</head>
<!-- 
	这是用户的主页
	等下再思考下用不用这布局还是存在一个局限性下拉连框没有下拉效果
 -->
 
<body>
 <div class="container-fluid"> 
<!-- 引入header -->
<jsp:include page="/pages/header.jsp"></jsp:include><!-- 知识点路径开头的/代表了当前目录》》》这个路径可能有问题 -->

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
							<img src="${pageContext.request.contextPath }/pages/img/head.jpeg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<a href="#"><img src="${pageContext.request.contextPath }/pages/img/head.jpeg"></a>
							<div class="carousel-caption">
								热门博客
							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath }/pages/img/head.jpeg">
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
				<a href="http://www.baidu.com"><strong class="current">最新发布</strong></a>
			</div>
		</div>
		<!-- 这里写最新文章的主要类容 -->
		<div class="art_content">
				<ul class="index_arc">
				
				<!-- 后面用for循环实现更多数据的添加 -->
					<li class="index_arc_item">
					<a href="#" class="pic">
						<img class="lazyload" data-original="temp/art.jpg" alt="应该选" /><!--  data-original="temp/art.jpg"不知道是什么意思-->
					</a>
					<h4 class="title"><a href="article_detail.html">能显示不？？</a></h4>
					<div class="date_hits">
						<span>老王</span>
						<span>2017-02-24</span>
						<span><a href="/article-lists/10.html">程序人生</a></span>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
						<p class="commonts"><i class="Hui-iconfont" title="点击量">&#xe622;</i> <span class="cy_cmt_count">20</span></p>
					</div>
					<div class="desc">不论搭建什么样的网站，选择一个好的域名都是很有必要的，选择一个好的域名对网站的意义也是不言而喻的。每一个网站都有之对应的域名，就像人的名字一样。每个人都想自己有个好听的名字，网站也是一样。一个网站可以有多个域名，但是一个域名只能对应一个网站。&nbsp;一、域名要好记，方便输入&nbsp; &nbsp; &nbsp; &nbsp;域名本身的意义就是为了人们方便记忆才使用的，不然都用IP地址就好了。所以，网站域名一定要选择好记忆的。因为域名是</div>
				</li>		
					
				</ul>
					
		
		
		</div>
			
	
	</div>
	 <div class="col-sm-3 col-md-3"><!-- 右半部 -->
	 		<!--站点声明-->
        <div class="panel panel-default mb-20">
            <div class="panel-body">
                <i class="Hui-iconfont" style="float: left;">&#xe62f;&nbsp;</i>
                <div class="slideTxtBox">
                    <div class="bd">
                        <ul>
                            <li><a href="">Lao博客测试版上线，欢迎访问</a></li>
                            <li><a href="">内容如有侵犯，请立即联系管理员删除</a></li>
                            <li><a href="">本站内容仅供学习和参阅，不做任何商业用途</a></li>
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
  		<!--热门推荐-->
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
					<li >
						<a href="#">PHP面试题汇总</a>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
					</li>
					<li >
						<a href="#">阻止a标签href默认跳转事件</a>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
					</li>
					<li >
						<a href="#">阻止a标签href默认跳转事件</a>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
					</li>
					<li >
						<a href="#">PHP面试题汇总</a>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
					</li>
				</ul>
			</div>
		</div>
		
		<!--点击排行-->
        <div class="bg-fff box-shadow radius mb-20">
            <div class="tab-category">
                <a href=""><strong>点击排行</strong></a>
            </div>
            <div class="tab-category-item">
                <ul class="index_recd clickTop">
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                </ul>
            </div>
        </div>
	 </div>
</section>
 </div> 
 <!-- 这个底部的标注规则可以在网上搜搜再决定写啥子 -->
 <jsp:include page="/pages/footer.jsp"></jsp:include>
<script src="<%=basePath%>/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>