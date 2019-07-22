package com.accenture.java.coding.assessment.activitylist;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ActivityList {


    private String activity;
    private List<String> actList = new ArrayList<>();
    private List<String> chosenActivity = new ArrayList<>();
    private Learners learn = new Learners("Anna", 50);
    public ActivityList(String activity) {
        this.activity = activity;
    }
    public List<String> getActList() {
        return actList;
    }
    public List<String> getChosenActivity() {
        return chosenActivity;
    }
    public void add() {
        actList.add("Concurrency");
        actList.add("Collections");
        actList.add("Naming Conventions");
        actList.add("Junit");
        actList.add("Termination");
        addToList();
    }
    //adding the chosen activity to chosenActivity list
    public void addToList() throws InputMismatchException {
        System.out.print("LIST OF ACTIVITIES: ");
        System.out.print(getActList());
        Scanner input = new Scanner(System.in);
        System.out.println("\nChoose activity from 1 to 5 press 0 to terminate and 9 to view result");
        int actChoice = input.nextInt();

        while (true) {
            if(actChoice == 1) {
                chosenActivity.add("Concurrency");
            } else if (actChoice == 2) {
                chosenActivity.add("Collections");
            } else if (actChoice == 3) {
                chosenActivity.add("Naming Conventions");
            } else if (actChoice == 4) {
                chosenActivity.add("Junit");
            } else if (actChoice == 5) {
                chosenActivity.add("Termination");
            } else if (actChoice == 9) {
                print();
                break;
            } else if (actChoice == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid input");
            }
            System.out.println(getChosenActivity());
            if(actChoice != 9) {
                System.out.println("Choose another? " + getActList());
                actChoice = input.nextInt();
            }


        }


        }
        //counts the minutes per activity
        public int totalHours(int totalHours) {
            int calculatedMinutes = totalHours * 60;
            return calculatedMinutes/chosenActivity.size();
    }
    public void print() {

            if(chosenActivity.isEmpty() == true) {
                System.out.println("** NO TOPICS CHOSEN INVALID INPUT **");
            }
            else {
                System.out.print("Name: " + learn.getName());
                System.out.println("\n\n-------------------------");
                for (String chosen : chosenActivity){
                    System.out.println("*" + chosen);
                }
                System.out.println("\n\n-------------------------");
                System.out.print("Total Minutes Per Activity: " + totalHours(learn.getHours()) +"\n");

            }

    }

}
