<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfood.model.restaurent" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tapfood.model.user" %>

<% 
    user user = (user)session.getAttribute("loginUser"); 
    if (user == null) {
        response.sendRedirect("Login.jsp");
        return; 
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Restaurants</title>
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

        .restaurent-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 20px auto;
            max-width: 1200px;
        }

        .restaurent {
            background-color: white;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            padding: 15px;
            margin: 10px;
            text-align: center;
            width: 280px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .restaurent:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
        }

        .restaurent img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 10px;
        }

        .restaurent h3 {
            color: #333;
            margin: 15px 0 10px;
            font-size: 1.3em;
        }

        .restaurent p {
            color: #777;
            margin: 10px 0;
            font-size: 0.9em;
        }

        .restaurent a {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 20px;
            background-color: #3498db; 
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.2s ease;
        }

        .restaurent a:hover {
            background-color: #2980b9;
        }

        p {
            text-align: center;
            color: darkgray;
            font-size: 1em;
        }

        @media (max-width: 768px) {
            .restaurent {
                width: 90%;
                margin: 15px auto;
            }
        }

        @media (max-width: 576px) {
            nav a {
                margin: 0 8px;
                font-size: 0.9em;
            }

            header {
                padding: 15px;
            }
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Tap Online Food Delivery</h1>
        <nav>
            <a href="home">HOME</a>
            <h3>Welcome back, <%= user.getUsername() %></h3>
            <div class="nav-bar">
                <a href="cart">View Cart</a>
                <a href="OrdeHistorybasedOnUserId?userId=<%= user.getUserId() %>">View Order History</a>
                <a href="logoutSevlet">LogOut</a>
                <a href="Update.jsp">Update</a>
            </div>
        </nav>
    </header>

    <h2>&nbsp;&nbsp;&nbsp;Featured Restaurants</h2>
    <section class="restaurent-list">
        <% 
            List<restaurent> restList = (List<restaurent>) session.getAttribute("restsList");

            if (restList != null && !restList.isEmpty()) {
                for (restaurent restaurent : restList) {
        %>
            <div class="restaurent">
                <img src="Images/<%= restaurent.getImagepathe() %>" 
                     alt="Image of <%= restaurent.getResName() %>" 
                     onerror="this.onerror=null; this.src='Images/default.jpg ';"> <!-- Fallback image -->
                <h3><%= restaurent.getResName() %></h3>
                <p><%= restaurent.getCusineType() %> - <%= restaurent.getDeliverytime() %> mins</p>
                <a href="menu?restaurentId=<%= restaurent.getRestaurentId() %>">View Menu</a>
            </div>
        <% 
                }
            } else {
        %>
            <p>No restaurants available at the moment.</p>
        <% 
            }
        %>
    </section>

</body>
</html>
