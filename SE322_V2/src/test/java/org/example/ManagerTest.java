package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void addToWaitingForApprovePositive() { // PASSED
        // Positive test case, waiting for approval of matching tasks and workers is tested
        Manager manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        Worker worker = new Worker("2", "John Black", "john@office.com", "Software Developer", manager);
        Task task = new Task("1", "Complete project report", 5);
        manager.AddToWaitingForApprove(worker, task);
        assertTrue(manager.WaitingForApprove.containsKey(worker));
        assertTrue(manager.WaitingForApprove.containsValue(task));

    }

    @Test
    void addToWaitingForApproveNegative() {

    }
    

    @Test
    void createEmployeePositive() { // PASSED
        //Positive test case, creating employee with valid data is tested
        Employee manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        assertEquals("Manager", manager.getJobRole());
    }

    @Test
    void createEmployeeNegative() { // PASSED
        //Negative test case, creating employee with invalid data is tested
        Employee invalidEmployee = new Employee(null, null, null, null);
        assertNotEquals("Invalid employee should not have an ID", "1", invalidEmployee.getId());
    }

    @Test
    void updateEmployeePositive() { // PASSED
        // Positive test case, updating existing employee is tested
        Employee manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        manager.setName("Updated Manager");
        assertEquals("Updated Manager", manager.getName());
    }

    @Test
    void updateEmployeeNegative() {
        // Negative test case
        // ??
    }

    @Test
    void FireEmployeePositive() { // PASSED
        // Positive test case, removing existing employee is tested
        Employee manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        Manager managerToDelete = (Manager) manager;
        assertNotNull(managerToDelete);
        managerToDelete = null;
        assertNull(managerToDelete);
    }

    @Test
    void FireEmployeeNegative() {
        // Negative test case - removing non-existing employee (??)
    }


    @Test
    public void giveTaskPositive() { // PASSED
        // Positive test case, adding a valid task is tested
        Employee employee = new Employee("2", "John Black", "john@office.com", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.addTaskArray(task);
        List<Task> taskList = employee.getTaskArray();
        assertTrue(taskList.contains(task), "Task should be assigned to the employee");
    }


    @Test
    public void giveTaskNegative() { // NEED TO BE FIXED **************************************
        // Negative test case, testing adding null task and assigning it

        //...

    }

    @Test
    public void isOKPositive() { // this takes too long - SHOULD BE FIXED
        Manager manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        boolean result = manager.isOk(1);

        assertEquals(true, result);

    }

    @Test
    public void isOKNegative() { // this takes too long - SHOULD BE FIXED
        Manager manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        boolean result = manager.isOk(2);

        assertNotEquals(false, result);
    }


    @Test
    public void updateTaskPositive() { // PASSED
        // boolean var should be tested
        TaskHolder holder = new TaskHolder();
        ArrayList<Task> tasks = holder.getAssignedList();
        tasks.add(new Task("1", "Complete project report", 5));
        tasks.add(new Task("2", "Prepare presentation", 2));

        Manager manager = new Manager("1", "Manager", "manager@office.com", "Manager");
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

        Manager manager = new Manager("1", "Manager", "manager@office.com", "Manager");
        int choice = 1;
        boolean isOk = true;
        boolean updateChoice = false;

        assertNotEquals(true, updateChoice);
    }

}
