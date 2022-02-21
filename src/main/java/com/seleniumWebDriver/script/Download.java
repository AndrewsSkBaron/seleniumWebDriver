package com.seleniumWebDriver.script;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.Objects;

public class Download {
    private WebDriver driver;
    private By button = By.xpath("//button[@id='cricle-btn']");
    private By percent = By.xpath("//input[@id='cricleinput']");
    private WebDriverWait wait;

    public Download(WebDriver driver) {
        this.driver = driver;
    }

    public Download download() {
        driver.findElement(button).click();
        wait = new WebDriverWait(driver, 50);
        wait.until((ExpectedCondition<Boolean>) d -> {
            WebElement element = Objects.requireNonNull(d).findElement(percent);
            int num = Integer.parseInt(element.getAttribute("value"));
            return num >= 50;
        });
        driver.navigate().refresh();
        return this;
    }
}
