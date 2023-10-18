package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExercisesTest {

    private Exercises exercises;

    @Before
    public void setup() {
        exercises = new Exercises();
    }

    @Test
    public void test_average() {
        Assert.assertEquals(4.0, exercises.average(new double[]{3,4,5}), 0.01);
    }

    @Test
    public void test_average2() {
        Assert.assertEquals(1.0, exercises.average(new double[]{1,1}), 0.01);
    }

    @Test
    public void test_specificGreeting1() {
        Assert.assertEquals("Hello Erica!", exercises.specificGreeting("Erica"));
    }

    @Test
    public void test_specificGreeting2() {
        Assert.assertEquals("Hello Robert!", exercises.specificGreeting("Bob"));
    }

    @Test
    public void test_getEmployeeNames1() {

        String [] input = {
                "001", "Gustavo", "123 Crooked Lane",
                "002", "Lisa", "456 Redwood Drive",
                "003", "Rajiv", "789 Success Circle"
        };

        List<String> expected = new ArrayList<>();
        expected.add("Gustavo");
        expected.add("Lisa");
        expected.add("Rajiv");

        Assert.assertEquals(expected, exercises.getEmployeeNames(input));
    }

    @Test
    public void test_getEmployeeNames2() {

        String [] input = {
                "001", "Andy", "123 Crooked Lane",
                "002", "Jeremy", "456 Redwood Drive",
                "003", "Sondra", "789 Success Circle"
        };


        Assert.assertEquals(3, exercises.getEmployeeNames(input).size());
    }

}