package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {
      /*
     Given an array of ints length 3, figure out which is larger between the first and last elements
     in the array, and set all the other elements to be that value. Return the changed array.
     MakeArray([1, 2, 3]) → [3, 3, 3]
     MakeArray([11, 5, 9]) → [11, 11, 11]
     MakeArray([2, 11, 3]) → [3, 3, 3]

     Tests:
     - 3 example test cases
     - test empty array
     - test array with all negative numbers
     - test case when first and last values are the same
     - test array with length greater than 3
     - test case with all 0s
     - test case with one 0
     */

    @Test
    public void makeArray() {

        //arrange

        MaxEnd3 code = new MaxEnd3();

        int [] testArray = {1, 2, 3};
        int expectedValue = 3;

        //act

        int [] returnedArray=code.makeArray(testArray);

        //assert

        for(int eachValue: returnedArray){

            Assert.assertEquals(expectedValue, eachValue);
        }
    }





}