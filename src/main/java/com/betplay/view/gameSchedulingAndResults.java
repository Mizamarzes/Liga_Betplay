package com.betplay.view;

import java.util.Scanner;

import com.betplay.utils.ConsoleUtils;

public class gameSchedulingAndResults {

    Scanner menusc = new Scanner(System.in);

    public void show() {
        ConsoleUtils.clear();
        int op;

        do {
            System.out.println("----------------------------------");
            System.out.println("    Game Scheduling and Results   ");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("1. Game Scheduling");
            System.out.println("2. Results Registration");
            
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
