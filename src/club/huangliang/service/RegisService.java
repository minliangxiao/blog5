package club.huangliang.service;

import java.sql.SQLException;

import club.huangliang.dao.RegisDao;
import club.huangliang.model.User_da_info;

/*
* 这个好像已经报废了
* */
public class RegisService {

	public String register(User_da_info user) throws SQLException {
		//直接进行数据传递
		RegisDao dao=new RegisDao();
		User_da_info _user =new User_da_info();
		
	     _user=dao.register(user);
		return null;
	}

}
