package club.huangliang.servlet;

import club.huangliang.model.PageBean;
import club.huangliang.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String currentPageStr = request.getParameter("currentPage");//当前页码
        if (currentPageStr == null) {
            currentPageStr = "1";
        }
        int currentPage = Integer.parseInt(currentPageStr);
        String rowsStr = request.getParameter("rows");
        if (rowsStr == null) {
            rowsStr = "32";
        }
        int rows = Integer.parseInt(rowsStr);
        AdminService service = new AdminService();
        PageBean page = null;
        try {
            page = service.findAllUser(rows, currentPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if ("user".equals(user)) {
            request.setAttribute("page", page);
            request.getRequestDispatcher("pages/showalluser.jsp").forward(request, response);

        } else {
            request.setAttribute("userpage", page);
            //转发页面

            request.getRequestDispatcher("admin/user/list.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
