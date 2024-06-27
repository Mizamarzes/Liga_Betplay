package com.liga_betplay;

import java.util.Scanner;

import com.utils.ConsoleUtils;
import com.view.mainmenu;

public class Main {
    public static void main(String[] args) {
        Scanner loginsc = new Scanner(System.in);
        //user para desarrollo
        String user1 = "santi";
        String passw1 = "123";
        ConsoleUtils.clear();

        System.out.print("\n" +
        "-------------------------\n" +
        "   BetPlay Admin Panel   \n" +
        "-------------------------\n" +
        "\n" +
        "Enter your username: ");
        String user = loginsc.nextLine();
        ConsoleUtils.clear();
        System.out.print("\n" +
        "-------------------------\n" +
        "   BetPlay Admin Panel   \n" +
        "-------------------------\n" +
        "\n" +
        "Enter your password: ");

        String password = loginsc.nextLine();
        ConsoleUtils.clear();

        if (user.equals(user1) && passw1.equals(password) ) {
            mainmenu main = new mainmenu();           
            main.showmenu();
        } else {
            System.out.println("Incorrect username or password.");
        }

        loginsc.close();
    }


    
}