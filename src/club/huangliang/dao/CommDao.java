package club.huangliang.dao;

import club.huangliang.model.blog_comm;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class CommDao {
    public void insertComm(blog_comm comm) throws SQLException {
        String sql = "insert into blog_comm (commid,blogid,userid,re_content,username,commtime) values(?,?,?,?,?,?) ";
        String _sql = "update blog set blog_renumber=blog_renumber+1 where blog_id=?";
        Object[] _objects = {comm.getBlogid()};
        Object[] objects = {comm.getCommid(), comm.getBlogid(), comm.getUserid(), comm.getRe_content(), comm.getUsername(), comm.getCommtime()};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        runner.update(sql, objects);
        runner.update(_sql, _objects);
    }
}
