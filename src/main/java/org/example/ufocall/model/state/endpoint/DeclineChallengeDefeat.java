package org.example.ufocall.model.state.endpoint;

public class DeclineChallengeDefeat extends EndPointState {
    public DeclineChallengeDefeat() {
        this.outcome = "Defeat";
        this.message = "You rejected the challenge.";
    }
}
