<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tapfood.model.orderhistory" %>
<%@ page import="com.tapfood.model.user" %>
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
            padding: 20px;
        }
        .username {
            background-color: #0056b3; 
            color: #fff;
            padding: 10px;
            text-align: center;
            margin-bottom: 20px;
            border-radius: 8px;
        }
        h3 {
            color: #0056b3; 
            text-align: center;
        }
        .order-list {
            width: 80%;
            margin: 0 auto;
            background-color: #fff; 
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .order-item {
            display: flex;
            justify-content: space-between;
            padding: 10px;
            border-bottom: 1px solid #ccc;
        }
        .order-item:last-child {
            border-bottom: none;
        }
        .order-id, .order-status, .order-amount, .order-date {
            font-size: 14px;
            color: #666;
        }
        .view-details {
            text-decoration: none;
            color: #007bff; 
            font-weight: bold;
        }
        .view-details:hover {
            text-decoration: underline;
        }
        .total-amount {
            text-align: right;
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
        }
        .total-amount span {
            color: #0056b3; 
        }
    </style>
</head>
<body>
    <div class="username">
        <% user user = (user)session.getAttribute("loginUser"); %>
        Welcome, <%= user.getUsername() %>!
    </div>

    <h3>Your Order Items</h3>
    <% float sum = 0; %>

    <div class="order-list">
        <% ArrayList<orderhistory> list = (ArrayList<orderhistory>)session.getAttribute("HistoryList"); 
        for(orderhistory e : list) { %>
            <div class="order-item">
                <span class="order-id">Order ID: <%= e.getOrdeId() %></span>
                <span class="order-status"><%= e.getStatus() %></span>
                <span class="order-amount">$<%= e.getTotalAmount() %></span>
                <span class="order-date"><%= e.getOrddate() %></span>
                <a class="view-details" href="orderitemHistory?OrderId=<%= e.getOrdeId()%>">View Details</a>
                <% sum += e.getTotalAmount(); %>
            </div>
        <% } %>
    </div>

    <div class="total-amount">
        Total Amount: <span>$<%= sum %></span>
    </div>
</body>
</html>
