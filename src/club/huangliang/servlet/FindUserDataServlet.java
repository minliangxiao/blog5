package club.huangliang.servlet;

import club.huangliang.model.User_da_info;
import club.huangliang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/FindUserDataServlet")
public class FindUserDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String mesage = request.getParameter("mesage");
        UserService service=new UserService();
        User_da_info user= null;
        try {
            user = service.findUserData(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("userdata",user);
        request.setAttribute("mesage",mesage);

        request.getRequestDispatcher("pages/userdata.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
