package com.bjsxt.pojo;

public class SysRoles {

    private   int  roleid;

    private   String rolename;

    private   String  roledesc;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public SysRoles(int roleid, String rolename, String roledesc) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roledesc = roledesc;
    }

    public SysRoles(){}

    @Override
    public String toString() {
        return "SysRoles{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roledesc='" + roledesc + '\'' +
                '}';
    }
}
