package com.tapfood.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DButils.DButils;
import com.tapfood.dao.RestaurentDAO;
import com.tapfood.model.restaurent;
import com.tapfood.model.user;

public class RestaurentDAOImpl implements RestaurentDAO {
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	int status=0;
	restaurent rest;
	
	ArrayList<restaurent>resList=new ArrayList<restaurent>();
	//user ;
	private static final String  ADD_RESTAURENT="Insert into`restaurent`(`resName`,`deliverytime`,`cusineType`"
			+ "`address`,`ratings`,`isActive`,`adminId`,`Imagepathe`)values (?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `restaurent`";
	private static final String SELECT_On_ID="select * from `restaurent`where `restaurentId`=?";
	private static final String UPDATE_On_ID="update `restaurent` set`resName`=?,`deliverytime`=?, "
			+ "`cusineType`=?,`address`=?,`ratings`=?,`isActive`=?,`adminId`=?,`Imagepathe`=? where `restaurentId`=?";
	private static final String DELETE_ON_ID="delete from `restaurent` where `restaurentId`=?";			
	
	
	public RestaurentDAOImpl()
	{
		try
		{
			con=DButils.myConnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int addRestaurent(restaurent r) {
		try {
			
			pstmt=con.prepareStatement(ADD_RESTAURENT);
			
			pstmt.setString(1,r.getResName());
			pstmt.setInt(2, r.getDeliverytime());
			pstmt.setString(3,r.getCusineType());
			pstmt.setString(4,r. getAddress());
			pstmt.setDouble(5,r. getRatings());
			pstmt.setString(6,r. isActive());
			pstmt.setInt(7,r. getAdminId());
			pstmt.setString(8, r.getImagepathe());
			
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<restaurent> getAllrestaurents() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL);
			resList=extractRestaurentFromResultSet(res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resList;
	}



	@Override
	public restaurent getRestaurent(int restaurentId) {

		try {
			pstmt=con.prepareStatement(SELECT_On_ID);
			pstmt.setInt(1, restaurentId);
			res=pstmt.executeQuery();
			resList=extractRestaurentFromResultSet(res);
			rest=resList.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rest;
	}

	@Override
	public int updateRestaurent(restaurent r) {
		try 
		{
			pstmt=con.prepareStatement(UPDATE_On_ID);
			pstmt.setString(1, r.getResName());
			pstmt.setInt(2, r.getDeliverytime());
			pstmt.setString(3, r.getCusineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setDouble(5, r.getRatings());
			pstmt.setString(6, r.isActive());
			pstmt.setInt(7, r.getAdminId());
			pstmt.setString(8, r.getImagepathe());
			pstmt.setInt(9, r.getRestaurentId());
			status=pstmt.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteRestaurent(int restaurentId) 
	{
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_ID);
			pstmt.setInt(1, restaurentId);
			status=pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return status;
	
}	
	ArrayList<restaurent> extractRestaurentFromResultSet(ResultSet res) {
	    ArrayList<restaurent> resList = new ArrayList<>();  
	    try {
	        while (res.next()) {
	            resList.add(new restaurent(
	                res.getInt("restaurentId"),
	                res.getString("resName"),
	                res.getInt("deliverytime"),
	                res.getString("cusineType"),
	                res.getString("address"),
	                res.getDouble("ratings"),
	                res.getString("isActive"),
	                res.getInt("adminId"),
	                res.getString("Imagepathe")  
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return resList;
	}

		

	 
}

		
