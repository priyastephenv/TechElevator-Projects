package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Collection mapRowToCollection(SqlRowSet sqlRowSet) {

        int collectionID = sqlRowSet.getInt("collection_id");
        String collectionName = sqlRowSet.getString("collection_name");
        Collection collection = new Collection();
        collection.setId(collectionID);
        collection.setName(collectionName);

        return collection;

    }


    @Override
    public List<Collection> getCollections() {

        List <Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collection";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Collection collection = mapRowToCollection(results);

            collections.add(collection);

        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {

        String sql = "SELECT * FROM collection WHERE collection_id = " + id;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        Collection collection = null;

        while (results.next()) {
            collection = mapRowToCollection(results);
        }

        return collection;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List <Collection> collections = new ArrayList<>();
        SqlRowSet results=null;
        if (useWildCard) {
            String sql = "SELECT * FROM collection WHERE collection_name ILIKE '%" + name + "%'";
            results = jdbcTemplate.queryForRowSet(sql);

        }else if (!useWildCard) {
            String sql = "SELECT * FROM collection WHERE collection_name ILIKE '" + name + "'";
            results = jdbcTemplate.queryForRowSet(sql);

        }

        while(results.next()){
            Collection collection = mapRowToCollection(results);

            collections.add(collection);

        }


        return collections;
    }
}
