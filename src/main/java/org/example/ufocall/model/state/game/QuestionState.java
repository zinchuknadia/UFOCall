package org.example.ufocall.model.state.game;

import jakarta.servlet.http.HttpServletRequest;
import org.example.ufocall.model.state.State;

import java.util.Map;

public abstract class QuestionState implements State {
    private final String page = "/question.jsp";

    @Override
    public String getPage() {
        return page;
    }

    public abstract String getQuestion();
    public abstract Map<String, String> getOptions();

    @Override
    public void process(HttpServletRequest request) {
        request.setAttribute("question", getQuestion());
        request.setAttribute("options", getOptions());
    }
}
