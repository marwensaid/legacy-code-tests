package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserNotLoggedInExceptionTest {

    @Test
    public void testConstructor() {
        UserNotLoggedInException exception = assertThrows(UserNotLoggedInException.class, () -> {
            throw new UserNotLoggedInException();
        });
    }
}
