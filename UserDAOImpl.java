package com.tapfood.daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DButils.DButils;
import com.tapfood.dao.UserDAO;
import com.tapfood.model.user;

public class UserDAOImpl implements UserDAO 
{
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	int status=0;
	
	
	ArrayList<user>userList=new ArrayList<user>();
	user us;
	private static final String ADD_USER="Insert into `user`(`username`,`email`,"
			+ "`phonenumber`,`password`,`address`)values (?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `user`";
	private static final String SELECT_On_EMAIL="select * from `user` where `email`=?";
	private static final String UPDATE_On_EMAIL="update `user` set `username`=?,`password`=?,`phonenumber`=?, "
			+ "`address`=? where `email`=?";
	private static final String DELETE_ON_EMAIL="delete from `user` where `email`=?";	
private static final String DELETE_ON_ID="delete from `user` where `userId`=? ";
	public UserDAOImpl()
	{
		try {
		con=DButils.myConnect();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public int addUser(user u) {
	
		try {
			pstmt=con.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhonenumber());
			pstmt.setString(4, u.getPassword());
			
			pstmt.setString(5, u.getAddress());
		status=	pstmt.executeUpdate();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	
@Override
	public ArrayList<user> getAllusers() {
		try
		{
			
		 stmt = con.createStatement();
		 res=stmt.executeQuery(SELECT_ALL);
	  userList=extractUserFromResultSet(res);
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
		
	}
	
	
	
@Override
	public user getUser(String email) {
		try
		{
			pstmt=con.prepareStatement(SELECT_On_EMAIL);
			pstmt.setString(1,email);
			res=pstmt.executeQuery();
			userList=extractUserFromResultSet(res);
		us=userList.get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return us;
	}
	
	
	
@Override
	public int updateUser(user u) {
		try
		{
			pstmt = con.prepareStatement(UPDATE_On_EMAIL);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPhonenumber());
			pstmt.setString(3, u.getPassword());
		
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getEmail());
			status =pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}


@Override
	public int deleteuser(String email) {
		try
		{
			pstmt=con.prepareStatement(DELETE_ON_EMAIL);
			pstmt.setString(1, email);
			status=	pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return status;
	}
	
	ArrayList<user>extractUserFromResultSet(ResultSet res)
	{
		try
		{
			while(res.next())
			 {
		userList.add(new user(res.getInt("userId"),
				res.getString("username"),
				res.getString("email"),
				res.getString("phonenumber"),
				res.getString("password"),
				res.getString("address")
				));
				 
			 }
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return userList;
		}
	@Override
	public user getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
		
		
		
	}
	
	
	
	
	
	
	


