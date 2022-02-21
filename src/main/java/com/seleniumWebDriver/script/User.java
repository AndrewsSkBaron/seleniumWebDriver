package com.seleniumWebDriver.script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User {
    private WebDriver driver;
    private By button = By.xpath("//button[@id='save']");
    private Wait<WebDriver> wait;

    public User(WebDriver driver) {
        this.driver = driver;
    }

    public User waitForUser() {
        driver.findElement(button).click();
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading']//*")));
        return this;
    }

}
