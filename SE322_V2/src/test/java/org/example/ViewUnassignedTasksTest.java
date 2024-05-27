package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewUnassignedTasksTest {
    @Test
    void viewUnAssignedTasksPositive() { // PASSED
        // Positive test case, testing viewing unassigned tasks
        TaskHolder taskHolder = new TaskHolder();
        Task task1 = new Task("1", "Complete project report", 5);
        Task task2 = new Task("2", "Prepare presentation slides", 10);
        taskHolder.AddToArraylist(task1);
        taskHolder.AddToArraylist(task2);
        List<Task> unassignedTasks = new ArrayList<>();
        for (Task task : taskHolder.arrayList) {
            if (!task.isAssigned()) {
                unassignedTasks.add(task);
            }
        }
        assertEquals(2, unassignedTasks.size(), "Task holder should have 2 unassigned tasks.");
    }

    @Test
    void viewUnAssignedTasksNegative() { // PASSED
        // Negative test case, viewing unassigned tasks when there is nothing to view
        TaskHolder taskHolder = new TaskHolder();
        TaskHolder emptyTaskHolder = new TaskHolder();
        List<Task> emptyUnassignedTasks = new ArrayList<>();
        for (Task task : emptyTaskHolder.arrayList) {
            if (!task.isAssigned()) {
                emptyUnassignedTasks.add(task);
            }
        }
        assertTrue(emptyUnassignedTasks.isEmpty(), "Task holder without unassigned tasks should have an empty list.");
    }
}
