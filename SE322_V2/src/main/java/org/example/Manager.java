package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Manager extends Employee{    // DivideToSubtasks methodu yok

    HashMap<Worker,Task> WaitingForApprove=new HashMap<>();

    public void AddToWaitingForApprove(Worker worker,Task task){
        WaitingForApprove.put(worker, task);
    }

    public void RemoveFromWaitingForApproveArraylist(Task task){
        //For each task we should show description of task and comment of worker and manager should decide if task is finished or not.
        for(Map.Entry<Worker,Task> set: WaitingForApprove.entrySet()){
            System.out.println("Task Description: ");
            System.out.println(task.getDescription());
            System.out.println("Worker Comment: ");
            System.out.println(task.getWorkerComment());
        }
    }

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

    public void UpdateEmployee(Employee employee){
        Scanner scanner = new Scanner(System.in);
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

    public void GiveTask(Employee employee, Task task){
        employee.addTaskArray(task);
    }
}
