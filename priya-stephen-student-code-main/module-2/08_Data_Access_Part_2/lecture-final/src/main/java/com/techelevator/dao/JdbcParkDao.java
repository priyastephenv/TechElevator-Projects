package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Park;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			parkCount = results.getInt("count");
		} 
        return parkCount;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name FROM park ORDER by park_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parkNames.add(results.getString("park_name"));
        }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE has_camping = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                     "FROM park p " +
                     "JOIN park_state ps ON p.park_id = ps.park_id " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        Park newPark = null;

        String sql = "INSERT INTO park " +
                "(park_name, date_established, area, has_camping) " +
                "VALUES " +
                "(?, ?, ?, ?)" +
                "RETURNING park_id";

        try {
            Integer newParkId = this.jdbcTemplate.queryForObject(
                    sql, Integer.class,
                    park.getParkName(), park.getDateEstablished(),
                    park.getArea(), park.getHasCamping()
            );

            newPark = getParkById(newParkId);

        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("ERROR: Unable to connect to server or DB", e);
        } catch(DataIntegrityViolationException e){
            throw new DaoException("ERROR: Data integrity violation", e);
        }

        //throw new DaoException("createPark() not implemented");

        return newPark;
    }

    @Override
    public Park updatePark(Park park) {

        Park updatedPark = null;

        String sql = "UPDATE park " +
                     "SET park_name = ? " +
                     "    date_established = ? " +
                     "    area = ? " +
                     "    has_camping = ? " +
                     "WHERE park_id = ?";

        try {

            int numRowsAffected = this.jdbcTemplate.update(
                    sql, park.getParkName(),
                    park.getDateEstablished(), park.getArea(),
                    park.getHasCamping(), park.getParkId()
                    );

            if(numRowsAffected == 0){
                throw new DaoException("ERROR: Expected > 0 rows affected");
            } else {
                /*
                 * SUCCESS!!!!
                 */
                updatedPark = getParkById(park.getParkId());
            }

        } catch(BadSqlGrammarException e){
            throw new DaoException("ERROR: connection down", e);
        } catch(DataIntegrityViolationException e){
            throw new DaoException("ERROR: data integrity violation", e);
        }


        return updatedPark;
        //throw new DaoException("updatePark() not implemented");
    }

    @Override
    public int deleteParkById(int parkId) {

        int numberOfRowsAffected = 0;

        String parkStateSql = "DELETE FROM park_state WHERE park_id = ?;";
        String parkSql = "DELETE FROM park WHERE park_id = ?;";

        try{

            /*
             * DELETE foreign key references first!
             */
            this.jdbcTemplate.update(parkStateSql, parkId);

            /*
             * DELETE from park table second!
             */
            numberOfRowsAffected = this.jdbcTemplate.update(parkSql, parkId);

        } catch(BadSqlGrammarException e){
            throw new DaoException("ERROR: bad SQL grammar", e);
        } catch(DataIntegrityViolationException e){
            throw new DaoException("ERROR: data integrity violation", e);
        }

        return numberOfRowsAffected;
//        throw new DaoException("deleteParkById() not implemented");
    }

    @Override
    public void linkParkState(int parkId, String stateAbbreviation) {
        throw new DaoException("linkParkState() not implemented");
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
