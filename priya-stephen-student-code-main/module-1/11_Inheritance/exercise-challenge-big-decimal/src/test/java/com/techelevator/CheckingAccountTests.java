package com.techelevator;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CheckingAccountTests {

    private static Class chkAccount;

    @BeforeClass
    public static void checkingAccountClassShouldExist() {
        try {
            chkAccount = Class.forName("com.techelevator.CheckingAccount");
        } catch (Exception e) {
            fail("com.techelevator.CheckingAccount class does not exist");
        }
    }

    @Test
    public void checkingAccountShouldExtendBankAccount() {
        Class superclass = chkAccount.getSuperclass();
        assertEquals("Checking Account should inherit from Bank Account",superclass.getName(),"com.techelevator.BankAccount");
    }

    @Test
    public void shouldHaveTwoArgumentConstructor() {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class, String.class);
        assertNotNull("com.techelevator.CheckingAccount should contain a 2 argument constructor that calls the matching BankAccount constructor.",constructor);
    }

    @Test
    public void shouldHaveThreeArgumentConstructor() {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class, String.class, BigDecimal.class);
        assertNotNull("com.techelevator.CheckingAccount should contain a 3 argument constructor that calls the matching BankAccount constructor.",constructor);
    }

    @Test
    public void withdrawNegativeWithFeeBalance_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,BigDecimal.class);
        Object checkingAccount = constructor.newInstance("", "", new BigDecimal(-1));

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(checkingAccount, new BigDecimal(1));
        assertEquals(new BigDecimal(-12), newBalance);
        assertEquals(new BigDecimal(-12), getBalance.invoke(checkingAccount));
    }

    @Test
    public void withdrawPositiveWithFee_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,BigDecimal.class);
        Object checkingAccount = constructor.newInstance("", "", new BigDecimal(-1));

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(checkingAccount, new BigDecimal(2));
        assertEquals(new BigDecimal(-13), newBalance);
        assertEquals(new BigDecimal(-13), getBalance.invoke(checkingAccount));
    }

    @Test
    public void withdrawNegativeBalanceBelow100_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,BigDecimal.class);
        Object checkingAccount = constructor.newInstance("", "", new BigDecimal(-100));

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(checkingAccount, new BigDecimal(2));
        assertEquals(new BigDecimal(-100), newBalance);
        assertEquals(new BigDecimal(-100), getBalance.invoke(checkingAccount));
    }

    @Test
    public void withdrawPositiveBalance_Test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(chkAccount,String.class,String.class,BigDecimal.class);
        Object checkingAccount = constructor.newInstance("", "", new BigDecimal(10));

        Method withdraw = checkingAccount.getClass().getMethod("withdraw", BigDecimal.class);
        Method getBalance = checkingAccount.getClass().getMethod("getBalance");
        BigDecimal newBalance = (BigDecimal) withdraw.invoke(checkingAccount, new BigDecimal(5));
        assertEquals(new BigDecimal(5), newBalance);
        assertEquals(new BigDecimal(5), getBalance.invoke(checkingAccount));
    }
}
