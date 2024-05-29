package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerConstructorTest {


    @Test
    public void testManagerConstructorValidInput() { // PASSED
        //Positive test case
        String id = "1";
        String name = "Alice Smith";
        String contactDetails = "alice.smith@example.com";
        String password = "SecureP@ssw0rd";
        String jobRole = "Manager";

        Manager manager = new Manager(id, name, contactDetails, password, jobRole);

        assertEquals(id, manager.getId());
        assertEquals(name, manager.getName());
        assertEquals(contactDetails, manager.getContactDetails());
        assertEquals(password, manager.getPassword());
        assertEquals(jobRole, manager.getJobRole());
        assertTrue(manager.getCompletedTasks().isEmpty());
        assertTrue(manager.getTaskArray().isEmpty());
        assertTrue(manager.WaitingForApprove.isEmpty());
    }
    
    @Test
    public void testManagerConstructorNullName() { // PASSED
        //Negative test case, handling null inputs
        String id = "1";
        String name = null;
        String contactDetails = "alice.smith@example.com";
        String password = "SecureP@ssw0rd";
        String jobRole = "Manager";

        Manager manager = new Manager(id, name, contactDetails, password, jobRole);

        assertNull(manager.getName(), "The name should be null.");
    }



}
