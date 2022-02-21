package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenim.driver.Driver;

import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    protected static WebDriver driver;
    private static String urlLogIn = "https://mail.yandex.com/";
    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private static String gecko = "webdriver.gecko.driver";

    @BeforeAll
    @MethodSource("data")
    public static void setUp() {
        driver = Driver.getInstance().getWebDriver();
        driver.get(urlLogIn);
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("<----- | Browser Session End | ----->");
    }
}
