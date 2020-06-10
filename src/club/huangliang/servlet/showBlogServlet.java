package club.huangliang.servlet;

import club.huangliang.model.blog;
import club.huangliang.model.blog_comm;
import club.huangliang.model.blog_photo;
import club.huangliang.model.discuss;
import club.huangliang.service.BlogService;
import club.huangliang.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet( "/showBlogServlet")
/*
* 用于展示单个博客的servlet
* */
public class showBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String blog_id=request.getParameter("blog_id");
        String user = request.getParameter("user");
        BlogService service =new BlogService();
        blog aBlog=new blog();
        try {
            aBlog=service.findBlog(blog_id,user);


        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("aBlog",aBlog);
        request.setAttribute("blog_id",blog_id);
        //对博客照片进行获取
        List<blog_photo> photoList= null;
        try {
            photoList = service.findBlogPhtoto(blog_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //对评论数据进行查询
//        CommentService service1=new CommentService();
        List<blog_comm> commList =null;
        try {
             commList =service.findComm(blog_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //将评论存进request 域
        request.setAttribute("commList",commList);
        request.setAttribute("photos",photoList);
        //进行页面跳转
        request.getRequestDispatcher("pages/article_detail.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
