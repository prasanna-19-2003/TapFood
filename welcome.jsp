<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tapfood.model.user" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8; 
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h3 {
            color: #3498db;
            margin: 0;
            font-size: 36px; 
        }
        p {
            color: #333; 
            font-size: 18px; 
        }
        .link {
            margin-top: 20px;
        }
        .link a {
            text-decoration: none;
            color: #3498db; 
            font-size: 18px;
            transition: color 0.3s ease;
        }
        .link a:hover {
            color: #2980b9; 
        }
    </style>
</head>
<body>

<div class="container">
    <h3>REGISTRATION SUCCESSFUL</h3>
    <p>Your account has been created successfully.</p>
    <div class="link">
        <a href="Login.jsp">Go to Login</a>
    </div>
</div>

</body>
</html>
