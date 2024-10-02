package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.OrderhistoryDAOImpl;
import com.tapfood.model.orderhistory;

/**
 * Servlet implementation class OrdeHistorybasedOnUserId
 */
@WebServlet("/OrdeHistorybasedOnUserId")
public class OrdeHistorybasedOnUserId extends HttpServlet {
	

	
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			
			int id =Integer.parseInt(req.getParameter("userId"));
			System.out.print(id);
			OrderhistoryDAOImpl ohi = new OrderhistoryDAOImpl();
			
			List<orderhistory> list = ohi.getHistory(id);
			session.setAttribute("list", list);
			resp.sendRedirect("UserOrderHistory.jsp");

}
}