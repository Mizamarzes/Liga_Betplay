package com.betplay.auth;

import java.util.Scanner;

import com.betplay.domain.entity.User;
import com.betplay.view.mainmenu;

public class LoginService {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        UserRepository userRep = new UserRepository();


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

            if (userRep.authUser(user)) {
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
