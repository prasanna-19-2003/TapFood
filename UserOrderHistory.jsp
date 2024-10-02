<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="com.tapfood.model.orderhistory,java.util.List" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f7ff; 
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 800px;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }

    .order-card {
        border: 2px solid #0056b3; 
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 8px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #fafafa;
    }

    .order-info p {
        margin: 5px 0;
        color: #333;
    }

    .order-info span {
        font-weight: bold;
        color: #0056b3; 
    }

    .order-action a {
        padding: 8px 15px;
        background-color: #28a745; 
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .order-action a:hover {
        background-color: #218838; 
    }

    p.no-orders {
        text-align: center;
        font-size: 1.2em;
        color: #888;
    }
</style>
</head>
<body>
<div class="container">
        <% List<orderhistory> list = (List<orderhistory>) session.getAttribute("list"); %>
        <% if (list != null && !list.isEmpty()) { %>
            <% for(orderhistory e : list) { %>
                <div class="order-card">
                    <div class="order-info">
                        <p><span>Order History ID:</span> <%= e.getOrdHisId() %></p>
                        <p><span>Order ID:</span> <%= e.getOrdeId() %></p>
                        <p><span>Status:</span> <%= e.getStatus() %></p>
                        <p><span>Total Amount:</span> $<%= e.getTotalAmount() %></p>
                        <p><span>Order Date:</span> <%= e.getOrddate() %></p>
                    </div>
                    <div class="order-action">
                        <a href="HistorybasedOnOrderId?OrderId=<%= e.getOrdeId() %>">View</a>
                    </div>
                </div>
            <% } %>
        <% } else { %>
            <p class="no-orders">No orders found.</p>
        <% } %>
    </div>
</body>
</html>
