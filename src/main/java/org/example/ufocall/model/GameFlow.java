package org.example.ufocall.model;

import org.example.ufocall.model.state.State;
import org.example.ufocall.model.state.endpoint.*;
import org.example.ufocall.model.state.game.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GameFlow {
    private static final Logger logger = LoggerFactory.getLogger(GameFlow.class);
    private String currentStateKey;
    private Map<String, State> states;

    public GameFlow() {
        states = new HashMap<>();

        states.put("losingMemory", new LosingMemory());
        states.put("acceptChallenge", new AcceptChallenge());
        states.put("onBridgeIdentity", new OnBridgeIdentity());
        states.put("declineChallengeDefeat", new DeclineChallengeDefeat());
        states.put("refuseBridgeDefeat", new RefuseBridgeDefeat());
        states.put("lieDefeat", new LieDefeat());
        states.put("truthVictory", new TruthVictory());

        currentStateKey = "losingMemory";
    }

    public State getCurrentState() {
        return states.get(currentStateKey);
    }

    public String getCurrentStateKey() {
        return currentStateKey;
    }

    public void transition(String nextKey) {
        logger.debug("Changing state from {} to {}", currentStateKey, nextKey);
        currentStateKey = nextKey;
    }
}
