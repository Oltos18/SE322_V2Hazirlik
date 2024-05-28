package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewEmployeeTest {
    @BeforeEach
    public void setUp() {
        EmployeeHolder.getEmployeesArraylist().clear(); //to clear the list before each test
    }

    @AfterEach
    public void tearDown() {
        EmployeeHolder.getEmployeesArraylist().clear(); //to clean up the list after tests
    }

    @Test
    public void testViewEmployeePositive() { // PASSED
        //Positive test case, viewing an employee after adding to EmployeeHolder
        Employee employee = new Employee("1", "John Black", "john@office.com", "123Abc", "Software Developer");
        EmployeeHolder.AddToArraylist(employee);

        Employee retrievedEmployee = EmployeeHolder.getEmployee(0);

        assertNotNull(retrievedEmployee, "Retrieved employee should not be null");
        assertEquals("1", retrievedEmployee.getId(), "Employee ID should match");
        assertEquals("John Doe", retrievedEmployee.getName(), "Employee name should match");
        assertEquals("123Abc", retrievedEmployee.getContactDetails(), "Employee contact details should match");
        assertEquals("Developer", retrievedEmployee.getJobRole(), "Employee job role should match");
    }

    @Test
    public void testViewEmployeeNegative() { // PASSED
        //Negative test case, attempting to view an employee at an invalid index
        Employee employee = new Employee("1", "John Black", "john@office.com", "123Abc", "Software Developer");
        EmployeeHolder.AddToArraylist(employee);

        Employee retrievedEmployee = EmployeeHolder.getEmployee(1);

        assertNull(retrievedEmployee, "Retrieved employee should be null for an invalid index");
    }
}
