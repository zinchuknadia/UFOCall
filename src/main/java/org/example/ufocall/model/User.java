package org.example.ufocall.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    private String name;
    private int gamesPlayed = 0;
    private GameFlow gameFlow;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
        logger.debug("Incremented gamesPlayed {}", this.gamesPlayed);
    }

    public GameFlow getGameFlow() {
        return gameFlow;
    }

    public void setGameFlow(GameFlow gameFlow) {
        this.gameFlow = gameFlow;
    }
}
