<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%--<meta href="<%=basePath%>">--%>
<title>菜单</title>
<link href="<%=basePath%>admin/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="<%=basePath%>admin/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="<%=basePath%>js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单树'); 
		d.add('0102','01','用户管理','','','mainFrame');
		d.add('010201','0102','所有用户','${pageContext.request.contextPath}/FindAllUserServlet','','mainFrame');
        d.add('0103','01','管理员管理');
        d.add('010301','0103','管理员展示','${pageContext.request.contextPath}/FindAllAdmin','','mainFrame');
        d.add('010302','0103','添加管理员','${pageContext.request.contextPath}/admin/addadmin.jsp','','mainFrame');
        // d.add('0104','01','博客管理');
        // d.add('010401','0104','博客展示','adminproductservlet','','mainFrame');
        d.add('0105','01','公告管理');
        d.add('010501','0105','公告展示','${pageContext.request.contextPath}/FindAllDiscussServlet','','mainFrame');
        d.add('010502','0105','发布公告','${pageContext.request.contextPath}/admin/discuss.jsp','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>

</body>
</html>
