package club.huangliang.service;

import club.huangliang.dao.InsertDao;
import club.huangliang.model.blog;

import java.sql.SQLException;

public class InsertService {
    public void UpdataBlog(blog blog) throws SQLException {
        InsertDao dao =new InsertDao();
        dao.insert(blog);
    }
}
