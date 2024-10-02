package com.tapfood.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DButils.DButils;
import com.tapfood.dao.OrderhistoryDAO;
import com.tapfood.model.orderhistory;

public class OrderhistoryDAOImpl implements OrderhistoryDAO {
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt; 
	ArrayList<orderhistory>ordhis=new ArrayList<orderhistory>();
	int status=0;
	
	orderhistory oh;
	
	private static final String ADD_ORDERHISTORY="insert into `orderhistory`(`ordeId`,`usId`,`totalAmount`,`status`)values(?,?,?,?)";
	private static final String SELECT_ALL="select * from `orderhistory`";
	private static final String SELECT_ON_ID="select * from `orderhistory` where `ordhisId`=?";
	private static final String SELECT_ON_USERID="select * from `orderhistory` where usId=?";
	
	public OrderhistoryDAOImpl()
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
	public int addOrderHistory(orderhistory OH)
	{
		try 
		{
			pstmt=con.prepareStatement(ADD_ORDERHISTORY);
			pstmt.setInt(1,OH.getOrdeId());
			pstmt.setInt(2,OH.getUsId());
			pstmt.setDouble(3,OH.getTotalAmount());
			pstmt.setString(4,OH.getStatus());
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	
	@Override
	public ArrayList<orderhistory>getAllorderhistoty()
	{
		
		try
		{
			stmt=con.createStatement();
			
			res=stmt.executeQuery(SELECT_ALL);
			ordhis=extractUserFromResultSet(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ordhis;
		
	}
	
	
	
	

	@Override 
	public ArrayList<orderhistory>getHistory(int usid)
	{
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_USERID);
			pstmt.setInt(1, usid);
			res=pstmt.executeQuery();
			ordhis=extractUserFromResultSet(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ordhis;
	}
		
		
	
	private ArrayList<orderhistory> extractUserFromResultSet(ResultSet res2) {
		try
		{
			while(res.next())
			{
				ordhis.add(new orderhistory(res.getInt("ordHisId"),
						res.getInt("ordeId"),
						res.getInt("usId"),
						res.getString("orddate"),
						
						res.getFloat("totalAmount"),
						res.getString("status")
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ordhis;
	
}

}
