package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CreateEmployeeTest {
    @Test
    void createEmployeePositive() { // PASSED
        //Positive test case, creating employee with valid data is tested
        Employee manager = new Manager("1", "Manager", "manager@office.com","123",  "Manager");
        assertEquals("Manager", manager.getJobRole());
    }

    @Test
    void createEmployeeNegative() { // PASSED
        //Negative test case, creating employee with invalid data is tested
        Employee invalidEmployee = new Employee(null, null, null,null, null);
        assertNotEquals("Manager", "1", invalidEmployee.getId());
    }
}
