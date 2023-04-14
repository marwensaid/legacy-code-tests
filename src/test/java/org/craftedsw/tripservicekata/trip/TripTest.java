package org.craftedsw.tripservicekata.trip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripTest {

    @Test
    public void testSetName() {
        Trip trip = new Trip();
        String name = "My trip";
        trip.setName(name);
        assertEquals(name, trip.getName());
    }
}