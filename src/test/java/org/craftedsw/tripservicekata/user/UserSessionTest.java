package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSessionTest {

    @Test
    public void testGetInstance() {
        UserSession userSession1 = UserSession.getInstance();
        UserSession userSession2 = UserSession.getInstance();
        assertNotNull(userSession1);
        assertNotNull(userSession2);
        assertSame(userSession1, userSession2);
    }

}