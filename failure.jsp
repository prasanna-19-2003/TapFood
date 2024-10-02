<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Failure</title>
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
        h1 {
            color: #e74c3c; 
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
    <h1>REGISTRATION FAILURE</h1>
    <p>There was an issue with your registration. Please try again.</p>
    <div class="link">
        <a href="Register.jsp">Go Back to Registration</a>
    </div>
</div>

</body>
</html>
