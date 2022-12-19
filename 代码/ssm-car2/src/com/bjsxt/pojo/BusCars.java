package com.bjsxt.pojo;
/***
 * 车辆信息的实体类
 * @author Administrator
 *
 */
public class BusCars {

	 
	private String carnumber; //车牌号
	private String cartype;   //车辆类型
	private String color;  //颜色
	private Double price;  //价格
	private Double rentprice; //租金
	private Double deposit; //押金
	private Boolean isrenting; //是否出租   1--可以出租   0--不可出租
	private String description; //描述
	private String carimg; //图片
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRentprice() {
		return rentprice;
	}
	public void setRentprice(Double rentprice) {
		this.rentprice = rentprice;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Boolean getIsrenting() {
		return isrenting;
	}
	public void setIsrenting(Boolean isrenting) {
		this.isrenting = isrenting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCarimg() {
		return carimg;
	}
	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}
	
	

}
