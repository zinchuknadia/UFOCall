package org.example.ufocall.model;

public class User {
    private String name;
    private int gamesPlayed = 0;

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
    }
}
