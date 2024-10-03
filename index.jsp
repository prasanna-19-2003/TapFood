<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Your Website</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0; 
        color: #333; 
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    a {
        text-decoration: none;
        color: white;
        background-color: #007bff; 
        padding: 12px 25px;
        border-radius: 30px;
        margin: 0 15px;
        font-size: 18px;
        font-weight: bold;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s ease, box-shadow 0.3s ease;
    }

    a:hover {
        background-color: #0056b3; 
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2); 
    }
</style>
</head>
<body>
    <a href="Register.jsp">Register</a>
    <a href="Login.jsp">Login</a>
</body>
</html>
