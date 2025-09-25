package org.example.ufocall.model.state.game;

import java.util.Map;

public class AcceptChallenge extends QuestionState {
    @Override
    public String getQuestion() {
        return "Ви прийняли виклик. Піднятися на капітанський місток?";
    }

    @Override
    public Map<String, String> getOptions() {
        return Map.of("accept", "onBridgeIdentity",
                "reject", "refuseBridgeDefeat");
    }
}
