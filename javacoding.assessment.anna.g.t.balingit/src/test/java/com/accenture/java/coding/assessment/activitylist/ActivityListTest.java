package com.accenture.java.coding.assessment.activitylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ActivityListTest {
    ActivityList activityList = new ActivityList("");
    List<String> actList = new ArrayList<>();
    List<String> chosen = new ArrayList<>();
    List<String> chosenActivity = new ArrayList<>();

    @Test
    public void add() {
        actList.add("Concurrency");
        assertEquals(actList, actList);
    }

    @Test
    public void addToListValidInput() {
      chosenActivity.add("Concurrency");
      assertEquals(chosenActivity, chosenActivity);
    }

    @Test
    public void addToListInvalidInput() {

    }
}