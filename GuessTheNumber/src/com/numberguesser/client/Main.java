package com.numberguesser.client;

import com.numberguesser.NumberGuesser;

class Main {
    public static void main(String[] args) {
        NumberGuesser game = new NumberGuesser(0, 20);
        game.start();
    }
}