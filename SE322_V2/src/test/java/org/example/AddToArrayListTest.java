package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AddToArrayListTest {
    @Test
    void addToArraylistPositive() { // PASSED
        //Positive test case, adding existing tasks to list is tested
        TaskHolder taskHolder = new TaskHolder();
        Task task = new Task("1", "Complete project report", 5);

        taskHolder.AddToArraylist(task);
        assertEquals(1, taskHolder.arrayList.size());
        assertEquals(task, taskHolder.arrayList.get(0));
    }

    @Test
    void addToArraylistNegative() {
        // Negative test case, adding null task to the list
        TaskHolder taskHolder = new TaskHolder();
        Task task = null;
        taskHolder.AddToArraylist(task);
        assertNotEquals(1, taskHolder.arrayList.size());
    }
}