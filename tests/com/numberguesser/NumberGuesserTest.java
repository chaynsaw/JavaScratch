package com.numberguesser;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class NumberGuesserTest {
    private NumberGuesser numberGuesser;
    private int min = 0;
    private int max = 20;

    @Before
    public void setUp() throws Exception {
        numberGuesser = new NumberGuesser(min, max);
    }

    @Test
    public void generateCorrectNumber_generatesAllNumbersInRange() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 150; i++) {
            set.add(numberGuesser.generateCorrectNumber());
        }
        assertEquals(21, set.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void generateCorrectNumber_throwsIllegalArgumentException_onInvalidRange() {
        NumberGuesser invalidNumGuesser = new NumberGuesser(20, 0);
    }
}