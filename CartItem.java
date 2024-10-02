
package com.tapfood.model;

public class CartItem {
	private int menuId;
	private int RestaurentId;
	private String name;
	private int quantity;
	private double price;
	private double subTotal;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int menuId, int restaurentId, String name, int quantity, double price, double subTotal) {
		super();
		this.menuId = menuId;
		this.RestaurentId = restaurentId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}
	

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurentId() {
		return RestaurentId;
	}

	public void setRestaurentId(int restaurantId) {
		RestaurentId = RestaurentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "CartItem [menuId=" + menuId + ", RestaurentId=" + RestaurentId + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + ", subTotal=" + subTotal + "]";
	}

	

}
	


