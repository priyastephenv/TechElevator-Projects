package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {

    /*
     When squirrels get together for a party, they like to have cigars. A squirrel party is successful
     when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
     there is no upper bound on the number of cigars. Return true if the party with the given values is
     successful, or false otherwise.
     haveParty(30, false) → false
     haveParty(50, false) → true
     haveParty(70, true) → true
     */

    @Test
    public void weekday_below_cigar_limit() {

        CigarParty test = new CigarParty();
        boolean result = test.haveParty(30, false);

        Assert.assertEquals(false, result);
    }
    @Test
    public void weekday_above_cigar_limit() {

        CigarParty test = new CigarParty();
        boolean result = test.haveParty(90, false);

        Assert.assertEquals(false, result );
    }

    @Test
    public void weekday_within_lower_cigar_limit() {

        CigarParty test = new CigarParty();
        boolean result = test.haveParty(40, false);

        Assert.assertEquals(true, result);
    }

    @Test
    public void weekday_within_higher_cigar_limit() {

        CigarParty test = new CigarParty();
        boolean result = test.haveParty(60, false);

        Assert.assertEquals(true, result);
    }

    @Test
    public void weekend_above_cigar_limit() {

        CigarParty test = new CigarParty();
        boolean result = test.haveParty(70, true);

        Assert.assertEquals(true,result);
    }



}