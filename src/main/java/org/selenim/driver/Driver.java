package org.selenim.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver driver;
    private WebDriver webDriver;
    private String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private String gecko = "webdriver.gecko.driver";

    private Driver() {
        System.setProperty(gecko,path);
        webDriver = new FirefoxDriver();
        Objects.requireNonNull(webDriver).manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static Driver getInstance() {
        if (driver == null) {
            driver = new Driver();
        }
        return driver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public static void getQuit() {
        getInstance().getWebDriver().quit();
    }
}
