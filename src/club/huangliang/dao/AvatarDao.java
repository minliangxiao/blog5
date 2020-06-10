package club.huangliang.dao;

import club.huangliang.model.useravatar;
import club.huangliang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AvatarDao {
    public useravatar findAvatar(Object userid) throws SQLException {
        String sql = "select * from useravatar where userid=? ";
        Object[] objects = {userid};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        useravatar avatar = runner.query(sql, new BeanHandler<>(useravatar.class), objects);
        return avatar;
    }

    public void insertAva(useravatar avatar) throws SQLException {
        String sql = "insert useravatar into (id,userid,useravatar) values(?,?,?)";
        Object[] objects = {avatar.getId(), avatar.getUserid(), avatar.getUseravatar()};
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, objects);
    }
}
