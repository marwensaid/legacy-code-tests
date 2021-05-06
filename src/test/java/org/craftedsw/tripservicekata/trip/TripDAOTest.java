package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripDAOTest {
	
	@Test
	void testExpectedException() {
		
		 Assertions.assertThrows(CollaboratorCallException.class, () -> {
			 	User u= new User();
			    TripDAO.findTripsByUser(u);
			    
			    
			  });

	}

}
