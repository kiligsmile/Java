package com.bjsxt.pojo;

public class SysUser {
	
	
	private  int  userid;
	
	private  String loginname;
	
	private String  identity;
	
	private String  realname;
	
	private String  sex;
	
	private  String  address;
	
	private  String  phone;
	
	private  String  pwd;
	
	private  String  position;
	
	private int  type;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public SysUser(int userid, String loginname, String identity, String realname, String sex, String address,
                   String phone, String pwd, String position, int type) {
		super();
		this.userid = userid;
		this.loginname = loginname;
		this.identity = identity;
		this.realname = realname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.pwd = pwd;
		this.position = position;
		this.type = type;
	}

	public SysUser() {
		super();
	}

	@Override
	public String toString() {
		return "SysUser [userid=" + userid + ", loginname=" + loginname + ", identity=" + identity + ", realname="
				+ realname + ", sex=" + sex + ", address=" + address + ", phone=" + phone + ", pwd=" + pwd
				+ ", position=" + position + ", type=" + type + "]";
	}
	
	

}
