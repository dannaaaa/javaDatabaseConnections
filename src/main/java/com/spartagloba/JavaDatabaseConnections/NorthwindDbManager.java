package com.spartagloba.JavaDatabaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NorthwindDbManager {

    private PropertiesManager props = new PropertiesManager();
    private final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=northwind;user=" + props.getUsername() + ";password=" + props.getPassword();
    public Connection northwindConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTIONURL);
    }
}
