package club.huangliang.servlet;

import club.huangliang.model.blog;
import club.huangliang.service.UpdataBlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/UpdataBlogServlet")
public class UpdataBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blog_id = request.getParameter("blog_id");
        UpdataBlogService service =new UpdataBlogService();
        blog blog = null;
        try {
            blog = service.updataBlog(blog_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("blog",blog);
        request.getRequestDispatcher("pages/updatablog.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
