package org.selenim.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver webDriver;
    private static ChromeOptions chrome;
    private static FirefoxOptions firefox;
    private static EdgeOptions edge;
    private static String URL = "https://andreibaron:f57e9fb8-f162-4a6b-8fd1-f5f065e8417f@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    private Driver() {
    }

    public static WebDriver getInstance(String browserName) throws MalformedURLException {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", System.getenv("andreibaron"));
        sauceOptions.put("accessKey", System.getenv("f57e9fb8-f162-4a6b-8fd1-f5f065e8417f"));
        sauceOptions.put("screenResolution", "1920x1080");
        if (webDriver == null) {
            switch (browserName.toLowerCase(Locale.ROOT)) {
                case "chrome":
                    chrome = new ChromeOptions();
                    chrome.setPlatformName("macOS 12");
                    chrome.setBrowserVersion("15");
                    chrome.setCapability("sauce:options", sauceOptions);
                    webDriver = new RemoteWebDriver(new URL(URL), chrome);
                    break;
                case "firefox":
                    firefox = new FirefoxOptions();
                    firefox.setPlatformName("Windows 8.1");
                    firefox.setBrowserVersion("latest");
                    firefox.setCapability("sauce:options", sauceOptions);
                    webDriver = new RemoteWebDriver(new URL(URL), firefox);
                case "edge":
                    edge = new EdgeOptions();
                    edge.setPlatformName("Windows 10");
                    edge.setBrowserVersion("latest");
                    edge.setCapability("sauce:options", sauceOptions);
                    webDriver = new RemoteWebDriver(new URL(URL), edge);
                    break;
                default:
                    System.out.println("Browser doesn't exist");
            }
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
        webDriver = null;
    }
}
