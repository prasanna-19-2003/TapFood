package com.tap.controller;

import java.awt.Menu;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.dao.MenuDAO;
import com.tapfood.daoImpl.MenuDAOImpl;
import com.tapfood.model.Cart;
import com.tapfood.model.CartItem;
import com.tapfood.model.menu;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		Cart cart =(Cart)session.getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		String action = req.getParameter("action");
		if("add".equals(action))
		{
			addItemToCart(req,cart);
		}
		else if("update".equals(action))
		{
			updateCartItem(req,cart);
		}
		else if("remove".equals(action))
		{
			removeItemFromCart(req,cart);
		}
		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
		
	}
	private void removeItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
	    cart.removeItem(itemId);
	    //System.out.println("hii");
		
	    
	    
	}
	private void updateCartItem(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
	    int newQuantity = Integer.parseInt(req.getParameter("quantity"));
	    cart.updateItem(itemId, newQuantity);
	   // System.out.println("Hello");
		
		
	}
	private void addItemToCart(HttpServletRequest req,Cart cart)
	{
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		//cart.updateItem(itemId, quantity);
		//System.out.println(quantity);
		//System.out.println(itemId);
		
		
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		menu menuItem = menuDAO.getMenuItem(itemId);
		
		HttpSession session = req.getSession();
		session.setAttribute("resturantId", menuItem. getRestaurentId());
		 
		if(menuItem!=null)
		{
			CartItem item = new CartItem(
					menuItem.getMenuId(),
					menuItem.getRestaurentId(),
					menuItem.getMenuname(),
					quantity,
					menuItem.getPrice(),
					quantity*menuItem.getPrice());
			cart.addItem(item);
		}
			
			
	}

}
