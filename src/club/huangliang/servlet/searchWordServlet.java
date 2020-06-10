package club.huangliang.servlet;

import club.huangliang.service.BlogService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/searchWord")
public class searchWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取关键字
        String word = request.getParameter("word");
        BlogService service=new BlogService();

        List<Object> blogList = null;
        try {
            blogList=service.findBlogByWord(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //json数据封装
//       Gson gson=new Gson();
        //JSONArray fromObject=JSONArray.fromObject(blogList);
        JSONArray fromObject =JSONArray.fromObject(blogList);
        String blog=fromObject.toString();
        //输出到页面
        response.getWriter().write(blog);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
