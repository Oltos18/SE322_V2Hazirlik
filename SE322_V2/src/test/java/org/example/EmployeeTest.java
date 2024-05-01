package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void addCompletedTasksPositive() { // PASSED
        // Positive test case, adding completed task is tasted
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.addCompletedTasks(task);
        List<Task> completedTasks = employee.getCompletedTasks();
        assertTrue(completedTasks.contains(task), "Completed task should be added to the completed tasks list.");
    }

    @Test
    void addCompletedTasksNegative() {  // NEED TO BE FIXED ********************************
        // Negative test case, adding a null task is tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");

        Task nullTask = new Task(null, null, 0);
        employee.addCompletedTasks(nullTask);

        assertNotEquals(nullTask, employee.getCompletedTasks().get(0));
    }

    @Test
    void viewAssignedTasksPositive() { // PASSED
        // Positive test case, viewing existing assigned tasks is tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Task task1 = new Task("1", "Complete project report", 5);
        Task task2 = new Task("2", "Prepare presentation slides", 10);
        employee.addTaskArray(task1);
        employee.addTaskArray(task2);
        List<Task> assignedTasks = employee.getTaskArray();
        assertEquals(2, assignedTasks.size(), "Employee should have 2 assigned tasks.");
    }

    @Test
    void viewAssignedTasksNegative() { // PASSED
        // Negative test case, viewing assigned tasks when there are none is tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Employee employeeWithoutTasks = new Employee("2", "Mary Smith", "mary@office.com", "Software Developer");
        List<Task> emptyAssignedTasks = employeeWithoutTasks.getTaskArray();
        assertTrue(emptyAssignedTasks.isEmpty(), "Employee without assigned tasks should have an empty list.");
    }

    @Test
    void viewUnAssignedTasksPositive() { // PASSED
        // Positive test case, testing viewing unassigned tasks
        TaskHolder taskHolder = new TaskHolder();
        Task task1 = new Task("1", "Complete project report", 5);
        Task task2 = new Task("2", "Prepare presentation slides", 10);
        taskHolder.AddToArraylist(task1);
        taskHolder.AddToArraylist(task2);
        List<Task> unassignedTasks = new ArrayList<>();
        for (Task task : taskHolder.arrayList) {
            if (!task.isAssigned()) {
                unassignedTasks.add(task);
            }
        }
        assertEquals(2, unassignedTasks.size(), "Task holder should have 2 unassigned tasks.");
    }

    @Test
    void viewUnAssignedTasksNegative() { // PASSED
        // Negative test case, viewing unassigned tasks when there is nothing to view
        TaskHolder taskHolder = new TaskHolder();
        TaskHolder emptyTaskHolder = new TaskHolder();
        List<Task> emptyUnassignedTasks = new ArrayList<>();
        for (Task task : emptyTaskHolder.arrayList) {
            if (!task.isAssigned()) {
                emptyUnassignedTasks.add(task);
            }
        }
        assertTrue(emptyUnassignedTasks.isEmpty(), "Task holder without unassigned tasks should have an empty list.");
    }

    @Test
    void completeTaskPositive() { // PASSED
        // Positive test case, testing the case that employee is completing an existing task
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        employee.addTaskArray(task);
        employee.CompleteTask(task);
        List<Task> completedTasks = employee.getCompletedTasks();
        assertTrue(completedTasks.contains(task), "Completed task should be added to the completed tasks list.");
        assertFalse(employee.getTaskArray().contains(task), "Completed task should be removed from the assigned tasks list.");
    }

    @Test
    void completeTaskNegative() { // NEED TO BE FIXED **************************************
        // Negative test case, testing the case that employee tries to complete a task that the he/she doesn't have any
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Task unassignedTask = new Task("2", "Prepare presentation slides", 10);
        //assertThrows(IllegalArgumentException.class, () -> employee.CompleteTask(unassignedTask));

        // ...
    }

    @Test
    void separateTaskPositive() { // PASSED
        // Positive test case, seperating tasks into subtasks are tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        Task subtask1 = new Task("1.1", "Gather project data", 2);
        Task subtask2 = new Task("1.2", "Analyze project requirements", 3);
        List<Task> subtasks = new ArrayList<>();
        subtasks.add(subtask1);
        subtasks.add(subtask2);
        employee.separateTask(task, (ArrayList<Task>) subtasks);
        assertEquals(2, task.getSubTasks().size(), "Task should have 2 subtasks after separation.");

    }

    @Test
    void separateTaskNegative() { // PASSED
        // Negative test case, trying to separate tasks when subtasks list is null is tested
        Employee employee = new Employee("1", "John Black", "john@office.com", "Software Developer");
        Task task = new Task("1", "Complete project report", 5);
        List<Task> nullSubtasks = null;
        assertThrows(NullPointerException.class, () -> employee.separateTask(task, (ArrayList<Task>) nullSubtasks));
    }
}