package com.tap.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfood.daoImpl.MenuDAOImpl;
import com.tapfood.model.menu;



@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("restaurentId"));
            System.out.println("Selected Restaurant ID: " + id);
            
            MenuDAOImpl md = new MenuDAOImpl();
            ArrayList<menu> menuList = md.getMenu(id);
            for (menu item : menuList) {
                System.out.println("Menu Item: " + item.getMenuname() + ", Image Path: " + item.getImgpath());
            }

            
            
            if (menuList != null && !menuList.isEmpty()) {
                HttpSession session = req.getSession();
                session.setAttribute("menu", menuList);
            } else {
                System.out.println("No menu items found for restaurant ID: " + id);
            }
            
            res.sendRedirect("menu.jsp");
        } catch (NumberFormatException e) {
            System.out.println("Invalid restaurant ID format: " + e.getMessage());
            res.sendRedirect("error.jsp"); 
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            res.sendRedirect("error.jsp"); 
        }
    }
}
