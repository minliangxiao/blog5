package club.huangliang.servlet;

import club.huangliang.model.discuss;
import club.huangliang.service.AdminService;
import club.huangliang.utils.IDUtil;
import club.huangliang.utils.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DiscussWriteServlet")
public class DiscussWriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String discuss_tile = request.getParameter("discuss_tile");
        String discuss_content = request.getParameter("discuss_content");
        String userid = request.getParameter("userid");
        String adminname = request.getParameter("Adminname");
        //
        discuss discuss =new discuss();
        discuss.setAdminid(userid);
        discuss.setDiscuss_content(discuss_content);
        discuss.setDiscuss_title(discuss_tile);
        discuss.setDiscuss_time(TimeUtil.getTime());
        discuss.setDiscussid(IDUtil.getUUID());
        discuss.setIs_delete(1);
        discuss.setAdminname(adminname);

        AdminService service=new AdminService();
        try {
            service.addDiscuss(discuss);
        } catch (SQLException e) {
            e.printStackTrace();
        }

   //跳转到查询页
        request.getRequestDispatcher("FindAllDiscussServlet").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
