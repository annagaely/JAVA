package com.accenture.java.coding.assessment.attendancelist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceList {
    private List<Student> student = new ArrayList<Student>();
    public void addData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Who do you want to add");
        String eID = input.nextLine();
//        String returned = enterLearner(eID);
//        System.out.println(returned);
        enterLearner(eID);

        //loop through the list and print each student object
        for(int i = 0; i < student.size(); i++){
            LocalDateTime tempTime = student.get(i).getNow();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String formattedDateTime = tempTime.format(formatter);
            System.out.println(student.get(i).getEid() + "    " + formattedDateTime);
        }

        choice();
    }
    public String enterLearner(String eid){
        boolean isExisting = false;
        if(student.size() > 0){
            //loop through the list and check if the entered eid is existing
            for(int i = 0; i < student.size(); i++){
                if(student.get(i).getEid().equals(eid)){
                    isExisting = true;
                }
            }
        }
        //eid exists
        if(isExisting == true){
            String print = "The user already exists";
            System.out.println(print);
            return print;
        }
        //eid doesn't exist
        else {
            //the input will be added to the list
            String print = "EID successfully added";
            Student stud = new Student(eid, LocalDateTime.now());
            student.add(stud);
            System.out.println(print);

            return print;
        }
    }
    public void choice(){
        System.out.println("Do you want to add more?(Y/N)");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        choiceInput = choiceInput.toUpperCase();
        if(choiceInput.equals("Y")){
            addData();
        }else if (choiceInput.equals("N")) {
            generateOutput();
        } else {
            System.out.println("Invalid Input");
            choice();
        }
    }
    public File generateOutput(){

        File file = new File("outputs/result.csv");
        Boolean isExisting = file.exists();
        try{
            FileWriter csvWriter = new FileWriter(file);
            for(int i = 0; i < student.size(); i++){
                //get the data of student and store it for later writing
                String tempEID = student.get(i).getEid();
                LocalDateTime tempTime = student.get(i).getNow();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                String formattedDateTime = tempTime.format(formatter);
                csvWriter.append(tempEID);
                csvWriter.append(",");
                csvWriter.append(formattedDateTime);
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }catch (IOException e){
            System.out.println(e);
        }

        if(isExisting){
            System.out.println("File already replaced.");
        }else{
            System.out.println("File generated.");
        }
        return file;
    }
}