package org.example;

import java.util.ArrayList;
import java.util.List;
//Receiver (sinem)
class Employee { // ViewUnAssigned yapılmadı + separateTask diye bi method var onu konuşmamız lazım
    private String id;
    private String name;
    private String contactDetails;
    private String jobRole;
    private ArrayList<Task> taskArray;
    private ArrayList<Task> completedTask;

    public Employee(String id, String name, String contactDetails, String jobRole) {
        this.id = id;
        this.name = name;
        this.contactDetails = contactDetails;
        this.jobRole = jobRole;
        this.taskArray = new ArrayList<>();
        this.completedTask = new ArrayList<>();
    }

    // Getters and setters for employee attributes
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public List<Task> getTaskArray() {
        return taskArray;
    }

    public void setTaskArray(ArrayList<Task> taskArray) {
        this.taskArray = taskArray;
    }

    public void addTaskArray(Task goal) { //also calls assignTask script
        this.taskArray.add(goal);
        goal.setStatus(Task.TaskStatus.INPROGRESS);
        goal.AddToEmpList(this);
    }

    public List<Task> getCompletedTasks() {
        return completedTask;
    }

    public void addCompletedTasks(Task task) {
        this.completedTask.add(task);
    }

    // Method to assign a task to this employee
    private void assignTask(Task task) {
        task.setAssigned(true);
    }

    public void ViewAssignedTasks(){
        for(Task task:taskArray){
            System.out.println("Task ID is " + task.getTaskId()+ " Task Description is " + task.getDescription());
        }
    }

    //bu method şuan boş. Genel task arrayinden assigned olmayanlar check edilip burada yazdırılabilir
    public void ViewUnAssignedTasks(){

    }

    //Bu methodu Workera mı yoksa Managera mı koyacağımıza karar verememiştik ben Employee koydum direkt yeri değişebilir ileride
    public void CompleteTask(Task task){
        task.setStatus(Task.TaskStatus.DONE);
        completedTask.add(task);
        taskArray.remove(task);
    }

    // bu method Sinem'in attığı java dosyası ile gelmişti ondan silmedim. Sizle konuşup silmek istedim
    // Method to separate a task to subtasks
    public void separateTask(Task task, ArrayList<Task> subTasks) {
        task.getSubTasks().addAll(subTasks);
    }

    // toString method to represent employee information as a string
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", allTasks=" + taskArray +
                ", completedTasks =" + completedTask +
                '}';
    }
}
