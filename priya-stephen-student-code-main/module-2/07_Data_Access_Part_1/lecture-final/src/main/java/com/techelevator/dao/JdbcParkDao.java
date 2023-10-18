package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount = 0;

        String sql = "SELECT COUNT(*) AS count FROM park;";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);

        if(results.next()){
            parkCount = results.getInt("count");
        }

        return parkCount;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        return null;
    }
    
    @Override
    public double getAvgParkArea() {
        return 0.0;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();

        String sql = "SELECT park_name FROM park;";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);

        while(results.next()){

            parkNames.add(results.getString("park_name"));

        }

        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        return new Park();
    }

    @Override
    public List<Park> getParksWithCamping() {

        List<Park> parks = new ArrayList<>();

        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE has_camping = true;";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Park parkResult = mapRowToPark(results);
            parks.add(parkResult);
        }

        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        return new Park();
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();

        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                     "FROM park p " +
                     "JOIN park_state ps ON p.park_id = ps.park_id " +
                     "WHERE ps.state_abbreviation = ?;";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while(results.next()){
            parks.add(mapRowToPark(results));
        }

        return parks;
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) { return new ArrayList<>(); }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park newPark = new Park();

        int parkId = rowSet.getInt("park_id");
        String parkName = rowSet.getString("park_name");

        // TODO: Possible null check on getDate()
        LocalDate dateEstablished = rowSet.getDate("date_established").toLocalDate();

        double area = rowSet.getDouble("area");
        boolean hasCamping = rowSet.getBoolean("has_camping");

        newPark.setParkId(parkId);
        newPark.setParkName(parkName);
        newPark.setDateEstablished(dateEstablished);
        newPark.setArea(area);
        newPark.setHasCamping(hasCamping);

        return newPark;
    }
}
