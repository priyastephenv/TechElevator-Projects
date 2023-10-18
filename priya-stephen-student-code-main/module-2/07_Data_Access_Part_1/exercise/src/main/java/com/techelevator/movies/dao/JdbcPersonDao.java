package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Person mapRowToPerson(SqlRowSet sqlRowSet) {
        Person person = new Person();

        int personID = sqlRowSet.getInt("person_id");
        String personName = sqlRowSet.getString("person_name");

        if (sqlRowSet.getDate("birthday") !=null){
            LocalDate birthday = sqlRowSet.getDate("birthday").toLocalDate();
            person.setBirthday(birthday);
        }


        if (sqlRowSet.getDate("deathday")!=null) {

            LocalDate deathDate = sqlRowSet.getDate("deathday").toLocalDate();
            person.setDeathDate(deathDate);
        }

        String biography = sqlRowSet.getString("biography");
        String profilePath = sqlRowSet.getString("profile_path");

        if (sqlRowSet.getString("home_page") != null) {
            String homePage = sqlRowSet.getString("home_page");
            person.setHomePage(homePage);

        }


      person.setId(personID);
      person.setName(personName);

      person.setBiography(biography);
      person.setProfilePath(profilePath);


        return person;

    }



    @Override
    public List<Person> getPersons() {

        List <Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM person";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Person person = mapRowToPerson(results);



            persons.add(person);


        }

        return persons;
    }

    @Override
    public Person getPersonById(int id) {

        String sql = "SELECT * from person WHERE person_id = " + id;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        Person person = null;

        if (results.next()) {
            person = mapRowToPerson(results);}

        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {

        List <Person> persons = new ArrayList<>();
        SqlRowSet results = null;
        if (useWildCard) {
            String sql = "SELECT * FROM person WHERE person_name ILIKE '%" + name + "%'";
            results = jdbcTemplate.queryForRowSet(sql);

        }else if (!useWildCard) {
            String sql = "SELECT * FROM person WHERE person_name ILIKE '" + name + "'";
            results = jdbcTemplate.queryForRowSet(sql);

        }

        while(results.next()){
            Person person = mapRowToPerson(results);

            persons.add(person);

        }

        return persons;

    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List <Person> persons = new ArrayList<>();
        SqlRowSet results = null;
        if (useWildCard) {
            String sql = "SELECT DISTINCT person_id, person_name, birthday, deathday, biography, profile_path, person.home_page \n" +
                    "FROM person\n" +
                    "JOIN movie_actor ON person.person_id = movie_actor.actor_id\n" +
                    "JOIN movie ON movie.movie_id = movie_actor.movie_id\n" +
                    "JOIN collection ON movie.collection_id = collection.collection_id\n" +
                    "WHERE collection_name ILIKE '%" + collectionName + "%'\n" +
                    "ORDER BY person_name";
            results = jdbcTemplate.queryForRowSet(sql);
        } else if (!useWildCard) {
            String sql = "SELECT  DISTINCT person_id, person_name, birthday, deathday, biography, profile_path, person.home_page \n" +
                    "FROM person\n" +
                    "JOIN movie_actor ON person.person_id = movie_actor.actor_id\n" +
                    "JOIN movie ON movie.movie_id = movie_actor.movie_id\n" +
                    "JOIN collection ON movie.collection_id = collection.collection_id\n" +
                    "WHERE collection_name ILIKE '"+ collectionName+ "'\n" +
                    "ORDER BY person_name";
            results = jdbcTemplate.queryForRowSet(sql);
        }

        while(results.next()){
            Person person = mapRowToPerson(results);

            persons.add(person);

        }

        return persons;
    }
}
