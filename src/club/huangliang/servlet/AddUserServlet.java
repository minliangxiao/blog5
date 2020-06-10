package club.huangliang.servlet;

import club.huangliang.model.User_da_info;
import club.huangliang.service.RegisterService;
import club.huangliang.utils.IDUtil;
import club.huangliang.utils.Pass;
import club.huangliang.utils.TimeUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet( "/AddUserServlet")
/*
* 添加用户所用的servlet
*
* */
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();
        User_da_info user =new User_da_info();
        //将页面参数进行封装
        try {
            BeanUtils.populate(user,map);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //手动封装一些数据
        String _userpwd = request.getParameter("userpwd");
        String userpwd = Pass.mad5(_userpwd);
        user.setUserpwd(userpwd);
        user.setUserid(IDUtil.getUUID());
        user.setUser_createtime(TimeUtil.getTime());
        user.setUserstatus("1");
        String message =null;
        //传递数据
        RegisterService service=new RegisterService();
        message=service.register(user);
        if ("注册成功".equals(message)) {
            request.setAttribute("message","用户注册成功请登陆");
            request.getRequestDispatcher("/FindAllUserServlet").forward(request,response);//这儿之后再填写跳转页面的地址


        }
        else {
            request.setAttribute("message","用户名已经注册");
            request.getRequestDispatcher("/pages/register.jsp").forward(request,response);//没有写注册失败后的跳转页面

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
