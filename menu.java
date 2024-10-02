package com.tapfood.model;

public class menu {
	private int MenuId ; 
	private int restaurentId; 
private String	menuname; 
private double	price; 
private String	description ;
boolean isAvailable ;
private String imgpath;
public menu() {
	super();
}
public menu(int menuId, int restaurentId, String menuname, double price, String description, String imgpath,boolean isAvailable) {
	super();
	MenuId = menuId;
	this.restaurentId = restaurentId;
	this.menuname = menuname;
	this.price = price;
	this.description = description;
	this.isAvailable = isAvailable;
	this.imgpath=imgpath;
}
public menu(int restaurentId, String menuname, double price, String description, boolean isAvailable,String imgpath) {
	super();
	this.restaurentId = restaurentId;
	this.menuname = menuname;
	this.price = price;
	this.description = description;
	this.isAvailable = isAvailable;
	this.imgpath=imgpath;
}

public int getMenuId() {
	return MenuId;
}
public void setMenuId(int menuId) {
	MenuId = menuId;
}
public int getRestaurentId() {
	return restaurentId;
}
public void setRestaurentId(int restaurentId) {
	this.restaurentId = restaurentId;
}
public String getMenuname() {
	return menuname;
}
public void setMenuname(String menuname) {
	this.menuname = menuname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
public String getImgpath() {
	return imgpath;
}
public void setImgpath(String imgpath) {
	this.imgpath = imgpath;
}
 
}



