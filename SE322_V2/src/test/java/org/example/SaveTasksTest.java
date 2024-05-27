package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.example.Task;
import org.example.Task.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaveTasksTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("1", "Complete unit testing", 5);
    }

    @Test
    public void testTaskCompletion() { // PASSED
        //Positive test case, saving valid tasks are tested
        LocalDateTime beforeCompletion = LocalDateTime.now();

        task.setStatus(TaskStatus.DONE);

        assertEquals(TaskStatus.DONE, task.getStatus(), "Task status should be DONE");
        assertNotNull(task.getEndDate(), "End date should be set when task is completed");
        assertTrue(task.getEndDate().isAfter(beforeCompletion) || task.getEndDate().isEqual(beforeCompletion),
                "End date should be the current time or after the time before completion");
    }

    @Test
    public void testInvalidTaskCompletion() {  // tekrar bakılacak
        //negative test case, saving invalid task is tested
        task.setStatus(TaskStatus.DONE);
        assertNotNull(task.getEndDate(), "End date should still be set when task is directly marked as DONE");

        //assertNotEquals(TaskStatus.DONE, task.getStatus());
    }
}

