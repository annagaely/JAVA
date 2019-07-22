package com.accenture.java.coding.assessment.attendancelist;

import java.time.LocalDateTime;

public class Student {
    private String eid;
    private LocalDateTime now;
    public String getEid() {
        return eid;
    }
    public LocalDateTime getNow() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(now.toString(), formatter);
        return now;
    }
    public Student(String eid, LocalDateTime now) {
        this.eid = eid;
        this.now = now;
    }
}
