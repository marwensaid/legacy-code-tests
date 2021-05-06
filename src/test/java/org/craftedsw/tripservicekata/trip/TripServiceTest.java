package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserNotLoggedInException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripServiceTest {

	@Test
	void testExpectedException() {
		
		 Assertions.assertThrows(CollaboratorCallException.class, () -> {
			 User u =new User();
				TripService ts= new TripService();
			    
			    ts.getTripsByUser(u);
			    
			    
			  });

	}
	
	@Test
	void testExpectedException2() {
		
		 Assertions.assertThrows(UserNotLoggedInException.class, () -> {
			 User u =new User();
			TripService ts= new TripService();
			    
			    
			    ts.logged(u,null);
			    
			    
			  });

	}
}
