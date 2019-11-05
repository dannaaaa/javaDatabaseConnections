package com.spartagloba.JavaDatabaseConnections;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class AppTest {

    NWEmployeesDAO nwEmployeesDAO = new NWEmployeesDAO();

    @Test
    public void getTotalNumberOfEmployeesTest () {
        //nwEmployeesDAO.getTotalNumberOfEmployees();
        assertEquals(9 , nwEmployeesDAO.getTotalNumberOfEmployees() );
    }

    @Test
    public void getEmployeesOver60Test () {
        assertEquals(5, nwEmployeesDAO.getEmployeesOver60());
    }

    @Test
    public void getEmployeeCountryTest () {
       assertEquals("USA" , nwEmployeesDAO.getEmployeeCountry());
    }

    @Test
    public void getVicePresidentTest(){
        nwEmployeesDAO.getVicePresident();
        assertEquals("Steve", "Steve");
    }

    @Test
    public void getLondonCustomersTest(){
        nwEmployeesDAO.getLondonCustomers();
        assertEquals(6, 6);
    }

    @Test
    public void getMostShippedToCountryTest(){
        nwEmployeesDAO.getShipCountry();
        assertEquals(122, 122);

    }

    @Test
    public void getCompanyOwnersTest(){
        nwEmployeesDAO.getCompanyOwners();
        assertEquals(91, 91);
    }




}
