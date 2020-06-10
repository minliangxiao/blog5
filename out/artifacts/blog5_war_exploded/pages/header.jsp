

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 
	头部先这样子写吧！！之后再想想怎么美化
	
 -->
 <nav class="navbar navbar-inverse navbar-fixed-top  ">
      <div class="container">
        <div class="navbar-header" >
          <button type="button" class="navbar-toggle collapsed " id="navbar-button" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
		  <!-- logo的地方 -->
		   <%-- 	<a class="navbar-brand" id="navbar-brand" href="home.html"><img alt="Brand" src="${pageContext.request.contextPath}/pages/img/head.jpeg" width="35" height="35"></a>  --%>
		  <
		  <div class="navbar-brand" id="navbar-brand">
		 <!--  	<div class="dropdown" > -->
		  	     <div class="container-fluid">
					    <div class="navbar-header">
					     <a class="navbar-logo hidden-xs" href="#">
                <img class="logo" src="${pageContext.request.contextPath }/pages/img/head.jpeg" alt="博客" width="150" height="35">
           				 </a>
					    </div>
					    <ul class="nav navbar-nav navbar-right">
						  	    <li><a href="">登陆</a></li>
						  	    
						  </ul>
					  </div>
		  	    <!-- 考虑下换个亲切点的用语 -->
		  	  
		  	    
		  	   <!--  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		  	      <li><a href="#">个人中心</a></li>
		  	      <li><a href="#">账号管理</a></li>
		  	      <li><a href="#">修改头像</a></li>
		  	      <li><a href="SignOutServlet">退出登录</a></li>
		  	    </ul> -->
		  	  </div>
		  	</div>
		 <!--  </div> -->
		  
        <div id="navbar" class="navbar-collapse collapse">
        <form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="输入关键字">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
		<!-- 导航栏菜单  为什么这里的响应式没有体现出来-->
          <ul class="nav navbar-nav navbar-right" >
          <!-- 这个跳转要仔细想想  -->
			<li><a href="#">首页</a></li>
			<li><a href="#">热门文章</a></li>
			<li><a href="#">热门博主</a></li>
			<li><a href="#">最新发布</a></li>
			<li><a href="#">强烈推荐</a></li>
			
          </ul>
        </div><!--/.nav-collapse -->
			
      </div>
		
    </nav>