package org.example;

import java.util.ArrayList;

public class EmployeeHolder {
    ArrayList<Employee> arrayList = new ArrayList<>();

    public void AddToArraylist(Employee emp){
        arrayList.add(emp);
    }

    public void showEmployees(){
        for (int i = 0; i< arrayList.size();i++){
            Employee tempEmp = arrayList.get(i);
            System.out.println(i + "-" + tempEmp.getId() + " : " + tempEmp.getName());
        }
    }

    public Employee getEmployee(int index){
        return arrayList.get(index);
    }
}
