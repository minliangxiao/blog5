package club.huangliang.service;

import club.huangliang.dao.HomeDao;
import club.huangliang.dao.MyDao;
import club.huangliang.model.PageBean;
import club.huangliang.model.blog;
import club.huangliang.model.blog_photo;
import club.huangliang.model.discuss;

import java.sql.SQLException;
import java.util.List;

public class HomeService {
    HomeDao dao = new HomeDao();

    public PageBean findAllBlog(int rows, int currentPage) throws SQLException {
        //接到往dao层传递
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(rows);
        //获取总共的数据条数
        int totalCount = dao.findPageData();
        pageBean.setTotalCount(totalCount);
        //计算总页数
        int totalPage = (int) Math.ceil(1.0 * totalCount / rows);
        pageBean.setTotalPage(totalPage);
        //计算设置索引index
        int index = (currentPage - 1) * rows;


        List<blog> blogs = dao.findAllBlog(index, rows);
        pageBean.setDatalist(blogs);
        return pageBean;
    }

    public List<discuss> findAllDiscuss() {
        List<discuss> discussList = dao.findAllDiscuss();
        return discussList;
    }

    public List<blog> findAllTui() {
        List<blog> blogs = dao.findAllTui();
        return blogs;
    }

    public List<blog_photo> findAllPhoto() {
        //List<blog_photo> photoList=dao.findAllPhotos();
        return null;
    }

    public PageBean findMyBlogs(int rows, int currentPage, String userid) throws SQLException {
        MyDao dao = new MyDao();
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(rows);
        //获取总共的数据条数

        int totalCount = dao.findMyBlog(userid);
        pageBean.setTotalCount(totalCount);
        //计算总页数
        int totalPage = (int) Math.ceil(1.0 * totalCount / rows);
        pageBean.setTotalPage(totalPage);
        //计算设置索引index
        int index = (currentPage - 1) * rows;


        List<blog> blogs = dao.findMyBlog(index, rows, userid);
        pageBean.setDatalist(blogs);
        return pageBean;


    }
}
