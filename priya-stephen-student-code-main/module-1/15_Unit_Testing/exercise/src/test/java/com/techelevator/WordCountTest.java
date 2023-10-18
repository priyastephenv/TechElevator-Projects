package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {
    /*
     * Given an array of strings, return a Map<String, Integer> with a key for
     * each different string, with the value the number of times that string appears
     * in the array.
     *
     * ** A CLASSIC **
     *
     * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
     * getCount([]) → {}
     * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
     *
     */
    @Test
    public void getDoubleWords() {

        WordCount test = new WordCount();
        Map result = test.getCount(new String [] {"ba", "ba", "black", "sheep"});


        Assert.assertEquals(2, result.get("ba"));
        Assert.assertEquals(1, result.get("black"));
        Assert.assertEquals(1, result.get("sheep"));


    }
    @Test
    public void getDoubleCharacters() {

        WordCount test = new WordCount();
        Map result = test.getCount(new String [] {"b", "a", "c", "b"});


        Assert.assertEquals(2, result.get("b"));
        Assert.assertEquals(1, result.get("a"));
        Assert.assertEquals(1, result.get("c"));


    }
    @Test
    public void getEmpty() {

        WordCount test = new WordCount();
        Map result = test.getCount(new String [] {});
        Map expected = new HashMap();

        Assert.assertEquals(expected,result);


    }

    @Test
    public void getCountNoDuplicate() {

        WordCount test = new WordCount();
        Map result = test.getCount(new String [] {"b", "a", "c", });


        Assert.assertEquals(1, result.get("b"));
        Assert.assertEquals(1, result.get("a"));
        Assert.assertEquals(1, result.get("c"));


    }



}