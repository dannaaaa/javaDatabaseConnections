package com.spartagloba.JavaDatabaseConnections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {

        //System.out.println( "Hello World!" );
        NWEmployeesDAO NWEmployeesDAO = new NWEmployeesDAO();
        //NWEmployeesDAO.iterateThroughEmployees();
        //NWEmployeesDAO.getTotalNumberOfEmployees();
        //NWEmployeesDAO.getEmployeesOver60();
        NWEmployeesDAO.getEmployeeCountry();
        //NWEmployeesDAO.getVicePresident();
        //NWEmployeesDAO.getLondonCustomers();
        //NWEmployeesDAO.getCompanyOwners();
        //NWEmployeesDAO.getShipCountry();

//        PropertiesManager props = new PropertiesManager();
//        System.out.println(props);

    }
}
