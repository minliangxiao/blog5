package club.huangliang.servlet;

import club.huangliang.service.DiscussService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/IsertUpDiscussServlet")
public class IsertUpDiscussServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String discuss_title = request.getParameter("discuss_title");
        String discuss_content = request.getParameter("discuss_content");
        String discussid = request.getParameter("discussid");
        DiscussService service = new DiscussService();
        try {
            service.inserUpDiscuss(discuss_title, discuss_content, discussid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("FindAllDiscussServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
