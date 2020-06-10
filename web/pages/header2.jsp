 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		  	<!-- <a class="navbar-brand" id="navbar-brand" href="home.html">oaSystem</a> -->
		  <!-- 头像 -->
		  <div class="navbar-brand" id="navbar-brand">
		  	<div class="dropdown" >
		  	    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="border: 0;">
		  	  	<img id="img-head" src="${pageContext.request.contextPath}/pages/img/100.jpg" width="45" height="30" class="img-circle" >
		  	    <!-- 后期将考虑用数据库的路径添加头像 -->
		  	    </button>
		  	    <!-- 考虑下换个亲切点的用语 -->
		  	    <label> ${ user.username} 欢迎您登陆</label> 
		  	     <!-- <ul class="nav navbar-nav navbar-right">
		  	    <li><a href="">登陆</a></li>
		  	    <li><a href="">注册</a></li>
		  	    </ul> -->
		  	    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="${pageContext.request.contextPath}/FindUserDataServlet?userid=${user.userid}">个人中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/changepwd.jsp">账号管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/useravatar.jsp">修改头像</a></li>
                    <li><a href="${pageContext.request.contextPath}/FindMyBlogServlet?userid=${user.userid} " >我的博客</a></li>
                    <li><a href="pages/blog_write.jsp">写博客</a></li>
                    <li><a href="${pageContext.request.contextPath}/SignOutServlet">退出登录</a></li>
		  	    </ul>
		  	  </div>
		  	</div>
		  </div>
		  
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/FindBlogByName" method="post">
                <div class="form-group">
                    <input type="text"  id="search" class="form-control" placeholder="输入查询博客主题" name="blog_name" onkeyup="searchWord(this)">
                    <div id="showDiv" style="display:none; position:absolute;z-index:1000;background:#fff; width:179px;border:1px solid #ccc;">

                    </div>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>




          <ul class="nav navbar-nav navbar-right">
          <!-- 这个跳转要仔细想想 -->
			  <li><a href="${pageContext.request.contextPath}/HomeServlet">首页</a></li>
              <li><a href="${pageContext.request.contextPath}/FindHotServlet">热门文章</a></li>
              <li><a href="${pageContext.request.contextPath}/FindAllUserServlet?user=user ">热门博主</a></li>
              <li><a href="${pageContext.request.contextPath}/FindAllNewBlogServlet?rows=12">最新发布</a></li>
              <li><a href="${pageContext.request.contextPath}/FindAllDiscussServlet?user=user">查看公告</a></li>
              <li><a href="${pageContext.request.contextPath}/pages/blog_write.jsp">写博客</a></li>

          </ul>

            <%--ajax 异步搜索--%>
            <script type="text/javascript">
                function overFn(obj){
                    $(obj).css("background","#DBEAF9");
                }
                function outFn(obj){
                    $(obj).css("background","#fff");
                }

                function clickFn(obj){
                    $("#search").val($(obj).html());
                    $("#showDiv").css("display","none");
                }

                function searchWord(obj){

                    //1、获得输入框的输入的内容
                    var word = $(obj).val();
                    //2、根据输入框的内容去数据库中模糊查询---List<Product>
                    var content = "";
                    $.post(
                        "${pageContext.request.contextPath}/searchWord",
                        {"word":word},
                        function(data){

                            if(data.length>0){
                                for(var i=0;i<data.length;i++){
                                    content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
                                }
                                $("#showDiv").html(content);
                                $("#showDiv").css("display","block");
                            }

                        },
                        "json"
                    );

                }


            </script>

        </div><!--/.nav-collapse -->
			
      </div>
		
    </nav>