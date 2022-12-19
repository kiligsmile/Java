package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;

public class Leave  implements Serializable{

    private    int  id;

    private   String   name;

    private Date   time;

    private   String   reason;

    public Leave(int id, String name, Date time, String reason) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.reason = reason;
    }

    public Leave(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", reason='" + reason + '\'' +
                '}';
    }
}
