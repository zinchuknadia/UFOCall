package org.example.ufocall.model.state.game;

import java.util.Map;

public class AcceptChallenge extends QuestionState {
    @Override
    public String getQuestion() {
        return "You accepted challenge. Go up to the captain's bridge?";
    }

    @Override
    public Map<String, String> getOptions() {
        return Map.of("accept", "onBridgeIdentity",
                "reject", "refuseBridgeDefeat");
    }
}
