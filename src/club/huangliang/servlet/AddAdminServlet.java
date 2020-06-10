package club.huangliang.servlet;

import club.huangliang.model.admin_ba_info;
import club.huangliang.service.AdminService;
import club.huangliang.utils.IDUtil;
import club.huangliang.utils.Pass;
import club.huangliang.utils.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String adminpwd = request.getParameter("adminpwd");
        String adminsex = request.getParameter("adminsex");
        //封装数据
        admin_ba_info admin = new admin_ba_info();
        admin.setAdminname(adminname);
        admin.setAdmin_createtime(TimeUtil.getTime());
        admin.setAdminlevel("1");
        //加密密码
        admin.setAdminpwd(Pass.mad5(adminpwd));
        admin.setAdminsex(adminsex);
        admin.setAdminid(IDUtil.getUUID());

        AdminService service = new AdminService();
        try {
            service.addAdmin(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("mesage", "添加成功");
        //跳转页面
        request.getRequestDispatcher("admin/addadmin.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
