package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetIndexInputTest {

    @Test
    public void testGetIndex_InvalidThenValidInput() {
        //Positive test case
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "Task 1", 10));
        tasks.add(new Task("2", "Task 2", 20));
        tasks.add(new Task("3", "Task 3", 30));

        String input = "5\n1\n";
        Scanner scanner = new Scanner(input);

        Manager manager = new Manager("1", "Manager", "manager@office.com", "123Abc", "Manager");

        int result = manager.getIndex(tasks);

        assertEquals(1, result);
    }

    @Test
    public void testGetIndex_InvalidNegativeInput() {
        //Negative test case
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "Task 1", 10));
        tasks.add(new Task("2", "Task 2", 20));
        tasks.add(new Task("3", "Task 3", 30));

        String input = "-1\n2\n";
        Scanner scanner = new Scanner(input);

        Manager manager = new Manager("1", "Manager", "manager@office.com", "123Abc", "Manager");

        int result = manager.getIndex(tasks);

        assertEquals(2, result);
    }



}
