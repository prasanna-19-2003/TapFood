package com.tapfood.model;

public class restaurent {
private int	restaurentId ;
private String	resName ;
private String cusineType; 
private int 	deliverytime ;
private String 	address ; 
private int 	adminId ;
private double  ratings; 
private String isActive  ;
private String imagepathe;

public restaurent() {
	super();
}
public restaurent(String resName,int deliverytime, String cusineType,  String address, double ratings, 
		int adminId,String isActive, String imagepathe) {
	super();
	this.resName = resName;
	this.cusineType = cusineType;
	this.deliverytime = deliverytime;
	this.address = address;
	this.adminId = adminId;
	this.ratings = ratings;
	this.isActive = isActive;
	this.imagepathe = imagepathe;
}
public restaurent(int restaurentId, String resName, int deliverytime,String cusineType,  String address, 
		double ratings, String isActive, int adminId,String imagepathe) {
	super();
	this.restaurentId = restaurentId;
	this.resName = resName;
	this.cusineType = cusineType;
	this.deliverytime = deliverytime;
	this.address = address;
	this.adminId = adminId;
	this.ratings = ratings;
	this.isActive = isActive;
	this.imagepathe = imagepathe;
}




public int getRestaurentId() {
	return restaurentId;
}

public void setRestaurentId(int restaurentId) {
	this.restaurentId = restaurentId;
}

public String getResName() {
	return resName;
}

public void setResName(String resName) {
	this.resName = resName;
}

public String getCusineType() {
	return cusineType;
}

public void setCusineType(String cusineType) {
	this.cusineType = cusineType;
}

public int getDeliverytime() {
	return deliverytime;
}

public void setDeliverytime(int deliverytime) {
	this.deliverytime = deliverytime;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getAdminId() {
	return adminId;
}

public void setAdminId(int adminId) {
	this.adminId = adminId;
}

public double getRatings() {
	return ratings;
}

public void setRatings(double ratings) {
	this.ratings = ratings;
}

public String isActive() {
	return isActive;
}

public void setActive(String isActive) {
	this.isActive = isActive;
}

public String getImagepathe() {
	return imagepathe;
}

public void setImagepathe(String imagepathe) {
	this.imagepathe = imagepathe;
}

@Override
public String toString() {
	return "restaurent [restaurentId=" + restaurentId + ", resName=" + resName + ", cusineType=" + cusineType
			+ ", deliverytime=" + deliverytime + ", address=" + address + ", adminId=" + adminId + ", ratings="
			+ ratings + ", isActive=" + isActive + ", imagepathe=" + imagepathe + "]";
}

 
}

 


