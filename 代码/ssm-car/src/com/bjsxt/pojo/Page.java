package com.bjsxt.pojo;

import java.util.List;

public class Page<T> {

    private List<T>  rows;

    private  long total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Page(List<T> rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
