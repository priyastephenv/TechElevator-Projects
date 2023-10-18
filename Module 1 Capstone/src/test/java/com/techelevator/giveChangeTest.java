package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class giveChangeTest {

    private Purchase purchase;


    @Test
    public void giveChange(){

        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal actual = Purchase.giveChange(new BigDecimal(3.00));
        assertEquals(actual, expected);

    }



    @Test
    public void giveChange2(){

        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal actual = Purchase.giveChange(new BigDecimal(10.00));
        assertEquals(actual, expected);

    }

}