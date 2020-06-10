package club.huangliang.servlet;

import club.huangliang.utils.IDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/UploadServlet")
/*
 * 这是用于文件上传的servlet
 *
 * 未完成:这个功能还没有测试还不知道怎么用
 * */
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("uploadFile");
        String inputName = part.getName();
        InputStream input = part.getInputStream();
        //想要保存的目标文件的目录下
        String tagDir = getServletContext().getRealPath("/upload");
        //避免文件名重复使用uuid来避免,产生一个随机的uuid字符
        String realFileName = IDUtil.getUUID();
        OutputStream output = new FileOutputStream(new File(tagDir, realFileName));
        int len = 0;
        byte[] buff = new byte[1024 * 8];

        while ((len = input.read(buff)) > -1) {
            output.write(buff, 0, len);
        }

        input.close();
        output.close();
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("upload success!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
