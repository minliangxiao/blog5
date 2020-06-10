package club.huangliang.service;

import club.huangliang.dao.CommDao;
import club.huangliang.model.blog_comm;

import java.sql.SQLException;

public class CommService {
    public void insertComm(blog_comm comm) throws SQLException {
        CommDao dao =new CommDao();
        dao.insertComm(comm);
    }
}
