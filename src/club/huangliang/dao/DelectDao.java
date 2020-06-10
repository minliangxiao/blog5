package club.huangliang.dao;

import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class DelectDao {
    public void delectUser(String userid) throws SQLException {
        String sql = "Delete from user_ba_info where userid=?";
        Object[] objects = {userid};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, objects);

    }

    public void deleteMyBlog(String blog_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //先删图片
        String sql = "delete from blog_photo where blogid=? ";
        Object[] objects = {blog_id};
        runner.update(sql, objects);


        //再删博文
        String _sql = "delete from blog where blog_id=?";
        runner.update(_sql, objects);
    }
}
