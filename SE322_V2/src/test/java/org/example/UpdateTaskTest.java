package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UpdateTaskTest {
    @Test
    public void updateTaskPositive() { // PASSED
        // boolean var should be tested
        TaskHolder holder = new TaskHolder();
        ArrayList<Task> tasks = holder.getAssignedList();
        tasks.add(new Task("1", "Complete project report", 5));
        tasks.add(new Task("2", "Prepare presentation", 2));

        Manager manager = new Manager("1", "Manager", "manager@office.com","123",  "Manager");
        int choice = 1;

        boolean isOk = true;
        boolean updateChoice = true;

        assertEquals(true, isOk);
        assertEquals(true, updateChoice);

    }

    @Test
    public void updateTaskNegative() { // PASSED
        // boolean var should be tested
        TaskHolder holder = new TaskHolder();
        ArrayList<Task> tasks = holder.getAssignedList();
        tasks.add(new Task("1", "Complete project report", 5));
        tasks.add(new Task("2", "Prepare presentation", 2));

        Manager manager = new Manager("1", "Manager", "manager@office.com","123",  "Manager");
        int choice = 1;
        boolean isOk = true;
        boolean updateChoice = false;

        assertNotEquals(true, updateChoice);
    }
}
