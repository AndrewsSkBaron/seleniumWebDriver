package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.ojb.Employees;
import com.seleniumWebDriver.script.Table;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlTable;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTest extends BaseTest {
    private Table table;
    private List<Employees> listOfEmployees;

    @Test
    public void checkSelectRandom() {
        driver.get(urlTable);
        table = new Table(driver);
        table.rowSelection(33,120000);
        listOfEmployees = table.getRows(33,120000);
        assertAll(
                () -> assertEquals(listOfEmployees, table.getRows(33,120000)),
                () -> assertTrue(CollectionUtils.isEqualCollection(listOfEmployees,  table.getRows(33,120000)))
        );
    }
}
