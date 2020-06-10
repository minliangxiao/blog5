package club.huangliang.dao;

import club.huangliang.model.User_da_info;
import club.huangliang.model.admin_ba_info;
import club.huangliang.model.discuss;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDao {
    public int findPageData() throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user_ba_info";
        Long query = (long) runner.query(sql, new ScalarHandler());

        int i = query.intValue();

        return i;
    }

    public List<User_da_info> findPageUser(int index, int rows) throws SQLException {
        String sql="select * from user_ba_info  limit ?,?";//join blog_photo  where blog.blog_id=blog_photo.blogid
        Object[] objects={index,rows};

        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        List<User_da_info> userList=runner.query(sql,new BeanListHandler<>(User_da_info.class),objects);
        return userList;
    }

    public void addAdmin(admin_ba_info admin) throws SQLException {
        String sql="insert into admin_ba_info values(?,?,?,?,?,?) ";
        Object[] objects={admin.getAdminid(),admin.getAdminname(),
                admin.getAdminpwd(),admin.getAdminsex(),admin.getAdminlevel(),admin.getAdmin_createtime()};
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,objects);
    }

    public List<admin_ba_info> findAllAdmin() throws SQLException {
        String  sql="select * from admin_ba_info";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        List<admin_ba_info> adminList=runner.query(sql, new BeanListHandler<>(admin_ba_info.class));
        return adminList;
    }

    public void deletAdmin(String adminid) throws SQLException {
        String sql="delete  from admin_ba_info where adminid=?";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,adminid);
    }

    public void addDiscuss(discuss discuss) throws SQLException {
        String sql="insert into discuss values(?,?,?,?,?,?,?)";
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        Object[] objects={discuss.getDiscussid(),discuss.getDiscuss_title(),discuss.getDiscuss_content(),
                discuss.getDiscuss_time(),discuss.getAdminid(),discuss.getIs_delete(),discuss.getAdminname()};
        runner.update(sql,objects);
    }
}
