package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.OrderhistoryDAOImpl;
import com.tapfood.model.orderhistory;
import com.tapfood.model.user;




@WebServlet("/history")
public class HistoryDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); 
		user user = (user)session.getAttribute("loginUser");
		int id= user.getUserId();
		OrderhistoryDAOImpl oim = new OrderhistoryDAOImpl();
		ArrayList<orderhistory> list = oim.getHistory(id);
		System.out.println(list);
		session.setAttribute("HistoryList", list);
		resp.sendRedirect("HistoryDisplay.jsp");

		
		
	
		
		
	}

	

}
