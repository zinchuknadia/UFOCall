package org.example.ufocall.utils;

import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;
import org.example.ufocall.model.state.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameService {
    private static final Logger logger = LoggerFactory.getLogger(GameService.class);

    public static void changeState(User user, String nextKey) {
        GameFlow flow = user.getGameFlow();
        if (nextKey != null) {
            flow.transition(nextKey);
            logger.info("Changed state to {}", nextKey);
        }
    }

    public static State getState(User user) {
        return user.getGameFlow().getCurrentState();
    }

    public static String getStatePage(User user) {
        String page = user.getGameFlow().getCurrentState().getPage();
        logger.debug("page {}", page);
        return page;
    }
}
