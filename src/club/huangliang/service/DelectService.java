package club.huangliang.service;

import club.huangliang.dao.DelectDao;

import java.sql.SQLException;

public class DelectService {
    public void delectUser(String userid) throws SQLException {
        DelectDao dao=new DelectDao();
        dao.delectUser(userid);
    }

    public void deleteMyBloge(String blog_id) throws SQLException {
        DelectDao dao =new DelectDao();
        dao.deleteMyBlog(blog_id);
    }
}
