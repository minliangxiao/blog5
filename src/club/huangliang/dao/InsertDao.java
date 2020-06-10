package club.huangliang.dao;

import club.huangliang.model.blog;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class InsertDao {
    public void insert(blog blog) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "Update blog set blog_context=?,blog_type=?,blog_titile=?,blog_name=? where blog_id=?";
        Object[] objects = {blog.getBlog_context(), blog.getBlog_type(), blog.getBlog_titile(), blog.getBlog_name(), blog.getBlog_id()};
        int res = runner.update(sql, objects);
        System.out.println(res);
    }
}
