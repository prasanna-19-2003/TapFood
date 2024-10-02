package com.tapfood.dao;

import java.util.ArrayList;

import com.tapfood.model.orderitem;

public interface OrderItemDAO {
	
	
	
	int addOrderItem(orderitem o);
	 ArrayList<orderitem> getAllOrderItem();
	
	orderitem getOrderItem(int orderId);
}
