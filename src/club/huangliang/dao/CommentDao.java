package club.huangliang.dao;

import club.huangliang.model.blog_comm;
import club.huangliang.model.discuss;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentDao {
    public List<blog_comm> findComm(String blog_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from  blog_comm  where blogid=? order by commtime desc ";
        Object[] objects = {blog_id};
        List<blog_comm> commList = runner.query(sql, new BeanListHandler<>(blog_comm.class), objects);
        return commList;
    }
}
