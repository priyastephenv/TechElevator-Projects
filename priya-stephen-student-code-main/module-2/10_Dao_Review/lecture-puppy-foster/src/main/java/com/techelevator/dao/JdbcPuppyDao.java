package com.techelevator.dao;

import com.techelevator.connection.DbConnection;
import com.techelevator.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcPuppyDao implements PuppyDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcPuppyDao(DbConnection dbConnection){
        // TODO: need to initialize
        this.jdbcTemplate = new JdbcTemplate(dbConnection.getConnection());
    }

    @Override
    public List<Puppy> getAllPuppies() {
        List<Puppy> allPuppies = new ArrayList<>();

        // TODO: replace * later....
        String sql = "SELECT * FROM puppy;";

        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);

        while(results.next()){

            allPuppies.add(mapRowToPuppy(results));

        }

        return allPuppies;
    }

    @Override
    public Puppy getPuppyById(int puppyId) {
        Puppy puppy = null;

        String sql = "SELECT * FROM puppy " +
                     "WHERE puppy_id = ?;";

        // TODO: ADD exception handling
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, puppyId);

        if(results.next()){
            puppy = mapRowToPuppy(results);
        }

        return puppy;
    }

    @Override
    public Puppy addPuppy(Puppy puppyToAdd) {
        return null;
    }

    private Puppy mapRowToPuppy(SqlRowSet row){
        Puppy puppy = new Puppy();

        puppy.setPuppyId(row.getInt("puppy_id"));
        puppy.setShelterId(row.getInt("shelter_id"));
        puppy.setPuppyName(row.getString("puppy_name"));
        puppy.setWeightLbs(row.getInt("weight_lbs"));
        puppy.setBreed(row.getString("breed"));
        puppy.setGender(row.getString("gender"));
        puppy.setFostered(row.getBoolean("is_fostered"));
        puppy.setImageUrl(row.getString("image_url"));

        return puppy;
    }
}
