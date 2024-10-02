package com.tapfood.dao;

import java.util.ArrayList;

import com.tapfood.model.Ordertable;

public interface OrderDAO {
	
	int addOrder(Ordertable ot);
	 ArrayList<Ordertable> getAllOrders();
 Ordertable getOrder(int OrderId);
	 

}
