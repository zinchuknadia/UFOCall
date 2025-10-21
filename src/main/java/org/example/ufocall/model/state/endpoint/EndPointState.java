package org.example.ufocall.model.state.endpoint;

import jakarta.servlet.http.HttpServletRequest;
import org.example.ufocall.model.state.State;
import org.example.ufocall.servlet.GameServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EndPointState implements State {
    private static final Logger logger = LoggerFactory.getLogger(EndPointState.class);
    protected String outcome;
    protected String message;

    public String getOutcome() {
        logger.info(outcome);
        return outcome;
    }

    public String getMessage() {
        logger.info(message);
        return message;
    }

    @Override
    public String getPage() {
        return "/endpoint.jsp";
    }

    @Override
    public void process(HttpServletRequest request) {
        logger.debug("Outcome and message set for request");
        request.setAttribute("outcome", getOutcome());
        request.setAttribute("message", getMessage());
    }
}
