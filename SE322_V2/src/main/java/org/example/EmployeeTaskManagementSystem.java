package org.example;

// Main class to demonstrate the usage of the system

import java.util.Calendar;

public class EmployeeTaskManagementSystem {
    public static void main(String[] args) {
        // Creating tasks
        Task task1 = new Task("1", "Complete project report",5);
        Task task2 = new Task("2", "Prepare presentation slides",10);
        Task task3 = new Task("3", "Review code",15);
        Task task4 = new Task("4", "Review code",15);
        Task task5 = new Task("5", "Review code",15);

        TaskHolder holder = new TaskHolder();
        holder.AddToArraylist(task1);
        holder.AddToArraylist(task2);
        holder.AddToArraylist(task3);
        holder.AddToArraylist(task4);
        holder.AddToArraylist(task5);

        // Creating employees
        Employee manager = new Employee("1", "Manager", "manager@example.com", "Manager");
        Employee employee1 = new Employee("2", "John Doe", "john@example.com", "Software Developer");
        Employee employee2 = new Employee("3", "Jane Smith", "jane@example.com", "Software Developer");

        // Assigning tasks
        manager.addTaskArray(task1);
        manager.addTaskArray(task2);

        // Adding unassigned tasks
        employee1.addTaskArray(task3);

        // Separating a task into subtasks
        Task subtask1 = new Task("1.1", "Gather project data",20);
        Task subtask2 = new Task("1.2", "Analyze project requirements",25);
        task1.addSubTask(subtask1);
        task1.addSubTask(subtask2);
        Command assignTask = new AssignTaskCommand();
        assignTask.execute(employee1, subtask1);
        assignTask.execute(employee2, subtask2);

        System.out.println("Unassigned Tasks:\n");
        holder.showUnAssigned();

        // Displaying employee and task details
        System.out.println(manager);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);
    }
}
