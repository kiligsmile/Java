package com.bjsxt.pojo;

import java.io.Serializable;

public class SysMenus implements Serializable {


    private   int  id;

    private   int  pid;

    private   String   name;

    private   String   url;

    private   int open;

    public SysMenus(int id, int pid, String name, String url, int open) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.url = url;
        this.open = open;
    }
    public SysMenus(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "SysMenus{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", open=" + open +
                '}';
    }
}
