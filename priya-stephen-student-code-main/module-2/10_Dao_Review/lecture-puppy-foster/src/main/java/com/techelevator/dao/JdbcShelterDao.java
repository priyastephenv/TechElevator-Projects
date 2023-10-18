package com.techelevator.dao;

import com.techelevator.connection.DbConnection;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcShelterDao implements ShelterDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcShelterDao(DbConnection dbConnection){
        this.jdbcTemplate = new JdbcTemplate(dbConnection.getConnection());
    }
}
