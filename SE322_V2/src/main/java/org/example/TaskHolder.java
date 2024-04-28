package org.example;

import java.util.ArrayList;

class TaskHolder{
    ArrayList<Task> arrayList = new ArrayList<>();
    public void showUnAssigned(){
        for (Task task : arrayList) {
            if (!task.isAssigned()){
                System.out.println(task.toString());
            }
        }
    }

    public void AddToArraylist(Task task){
        arrayList.add(task);
    }
}
