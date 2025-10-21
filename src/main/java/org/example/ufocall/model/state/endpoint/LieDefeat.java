package org.example.ufocall.model.state.endpoint;

public class LieDefeat extends EndPointState {
    public LieDefeat() {
        this.outcome = "Defeat";
        this.message = "Your lie was exposed.";
    }
}
