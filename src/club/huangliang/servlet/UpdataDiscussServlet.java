package club.huangliang.servlet;

import club.huangliang.model.discuss;
import club.huangliang.service.DiscussService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdataDiscussServlet")
public class UpdataDiscussServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String discussid = request.getParameter("discussid");
        String user = request.getParameter("user");
        DiscussService service = new DiscussService();
        discuss discuss = null;
        try {
            discuss = service.findDiscussById(discussid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("discuss", discuss);
        if ("user".equals(user)) {
            request.getRequestDispatcher("pages/discuss.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("admin/updiscuss.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
