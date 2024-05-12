package org.example;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Log {// Log kayıtları için sınıf olmalı bu sınıf action, kimin yaoptığı ve zaman içermeli (sinem)
    private String action;
    private String performedBy;
    private LocalDateTime timestamp;

    public Log(String action, String performedBy) {
        this.action = action;
        this.performedBy = performedBy;
        this.timestamp=LocalDateTime.now();

    }

    public String toString(){
        return "{"+timestamp+"}" +action+"performed by "+ performedBy;
    }
}
