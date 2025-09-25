package org.example.ufocall.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        if (user != null) {
            req.setAttribute("userName", user.getName());
        }

        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GameFlow flow = new GameFlow();
        session.setAttribute("flow", flow);

        User user = (User) session.getAttribute("user");

        if (user == null) {
            String userName = req.getParameter("userName");
            user = new User();
            user.setName(userName);
            session.setAttribute("user", user);
        } else if (!user.getName().equals(req.getParameter("userName"))) {
            User newUser = new User();
            newUser.setName(req.getParameter("userName"));
            session.setAttribute("user", newUser);
        }

        ((User) session.getAttribute("user")).incrementGamesPlayed();
        resp.sendRedirect("game");
    }

}
