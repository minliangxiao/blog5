package club.huangliang.servlet;

import club.huangliang.model.PageBean;
import club.huangliang.model.blog;
import club.huangliang.model.blog_photo;
import club.huangliang.model.discuss;
import club.huangliang.service.HomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/HomeServlet")
/*
* 这个是用于主页所有数据查询的servlet
* 未完成：目前就写成这样后期再做修改
* */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先查blog列表最新发布


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


        request.setAttribute("newblogs",page);/*后面考虑要不要把这些数据存到session域里面*/
       //查询公告
        List<discuss> discussList =service.findAllDiscuss();
        request.setAttribute("newdiscusslist",discussList);
        //查询点记排行
        List<blog> tuijian =service.findAllTui();

        request.setAttribute("dianji",tuijian);

        //博客图片查询
       // List<blog_photo> photoList =service.findAllPhoto();

        //头像查询






        request.getRequestDispatcher("/pages/home2.jsp").forward(request,response);/*如果信息存到了session域里面这个就可以用重定向*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
