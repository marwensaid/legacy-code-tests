package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TripServiceTest {

    @Mock
    private UserSession userSessionMock;

    @Mock
    private TripDAO tripDAOMock;

    @InjectMocks
    private TripService tripService;

    private User loggedUser;
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loggedUser = new User();
        user = new User();
    }

    @Test
    public void should_return_no_trips_when_users_are_not_friends() {
        User user = new User();
        user.addTrip(new Trip());

        when(userSessionMock.getLoggedUser()).thenReturn(loggedUser);
        when(tripDAOMock.findTripsByUser(user)).thenReturn(user.trips());

        assertEquals(0, tripService.getTripsByUser(user).size());
    }

    @Test
    public void should_return_trips_when_users_are_friends() {
        User user = new User();
        user.addTrip(new Trip());
        user.addFriend(loggedUser);

        when(userSessionMock.getLoggedUser()).thenReturn(loggedUser);
        when(tripDAOMock.findTripsByUser(user)).thenReturn(user.trips());

        assertEquals(1, tripService.getTripsByUser(user).size());
    }
}

