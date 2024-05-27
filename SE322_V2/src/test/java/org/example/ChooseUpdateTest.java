package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseUpdateTest {
    @Test
    public void testChooseUpdateDescription() { // java.util.NoSuchElementException: No line found
        //Positive test case, user updates description
        Manager manager = new Manager("1", "John Doe", "john@example.com", "password", "Manager");
        manager.scanner = new Scanner("D\n");
        boolean isDescription = manager.chooseUpdate();
        assertTrue(isDescription);
    }

    @Test
    public void testChooseUpdateInvalidInput() { // PASSED
        //Negative test case, user enters invalid input
        Manager manager = new Manager("1", "John Doe", "john@example.com", "password", "Manager");
        manager.scanner = new Scanner("X\nD\n");

        boolean isDescription = manager.chooseUpdate();
        assertTrue(isDescription);
    }
}
