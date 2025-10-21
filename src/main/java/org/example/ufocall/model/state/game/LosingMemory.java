package org.example.ufocall.model.state.game;

import java.util.Map;

public class LosingMemory extends QuestionState {

    @Override
    public String getQuestion() {
        return "You are losing memory. Accept the UFO challenge?";
    }

    @Override
    public Map<String, String> getOptions() {
        return Map.of("acceptChallenge", "acceptChallenge",
                "rejectChallenge", "declineChallengeDefeat");
    }
}
