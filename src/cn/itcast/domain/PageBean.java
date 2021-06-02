package cn.itcast.domain;

import java.util.List;

public class PageBean<T> {
    private int tatalCount;//总记录数
    private int totalPage;//总页码
    private List<T> list;//每页的数据
    private int currentPage;//当前页码
    private int rows;//每页显示的记录数


    public int getTatalCount() {
        return tatalCount;
    }

    public void setTatalCount(int tatalCount) {
        this.tatalCount = tatalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "tatalCount=" + tatalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
