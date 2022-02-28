package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenim.driver.Driver;
import org.selenim.pages.WebDriverUtils;

public abstract class BaseTest {
    protected static WebDriver driver = Driver.getInstance();
    protected static WebDriverWait wait;
    protected static WebDriverUtils screenshot;
    private static String urlLogIn = "https://mail.yandex.com/";

    @BeforeAll
    public static void setUp() {
        screenshot = new WebDriverUtils();
        driver.get(urlLogIn);
        wait = new WebDriverWait(driver, 30);
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterAll
    public static void tearDown() {
        Driver.quit();
        System.out.println("<----- | Browser Session End | ----->");
    }
}
