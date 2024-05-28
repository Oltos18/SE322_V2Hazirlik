package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Report { //This is for weekly or daily report
    Scanner reportScanner = new Scanner(System.in);
    ArrayList<Employee> employees;
    Calendar calendar = Calendar.getInstance();
    LocalDateTime localDateTime;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            employees = EmployeeHolder.getEmployeesArraylist();
            localDateTime = LocalDateTime.now();
            LocalDateTime past = localDateTime.minus(7, ChronoUnit.DAYS);
            for(Employee e: employees){
                int point=0;
                for(Task task :e.getCompletedTasks()){
                    if(task.getEndDate().isAfter(past) && task.endDate.isBefore(localDateTime)){
                        point+= task.getTaskPoint();
                    }
                }
                System.out.println("Employee " + e.getName() + " get " + point + " points");
            }
        }
    };

    public Report(){
        setReportTimer();
        addToCalender();
    }

    public void setReportTimer(){
        boolean bool = false;
        String tempString="";

        while (!bool){
            System.out.println("Please enter time period for reports. Write \"Day\" for daily and \"Week\" for weekly reports"); // burayi duzelt daha guzel bir string yaz
            tempString = reportScanner.nextLine();
            if(tempString.toLowerCase().replace(" ","").equals("day")||tempString.toLowerCase().replace(" ","").equals("week")){
                bool=true;
            }
        }

        if(tempString.toLowerCase().replace(" ","").equals("day")){
            calendar.add(Calendar.DATE,1);
            System.out.println("Report scheduled daily");
        }
        else if(tempString.toLowerCase().replace(" ","").equals("week")){
            calendar.add(Calendar.DATE,7);
            System.out.println("Report scheduled weekly");
        }
    }

    public void addToCalender(){
        timer.schedule(task,calendar.getTime());
    }
}
