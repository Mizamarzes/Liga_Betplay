package com.liga_betplay;

import com.liga_betplay.auth.Login;

public class Main {
    public static void main(String[] args) {

        // New class declared Database
        Login login = new Login();
        // Auth and login of the users
        login.start();

    
    }
}