package org.selenim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LogInPage {
    /*Page Object*/
    private WebDriver driver;
    private WebDriverWait wait;

    private By signInButtonOnHome = By.xpath("//div[@class='HeadBanner-ButtonsWrapper']/a[2]");
    private By loginField = By.xpath("//input[@id='passp-field-login']");
    private By passwordField = By.xpath("//input[@id='passp-field-passwd']");
    private By signInButton = By.xpath(" //button[@id='passp:sign-in']");
    private By heading = By.xpath("//h1[contains(@class,'passp-title')]//span");
    private By logInTitle = By.xpath("//span[normalize-space()='LoginTestDriver1']");
    private By errorLogin= By.xpath("//div[@id='field:input-login:hint']");
    private By errorPassword = By.xpath("//div[@id='field:input-passwd:hint']");

    public LogInPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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


    public String getInboxText(){
        return driver.findElement(logInTitle).getText();
    }

    public LogInPage loginWithData(String username, String password){
        this.clickButton();
        this.typeUsername(username);
        this.typePassword(password);
        wait.until(visibilityOfElementLocated(logInTitle));
        return this;
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorLoginText(){
        return driver.findElement(errorLogin).getText();
    }

    public String getErrorPasswordText(){
        return driver.findElement(errorPassword).getText();
    }

}