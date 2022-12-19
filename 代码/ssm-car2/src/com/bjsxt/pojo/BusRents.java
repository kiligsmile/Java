package com.bjsxt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/***
 * 出租单实体类
 * @author Administrator
 *
 * @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
 *
 */
public class BusRents {
	private String rentid;
	private Double price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date begindate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returndate;
	private Boolean rentflag; //  归还状态  如果是1 --已经归还  0--没由归还
	private String identity;
	private String carnumber;
	private String opername;
	public String getRentid() {
		return rentid;
	}
	public void setRentid(String rentid) {
		this.rentid = rentid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getBegindate() {
		return begindate;
	}


	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	public Boolean getRentflag() {
		return rentflag;
	}
	public void setRentflag(Boolean rentflag) {
		this.rentflag = rentflag;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getOpername() {
		return opername;
	}
	public void setOpername(String opername) {
		this.opername = opername;
	}


	@Override
	public String toString() {
		return "BusRents{" +
				"rentid='" + rentid + '\'' +
				", price=" + price +
				", begindate=" + begindate +
				", returndate=" + returndate +
				", rentflag=" + rentflag +
				", identity='" + identity + '\'' +
				", carnumber='" + carnumber + '\'' +
				", opername='" + opername + '\'' +
				'}';
	}
}
