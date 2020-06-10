package club.huangliang.servlet;

import club.huangliang.model.admin_ba_info;
import club.huangliang.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/FindAllAdmin")
public class FindAllAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService service = new AdminService();
        List<admin_ba_info> adminList = null;
        try {
            adminList = service.findAllAdmin();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("admins", adminList);
        request.getRequestDispatcher("admin/adminlist.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
