package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Genre mapRowToGenre(SqlRowSet sqlRowSet) {

        int genreID = sqlRowSet.getInt("genre_id");
        String genreName = sqlRowSet.getString("genre_name");
        Genre genre = new Genre();
        genre.setId(genreID);
        genre.setName(genreName);

        return genre;

    }

    @Override
    public List<Genre> getGenres() {

        List <Genre> genres = new ArrayList<>();
        String sql = "SELECT genre_id, genre_name FROM genre";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Genre genre = mapRowToGenre(results);

            genres.add(genre);

        }
        return genres;
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "SELECT * FROM genre WHERE genre_id = " + id;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        Genre genre = null;

        while (results.next()) {
            genre = mapRowToGenre(results);
        }

        return genre;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List <Genre> genres = new ArrayList<>();
        SqlRowSet results=null;
        if (useWildCard) {
            String sql = "SELECT * FROM genre WHERE genre_name ILIKE '%" + name + "%'";
            results = jdbcTemplate.queryForRowSet(sql);

        }else if (!useWildCard) {
            String sql = "SELECT * FROM genre WHERE genre_name ILIKE '" + name + "'";
            results = jdbcTemplate.queryForRowSet(sql);

        }

        while(results.next()){
            Genre genre = mapRowToGenre(results);

            genres.add(genre);

        }


        return genres;
    }
}
