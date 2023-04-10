package org.craftedsw.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripDAO;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.UserSession;
import org.craftedsw.tripservicekata.user.UserSession.UserSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;

public class TripServiceTest {
	private UserSessionService sessionService;
	private TripService tripService;

	@Mock 
	private TripDAO tripDAO;
	
	@BeforeEach
	public void setUp() {
		sessionService = mock(UserSessionService.class);
		tripDAO = mock(TripDAO.class);
		tripService = new TripService(sessionService, tripDAO);
	}

	@Test
	public void should_throw_exception_when_user_is_not_logged_in() {
		// arrange
		when(sessionService.getLoggedUser()).thenReturn(null);
		User user = new User();
		
		// act & assert
		assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(user));
		verify(sessionService, times(1)).getLoggedUser();
	}

	@Test
	public void should_return_empty_trip_list_when_users_are_not_friends() {
		// arrange
		User user = new User();
		User friend = new User();
		friend.addTrip(new Trip());
		user.addFriend(friend);
		
		when(sessionService.getLoggedUser()).thenReturn(new User());
		
		// act
		List<Trip> trips = tripService.getTripsByUser(user);
		
		// assert
		assertEquals(0, trips.size());
	}

	@Test
	public void should_return_trip_list_when_users_are_friends() {
		// arrange
		User user = new User();
		User friend = new User();
		friend.addTrip(new Trip());
		user.addFriend(friend);
		
		given(sessionService.getLoggedUser()).willReturn(friend);
		given(tripDAO.tripsByUser(user)).willReturn(friend.trips());
		
		// act
		List<Trip> trips = tripService.getTripsByUser(user);
		
		// assert
		assertEquals(1, trips.size());
	}

}

