package club.huangliang.servlet;

import club.huangliang.dao.AdminDao;
import club.huangliang.model.PageBean;
import club.huangliang.service.DiscussService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/FindAllDiscussServlet")
/*
 * 分页查询公告
 * */
public class FindAllDiscussServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String currentPageStr = request.getParameter("currentPage");//当前页码

        if (currentPageStr == null) {
            currentPageStr = "1";
        }
        int currentPage = Integer.parseInt(currentPageStr);
        String rowsStr = request.getParameter("rows");
        if (rowsStr == null) {
            rowsStr = "18";
        }
        int rows = Integer.parseInt(rowsStr);
        DiscussService service = new DiscussService();
        PageBean page = null;
        try {
            page = service.findDiscuss(rows, currentPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("page", page);
        if ("user".equals(user)) {
            request.getRequestDispatcher("pages/showalldiscuss.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("admin/discusslist.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
