package org.example;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GiveTaskTest {
    @Test
    public void giveTaskPositive() { // PASSED
        // Positive test case, adding a valid task is tested
        Employee employee = new Employee("2", "John Black", "john@office.com", "123", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.addTaskArray(task);
        List<Task> taskList = employee.getTaskArray();
        assertTrue(taskList.contains(task), "Task should be assigned to the employee");
    }


    @Test
    public void giveTaskNegative() { // PASSED
        // Negative test case, testing adding null task and assigning it
        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Employee employee = new Employee("2", "John Black", "john@office.com","123",  "Software Developer");
        Task nullTask = null;
        manager.GiveTask(employee, nullTask);

        assertNotEquals(1, employee.getTaskArray().size());

    }
}
