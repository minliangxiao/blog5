package club.huangliang.servlet;

import club.huangliang.model.PageBean;
import club.huangliang.service.HotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/FindHotServlet")
public class FindHotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");//当前页码
        if (currentPageStr==null){
            currentPageStr="1";
        }
        int currentPage=Integer.parseInt(currentPageStr);
        String rowsStr = request.getParameter("rows");
        if (rowsStr == null) {
            rowsStr="15";
        }
        int rows=Integer.parseInt(rowsStr);
        HotService service=new HotService();
        PageBean page = null;
        try {
            page = service.findHotBlog(rows,currentPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("pages/hotblog.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
