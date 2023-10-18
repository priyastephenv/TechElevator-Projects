package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    /*
     * sut => System Under Test
     */
    private JdbcParkDao sut;
    private Park testPark;

    @Before
    public void setup() {
        // ARRANGE: get object of parkDao
        sut = new JdbcParkDao(dataSource);
        // public Park(int parkId, String parkName, LocalDate dateEstablished, double area, boolean hasCamping) {
        this.testPark = new Park(-1, "Jellystone", LocalDate.now(), 4200, false);
    }

    @Test
    public void getParkById_returns_correct_park() {

        /*
         * Park getParkById(int parkId);
         */
        // ARRANGE:
        int parkIdToTest = 1;

        // ACT
        Park park = sut.getParkById(parkIdToTest);

        // ASSERT
        // assert park_id
        // assert park_name
        // assert date_established
        // ...
        assertParksMatch(PARK_1, park);

        /*
         * Test another park to make sure it works
         */
        parkIdToTest = 2;
        park = sut.getParkById(parkIdToTest);
        assertParksMatch(PARK_2, park);

        // TODO: figure out how to test all parks in an array...
    }

    @Test
    public void getParkById_returns_null_when_id_not_found() {
        /*
         * Park getParkById(int parkId);
         */

        // ARRANGE
        int invalidParkId = 42;

        // ACT
        Park returnedPark = sut.getParkById(invalidParkId);

        // ASSERT
        Assert.assertNull(returnedPark);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {

        /*
         * List<Park> getParksByState(String stateAbbreviation);
         */

        // ARRANGE
        String StateAbbreviationToTest = "AA";
        int expectedParksReturned = 2;
        List<Park> expectedParks = new ArrayList<>();
        List<Park> actualParks;
        expectedParks.add(PARK_1);
        expectedParks.add(PARK_3);

        // ACT
        actualParks = sut.getParksByState(StateAbbreviationToTest);

        // ASSERT: test ONLY 2 parks returned
        Assert.assertEquals(expectedParksReturned, actualParks.size());

        // ASSERT: test both parks are PARK_1 and PARK_3
        for(int i = 0; i < expectedParks.size(); i++){
            assertParksMatch(expectedParks.get(i), actualParks.get(i));
        }
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        /*
         * List<Park> getParksByState(String stateAbbreviation);
         */

        // ARRANGE
        int numExpectedParks = 0;
        String stateAbbreviationNotInDatabase = "ZZ";
        List<Park> actualParks;

        // ACT
        actualParks = sut.getParksByState(stateAbbreviationNotInDatabase);

        // ASSERT: list with no parks -> size of list is 0
        Assert.assertEquals(actualParks.size(), numExpectedParks);
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        /*
         * Park createPark(Park park);
         */

        // ARRANGE
        // setup test park (see above)
        Park actualPark;

        // ACT
        actualPark = sut.createPark(this.testPark);
        int actualParkId = actualPark.getParkId();

        // ASSERT: actual park Id is > 0....NOT -1
        Assert.assertTrue(actualParkId > 0);

        // ASSERT: reading park by id matches the test park
        Park returnedPark = sut.getParkById(actualParkId);
        assertParksMatchNoId(returnedPark, this.testPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        Assert.fail();
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        Assert.fail();
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

    private void assertParksMatchNoId(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }
}
