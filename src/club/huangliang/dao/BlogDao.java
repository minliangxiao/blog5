package club.huangliang.dao;

import club.huangliang.model.blog;
import club.huangliang.model.blog_photo;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class BlogDao {
    public void insertPhoto(blog_photo blog_photo) throws SQLException {
        String sql = "insert into blog_photo(Photoid,photo_address,Photo_time,Blogid) values(?,?,?,?)";
        Object[] objects = {blog_photo.getPhotoid(), blog_photo.getPhoto_address(), blog_photo.getPhoto_time(), blog_photo.getBlogid()};

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, objects);
    }

    public void insertBlog(blog blog) throws SQLException {

        String sql = "insert into blog(Blog_titile,Blog_context,Blog_type,Blog_name,Blog_id,Blog_createtime,Userid) values(?,?,?,?,?,?,?)";
        Object[] objects = {blog.getBlog_titile(), blog.getBlog_context(), blog.getBlog_type(), blog.getBlog_name(), blog.getBlog_id(),
                blog.getBlog_createtime(), blog.getUserid()};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, objects);
    }

    public blog findBlog(String blog_id, String user) throws SQLException {
        String sql = "select * from blog where blog_id=?";
        String _sql = "update blog set blog_hot=blog_hot+1 where blog_id=?";
        Object[] objects = {blog_id};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        blog blog = runner.query(sql, new BeanHandler<blog>(blog.class), objects);
        if (user != null) {
            try {
                runner.update(_sql, objects);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return blog;
    }

    public List<blog_photo> findPhotos(String blog_id) throws SQLException {
        String sql = "select* from blog_photo where blogid=?";
        Object[] objects = {blog_id};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<blog_photo> photoList = runner.query(sql, new BeanListHandler<>(blog_photo.class), objects);
        return photoList;
    }

    public List<Object> findBlogByWord(String word) throws SQLException {
        String sql = "select * from blog where blog_titile like ? limit 0,8";
        List<Object> objectList = null;
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        objectList = runner.query(sql, new ColumnListHandler("blog_titile"), "%" + word + "%");
        return objectList;
    }

    public List<blog> finBlogByname(String blog_name) throws SQLException {
        String sql = "select * from blog where blog_titile =?";
        String _sql = "select * from blog_photo where blogid=?";
        Object[] objects = {blog_name};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<blog> blogList = runner.query(sql, new BeanListHandler<>(blog.class), objects);
        for (int i = 0; i < blogList.size(); i++) {
            String blog_id = blogList.get(i).getBlog_id();
            blog_photo photo = runner.query(_sql, new BeanHandler<>(blog_photo.class), blog_id);
            //封装照片
            blogList.get(i).photos.setBlogid(photo.getBlogid());
            blogList.get(i).photos.setPhoto_time(photo.getPhoto_time());
            blogList.get(i).photos.setPhoto_desc(photo.getPhoto_desc());
            //对地址进行截取
            String addrStr = photo.getPhoto_address();
            String address = addrStr.substring(addrStr.lastIndexOf("\\") + 1);
            blogList.get(i).photos.setPhoto_address(address);


        }


        return blogList;
    }
}
