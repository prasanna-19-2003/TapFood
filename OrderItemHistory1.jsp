<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tapfood.model.orderitem" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Item Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f7ff; 
        margin: 0;
        padding: 20px;
    }

    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        height: 100vh;
    }

    .order-item-card {
        background-color: #ffffff;
        border: 2px solid #0056b3; 
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 50%;
    }

    .order-item-card p {
        margin: 10px 0;
        font-size: 16px;
    }

    .order-item-card p span {
        font-weight: bold;
        color: #0056b3; 
    }
</style>
</head>
<body>
    <div class="container">
        <% orderitem ot = (orderitem) session.getAttribute("OrderItem"); %>
        <% if (ot != null) { %>
            <div class="order-item-card">
                <p><span>Menu ID:</span> <%= ot.getMenId() %></p>
                <p><span>Order ID:</span> <%= ot.getOrderId() %></p>
                <p><span>Order Item ID:</span> <%= ot.getOrderitemId() %></p>
                <p><span>Quantity:</span> <%= ot.getQuantity() %></p>
                <p><span>Subtotal:</span> $<%= ot.getSubtotal() %></p>
            </div>
        <% } else { %>
            <p>No order item found.</p>
        <% } %>
    </div>
</body>
</html>
