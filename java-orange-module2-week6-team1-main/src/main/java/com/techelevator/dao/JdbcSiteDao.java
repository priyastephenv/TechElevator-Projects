package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Site;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesWithRVAccessByParkId(int parkId) {

        List <Site> sites = new ArrayList<>();
        String sql = "SELECT * FROM site " +
                "JOIN campground AS c ON site.campground_id = c.campground_id" +
                " WHERE max_rv_length > 0 AND park_id = ?;";
        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql,parkId);

            while (result.next()) {

                sites.add(mapRowToSite(result));

            }


        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return sites;
    }

    @Override
    public List<Site> getSitesWithoutReservationByParkId(int parkId) {
        List <Site> sites = new ArrayList<>();
        String sql = "SELECT DISTINCT site.* " +
                "FROM site " +
                "     JOIN campground AS c ON site.campground_id = c.campground_id  " +
                "     JOIN reservation ON site.site_id = reservation.site_id  " +
                "     WHERE park_id = ? AND CURRENT_DATE NOT BETWEEN reservation.from_date AND reservation.to_date; ";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql,parkId);

            while (result.next()) {

                sites.add(mapRowToSite(result));
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }


        return sites;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
