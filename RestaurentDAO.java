package com.tapfood.dao;

import java.util.ArrayList;

import com.tapfood.model.restaurent;

public interface RestaurentDAO {
	int addRestaurent(restaurent r);
	ArrayList<restaurent> getAllrestaurents();
	restaurent getRestaurent(int restaurentId);
	int updateRestaurent(restaurent r);
	int  deleteRestaurent(int restaurentId);
  
}
