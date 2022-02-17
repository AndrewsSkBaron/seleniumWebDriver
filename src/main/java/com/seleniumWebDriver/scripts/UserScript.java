package com.seleniumWebDriver.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class UserScript {
    private WebDriver driver;
    private By button = By.xpath("//button[@id='save']");
    private Wait<WebDriver> wait;

    public UserScript(WebDriver driver) {
        this.driver = driver;
    }

    public UserScript clickButton(){
        driver.findElement(button).click();
        return this;
    }
    public UserScript waitForUser(){
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='loading']/*")));
        return this;
    }

    public UserScript scriptWaitForUser(){
        this.clickButton();
        this.waitForUser();
        return new UserScript(driver);
    }

}
