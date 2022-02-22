package org.selenim.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver webDriver;
    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
    private static String gecko = "webdriver.gecko.driver";

    private Driver() {
    }
    public static WebDriver getInstance() {
        if (webDriver == null) {
            System.setProperty(gecko,path);
            webDriver = new FirefoxDriver();
            Objects.requireNonNull(webDriver).manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
        webDriver = null;
    }
}

