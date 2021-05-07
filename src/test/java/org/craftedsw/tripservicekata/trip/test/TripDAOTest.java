package org.craftedsw.tripservicekata.trip.test;

import org.craftedsw.tripservicekata.exception.DependendClassCallDuringUnitTestException;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.trip.TripDAO;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripDAOTest {
	
	@Test
	public void should_throw_an_exception_when_return_trips_from_user() {

		assertThrows(DependendClassCallDuringUnitTestException.class, () -> {
			new TripDAO().tripsBy(new User());
		});
	}

}
