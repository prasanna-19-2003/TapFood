<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfood.model.Cart" %>
<%@ page import="com.tapfood.model.CartItem" %>
<%@ page import="java.util.Map" %>

<%
    // Prevent caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); 
    response.setDateHeader("Expires", 0); 

    session = request.getSession(false);
    if (session == null || session.getAttribute("loginUser") == null) {
        response.sendRedirect("Login.jsp"); 
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e9f3fc; 
            margin: 0;
            padding: 20px;
        }
        .cart-container {
            background-color: #ffffff; 
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            margin: auto;
        }
        .cart-item {
            border-bottom: 1px solid #007BFF; 
            padding: 10px 0;
        }
        .item-info {
            margin-bottom: 10px;
        }
        h3 {
            margin: 0 0 5px 0;
            color: #0056b3; 
        }
        .item-subtotal {
            font-weight: bold;
            color: #333;
        }
        .cart-empty {
            text-align: center;
            color: #777;
            font-size: 18px;
            margin: 20px 0;
        }
        .btn {
            background-color: #007BFF; 
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease; 
        }
        .btn:hover {
            background-color: #0056b3; 
        }
        form {
            display: flex;
            align-items: center;
        }
        input[type="number"] {
            width: 60px;
            margin-right: 10px;
            padding: 5px;
            border: 1px solid #007BFF; 
            border-radius: 4px;
        }
        input[type="submit"] {
            margin-right: 10px;
            background-color: #007BFF; 
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease; 
        }
        input[type="submit"]:hover {
            background-color: #0056b3; 
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <% 
            Cart cart = (Cart) session.getAttribute("cart"); 
            if (cart != null) {
                Map<Integer, CartItem> cartItems = cart.getItems();
                if (cartItems != null && !cartItems.isEmpty()) {
                    for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                        CartItem cartItem = entry.getValue();
        %>
                        <div class="cart-item">
                            <div class="item-info">
                                <h3>Item Id: <%= cartItem.getMenuId() %></h3>
                                <h3>Item Name: <%= cartItem.getName() %></h3>
                                <h3>Item Price: $<%= cartItem.getPrice() %></h3>
                                <h3>Quantity: 
                                    <form action="cart" style="display: inline;">
                                        <input type="hidden" name="itemId" value="<%= cartItem.getMenuId() %>">
                                        <input type="number" name="quantity" value="<%= cartItem.getQuantity() %>" min="1">
                                        <input type="submit" name="action" value="update">
                                        <input type="submit" name="action" value="remove">
                                    </form>
                                </h3>
                            </div>
                            <div class="item-subtotal">
                                <h3>Subtotal: $<%= cartItem.getQuantity() * cartItem.getPrice() %></h3>
                            </div>
                        </div>
        <% 
                    }
                } else { 
        %>
                    <p class="cart-empty">Your cart is empty.</p>
        <% 
                } 
            } else { 
        %>
                <p class="cart-empty">Your cart is empty.</p>
        <% 
            } 
        %>
        <div>
        <%
            if (session.getAttribute("cart") != null) {
        %>
            <form action="checkout.jsp">
                <input type="submit" value="Proceed to Checkout" class="btn proceed-to-check-btn">
            </form>
        <% 
            } 
        %>
        </div>
    </div>
</body>
</html>
