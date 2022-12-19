package com.bjsxt.pojo;

import java.util.List;

public class Tree {


    private  int  id;

    private   String   text;

    private   String state;

    private   String  url;

    //里面保存的是二级菜单
    private List<Tree>  children;

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Tree(int id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public Tree(int id, String text, String state, String url) {
        this.id = id;
        this.text = text;
        this.state = state;
        this.url = url;
    }

    public Tree(int id, String text, String state, String url, List<Tree> children) {
        this.id = id;
        this.text = text;
        this.state = state;
        this.url = url;
        this.children = children;
    }

    public Tree(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
