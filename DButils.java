package com.tapfood.DButils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButils {
private static	Connection con=null;
private static String url="jdbc:mysql://localhost:3306/tapfood";
private static		String username="root";
private static		String password="Mypassword@2003";
	
	public static Connection myConnect()
	{

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
       con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	

}
