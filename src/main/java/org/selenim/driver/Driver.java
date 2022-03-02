package org.selenim.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver webDriver;
    private static DesiredCapabilities dc;

    private Driver() {
    }

    public static WebDriver getInstance(String browserName) throws MalformedURLException {
        if (webDriver == null) {
            dc = new DesiredCapabilities();
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);

            switch (browserName.toLowerCase(Locale.ROOT)) {
                case "chrome":
                    dc.setBrowserName("chrome");
                    break;
                case "firefox":
                    dc.setBrowserName("firefox");
                    break;
                case "opera":
                    dc.setBrowserName("opera");
                    break;
                default:
                    System.out.println("Browser doesn't exist");
            }

            Objects.requireNonNull(webDriver).manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
        webDriver = null;
    }

//    private static WebDriver webDriver;
//    private static String path = "src/main/resources/drivers/geckodriver/geckodriver.exe";
//    private static String gecko = "webdriver.gecko.driver";
//
//    private Driver() {
//    }
//    public static WebDriver getInstance() {
//        if (webDriver == null) {
//            System.setProperty(gecko,path);
//            webDriver = new FirefoxDriver();
//            Objects.requireNonNull(webDriver).manage().window().maximize();
//            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        }
//        return webDriver;
//    }
//
//    public static void quit() {
//        webDriver.quit();
//        webDriver = null;
//    }
}
