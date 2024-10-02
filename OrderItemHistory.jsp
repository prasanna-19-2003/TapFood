<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tapfood.model.menu" %> 
<%@ page import="com.tapfood.model.orderitem" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu and Order Item Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f7ff; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            border: 2px solid #0056b3; 
        }

        .menu-item, .order-item {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        .menu-item:last-child, .order-item:last-child {
            margin-bottom: 0;
        }

        .label {
            font-weight: bold;
            color: #0056b3; 
        }

        .order-item span {
            color: #007bff; 
        }
    </style>
</head>
<body>
    <div class="container">
        <% orderitem item = (orderitem) session.getAttribute("OrderItem"); %>

        <div class="order-item">
            <span class="label">Quantity:</span>
            <span><%= item.getQuantity() %></span>
        </div>
        
        <div class="order-item">
            <span class="label">Order Item ID:</span>
            <span><%= item.getOrderitemId() %></span>
        </div>
        
        <div class="order-item">
            <span class="label">Menu ID:</span>
            <span><%= item.getMenId() %></span>
        </div>

        <div class="order-item">
            <span class="label">Subtotal:</span>
            <span>$<%= item.getSubtotal() %></span>
        </div>
    </div>
</body>
</html>
