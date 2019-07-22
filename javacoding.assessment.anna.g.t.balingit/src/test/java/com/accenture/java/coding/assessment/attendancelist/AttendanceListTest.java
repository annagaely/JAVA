package com.accenture.java.coding.assessment.attendancelist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AttendanceListTest {
    AttendanceList attendanceList = new AttendanceList();
    List<Student> students = new ArrayList<>();
    @Test
    public void enterLearnerValidTest() {
        String result = attendanceList.enterLearner("anna");
        assertEquals("EID successfully added", result);
    }

    @Test
    public void enterLearnerInvalidInput() {
        attendanceList.enterLearner("anna");
        assertEquals("The user already exists", attendanceList.enterLearner("anna"));    }

    @Test
    public void generateOutput() {

    }
}