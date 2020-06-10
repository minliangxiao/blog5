package club.huangliang.servlet;

import club.huangliang.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DelectAdminServlet")
public class DelectAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminid = request.getParameter("adminid");
        AdminService service=new AdminService();
        try {
            service.deletAmin(adminid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("FindAllAdmin").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
