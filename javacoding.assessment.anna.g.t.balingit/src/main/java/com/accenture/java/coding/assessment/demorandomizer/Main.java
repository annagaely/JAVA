package com.accenture.java.coding.assessment.demorandomizer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        DemoRandomizer printOutput = new DemoRandomizer();
//        printOutput.print();
        DemoRandomizer readFILE = new DemoRandomizer();
        readFILE.readFile("outputs/demolist.csv", 4);
    }
}
