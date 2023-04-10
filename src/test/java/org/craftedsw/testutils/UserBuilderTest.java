package org.craftedsw.testutils;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

public class UserBuilderTest {

    @Test
    public void buildUserWithFriendsAndTrips() {
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();

        User friend1 = new User();
        User friend2 = new User();

        User user = new UserBuilder()
                        .withTrips(trip1, trip2)
                        .withFriends(friend1, friend2)
                        .build();

        assertEquals(2, user.getFriends().size());
        assertEquals(2, user.trips().size());
    }
}
