package com.view;

import java.util.Scanner;

public class statsAndReports {

    Scanner menusc = new Scanner(System.in);

    public void show() {
        cleanscreen.clear();
        int op;

        do {
            System.out.println("-----------------------");
            System.out.println("   Stats and Reports   ");
            System.out.println("-----------------------");
            System.out.println(" ");
            System.out.println("1. Menu 1");
            System.out.println("2. Menu 2");
            
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
