package com.tapfood.model;

public class orderitem {
	
private int	orderitemId  ;
private int	orderId ; 
private int	menId  ;
private int	quantity  ;
private double	subtotal ;
public orderitem(int orderitemId, int orderId, int menId, int quantity, double subtotal) {
	super();
	this.orderitemId = orderitemId;
	this.orderId = orderId;
	this.menId = menId;
	this.quantity = quantity;
	this.subtotal = subtotal;
}
public orderitem(int orderId, int menId, int quantity, double subtotal) {
	super();
	this.orderId = orderId;
	this.menId = menId;
	this.quantity = quantity;
	this.subtotal = subtotal;
}
public int getOrderitemId() {
	return orderitemId;
}
public void setOrderitemId(int orderitemId) {
	this.orderitemId = orderitemId;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getMenId() {
	return menId;
}
public void setMenId(int menId) {
	this.menId = menId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
@Override
public String toString() {
	return "orderitem [orderitemId=" + orderitemId + ", orderId=" + orderId + ", menId=" + menId + ", quantity=" + quantity
			+ ", subtotal=" + subtotal + "]";
}

	
	
	

}
