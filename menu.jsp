<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfood.model.menu, java.util.ArrayList" %>
<%@ page import="com.tapfood.model.user" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Menu Item List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9; 
            margin: 0;
            padding: 0;
            color: #333;
        }

        header {
            background-color: #3498db; 
            color: white;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        nav {
            margin-top: 10px;
        }

        nav a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.2s ease;
        }

        nav a:hover {
            color: #f0f0f0;
            text-decoration: underline;
        }

        h2 {
            margin: 20px;
            color: #3498db;
            font-weight: 400;
        }

        .menu-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 20px auto;
            max-width: 1200px;
        }

        .menu-item {
            background-color: white;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            padding: 15px;
            margin: 10px;
            text-align: center;
            width: 250px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .menu-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
        }

        .menu-item img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 10px;
        }

        .menu-item h4 {
            color: #333;
            margin: 15px 0 10px;
            font-size: 1.2em;
        }

        .menu-item p {
            color: #777;
            margin: 10px 0;
            font-size: 0.9em;
            height: 50px;
            overflow: hidden;
        }

        .price {
            color: #333;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .menu-item form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .menu-item input[type="number"] {
            padding: 5px;
            font-size: 16px;
            width: 80px;
            margin: 0 auto;
            text-align: center;
        }

        .menu-item input[type="submit"] {
            background-color: #3498db; 
            color: white;
            padding: 10px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease; 
        }

        .menu-item input[type="submit"]:hover {
            background-color: #2980b9; 
        }
    </style>
</head>
<body>
    <header>
        <h1>Menu for Selected Restaurant</h1>
        <nav>
            <a href="home">HOME</a>
            <% user user = (user)session.getAttribute("loginUser"); %>
            <% if(user != null) { %>
                <h3>Welcome back, <% out.println(user.getUsername()); %></h3>
                <div class="nav-bar">
                    <a href="cart">View Cart</a>
                    <a href="OrdeHistorybasedOnUserId?userId=<%=user.getUserId() %>">View Order History</a>
                    <a href="logoutSevlet">LogOut</a>
                    <a href="Update.jsp">Update</a>
                </div>
            <% } else { %> 
                <h3>YOU HAVEN'T LOGGED IN</h3>
                <div class="nav-bar">
                    <a href="Login.jsp">Login</a>
                    <a href="SignUp.jsp">Register</a>
                </div>
            <% } %>
        </nav>
    </header>

    <h2>&nbsp;&nbsp;&nbsp;Menu Items</h2>
    <section class="menu-list">
    <% 
        ArrayList<menu> menuList = (ArrayList<menu>) session.getAttribute("menu");
        
        if (menuList != null && !menuList.isEmpty()) {
            for (menu menuItem : menuList) {
    %>
        <div class="menu-item">
            <img src="Images/<%= menuItem.getImgpath() %>" 
                 alt="Image of <%= menuItem.getMenuname() %>" 
                 
                 onerror="this.onerror=null; this.src='Images/default.jpg';">
            <h4><%= menuItem.getMenuname() %></h4>
            <p><%= menuItem.getDescription() %></p>
            <div class="price">Price: $<%= menuItem.getPrice() %></div>
            <form action="cart">
                <input type="hidden" name="itemId" value="<%= menuItem.getMenuId() %>">
                Quantity: <input type="number" name="quantity" value="1" min="1">
                <input type="submit" value="Add to cart">
                <input type="hidden" name="action" value="add">
            </form>
        </div>
    <% 
            }
        } else {
    %>
        <p>No menu items available at the moment.</p>
    <% 
        }
    %>
</section>



</body>
</html>
