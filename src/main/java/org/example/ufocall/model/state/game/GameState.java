package org.example.ufocall.model.state.game;

import org.example.ufocall.model.state.State;

import java.util.Map;

public abstract class GameState implements State {
    private final String page = "/question.jsp";

    @Override
    public String getPage() {
        return page;
    }

    public abstract String getQuestion();
    public abstract Map<String, String> getOptions();
}
