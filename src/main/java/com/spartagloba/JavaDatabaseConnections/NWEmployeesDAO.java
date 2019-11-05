package com.spartagloba.JavaDatabaseConnections;

import java.sql.*;

public class JDBCExample {


    private NorthwindDbManager northwindDbManager = new NorthwindDbManager();
    private final String SQL = "SELECT TOP 10 * FROM Employees";



    //private final String SQL = "SELECT TOP 10 * FROM Employees";
    private NorthwindDbManager nwconn = new NorthwindDbManager();

    public void iterateThroughEmployees(){
        try(Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()){
                System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
