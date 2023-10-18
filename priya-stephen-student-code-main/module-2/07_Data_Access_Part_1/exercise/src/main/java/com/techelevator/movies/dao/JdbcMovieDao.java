package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Movie mapRowToMovie(SqlRowSet sqlRowSet) {

        int movieID = sqlRowSet.getInt("movie_id");
        String movieTitle = sqlRowSet.getString("title");
        String overview = sqlRowSet.getString("overview");
        String tagline = sqlRowSet.getString("tagline");
        String posterPath = sqlRowSet.getString("poster_path");
        String homePage = sqlRowSet.getString("home_page");
        LocalDate releaseDate = sqlRowSet.getDate("release_date").toLocalDate();
        int lengthMinutes = sqlRowSet.getInt("length_minutes");
        int directorId = sqlRowSet.getInt("director_id");
        int collectionId = sqlRowSet.getInt("collection_id");
        Movie movie = new Movie();

        movie.setId(movieID);
        movie.setTitle(movieTitle);
        movie.setOverview(overview);
        movie.setTagline(tagline);
        movie.setPosterPath(posterPath);
        movie.setHomePage(homePage);
        movie.setReleaseDate(releaseDate);
        movie.setLengthMinutes(lengthMinutes);
        movie.setDirectorId(directorId);
        movie.setCollectionId(collectionId);

        return movie;

    }

    @Override
    public List<Movie> getMovies() {
        List <Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Movie movie = mapRowToMovie(results);

            movies.add(movie);

        }

        return movies;
    }

    @Override
    public Movie getMovieById(int id) {

        String sql = "SELECT * from movie WHERE movie_id = " + id;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        Movie movie = null;

        if (results.next()) {
            movie = mapRowToMovie(results);}
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List <Movie> movies = new ArrayList<>();
        SqlRowSet results = null;
        if (useWildCard) {
            String sql = "SELECT * FROM movie WHERE title ILIKE '%" + title + "%'";
            results = jdbcTemplate.queryForRowSet(sql);

        }else if (!useWildCard) {
            String sql = "SELECT * FROM movie WHERE title ILIKE '" + title + "'";
            results = jdbcTemplate.queryForRowSet(sql);

        }

        while(results.next()){
            Movie movie = mapRowToMovie(results);

            movies.add(movie);

        }

        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear,
           int endYear, boolean useWildCard) {
        List <Movie> movies = new ArrayList<>();
        SqlRowSet results = null;
        if (useWildCard) {
            String sql =
                        "SELECT * " +
                            "FROM movie " +
                            "JOIN person ON movie.director_id = person.person_id " +
                            "WHERE person.person_name ILIKE '%" + directorName + "%' AND release_date BETWEEN" +
                                "'" + startYear + "-01-01' AND '" + endYear + "-12-31'";
            results = jdbcTemplate.queryForRowSet(sql);

        }else if (!useWildCard) {

            String sql =
                    "SELECT * " +
                            "FROM movie " +
                            "JOIN person ON movie.director_id = person.person_id " +
                            "WHERE person.person_name ILIKE '" + directorName + "' AND release_date BETWEEN" +
                            "'" + startYear + "-01-01' AND '" + endYear + "-12-31'";



            results = jdbcTemplate.queryForRowSet(sql);

        }
        while(results.next()){
            Movie movie = mapRowToMovie(results);

            movies.add(movie);

        }


        return movies;
    }
}
