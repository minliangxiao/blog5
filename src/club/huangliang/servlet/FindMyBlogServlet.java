package club.huangliang.servlet;

import club.huangliang.model.PageBean;
import club.huangliang.model.User_da_info;
import club.huangliang.service.HomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/FindMyBlogServlet")
/*这是用于查看登陆用户发布的所有博客
 * */
public class FindMyBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("user");

        String userid = request.getParameter("userid");

        if (userid == null) {
            User_da_info u = (User_da_info) session.getAttribute("user");
            userid = u.getUserid();

        }


        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr == null) {
            currentPageStr = "1";
        }
        int currentPage = Integer.parseInt(currentPageStr);
        String rowsStr = request.getParameter("rows");
        if (rowsStr == null) {
            rowsStr = "12";
        }
        int rows = Integer.parseInt(rowsStr);
        HomeService service = new HomeService();
        PageBean page = null;
        try {
            page = service.findMyBlogs(rows, currentPage, userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("page", page);
        //页面跳转
        if ("user".equals(user)) {
            request.getRequestDispatcher("pages/showuserblog.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("pages/showmyblog.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
