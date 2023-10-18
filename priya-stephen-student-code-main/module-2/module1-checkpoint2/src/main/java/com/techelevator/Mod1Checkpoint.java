package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Mod1Checkpoint extends PC{

    public Mod1Checkpoint(String cpu, String memory, String graphicsCard) {
        super(cpu, memory, graphicsCard);
    }

    public static void main(String[] args) {
        PC pc1 = new PC("NITEL", "8", "EONRAD");

        PC pc2 = new PC("DAM", "8", "FORCEG");

        System.out.println(pc1.toString() + "\n" + pc2.toString());

        File order = new File("Orders.csv");
        try {
            Scanner readFile = new Scanner(order);
            while (readFile.hasNext()) {
                String line =readFile.nextLine();
                String [] newAttributes = line.split(",");

                PC anotherPC = new PC(newAttributes [0], newAttributes [1], newAttributes [2]);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean offerDiscount (PC object, boolean isMember) {

        boolean isDiscountOffered;
        if (object.getPrice().compareTo(new BigDecimal("2000")) == 1 & isMember ==true) {

            isDiscountOffered = true;
        } else {

            isDiscountOffered = false;
        }
        return isDiscountOffered;
    }









}
