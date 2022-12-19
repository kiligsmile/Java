package com.bjsxt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SysLogLogin {

    private  Integer  id;

    private  String   loginname;

    private   String  loginip;

    private Date logintime;

    public SysLogLogin(Integer id, String loginname, String loginid, Date logintime) {
        this.id = id;
        this.loginname = loginname;
        this.loginip = loginid;
        this.logintime = logintime;
    }

    public SysLogLogin(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}
