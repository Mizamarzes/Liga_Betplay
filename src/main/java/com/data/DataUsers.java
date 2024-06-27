package com.data;

import java.util.ArrayList;
import java.util.List;

import com.entity.User;

public class DataUsers {

    public static List<User> users = new ArrayList<>();

    public static void defaultUsers() {
        DataRols.defaultRols();

        users.add(new User(1, "Santiago", "santiago@gmail.com", "santi123", DataRols.rols.get(0)));
    }
}
