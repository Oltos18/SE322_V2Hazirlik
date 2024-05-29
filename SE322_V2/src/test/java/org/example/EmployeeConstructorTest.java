package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeConstructorTest {
    @Test
    public void testEmployeeConstructorValidInput() { // PASSED
        //Positivie test case, valid inputs are tested
        String id = "1";
        String name = "John Smith";
        String contactDetails = "john.black@office.com";
        String password = "SecureP@ssw0rd";
        String jobRole = "Developer";

        Employee employee = new Employee(id, name, contactDetails, password, jobRole);

        assertEquals(id, employee.getId());
        assertEquals(name, employee.getName());
        assertEquals(contactDetails, employee.getContactDetails());
        assertEquals(password, employee.getPassword());
        assertEquals(jobRole, employee.getJobRole());
        assertTrue(employee.getCompletedTasks().isEmpty());
        assertTrue(employee.getTaskArray().isEmpty());
    }

    @Test
    public void testEmployeeConstructorNullID() { // PASSED
        //Negative test case, handles null inputs
        String id = null;
        String name = "John Smith";
        String contactDetails = "john.doe@office.com";
        String password = "SecureP@ssw0rd";
        String jobRole = "Developer";

        Employee employee = new Employee(id, name, contactDetails, password, jobRole);

        assertNull(employee.getId());
    }
}
