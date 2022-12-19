package com.bjsxt.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private   Integer  uid;

    private   String   uname;

    private  String  pwd;


    private   Integer  score;

    private   String  filename;

    private   String  fileType;


    public User(Integer uid, String uname, String pwd, Integer score, String filename, String fileType) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.score = score;
        this.filename = filename;
        this.fileType = fileType;
    }
    public User(){}

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", score=" + score +
                ", filename='" + filename + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
