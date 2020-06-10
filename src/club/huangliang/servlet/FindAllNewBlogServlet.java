package club.huangliang.servlet;

import club.huangliang.model.PageBean;
import club.huangliang.service.HomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/FindAllNewBlogServlet")
/*
* 这是用于找到所有的最新发布的博客
* 这个servlet除了跳转路径，其他找寻博客的步骤与homeservlet一样
* */
public class FindAllNewBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");//当前页码
        if (currentPageStr==null){
            currentPageStr="1";
        }
        int currentPage=Integer.parseInt(currentPageStr);
        String rowsStr = request.getParameter("rows");
        if (rowsStr == null) {
            rowsStr="5";
        }
        int rows=Integer.parseInt(rowsStr);
        HomeService service=new HomeService();
        PageBean page = null;
        try {
            page = service.findAllBlog(rows,currentPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("page",page);/*后面考虑要不要把这些数据存到session域里面*/
        //
        request.getRequestDispatcher("pages/article.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
