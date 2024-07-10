package com.betplay;

import com.betplay.auth.LoginService;

public class Main {
    public static void main(String[] args) {
        // New class declared Database
        LoginService login = new LoginService();
        // Auth and login of the users
        login.start();    
    }
}