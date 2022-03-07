package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenim.driver.Driver;
import org.selenim.pages.WebDriverUtils;

import java.net.MalformedURLException;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebDriverUtils screenshot;
    private static String urlLogIn = "https://mail.yandex.com/";

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        driver = Driver.getInstance("firefox");
        screenshot = new WebDriverUtils();
        driver.get(urlLogIn);
        wait = new WebDriverWait(driver, 30);
import org.selenim.driver.Driver;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static String urlLogIn = "https://mail.yandex.com/";

    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private static String gecko = "webdriver.gecko.driver";

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