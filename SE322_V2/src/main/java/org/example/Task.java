package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String taskId;
    private String description;
    private String workerComment;
    private List<TaskComponent> subTasks;  //Bunu Composite Interface liğinden dolayı TaskComponenttan alır.(sinem)    private boolean assigned; // Sinem'in kodundan geldi bunu ve alakalı şeyleri silmedim
    public enum TaskStatus{
        TODO,INPROGRESS,DONE
    }
    private TaskStatus status;
    private int taskPoint;
    private ArrayList<Employee> empList;

    public Task(String taskId, String description,int point) {
        this.taskId = taskId;
        this.description = description;
        this.subTasks = new ArrayList<>();
        this.assigned = false;
        this.empList = new ArrayList<>();
        status = TaskStatus.TODO;
        taskPoint = point;
    }


    // Getters and setters for task attributes
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskComponent> getSubTasks() {
        return subTasks;
    }
    @Override
    public void addSubTask(TaskComponent task) {
        subTasks.add(task);
    }
    @Override
    public void removeSubTask(TaskComponent task) {
        subTasks.remove(task);
    }
    @Override
    public void assignTask(Employee employee) { //Görev atayacak (sinem) ve bunu output verir
        System.out.println("Task "+ taskId+"assigned to employee:\n"+employee.getName());

    }


    public boolean isAssigned() {
        return assigned;
    }
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public void setStatus(TaskStatus taskStatus){
        status=taskStatus;
    }
    public TaskStatus getStatus(){
        return status;
    }

    public int getTaskPoint() {
        return taskPoint;
    }
    public void setTaskPoint(int taskPoint) {
        this.taskPoint = taskPoint;
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }
    public void setEmpList(ArrayList<Employee> empList) {
        this.empList = empList;

        if (this.empList.size()>0){
            assigned = true;
        }
        else {
            assigned = false;
        }
    }

    public void AddToEmpList(Employee employee){
        empList.add(employee);

        if (this.empList.size()>0){
            assigned = true;
        }
        else {
            assigned = false;
        }
    }
    public void removeFromEmpList(Employee employee){
        for(Employee employee_ID : empList){
            if(employee.getId().equals(employee_ID)){
                empList.remove(employee_ID);
            }
        }
    }

    public String getWorkerComment() {
        return workerComment;
    }
    public void setWorkerComment(String workerComment) {
        this.workerComment = workerComment;
    }

    public void showAssignedPeople(){
        for (int i = 0; i< empList.size();i++){
            Employee emp = empList.get(i);
            System.out.println(i + "-" + emp.getId() + " : " + emp.getName());
        }
    }

    // toString method to represent task information as a string
    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", description='" + description + '\'' +
                ", subTasks=" + subTasks +
                ", assigned=" + assigned +
                '}';
    }

    public void addEmp(Employee emp){
        empList.add(emp);
    }
}


