package com.cybertek.library.utilities;

public class BrowserUtils {
    public static void sleep(int seconds) {
        seconds*=1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
