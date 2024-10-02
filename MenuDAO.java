package com.tapfood.dao;



import java.awt.Menu;
import java.util.ArrayList;

import com.tapfood.model.menu;

public interface MenuDAO {
	int addMenu(menu m);
	ArrayList<menu> getAllMenu();
	ArrayList<menu> getMenu(int restaurentId);
	menu  getMenuItem(int MenuId);
	int updateMenu(menu m);
	int deleteMenu(int MenuId);
	//int deleteMenu(String MenuId);
	
}
