package org.craftedsw.tripservicekata;

import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.craftedsw.tripservicekata.trip.TripService;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class Main {

    public static void main(String[] args)  {
    	UserSession.UserSessionService userSessionService = UserSession.UserSessionService.getInstance();
    	TripService tripService = new TripService(userSessionService);

        try {
            tripService.getTripsByUser(new User());
        } catch (UserNotLoggedInException e) {
            throw new RuntimeException(e);
        }
    }
}
