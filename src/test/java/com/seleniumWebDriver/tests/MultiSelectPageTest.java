package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.pages.MultiSelectPage;
import org.junit.jupiter.api.Test;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlMultiSelect;
import static org.junit.Assert.assertEquals;

public class MultiSelectPageTest extends BaseTest {
    private MultiSelectPage multiSelect;

    @Test
    public void checkSelectRandom() {
        driver.get(urlMultiSelect);
        multiSelect = new MultiSelectPage(driver, wait);
        multiSelect.getRandomElement();
        assertEquals(multiSelect.getDetailSelected(), multiSelect.getSelectedElement());
    }
}
