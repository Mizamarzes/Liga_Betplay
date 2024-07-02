package com.liga_betplay;

import com.liga_betplay.auth.Login;
import com.liga_betplay.data.DatabaseInitializer;
import com.liga_betplay.utils.ConsoleUtils;

public class Main {
    public static void main(String[] args) {

        // New class declared Database
        DatabaseInitializer initializer = new DatabaseInitializer();

        // New class declared Database
        Login login = new Login();

        // Tables and database Created
        initializer.createTables();

        ConsoleUtils.clear();

        // Auth and login of the users
        login.start();
    }
}