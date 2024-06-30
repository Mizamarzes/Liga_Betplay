package com.liga_betplay.view;

import java.util.Scanner;

import com.liga_betplay.utils.ConsoleUtils;

public class trainingsAndConvocations {

    Scanner menusc = new Scanner(System.in);

    public void show() {
        ConsoleUtils.clear();
        int op;

        do {
            System.out.println("--------------------------------");
            System.out.println("   Trainings and Convocations   ");
            System.out.println("--------------------------------");
            System.out.println(" ");
            System.out.println("1. Training Management");
            System.out.println("2. Player Call-up Management");
            
            op = menusc.nextInt(); 

            switch (op) {
                case 1:
                    System.out.println("submenu-1");
                    break;
                case 2:
                    System.out.println("submenu-2");
                    break;
            
                default:
                    break;
            }
        } while (op != 1);
    }

}
