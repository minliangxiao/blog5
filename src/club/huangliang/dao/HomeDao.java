package club.huangliang.dao;

import club.huangliang.model.blog;
import club.huangliang.model.blog_photo;
import club.huangliang.model.discuss;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class HomeDao {
    public List<blog> findAllBlog(int index, int rows) {
        //数据查询order by user_createtime
        String sql = "select * from blog order by blog_createtime desc limit ?,?   ";//join blog_photo  where blog.blog_id=blog_photo.blogid
        Object[] objects = {index, rows};

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<blog> blogs = null;
        try {
            blogs = runner.query(sql, new BeanListHandler<blog>(blog.class), objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //查询blog_photo
        String sql1 = "select * from blog_photo";
        List<blog_photo> photoList = null;
        try {
            photoList = runner.query(sql1, new BeanListHandler<blog_photo>(blog_photo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //还需要手动封装blog_photo>>>用for循环
        for (int i = 0; i < blogs.size(); i++) {
            for (blog_photo p : photoList) {
                if (p.getBlogid().equals(blogs.get(i).getBlog_id())) {
                    //对地址进行截取
                    String addr = p.getPhoto_address();

                    String address = addr.substring(addr.lastIndexOf("\\") + 1);
//                    p.setPhoto_address(address);
//                    blogs.get(i).setPhotos(address);


                    //  String addr=p.getPhoto_address();
                    //对地址进行截取
                    //String address=addr.substring(addr.lastIndexOf("\\"));
                    blogs.get(i).photos.setBlogid(p.getBlogid());
                    blogs.get(i).photos.setPhoto_desc(p.getPhoto_desc());
                    blogs.get(i).photos.setPhoto_time(p.getPhoto_time());
                    //Object[] objects={address};
                    blogs.get(i).photos.setPhoto_address(address);

                    // blogs.get(i).setAdre(address);
                    blogs.get(i).photos.setPhoto_desc(p.getPhoto_desc());

                }

            }


        }

        // System.out.println(blogs.get(2));
        //System.out.println(photoList.get(0));


        return blogs;
    }

    public List<discuss> findAllDiscuss() {
        String sql = "select * from discuss order by discuss_time desc limit 0,5";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<discuss> discussList = null;
        try {
            discussList = runner.query(sql, new BeanListHandler<discuss>(discuss.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discussList;
    }

    public List<blog> findAllTui() {
        String sql = "select * from blog  order by blog_hot desc limit 0,9";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<blog> tuiList = null;
        try {
            tuiList = runner.query(sql, new BeanListHandler<blog>(blog.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tuiList;
    }

    public int findPageData() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from blog";
        Long query = (long) runner.query(sql, new ScalarHandler());

        int i = query.intValue();

        return i;
    }


}
