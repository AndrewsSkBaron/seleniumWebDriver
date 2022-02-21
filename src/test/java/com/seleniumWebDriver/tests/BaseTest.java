package com.seleniumWebDriver.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.seleniumWebDriver.tests.UrlConstantsTest.gecko;
import static com.seleniumWebDriver.tests.UrlConstantsTest.path;

public abstract class BaseTest {
    protected static WebDriver driver ;
    protected static WebDriverWait wait;
    protected static UrlConstantsTest url;

    @BeforeEach
    public void setUp(){
        System.setProperty(gecko, path);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("<----- | Browser Session End | ----->");
        driver.quit();
    }

}
