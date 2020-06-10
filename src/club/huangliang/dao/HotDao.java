package club.huangliang.dao;

import club.huangliang.model.blog;
import club.huangliang.model.blog_photo;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class HotDao {
    public int findPageData() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from blog";
        Long query = (long) runner.query(sql, new ScalarHandler());

        int i = query.intValue();

        return i;

    }

    public List<blog> findHotBlog(int index, int rows) throws SQLException {
        //数据查询order by user_createtime
        String sql="select * from blog order by blog_hot desc limit ?,?   " ;//join blog_photo  where blog.blog_id=blog_photo.blogid
        Object[] objects={index,rows};

        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        List<blog> blogs=null;
        try {
            blogs = runner.query(sql, new BeanListHandler<blog>(blog.class),objects );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //查询blog_photo
        String sql1="select * from blog_photo where blogid=?";


        blog_photo p=null;

        //还需要手动封装blog_photo>>>用for循环(后期所有的带图片的博客都这样查询)
        for (int i=0 ;i<blogs.size();i++) {
            Object[] objects1 = {blogs.get(i).getBlog_id()};
            p = runner.query(sql1, new BeanHandler<>(blog_photo.class), objects1);
            if (p == null) {
                continue;
            } else {
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














        return blogs;
    }
}
