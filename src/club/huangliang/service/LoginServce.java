package club.huangliang.service;

import club.huangliang.dao.AvatarDao;
import club.huangliang.dao.LoginDao;
import club.huangliang.model.User_da_info;
import club.huangliang.model.admin_ba_info;
import club.huangliang.model.useravatar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginServce {
    public Map<String,Object> userLogin(User_da_info user) {
        //定义一些必须的变量
        String message=null;
        List<User_da_info> _user=new ArrayList<User_da_info>();
        Map<String,Object> map=new HashMap<String, Object>();

        //向dao层传递
        LoginDao dao=new LoginDao();
        _user=dao.userLogin(user);
        if (_user!=null&&_user.size()>0) {
            map.put("user",_user.get(0));
            map.put("userid",_user.get(0).getUserid());
        }
        else {
            map.put("message","你还没有注册请先进行注册");

        }
        return map;
    }

    public Map<String, Object> adminLogin(admin_ba_info admin) throws SQLException {
        String message=null;
        Map<String,Object> map=new HashMap<String, Object>();
        admin_ba_info _admin =new admin_ba_info();
        LoginDao dao=new LoginDao();
        _admin =dao.adminLogin(admin);
        if (_admin==null&&_admin.getAdminname()==null){

            map.put("message","你还没有注册请先进行注册");
        }
        else {
            map.put("admin",_admin);
        }

        return map;
    }

    public useravatar findAvatar(Object userid) throws SQLException {
        AvatarDao dao =new AvatarDao();
        useravatar avatar=dao.findAvatar(userid);

        //字符串截取
        String userava=null;
        if (avatar.getUseravatar() != null) {

            String useravaStr=avatar.getUseravatar();
            userava=useravaStr.substring(useravaStr.lastIndexOf("\\"));
        }

        avatar.setUseravatar(userava);

        return avatar;
    }

}
