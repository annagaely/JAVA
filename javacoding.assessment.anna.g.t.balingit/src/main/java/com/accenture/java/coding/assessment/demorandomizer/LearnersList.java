package com.accenture.java.coding.assessment.demorandomizer;

public class LearnersList {
    private String eid;
    private String status;
    private int lateTime;
    private int timeForDemo;
    public LearnersList(String eid, String status, int lateTime) {
        this.eid = eid;
        this.status = status;
        this.lateTime = lateTime;
    }

    public LearnersList(String eid, String status, int lateTime, int timeForDemo) {
        this.eid = eid;
        this.status = status;
        this.lateTime = lateTime;
        this.timeForDemo = timeForDemo;
    }

    public String getEid() {
        return eid;
    }

    public String getStatus() {
        return status;
    }

    public int getLateTime() {
        return lateTime;
    }

    public int getTimeForDemo() {
        return timeForDemo;
    }


}
