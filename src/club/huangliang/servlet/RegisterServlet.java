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

/*
明天在来写吧！！今天太累了！！不过终于学会了这个编辑器还是很不错！！这个编辑器还是很先进的
这个时用于注册的servlet
这个注解真的是搞得劳资想锤人
 */
@WebServlet( "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkCode_client = request.getParameter("checkCode");
        String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
        if(!checkCode_session.equals(checkCode_client) ){
            request.setAttribute("message", "您的验证码不正确");
            request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
            return;
        }
        //获取页面参数
        Map<String, String[]> map = request.getParameterMap();
        User_da_info user =new User_da_info();
        String userpwd = request.getParameter("userpwd");
        //将页面参数进行封装
        try {
            BeanUtils.populate(user,map);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //手动封装一些数据
        user.setUserpwd(Pass.mad5(userpwd));
        user.setUserid(IDUtil.getUUID());
        user.setUser_createtime(TimeUtil.getTime());
        user.setUserstatus("1");
        String message =null;
        //传递数据
        RegisterService service=new RegisterService();
        message=service.register(user);
        if ("注册成功".equals(message)) {
            request.setAttribute("message","用户注册成功请登陆");
            request.getRequestDispatcher("/index.jsp").forward(request,response);//这儿之后再填写跳转页面的地址


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
