package com.tap.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.RestaurentDAOImpl;
import com.tapfood.model.restaurent;
import com.tapfood.model.user;


@WebServlet("/home")
public class HOME extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		user user = (user) session.getAttribute("loginUser");
		RestaurentDAOImpl rd = new RestaurentDAOImpl();
		List<restaurent> restsList = rd.getAllrestaurents();
		
		for (restaurent r : restsList) {
			System.out.println("Restaurant: " + r.getResName() + " | Image Path: " + r.getImagepathe());
		}
		
		session.setAttribute("loginUser", user);
		session.setAttribute("restsList", restsList);
		
		res.sendRedirect("home.jsp");
	}
}
