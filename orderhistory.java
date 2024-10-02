package com.tapfood.model;

public class orderhistory {




private int	ordHisId ;

private int ordeId  ;
private	int usId  ;
private String orddate;
private	 double  totalAmount ;
private String	status ;
	
public orderhistory() {
	super();
}
public orderhistory(int ordHisId, int ordeId,int uderid , double totalAmount) {
	super();
	this.ordHisId = ordHisId;
	this.ordeId = ordeId;
	this.usId = usId;
	this.totalAmount = totalAmount;
}
public orderhistory(int ordHisId, int ordeId, int usId,String orddate, double totalAmount, String status) {
	super();
	this.ordHisId = ordHisId;
	this.ordeId = ordeId;
	this.usId = usId;
	this.orddate=orddate;
	this.totalAmount = totalAmount;
	this.status = status;
}
public orderhistory( int ordeId, int usId,  double totalAmount, String status) {
	super();
	
	this.ordeId = ordeId;
	this.usId = usId;
	this.totalAmount = totalAmount;
	this.status = status;
}
public String getOrddate() {
	return orddate;
}
public void setOrddate(String orddate) {
	this.orddate = orddate;
}
public int getOrdHisId() {
	return ordHisId;
}
public void setOrdHisId(int ordHisId) {
	this.ordHisId = ordHisId;
}
public int getOrdeId() {
	return ordeId;
}
public void setOrdeId(int ordeId) {
	this.ordeId = ordeId;
}
public int getUsId() {
	return usId;
}
public void setUsId(int usId) {
	this.usId = usId;
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
@Override
public String toString() {
	return "orderhistory [ordHisId=" + ordHisId + ", ordeId=" + ordeId + ", usId=" + usId + ", totalAmount="
			+ totalAmount + ", status=" + status + "]";
}
}