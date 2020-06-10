package club.huangliang.dao;

import club.huangliang.model.blog;
import club.huangliang.model.discuss;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class DiscussDao {
    public int findPageData() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from discuss";
        Long query = (long) runner.query(sql, new ScalarHandler());

        int i = query.intValue();

        return i;
    }

    public List<discuss> findDiscussBypage(int index, int rows) throws SQLException {
        String sql="select * from discuss order by discuss_time desc limit ?,?   " ;//join blog_photo  where blog.blog_id=blog_photo.blogid
        Object[] objects={index,rows};

        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        List<discuss> discussList=runner.query(sql, new BeanListHandler<>(discuss.class) ,objects);
        return discussList;
    }

    public void deleteDisecuss(String discussid) throws SQLException {
        String sql="delete from discuss where discussid=?  ";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,discussid);
    }

    public discuss findDiscussById(String discussid) throws SQLException {
        String sql="select * from discuss where discussid=?";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        discuss discuss=runner.query(sql, new BeanHandler<>(discuss.class) ,discussid);
        return discuss;
    }

    public void InsertUpDiscuss(String discuss_title, String discuss_content, String discussid) throws SQLException {
        String sql="update discuss set discuss_title=?,discuss_content=? where discussid=? ";
        Object[] objects={discuss_title,discuss_content,discussid};
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,objects);
    }
}
