package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    void setReportTimerPositive() {  // NEEDS TO BE FIXED
        Report report = new Report();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 1);
        report.calendar = calendar;

        report.setReportTimer();

        Calendar expectedCalendar = Calendar.getInstance();
        expectedCalendar.set(2024, Calendar.MAY, 8); // one week later

        assertEquals(expectedCalendar.getTime(), calendar.getTime()); // testing whether calendar updates correctly
    }

    @Test
    void setReportTimerNegative() {
    }

}