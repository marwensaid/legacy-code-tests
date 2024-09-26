package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;

public class UserSession {

	private static final UserSession userSession = new UserSession();

	private UserSession() {
	}

	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		return UserSessionService.getInstance().getLoggedUser();
	}

	public static class UserSessionService {
		private static UserSessionService userSessionService = new UserSessionService();

		private UserSessionService() {
		}

		public static UserSessionService getInstance() {
			return userSessionService;
		}

		public User getLoggedUser() {
			throw new CollaboratorCallException(
					"UserSessionService.getLoggedUser() should not be called in an unit test");
		}
		
	}
}
