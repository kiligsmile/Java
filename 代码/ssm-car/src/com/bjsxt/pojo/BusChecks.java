package com.bjsxt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/***
 * 检查单对应的pojo类
 * @author Administrator
 *
 */
public class BusChecks {
	
	
	private String checkid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkdate;

	private String checkdesc;
	private String problem;
	private Double paymoney;
	private String opername;
	private String rentid;
	public String getCheckid() {
		return checkid;
	}
	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	public String getCheckdesc() {
		return checkdesc;
	}
	public void setCheckdesc(String checkdesc) {
		this.checkdesc = checkdesc;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Double getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}
	public String getOpername() {
		return opername;
	}
	public void setOpername(String opername) {
		this.opername = opername;
	}
	public String getRentid() {
		return rentid;
	}
	public void setRentid(String rentid) {
		this.rentid = rentid;
	}


 
	

}
