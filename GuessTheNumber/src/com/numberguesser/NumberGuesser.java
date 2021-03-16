package com.numberguesser;

public class NumberGuesser {
    private int correctNumber;
    public NumberGuesser(int x, int y) {
        setCorrectNumber(x, y);
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(int x, int y) {
        if (y > x) {
            this.correctNumber = (int) Math.random() * ((y - x) + x);
        } else {
            throw new IllegalArgumentException(y + "-" + x + " is not a valid range.");
        }
    }
}