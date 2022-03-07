package com.seleniumWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {
    private WebDriver driver;
    private String button = "//button[@id='save']";
    private String element = "//div[@id='loading']//*";
    private Wait<WebDriver> wait;

    public UserPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement waitForUser() {
        driver.findElement(By.xpath(button)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

}
