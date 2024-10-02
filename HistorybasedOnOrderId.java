package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.OrderitemDAOImpl;
import com.tapfood.model.orderitem;


@WebServlet("/HistorybasedOnOrderId")
public class HistorybasedOnOrderId extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id =Integer.parseInt(req.getParameter("OrderId"));
		System.out.println(id);
		OrderitemDAOImpl oii = new OrderitemDAOImpl();
		orderitem oi = oii.getOrderItem(id);
		session.setAttribute("OrderItem", oi);
		resp.sendRedirect("OrderItemHistory1.jsp");
		System.out.println(oi);

	

}
}
