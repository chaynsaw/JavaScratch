package com.duckracer;

public class DuckRacer {
    public void begin() throws InterruptedException {
        int i = 0;
        StringBuilder string = new StringBuilder();
        while (i < 10) {
            System.out.println("\f");
            Thread.sleep(1000);
            i++;
            string.append("-");
            System.out.println(string);
        }
    }
}