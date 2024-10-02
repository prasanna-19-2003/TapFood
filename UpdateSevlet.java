package com.tap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.UserDAOImpl;
import com.tapfood.model.user;


@WebServlet("/update")
public class UpdateSevlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		user user = (user)session.getAttribute("loginUser");
		String username = req.getParameter("username");
		System.out.println(username);
		//String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phone");
		System.out.println(phoneNumber);
		String password = req.getParameter("password");
		System.out.println(password);
		String Address = req.getParameter("address");
		System.out.println(Address);
		user u = new user(username,password,phoneNumber,Address,user.getEmail());
		UserDAOImpl ud = new UserDAOImpl();
		int x = ud.updateUser(u);
		if(x==1)
		{
			resp.sendRedirect("updateSuccess.jsp");
		}
		
		else
		{
		resp.sendRedirect("updateFailure.jsp");
		}

}
}
