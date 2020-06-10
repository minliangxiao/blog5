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

@WebServlet( "/DelectUserServlet")
public class DelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数

        String userid = request.getParameter("userid");
        DelectService service=new DelectService();
        try {
            service.delectUser(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //跳转页面

        request.getRequestDispatcher("FindAllUserServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
