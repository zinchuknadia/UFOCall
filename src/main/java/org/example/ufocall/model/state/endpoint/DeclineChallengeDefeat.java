package org.example.ufocall.model.state.endpoint;

public class DeclineChallengeDefeat extends EndPointState {
    public DeclineChallengeDefeat() {
        this.outcome = "Поразка";
        this.message = "Ви відхилили виклик.";
    }
}
