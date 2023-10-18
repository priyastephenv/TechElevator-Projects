package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BuyingSnacksTest {



    private  Purchase purchase;

    @Before
    public void setup(){
        this.purchase = new Purchase();
    }

    @Test
    public void buyingSnacks(){



        Product product = new Product("A1", "U-Chews", new BigDecimal("1.65"), "Gum");

        Product expectedResult = Product.getBySlot("A1");

        assertEquals(expectedResult.getProductName(), product.getProductName());
    }

    @Test
    public void buyingSnacks2(){



        Product product = new Product("B4", "Wonka Bar", new BigDecimal("2.35"), "Candy");

        Product expectedResult = Product.getBySlot("B4");

        assertEquals(expectedResult.getProductName(), product.getProductName());
    }
}