package com.accenture.java.coding.assessment.addressbook;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("ReadFile Page where path is AddressBook.csv");
        AddressBook readFILE = new AddressBook();
        readFILE.readFile("outputs/AddressBook.csv");
        }
    }

