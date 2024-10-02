<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Food Delivery App</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('A_vibrant_and_appealing_background_image_for_a_foo.png'); /* Background image */
            background-size: cover; /* Cover the entire viewport */
            color: white; 
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            text-align: center;
        }

        h1 {
            font-size: 48px;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: rgba(0, 123, 255, 0.8); /* Slightly transparent button */
            padding: 12px 25px;
            border-radius: 30px;
            margin: 10px;
            font-size: 18px;
            font-weight: bold;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, box-shadow 0.3s ease;
        }

        a:hover {
            background-color: rgba(0, 85, 140, 0.8); /* Darker transparent button on hover */
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2); 
        }
    </style>
</head>
<body>
    <h1>Welcome to Our Food Delivery App!</h1>
    <a href="Register.jsp">Register</a>
    <a href="Login.jsp">Login</a>
</body>
</html>
