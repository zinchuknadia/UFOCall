package org.example.ufocall.utils;

import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;
import org.example.ufocall.model.state.State;
import org.example.ufocall.model.state.game.LosingMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    @Test
    public void shouldChangeState() {
        User user = new User();
        user.setGameFlow(new GameFlow());

        String nextStateKey = "onBridgeIdentity";
        GameService.changeState(user, nextStateKey);

        String newStateKey = user.getGameFlow().getCurrentStateKey();
        assertNotEquals("losingMemory", newStateKey);
        assertEquals(nextStateKey, newStateKey);
    }

    @Test
    public void shouldNotChangeState() {
        User user = new User();
        user.setGameFlow(new GameFlow());
        String previousStateKey = user.getGameFlow().getCurrentStateKey();

        String nextStateKey = null;
        GameService.changeState(user, nextStateKey);

        String stateKey = user.getGameFlow().getCurrentStateKey();

        assertNotEquals(nextStateKey, stateKey);
        assertEquals(previousStateKey, stateKey);
    }

    @Test
    public void shouldGetState() {
        User user = new User();
        user.setGameFlow(new GameFlow());

        State losingMemory = new LosingMemory();
        State gameState = GameService.getState(user);

        assertEquals(losingMemory.getClass(), gameState.getClass());
    }

    @Test
    public void shouldGetStatePage() {
        User user = new User();
        user.setGameFlow(new GameFlow());

        String page = "/question.jsp";
        String gamePage = GameService.getStatePage(user);

        assertEquals(page, gamePage);
    }
}