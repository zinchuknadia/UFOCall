<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Quest Game</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .question { font-size: 20px; margin-bottom: 15px; }
    .answers { margin-bottom: 20px; }
    .stats { background: #e0f8ff; padding: 10px; border-radius: 5px; }
    button { background: black; color: white; padding: 8px 15px; border: none; cursor: pointer; }
  </style>
</head>
<body>

<!-- Question -->
<div class="question">
  ${question.text}
</div>

<!-- Form with answers -->
<form action="answer" method="post">
  <div class="answers">
    <c:forEach var="answer" items="${question.answers}">
      <label>
        <input type="radio" name="choice" value="${answer.id}" required>
          ${answer.text}
      </label><br/>
    </c:forEach>
  </div>
  <button type="submit">Відповісти</button>
</form>

<!-- Stats -->
<div class="stats">
  <strong>Statistics</strong><br/>
  IP Address: ${stats.ip}<br/>
  Nickname: ${stats.nickname}<br/>
  Game counter: ${stats.counter}
</div>

</body>
</html>
