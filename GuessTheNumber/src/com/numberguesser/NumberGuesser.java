package com.numberguesser;

import java.util.Scanner;

public class NumberGuesser {
    private int correctNumber;
    private int min;
    private int max;
    private Scanner sc = new Scanner(System.in);

    public NumberGuesser(int min, int max) {
        setCorrectNumber(min, max);
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(int min, int max) {
        this.min = min;
        this.max = max;
        this.generateCorrectNumber();
    }

    public int generateCorrectNumber() {
        if (max > min) {
            this.correctNumber = (int) (Math.random() * (max - min + 1) + min);
            return this.correctNumber;
        } else {
            throw new IllegalArgumentException(max + "-" + min + " is not a valid range.");
        }
    }

    public void start() {
        System.out.println("Please guess a number from " + min + "-" + max);
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int guess = sc.nextInt();
                if (guess == correctNumber) {
                    System.out.println(guess + " was correct! Yay!");
                    return;
                } else {
                    System.out.println(guess + " was not correct. Try again!");
                }
            } else {
                System.out.println("Please enter a whole number.");
                sc.next();
            }
        }
    }
}