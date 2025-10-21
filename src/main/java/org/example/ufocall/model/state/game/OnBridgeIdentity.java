package org.example.ufocall.model.state.game;

import java.util.Map;

public class OnBridgeIdentity extends QuestionState {
    @Override
    public String getQuestion() {
        return "You went up the captain's bridge. Who are you?";
    }

    @Override
    public Map<String, String> getOptions() {
        return Map.of("tellTruth", "truthVictory",
                "lie", "lieDefeat");
    }
}
