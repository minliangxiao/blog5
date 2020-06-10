package club.huangliang.servlet;

import club.huangliang.model.User_da_info;
import club.huangliang.model.admin_ba_info;
import club.huangliang.model.useravatar;
import club.huangliang.service.LoginServce;
import club.huangliang.utils.Pass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/LonginServlet")
/*
* 这是用来写登陆模块的servlet
* 未完成：1.管理员登陆模块
*         2.未有完成不可以往页面上跳转
* */
public class LonginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //页面获取参数
        //Map<String, String[]> parameterMap = request.getParameterMap();

        String checkCode_client = request.getParameter("checkCode");
        //获得生成图片的文字的验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
        //比对页面的和生成图片的文字的验证码是否一致
        if(!checkCode_session.equals(checkCode_client) ){//||(checkCode_client==null)
            request.setAttribute("message", "您的验证码不正确");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        String identity=request.getParameter("identity");
        String username=request.getParameter("username");
        String _userpwd=request.getParameter("userpwd");
        String userpwd=Pass.mad5(_userpwd);
        //数据封装
        User_da_info user=new User_da_info(username,userpwd);
        User_da_info user1=new User_da_info(username,userpwd);

        admin_ba_info admin =new admin_ba_info(username,userpwd );
        //定义需要的变量
        Map<String,Object>  map=new HashMap<String,Object>();
        HttpSession session =request.getSession();
        if ("用户登录" .equals(identity)) {
            //向用户登陆的层传递
            LoginServce servce =new LoginServce();
            map=servce.userLogin(user);
            if ("你还没有注册请先进行注册".equals(map.get("message"))) {
                    request.setAttribute("message","你还没有注册请先注册");
                    request.getRequestDispatcher("index.jsp").forward(request,response);//这个路径好像有问题

            }
            else {
                session.setAttribute("user", map.get("user"));//这样子写好像有问题》》一会看下jsp好不好取ssion里面的值
                //查询头像
//                useravatar avatar=null;
//                try {
//                     avatar=servce.findAvatar(map.get("userid"));
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                session.setAttribute("avatar",avatar);

                //request.getRequestDispatcher("").forward();
               //response.sendRedirect(request.getContextPath()+"/pages/home2.jsp");//这儿因该写一个跳转到查询页面所有信息的servlet
               response.sendRedirect(request.getContextPath()+"/HomeServlet");

            }

        }else{
            //管理员登陆
            LoginServce servce=new LoginServce();
            try {
                map=servce.adminLogin(admin);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if ("你还没有注册请先进行注册".equals(map.get("message"))) {
                request.setAttribute("message","你还没有注册请先注册");
                request.getRequestDispatcher("index.jsp").forward(request,response);//这个路径好像有问题

            }
            else {
                session.setAttribute("admin", map.get("admin"));//这样子写好像有问题》》一会看下jsp好不好取ssion里面的值
                //request.getRequestDispatcher("").forward();
                //response.sendRedirect(request.getContextPath()+"/pages/home2.jsp");//这儿因该写一个跳转到查询页面所有信息的servlet
//                response.sendRedirect(request.getContextPath()+"/HomeServlet");
                //往管理员页面主页跳转
                response.sendRedirect("admin/home.jsp");


            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
