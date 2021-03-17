package com.numberguesser;

public class NumberGuesser {
    private int correctNumber;
    private int min;
    private int max;
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

    public void begin() {

    }
}