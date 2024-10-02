package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.dao.UserDAO;
import com.tapfood.daoImpl.UserDAOImpl;
import com.tapfood.model.user;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println(email);
        System.out.println(password);

        UserDAOImpl userDAO = new UserDAOImpl();
        user user = userDAO.getUser(email); 

       
        if (user == null) {
            req.setAttribute("errorMessage", "Email is not registered.");
            req.getRequestDispatcher("Loginfailure.jsp").forward(req, res);  
        } else if (password.equals(user.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", user);
            res.sendRedirect("home");  
        } else {
            req.setAttribute("errorMessage", "Incorrect Email or Incorrect password. Please try again.");
            req.getRequestDispatcher("Login.jsp").forward(req, res);  
        }
    }
}
