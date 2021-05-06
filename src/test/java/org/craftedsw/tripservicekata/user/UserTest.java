package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class UserTest {
	@Test
	void testfriend() {
	User u1=new User();
	User u2=new User();
	
	u1.addFriend(u2);
	

	Assertions.assertTrue(u1.getFriends().contains(u2));
	}

	@Test
	void testtrip() {
		
	User u=new User();
	Trip t=new Trip();
	
	u.addTrip(t);
	
	
	Assertions.assertTrue(u.trips().contains(t));
	
	}
}
