package club.huangliang.service;

import club.huangliang.dao.BlogDao;
import club.huangliang.dao.CommentDao;
import club.huangliang.model.blog;
import club.huangliang.model.blog_comm;
import club.huangliang.model.blog_photo;
import club.huangliang.model.discuss;

import java.sql.SQLException;
import java.util.List;

public class BlogService {

    public void insetPhoto(blog_photo blog_photo) throws SQLException {
        BlogDao dao =new BlogDao();
        //再进行数据传递

        dao.insertPhoto(blog_photo);
    }

    public void insertBlog(blog blog) throws SQLException {
        BlogDao dao =new BlogDao();

        dao.insertBlog(blog);

    }

    public blog findBlog( String blog_id,String user) throws SQLException {
        BlogDao dao=new BlogDao();
      blog blogs=dao.findBlog(blog_id,user);
      String id=blogs.getBlog_id();


         return blogs;
    }

    public List<blog_photo> findBlogPhtoto(String blog_id) throws SQLException {

        BlogDao dao =new BlogDao();
        List<blog_photo> photoList=dao.findPhotos(blog_id);
        //将地址进行截取
        for (int i = 0; i <photoList.size() ; i++) {
            String photo_address = photoList.get(i).getPhoto_address();
            //进行地址截取
            String substring = photo_address.substring(photo_address.lastIndexOf("\\") + 1);
            //覆盖原有值
            photoList.get(i).setPhoto_address(substring);


        }

        return  photoList;
    }

    public List<blog_comm> findComm(String blog_id) throws SQLException {
        CommentDao dao=new CommentDao();
        List<blog_comm> commList=dao.findComm(blog_id);

        return commList;
    }

    public List<Object> findBlogByWord(String word) throws SQLException {
        List<Object> objectList=null;
        BlogDao dao=new BlogDao();
        objectList=dao.findBlogByWord(word);
        return objectList;
    }

    public List<blog> findBlogByName(String blog_name) throws SQLException {
        BlogDao dao=new BlogDao();
        List<blog> blogList=dao.finBlogByname(blog_name);

        return blogList;
    }
}
