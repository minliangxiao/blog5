package club.huangliang.servlet;

import club.huangliang.model.blog_comm;
import club.huangliang.service.CommService;
import club.huangliang.utils.IDUtil;
import club.huangliang.utils.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/InsertCommServlet")
/*
* 用于存储评论的servlet
* */
public class InsertCommServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面参数
        String re_content = request.getParameter("re_content");
        String username = request.getParameter("username");
        String userid = request.getParameter("userid");
        String blogid = request.getParameter("blogid");
        System.out.println(blogid);

        //j进行封装
        blog_comm comm=new  blog_comm();
        comm.setBlogid(blogid);
        comm.setCommid(IDUtil.getUUID());
        comm.setCommtime(TimeUtil.getTime());
        comm.setRe_content(re_content);
        comm.setUserid(userid);
        comm.setUsername(username);
        //传递数据
        CommService service =new CommService();
        try {
            service.insertComm(comm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //页面跳转
        request.getRequestDispatcher("showBlogServlet?blog_id="+blogid).forward(request,response);








    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
