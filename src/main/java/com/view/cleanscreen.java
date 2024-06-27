package com.view;

public class cleanscreen {

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
