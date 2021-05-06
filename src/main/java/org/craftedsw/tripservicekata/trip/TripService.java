package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip>  logged(User user,User l) {
		List<Trip> tripList = new ArrayList<Trip>();
		boolean isFriend = false;
		if (l != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(l)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		
		User loggedUser = UserSession.getInstance().getLoggedUser();
		return logged(user,loggedUser);
		
	}
	
}
