package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AddingCompletedTasksTest {

    @Test
    void addCompletedTasksPositive() { // PASSED
        // Positive test case, adding completed task is tasted
        Employee employee = new Employee("1", "John Black", "john@office.com", "123","Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.addCompletedTasks(task);
        List<Task> completedTasks = employee.getCompletedTasks();
        assertTrue(completedTasks.contains(task), "Completed task should be added to the completed tasks list.");
    }

    @Test
    void addCompletedTasksNegative() {  // PASSED
        // Negative test case, adding a null task is tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "123", "Software Developer");
        Task nullTask = null;
        employee.addCompletedTasks(nullTask);
        List<Task> completedTasks = employee.getCompletedTasks();
        assertFalse(completedTasks.contains(nullTask), "Null task should not be added to the completed tasks list.");
    }
}