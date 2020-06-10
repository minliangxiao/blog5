package club.huangliang.service;

import club.huangliang.dao.DiscussDao;
import club.huangliang.model.PageBean;
import club.huangliang.model.discuss;

import java.sql.SQLException;
import java.util.List;

public class DiscussService {
    public PageBean findDiscuss(int rows, int currentPage) throws SQLException {
        DiscussDao dao=new DiscussDao();
        PageBean page=new PageBean();

        page.setCurrentPage(currentPage);
        page.setRow(rows);
        int totalCount=dao.findPageData();
        page.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil(1.0*totalCount/rows);
        page.setTotalPage(totalPage);
        int index=(currentPage-1)*rows;

        List<discuss> discussList=dao.findDiscussBypage(index,rows);
        page.setDatalist(discussList);
        return page;
    }

    public void deleteDiscuss(String discussid) throws SQLException {
        DiscussDao dao=new DiscussDao();
        dao.deleteDisecuss(discussid);
    }

    public discuss findDiscussById(String discussid) throws SQLException {
        DiscussDao dao= new  DiscussDao();
        discuss discuss=dao.findDiscussById(discussid);

        return discuss;
    }


    public void inserUpDiscuss(String discuss_title, String discuss_content, String discussid) throws SQLException {
        DiscussDao dao= new DiscussDao();
        dao.InsertUpDiscuss(discuss_title,discuss_content,discussid);
    }
}
