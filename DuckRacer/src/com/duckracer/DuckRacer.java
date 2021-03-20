package com.duckracer;

import java.util.Arrays;
import java.util.Scanner;

public class DuckRacer {
    String[] raceProgress = new String[50];
    public DuckRacer() {
        raceProgress[0] = ".";
        for (int i = 1; i < 49; i++) {
            raceProgress[i] = " ";
        }
        raceProgress[49] = ".";
    }
    public void begin() {
        int i = 0;
        System.out.println(String.join("", Arrays.asList(raceProgress)));
    }
}