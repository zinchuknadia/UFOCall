package org.example.ufocall.utils;

import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;

public class UserService {
    public static User createUser(String userName) {
        User user = new User();
        user.setName(userName);
        return user;
    }

    public static boolean userValidate(User user, String userName) {
        if (user == null) {
            return false;
        } else if (user.getName() == null) {
            return false;
        } else if (!user.getName().equals(userName)) {
            return false;
        }
        return true;
    }

    public static boolean userExists(User user) {
        if (user == null) {
            return false;
        } else if (user.getName() == null) {
            return false;
        }
        return true;
    }

    public static void setNewGame(User user) {
        GameFlow flow = new GameFlow();
        user.setGameFlow(flow);
        user.incrementGamesPlayed();
    }
}
