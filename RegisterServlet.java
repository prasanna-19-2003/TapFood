package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfood.dao.UserDAO;
import com.tapfood.daoImpl.UserDAOImpl;
import com.tapfood.model.user;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");

        user u = new user(username,email, phoneNumber, password, address );


        UserDAO userDAO = new UserDAOImpl();
        int status = userDAO.addUser(u);
        if (status == 1) {
            res.sendRedirect("welcome.jsp"); 
        } else {
            res.sendRedirect("failure.jsp"); 
        }
    }
}
