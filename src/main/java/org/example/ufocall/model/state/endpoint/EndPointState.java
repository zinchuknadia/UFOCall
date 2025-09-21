package org.example.ufocall.model.state.endpoint;

import jakarta.servlet.http.HttpServletRequest;
import org.example.ufocall.model.state.State;

public abstract class EndPointState implements State {
    protected String outcome;
    protected String message;

    public String getOutcome() {
        return outcome;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getPage() {
        return "/endpoint.jsp";
    }

    @Override
    public void process(HttpServletRequest request) {
        request.setAttribute("outcome", getOutcome());
        request.setAttribute("message", getMessage());
    }
}
