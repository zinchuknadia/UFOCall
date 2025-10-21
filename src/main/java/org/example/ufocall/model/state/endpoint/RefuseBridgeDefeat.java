package org.example.ufocall.model.state.endpoint;

public class RefuseBridgeDefeat extends EndPointState {
    public RefuseBridgeDefeat() {
        this.outcome = "Defeat";
        this.message = "You didn't go to the negotiations.";
    }
}
