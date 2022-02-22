package com.seleniumWebDriver.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.Objects;

public class DownloadPage {
    private WebDriver driver;
    private String button = "//button[@id='cricle-btn']";
    private String percent = "//input[@id='cricleinput']";
    private WebDriverWait wait;

    public DownloadPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement download() {
        driver.findElement(By.xpath(button)).click();
        wait.until((ExpectedCondition<Boolean>) d -> {
            WebElement element = Objects.requireNonNull(d).findElement(By.xpath(percent));
            int num = Integer.parseInt(element.getAttribute("value"));
            return num >= 50;
        });
        driver.navigate().refresh();
        return driver.findElement(By.xpath(percent));
    }

}
