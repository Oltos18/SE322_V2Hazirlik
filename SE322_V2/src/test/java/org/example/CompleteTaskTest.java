package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteTaskTest {
    @Test
    void completeTaskPositive() { // PASSED
        // Positive test case, testing the case that employee is completing an existing task
        Employee employee = new Employee("1", "John Black", "john@office.com", "123", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.addTaskArray(task);
        employee.CompleteTask(task);
        List<Task> completedTasks = employee.getCompletedTasks();
        assertTrue(completedTasks.contains(task), "Completed task should be added to the completed tasks list.");
        assertFalse(employee.getTaskArray().contains(task), "Completed task should be removed from the assigned tasks list.");
    }

    @Test
    void completeTaskNegative() {  // NEED TO BE FIXED
        // Negative test case, testing the case that employee tries to complete a task that the he/she doesn't have any
        Employee employee = new Employee("1", "John Black", "john@office.com", "123", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.CompleteTask(task);

        assertFalse(employee.getCompletedTasks().contains(task), "Non-existing task should not be completed.");

    }

}
