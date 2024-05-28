package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShowUnassignedTest {

    @Test
    void showUnAssignedPositive() {  // PASSED
        // Positive test case, viewing existing unassigned tasks is tested
        TaskHolder taskHolder = new TaskHolder();
        Task unassignedTask = new Task("1", "Complete project report", 5);
        unassignedTask.setAssigned(false);
        taskHolder.AddToArraylist(unassignedTask);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        taskHolder.showUnAssigned();
        String expectedOutput = "0: " + unassignedTask.toString() + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void showUnAssignedNegative() {  // PASSED
        //Negative test case, viewing existing assigned tasks are tested
        TaskHolder taskHolder = new TaskHolder();
        Task assignedTask = new Task("1", "Complete project report", 5);
        assignedTask.setAssigned(true);
        taskHolder.AddToArraylist(assignedTask);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        taskHolder.showUnAssigned();
        String expectedOutput = ""; //no unassigned tasks, so output should be empty
        assertEquals(expectedOutput, outputStream.toString());
    }
}
