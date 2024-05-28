package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class LogHistoryTest {
    private static final String LOG_FILE = "log.txt";

    @BeforeEach
    public void setUp() throws IOException {
        Files.deleteIfExists(Paths.get(LOG_FILE)); //to clean the file before each test
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(LOG_FILE)); //to clean after test
    }

    @Test
    public void testLogEntryCreation() { // PASSED
        //Positive test case, verifying log entry is created correctly
        String action = "Task Completed";
        String performedBy = "John Black";

        Log log = new Log(action, performedBy);

        List<String> logEntries = readLogFile();
        assertEquals(1, logEntries.size());

        String logEntry = logEntries.get(0);
        assertTrue(logEntry.contains("Action: " + action), "Log entry should contain the correct action");
        assertTrue(logEntry.contains("By: " + performedBy), "Log entry should contain the correct performer");
    }

    @Test
    public void testLogFileWritingErrorHandling() { // PASSED but with error but this is actually okay
        //Negative test case, writing to the log file fails
        try {
            File logFile = new File(LOG_FILE);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            logFile.setReadOnly();

            new Log("This should fail", "Tester");

            List<String> logEntries = readLogFile();
            assertNotEquals(1, logEntries.size(), "Log file should not contain the entry due to write error");
        } catch (IOException e) {
            fail("Setup failed: " + e.getMessage());
        } finally {
            File logFile = new File(LOG_FILE);
            logFile.setWritable(true);
        }
    }

    private List<String> readLogFile() {
        try {
            return Files.readAllLines(Paths.get(LOG_FILE));
        } catch (IOException e) {
            fail("Failed to read log file: " + e.getMessage());
            return null;
        }
    }
}

