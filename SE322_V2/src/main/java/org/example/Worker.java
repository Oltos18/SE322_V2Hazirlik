package org.example;

class Worker extends Employee{
    Manager manager;

    public Worker(String id, String name, String contactDetails, String jobRole,Manager manager_1){
        super(id, name, contactDetails, jobRole);
        manager=manager_1;
    }

    @Override
    public void CompleteTask(Task task) {
        super.CompleteTask(task);
        manager.AddToWaitingForApprove(this,task);
    }

    public String toString() {
        return "Worker{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", contactDetails='" + getContactDetails() + '\'' +
                ", jobRole='" + getJobRole() + '\'' +
                ", allTasks=" + super.getTaskArray() +
                ", completedTasks =" + super.getCompletedTasks() +
                '}';
    }
}
