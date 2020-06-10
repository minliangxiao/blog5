package club.huangliang.dao;

import java.sql.SQLException;

import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import club.huangliang.model.User_da_info;

public class RegisDao {

	public User_da_info register(User_da_info user) throws SQLException {
		//对数据库数据进行查询
		String sql="select * from user_ba_info where username=?";
		Object[] objects = {user.getUsername()};
 		QueryRunner runner =new QueryRunner(DataSourceUtils.getDataSource());
 		//new BeanHandler(User_da_info.class) 这句并没有怎么搞懂
		User_da_info query = (User_da_info) runner.query(sql, new BeanHandler(User_da_info.class), objects);
		return query;
	}

	public void insert(User_da_info user) {
		String sql ="insert into user_ba_info(userid,username,userpwd,qq,email,user_createtime,userstatus )  values (?,?,?,?,?,?,?)";
		Object[] objects={user.getUserid(),user.getUsername(),user.getUserpwd(),user.getQq(),
                user.getEmail(),user.getUser_createtime(),user.getUserstatus()};
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int update = runner.update(sql, objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
