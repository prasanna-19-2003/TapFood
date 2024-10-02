<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order Confirmation</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
            margin: 0;
            background-color: #e6f7ff; 
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #0056b3; 
            font-size: 36px;
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        input[type="submit"] {
            background-color: #007bff; 
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3; 
        }
    </style>
</head>
<body>
    <h1>Your Order has been Placed!</h1>
    
    <form action="history">
        <input type="submit" value="Show History Details">
    </form>
</body>
</html>
