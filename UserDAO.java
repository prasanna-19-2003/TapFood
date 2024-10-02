package com.tapfood.dao;

import java.util.ArrayList;
import com.tapfood.model.user;
public interface UserDAO 
{
int addUser(user u);
ArrayList<user> getAllusers();
user getUser(int id);
user getUser(String email);
int updateUser(user u);
int  deleteuser(String email);


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
