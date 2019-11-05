package com.spartagloba.JavaDatabaseConnections;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NWEmployeesDAO {


    private NorthwindDbManager northwindDbManager = new NorthwindDbManager();
    private NorthwindDbManager nwconn = new NorthwindDbManager();


   // the SQL statemnet should be in the method because you don't want multiple member varibles you want the
    //method to do one thing
    public void iterateThroughEmployees(){
        final String SQL = "SELECT TOP 10 * FROM Employees";
        try(Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()){
                System.out.println(resultSet.getString("firstName") + " " + resultSet.getString("lastName") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTotalNumberOfEmployees (){
        int empoyeeNames = 0;
        final String SQL = "SELECT COUNT(*) AS 'Total' FROM Employees";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()){
                empoyeeNames = resultSet.getInt("Total");
                System.out.println(empoyeeNames);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empoyeeNames;
    }

    public int getEmployeesOver60 (){
        int employeeAge = 0;
        final String SQL = "SELECT FirstName + ' ' + LastName AS 'Employee', DATEDIFF(d, BirthDate, GETDATE())/ 365  AS 'Age'  FROM Employees WHERE DATEDIFF(d, BirthDate, GETDATE())/ 365 > 60 ";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()){
                System.out.println(resultSet.getString("Employee")  + " "+ resultSet.getString("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeAge;
    }

    public Map<Integer, String> getEmployeeCountry(){
        Map<Integer, String> getEmployeeCountry = new HashMap<>();
        final String SQL = "SELECT COUNT(EmployeeID) AS 'Number of Employees', Country FROM Employees GROUP BY Country";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()){
                System.out.println(resultSet.getString("Number of Employees")  + " "+ resultSet.getString("Country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getEmployeeCountry;
    }

    public void getVicePresident(){
        final String SQL = "SELECT FirstName + ' ' + LastName AS 'Employee', Title FROM Employees WHERE Title LIKE '%Vice President%'";
        try(Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);
            while (resultSet.next()){
                System.out.println(resultSet.getString("Employee") + " , " +  resultSet.getString("Title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLondonCustomers (){
        int customerCount  = 0;
        final String SQL = "SELECT COUNT(ContactName) AS 'Number of Customers' FROM Customers WHERE City = 'London'";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()){
                System.out.println(resultSet.getString("Number of Customers"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerCount;
    }

    public int getCompanyOwners(){
        int customerOwnerCount  = 0;
        final String SQL = "SELECT COUNT(ContactTitle) AS 'Customer Owners' FROM Customers ORDER BY [Customer Owners]";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()){
                System.out.println(resultSet.getString("Customer Owners"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerOwnerCount;
    }

    public Map<Integer, String> getShipCountry(){
        Map<Integer, String> getShipCountry = new HashMap<>();
        final String SQL = "SELECT ShipCountry, COUNT(ShipCountry) AS 'Number of Orders' FROM Orders GROUP BY ShipCountry ORDER BY [Number of Orders] DESC";
        try (Statement stmt = nwconn.northwindConnection().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(SQL);

            while (resultSet.next()){
                System.out.println(resultSet.getString("ShipCountry")  + " "+ resultSet.getString("Number of Orders"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getShipCountry;
    }







}
