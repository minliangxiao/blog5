package club.huangliang.service;

import club.huangliang.dao.HotDao;
import club.huangliang.model.PageBean;
import club.huangliang.model.blog;

import java.sql.SQLException;
import java.util.List;

public class HotService {
    public PageBean findHotBlog(int rows, int currentPage) throws SQLException {
        HotDao dao=new HotDao();

        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(rows);
        int totalCount=dao.findPageData();
        pageBean.setTotalCount(totalCount);
        //计算总页数
        int totalPage = (int) Math.ceil(1.0*totalCount/rows);
        pageBean.setTotalPage(totalPage);
        //计算设置索引index
        int index=(currentPage-1)*rows;

        List<blog> blogs=dao.findHotBlog(index,rows);
        pageBean.setDatalist(blogs);
        return pageBean;

    }
}
