package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.ojb.Employees;
import com.seleniumWebDriver.pages.TablePage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlTable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTest extends BaseTest {
    private TablePage table;
    private List<Employees> listOfEmployees;

    @Test
    public void checkSelectRandom() {
        driver.get(urlTable);
        table = new TablePage(driver);
        table.rowSelection(33, 120000);
        listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employees("A. Cox", "Junior Technical Author", "San Francisco"));
        listOfEmployees.add(new Employees("G. Joyce", "Developer", "Edinburgh"));
        listOfEmployees.add(new Employees("M. House", "Integration Specialist", "Sidney"));
        listOfEmployees.add(new Employees("S. Burks", "Developer", "London"));
        assertEquals(listOfEmployees.toString(), table.getEmployees(33, 120000).toString());
    }
}
