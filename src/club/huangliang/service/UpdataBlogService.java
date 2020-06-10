package club.huangliang.service;

import club.huangliang.dao.UpdataBlogDao;
import club.huangliang.model.blog;

import java.sql.SQLException;

public class UpdataBlogService {
    public blog updataBlog(String blog_id) throws SQLException {
        UpdataBlogDao dao=new UpdataBlogDao();
        blog blog=dao.updataBlog(blog_id);

        return blog;
    }
}
