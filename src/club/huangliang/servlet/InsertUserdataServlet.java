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

@WebServlet("/InsertUserdataServlet")
/*
* 这是用于把用户信息修改后重新写入的servlet
* */
public class InsertUserdataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        String userstatus = request.getParameter("userstatus");

        String email = request.getParameter("email");

        String qq = request.getParameter("qq");

        String userid= request.getParameter("userid");
//数据封装
        UserService service=new UserService();
        try {
            service.insertUserdata(email,qq,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String mesage="修改成功";
        request.setAttribute("",mesage);
        //进行跳转
        request.getRequestDispatcher("FindUserDataServlet?userid="+userid+"&&mesage="+mesage).forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
