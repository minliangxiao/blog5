package club.huangliang.service;

import club.huangliang.dao.AvatarDao;
import club.huangliang.model.useravatar;

import java.sql.SQLException;

public class AvatarService {
    public void insertAva(useravatar avatar) throws SQLException {
        AvatarDao dao = new AvatarDao();
        dao.insertAva(avatar);

    }
}
