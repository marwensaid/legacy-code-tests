package org.craftedsw.tripservicekata.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    private User friend;
    private User stranger;
    private Trip friendTrip;
    private Trip strangerTrip;

    @BeforeEach
    public void setUp() {
        user = new User();
        friend = new User();
        stranger = new User();
        friendTrip = new Trip();
        strangerTrip = new Trip();
    }

    @Test
    public void testAddFriend() {
        user.addFriend(friend);
        assertTrue(user.getFriends().contains(friend));
    }

    @Test
    public void testAddTrip() {
        user.addTrip(friendTrip);
        assertTrue(user.trips().contains(friendTrip));
    }

    @Test
    public void testGetFriends() {
        user.addFriend(friend);
        user.addFriend(stranger);
        List<User> friends = user.getFriends();
        assertEquals(2, friends.size());
        assertTrue(friends.containsAll(Arrays.asList(friend, stranger)));
    }

    @Test
    public void testGetTrips() {
        user.addTrip(friendTrip);
        user.addTrip(strangerTrip);
        List<Trip> trips = user.trips();
        assertEquals(2, trips.size());
        assertTrue(trips.containsAll(Arrays.asList(friendTrip, strangerTrip)));
    }
}
