package com.accenture.java.coding.assessment.attendancesummary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendanceSummary {
    private List<Trainee> trainee = new ArrayList<>();
    private List<Trainee> onTime = new ArrayList<>();
    private List<Trainee> late = new ArrayList<>();
    public void readFile(String path) throws IOException {
        System.out.println("Reading the file: " + path);
        System.out.println("Call time: 8:00");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\\\Users\\\\anna.g.t.balingit\\\\Desktop\\\\result.csv"));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String[] timeNow = data[1].split(":");
                int first = Integer.parseInt(timeNow[0]);
                int second = Integer.parseInt(timeNow[1]);
                LocalTime formattedTime = LocalTime.of(first, second);
                LocalTime callTime = LocalTime.of(9, 1);
                //the late trainees will be saved in the trainee list
                if(formattedTime.isAfter(callTime)) {
                    Trainee trainees = new Trainee(data[0], formattedTime, false);
                    trainee.add(trainees);
                    //the on time trainees will be saved in the trainee list
                }else {
                    Trainee trainees = new Trainee(data[0], formattedTime, true);
                    trainee.add(trainees);
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (Trainee notLate : trainee) {
            //after saving all the trainees in the trainee list. they will be grouped
            //on time
            if (notLate.isOnTime()) {
                onTime.add(notLate);
                //late
            } else {
                late.add(notLate);
            }
        }

        System.out.println("Late");
        for (Trainee late : late) {
            System.out.println(late.getEid() + "\t" + late.getDate().toString());
        }
        System.out.println("Ontime");
        for (Trainee onTime: onTime) {
            System.out.println(onTime.getEid()+ "\t" + onTime.getDate().toString());
        }


    }
}
