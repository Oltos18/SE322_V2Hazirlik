package org.example;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskHolder holder = new TaskHolder();
        EmployeeHolder employeeHolder = new EmployeeHolder();
        Report report = null;

        Employee manager = new Manager("1", "Manager", "manager@example.com", "123", "Manager");
        Employee employee1 = new Worker("2", "John Doe", "john@example.com", "456", "Software Developer", (Manager) manager);
        Employee employee2 = new Worker("3", "Jane Smith", "jane@example.com", "789", "Software Developer", (Manager) manager);
        Employee manager2 = new Manager("4", "Manager2", "manager2@example.com", "101112", "Manager");

        Task task1 = new Task("1", "Complete project report", 5);
        Task task2 = new Task("2", "Prepare presentation slides", 10);
        Task task3 = new Task("3", "Review code", 15);
        Task task4 = new Task("4", "Review code", 15);
        Task task5 = new Task("5", "Review code", 15);


        holder.AddToArraylist(task1);
        holder.AddToArraylist(task2);
        holder.AddToArraylist(task3);
        holder.AddToArraylist(task4);
        holder.AddToArraylist(task5);

        EmployeeHolder.AddToArraylist(manager);
        EmployeeHolder.AddToArraylist(employee1);
        EmployeeHolder.AddToArraylist(employee2);


        Command newAssign = new AssignTaskCommand();

        task1.assignTask(employee1);
        task2.assignTask(employee2);
        System.out.println(task1.isAssigned());


        Task subtask1 = new Task("1.1", "Gather project data", 20);
        Task subtask2 = new Task("1.2", "Analyze project requirements", 25);
        task1.addSubTask(subtask1);
        task2.addSubTask(subtask2);

        ((Manager) manager).GiveTask(employee1, task5);
        employee1.CompleteTask(task5);

        System.out.println("Welcome to the Employee Task Management System!");

        int employeeIndex = 0;
        while (true) {
            System.out.println("Enter your ID:(Write 'exit' for quit)");
            String employeeId = scanner.nextLine();
            if (employeeId.equals("exit")) {
                System.exit(0);
            }
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < EmployeeHolder.getSize(); i++) {
                if (EmployeeHolder.getEmployee(i).getId().equals(employeeId) && EmployeeHolder.getEmployee(i).getPassword().equals(password)) {
                    employeeIndex = i;
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                new Log("Entered to the system", EmployeeHolder.getEmployee(employeeIndex).getName());
                break;
            } else {
                System.out.println("Wrong ID or password!!!");
            }

        }

        if (EmployeeHolder.getEmployee(employeeIndex).getJobRole().equals("Manager")) {
            System.out.println("Welcome, Manager!");
            boolean managerRunning = true;
            while (managerRunning) {
                System.out.println("Manager Options:");
                System.out.println("1. Create Task");
                System.out.println("2. Show Assigned Task");
                System.out.println("3. Show Unassigned Task");
                System.out.println("4. Create Employee");
                System.out.println("5. Update Employee");
                System.out.println("6. Delete Employee");
                System.out.println("7. Assign Task");
                System.out.println("8. Update Task");
                System.out.println("9. Separate Task to Subtasks");
                System.out.println("10. Complete Task");
                System.out.println("11. Show completed tasks");
                System.out.println("12. Set report time");
                System.out.println("13. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        //Create Task
                        System.out.println("Please enter new Task ID:");
                        String id = scanner.nextLine();
                        System.out.println("Please enter a description for new Task:");
                        String description = scanner.nextLine();
                        System.out.println("Please enter a point for new Task:");
                        int point = scanner.nextInt();
                        scanner.nextLine();
                        holder.AddToArraylist(((Manager) manager).CreateTask(id, description, point));
                        //Bu kısımda kullanıcı kısmı belli olduğunda yapan kişi tarafı değişecek
                        new Log("A new task created", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 2:
                        System.out.println("Assigned Tasks:");
                        holder.showAssigned();
                        new Log("Displayed assigned tasks", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 3:
                        System.out.println("Unassigned Tasks:");
                        holder.showUnAssigned();
                        new Log("Displayed unassigned tasks", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 4:
                        //Create Employee
                        System.out.println("Please enter new Employee ID:");
                        String ID = scanner.nextLine();
                        System.out.println("Please enter name of new Employee:");
                        String name = scanner.nextLine();

                        String newPassword;
                        while(true){    //this part is specifically for password part
                            System.out.println("Please enter password of new Employee: !(Please use 1 uppercase letter, 1 special character and 1 number)" );
                            newPassword = scanner.nextLine();
                            if(isPasswordValid(newPassword)){
                                break;
                            }
                            else{
                                System.out.println("This password is not valid");
                            }
                        }

                        System.out.println("Please enter contact details of new Employee:");
                        String contactDetails = scanner.nextLine();
                        System.out.println("Please enter job role of new Employee:");
                        String jobRole = scanner.nextLine();
                        EmployeeHolder.AddToArraylist(((Manager) manager).CreateEmployee(ID, name, newPassword, contactDetails, jobRole));
                        new Log(new String("Created a new employee with ID number: " + ID),
                                EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 5:
                        //Update Employee
                        EmployeeHolder.showEmployees();
                        System.out.println("Select an Employee by index number:");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        ((Manager) manager).updateEmployee(EmployeeHolder.getEmployee(index));
                        System.out.println("New information for updated Employee:");
                        EmployeeHolder.getEmployee(index).toString();
                        new Log(new String("Information about employee with ID number: " +
                                EmployeeHolder.getEmployee(index).getId() + " has been updated"),
                                EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 6:
                        //Delete Employee
                        EmployeeHolder.showEmployees();
                        System.out.println("Select an Employee by index number:");
                        index = scanner.nextInt();
                        scanner.nextLine();
                        Employee deletedEmployee = ((Manager) manager).FireEmployee(index);
                        System.out.println("Information of deleted Employee:");
                        deletedEmployee.toString();
                        new Log(new String("Information about employee with ID number: " +
                                deletedEmployee.getId() + " has been deleted"),
                                EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 7:
                        //Assign Task
                        EmployeeHolder.showEmployees();
                        System.out.println("Please select which employee take the task(Please enter employee index!)");
                        index = scanner.nextInt();
                        scanner.nextLine();
                        Employee selectedEmployee = EmployeeHolder.getEmployee(index);
                        holder.showUnAssigned();
                        System.out.println("Please select which task do you want to assign.(Please enter task index!)");
                        index = scanner.nextInt();
                        scanner.nextLine();
                        Task selectedTask = holder.getUnAssignedList().get(index);
                        //newAssign.execute(selectedEmployee, selectedTask);
                        ((Manager) manager).GiveTask(selectedEmployee, selectedTask);
                        new Log(new String("Task with ID: " + selectedTask.getTaskId() +
                                " has been assigned to employee with ID: " + selectedEmployee.getId()),
                                EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 8:
                        //Update Task
                        ((Manager) manager).updateTask(holder);
                        new Log("Updated a task", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 9:
                        //Separate Task to Subtasks
                        boolean flag = true;
                        holder.showUnAssigned();
                        System.out.println("Please select which task do you want to separate.(Please enter task index)");
                        index = scanner.nextInt();
                        scanner.nextLine();
                        while (flag) {
                            System.out.println("Please enter new Task ID:");
                            id = scanner.nextLine();
                            System.out.println("Please enter a description for new Task:");
                            description = scanner.nextLine();
                            System.out.println("Please enter a point for new Task:");
                            point = scanner.nextInt();
                            scanner.nextLine();
                            Task newSubTask = ((Manager) manager).CreateTask(id, description, point);
                            holder.getUnAssignedList().get(index).addSubTask(newSubTask);

                            System.out.println("Want to create another subtask? Press 0 to stop creating subtasks!");
                            int subTaskContinue = scanner.nextInt();
                            scanner.nextLine();
                            if (subTaskContinue == 0) {
                                flag = false;
                            }
                        }
                        new Log(new String("Task with ID: " + holder.getTask(index).getTaskId() +
                                " has been separated to subtasks"), EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 10:
                        //Complete Task
                        ((Manager) manager).RemoveFromWaitingForApproveArraylist();
                        new Log("Checked and completed some tasks", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 11:
                        holder.showCompletedTask();
                        new Log("Displayed completed tasks", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 12:
                        report = new Report();
                        new Log("Report scheduled",EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        managerRunning = false;
                        new Log("Quit from the system", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                        break;
                }
            }
        } else {
            System.out.println("Welcome, Worker!");
            boolean employeeRunning = true;
            while (employeeRunning) {
                System.out.println("Worker Options:");
                System.out.println("1. Show Unassigned Tasks");
                System.out.println("2. Show Assigned Tasks");
                System.out.println("3. Write task comment");
                System.out.println("4. Complete Task");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Unassigned Tasks:");
                        holder.showUnAssigned();
                        new Log("Displayed unassigned tasks", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 2:
                        System.out.println("Assigned Tasks:");
                        holder.showAssigned();
                        new Log("Displayed assigned tasks", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 3:
                        //Write task comment
                        Employee selectedEmp = EmployeeHolder.getEmployee(employeeIndex);
                        selectedEmp.ViewAssignedTasks();
                        System.out.println("Please select which task do you want to add comment:");
                        int tsk = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Write your comment to the task:");
                        String selectedComment = scanner.nextLine();
                        try {
                            selectedEmp.getTaskArray().get(tsk).setWorkerComment(selectedComment);
                        } catch (Exception e) {
                            System.out.println("Something went wrong!");
                        }
                        new Log(new String("Entered comment to the task with ID: " + selectedEmp.getTaskArray().get(tsk).getTaskId()),
                                EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 4:
                        selectedEmp = EmployeeHolder.getEmployee(employeeIndex);
                        selectedEmp.ViewAssignedTasks();
                        System.out.println("Please select which task do you want to complete:");
                        tsk = scanner.nextInt();
                        scanner.nextLine();
                        selectedEmp.CompleteTask(selectedEmp.getTaskArray().get(tsk));
                        new Log(new String("Task with ID: " + selectedEmp.getTaskArray().get(tsk).getTaskId() +
                                " has been claimed as completed"), EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        employeeRunning = false;
                        new Log("Quit from system", EmployeeHolder.getEmployee(employeeIndex).getName());
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            }
        }


        scanner.close();
    }

    public static boolean isPasswordValid(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                // Check for special characters using ASCII values
                if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) {
                    hasSpecialCharacter = true;
                }
            }
        }

        // hepsi okeyse true doner
        return hasUppercase && hasLowercase && hasDigit && hasSpecialCharacter;
    }

}
