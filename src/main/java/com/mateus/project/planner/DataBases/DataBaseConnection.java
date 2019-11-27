package com.mateus.project.planner.DataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String username;
    private final String pass;

    public DataBaseConnection(){
        this.username = "planner";
        this.pass = "planner@2135";
    }

    public Connection connect() throws SQLException {
            String dbURL = "jdbc:mysql://localhost:3306/planner-db";
            return DriverManager.getConnection(dbURL, this.username, this.pass);
    }


}
