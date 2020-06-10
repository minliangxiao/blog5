package club.huangliang.dao;

import club.huangliang.model.User_da_info;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public User_da_info findUserdata(String userid) throws SQLException {
        String sql="select * from user_ba_info where userid=?";
        Object[] objects={userid};
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());

        User_da_info user=runner.query(sql, new BeanHandler<>(User_da_info.class),objects);
        return user;
    }

    public void InsertUserdata(String email, String qq, String userid) throws SQLException {
        String sql="update  user_ba_info set email=?,qq=? where userid=?";
        Object[] objects={email,qq,userid};
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,objects);

    }

    public String changePWD(String userid, String username, String userpwd) throws SQLException {
        String  sql="update user_ba_info set username=? ,userpwd=? where  userid =?";
        Object[] object={username,userpwd,userid};
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,object);
        return "修改成功";
    }
}
