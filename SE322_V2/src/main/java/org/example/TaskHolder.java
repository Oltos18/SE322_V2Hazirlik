package org.example;

import java.util.ArrayList;

class TaskHolder{
    ArrayList<Task> arrayList = new ArrayList<>();

    public void showUnAssigned(){ //prints all unassigned task in the main tasklist
        int index = 0;
        for (int i = 0; i<arrayList.size(); i++) {
            if (!(arrayList.get(i).isAssigned())){
                System.out.println( index +": "+ arrayList.get(i).toString());
                index++;
            }
        }
    }

    public void showAssigned(){ //prints all unassigned task in the main tasklist
        int index = 0;
        for (int i = 0; i<arrayList.size(); i++) {
            if (arrayList.get(i).isAssigned()){
                System.out.println(index +": "+ arrayList.get(i).toString());
                index++;
            }
        }
    }

    public ArrayList<Task> getAssignedList(){ //returns all assigned tasks in the task list. Returns an arraylist format
        ArrayList<Task> temp = new ArrayList<>();
        for (Task task : arrayList) {
            if (task.isAssigned()){
                temp.add(task);
            }
        }
        return temp;
    }

    public ArrayList<Task> getUnAssignedList(){ //returns all assigned tasks in the task list. Returns an arraylist format
        ArrayList<Task> temp = new ArrayList<>();
        for (Task task : arrayList) {
            if (!(task.isAssigned())){
                temp.add(task);
            }
        }
        return temp;
    }

    public void AddToArraylist(Task task){
        arrayList.add(task);
    }

    public static void showTasks(ArrayList<Task> tasks){
        for (int i = 0; i< tasks.size();i++){
            Task task = tasks.get(i);
            System.out.println(i + "-" + task.getTaskId() + "\n" +
                    "  " + task.getDescription()+ "\n" +
                    "  " + task.getEmpList() );
        }
    }

    public Task getTask(int index) {
        return arrayList.get(index);
    }

    public void showCompletedTask(){
        int index = 0;
        for (int i = 0; i< arrayList.size();i++){
            Task task = arrayList.get(i);
            if (task.getStatus() == Task.TaskStatus.DONE) {
                System.out.println(index + "-" +" Task ID: " + task.getTaskId() + "\n" +
                        "Description: " + task.getDescription()+ "\n" +
                        "Employees: " + empSplitter(task.getEmpList()) +
                        "End Date: " + task.getEndDate() + "\n");
                index++;
            }

        }
    }

    public String empSplitter(ArrayList<Employee> emps){
        String s = "";
        for (Employee e : emps){
            s += "\n   Employee Name: " + e.getName() + "\n"+
            "   Employee ID: " + e.getId() + "\n";
        }
        return s;
    }
}
