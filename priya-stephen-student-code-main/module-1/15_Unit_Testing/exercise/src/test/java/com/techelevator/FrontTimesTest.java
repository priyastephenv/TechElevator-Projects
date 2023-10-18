package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {
    /*
     * Given a string and a non-negative int n, we'll say that the front of the
     * string is the first 3 chars, or whatever is there if the string is less than
     * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
     * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
     * "AbcAbcAbc"
     */

    @Test
    public void string_with_more_than_3_characters() {
        FrontTimes test = new FrontTimes();

       String result = test.generateString("Alejandro", 2);

        Assert.assertEquals("AleAle", result);

    }
    @Test
    public void shortString() {
        FrontTimes test = new FrontTimes();

        String result = test.generateString("No", 5);

        Assert.assertEquals("NoNoNoNoNo", result);

    }
    @Test
    public void threeLetterString() {
        FrontTimes test = new FrontTimes();

        String result = test.generateString("Abc", 3);

        Assert.assertEquals("AbcAbcAbc", result);

    }
}