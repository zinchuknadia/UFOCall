package org.example.ufocall.model.state.game;

import java.util.Map;

public class LosingMemory extends GameState {

    @Override
    public String getQuestion() {
        return "Ви втрачаєте пам'ять. Прийняти виклик НЛО?";
    }

    @Override
    public Map<String, String> getOptions() {
        return Map.of("acceptChallenge", "acceptChallenge",
                "rejectChallenge", "declineChallengeDefeat");
    }
}
