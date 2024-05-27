package org.example;

import org.example.Employee;
import org.example.Manager;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class AssignWorkHourTest {
    @Test
    void assignTaskWithinWorkHours() { // problem about time
        //Positive test case:Task assignment within work hours
        //work hours (8:00 AM - 5:00 PM)
        LocalTime currentTime = LocalTime.of(10, 0); //Within work hours

        //Manager.setCurrentTime(currentTime);

        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Employee employee = new Employee("1", "John Black", "john@office.com", "123","Software Developer");
        Task task = new Task("1", "Complete project report", 5);

        manager.GiveTask(employee, task);
        assertTrue(task.isAssigned());
    }


    @Test
    void assignTaskOutsideWorkHours() { // problem about time
        //Negative test case, task assignment outside work hours
        //work hours (8:00 AM - 5:00 PM)
        LocalTime currentTime = LocalTime.of(19, 0); //Outside work hours

        //Manager.setCurrentTime(currentTime);

        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Employee employee = new Employee("1", "John Black", "john@office.com", "123","Software Developer");
        Task task = new Task("1", "Complete project report", 5);

        manager.GiveTask(employee, task);
        assertFalse(task.isAssigned()); //verifying that the task was not assigned
    }
}
