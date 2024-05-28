package org.example;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SeperateTaskTest {

    @Test
    void separateTaskPositive() { // PASSED
        // Positive test case, seperating tasks into subtasks are tested
        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Task task = new Task("1", "Complete project report", 5);
        Task subtask1 = new Task("1.1", "Gather project data", 2);
        Task subtask2 = new Task("1.2", "Analyze project requirements", 3);
        List<Task> subtasks = new ArrayList<>();
        subtasks.add(subtask1);
        subtasks.add(subtask2);
        manager.separateTaskToSubtasks(task, (ArrayList<Task>) subtasks);
        assertEquals(2, task.getSubTasks().size(), "Task should have 2 subtasks after separation.");

    }

    @Test
    void separateTaskNegative() { // PASSED
        // Negative test case, trying to separate tasks when subtasks list is null is tested
        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Task task = new Task("1", "Complete project report", 5);
        List<Task> nullSubtasks = null;
        assertThrows(NullPointerException.class, () -> manager.separateTaskToSubtasks(task, (ArrayList<Task>) nullSubtasks));
    }
}