package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Lucky13Test {

    /*
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     * GetLucky([0, 2, 4]) → true
     * GetLucky([1, 2, 3]) → false
     * GetLucky([1, 2, 4]) → false
     */

    Lucky13 sut;

    @Before
    public void setup(){
        sut = new Lucky13();
    }

    @Test
    public void containsNo1or3() {
        // Arrange
        int[] nums = new int[] {2,4,5,6};

        // Act
        boolean noOnesOrThrees = sut.getLucky(nums);

        // Assert
        assertTrue("1 in array so expect false, " + Arrays.toString(nums), noOnesOrThrees);
    }

    @Test
    public void contains1() {
        // Arrange
        int[] nums = new int[] {1,4,5,6};

        // Act
        boolean noOnesOrThrees = sut.getLucky(nums);

        // Assert
        assertFalse("1 in array so expect false, " + Arrays.toString(nums), noOnesOrThrees);
    }

    @Test
    public void contains3() {
        // Arrange
        int[] nums = new int[] {0,4,5,3};

        // Act
        boolean noOnesOrThrees = sut.getLucky(nums);

        // Assert
        assertFalse("1 in array so expect false, " + Arrays.toString(nums), noOnesOrThrees);
    }
}
