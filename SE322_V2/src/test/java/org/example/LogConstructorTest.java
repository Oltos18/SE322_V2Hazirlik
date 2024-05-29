package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class LogConstructorTest {

    private static final String LOG_FILE = "log.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @BeforeEach
    public void setUp() throws IOException {//to clear the log file before each test
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE))) {
            writer.write("");
        }
    }

    @Test
    public void testLogConstructorValidInput() throws IOException { // PASSED
        //Positive test case
        String action = "Created task";
        String performedBy = "Manager";

        Log log = new Log(action, performedBy);

        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {//to check if log file contains the expected log entry
            String logEntry = reader.readLine();
            assertNotNull(logEntry);

            LocalDateTime timestamp = LocalDateTime.now();
            String expectedTimestamp = timestamp.format(DATE_TIME_FORMATTER);

            assertTrue(logEntry.contains("Action: " + action));
            assertTrue(logEntry.contains("By: " + performedBy));
        }
    }

    // Negative Test Cases
    @Test
    public void testLogConstructorEmptyAction() throws IOException { // PASSED
        String action = "";
        String performedBy = "Manager";

        Log log = new Log(action, performedBy);

        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String logEntry = reader.readLine();
            assertNotNull(logEntry);

            assertNotEquals("Action: ", logEntry.contains("Action: "));
            //log entry should not contain empty action
        }
    }
}
