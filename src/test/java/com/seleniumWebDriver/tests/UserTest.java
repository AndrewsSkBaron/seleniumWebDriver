package com.seleniumWebDriver.tests;

import com.seleniumWebDriver.pages.UserPage;
import org.junit.jupiter.api.Test;
import static com.seleniumWebDriver.tests.UrlConstantsTest.urlUser;
import static org.junit.Assert.assertTrue;

public class UserTest extends BaseTest {
    private UserPage user;

    @Test
    public void checkSelectRandom() {
        driver.get(urlUser);
        user = new UserPage(driver, wait);
        user.waitForUser();
        assertTrue(user.waitForUser().isDisplayed());
    }
}
