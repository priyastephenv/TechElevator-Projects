package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class SavingsAccountTests {

    private static Class savAccount;

    @BeforeClass
    public static void checkingAccountClassShouldExist() {
        try {
            savAccount = Class.forName("com.techelevator.SavingsAccount");
        } catch (Exception e) {
            fail("com.techelevator.SavingsAccount class does not exist");
        }
    }

    @Test
    public void savingsAccountShouldExtendBankAccount() {
        Class superclass = savAccount.getSuperclass();
        assertEquals("Savings Account should inherit from Bank Account",superclass.getName(),"com.techelevator.BankAccount");
    }

    @Test
    public void shouldHaveTwoArgumentConstructor() {
        Constructor constructor = SafeReflection.getConstructor(savAccount,String.class, String.class);
        assertNotNull("com.techelevator.SavingsAccount should contain a 2 argument constructor that calls the matching BankAccount constructor.",constructor);
    }

    @Test
    public void shouldHaveThreeArgumentConstructor() {
        Constructor constructor = SafeReflection.getConstructor(savAccount,String.class, String.class, BigDecimal.class);
        assertNotNull("com.techelevator.SavingsAccount should contain a 3 argument constructor that calls the matching BankAccount constructor.",constructor);
    }

    @Test
    public void tryToWithdrawFromNegativeBalance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(savAccount,String.class,String.class,BigDecimal.class);
        Object savingsAccount = constructor.newInstance("", "", new BigDecimal(-1));

        Method withdraw = savingsAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = savingsAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(savingsAccount, new BigDecimal(1));
        assertEquals(new BigDecimal(-1), newBalance);
        assertEquals(new BigDecimal(-1), getBalance.invoke(savingsAccount));
    }

    @Test
    public void sendPositiveIntoNegativeTest() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(savAccount,String.class,String.class, BigDecimal.class);
        Object savingsAccount = constructor.newInstance("", "", new BigDecimal(1));

        Method withdraw = savingsAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = savingsAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(savingsAccount, new BigDecimal(-2));
        assertEquals(new BigDecimal(1), newBalance);
        assertEquals(new BigDecimal(1), getBalance.invoke(savingsAccount));
    }

    @Test
    public void tryToWithdrawFromPositiveBalance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(savAccount,String.class,String.class,BigDecimal.class);
        Object savingsAccount = constructor.newInstance("", "", new BigDecimal(200));

        Method withdraw = savingsAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = savingsAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(savingsAccount, new BigDecimal(10));
        assertEquals(new BigDecimal(190), newBalance);
        assertEquals(new BigDecimal(190), getBalance.invoke(savingsAccount));
    }

    @Test
    public void tryToWithdrawFromBalanceBelow150() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(savAccount,String.class,String.class,BigDecimal.class);
        Object savingsAccount = constructor.newInstance("", "", new BigDecimal(151));

        Method withdraw = savingsAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = savingsAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(savingsAccount, new BigDecimal(10));
        assertEquals(new BigDecimal(139), newBalance);
        assertEquals(new BigDecimal(139), getBalance.invoke(savingsAccount));
    }
}
