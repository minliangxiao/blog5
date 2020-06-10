package club.huangliang.servlet;

import club.huangliang.model.blog;
import club.huangliang.service.InsertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/InsertNewBlog")
public class InsertNewBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String blog_id = request.getParameter("blog_id");
        String blog_context = request.getParameter("blog_context");
        String blog_type = request.getParameter("blog_type");
        String blog_titile = request.getParameter("blog_titile");
        String blog_name = request.getParameter("blog_name");

        //进行封装
        blog blog =new blog();
        blog.setBlog_id(blog_id);
        blog.setBlog_name(blog_name);
        blog.setBlog_context(blog_context);
        blog.setBlog_type(blog_type);
        blog.setBlog_titile(blog_titile);
        InsertService service=new InsertService();
        try {
            service.UpdataBlog(blog);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //跳转问题一直都没有解决
        request.getRequestDispatcher("FindMyBlogServlet").forward(request,response);
       // response.getWriter().write("修改成功");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
