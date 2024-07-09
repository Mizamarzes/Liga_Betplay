package com.betplay.view;

import java.util.Scanner;

import com.betplay.utils.ConsoleUtils;

public class communicationsAndPublicRelations {

    Scanner menusc = new Scanner(System.in);

    public void show() {
        ConsoleUtils.clear();
        int op;

        do {
            System.out.println("-----------------------------------------");
            System.out.println("   Communications and Public Relations   ");
            System.out.println("-----------------------------------------");
            System.out.println(" ");
            System.out.println("1. Gestión de Noticias y Comunicados");
            System.out.println("2. Gestión de Relaciones Públicas");
            
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
