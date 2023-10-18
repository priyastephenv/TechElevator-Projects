package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    /*
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "Herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * GetHerd("giraffe") → "Tower"
     * GetHerd("") -> "unknown"
     * GetHerd("walrus") -> "unknown"
     * GetHerd("Rhino") -> "Crash"
     * GetHerd("rhino") -> "Crash"
     * GetHerd("elephants") -> "unknown"
     *
     */

    @Test
    public void testAllLowercase() {
        AnimalGroupName group = new AnimalGroupName();
        String actualResult=group.getHerd("giraffe");
        Assert.assertEquals("Tower", actualResult);
    }
    @Test
    public void test_With_Starting_Capital_Letter() {
        AnimalGroupName group = new AnimalGroupName();
        String actualResult=group.getHerd("Rhino");
        Assert.assertEquals("Crash", actualResult);
    }
    @Test
    public void test_All_Uppercase() {
        AnimalGroupName group = new AnimalGroupName();
        String actualResult=group.getHerd("FLAMINGO");
        Assert.assertEquals("Pat", actualResult);
    }
    @Test
    public void test_Empty_String() {
        AnimalGroupName group = new AnimalGroupName();
        String actualResult=group.getHerd(" ");
        Assert.assertEquals("unknown", actualResult);
    }
    @Test
    public void test_Unlisted_Animal() {
        AnimalGroupName group = new AnimalGroupName();
        String actualResult=group.getHerd("walrus");
        Assert.assertEquals("unknown", actualResult);
    }

    @Test
    public void test_null() {
        AnimalGroupName group = new AnimalGroupName();
        String actualResult=group.getHerd(null);
        Assert.assertEquals("unknown", actualResult);
    }



}