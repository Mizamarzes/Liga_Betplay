package com.liga_betplay;

import java.util.Scanner;

import com.liga_betplay.data.DatabaseInitializer;
import com.liga_betplay.utils.ConsoleUtils;
import com.liga_betplay.view.mainmenu;

public class Main {

    private static final String DEFAULT_USERNAME = "santi";
    private static final String DEFAULT_PASSWORD = "123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConsoleUtils.clear();
        System.out.print("\n" +
        "-------------------------\n" +
        "   BetPlay Admin Panel   \n" +
        "-------------------------\n" +
        "\n" +
        "Enter your username: ");
        String username = scanner.nextLine().trim();

        ConsoleUtils.clear();
        System.out.print("\n" +
        "-------------------------\n" +
        "   BetPlay Admin Panel   \n" +
        "-------------------------\n" +
        "\n" +
        "Enter your password: ");
        String password = scanner.nextLine().trim();

        ConsoleUtils.clear();

        if (authenticate(username, password)) {
            DatabaseInitializer initializer = new DatabaseInitializer();
            initializer.createTables();

            mainmenu mainMenu = new mainmenu();
            mainMenu.showmenu();
        } else {
            System.out.println("Incorrect username or password.");
        }

        scanner.close();
    }

    private static boolean authenticate(String username, String password) {
        return DEFAULT_USERNAME.equals(username) && DEFAULT_PASSWORD.equals(password);
    }
}