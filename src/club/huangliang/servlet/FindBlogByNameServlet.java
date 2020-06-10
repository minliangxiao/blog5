package club.huangliang.servlet;

import club.huangliang.model.blog;
import club.huangliang.service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet( "/FindBlogByName")
public class FindBlogByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String blog_name= request.getParameter("blog_name");
       //
        BlogService service=new BlogService();
        List<blog> blogList = null;
        try {
            blogList = service.findBlogByName(blog_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("blogList",blogList);
        //页面跳转
        request.getRequestDispatcher("pages/serch.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
