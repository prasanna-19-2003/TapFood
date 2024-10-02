package com.tapfood.daoImpl;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DButils.DButils;
import com.tapfood.dao.MenuDAO;
import com.tapfood.model.menu;


public class MenuDAOImpl implements MenuDAO {
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	private PreparedStatement pstmt;
	ArrayList<menu> men=new ArrayList<menu>();
	int status=0;
	menu mn;
	
	
	
	private static final String ADD_MENU="insert into `menu` (`restaurentId`,`menuName`,`price`,`description`,isAvailable,imgPath) values(?,?,?,?,?,?)";
	private static final String SELECT_ALL="select from `menu`";
	private static final String SELECT_ON_ID="select * from `menu` where `restaurentId`=?";

	private static final String SELECT_ON_MENUITEMID="select * from `menu` where `MenuId`=?";
	private static final String UPDATE_ON_ID="update `menu` set `restaurentId`=?,`menuName`=?,`price`=?,`description`=?,`isAvailable`=?,`imgPath`=? where `MenuId`=?";
	private static final String DELETE_ON_EMAIL="delete from `menu` where `MenuId`=?";

	public MenuDAOImpl()
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
	public int addMenu(menu m) {
		try {
			pstmt=con.prepareStatement(ADD_MENU);
			pstmt.setInt(1, m.getRestaurentId());
			pstmt.setString(2, m.getMenuname());
			pstmt.setDouble(3, m.getPrice());
			pstmt.setString(4, m.getDescription());
			pstmt.setBoolean(5, m.isAvailable());
			pstmt.setString(6,  m.getImgpath());
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
		
	}

	@Override
	public ArrayList<menu> getAllMenu() {
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL);
			 men=exctractMenuFromResultSet( res);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return men;
		
	}

	@Override

	public ArrayList<menu> getMenu(int restaurentId) {
	    men = new ArrayList<>(); 
	    try {
	        pstmt = con.prepareStatement(SELECT_ON_ID);
	        pstmt.setInt(1, restaurentId);
	        res = pstmt.executeQuery();
	        men = exctractMenuFromResultSet(res);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return men;
	}

	

	



	@Override
	public int updateMenu(menu m) {
		try {
			pstmt=con.prepareStatement(UPDATE_ON_ID);
			//pstmt=con.prepareStatement(ADD_MENU);
			pstmt.setInt(1, m.getRestaurentId());
			pstmt.setString(2,m.getMenuname());
			pstmt.setDouble(3, m.getPrice());
			
			pstmt.setString(4, m.getDescription());
			pstmt.setBoolean(5, m.isAvailable());
			pstmt.setString(6, m.getImgpath());
			
			pstmt.setInt(7, m.getMenuId());
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public int deleteMenu(int MenuId) {
	
	try {
		pstmt=con.prepareStatement(DELETE_ON_EMAIL);
		pstmt.setInt(1, MenuId);
		status=pstmt.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
	}
	private ArrayList<menu> exctractMenuFromResultSet(ResultSet res) {
	    try {
	        while (res.next()) {
	            men.add(new menu(res.getInt("MenuId"),
	                    res.getInt("restaurentId"),
	                    res.getString("menuname"),
	                    res.getDouble("price"),
	                    res.getString("description"),
	                    res.getString("imgpath"),
	                    res.getBoolean("isAvailable")
	                    )); // Ensure this is correct
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return men;
	}

	




		@Override
		public menu getMenuItem(int MenuId) {
			
			try
			{
				pstmt=con.prepareStatement(SELECT_ON_MENUITEMID);
				pstmt.setInt(1, MenuId);
				res = pstmt.executeQuery();
				men=exctractMenuFromResultSet( res);
				mn=men.get(0);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return mn;
			
			
			
			
			
			
		}



		
		
	}


