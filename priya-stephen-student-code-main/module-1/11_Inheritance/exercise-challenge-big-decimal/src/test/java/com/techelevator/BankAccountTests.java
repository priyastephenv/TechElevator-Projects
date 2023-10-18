package com.techelevator;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.lang.reflect.*;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BankAccountTests {

    private static Class account;

    @BeforeClass
    public static void classShouldExist() {
        try {
            account = Class.forName("com.techelevator.BankAccount");
        } catch (Exception e) {
            fail("com.techelevator.BankAccount class does not exist");
        }
    }

    @Test
    public void shouldContainFieldAccountHolderName() {
        Field f = SafeReflection.getDeclaredField(account, "accountHolderName");
        assertNotNull("Field accountHolderName does not exist", f);
        assertEquals("Field accountHolderName should be of Type String", "java.lang.String", f.getType().getName());
        assertTrue("Field accountHolderName should be private",Modifier.isPrivate(f.getModifiers()));
    }

    @Test
    public void shouldContainFieldAccountNumber() {
        Field f = SafeReflection.getDeclaredField(account, "accountNumber");
        assertNotNull("Field accountNumber does not exist", f);
        assertEquals("Field accountNumber should be of Type String", "java.lang.String", f.getType().getName());
    }

    @Test
    public void shouldContainFieldBalance() {
        Field f = SafeReflection.getDeclaredField(account, "balance");
        assertNotNull("Field balance does not exist",f);
        assertEquals("Field balance should be of Type BigDecimal", "java.math.BigDecimal", f.getType().getName());
    }

    @Test
    public void bankAccountHasTwoArgsConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        assertNotNull("com.techelevator.BankAccount should contain a 2 argument constructor that sets account holder name and number.",constructor);
    }

    @Test
    public void bankAccountHasThreeArgsConstructor() {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class, BigDecimal.class);
        assertNotNull("com.techelevator.BankAccount should contain a 3 argument constructor that sets account holder name, number and balance.",constructor);
    }

    @Test
    public void twoArgumentConstructorShouldSetNameAndNumber() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        assertNotNull("com.techelevator.BankAccount should contain a 2 argument constructor that sets account holder name and number.",constructor);

        Object bankAccount = constructor.newInstance("John Smith", "CHK:1234");

        Method getAccountNameHolder = bankAccount.getClass().getMethod("getAccountHolderName");
        assertEquals("John Smith", getAccountNameHolder.invoke(bankAccount));

        Method getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
        assertEquals("CHK:1234", getAccountNumber.invoke(bankAccount));

        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(new BigDecimal(0), getBalance.invoke(bankAccount));
    }

    @Test
    public void newCustomerHasZeroBalance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        Object bankAccount = constructor.newInstance("","");
        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(new BigDecimal(0), getBalance.invoke(bankAccount));
    }

    @Test
    public void threeArgumentConstructorShouldSetNameNumberAndBalance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class, BigDecimal.class);
        assertNotNull("com.techelevator.BankAccount should contain a 3 argument constructor that sets account holder name, number and balance.",constructor);

        Object bankAccount = constructor.newInstance("John Smith","CHK:1234", new BigDecimal(1));
        Method getAccountNameHolder = bankAccount.getClass().getMethod("getAccountHolderName");
        assertEquals("John Smith", getAccountNameHolder.invoke(bankAccount));

        Method getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
        assertEquals("CHK:1234", getAccountNumber.invoke(bankAccount));

        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(new BigDecimal(1), getBalance.invoke(bankAccount));
    }

    @Test
    public void accountHolderNameShouldOnlyHaveAGetter() {
        assertTrue("Account Holder Name field should have a getter",SafeReflection.hasGetter(account, "AccountHolderName"));
        assertFalse("Account Holder Name field should not have a setter",SafeReflection.hasSetter(account, "AccountHolderName"));
    }

    @Test
    public void accountNumberShouldOnlyHaveAGetter() throws NoSuchMethodException {
        assertTrue("Account Number field should have a getter",SafeReflection.hasGetter(account, "AccountNumber"));
        assertFalse("Account Number field should not have a setter",SafeReflection.hasSetter(account, "AccountNumber"));
    }

    @Test
    public void balanceShouldOnlyHaveAGetter() throws NoSuchMethodException {
        assertTrue("Balance field should have a getter",SafeReflection.hasGetter(account, "Balance"));
        assertFalse("Balance field should not have a setter method",SafeReflection.hasSetter(account, "Balance"));
    }

    @Test
    public void depositIncreasesBalance() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        Object bankAccount = constructor.newInstance("","");

        Method deposit = bankAccount.getClass().getMethod("deposit", BigDecimal.class);
        assertEquals(new BigDecimal(1), deposit.invoke(bankAccount, new BigDecimal(1)));

        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(new BigDecimal(1), getBalance.invoke(bankAccount));
    }

    @Test
    public void withdrawDecreasesBalance() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        Object bankAccount = constructor.newInstance("","");

        Method withdraw = bankAccount.getClass().getMethod("withdraw", BigDecimal.class);
        assertEquals(new BigDecimal(-1), withdraw.invoke(bankAccount, new BigDecimal(1)));

        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(new BigDecimal(-1), getBalance.invoke(bankAccount));
    }

}
