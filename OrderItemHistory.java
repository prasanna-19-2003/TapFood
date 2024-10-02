package com.tap.controller;

import java.awt.Menu;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.MenuDAOImpl;
import com.tapfood.daoImpl.OrderitemDAOImpl;
import com.tapfood.model.menu;
import com.tapfood.model.orderitem;


@WebServlet("/orderitemHistory")
public class OrderItemHistory extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id =Integer.parseInt(req.getParameter("OrderId"));
		System.out.println("orderid" + id);
		OrderitemDAOImpl ol = new OrderitemDAOImpl();
		orderitem  o = ol.getOrderItem(id);
		System.out.println(o);
		 //if (o != null) {

		//System.out.println(id1);
		//MenuDAOImpl md = new MenuDAOImpl();
			//	int id1= o.getMenId();menu m= md.getMenuItem(id1);
		//System.out.println(m);
		//session.setAttribute("Menu", m);
		session.setAttribute("OrderItem", o);
		resp.sendRedirect("OrderItemHistory.jsp");

		 
		 



}

}

