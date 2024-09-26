package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.UserSession.UserSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserSessionTest {

    private UserSession userSession;

    @BeforeEach
    public void setUp() {
        userSession = UserSession.getInstance();
    }

    
    @Test
    public void getLoggedUser_should_throw_CollaboratorCallException_when_called_from_unit_test() {
        // Act and Assert
        assertThrows(CollaboratorCallException.class, () -> userSession.getLoggedUser());
    }
   

    @Test
    public void UserSessionService_getLoggedUser_should_throw_CollaboratorCallException_when_called_from_unit_test() {
        // Act and Assert
        assertThrows(CollaboratorCallException.class, () -> UserSessionService.getInstance().getLoggedUser());
    }
    
    
}
