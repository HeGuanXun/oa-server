package com.hgx.common.utils;

/**
 * <p>分页插件</p>
 *
 * @author 何冠勋
 * @since 2020/7/13
 **/
public class Pagination<T> {

    private int total;

    private int pageSize = 10;

    private int currentPage = 10;

    private Object data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
