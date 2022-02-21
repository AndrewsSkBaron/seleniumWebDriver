package com.seleniumWebDriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    private WebDriver driver;

    private By signInButtonOnHome = By.xpath("//div[@class='HeadBanner-ButtonsWrapper']/a[2]");
    private By loginField = By.xpath("//input[@id='passp-field-login']");
    private By passwordField = By.xpath("//input[@id='passp-field-passwd']");
    private By signInButton = By.xpath(" //button[@id='passp:sign-in']");
    private By logInTitle = By.xpath("//a[contains(@data-count,'{\"name\":\"user\"}')]//span[@class='user-account__name']");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage clickButton(){
        driver.findElement(signInButtonOnHome).click();
        return this;
    }

    public LogInPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(signInButton).click();
        return this;
    }

    public LogInPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).submit();
        return this;
    }

    public String getLogInText(String username){
        WebElement firstResult = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+ username +"']")));
        return firstResult.getText();
    }

    public LogInPage loginWithData(String username, String password){
        this.clickButton();
        this.typeUsername(username);
        this.typePassword(password);
        return new LogInPage(driver);
    }
}