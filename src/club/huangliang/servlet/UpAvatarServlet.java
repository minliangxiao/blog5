package club.huangliang.servlet;

import club.huangliang.model.useravatar;
import club.huangliang.service.AvatarService;
import club.huangliang.utils.IDUtil;
import club.huangliang.utils.TimeUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet( "/UpAvatarServlet")
public class UpAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = this.getServletContext().getRealPath("upload");
        String time= TimeUtil.getTime();


        filePath+= File.separator;//File.separator是什么东西？？？File.separator与系统相关的分隔符

        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }


        // 临时文件存放的路径
        String tempPath = this.getServletContext().getRealPath("temp");
        File tempFile = new File(tempPath);
        // 如果临时目录不存在，则创建此目录
        if(!tempFile.exists()) {
            tempFile.mkdirs();
        }


        // 文件工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置缓冲区,如果超过缓冲区大小(50MB)，则会自动生成一个临时文件，存放到临时目录中
        factory.setSizeThreshold(1024 * 1024 * 1);
        // 设置临时目录
        factory.setRepository(tempFile);//以上都不是很懂？？？

        // 获取文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置上传单个文件的最大值10MB
        upload.setFileSizeMax(1024 * 1024 * 500);
        // 所有文件的最大值50MB
        upload.setSizeMax(1024 * 1024 * 5000);

        String savePath = null;
        String userid = null;
        useravatar avatar=new useravatar();

        // 解析请求对象，并得到请求参数
        List<FileItem> fileItem = null;
        try {
            fileItem = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        for (FileItem item : fileItem) {
            // 如果数据不是文件
            if(item.isFormField()) {
                userid = item.getString("utf-8");
                avatar.setUserid(userid);//？？？这个是什么意识？？

            } else {
                // 如果是文件,获取文件名
                String fileName = item.getName();
                // 获取文件类型
                String fileType = fileName.substring(fileName.lastIndexOf("."));
                // 获取文件保存的名称
                savePath = filePath + File.separator + fileName;

                // 获取文件输入流
                InputStream is = item.getInputStream();

                OutputStream os = new FileOutputStream(savePath);//savePath里面存的就是文件地址

                byte[] b = new byte[1024];
                int len = 0;

                // 每次读取1024字节
                while((len = is.read(b)) > -1) {

                    os.write(b, 0, len);
                }

                os.close();
                is.close();
                item.delete();


                avatar.setUseravatar(savePath);
                avatar.setUserid(IDUtil.getUUID());
                AvatarService service=new AvatarService();
                try {
                    service.insertAva(avatar);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }


        }
        //跳转页面

        request.getRequestDispatcher("PolicyListServlet").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
