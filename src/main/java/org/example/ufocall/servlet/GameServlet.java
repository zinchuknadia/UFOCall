package org.example.ufocall.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.ufocall.model.User;
import org.example.ufocall.utils.GameService;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        stateProcessRequest(request, user);
        setUserAttributes(request, user);

        String page = GameService.getStatePage(user);
        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String nextStateKey = request.getParameter("next");
        GameService.changeState(user, nextStateKey);

        stateProcessRequest(request, user);
        setUserAttributes(request, user);

        String page = GameService.getStatePage(user);
        request.getRequestDispatcher(page).forward(request, response);
    }

    private void stateProcessRequest(HttpServletRequest request, User user) {
        GameService.getState(user).process(request);
    }

    private void setUserAttributes(HttpServletRequest request, User user) {
        request.setAttribute("userName", user.getName());
        request.setAttribute("gameCounter", user.getGamesPlayed());
    }
}
