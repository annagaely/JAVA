package com.accenture.java.coding.assessment.attendancesummary;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AttendanceSummary readFILE = new AttendanceSummary();
        readFILE.readFile("outputs/result.csv");
    }
}
