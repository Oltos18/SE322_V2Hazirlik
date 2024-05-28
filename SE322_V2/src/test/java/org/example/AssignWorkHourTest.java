package org.example;

import org.example.Employee;
import org.example.Manager;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class AssignWorkHourTest {
    @Test
    void assignTaskWithinWorkHours() { // PASSED
        //Positive test case, assigning task within work hours
        Manager.currentTime = LocalTime.of(10, 0); //set current time to within work hours (8:00 - 17:00 )

        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Employee employee = new Employee("1", "John Black", "john@office.com", "123", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);

        manager.GiveTask(employee, task);
        assertTrue(task.isAssigned());
    }

    @Test
    void assignTaskOutsideWorkHours() {
        //Negative test case, assigning task outside work hours
        Manager.currentTime = LocalTime.of(19, 0);//set current time to outside work hours

        Manager manager = new Manager("1", "Manager", "manager@office.com", "123", "Manager");
        Employee employee = new Employee("1", "John Black", "john@office.com", "123","Software Developer");
        Task task = new Task("1", "Complete project report", 5);

        manager.GiveTask(employee, task);
        assertFalse(task.isAssigned());
    }
}
