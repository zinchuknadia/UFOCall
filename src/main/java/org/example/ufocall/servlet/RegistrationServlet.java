package org.example.ufocall.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;
import org.example.ufocall.utils.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        if (UserService.userExists(user)) {
            req.setAttribute("userName", user.getName());
            logger.debug("User name set to {}", user.getName());
        }

        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        String userName = req.getParameter("userName");

        user = validateUser(user, userName);
        UserService.setNewGame(user);

        session.setAttribute("user", user);
        resp.sendRedirect("game");
    }

    private User validateUser(User user, String userName) {
        try {
            UserService.userValidate(user, userName);
        }catch (Exception e) {
            logger.debug(e.getMessage());
            user = UserService.createUser(userName);
            logger.info("New user created");
        }
        return user;
    }
}
