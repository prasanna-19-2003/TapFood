<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #e1bee7, #f3e5f5); 
            color: #333; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            color: #007bff; 
            font-size: 36px;
            margin-bottom: 20px;
        }

        table {
            background-color: #ffffff; 
            border-radius: 15px;
            padding: 25px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.15); 
            width: 350px; 
        }

        td {
            padding: 10px;
            font-size: 18px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc; 
            border-radius: 5px;
            font-size: 16px;
            transition: border 0.3s ease-in-out; 
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007bff; 
            outline: none; 
        }

        input[type="submit"] {
            background-color: #007bff; 
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            width: 100%;
            transition: background-color 0.3s ease, transform 0.2s ease; 
        }

        input[type="submit"]:hover {
            background-color: #0056b3; 
            transform: scale(1.05); 
        }
    </style>
</head>
<body>
    <center>   
        <h1>Login Page</h1> 
        <table>
            <form action="Login" method="post">
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </form>
             <c:if test="${not empty errorMessage}">
            <div class="error-message" style="color: red; margin-top: 10px;">
                ${errorMessage}
            </div>
        </c:if>
        </table>
    </center>
</body>
</html>
