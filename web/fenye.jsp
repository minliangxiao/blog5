<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>

        <c:forEach begin="1" end="${newblogs.totalPage}" var="i">
            <li><a href="${pageContext.request.contextPath}/HomeServlet?currentPage=${i}">${i}</a></li>
        </c:forEach>

        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
        <span style="font-size: 25px;margin-left: 5px">共查询到${newblogs.totalCount}条数据 共${newblogs.totalPage}页</span>
    </ul>
</nav>