package club.huangliang.dao;

import club.huangliang.model.User_da_info;
import club.huangliang.model.admin_ba_info;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
/*
* 实现用户登陆的数据库操作
* */
public class LoginDao {
    public List<User_da_info>userLogin(User_da_info user) {
        String sql="select * from user_ba_info where username=? and userpwd=?"    ;
        Object[] objects={user.getUsername(),user.getUserpwd()};
        List<User_da_info> userlist=null;
        //加载数据库
        QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
        //执行数据库查询
        try {
            userlist = runner.query(sql, new BeanListHandler<User_da_info>(User_da_info.class), objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userlist;
    }

    public admin_ba_info adminLogin(admin_ba_info admin) throws SQLException {
        String sql="select * from admin_ba_info where adminname=? and adminpwd=?";
        Object[] objects={admin.getAdminname(),admin.getAdminpwd()};
        admin_ba_info adminBaInfo =new admin_ba_info();
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        adminBaInfo=runner.query(sql,new BeanHandler<>(admin_ba_info.class),objects);
        return adminBaInfo;
    }
}
