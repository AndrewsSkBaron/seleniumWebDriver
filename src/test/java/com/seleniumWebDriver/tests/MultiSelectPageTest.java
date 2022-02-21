package com.seleniumWebDriver.tests;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.seleniumWebDriver.pages.MultiSelectPage;
import java.util.List;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlMultiSelect;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MultiSelectPageTest extends BaseTest {
    private Select select;
    private MultiSelectPage multiSelect;
    private By id = By.xpath("//select[@id='multi-select']");
    private List<WebElement> listOfElements;

    @Test
    public void checkSelectRandom() {
        driver.get(urlMultiSelect);
        multiSelect = new MultiSelectPage(driver);
        multiSelect.getRandomElement();
        select = new Select(driver.findElement(id));
        listOfElements = select.getAllSelectedOptions();
        assertAll(
                () -> assertTrue(select.isMultiple()),
                () -> assertTrue(CollectionUtils.isEqualCollection(listOfElements, multiSelect.getSelectedElement()))
        );
    }
}
