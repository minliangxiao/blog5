package club.huangliang.servlet;

import club.huangliang.service.UserService;
import club.huangliang.utils.Pass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/ChangePWDServlet")
public class ChangePWDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String _userpwd = request.getParameter("userpwd");
        String userpwd= Pass.mad5(_userpwd);
        String userid = request.getParameter("userid");
        UserService service=new UserService();
        String mesage=null;
        try {
            mesage=service.changePWD(userid,username,userpwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("mesage",mesage);
        request.getRequestDispatcher("pages/changepwd.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
