package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.script.User;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.seleniumWebDriver.tests.UrlConstantsTest.urlUser;
import static org.junit.Assert.assertTrue;

public class UserTest extends BaseTest {
    private User user;
    private By item = By.xpath("//div[@id='loading']//*");

    @Test
    public void checkSelectRandom() {
        driver.get(urlUser);
        user = new User(driver);
        user.waitForUser();
        WebElement element = driver.findElement(item);
        System.out.println(element.isDisplayed());
        assertTrue(element.isDisplayed());
    }
}
