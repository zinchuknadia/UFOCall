package org.example.ufocall.model.state;

import jakarta.servlet.http.HttpServletRequest;

public interface State {
    String getPage();
    void process(HttpServletRequest request);
}
