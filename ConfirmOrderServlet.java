package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.OrderDAOImpl;
import com.tapfood.daoImpl.OrderhistoryDAOImpl;
import com.tapfood.daoImpl.OrderitemDAOImpl;
import com.tapfood.model.Cart;
import com.tapfood.model.CartItem;
import com.tapfood.model.Ordertable;
import com.tapfood.model.menu;
import com.tapfood.model.orderhistory;
import com.tapfood.model.orderitem;
import com.tapfood.model.user;


@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderDAOImpl ot = new OrderDAOImpl();
		OrderitemDAOImpl oi = new OrderitemDAOImpl();
		OrderhistoryDAOImpl oh = new OrderhistoryDAOImpl();
		String paymentMode = req.getParameter("paymentMode");
		HttpSession session = req.getSession();
		user user = (user)session.getAttribute("loginUser");
		int id= user.getUserId();
		System.out.print("user" +id);
		System.out.println(id);
		int restaurentId=0;
		ArrayList<menu> menuList =(ArrayList<menu>)session.getAttribute("menu");
		for(menu m : menuList)
		{
			restaurentId=m.getRestaurentId();
		}
		System.out.println(restaurentId);
		float totalAmount=0.0f;
		Cart cart =(Cart)session.getAttribute("cart");
		if (cart != null) 
		{
            Map<Integer, CartItem> cartitems = cart.getItems();
            if (cartitems != null && !cartitems.isEmpty()) 
            {
                for (Map.Entry<Integer, CartItem> entry : cartitems.entrySet())
                {
                    CartItem cartitem = entry.getValue();
                    totalAmount+= cartitem.getSubTotal();
                }
            
                Ordertable Ot = new Ordertable( restaurentId,id, totalAmount,"Pending",paymentMode);
               int orderId = ot.addOrder(Ot);
               System.out.println("orderid"+" "+orderId);
               int a=0;
              for (Map.Entry<Integer, CartItem> entry : cartitems.entrySet()) {
              	CartItem cartitem = entry.getValue();
              	
               	orderitem item = new orderitem(orderId, cartitem.getMenuId(), cartitem.getQuantity(), cartitem.getPrice()*cartitem.getQuantity());
               	 a = oi.addOrderItem(item);
               	System.out.println(a);
               }
              	orderhistory ohs = new orderhistory(orderId,id,totalAmount,"completed");
               int b = oh.addOrderHistory(ohs);
               if(orderId>0 && a>0&&b>0)
               {
            	   resp.sendRedirect("orderconfirm.jsp");
               }
               
               
               
            } 
		}
    
		
	}
	
	
	
	
	
	
}
