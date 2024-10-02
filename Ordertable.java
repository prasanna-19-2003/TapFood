package com.tapfood.model;

public class Ordertable {




private int orderId; 
private int useId;
private int	restId ;
private double	totalAmount; 
private String	status; 
private String	paymentMode;
public Ordertable(int restId,int useId,  double totalAmount, String status, String paymentMode) {
	super();
	this.useId = useId;
	this.restId = restId;
	this.totalAmount = totalAmount;
	this.status = status;
	this.paymentMode = paymentMode;
}

public Ordertable() {
	super();
}

public Ordertable(int restId, int useId, double totalAmount,String	paymentMode) {
	super();
	
	this.restId = restId;
	this.useId = useId;
	this.totalAmount = totalAmount;
	this.paymentMode = paymentMode;
}

public Ordertable(int orderId,  int restId,int useId, double totalAmount, String status,
		String paymentMode) {
	super();
	this.orderId = orderId;
	
	this.restId = restId;
	this.useId = useId;
	this.totalAmount = totalAmount;
	this.status = status;
	this.paymentMode = paymentMode;
}

public int getOrderId() {
	return orderId;
}



public void setOrderId(int orderId) {
	this.orderId = orderId;
}



public int getUseId() {
	return useId;
}



public void setUseId(int useId) {
	this.useId = useId;
}



public int getRestId() {
	return restId;
}



public void setRestId(int restId) {
	this.restId = restId;
}






public double getTotalAmount() {
	return totalAmount;
}



public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public String getPaymentMode() {
	return paymentMode;
}



public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}

@Override
public String toString() {
	return "Ordertable [orderId=" + orderId + ", useId=" + useId + ", restId=" + restId + ", totalAmount=" + totalAmount
			+ ", status=" + status + ", paymentMode=" + paymentMode + "]";
}





}
