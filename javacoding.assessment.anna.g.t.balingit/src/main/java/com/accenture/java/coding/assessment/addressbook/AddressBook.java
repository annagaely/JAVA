package com.accenture.java.coding.assessment.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    public List<Details> list = new ArrayList<>();
    //reads file
    public List<Details> readFile(String path) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Details oldDetails = new Details(data[0], data[1], data[2], data[3]);
                list.add(oldDetails);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //prints the details
        for (Details addressBook : list) {
                    System.out.println(addressBook.getName() + "\t" +
                            addressBook.getLocation() + "\t\t" +
                            addressBook.getContactNumber() + "\t\t" +
                            addressBook.getEmail());
        }
        Scanner input = new Scanner(System.in);
//        boolean quit = true;
//        while(quit == false)
        System.out.println("Select a choice");
        System.out.println("1 - Add\n" +
                "2 - Edit\n" +
                "3 - Delete\n" +
                "4 - Generate Updated Report");
        int choice = input.nextInt();
        //add
        if (choice == 1) {
            System.out.println("Insert name you want to add");
            String addName = input.next();
            String cap1 = addName.substring(0,1).toUpperCase();
            String name = cap1 + addName.substring(1);
            boolean isExisting = false;
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i).getName().equals(name)) {
                        isExisting = true;
                    }
                }
            }
            if(isExisting == true) {
                System.out.println("Error: Name already exists");
            }
            else{
                System.out.println("Insert Location");
                String addLocation = input.next();
                String cap2 = addLocation.substring(0,1).toUpperCase();
                String location = cap2 + addLocation.substring(1);
                System.out.println("Insert number");
                String addNumber = input.next();
                String cap3 = addNumber.substring(0,1).toUpperCase();
                String contactNumber = cap3 + addNumber.substring(1);
                System.out.println("Insert email");
                String addEmail = input.next();
                System.out.println("Add Page");
                add(name, location, contactNumber, addEmail);


//                for(Details added : list) {
//                    System.out.println(added.getName()+added.getLocation()+added.getContactNumber()+added.getEmail());
//                }
            }
            //edit
        } else if (choice == 2) {
            System.out.println("Select name to edit");
            String editName = input.next();
            String cap1 = editName.substring(0,1).toUpperCase();
            String editedName = cap1 + editName.substring(1);
            boolean exists = false;
            if(list.size() > 0) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getName().equals(editedName)) {
                        exists = true;
                    }
                }
            }
            if (!exists) {
                System.out.println("Name doesn't exist");
            }
            else{
                System.out.println("Select new location");
                String editLocation = input.next();
                String cap2 = editLocation.substring(0,1).toUpperCase();
                String editedLocation = cap2 + editLocation.substring(1);
                System.out.println("Select new number");
                String editNumber = input.next();
                String cap3 = editNumber.substring(0,1).toUpperCase();
                String editedNumber = cap3 + editNumber.substring(1);
                System.out.println("Select new email");
                String editedEmail = input.next();
                System.out.println("Edit Page");
                edit(editedName, editedLocation, editedNumber, editedEmail);

            }


        }

        return list;
    }

    //add method
    public List<Details> add(String name, String location, String contactNumber, String email) throws IOException {
        Details addDetails = new Details(name, location, contactNumber, email);
        list.add(addDetails);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "\t" +
                    list.get(i).getLocation() + "\t" +
                    list.get(i).getContactNumber() + "\t" +
                    list.get(i).getEmail());
        }
//        readFile("C:\\Users\\anna.g.t.balingit\\Desktop\\AddressBook.csv");
        return list;
    }
    public List<Details> edit(String name, String location, String contactNumber, String email) {
//        for (Details edit : list) {
//
//
//        }
//        list.set()
        return list;
    }
    public List<Details> delete (String name) {
        return list;
    }
    public void generatedUpdatedReport() {

    }
}
