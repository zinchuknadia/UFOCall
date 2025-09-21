package org.example.ufocall.model.state.game;

import java.util.Map;

public class OnBridgeIdentity extends QuestionState {
    @Override
    public String getQuestion() {
        return "Ви піднялися на капітанський місток. Хто ви?";
    }

    @Override
    public Map<String, String> getOptions() {
        return Map.of("tellTruth", "truthVictory",
                "lie", "lieDefeat");
    }
}
