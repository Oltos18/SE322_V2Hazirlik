package org.example;

import java.util.ArrayList;

class TaskHolder{
    ArrayList<Task> arrayList = new ArrayList<>();

    public void showUnAssigned(){ //prints all unassigned task in the main tasklist
        for (Task task : arrayList) {
            if (!task.isAssigned()){
                System.out.println(task.toString());
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
}
