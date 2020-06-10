package club.huangliang.servlet;

import club.huangliang.model.User_da_info;
import club.huangliang.model.blog;
import club.huangliang.model.blog_photo;
import club.huangliang.service.BlogService;
import club.huangliang.utils.IDUtil;
import club.huangliang.utils.TimeUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/BlogWriteServlet")
/*
* 这个是用来写博客的servlet
* */
public class BlogWriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        blog blog=new blog();
        HttpSession session =request.getSession();
        User_da_info user= (User_da_info) session.getAttribute("user");

        //首先获取页面参数
      /*  Map<String, String[]> map=new HashMap<String, String[]>();
        map=request.getParameterMap();
        //对获取到的参数进行封装
        try {
            BeanUtils.populate(blog,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //对无法获取的参数进行手动封装（后面再写）
*/

        //进行图片获取和图片操作（）
        //Part part = request.getPart("file");
        String filePath = this.getServletContext().getRealPath("/upload");
        String time= TimeUtil.getTime();
        filePath+=File.separator;//File.separator系统下的分割符+time
        File file=new File(filePath);
        //如果文件夹不存在就创造文件夹
        if (!file.exists() ) {
            file.mkdirs();

        }
        //临时文件存放路径
        String tempPath =this.getServletContext().getRealPath("/temp");
        File tempFile = new File(tempPath);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        //文件工厂对象
        DiskFileItemFactory factory=new DiskFileItemFactory();
        // 设置缓冲区,如果超过缓冲区大小(50MB)，则会自动生成一个临时文件，存放到临时目录中
        factory.setSizeThreshold(1024 * 1024 * 1);
        // 设置临时目录
        factory.setRepository(tempFile);

        // 获取文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024 * 1024 * 500);
        // 所有文件的最大值50MB
        upload.setSizeMax(1024 * 1024 * 5000);
        //定义相关变量，做以后作用
        String savePath = null;
        String title = null;
        //
        blog_photo blog_photo=new blog_photo();
        //解析请求对象，并得到请求参数???不知道这样子写行不行
        List<FileItem> fileItem = null;
        try {
            fileItem = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        blog.setBlog_id(IDUtil.getUUID());
        blog.setBlog_createtime(TimeUtil.getTime());
        blog.setUserid(user.getUserid());
        for (FileItem item : fileItem) {
            // 如果数据不是文件
            if (item.isFormField()) {

                blog.setBlog_titile(fileItem.get(1).getString("utf-8"));
                blog.setBlog_context(fileItem.get(4).getString("utf-8"));
                blog.setBlog_type(fileItem.get(3).getString("utf-8"));
                blog.setBlog_name(fileItem.get(0).getString("utf-8"));//这个后面会在页面上输入*/


//                数据进行传递




            }
            else {
                // 如果是文件,获取文件名
                String fileName=item.getName();
                //获取文件类型???暂时还不知道有什么用
                String fileType=fileName.substring(fileName.lastIndexOf("."));
                //获取文件保存名称
                savePath=filePath+File.separator+fileName;
                //获取文件输入流???暂时也不知道这两个句有什么作用
                InputStream is= item.getInputStream();
                OutputStream os=new FileOutputStream(savePath);
                byte[] b = new byte[1024];
                int len = 0;
                // 每次读取1024字节
                while((len = is.read(b)) > -1) {

                    os.write(b, 0, len);
                }
                os.close();
                is.close();
                item.delete();
                //保存参数
                blog_photo.setPhotoid(IDUtil.getUUID());
                blog_photo.setPhoto_address(savePath);
                blog_photo.setPhoto_time(TimeUtil.getTime());
                blog_photo.setBlogid(blog.getBlog_id());
                //进行数据传递


            }
        }
        //
        BlogService service=new BlogService();
        try {
            service.insertBlog(blog);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //


        try {
            service.insetPhoto(blog_photo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("HomeServlet").forward(request,response);//跳转路径以后再想
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
