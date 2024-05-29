package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskConstructorTest {
    @Test
    public void testTaskConstructorValidInput() { // PASSED
        //Positive test case, constructing task with valid inputs
        String taskId = "1";
        String description = "Complete project documentation";
        int taskPoint = 5;

        Task task = new Task(taskId, description, taskPoint);

        assertEquals(taskId, task.getTaskId());
        assertEquals(description, task.getDescription());
        assertEquals(taskPoint, task.getTaskPoint());
        assertFalse(task.isAssigned());
        assertTrue(task.getEmpList().isEmpty());
        assertTrue(task.getSubTasks().isEmpty());
    }
}
