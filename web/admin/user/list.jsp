<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/Style1.css"
          rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <script language="javascript"
            src="${pageContext.request.contextPath}/js/public.js"></script>
    <script type="text/javascript">
        function addCategory() {
            window.location.href = "${pageContext.request.contextPath}/admin/user/add.jsp";
        }
    </script>
</HEAD>
<body>
<br>
<table cellSpacing="1" cellPadding="0" width="100%" align="center"
       bgColor="#f5fafe" border="0">
    <TBODY>
    <tr>
        <td class="ta_01" align="center" bgColor="#afd1f3"><strong>分类列表</strong>
        </TD>
    </tr>
    <tr>
        <td class="ta_01" align="right">
            <button type="button" id="add" name="add" value="添加"
                    class="button_add" onclick="addCategory()">
                &#28155;&#21152;
            </button>

        </td>
    </tr>
    <tr>
        <td class="ta_01" align="center" bgColor="#f5fafe">
            <table cellspacing="0" cellpadding="1" rules="all"
                   bordercolor="gray" border="1" id="DataGrid1"
                   style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

                    <td align="center" width="18%">用户名字</td>
                    <td align="center" width="17%">用户等级</td>
                    <td align="center" width="17%">创建时间</td>
                    <td align="center" width="17%">email</td>
                    <td align="center" width="17%">qq</td>


                    <td align="center" width="17%">状态</td>
                    <td width="17%" align="center">编辑</td>

                    <td width="17%" align="center">删除</td>
                </tr>

                <c:forEach items="${userpage.datalist}" var="u">
                    <tr onmouseover="this.style.backgroundColor = 'white'"
                        onmouseout="this.style.backgroundColor = '#F5FAFE';">
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="18%">${u .username }</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="17%">${u .userstatus }</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="17%">${u .user_createtime }</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="17%">${u .email}</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="17%">${u .qq }</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="17%">${u .user_lock }</td>
                        <td align="center" style="HEIGHT: 22px"><a
                                href="${ pageContext.request.contextPath }/admin/category/edit.jsp">
                            <img
                                    src="${pageContext.request.contextPath}/images/i_edit.gif"
                                    border="0" style="CURSOR: hand">
                        </a></td>

                        <td align="center" style="HEIGHT: 22px"><a
                                href="${pageContext.request.contextPath}/DelectUserServlet?userid=${u.userid}">
                            <img src="${pageContext.request.contextPath}/images/i_del.gif"
                                 width="16" height="16" border="0" style="CURSOR: hand">
                        </a></td>
                    </tr>
                </c:forEach>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${userpage.totalPage}" var="i">
                        <li><a href="${pageContext.request.contextPath}/FindAllUserServlet?currentPage=${i}">${i}</a>
                        </li>
                    </c:forEach>


                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <span style="font-size: 25px;margin-left: 5px">共查询到${userpage.totalCount}条数据 共${userpage.totalPage}页</span>
                </ul>
            </nav>
        </td>
    </tr>
    </TBODY>
</table>
<script></script>
<script src="<%=basePath%>bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</HTML>

