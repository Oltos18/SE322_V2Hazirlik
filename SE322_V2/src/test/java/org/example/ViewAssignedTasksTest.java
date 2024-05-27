package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewAssignedTasksTest {
    @Test
    void viewAssignedTasksPositive() { // PASSED
        // Positive test case, viewing existing assigned tasks is tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "123", "Software Developer");
        Task task1 = new Task("1", "Complete project report", 5);
        Task task2 = new Task("2", "Prepare presentation slides", 10);
        employee.addTaskArray(task1);
        employee.addTaskArray(task2);
        List<Task> assignedTasks = employee.getTaskArray();
        assertEquals(2, assignedTasks.size(), "Employee should have 2 assigned tasks.");
    }

    @Test
    void viewAssignedTasksNegative() { // PASSED
        // Negative test case, viewing assigned tasks when there are none is tested
        Employee employee = new Employee("1", "John Black", "john@office.com",  "123","Software Developer");
        Employee employeeWithoutTasks = new Employee("2", "Mary Smith", "mary@office.com", "123", "Software Developer");
        List<Task> emptyAssignedTasks = employeeWithoutTasks.getTaskArray();
        assertTrue(emptyAssignedTasks.isEmpty(), "Employee without assigned tasks should have an empty list.");
    }
}
