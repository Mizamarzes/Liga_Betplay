package com.liga_betplay;

import com.liga_betplay.auth.Login;
import com.liga_betplay.data.DatabaseInitializer;
import com.liga_betplay.utils.ConsoleUtils;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer initializer = new DatabaseInitializer();
        Login login = new Login();
        initializer.createTables();
        ConsoleUtils.clear();
        login.start();
    }
}