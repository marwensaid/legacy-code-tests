package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for User class
 */
public class UserTest {

    private User user;

    /** Set up the test by creating a new User object before each test case */
    @BeforeEach
    void setUp() {
        user = new User();
    }

    /** Test the addFriend() method by adding a new friend to the user's friends list
     * and asserting that the list contains the new friend */
    @Test
    void testAddFriend() {
        User friend = new User();
        user.addFriend(friend);
        List<User> friends = user.getFriends();
        assertTrue(friends.contains(friend));
    }

    /** Test the addTrip() method by adding a new trip to the user's trips
     * list and asserting that the list contains the new trip */
    @Test
    void testAddTrip() {
        Trip trip = new Trip();
        user.addTrip(trip);
        List<Trip> trips = user.trips();
        assertTrue(trips.contains(trip));
    }

    /** Test the getFriends() method by adding two friends to the user's friends list
     * and asserting that the list contains both friends */
    @Test
    void testGetFriends() {
        User friend1 = new User();
        User friend2 = new User();
        user.addFriend(friend1);
        user.addFriend(friend2);
        List<User> friends = user.getFriends();
        assertEquals(2, friends.size());
        assertTrue(friends.contains(friend1));
        assertTrue(friends.contains(friend2));
    }

    /** Test the trips() method by adding two trips to the user's trips list
     * and asserting that the list contains both trips */
    @Test
    void testTrips() {
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();
        user.addTrip(trip1);
        user.addTrip(trip2);
        List<Trip> trips = user.trips();
        assertEquals(2, trips.size());
        assertTrue(trips.contains(trip1));
        assertTrue(trips.contains(trip2));
    }
}
