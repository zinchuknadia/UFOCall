package org.example.ufocall;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Question q = new Question();
        q.setText("Ви втрачаєте пам'ять. Прийняти виклик НЛО?");
        q.setAnswers(List.of(
                new Answer("accept", "Прийняти виклик", "captainBridge"),
                new Answer("reject", "Відхилити виклик", "defeat")
        ));

        request.setAttribute("question", q);
        request.setAttribute("stats", Map.of(
                "ip", request.getRemoteAddr(),
                "nickname", "Seismology",
                "counter", 55
        ));

        request.getRequestDispatcher("question.jsp").forward(request, response);
    }

}
