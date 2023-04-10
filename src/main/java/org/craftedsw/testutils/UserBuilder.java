package org.craftedsw.testutils;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.user.User;

public class UserBuilder {
    private User user = new User();

    public UserBuilder() {}

    public UserBuilder withFriends(User... friends) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
        return this;
    }

    public UserBuilder withTrips(Trip... trips) {
        for (Trip trip : trips) {
            user.addTrip(trip);
        }
        return this;
    }

    public User build() {
        return user;
    }
}