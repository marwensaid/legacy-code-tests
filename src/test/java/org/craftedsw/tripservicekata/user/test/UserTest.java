package org.craftedsw.tripservicekata.user.test;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.craftedsw.tripservicekata.user.test.UserBuilder.aUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserTest {

	private static final User BOB  = new User();
	private static final User PAUL = new User();

	@Test
	public void
	should_inform_when_users_are_not_friends() {
		 User user = aUser()
				 		.friendsWith(BOB)
				 		.build();
		 
		assertThat(user.isFriendsWith(PAUL), is(false));		 		
	}

	@Test public void 
	should_inform_when_users_are_friends() {
		User user = aUser()
				.friendsWith(BOB, PAUL)
				.build();
		
		assertThat(user.isFriendsWith(PAUL), is(true));		 				 
	}
	
}
