package club.huangliang.service;

import club.huangliang.dao.UserDao;
import club.huangliang.model.User_da_info;

import java.sql.SQLException;

public class UserService {
    public User_da_info findUserData(String userid) throws SQLException {
        UserDao dao =new UserDao();
        User_da_info user=dao.findUserdata(userid);

        return user;
    }

    public void insertUserdata(String email, String qq, String userid) throws SQLException {
        UserDao dao=new UserDao();
        dao.InsertUserdata(email,qq,userid);
    }

    public String changePWD(String userid, String username, String userpwd) throws SQLException {
        UserDao dao=new UserDao();
        String mesage= dao.changePWD(userid,username,userpwd);

        return mesage;
    }
}
