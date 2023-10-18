package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SameFirstLastTest {
    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true
     */

    @Test
    public void elementsNotEqual() {

        SameFirstLast test = new SameFirstLast();
        boolean result = test.isItTheSame(new int []{ 1, 2, 3});

        Assert.assertEquals( false, result);
    }
    @Test
    public void elementsEqual() {

        SameFirstLast test = new SameFirstLast();
        boolean result = test.isItTheSame(new int []{ 1, 2, 3, 1});

        Assert.assertEquals( true, result);
    }

    @Test
    public void elementsEqualAndShort() {

        SameFirstLast test = new SameFirstLast();
        boolean result = test.isItTheSame(new int []{ -6, 5, -6});

        Assert.assertEquals( true, result);
    }

    @Test
    public void elementsIsDuplicated() {

        SameFirstLast test = new SameFirstLast();
        boolean result = test.isItTheSame(new int []{ 6, 6, 3});

        Assert.assertEquals( false, result);
    }

    @Test
    public void length1() {

        SameFirstLast test = new SameFirstLast();
        boolean result = test.isItTheSame(new int []{ 6});

        Assert.assertEquals( true, result);
    }
}