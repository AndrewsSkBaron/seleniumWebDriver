package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.pages.MultiSelectPage;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlMultiSelect;
import static org.junit.Assert.assertTrue;

public class MultiSelectPageTest extends BaseTest {
    private Select select;
    private MultiSelectPage multiSelect;
    private List<WebElement> listOfElements;

    @Test
    public void checkSelectRandom() {
        driver.get(urlMultiSelect);
        multiSelect = new MultiSelectPage(driver);
        multiSelect.getRandomElement();
        select = new Select(multiSelect.getSelectBy());
        listOfElements = select.getAllSelectedOptions();
        assertTrue(CollectionUtils.isEqualCollection(listOfElements, multiSelect.getSelectedElement()));
    }
}
