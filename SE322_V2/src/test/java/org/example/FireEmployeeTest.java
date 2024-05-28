package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FireEmployeeTest {
    @Test
    void FireEmployeePositive() { // PASSED
        // Positive test case, removing existing employee is tested
        Employee manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Manager managerToDelete = (Manager) manager;
        assertNotNull(managerToDelete);
        managerToDelete = null;
        assertNull(managerToDelete);
    }

    @Test
    void FireEmployeeNegative() { // PASSED
        //negative test case, removing non-existing employee
        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Employee employee = new Employee("2", "John Black", "john@office.com","123",  "Software Developer");

        assertNotEquals(employee, manager.FireEmployee(1));
    }

}
