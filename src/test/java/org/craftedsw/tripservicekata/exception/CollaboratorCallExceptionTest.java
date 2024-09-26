package org.craftedsw.tripservicekata.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CollaboratorCallExceptionTest {

    @Test
    public void shouldThrowExceptionWithMessage() {
        try {
            throw new CollaboratorCallException("Collaborator call exception message");
        } catch (CollaboratorCallException ex) {
            assertEquals("Collaborator call exception message", ex.getMessage());
            return;
        }
    }
    
    @Test
    public void testCollaboratorCallExceptionWithMessage() {
        String message = "This is an error message";
        CollaboratorCallException exception = new CollaboratorCallException(message);
        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    public void testCollaboratorCallExceptionWithCause() {
        Throwable cause = new Exception("This is the cause");
        CollaboratorCallException exception = new CollaboratorCallException(cause);
        assertEquals(cause, exception.getCause());
    }


    @Test
    public void testCollaboratorCallExceptionWithMessageAndCause() {
        String message = "This is an error message";
        Exception cause = new Exception("This is the cause");
        CollaboratorCallException exception = new CollaboratorCallException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testCollaboratorCallExceptionDefault() {
        CollaboratorCallException exception = new CollaboratorCallException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }
}
