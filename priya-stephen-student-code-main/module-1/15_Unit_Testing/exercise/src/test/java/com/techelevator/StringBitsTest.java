package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {
    /*
     * Given a string, return a new string made of every other char starting with
     * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
     * → "H" GetBits("Heeololeo") → "Hello"
     */

    @Test
    public void normalString() {
        StringBits test = new StringBits();

        String result = test.getBits("Hello");

        Assert.assertEquals("Hlo", result);
    }

    @Test
    public void shortString() {
        StringBits test = new StringBits();

        String result = test.getBits("Hi");

        Assert.assertEquals("H", result);
    }

    @Test
    public void getBits3() {
        StringBits test = new StringBits();

        String result = test.getBits("Heeololeo");

        Assert.assertEquals("Hello", result);
    }


    @Test
    public void getBits4() {
        StringBits test = new StringBits();

        String result = test.getBits("");

        Assert.assertEquals("", result);
    }
}