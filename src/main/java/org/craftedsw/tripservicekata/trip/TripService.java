package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.craftedsw.tripservicekata.user.UserSession.UserSessionService;

public class TripService {
	
	private final UserSessionService userSessionService;

	public TripService(UserSessionService userSessionService) {
		this.userSessionService = userSessionService;
	}
	
	
	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		validateUserIsLoggedIn();
        return getTripsForFriend(user);
    }
	
	private List<Trip> getTripsForFriend(User friend) {
    	List<Trip> tripList = new ArrayList<>();
		User loggedUser = userSessionService.getLoggedUser();
		if (isFriend(friend, loggedUser)) {
			tripList = TripDAO.findTripsByUser(friend);
		}
		return tripList;
    }

	private void validateUserIsLoggedIn() {
		if (userSessionService.getLoggedUser() == null) {
			throw new UserNotLoggedInException();
		}
	}

	private boolean isFriend(User user, User loggedUser) {
		for (User friend : user.getFriends()) {
			if (friend.equals(loggedUser)) {
				return true;
			}
		}
		return false;
	}

}
