package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_returns_correct_timesheet_for_id() {
        Timesheet testTimesheet = dao.getTimesheetById(1);
        Timesheet expectedTimesheet = TIMESHEET_1;
        assertTimesheetsMatch(expectedTimesheet, testTimesheet);

        testTimesheet = dao.getTimesheetById(3);
        expectedTimesheet = TIMESHEET_3;
        assertTimesheetsMatch(expectedTimesheet, testTimesheet);
    }

    @Test
    public void getTimesheetById_returns_null_when_id_not_found() {

        Timesheet testTimesheet =dao.getTimesheetById(0);

        Assert.assertNull("Timesheet does not exist",testTimesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> testList = new ArrayList<>();
        List<Timesheet> actualList = dao.getTimesheetsByEmployeeId(1);
        testList.add(TIMESHEET_1);
        testList.add(TIMESHEET_2);
        Assert.assertEquals(2, actualList.size());
        assertTimesheetsMatch(TIMESHEET_2, actualList.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {

        List <Timesheet> testList = new ArrayList<>();
        List <Timesheet> actualList = dao.getTimesheetsByProjectId(1);
        testList.add (TIMESHEET_1);
        testList.add(TIMESHEET_2);
        testList.add(TIMESHEET_3);

        Assert.assertEquals(testList.size(), actualList.size());

        assertTimesheetsMatch(testList.get(2), actualList.get(2));

        testList = new ArrayList<>();
        actualList = dao.getTimesheetsByProjectId(2);
        testList.add (TIMESHEET_4);

        Assert.assertEquals(testList.size(), actualList.size());

        assertTimesheetsMatch(testList.get(0), actualList.get(0));



    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet TIMESHEET_5 = new Timesheet();
        TIMESHEET_5.setEmployeeId(1);
        TIMESHEET_5.setProjectId(2);
        TIMESHEET_5.setDateWorked(LocalDate.parse("2023-08-10"));
        TIMESHEET_5.setHoursWorked(6.6);
        TIMESHEET_5.setBillable(false);
        TIMESHEET_5.setDescription("Timesheet 5");

        Timesheet createdTimesheet = dao.createTimesheet(TIMESHEET_5);
        Assert.assertNotNull("Timesheet not created", createdTimesheet);
        Assert.assertTrue("Timesheet doesn't have a Timesheet ID", createdTimesheet.getTimesheetId()> 0);
        Assert.assertEquals("Incorrect Employee ID",TIMESHEET_5.getEmployeeId(),createdTimesheet.getEmployeeId() );
        Assert.assertEquals("Incorrect Project ID",TIMESHEET_5.getProjectId() ,createdTimesheet.getProjectId() );
        Assert.assertEquals("Incorrect Date Worked", TIMESHEET_5.getDateWorked() ,createdTimesheet.getDateWorked() );
        Assert.assertEquals(TIMESHEET_5.getHoursWorked() ,createdTimesheet.getHoursWorked(), 0.001 );
        Assert.assertEquals("Incorrect Billable setting", TIMESHEET_5.isBillable(),createdTimesheet.isBillable() );
        Assert.assertEquals("Incorrect Description",TIMESHEET_5.getDescription() ,createdTimesheet.getDescription() );

        Timesheet retrievedTimesheet = getTimesheetByIdForTestVerification(createdTimesheet.getTimesheetId());
        Assert.assertNotNull("Timesheet not made in database", retrievedTimesheet);
        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);

    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet existingTimesheet = new Timesheet();
        existingTimesheet.setTimesheetId(TIMESHEET_4.getTimesheetId());
        existingTimesheet.setEmployeeId(2);
        existingTimesheet.setProjectId(2);
        existingTimesheet.setDateWorked(LocalDate.parse("2023-06-06"));
        existingTimesheet.setHoursWorked(6.6);
        existingTimesheet.setBillable(true);
        existingTimesheet.setDescription("Do you ever feel like a plastic bag drifting through the wind wanting to start " +
                        "again?");
       Timesheet updatedTimesheet = dao.updateTimesheet(existingTimesheet);
       Assert.assertNotNull("The updated Timesheet is null", updatedTimesheet);
       Assert.assertEquals("Updated Timesheet doesn't have the right Timesheet ID", existingTimesheet.getTimesheetId(), updatedTimesheet.getTimesheetId());
       Assert.assertEquals("Wrong employee id", existingTimesheet.getEmployeeId(), updatedTimesheet.getEmployeeId());
       Assert.assertEquals("Wrong project ID",existingTimesheet.getProjectId(),updatedTimesheet.getProjectId());
       Assert.assertEquals("Wrong date", existingTimesheet.getDateWorked(), updatedTimesheet.getDateWorked());
       Assert.assertEquals( existingTimesheet.getHoursWorked(), updatedTimesheet.getHoursWorked(), 0.001);
       Assert.assertEquals("Wrong billable setting", existingTimesheet.isBillable(), updatedTimesheet.isBillable());
       Assert.assertEquals("Wrong description", existingTimesheet.getDescription(), updatedTimesheet.getDescription());

        // verify value was saved to database, retrieve it and compare values
       Timesheet retrievedTimesheet = getTimesheetByIdForTestVerification(TIMESHEET_4.getTimesheetId());
       assertTimesheetsMatch(updatedTimesheet, retrievedTimesheet);


    }

    @Test
    public void deleted_timesheet_can_no_longer_be_retrieved() {
        int recordsAffected = dao.deleteTimesheetById(TIMESHEET_2.getTimesheetId());
        Assert.assertEquals("Did not return the correct number of rows affected", 1, recordsAffected);

        Timesheet retrievedTimesheet = getTimesheetByIdForTestVerification(TIMESHEET_2.getTimesheetId());
        Assert.assertNull("Project was not deleted", retrievedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double actualHoursInDatabase= dao.getBillableHours(TIMESHEET_1.getEmployeeId(), TIMESHEET_1.getProjectId());
        Assert.assertEquals(2.5, actualHoursInDatabase, 0.000);

        actualHoursInDatabase= dao.getBillableHours(TIMESHEET_4.getEmployeeId(), TIMESHEET_4.getProjectId());
        Assert.assertEquals(0, actualHoursInDatabase, 0.000);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

    // test-specific implementation of getTimesheetById to be independent of DAO class
    private Timesheet getTimesheetByIdForTestVerification(int id) {
        Timesheet timesheet1 = null;
        String sql = "SELECT timesheet_id, employee_id, project_id, date_worked, hours_worked, billable, description FROM timesheet WHERE timesheet_id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            Timesheet mappedTimesheet = new Timesheet();
            mappedTimesheet.setTimesheetId(results.getInt("timesheet_id"));
            mappedTimesheet.setEmployeeId(results.getInt("employee_id"));
            mappedTimesheet.setProjectId(results.getInt("project_id"));
            mappedTimesheet.setDateWorked(results.getDate("date_worked").toLocalDate());
            mappedTimesheet.setHoursWorked(results.getDouble("hours_worked"));
            mappedTimesheet.setBillable(results.getBoolean("billable"));
            mappedTimesheet.setDescription(results.getString("description"));


            timesheet1 = mappedTimesheet;
        }
        return timesheet1;
    }

}
