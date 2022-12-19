package com.bjsxt.pojo;

import java.io.Serializable;

public class Account  implements Serializable {


    private   int  id;

    private   String  cno;

    private   String   pwd;

    private   int money;

    public Account(int id, String cno, String pwd, int money) {
        this.id = id;
        this.cno = cno;
        this.pwd = pwd;
        this.money = money;
    }

    public Account(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cno='" + cno + '\'' +
                ", pwd='" + pwd + '\'' +
                ", money=" + money +
                '}';
    }
}
