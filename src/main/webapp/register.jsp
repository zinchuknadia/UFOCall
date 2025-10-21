<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    org.example.ufocall.model.User user = (org.example.ufocall.model.User) session.getAttribute("user");
%>
<html>
<head>
    <title>Реєстрація</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 400px;
        }

        h2 {
            margin-bottom: 25px;
            font-size: 24px;
        }

        .info {
            font-size: 18px;
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 12px;
            width: 100%;
            font-size: 16px;
            margin-bottom: 25px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        button {
            padding: 12px 24px;
            font-size: 16px;
            background-color: black;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        button:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Реєстрація гравця</h2>

    <form method="post" action="register">
        <c:if test="${not empty user}">
            <div class="info">Ігор зіграно: <strong>${user.gamesPlayed}</strong></div>
        </c:if>

        <input type="text" name="userName"
               value="${user.name}" placeholder="Ваше ім’я" required/>

        <button type="submit">Почати гру</button>
    </form>
</div>
</body>
</html>
