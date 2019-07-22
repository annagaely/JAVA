package com.accenture.java.coding.assessment.attendancesummary;

import java.time.LocalTime;

public class Trainee {
    private String eid;
    private LocalTime date;
    private boolean isOnTime;

    public Trainee(String eid, LocalTime date, boolean isOnTime) {
        this.eid = eid;
        this.date = date;
        this.isOnTime = isOnTime;
    }
    public String getEid() {
        return eid;
    }

    public LocalTime getDate() {
        return date;
    }

    public boolean isOnTime() {
        return isOnTime;
    }
}
