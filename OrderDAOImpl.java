package com.tapfood.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DButils.DButils;
import com.tapfood.dao.OrderDAO;
import com.tapfood.model.Ordertable;

public class OrderDAOImpl implements OrderDAO {
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	
	
	
	ArrayList<Ordertable>orderList=new ArrayList<Ordertable>();
	int status=0;
	Ordertable ordertable;
	private static final String ADD_ORDER ="insert into `Ordertable`(`restId`,`useId`,`totalAmount`,`status`,`paymentMode`)values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `Ordertable`";
	private static final String SELECT_ON_ID="select * from `Ordertable` where `orderId`=?";

	public OrderDAOImpl()
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
public int addOrder(Ordertable ot) 
{
		int orderId=0;
		try
		{
			pstmt=con.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, ot.getRestId());
			pstmt.setInt(2, ot.getUseId());
			
			pstmt.setDouble(3, ot.getTotalAmount());
			pstmt.setString(4, ot.getStatus());
			pstmt.setString(5, ot.getPaymentMode());
			status = pstmt.executeUpdate();
			if(status>0)
			{
				res=pstmt.getGeneratedKeys();
				if(res.next()) 
				{
					orderId=res.getInt(1);
					
				}
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderId;
	}
		
	

@Override
	public ArrayList<Ordertable> getAllOrders() {
		
		try
		{
			stmt=con.createStatement();
			res = stmt.executeQuery(SELECT_ALL);
			orderList=extractOrdersFromResultSet(res);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderList;
		
}

@Override
	public Ordertable getOrder(int orderId)
{
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_ID);
			pstmt.setInt(1, orderId);
			res = pstmt.executeQuery();
			orderList=extractOrdersFromResultSet(res);
			ordertable=orderList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ordertable;
		
}
 ArrayList<Ordertable> extractOrdersFromResultSet(ResultSet res) {
		try
		{
			while(res.next())
			{
				
				orderList.add(new Ordertable(
						res.getInt("restId"),
						res.getInt("useId"),
						res.getDouble("totalamount"),
						res.getString("status"),
						res.getString("paymentmode")));
			}
		}
		catch(Exception e)
		{
			
		}
		return orderList;
		
	}

}
