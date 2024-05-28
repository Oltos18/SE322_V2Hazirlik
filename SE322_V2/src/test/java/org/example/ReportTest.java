package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {

    @Test
    public void testReportWithCompletedTasks() {
        Employee emp1 = new Employee("1", "John Black", "john@office.com", "123Abc", "Software Developer");
        Employee emp2 = new Employee("2", "Jenna Bailey", "jenna@office.com", "123Cde", "Software Developer");

        Task task1 = new Task("1", "Complete project report", 5);
        task1.setEndTime();
        Task task2 = new Task("2", "Gather project data", 2);
        task2.setEndTime();

        emp1.CompleteTask(task1);
        emp2.CompleteTask(task2);

        EmployeeHolder.AddToArraylist(emp1);
        EmployeeHolder.AddToArraylist(emp2);

        Report report = new Report();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        report.task.run();

        System.setOut(System.out);

        String expectedOutput = "Employee John Black get 5 points\nEmployee Jenna Bailey get 2 points\n";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void testReportWithoutCompletedTasks() {
        Employee emp1 = new Employee("1", "John Doe", "password", "contact", "Developer");
        Employee emp2 = new Employee("2", "Jane Smith", "password", "contact", "Designer");

        EmployeeHolder.AddToArraylist(emp1);
        EmployeeHolder.AddToArraylist(emp2);

        Report report = new Report();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        report.task.run();

        System.setOut(System.out);

        String expectedOutput = "Employee John Doe get 0 points\nEmployee Jane Smith get 0 points\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
