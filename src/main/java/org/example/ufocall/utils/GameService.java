package org.example.ufocall.utils;

import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;
import org.example.ufocall.model.state.State;

public class GameService {
    public static void changeState(User user, String nextKey) {
        GameFlow flow = user.getGameFlow();
        if (nextKey != null) {
            flow.transition(nextKey);
        }
    }

    public static State getState(User user) {
        return user.getGameFlow().getCurrentState();
    }

    public static String getStatePage(User user) {
        return user.getGameFlow().getCurrentState().getPage();
    }
}
