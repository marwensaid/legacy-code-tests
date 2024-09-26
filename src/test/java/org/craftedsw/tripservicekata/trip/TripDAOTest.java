package org.craftedsw.tripservicekata.trip;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripDAOTest {

    private TripDAO tripDao;
    
    @BeforeEach
    public void setUp() {
        tripDao = new TripDAO();
    }
    
    @Test
    @DisplayName("Should throw CollaboratorCallException when findTripsByUser is invoked")
    public void shouldThrowCollaboratorCallException_whenFindTripsByUserIsInvoked() {
        // given
        User user = new User();
        
        // when & then
        CollaboratorCallException exception = assertThrows(CollaboratorCallException.class, () -> {
            TripDAO.findTripsByUser(user);
        });
        
        assertThat(exception.getMessage(), containsString("TripDAO should not be invoked on an unit test."));
    }
}
