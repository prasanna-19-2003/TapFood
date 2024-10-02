<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfood.model.Cart" %>
<%@ page import="com.tapfood.model.CartItem" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Your Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9; 
            margin: 0;
            padding: 20px;
            color: #333;
        }

        .cart-container {
            max-width: 800px;
            margin: auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h3 {
            color: #333;
            margin: 10px 0;
        }

        .cart-item {
            border-bottom: 1px solid #e0e0e0;
            padding: 10px 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .item-subtotal {
            text-align: right;
        }

        .order-form {
            margin-top: 20px;
            padding: 15px;
            background-color: #f0f8ff; 
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .order-form input[type="text"],
        .order-form select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .order-form input[type="submit"] {
            background-color: #3498db; 
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .order-form input[type="submit"]:hover {
            background-color: #2980b9; 
        }

        .card-details {
            display: none; 
            margin-top: 10px;
            padding: 15px;
            background-color: #e0f7fa; 
            border-radius: 5px;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
    <script>
        function toggleCardDetails(paymentMode) {
            const cardDetails = document.getElementById('card-details');
            if (paymentMode === 'Credit Card' || paymentMode === 'Debit Card') {
                cardDetails.style.display = 'block'; 
            } else {
                cardDetails.style.display = 'none'; 
                clearCardInputs(); 
            }
        }

        function clearCardInputs() {
            document.getElementById('cardNumber').value = '';
            document.getElementById('expirationDate').value = '';
            document.getElementById('cvv').value = '';
        }

        function validateForm(event) {
            const cardNumber = document.getElementById('cardNumber').value;
            const expirationDate = document.getElementById('expirationDate').value;
            const cvv = document.getElementById('cvv').value;
            const errorMessage = document.getElementById('error-message');

            errorMessage.innerHTML = ''; 

            if ((document.querySelector('select[name="paymentMode"]').value === 'Credit Card' || 
                document.querySelector('select[name="paymentMode"]').value === 'Debit Card') && 
                (!cardNumber || !expirationDate || !cvv)) {
                
                errorMessage.innerHTML = 'Please fill in all card details.';
                event.preventDefault(); 
                return;
            }

            if (cardNumber.length < 16 || isNaN(cardNumber)) {
                errorMessage.innerHTML += 'Card number must be 16 digits long.<br>';
                event.preventDefault(); 
            }

            if (cvv.length < 3 || cvv.length > 4 || isNaN(cvv)) {
                errorMessage.innerHTML += 'CVV must be 3 or 4 digits long.<br>';
                event.preventDefault(); 
            }

            const currentDate = new Date();
            const [month, year] = expirationDate.split('/').map(Number);

            if (isNaN(month) || isNaN(year) || month < 1 || month > 12) {
                errorMessage.innerHTML += 'Invalid month. Please enter a valid expiration date (MM/YY).<br>';
                event.preventDefault(); 
                return;
            }

           
            const fullYear = 2000 + year; 
            const isExpired = (fullYear < currentDate.getFullYear() || 
                               (fullYear === currentDate.getFullYear() && month < currentDate.getMonth() + 1));

            if (isExpired) {
                errorMessage.innerHTML += 'The expiration date cannot be in the past.<br>';
                event.preventDefault(); 
            }
        }
    </script>
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
                                <h3>Item Name: <%= cartItem.getName() %></h3>
                                <h3>Item Price: $<%= cartItem.getPrice() %></h3>
                                <h3>Quantity: <%= cartItem.getQuantity() %></h3>
                            </div>
                            <div class="item-subtotal">
                                <h3>Subtotal: $<%= cartItem.getQuantity() * cartItem.getPrice() %></h3>
                            </div>
                        </div>
        <% 
                    }
                } else {
                    out.println("<h3>Your cart is empty.</h3>");
                }
            } else { 
                out.println("<h3>Your cart is empty.</h3>");
            } 
        %>
        
        <div class="order-form">
            <h3>Enter Your Shipping Address and Payment Mode</h3>
            <form action="ConfirmOrderServlet" method="post" onsubmit="validateForm(event)">
                <input type="text" name="address" placeholder="Enter your address" required>
                <select name="paymentMode" onchange="toggleCardDetails(this.value)" required>
                    <option value="">Select Payment Mode</option>
                    <option value="Credit Card">Credit Card</option>
                    <option value="Debit Card">Debit Card</option>
                    <option value="PayPal">PayPal</option>
                    <option value="Cash on Delivery">Cash on Delivery</option>
                </select>

                <div id="card-details" class="card-details">
                    <input type="text" id="cardNumber" name="cardNumber" placeholder="Card Number" required>
                    <input type="text" id="expirationDate" name="expirationDate" placeholder="MM/YY" required pattern="\d{2}/\d{2}" title="Format: MM/YY">
                    <input type="text" id="cvv" name="cvv" placeholder="CVV" required>
                </div>

                <div id="error-message" class="error-message"></div>
                <input type="submit" value="Confirm Order">
            </form>
        </div>
    </div>
</body>
</html>
