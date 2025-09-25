package org.example.ufocall.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.state.State;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameFlow flow = getFlow(session);

        State state = flow.getCurrentState();
        state.process(request);
        request.getRequestDispatcher(state.getPage()).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameFlow flow = (GameFlow) session.getAttribute("flow");

        String nextKey = request.getParameter("next");
        if (nextKey != null) {
            flow.transition(nextKey);
        }

        State state = flow.getCurrentState();
        state.process(request);
        request.getRequestDispatcher(state.getPage()).forward(request, response);
    }

    private GameFlow getFlow(HttpSession session) {
        GameFlow flow = (GameFlow) session.getAttribute("flow");

        if (flow == null) {
            flow = new GameFlow();
            session.setAttribute("flow", flow);
        }

        return flow;
    }
}
