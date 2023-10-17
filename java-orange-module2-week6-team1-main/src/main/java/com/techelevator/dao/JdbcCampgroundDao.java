package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Campground;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCampgroundDao implements CampgroundDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCampgroundDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Campground getCampgroundById(int id) {
        Campground campground = null;
        String sql = "SELECT * FROM campground " +
                "WHERE campground_id = ?;";

        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
            if(result.next()){
                campground = mapRowToCampground(result);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return campground;
    }

    @Override
    public List<Campground> getCampgroundsByParkId(int parkId) {
        List<Campground> campgroundsList = new ArrayList<>();
        String sql = "SELECT * FROM campground " +
                "WHERE park_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkId);

        try{
            while(result.next()){
                campgroundsList.add(mapRowToCampground(result));
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return campgroundsList;
    }

    private Campground mapRowToCampground(SqlRowSet results) {
        Campground campground = new Campground();
        campground.setCampgroundId(results.getInt("campground_id"));
        campground.setParkId(results.getInt("park_id"));
        campground.setName(results.getString("name"));
        campground.setOpenFromMonth(results.getInt("open_from_mm"));
        campground.setOpenToMonth(results.getInt("open_to_mm"));
        campground.setDailyFee(results.getDouble("daily_fee"));
        return campground;
    }
}
