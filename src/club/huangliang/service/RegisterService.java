package club.huangliang.service;

import club.huangliang.dao.RegisDao;
import club.huangliang.model.User_da_info;

import java.sql.SQLException;

public class RegisterService {
    public String register(User_da_info user) {
        RegisDao dao = new RegisDao();
        User_da_info _user = new User_da_info();
        //定义显示字符串的信息
        String massage = null;

        try {
            _user = dao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (_user != null) {
            massage = "用户名已经注册";
        } else {
            //插入数据到数据库中
            dao.insert(user);
            massage = "注册成功";
        }

        return massage;
    }
}
