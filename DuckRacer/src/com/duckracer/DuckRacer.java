package com.duckracer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DuckRacer {
    int raceLength;
    List<String> raceProgress = new ArrayList<>();
    public DuckRacer(int raceLength) {
        raceProgress.add(".");
        for (int i = 1; i < raceLength; i++) {
            raceProgress.add(" ");
        }
        raceProgress.add(".");
    }
    public void begin() {
        int i = 1;
        while (i < 50) {
            raceProgress.set(i, ".");
            i++;
        }
        System.out.println(String.join("", raceProgress));
    }
}