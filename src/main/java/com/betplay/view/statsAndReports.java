package com.betplay.view;

import java.util.Scanner;

import com.betplay.utils.ConsoleUtils;

public class statsAndReports {

    Scanner menusc = new Scanner(System.in);

    public void show() {
        ConsoleUtils.clear();
        int op;

        do {
            System.out.println("-----------------------");
            System.out.println("   Stats and Reports   ");
            System.out.println("-----------------------");
            System.out.println(" ");
            System.out.println("1. Visualización de Estadísticas");
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
