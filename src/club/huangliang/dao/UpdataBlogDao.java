package club.huangliang.dao;

import club.huangliang.model.blog;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UpdataBlogDao {
    public blog updataBlog(String blog_id) throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select *from blog where blog_id=?";

        Object[] objects={blog_id};
        blog blog =runner.query(sql,new BeanHandler<>(blog.class),objects);


        return blog;
    }
}
