package com.accenture.java.coding.assessment.demorandomizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoRandomizer {
    private List<LearnersList> learnersList = new ArrayList<>();
    private List<LearnersList> listOfAbsentLearners = new ArrayList<>();
    private List<LearnersList> listOfRandomizeLearners = new ArrayList<>();
    public List<LearnersList> readFile(String demoList, int demoTime) throws IOException {
        demoList = "outputs/demolist.csv";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(demoList));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                int lateTimeMinutes = Integer.parseInt(words[2]);
                LearnersList learnList = new LearnersList(words[0], words[1], lateTimeMinutes);
                learnersList.add(learnList);
                //all the learners will be saved in the learnersList
                for (LearnersList absent : learnersList) {
                    //the trainees that are absent will be added to the listOfAbsentLearners
                    if (absent.getStatus().equals("absent")) {
                        LearnersList absentList = new LearnersList(absent.getEid(), absent.getStatus(), lateTimeMinutes);
                        listOfAbsentLearners.add(absentList);

                    }
                }


//                if (words[1].equals( "absent")) {
//                    LearnersList absentList = new LearnersList(words[0], words[1], lateTimeMinutes);
//                    listOfAbsentLearners.add(absentList);
//                } else {
//                    LearnersList presentList = new LearnersList(words[0], words[1], lateTimeMinutes, demoTime);
//
//                    listOfRandomizeLearners.add(presentList);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//        }for(int i = 0; i < learnersList.size(); i++) {
//            System.out.println(learnersList.get(i).getEid());
//        } for (int j = 0; j < listOfAbsentLearners.size(); j++) {
//            System.out.println(listOfAbsentLearners.get(j).getEid());
//        }
            //instantiating the totalDemoTime method
            int x = totalDemoTime(demoTime);
            for (LearnersList allLearners : learnersList){
                //putting the present/late learners in the listOfRandomizeLearners list
                if (allLearners.getStatus().equals("present")) {
                    LearnersList presentList = new LearnersList(allLearners.getEid(), allLearners.getStatus(), allLearners.getLateTime(), x-allLearners.getLateTime());
                    listOfRandomizeLearners.add(presentList);

                }
            }
            print();
            return learnersList;
        }
    }
    //computing the totalDemoTime for every learner
    public int totalDemoTime(int demoTime) {
        int timePerStudent = (demoTime*60)/(learnersList.size() - listOfAbsentLearners.size());
        return timePerStudent;
    }

        public void print() throws IOException{
            System.out.println();
            System.out.println("=PRESENT PARTICIPANTS=\n");
            System.out.println("Position\t\t" +
                    "EID\t\t" +
                    "Late Time\t\t" +
                    "Total time for Demo\n");
            int count = 1;
            //printing the present participants
            for (int i = 0; i < learnersList.size(); i++) {
                System.out.println(count + "\t\t" + listOfRandomizeLearners.get(i).getEid() + "\t\t\t\t" +
                        listOfRandomizeLearners.get(i).getLateTime() + "\t\t\t\t" +
                        listOfRandomizeLearners.get(i).getTimeForDemo());
                count++;
            }
            //printing the absent participants
            System.out.println("\n\n=ABSENT PARTICIPANTS=\n");
            int countAbsent = 1;
            for (int j = 0; j < listOfAbsentLearners.size(); j++) {

                System.out.println(countAbsent + "\t\t" + listOfAbsentLearners.get(j).getEid() + "\t\t" +
                        listOfAbsentLearners.get(j).getStatus());
                countAbsent +=1;
            }

        }
    }

