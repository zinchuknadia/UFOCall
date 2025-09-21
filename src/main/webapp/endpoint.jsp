<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${state.outcome}</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; text-align: center; }
        .outcome { font-size: 28px; margin-bottom: 20px; color: #c00; }
        .message { font-size: 20px; margin-bottom: 30px; }
        .restart { background: black; color: white; padding: 10px 20px; border: none; cursor: pointer; text-decoration: none; }
    </style>
</head>
<body>

<div class="outcome">${state.outcome}</div>
<div class="message">${state.message}</div>

<a href="game" class="restart">Почати знову</a>

</body>
</html>
