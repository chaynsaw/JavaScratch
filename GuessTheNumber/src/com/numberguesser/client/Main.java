package com.numberguesser.client;

import com.numberguesser.NumberGuesser;

class Main {
    public static void main(String[] args) {
        NumberGuesser game = new NumberGuesser(0, 20);
        for (int i = 0; i < 100; i++) {
            game.setCorrectNumber(0, 20);
            System.out.println(game.getCorrectNumber());
        }
    }
}