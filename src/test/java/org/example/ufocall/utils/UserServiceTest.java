package org.example.ufocall.utils;

import org.example.ufocall.exeption.UserValidationException;
import org.example.ufocall.model.GameFlow;
import org.example.ufocall.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void shouldCreateUser() {
        String userName = "John";

        User expectedUser = new User();
        expectedUser.setName(userName);

        User actualUser = UserService.createUser(userName);

        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getGamesPlayed(), actualUser.getGamesPlayed());
    }

    @Test
    void shouldValidateUser_WhenUserIsNull() {
        Throwable exception = assertThrows(UserValidationException.class,
                () -> UserService.userValidate(null, null));
        assertEquals("User does not exist", exception.getMessage());
    }

    @Test
    void shouldValidateUser_WhenUserNameIsNull() {
        User user = new User();
        Throwable exception = assertThrows(UserValidationException.class,
                () -> UserService.userValidate(user, null));
        assertEquals("User name not initialized", exception.getMessage());
    }

    @Test
    void shouldValidateUser_WhenUserNameDifferent() {
        User user = new User();
        user.setName("John");
        String differentName = "Doe";

        Throwable exception = assertThrows(UserValidationException.class,
                () -> UserService.userValidate(user, differentName));
        assertEquals("User name not valid", exception.getMessage());
    }

    @Test
    void checkIfUserExists() {
        assertFalse(UserService.userExists(null));

        User user = new User();
        assertFalse(UserService.userExists(user));

        user.setName("John");
        assertTrue(UserService.userExists(user));
    }

    @Test
    void shouldSetNewGame() {
        User user = new User();
        user.setGameFlow(new GameFlow());
        user.incrementGamesPlayed();

        User actualUser = new User();
        UserService.setNewGame(actualUser);

        assertEquals(user.getGamesPlayed(), actualUser.getGamesPlayed());
        assertEquals(user.getGameFlow().getCurrentStateKey(), actualUser.getGameFlow().getCurrentStateKey());
    }
}