package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {
    /*
      Given 2 strings, return their concatenation, except omit the first char of each. The strings will
      be at least length 1.
      GetPartialString("Hello", "There") → "ellohere"
      GetPartialString("java", "code") → "avaode"
      GetPartialString("shotl", "java") → "hotlava"
      */
    @Test
    public void getPartialString1() {
        NonStart testCase = new NonStart();

        String result =testCase.getPartialString("Hello", "There");

        Assert.assertEquals("ellohere", result);
    }
    @Test
    public void getPartialString2() {
        NonStart testCase = new NonStart();

        String result =testCase.getPartialString("java", "code");

        Assert.assertEquals("avaode", result);
    }

    @Test
    public void differentLengthWords() {
        NonStart testCase = new NonStart();

        String result =testCase.getPartialString("electric", "pie");

        Assert.assertEquals("lectricie", result);
    }
    @Test
    public void getPartialString3() {
        NonStart testCase = new NonStart();

        String result =testCase.getPartialString("k", "l");

        Assert.assertEquals("", result);
    }

}