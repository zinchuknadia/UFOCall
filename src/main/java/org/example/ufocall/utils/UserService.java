package org.example.ufocall.utils;

import org.example.ufocall.exeption.UserValidationException;
import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static User createUser(String userName) {
        User user = new User();
        user.setName(userName);
        logger.debug("New user with name {}", userName);
        return user;
    }

    public static void userValidate(User user, String userName) throws Exception {
        if (user == null) {
            throw new UserValidationException("User does not exist");
        } else if (user.getName() == null) {
            throw new UserValidationException("User name not initialized");
        } else if (!user.getName().equals(userName)) {
            throw new UserValidationException("User name not valid");
        }
    }

    public static boolean userExists(User user) {
        if (user == null) {
            logger.debug("User does not exist");
            return false;
        } else if (user.getName() == null) {
            logger.debug("User has no name");
            return false;
        }
        return true;
    }

    public static void setNewGame(User user) {
        GameFlow flow = new GameFlow();
        user.setGameFlow(flow);
        user.incrementGamesPlayed();
        logger.debug("{} game initialized for user {}", user.getGamesPlayed(), user.getName());
    }
}
