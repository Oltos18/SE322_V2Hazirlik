package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerConstructorTest {

    @Test
    public void testWorkerConstructorValidInput() { // PASSED
        //Positive test case, constructing worker with valid inputs
        String id = "1";
        String name = "Bob Jones";
        String contactDetails = "bob.jones@office.com";
        String password = "SecureP@ssw0rd";
        String jobRole = "Developer";
        Manager manager = new Manager("2", "Alice Smith", "alice.smith@office.com", "SecureP@ssw0rd", "Manager");

        Worker worker = new Worker(id, name, contactDetails, password, jobRole, manager);

        assertEquals(id, worker.getId());
        assertEquals(name, worker.getName());
        assertEquals(contactDetails, worker.getContactDetails());
        assertEquals(password, worker.getPassword());
        assertEquals(jobRole, worker.getJobRole());
        assertEquals(manager, worker.manager);
        assertTrue(worker.getCompletedTasks().isEmpty());
        assertTrue(worker.getTaskArray().isEmpty());
    }

    @Test
    public void testWorkerConstructorNullContactDetails() { // PASSED
        //Negative test case, null input handling
        String id = "1";
        String name = "Bob Johnson";
        String contactDetails = null;
        String password = "SecureP@ssw0rd";
        String jobRole = "Worker";
        Manager manager = new Manager("2", "Alice Smith", "alice.smith@office.com", "SecureP@ssw0rd", "Manager");

        Worker worker = new Worker(id, name, contactDetails, password, jobRole, manager);

        assertNull(worker.getContactDetails());
    }
}