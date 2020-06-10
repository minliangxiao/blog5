package club.huangliang.service;

import club.huangliang.dao.AdminDao;
import club.huangliang.model.PageBean;
import club.huangliang.model.User_da_info;
import club.huangliang.model.admin_ba_info;
import club.huangliang.model.discuss;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    public PageBean findAllUser(int rows, int currentPage) throws SQLException {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(rows);
        AdminDao dao=new AdminDao();
        int totalCount=dao.findPageData();
        pageBean.setTotalCount(totalCount);
        //计算总页数
        int totalPage = (int) Math.ceil(1.0*totalCount/rows);
        pageBean.setTotalPage(totalPage);
        //计算设置索引index
        int index=(currentPage-1)*rows;

        List<User_da_info> userList =dao.findPageUser(index,rows);
        pageBean.setDatalist(userList);



        return pageBean;
    }

    public void addAdmin(admin_ba_info admin) throws SQLException {
        AdminDao dao=new AdminDao();
        dao.addAdmin(admin);

    }

    public List<admin_ba_info> findAllAdmin() throws SQLException {
        AdminDao dao=new AdminDao();
        List<admin_ba_info> adminList=dao.findAllAdmin();
        return adminList;
    }

    public void deletAmin(String adminid) throws SQLException {
     AdminDao dao=new AdminDao();
     dao.deletAdmin(adminid);
    }

    public void addDiscuss(discuss discuss) throws SQLException {
        AdminDao dao=new AdminDao();
        dao.addDiscuss(discuss);
    }
}
