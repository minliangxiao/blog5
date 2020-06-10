package club.huangliang.servlet;

import club.huangliang.service.DelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteMyBlogServlet")
public class DeleteMyBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
        String blog_id = request.getParameter("blog_id");
        DelectService service = new DelectService();
        try {
            service.deleteMyBloge(blog_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //页面跳转
        request.getRequestDispatcher("FindMyBlogServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
