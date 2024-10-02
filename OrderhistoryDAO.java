package com.tapfood.dao;

import java.util.ArrayList;

import com.tapfood.model.orderhistory;
public interface OrderhistoryDAO {
	
	
	int addOrderHistory(orderhistory OH);
	ArrayList<orderhistory>getAllorderhistoty();
	ArrayList<orderhistory>getHistory(int usid);

}
