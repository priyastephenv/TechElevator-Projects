package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {
    /*
         Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
         and 39 return true, but 40 returns false.
         (Hint: Think "mod".)
         less20(18) → true
         less20(19) → true
         less20(20) → false
     */
    @Test
    public void isTwoLessThanMultipleOf20() {
        Less20 number = new Less20();
        boolean result = number.isLessThanMultipleOf20(18);

        Assert.assertEquals(true, result);

    }
    @Test
    public void isOneLessThanMultipleOf20() {
        Less20 number = new Less20();
        boolean result = number.isLessThanMultipleOf20(19);

        Assert.assertEquals(true, result);

    }

    @Test
    public void is20() {
        Less20 number = new Less20();
        boolean result = number.isLessThanMultipleOf20(20);

        Assert.assertEquals(false, result);

    }
    @Test
    public void is40() {
        Less20 number = new Less20();
        boolean result = number.isLessThanMultipleOf20(40);

        Assert.assertEquals(false, result);

    }

    @Test
    public void isMoreThan60() {
        Less20 number = new Less20();
        boolean result = number.isLessThanMultipleOf20(61);

        Assert.assertEquals(false, result);

    }
}