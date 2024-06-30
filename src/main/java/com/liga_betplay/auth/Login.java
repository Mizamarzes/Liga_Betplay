package com.liga_betplay.auth;

import java.util.Scanner;

import com.liga_betplay.model.User;
import com.liga_betplay.model.dao.UserDao;
import com.liga_betplay.view.mainmenu;

public class Login {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();


        System.out.println("---------------------");
        System.out.println("    BetPlay Panel    ");
        System.out.println("---------------------");
        System.out.print("\nEnter your username: ");
        String username = scanner.nextLine().trim();

        System.out.print("\nEnter your password: ");
        String password = scanner.nextLine().trim();
        System.out.println();

        try {
            User user = new User();
            user.setName(username);
            user.setPassword(password);

            if (userDao.authUser(user)) {
                mainmenu mainMenu = new mainmenu(username);
                mainMenu.showmenu();
            } else {
                System.out.println("Incorrect username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during authentication: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
