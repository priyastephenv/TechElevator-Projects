package com.techelevator.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DbConnection {

    // TODO: replace with environment variables
    private final String dbUsername = "postgres";
    private final String dbPassword = "postgres1";

    // Example:
    // jdbc:postgresql://localhost:5432/PuppyDB
    private final String hostNameUrl = "localhost";
    private final int portNumber = 5432;
    private final String databaseName = "PuppyDB";
    private final String connectionString = "jdbc:postgresql://" + hostNameUrl +
                                            ":" + portNumber + "/" + databaseName;

    private BasicDataSource dataSource;

    public DbConnection(){
        this.dataSource = new BasicDataSource();
        this.dataSource.setUrl(connectionString);
        this.dataSource.setUsername(dbUsername);
        this.dataSource.setPassword(dbPassword);
    }

    public DataSource getConnection(){
        return this.dataSource;
    }
}
