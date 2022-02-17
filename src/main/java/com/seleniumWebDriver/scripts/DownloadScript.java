package com.seleniumWebDriver.scripts;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Objects;

public class DownloadScript {
    private WebDriver driver;
    private By button = By.xpath("//button[@id='cricle-btn']");
    private By percent = By.xpath("//input[@id='cricleinput']");
    private WebDriverWait wait;

    public DownloadScript(WebDriver driver) {
        this.driver = driver;
    }

    public DownloadScript clickButton(){
        driver.findElement(button).click();
        return this;
    }

    public DownloadScript download() {
        clickButton();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until((ExpectedCondition<Boolean>) d -> {
            WebElement element = Objects.requireNonNull(d).findElement(percent);
            int num = Integer.parseInt(element.getAttribute("value"));
            return num >= 50;
        });
        driver.navigate().refresh();
        return new DownloadScript(driver);
    }
}
