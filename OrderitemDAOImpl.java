package com.tapfood.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DButils.DButils;
import com.tapfood.dao.OrderItemDAO;
import com.tapfood.model.menu;
import com.tapfood.model.orderitem;

public class OrderitemDAOImpl implements OrderItemDAO {
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt; 
	ArrayList<orderitem>ordit=new ArrayList<orderitem>();
	int status=0;
	 orderitem orderitem;
	
	
private static final String	ADD_ITEM="insert into `orderitem`(`orderId`,`menId`,`quantity`,`subtotal`) values(?,?,?,?)";
private static final String  SELECT_ALL="select * from `orderitem`";
private static final String SELECT_ON_ID="select * from `orderitem` where `orderitemId`=?";
	
public OrderitemDAOImpl()
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
	public int addOrderItem(orderitem o) {
		try {
			pstmt=con.prepareStatement(ADD_ITEM);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getMenId());
			pstmt.setDouble(3, o.getQuantity());
			pstmt.setDouble(4,  o.getSubtotal());
			
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public ArrayList<orderitem> getAllOrderItem() {
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL);
			 ordit=exctractMenuFromResultSet( res);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ordit;
		
		
	}

	


	@Override
	public orderitem getOrderItem(int orderId) {
		try {
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1,orderId);
			res=pstmt.executeQuery();
			ordit=exctractMenuFromResultSet(res);
			orderitem=ordit.get(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderitem;
		
	}
	public  ArrayList<orderitem> exctractMenuFromResultSet(ResultSet res) {
		try {

			while(res.next())
			{
				ordit.add(new orderitem(
						res.getInt("orderitemId"),
						res.getInt("orderId"),
						res.getInt("menId"),
						res.getInt("quantity"),
						res.getDouble("subtotal")));
				
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ordit;
}



	
}

	
		
	


		