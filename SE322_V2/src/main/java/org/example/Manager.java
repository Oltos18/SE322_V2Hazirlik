package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Manager extends Employee{    // DivideToSubtasks methodu yok
    HashMap<Worker,Task> WaitingForApprove = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    
    public Manager(String id, String name, String contactDetails, String jobRole){
        super(id, name, contactDetails, jobRole);
    }

    // bunun çalışması için bizim employeeleri tuttuğumuz bir genel arrayden, input olarak verilen employee objesini silmemiz lazım
    public Employee FireEmployee(Employee input){
        return null;
    }

    //bunun icinde yaratınca genel bir employee arrayi varsa içine atabilir ya da return ettigi yerde eklenebilir
    public Employee CreateEmployee(String EmployeeID, String name, String ContactDetail, String jobRole){
        return new Employee(EmployeeID, name, ContactDetail, jobRole);
    }

    //just for the change the employee attributes
    public void UpdateEmployee(Employee employee){
        int temp_input =0;
        System.out.println();
        System.out.println("To change employee ID press 1 \nTo change employee name press 2 \nTo change employee contact detail press 3 \nTo change employee job role press 4 \n");
        temp_input = scanner.nextInt();
        if (temp_input==1){
            int temp_input_2=0;
            System.out.println("Enter new ID");
            temp_input_2=scanner.nextInt();
            employee.setId(Integer.toString(temp_input_2));
        }
        else if(temp_input==2){
            String temp_input_string_2="";
            System.out.println("Enter new name");
            temp_input_string_2= scanner.nextLine();
            employee.setName(temp_input_string_2);
        }
        else if(temp_input==3){
            String temp_input_string_3="";
            System.out.println("Enter new contact detail");
            temp_input_string_3= scanner.nextLine();
            employee.setContactDetails(temp_input_string_3);
        }
        else if(temp_input==4){
            String temp_input_string_3="";
            System.out.println("Enter new job role");
            temp_input_string_3= scanner.nextLine();
            employee.setJobRole(temp_input_string_3);
        }
    }

    public void AddToWaitingForApprove(Worker worker,Task task){
        WaitingForApprove.put(worker, task);
    }

    public void RemoveFromWaitingForApproveArraylist(){
        //For each task we should show description of task and comment of worker and manager should decide if task is finished or not.
        for(Map.Entry<Worker,Task> set: WaitingForApprove.entrySet()){
            System.out.print("Task Description: ");
            System.out.println(set.getValue().getDescription());
            System.out.print("Worker Comment: ");
            System.out.println(set.getValue().getWorkerComment());
            System.out.println("Is Finished (Write \"Yes\" or \"No\")");
            String string = scanner.nextLine();

            if (string.toLowerCase().replace(" ","").equals("yes")){
                WaitingForApprove.remove(set.getKey(),set.getValue());
            }
            else if (string.toLowerCase().replace(" ","").equals("no")){
                GiveTask(set.getKey(),set.getValue());
            }
            else{
                System.out.println("Wrong input given and task skipped");
            }
        }



    }

    public void GiveTask(Employee employee, Task task){
        employee.addTaskArray(task);
    }

    public void updateTask(TaskHolder holder,EmployeeHolder employeeHolder){
        ArrayList<Task> tempList = holder.getAssignedList();
        TaskHolder.showTasks(tempList);

        System.out.println("Which Task Do You Want to Change? Give Number Please");
        int realChoice;
        while (true){
            int choice = scanner.nextInt();
            if (choice> tempList.size()){
                System.out.println("Your number is bigger than our list. Please try again");
                continue;
            } else if (choice<0) {
                System.out.println("Your number is not a index number. Please give a bigger number than 0");
                continue;
            } else {
                System.out.println("You enter "+ choice + "Is this what you want? \"Y\" or \"N\"");
                String choice2 = scanner.nextLine();
                choice2.toUpperCase();
                if (choice2.equals("N")){
                    System.out.println("Please enter new number:");
                    continue;
                }
                else if(choice2.equals("Y")){
                    realChoice = choice;
                    System.out.println("What do you want to change? For Description enter \"D\". For Employee please \"E\"");
                    choice2 = scanner.nextLine();
                    if (choice2.toUpperCase().equals("D")){
                        System.out.println("Enter New Description");
                        choice2 = scanner.nextLine();
                        tempList.get(choice).setDescription(choice2);
                    } else if (choice2.toUpperCase().equals("E")) {
                        tempList.get(choice).showAssignedPeople();
                        System.out.println("What do you want yo do?\n1-Add\n2-Delete");
                        int choice3 = scanner.nextInt();
                        if (choice3 == 1){
                            employeeHolder.showEmployees();
                            System.out.println("Which employee do you want to choose give an index");
                        }
                        else if(choice3 == 2){

                        }
                        else {
                            System.out.println("You can only enter \"1\" or \"2\". Please do not give another number.");
                        }
                    }else {
                        System.out.println("You can only enter \"D\" or \"E\". Please do not give another answer.");
                    }
                }
                else {
                    System.out.println("You cannot enter \"Y\" or \"N\". Please give another number.");
                }
            }
        }

    }
}
