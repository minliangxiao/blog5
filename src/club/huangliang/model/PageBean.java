package club.huangliang.model;

import java.util.ArrayList;
import java.util.List;

/*
 * 分页所用实体
 * */
public class PageBean<T> {
    //当前页数
    private int currentPage;
    //当前页显示的条数
    private int row;
    //总条数
    private int totalCount;
    //总页数
    private int totalPage;
    //每页显示的数据
    private List<T> datalist = new ArrayList<T>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }
}
