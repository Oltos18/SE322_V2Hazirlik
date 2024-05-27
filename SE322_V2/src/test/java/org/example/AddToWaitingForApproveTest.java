package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToWaitingForApproveTest {
    @Test
    void addToWaitingForApprovePositive() { // PASSED
        // Positive test case, waiting for approval of matching tasks and workers is tested
        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Worker worker = new Worker("2", "John Black", "john@office.com", "123", "Software Developer", manager);
        Task task = new Task("1", "Complete project report", 5);
        manager.AddToWaitingForApprove(worker, task);
        assertTrue(manager.WaitingForApprove.containsKey(worker));
        assertTrue(manager.WaitingForApprove.containsValue(task));

    }

    @Test
    void addToWaitingForApproveNegative() { // PASSED
        // adding for invalid worker
        Manager manager = new Manager("1", "Manager", "manager@office.com", "123","Manager");
        Worker invalidWorker = new Worker("3", "Jenna Bailey", "jenna@office.com", "123", "Software Developer",manager);
        Task task = new Task("1", "Complete project report", 5);

        assertFalse(manager.WaitingForApprove.containsKey(invalidWorker));

    }
}
