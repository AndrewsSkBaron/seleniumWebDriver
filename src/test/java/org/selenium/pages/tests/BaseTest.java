package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.selenim.driver.Driver;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static String urlLogIn = "https://mail.yandex.com/";

    @BeforeAll
    @MethodSource("data")
    public static void setUp() {
        driver = Driver.getInstance();
        driver.get(urlLogIn);
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterAll
    public static void tearDown() {
        Driver.quit();
        System.out.println("<----- | Browser Session End | ----->");
    }
}
